import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RATEST2 {
    @Test
    public void test1() {
        Response res = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Response code" + res.getStatusCode());
        System.out.println("Response response Body" + res.getBody().asString());
        System.out.println("Response Time" + res.getTime());
        System.out.println("Response Header" + res.getHeader("content-Type"));


        int expectedstatuscode = 200;
        int Actualstatuscode = res.getStatusCode();
        Assert.assertEquals(expectedstatuscode, Actualstatuscode);

    }


    @Test
    public void test02(){
        //given,when,then
        RestAssured.baseURI="https://reqres.in/api/users";
        RestAssured.given().queryParam("page","2").when().get().then().statusCode(200);
    }
}

