import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class ApiTest2
{
    @Test
    public void getusertest()
    {
    given()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .header("User-Agent", "Mozilla/5.0")
            .when()
            .get("https://reqres.in/api/users/2")
            .then()
            .statusCode(200);

    }
    @Test
    public void addusertest()
    {
        String reqbody = "{\n" +
                "  \"name\": \"Shubham\",\n" +
                "  \"job\": \"QA Automation\"\n" +
                "}";
        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", "Mozilla/5.0")
                .body(reqbody)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name",equalTo("Shubham"))
            .body("job",equalTo("QA Automation"));
    }

}
