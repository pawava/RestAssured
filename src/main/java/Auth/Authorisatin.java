package Auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Authorisatin {
    //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
    @Test
    public void GetWeatherDataByCity(){

        //Create request Specification
        RequestSpecification resSpe= RestAssured.given();
        resSpe.baseUri("ttps://api.openweathermap.org");
        resSpe.basePath("data/2.5/weather");
        resSpe.queryParam("cityName","delhi").queryParam("appid","7f733feb7fccb09b52df28a66f7bf487");
       Response response= resSpe.get();
       //validate status line and response body
        Assert.assertEquals(response.statusCode()/*actual*/,200/*expected*/,"check the validation");
        //print status line and response body
        System.out.println("Response status line:"+response.statusLine());
        System.out.println("Response Body"+response.body().asString());

    }
}
