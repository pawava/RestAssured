package Secession18;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class Fileupload {
    @Test
    public void uploadFile(){
        //create file object
        File testfileupload=new File("/home/sudha-admin/Documents/documentvk.odt");

        //create Request specifaction
        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://httpbin.org/post");

        requestSpecification.multiPart("file",testfileupload);
        requestSpecification.contentType("multiplepart/formdata");
       Response response= requestSpecification.post();
       //print response body
        response.prettyPrint();
        //validate statuscode
        Assert.assertEquals(response.statusCode(),200,"Check for status code");
    }
}
//tdftghkjkl