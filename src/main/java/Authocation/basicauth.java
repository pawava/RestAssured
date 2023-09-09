package Authocation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class basicauth {
    //https://httpbin.org/digest-auth/undefined/vikash/vikash
    @Test
    public void test(){
        RequestSpecification request1= RestAssured.given();
        request1.baseUri("https://httpbin.org");

        request1.basePath("/digest-auth/undefined/vikash/vikash");
        Response response=request1.auth().digest("vikash","vikash").get();
        Assert.assertEquals(response.statusCode()/*actual*/,200);
        System.out.println("ResponseStatus"+response.statusLine());
        System.out.println("Response body"+response.asString());

    }
}
