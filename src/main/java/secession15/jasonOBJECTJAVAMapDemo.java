package secession15;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;//creating jason object

public class jasonOBJECTJAVAMapDemo {
    @Test(enabled = false)
    public void CreateAuthToken() {
        //create JSON object using java
        Map<String, String> authToken = new HashMap<String, String>();
        authToken.put("username", "admin");
        authToken.put("password", "password123");
        Response response = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").contentType(ContentType.JSON)
                .body(authToken).post();
        response.prettyPrint();
        //verify status code
        Assert.assertEquals(response.statusCode(), 200, "Check for the status code");

    }

@Test
    public void createUser(){
        HashMap<String,Object> UserData=new HashMap<String, Object>();
        UserData.put("firstName","Amod");
        UserData.put("lastName","Mahajan");
        UserData.put("age",28);
        UserData.put("salary",5456787.0);
        UserData.put("ismarried",true);

        ArrayList<String> hobbies=new ArrayList<String>();
        hobbies.add("Music");
        hobbies.add("computers");
        hobbies.add("Games");
        UserData.put("Hobbies",hobbies);
        HashMap<String,String> TechSkill=new HashMap<String,String>();
        TechSkill.put("Programming language","Java");
        TechSkill.put("WebAutomation","Selenium");
        TechSkill.put("Api testing","Rest Assured");
        UserData.put("TechSkill",TechSkill);
    Response response = RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON)
            .body(UserData).post();
    response.prettyPrint();
    //verify status code
    Assert.assertEquals(response.statusCode(), 201, "Check for the status code");

}
}

