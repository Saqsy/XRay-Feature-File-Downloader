package components;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

import javax.swing.*;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FeatureFileProcessor {

    private File generateZipFromResponse(Response response) {

        File zipFile = new File(RandomStringUtils.randomAlphabetic(10) + ".zip");
        byte[] responseFileStream = response.getBody().asByteArray();
        try (FileOutputStream fileOutputStream = new FileOutputStream(zipFile)) {
            fileOutputStream.write(responseFileStream);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error converting response into zip file");
        }
        return zipFile;
    }

    private void extractFeatureFileFromZip(File zipfile, String testCase) {
        byte[] buffer = new byte[1024];
        try {
            File featureFile = new File(System.getProperty("user.dir") + "\\Output",testCase + ".feature");
            if (!featureFile.getParentFile().exists()){
                featureFile.getParentFile().mkdir();
            }
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipfile));
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(featureFile)) {
                    int len;
                    while ((len = zipInputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                }
                zipEntry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();
            zipInputStream.close();
            zipfile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processFeatureFile(Response response,String testCase) {
        if (response.statusCode() == 200) {
            extractFeatureFileFromZip(generateZipFromResponse(response),testCase);
        }
    }

}
