import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckValidation {
    @Test
    public void getSingleuser(){
        RestAssured.baseURI="https://reqres.in/api/users/2";
        RequestSpecification requstspec=RestAssured.given();
       Response response= requstspec.get();
       //get response code
       int statusCode= response.statusCode();
       //validate actualstatuscode with expected
        String statusLine= response.statusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 ok","Incorrect statusLine received");



    }
}
