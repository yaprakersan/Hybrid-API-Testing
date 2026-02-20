package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P04_ResponseBodyTest {

    /*
        https://jsonplaceholder.typicode.com/posts url’ine
        asagidaki body ile bir POST request gonderdigimizde
            {
            “title”:“API”,
            “body”:“API ogrenmek ne guzel”,
            “userId”:10,
            }

        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body’sindeki,
            “title”’in “API” oldugunu
            “userId” degerinin 100’den kucuk oldugunu
            “body” nin “API” kelimesi icerdigini
        test edin.

    */


@Test
    public void test02(){
    String url=" https://jsonplaceholder.typicode.com/posts";
    JSONObject reqBody= new JSONObject();
    reqBody.put("title", "API");
    reqBody.put("userId",99);
    reqBody.put("body","API learn");

    Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
    response.then().assertThat().statusCode(201).contentType("application/json")
                                                    .body("title", equalTo("API"))
                                                    .body("body", containsString("API"))
                                                    .body("userId", Matchers.lessThan(100)); //yuakarıda * koyduk artık Matchers kullanmamaıza gerek yok örnek olarak kalması için




    }

























}
