
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class ApiFullValidationTest {

    @Test
    public void validateRequest()
    {
        given()
                //.header("Content-Type","application/json")
                .when()
                .get("https://reqres.in/api/users")
                .then()
                //validate status code
                .statusCode(200)
                //  validate header
                .header("Content-Type","application/json; charset=utf-8")
                // validate response time
                .time(lessThan(2000L))
                //schema validation
                .body(matchesJsonSchemaInClasspath("schemas/getUserSchema.json"))
                //body validation
                .body("data.id", equalTo(2))
                .body("data.email", containsString("@"))
                .body("data.first_name",notNullValue());






    }
}
