package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dzieciou.testing.curl.CurlLoggingRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class rest {

    static final String url = "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

    @Test
    public void testGet() {
        RestAssured
                .get("http://my-api.com/resource/123")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body("id", equalTo(123));
    }

    @Test
    public void testGet_1() {

        getResponseBody();
        getResponseStatus();

    }

        //This will fetch the response body as is and log it. given and when are optional here
        public static void getResponseBody(){
            given().when().get(url).then().log().all();

            given().queryParam("CUSTOMER_ID","68195")
                    .queryParam("PASSWORD","1234!")
                    .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
        }

        public static void getResponseStatus(){
            int statusCode= given().queryParam("CUSTOMER_ID","68195")
                    .queryParam("PASSWORD","1234!")
                    .queryParam("Account_No","1")
                    .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
            System.out.println("The response status is "+statusCode);

            given().when().get(url).then().assertThat().statusCode(200);
        }


        @Test
    public void testToken() throws IOException {

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
            System.out.println(finalToken[1].replace("\"",""));


 }
 @Test
    public void runcompletebooking() throws IOException {
     String s= Files.readString(Paths.get("C:\\Users\\mukul\\IdeaProjects\\untitled\\src\\test\\java\\test\\data.json"));


     String token=given().body(s)
             .contentType(ContentType.JSON)
             .header("Content-Type", "application/json")
             .when().post("https://restful-booker.herokuapp.com/auth").then().extract().body().asPrettyString();
     System.out.println(token);
     String [] finalToken=token.split(":");
     System.out.println(finalToken[1].replace("\"","").replace("}",""));
     String Token=finalToken[1].replace("\"","").replace("}","");
        given()
                .header("Content-Type", "application/json")
                .header("Cookie","token="+Token.trim())
                .contentType(ContentType.JSON)
                .when().delete("https://restful-booker.herokuapp.com/booking/1").then().log().all();

 }
}
