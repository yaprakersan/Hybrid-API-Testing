package BaseUrl;

import groovy.transform.BaseScript;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
@BaseScript
public class BaseUrlJsonPlace {

    protected RequestSpecification specJsonPlace;

    public  void setup(){
        specJsonPlace=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }
}
