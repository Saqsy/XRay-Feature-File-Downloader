package components;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.ArrayList;

import static XRayFeatureFileDownloader.Main.testCases;

public class ExcelProcessor {

    private static final String projectId = new PropertyManager().getProperties("Project_ID");

    public static ArrayList<String> fetchDataFromExcel(File excel){

        try (Workbook wb = WorkbookFactory.create(excel)){
            DataFormatter dataFormatter = new DataFormatter();
            Sheet sheet = wb.getSheetAt(0);
            int rows = sheet.getLastRowNum();
            System.out.println(rows);
            for (int i = 0; i <= rows; i++) {
                String testId = dataFormatter.formatCellValue(sheet.getRow(i).getCell(0)).trim().toUpperCase();
                if (testId.contains(projectId)) {
                    testCases.add(testId);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return testCases;
    }
}
