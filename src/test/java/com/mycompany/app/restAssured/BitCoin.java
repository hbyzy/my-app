
package com.mycompany.app.restAssured;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.poi.util.SystemOutLogger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

public class BitCoin {
    private static String host;

    @BeforeClass
    public static void setup() {
        Properties prop = getProperties();
        host = prop.getProperty("bitcoin.url.min");
        System.out.println(host);
    }

    @Test
    public void pricetest() {
        HashMap<String, String> para = new HashMap<>();
        para.put("BTC", "CAD");
        para.put("ETH", "USD");
        for (String key : para.keySet()) {
            given().log().uri()
                    .when().get(host + "/data/price?fsym={currency}&tsyms={unit}", key, para.get(key))
                    .then().log().body()
                    .statusCode(200)
                    .body("CAD", is(not(equalTo(7971.29))));
        }
    }

    @Test
    public void bitCoinError(){
        HashMap<String, String> currencyPair = new HashMap<>();
        currencyPair.put("BTc", "CAD");
        currencyPair.put("eth", "USD");

       for (String key:currencyPair.keySet()){
           given().log().uri()
                   .when().get(host+"/data/price?fsym={currency}&tsyms={unit}",key,currencyPair.get(key))
                   .then().log().body().statusCode(200)
                   .body("Response", equalTo("Error")).
                   body("Message", equalTo("There is no data for the symbol " + key + " ."));
       }
    }

    @Test
    public void getjason() {
        ValidatableResponse jason = given().log().uri().when().get(host + "/data/price?fsym=eTH&tsyms=CAD").then();
        System.out.println(jason);
        jason.body("Response",equalTo("Error"));
        System.out.println(jason.body("Message",equalTo("There is no data for the symbol eTH .")));

        String jasonstr=jason.extract().asString();

        System.out.println(jasonstr);
        System.out.println("body:"+jason.extract().body());
        System.out.println("status code:" + jason.extract().statusCode());
        System.out.println("content type:" + jason.extract().contentType());
        System.out.println("session id:" + jason.extract().sessionId());
        System.out.println("status line:" + jason.extract().statusLine());
        System.out.println("cookies:" + jason.extract().cookies());
        System.out.println("headers:" + jason.extract().headers());
        System.out.println("response:" + jason.extract().response());
        System.out.println("time:" + jason.extract().time());
    }
    @Test
    public void otherWayConfig(){
        RestAssured.baseURI="https://min-api.cryptocompare.com";
        RestAssured.port=80;
        RestAssured.basePath="/data/price?fsym=ETH&tsyms=CAD";
        RestAssured.registerParser("application/json", Parser.JSON);
        ValidatableResponse jason = given().when().get().then();
        System.out.println(jason);
        jason.body("Response",equalTo("Error"));
        System.out.println(jason.body("Message",equalTo("There is no data for the symbol eTH .")));


    }

    public static Properties getProperties() {
        //load properties from the config file
        String resourceName = "config.properties"; // could also be a constant
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties prop = new Properties();
        try {
            InputStream resourceStream = loader.getResourceAsStream(resourceName);
            prop.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
