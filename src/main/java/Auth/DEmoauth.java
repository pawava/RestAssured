package Auth;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DEmoauth {
   // https://api-m.sandbox.paypal.com/v1/oauth2/token
    @Test
    public void otho(){
        RequestSpecification reqSpec= RestAssured.given();
        reqSpec.baseUri("https://api-m.sandbox.paypal.com");
        reqSpec.basePath("/v1/oauth2/token");



    }
}
