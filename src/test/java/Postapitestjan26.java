import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.annotations.Test;

public class Postapitestjan26 {

    @Test
    public void validatepostapi()
    {

        String requestbody = "{\n" +
                "  \"name\": \"Shubham\",\n" +
                "  \"job\": \"QA Engineer\"\n" +
                "}";

        Response res = RestAssured.given()
                .baseUri("https://reqres.in/api")
                .header("ContentType","application/json")
                .body(requestbody)
                .when()
                .post("/users");

        res.prettyPrint();

        // status code validation

        Assert.assertEquals(res.getStatusCode(),201);

        // Json data validation

        Assert.assertEquals(res.jsonPath().getString("name"),"Shubham");
        Assert.assertEquals(res.jsonPath().getString("job"),"QA Engineer");

        // Validate generated fields -> id and timestamp

        Assert.assertNotNull(res.jsonPath().getString("id"));
        Assert.assertNotNull(res.jsonPath().getString("createdAt"));

    }
}
