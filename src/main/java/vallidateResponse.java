import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class vallidateResponse {
    //https://reqres.in/api/users/2
    public static void main(String[]args){

        RequestSpecification res= RestAssured.given();
        //specify base uri
        res.baseUri("https://reqres.in");
        res.basePath("/api/users/2");
        //create get request
        Response res1= res.get();
        //validate response header
       String connection=   res1.header("connection");
       System.out.println("Value of content-type"+connection);
     //read all the response header attribute/keys and print there  values
        Headers headersList= res1.getHeaders();
        // iterate over header List
        for(Header header:headersList){
            System.out.println("Key:"+header.getName()+"Value:"+header.getValue());
            //validate header content-type,expected value:application/jason;chars
            Assert.assertEquals(connection,false);
        }



    }
}
