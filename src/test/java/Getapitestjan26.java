import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.Assert;


public class Getapitestjan26 {

    @Test
    public void validategetapi()
    {
        Response res = RestAssured.given()
                .baseUri("https://reqres.in/api")
                .when()
                .get("/users?page=2");

        // status code validations
        Assert.assertEquals(res.getStatusCode(),200);

        // JSON validations
        Assert.assertEquals(res.jsonPath().getInt("page"),2);

        // validate  data list is not empty
        Assert.assertTrue(res.jsonPath().getList("data").size()>0);

        // validate first users email

        String email = res.jsonPath().getString("data[0].email");

        // validate email
        Assert.assertTrue(email.contains("@reqres.in"));

    }
}
