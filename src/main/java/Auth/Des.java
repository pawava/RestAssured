package Auth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Des {
   // public static void main(String[]args){
        @Test
        public void createUser(){
            //create request specificattion
            RequestSpecification req= RestAssured.given();
            req.baseUri("https://reqres.in");
            req.basePath("/api/users");
            //create request body

            JSONObject payload=new JSONObject();
            payload.put("name","vikashkumar");
            payload.put("job","QA");
          //perform post request
            Response response=req.
            contentType(ContentType.JSON).
                    body((payload.toString())).
                    post();
            ResponseBody responseBody=response.getBody();
            SERDES responseClass=responseBody.as( SERDES.class);
            Assert.assertEquals(responseClass.name,"vikashkumar","check for name");
            Assert.assertEquals(responseClass.job,"QA","Check for QA");


        }
    }

