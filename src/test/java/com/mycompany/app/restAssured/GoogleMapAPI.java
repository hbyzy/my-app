package com.mycompany.app.restAssured;

import com.sun.jna.StringArray;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.poi.ss.formula.functions.T;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;


import java.io.*;
import java.util.*;


import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.config.XmlConfig.xmlConfig;
import static io.restassured.path.json.JsonPath.from;
import static io.restassured.path.json.JsonPath.given;
import static io.restassured.path.json.JsonPath.with;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class GoogleMapAPI {
    private static String host;
    private static String path;

    @BeforeClass
    public  static void setup() {
        Properties prop = GetProperties();
        host = prop.getProperty("google");
        path = prop.getProperty("googlepath");
        RestAssured.baseURI = host;
        RestAssured.basePath = path;
    }

    public static Properties GetProperties() {
        String config = "config.properties";
        ClassLoader cloader = Thread.currentThread().getContextClassLoader();
        Properties prop = new Properties();
        InputStream ins = cloader.getResourceAsStream(config);
        try {
            prop.load(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    @Test
    public void googleMapTest() throws IOException {
        String url = host + "/maps/api/geocode/json?address=Concordia+montreal&key=AIzaSyAdcPpjUUPVlXSsZrgnTzZ_ibmJVo7S8lM";
        ValidatableResponse googleMapJson = given().get(url).then();
        String googleMapStr = googleMapJson.extract().asString();
        File file = new File("d:/googlejason.txt");
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        FileInputStream fi = new FileInputStream(file);
        InputStreamReader ir = new InputStreamReader(fi);
        BufferedReader read = new BufferedReader(ir);
        String str = null;
        String line;
        while ((line = read.readLine()) != null)
            str += line;
        System.out.println(googleMapStr);
        read.close();
        googleMapJson.statusCode(200);
        // googleMapJson.body("results.formatted_address",equalTo("[1455 Boulevard de Maisonneuve O, Montréal, QC H3G 1M8, Canada]"));
        googleMapJson.body("status", equalTo("OK"));
        //System.out.println(Optional.ofNullable(with(googleMapStr).get("results.address_components.short_name")));
        List<String> getShortName = with(file).get("results.address_components.short_name");
        for (String s : getShortName)
            System.out.println("s");
    }

    @Test
    public void googleTestResponse() {
        String url = host + "/maps/api/geocode/json?address=Concordia+montreal&key=AIzaSyAdcPpjUUPVlXSsZrgnTzZ_ibmJVo7S8lM";
        //Response response=get(url);
        Response response = get(url);
        String jsonASString = response.asString();
        System.out.println(jsonASString);
        List<Object> aa = from(jsonASString).getList("results[0].address_components.short_name");
        for (int i = 0; i < aa.size(); i++)
            System.out.println("shortname:" + aa.get(i));
        Map<Object, Object> bb = from(jsonASString).getMap("results[0].address_components[0]");
         for (Object s : bb.keySet()) {
            System.out.println("bb:" + s + "=" + bb.get(s));
        }
        List<Map<String,String>> cc=from(jsonASString).getList("results[0].address_components");
        for (int i=0;i<cc.size();i++){
            Map map=cc.get(i);
            for(Object o:map.keySet())
                System.out.println("cc:"+o+"="+map.get(o));
        }
        String a1=from(jsonASString).getString("results.formatted_address");
        if(a1.equals("[1455 Boulevard de Maisonneuve O, Montréal, QC H3G 1M8, Canada]"))
            System.out.println("a1 equals");
        else
            System.out.println("a1 not equals");

        System.out.println("a1:"+a1);
        JsonPath js = new JsonPath(jsonASString);
        if (response.getStatusCode() == 200) {
            System.out.println(response.getContentType() + ":" + response.getHeaders());
            // String address="[1455 Boulevard de Maisonneuve O, Montréal, QC H3G 1M8, Canada]";
            given().when().get(url).then().body("results[0].formatted_address", equalTo("1455 Boulevard de Maisonneuve O, Montréal, QC H3G 1M8, Canada"));
            System.out.println(response.path("results[0].address_components[0].short_name").toString());
            System.out.println(js.get("results[0].address_components[0].short_name").toString());
            assertEquals("1455 Boulevard de Maisonneuve O, Montréal, QC H3G 1M8, Canada", response.path("results[0].formatted_address"));
            assertEquals("1455 Boulevard de Maisonneuve O, Montréal, QC H3G 1M8, Canada", js.get("results[0].formatted_address"));
            System.out.println(js.get("results.formatted_address").toString());

           js.setRoot("results[0].address_components");
            Map address2 = js.getMap("find{e->e.short_name='Ville-Marie'}");
            System.out.println(address2);
            // assertEquals("Ville-Marie", address2.get("long_name"));
        }
    }
    @Test
    public void testLogin(){

    }
    @Test
    public void googleTestXml() {
        String url = host + "/maps/api/geocode/xml?address=Concordia+montreal&key=AIzaSyAdcPpjUUPVlXSsZrgnTzZ_ibmJVo7S8lM";
        given().config(RestAssured.config().xmlConfig(xmlConfig().with().namespaceAware(true)));
        Response response = get(url);
        //Response response = when().get(url).then().extract().response();
        String jsonASString = response.asString();
        System.out.println(jsonASString);
        if (response.getStatusCode() == 200) {
            System.out.println(response.getContentType() + ":" + response.getHeaders());
            response.then().body("GeocodeResponse.result.formatted_address", equalTo("1455 Boulevard de Maisonneuve O, Montréal, QC H3G 1M8, Canada"));
            response.then().body(hasXPath("/GeocodeResponse/result/address_component/type[text()='street_number']"));
            // response.then().body("**.findAll{it.@long_name=='Ville-Marie'}", hasItem("political"));
            Map<String, String> allCookies = response.getCookies();
            for (String s : allCookies.keySet())
                System.out.println("cookies=" + s + ":" + allCookies.get(s));
        }
    }
}
