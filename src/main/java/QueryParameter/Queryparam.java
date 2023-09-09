package QueryParameter;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Queryparam {
    //https://reqres.in/api/users/2
    @Test
    public void filterData() {
        // get request specification for the given request
        RequestSpecification resp = RestAssured.given();
        //specify url
        resp.baseUri("https://reqres.in");
        resp.basePath("api/users");
        resp.queryParam("page", 2).queryParam("id",10);

        //perform get request
        Response response = resp.get();
        //read response body
      String responseBodyString=  response.getBody().asString();
      //print response body
      System.out.println("ResponseBody:"+responseBodyString);
      //get jason path view of response body
      JsonPath jsonpathView=response.jsonPath();
      // get first_name
        String firstname=jsonpathView.get("data.first_name");
        Assert.assertEquals(firstname,"Byron","verify t name.");

    }
}
