package com.mycompany.app.selenium.page_object.function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public String baseUrl;
    public int timeout=5000;
    public int interval=500;

    public TestBase(){
    String osName= (System.getProperty("os.name"));

    if (osName.equalsIgnoreCase("Mac OS X"))
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
    else   System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");

        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        driver= new ChromeDriver(chromeOptions);
    }

    public void pageLoad(String url){
        baseUrl=url;
        driver.get(baseUrl+"/");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    public  void tearDown() throws Exception{
        driver.quit();
    }
}