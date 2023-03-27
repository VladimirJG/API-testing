package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    public static RequestSpecification reqSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static ResponseSpecification respSpec200OK(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static void installSpecification(RequestSpecification req,ResponseSpecification resp){
        RestAssured.requestSpecification = req;
        RestAssured.responseSpecification = resp;
    }
}
