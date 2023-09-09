package QueryParameter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Auth {
    @Test
    public void BaseURI() {


        RequestSpecification res = RestAssured.given();
        //specify URL
        res.baseUri("https://postman-echo.com");
        res.basePath("/basic-auth");
        //Perform get request
        Response response = res.auth().basic("postman","postman").get();
        //print status Line+
        System.out.println("Response Status"+response.statusLine());
        System.out.println("Response body"+response.body().asString());

    }
}
