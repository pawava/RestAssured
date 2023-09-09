
import io.restassured.RestAssured;

import io.restassured.response.Response;

import org.testng.annotations.Test;

public class MYFirstTes {
    @Test
    void testcase1(){
       Response res= RestAssured.get("https://reqres.in/api/users/2");
       System.out.println(res.asString());
       System.out.println("Status code"+res.getStatusCode());

    }


    }


