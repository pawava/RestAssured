import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test5 {
    //https://reqres.in/api/users/2
    @Test
    public void GetSingleUser(){
        //get  request specification
        RequestSpecification req= RestAssured.given();
//specify base uri
        req.baseUri("https://reqres.in");
        req.basePath("/api/users/2");
        //create get request
      Response response= req.get();

      //validate response header
     String ContentType= response.getHeader("Content-Type");
     System.out.println("Value of content type"+ContentType);

     //read all the response header and attributes/key and print there values
        Headers headersList=response.getHeaders();
        //iterate over header list
        for(Header header:headersList){
            System.out.println(header.getName()+":"+header.getValue());
            Assert.assertEquals(ContentType,"application/json; charset=utf-8","Header content missmatch");
        }

    }
}
