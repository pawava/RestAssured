package Auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DemoOth {
    @Test
    public void Outh2Demo(){
        String clientId="";
        String clientScret="";
        RequestSpecification resSpe= RestAssured.given();
        resSpe.baseUri("https://api-m.sandbox.paypal.com");
        resSpe.basePath("/v1/oauth2/token");
        //Basic authorisation
     // Response response=   resSpe.auth().preemptive().basic(clientId,clientScret).param("grant_type","client_crendentials").response(



    }
}
