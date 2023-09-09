package Secession19;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OwnApiTesting {
    @Test
    public void readUserData() {


        RequestSpecification requestSpec = RestAssured.given();
        //specify URL
        requestSpec.baseUri("http://localhost:3000");
                requestSpec.basePath("/users");
                //perform get request
        Response response=requestSpec.get();
        //print response body
        response.prettyPrint();
        //validate status code
        Assert.assertEquals(response.statusCode(),200,"Check status code");
    }
}
