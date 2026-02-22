package tests;

import BaseUrl.BaseUrlJsonPlace;
import TestData.PostPojo;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P11_Deserialization extends BaseUrlJsonPlace {
/*

        https://jsonplaceholder.typicode.com/posts/70 url'ine

        asagidaki body'e sahip bir PUT request yolladigimizda

        donen response'in response body'sinin

        asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {

        "title": "Ahmet",

        "body": "Merhaba",

        "userId": 10,

        "id": 70

        }

        Expected Data :

        {

        "title": "Ahmet",

        "body": "Merhaba",

        "userId": 10,

        "id": 70

        }


*/


@Test
    public void test09(){
    JSONObject requestBody = new JSONObject();

    requestBody.put("title", "Ahmet");
    requestBody.put("body", "Merhaba");
    requestBody.put("userId", 10);
    requestBody.put("id", 70);

    Response response = given()
            .spec(specJsonPlace)
            .contentType("application/json") // JSON gönderiyoruz
            .body(requestBody.toString())     // Body gönderiyoruz
            .when()
            .put("/posts/70");

    PostPojo actualData = response.as(PostPojo.class);
    PostPojo expectedData = new PostPojo();
    expectedData.setTitle("Ahmet");
    expectedData.setBody("Merhaba");
    expectedData.setUserId(10);
    expectedData.setId(70);
    assertEquals(expectedData.getTitle(), actualData.getTitle());
    assertEquals(expectedData.getBody(), actualData.getBody());
    assertEquals(expectedData.getUserId(), actualData.getUserId());
    assertEquals(expectedData.getId(), actualData.getId());
}




}
