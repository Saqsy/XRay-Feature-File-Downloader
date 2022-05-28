package components;

import io.restassured.response.Response;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class taskExecutor {

    private final ExecutorService executorService;

    public taskExecutor(int threads) {
        this.executorService = Executors.newFixedThreadPool(threads);
    }

    public void executeDownloadAndProcessingTask(List<String> testCases) {

        try {
            AuthenticationGenerator authenticationGenerator = new AuthenticationGenerator();

            if (authenticationGenerator.getAuthenticationToken() == null) {
                authenticationGenerator.generateBearerToken();
            }

            for (String testCaseId : testCases) {
                executorService.submit(() -> {
                    FeatureDownloader featureDownloader = new FeatureDownloader();
                    FeatureFileProcessor featureFileProcessor = new FeatureFileProcessor();
                    Response response = featureDownloader.getResponse(testCaseId);
                    featureFileProcessor.processFeatureFile(response, testCaseId);
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occurred in downloading files through multi threading.");
        } finally {
            executorService.shutdown();
        }
    }

}
