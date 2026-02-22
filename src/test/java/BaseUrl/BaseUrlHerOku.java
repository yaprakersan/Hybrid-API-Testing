package BaseUrl;

import groovy.transform.BaseScript;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
@BaseScript
public class BaseUrlHerOku {
protected  RequestSpecification specHerOku;
    public void setup(){

    specHerOku = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }
}
