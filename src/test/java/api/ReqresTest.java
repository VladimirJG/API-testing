package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest() {
        List<UserData> allUsers = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
    }
}
