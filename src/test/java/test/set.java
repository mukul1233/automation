package test;

import io.restassured.http.ContentType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class set {

   public String generateToken() throws IOException {
       String s= Files.readString(Paths.get("C:\\Users\\mukul\\IdeaProjects\\untitled\\src\\test\\java\\test\\data.json"));

       System.out.println(s);
       given().body(s)
               .contentType(ContentType.JSON)
               .header("Content-Type", "application/json")
               .when().post("https://restful-booker.herokuapp.com/auth");

       String token=given().body(s)
               .contentType(ContentType.JSON)
               .header("Content-Type", "application/json")
               .when().post("https://restful-booker.herokuapp.com/auth").then().extract().body().asPrettyString();
       String [] finalToken=token.split(":");
       return (finalToken[1].replace("\"",""));
   }
}
