
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostMethod {
    @Test
    public void test03(){
        JSONObject object= new JSONObject();
        object.put("name","prachi");
        object.put("job","QA");
        RestAssured.baseURI="https://reqres.in/api/users";
        RestAssured.given().header("Content-type","application/json").
                contentType(ContentType.JSON).
                body(object.toString()).
                when().post().then().statusCode(201);




    }
}
