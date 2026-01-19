

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class ApiTest {

    @Test
    public void getusertest()
    {
        given()
                .when()
                .get("https://reqres.in/api/users/2   ")
                .then()
                .statusCode(200);

        String reqBody = "{\n" +
                "  \"name\": \"Shubham\",\n" +
                "  \"job\": \"QA Automation\"\n" +
                "}";
        given()
                .header("Content-Type","application/json")
                .body(reqBody)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);

    }


}
