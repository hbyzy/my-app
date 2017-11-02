package com.mycompany.app.selenium.page_object.page_actions;

import com.mycompany.app.selenium.page_object.Page_Elements.AboutPage;
import org.openqa.selenium.WebDriver;

public class AboutPageAction {
    WebDriver driver;
    AboutPage aboutPage;
    public AboutPageAction(WebDriver rdriver){
        driver=rdriver;
        aboutPage=new AboutPage();
    }
    public void studyHereClick(){
        System.out.println(driver.findElement(aboutPage.studyHere).getText());

        driver.findElement(aboutPage.studyHere).click();

    }
}
