package Steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class APISteps {
    private static RequestSpecification request;
    private static ResponseSpecification response;

    @Given("I send a GET request to the endpoint")
    public void sendGETRequest(){
        request = given()
                .baseUri("https://pokeapi.co/api/v2/")
                .contentType(ContentType.JSON);
    }

     @Then("I get a list of (\\d+) users")
     public void getListOfUsers(int expectedUserSize){
         response = (ResponseSpecification) request
                 .when()
                 .get("pokemon/ditto");
     }

}
