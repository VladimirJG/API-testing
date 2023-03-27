package api;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void getAllUsers() {
        List<UserData> allUsers = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
    }

    @Test
    public void getAllAvatar() {
        List<UserData> allUsers = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        allUsers.stream().map(UserData::getAvatar).forEach(System.out::println);
    }

}
