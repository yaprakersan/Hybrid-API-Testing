package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P03_PutApiTest {


    /*
https://jsonplaceholder.typicode.com/posts/70 url’ine
asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}
donen Response’un,
status code’unun 200,
ve content type’inin application/json; charset=utf-8,
ve Server isimli Header’in degerinin cloudflare,
ve status Line’in HTTP/1.1 200 OK

*/
    @Test
    public void test01(){
        //1.Endpoint Hazırla
        String url="https://jsonplaceholder.typicode.com/posts/70";
        JSONObject reqBody= new  JSONObject();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        //2.🙋‍♀️Expected data (Response) Verilmemiş

        //3.Response değerini kayıt altına alma
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);
        //  anlamı= ContenTypeJSON data türünde bir data verdiğim zaman->bu body(reqBody) -> bu url gönder ve dönen cevabı response içine kayıt et.

        //4.Assertion
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                                                        .statusLine("HTTP/1.1 200 OK").header("Server","cloudflare");

        response.prettyPrint();
        response.prettyPeek();












    }










































}
