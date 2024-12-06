package api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import org.testng.annotations.Test;

public class TestRegresIn {

    @Test
    public void getListUser(){
        baseURI = "https://reqres.in/api";
        given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name",equalTo("George"))
                .body("data.first_name",hasItems("George","Rachel"));
    }

    @Test
    public void testPost(){
        JsonObject request =new JsonObject();
        request.add("name","Sam");

        baseURI = "https://reqres.in/api";
        given()
                .get("/users?page=2")
                .body();


    }


}
