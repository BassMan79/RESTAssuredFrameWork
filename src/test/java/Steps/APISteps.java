package Steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class APISteps {
    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("^I send a GET request to the (.+) URI$")
    public void sendGETRequest(String URI){
        request = given()
                .baseUri(URI)
                .contentType(ContentType.JSON);
    }

     @Then("^I get a (\\d+) status code$")
     public void getListOfUsers(int expectedStatusCode){
         response = request
                 .when()
                 .get("/users/BassMan79/repos");

                json = response.then().statusCode(expectedStatusCode);
     }

    @Then("^I validate there are (\\d+) items (.+) endpoint$")
    public void validateSize(int expectedSize, String endpoint){
        response = request
                .when()
                .get(endpoint);

        List<String> jsonResponse = response.jsonPath().getList("$");
        int actualSize = jsonResponse.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

}
