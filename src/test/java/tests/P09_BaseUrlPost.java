package tests;

import BaseUrl.BaseUrlHerOku;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P09_BaseUrlPost extends BaseUrlHerOku {

    /*
    {
    "firstname" : "Murat",
    "lastname" : "Yigit",
    "totalprice" : 500,
    "depositpaid" : false,
    "bookingdates" : {
        "checkin" : "2025-06-01",
        "checkout" : "2025-06-10"
        },
    "additionalneeds" : "wi-fi" }

donen response'un
    status code'unun 200 oldugunu
    ve "firstname" degerinin "Murat" oldugunu test edin

     */


        @Test
        public void test(){

            specHerOku.pathParam("pp1",  "booking");

            JSONObject innerData=new JSONObject();

            innerData.put( "checkin" , "2025-06-01");

            innerData.put( "checkout" , "2025-06-10");

            JSONObject reqBody=new JSONObject();

            reqBody.put("firstname","Murat");

            reqBody.put("lastname","Yigit");

            reqBody.put("totalprice",500);

            reqBody.put("depositpaid",true);

            reqBody.put("additionalneeds","wi-fi");

            reqBody.put("bookingdates",innerData);

            Response response=given().contentType(ContentType.JSON).spec(specHerOku).when().body(reqBody.toString()).post( "/{pp1}");
            response.then().assertThat().statusCode(200).body("firstname", Matchers.equalTo( "Murat"));
        }



}
