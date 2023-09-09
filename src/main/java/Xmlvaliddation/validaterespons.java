package Xmlvaliddation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;


public class validaterespons {
    @Test
    public void AddPet(){
        String jasonData="{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        //create request specification
        RequestSpecification requestSpe= RestAssured.given();
        //specify url
        requestSpe.baseUri("https://petstore.swagger.io");
        requestSpe.basePath("/v2/pet");
        requestSpe.header("accept","application/xml");
        requestSpe.header("content-Type","application/json");
        requestSpe.body(jasonData);
        Response response=requestSpe.post();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode()/*actual status code*/,200,"Check for status code");

    }
}
