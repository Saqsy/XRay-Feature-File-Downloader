/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**
 *
 * @author Saqsy
 */
public class FeatureDownloader extends AuthenticationGenerator {

    private Response response = null;

    protected Response getResponse(String testCaseId) {
        return retrieveFeatureNetworkCall(testCaseId);
    }

    private Response retrieveFeatureNetworkCall(String testCaseId){
        
        RequestSpecification httpRequest;

        httpRequest = RestAssured.given();

            String endpoint = "https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=" + testCaseId;
            response = httpRequest.headers("Authorization", getAuthenticationToken(), "Content-Type",
                    ContentType.JSON).get(endpoint);
        return response;
    }
}
