package com.mycompany.app.selenium.page_object.Page_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public By menu_about = By.xpath("//a[@href=\"/about.html\" and @class]");
    public By menu_admissions = By.xpath("//a[@href=\"/admissions.html\" and @class]");
    public By menu_campuslife = By.xpath("//a[@href=\"/campus-life.html\" and @class]");
    public By menu_research = By.xpath("//a[@href=\"/research.html\" and @class]");
    public By menu_international = By.xpath("//a[@href=\"/international.html\" and @class]");


}


