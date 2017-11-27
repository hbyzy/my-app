package com.mycompany.app.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

import static io.restassured.path.xml.XmlPath.given;

public class CouchDBRest {
    @Test
    public void postExample()
    {
        String myJson = "{\"name\":\"Jimi Hendrix\"}";
        RestAssured.baseURI  = "http://127.0.0.1:5984/restassured";
        System.out.println("https://www.joecolantonio.com/2014/04/24/rest-assured-how-to-post-a-json-request/");
        Response r = given()
                .contentType("application/json").
                        body("{\"name\":\"Jimi Hendrix\"}").
                        when().
                        post("");

        String body = r.getBody().asString();
        System.out.println(body);

    }
}
