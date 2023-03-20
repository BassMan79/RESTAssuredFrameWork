package Steps;

import static io.restassured.RestAssured.given;

public class APIBase {

    public void getRequest(){
        given().baseUri("https://api.github.com").when().get("users/BassMan79/repositories").statusCode();
    }

    public void postRequest(){
        given().baseUri("https://api.github.com").when().post("","");
    }
}
