package com.mycompany.app.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test_Kijiji {
    WebDriver driver;

    @Before
    public void startup() {
        String os = System.getProperty("os.name");
        if (os.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        else
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        driver = new ChromeDriver(chromeOptions);
        String BaseUrl = "http://www.kijiji.ca";
        driver.get(BaseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void kijijiTest(){
        System.out.println(driver.getCurrentUrl());
        String currentLoction=driver.findElement(By.cssSelector("#SearchLocationPicker")).getAttribute("value");
        String Title="Kijiji in "+currentLoction+". - Buy, Sell & Save with Canada's #1 Local Classifieds.";
        assertEquals(Title,driver.getTitle());
//itemContainer-1385798859   ul class="itemContainer-1385798859"
        WebElement serchKey=driver.findElement(By.cssSelector("#SearchKeyword"));
        serchKey.sendKeys("free");
        WebElement sk=driver.findElement(By.xpath("ul[@class='itemContainer-1385798859'"));
       // List<String> skList=sk.findElements()
    }

    /*@Test
            print out current system properties;
    public void systermProperties(){
        Properties props = System.getProperties();

        //We want to loop through the entrys using the Keyset
        Set<Object> propKeySet = props.keySet();

        for (Object singleKey : propKeySet) {
            System.out.println(singleKey += props.getProperty((String) singleKey));
        }
    }*/
@After
    public void tearDown(){
    driver.close();
    driver.quit();
}
}
