package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P06_JsonPad {

    /*
    https://restful-booker.herokuapp.com/booking url'ine asagidaki body'ye sahip bir POST request gonderdigimizde

    {
        "firstname" : "Ahmet",
        "lastname" : "Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
             "checkin" : "2021-06-01",
             "checkout" : "2021-06-10"
        },
        "additionalneeds" : "wi-fi"
    }

    donen Response'un,
    status code'unun 200,
    ve content type'inin application/json,
    ve response body'sindeki
      "firstname"in "Ahmet",
      "lastname"in "Bulut",
      "totalprice"in 500,
      "depositpaid"in false,
      "checkin" tarihinin 2021-06-01,
      "checkout" tarihinin 2021-06-10,
      "additionalneeds"in "wi-fi"
    oldugunu test edin.
    */


    @Test
    public void test() {
        // 1. ADIM: Adresi Tanımlama
        // API'nin kapı numarası gibi düşün.
        String url = "https://restful-booker.herokuapp.com/booking";

        // 2. ADIM: İç Paketi (Tarihler) Hazırlama
        // Neden? Çünkü otel sistemi giriş-çıkış tarihlerini ayrı bir grup olarak istiyor.
        JSONObject innerData = new JSONObject();
        innerData.put("checkin", "2025-06-01");
        innerData.put("checkout", "2025-06-10");

        // 3. ADIM: Dış Paketi (Ana Form) Hazırlama
        // Neden? Müşterinin tüm bilgilerini bu ana kutuda topluyoruz.
        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Murat");
        reqBody.put("lastname", "Yiğit");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", true);
        reqBody.put("additionalneeds", "wi-fi");

        // DİKKAT: Az önce hazırladığımız tarih kutusunu (innerData) bu ana kutunun içine yerleştirdik.
        // "Kutu içinde kutu" yapısı burada kuruldu.
        reqBody.put("bookingdates", innerData);

        // 4. ADIM: İsteği Gönderme
        // given() -> Hazırlıklarım şunlar:
        // when()  -> Şu eylemi yaptığımda:
        Response response = given()
                .contentType(ContentType.JSON) // API'ye "Sana JSON formatında bir kutu yolluyorum" dedik.
                .when()
                .body(reqBody.toString())      // Kutumuzu yazıya döküp içine koyduk.
                .post(url);                    // "POST" komutuyla bu adrese "Kaydet" dedik.

        // 5. ADIM: Kontrol Etme
        // response.then() -> "Gelen cevabı al ve şimdi şunlara bak"
/*        response.then().assertThat()
                .statusCode(200) // Kontrol 1: Kapıdaki görevli "Tamam" (200) dedi mi?
                .contentType("application/json") // Kontrol 2: Gelen makbuz JSON tipinde mi?

                // Kontrol 3: Body (İçerik) Kontrolleri
                // .body("YOL", equalTo("BEKLENEN"))
                // Virgüller: "Ve ayrıca şuna da bak" demektir.
                .body("booking.firstname", equalTo("Murat"), // "booking kutusunu aç, isme bak"
                        "booking.lastname", equalTo("Yiğit"),
                        "booking.totalprice", equalTo(500),
                        "booking.depositpaid", equalTo(true),

                        // "booking kutusunu aç -> içindeki bookingdates odasına gir -> checkin'e bak"
                        // İşte noktalar bu hiyerarşiyi (alt klasöre inmeyi) sağlar.
                        "booking.bookingdates.checkin", equalTo("2025-06-01"),
                        "booking.bookingdates.checkout", equalTo("2025-06-10"),

                        // Bu veriler bazen doğrudan booking içinde olmayabilir, API'ye göre yolu değişir.
                        "booking.additionalneeds", equalTo("wi-fi"));*/

// --- Önceki Adımlar (Endpoint ve Payload) Aynı Kalıyor ---

// 1. ADIM: Cevabı "Sorgulanabilir" Bir Rehbere Çevir
// API'den gelen karışık yazıları (response), 'cımbızla veri çekebileceğimiz' bir objeye (resJP) dönüştürüyoruz.
        JsonPath resJP = response.jsonPath();

// 2. ADIM: Masaya Eşyaları Diz (Verileri Değişkenlere Al)
// "Git koliye, booking'in içindeki totalprice'ı bul ve onu 'fiyat' diye bir kutuya koy."

// 3. ADIM: Elindeki Listeyle Karşılaştır (Assertion)
// assertEquals( BEKLENEN , GERÇEK_OLAN )

// "Ben 200 bekliyorum, bakalım kapıdaki görevli (response) ne diyor?"
        assertEquals(200, response.getStatusCode());

// "Ben Murat bekliyorum, bakalım koliden (resJP) ne çıktı?"
        assertEquals("Murat", resJP.get("booking.firstname"));

// "Ben Yiğit bekliyorum..."
        assertEquals("Yiğit", resJP.get("booking.lastname"));

// "Ben az önce çektiğim 'fiyat' kutusunun 500 olmasını bekliyorum."
        assertEquals(500, resJP.getInt("booking.totalprice"));

// "Ben tarihin 2025-06-01 olmasını bekliyorum."
        assertEquals("2025-06-01", resJP.get("booking.bookingdates.checkin"));
    }


    }









