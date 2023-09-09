import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class secision6 {
//https://reqres.in/api/users/2

       @Test
        public void UserListResponseBody(){
           RequestSpecification reqsp= RestAssured.given();
           //specify base URI
           reqsp.baseUri("https://reqres.in");
           reqsp.basePath("api/users/2");
           //create get request
          Response response= reqsp.get();
          // read response body
          ResponseBody responseBody= response.body();
         String responseString= responseBody.asString();
         //print response body
         System.out.println("Response body"+responseString);
         // check for presence of George in response body
           //Assert.assertEquals(responseString.contains("George"),true,"Check for presence of George");
           //get jason path view of response body
           //

          JsonPath jasonpathview= responseBody.jsonPath();
          String firstName=jasonpathview.get("data[0].fistName");
          System.out.println("email address"+jasonpathview.get("data[1].avtar"));
          Assert.assertEquals(firstName,"George","Check for presence of George");


        }
    }

