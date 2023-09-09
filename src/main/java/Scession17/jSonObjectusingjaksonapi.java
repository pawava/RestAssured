package Scession17;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

import java.util.Iterator;

public class jSonObjectusingjaksonapi {
    @Test
    public void CreatUser() {
        //https://reqres.in/api/users
        //Create Object Mapper class instance
        ObjectMapper objectMapper = new ObjectMapper();
        //create object node that is jason node
        ObjectNode userDetails = objectMapper.createObjectNode();
        userDetails.put("firstName", "Prerna");
        userDetails.put("lastName", "Gupta");
        userDetails.put("age", 28);
        userDetails.put("Salary", 4657688909.6);
        userDetails.put("IsMarried", false);
        ObjectNode TechSkill = objectMapper.createObjectNode();
        TechSkill.put("Programming language", "Java");
        TechSkill.put("WebAutomation", "Selenium");
        TechSkill.put("Api testing", "Rest Assured");
        userDetails.set("TechSkill", TechSkill);
        //print UserDetails Json Object
        try {
            String UesrDetailsIsAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
            System.out.println("Created jason Node" + UesrDetailsIsAsString);

        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        //Retrive field value
        String firstName = userDetails.get("firstName").asText();
        System.out.println("Value of firstname field is" + firstName);

        Boolean ISMarried = userDetails.get("isMarried").asBoolean();
        System.out.println("Value of firstname field is"+ ISMarried);
        //retried field value webautomation
       String WebAutomation= userDetails.get("TechSkill").get("webautomation").asText();
        System.out.println("Value of Field automation is "+WebAutomation);
        Iterator<String> fieldnameIterator=userDetails.fieldNames();
        while (fieldnameIterator.hasNext()){
          System.out.println(  fieldnameIterator.next());
          Iterator<JsonNode> fieldvalueterator= userDetails.elements();
          while (fieldvalueterator.hasNext()){
              System.out.println(fieldnameIterator.next());
          }
        }
    }
}
