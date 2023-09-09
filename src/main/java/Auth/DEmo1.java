package Auth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DEmo1 {

        // https://api-m.sandbox.paypal.com/v1/oauth2/token
    //https://gorest.co.in/public/v2/users
        @Test
        public void otho(){
            RequestSpecification res= RestAssured.given();
            res.baseUri("https://gorest.co.in");
            res.basePath("/public/v2/users");
            JSONObject payload=new JSONObject();
            payload.put("name","vikashkumar");
            payload.put("gender","male");
            payload.put("email","vikas@gmail.com");
            payload.put("status","Active");
            String AUthToken="Bearer 0b1e5bbaa61b666abb397994e345f1a6b1a3d20db261d6ffbba596067b632ba7";
            res.headers("Authorisation",AUthToken).contentType(ContentType.JSON);
        Response response= res.post();
            Assert.assertEquals(response.statusCode()/*actual*/,200,"Check status code");
            System.out.println("Digest Auth Response status"+response.statusLine());
            System.out.println("Digest Auth Response status"+response.body().asString());


        }
}
