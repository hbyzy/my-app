package com.mycompany.app.selenium.page_object.Page_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage {
    WebDriver driver;


    public By menu_about = By.xpath("//a[@href=\"/about.html\" and @class]");
    public By menu_admissions = By.xpath("//a[@href=\"/admissions.html\" and @class]");
    public By menu_campuslife = By.xpath("//a[@href=\"/campus-life.html\" and @class]");
    public By menu_research = By.xpath("//a[@href=\"/research.html\" and @class]");
    public By menu_international = By.xpath("//a[@href=\"/international.html\" and @class]");

    public By sub_About_1 = By.linkText("Administration & governance");
    public By sub_About_2 = By.linkText("Strategic directions");
    public By sub_Adimissions_1 = By.linkText("Undergraduate programs");
    public By sub_Adimissions_2 = By.linkText("Graduate programs");

    public String aboutCss="ul.nav:nth-child(2) > li:nth-child(1)";
    public String admissionsCss="ul.nav:nth-child(2) > li:nth-child(2)";
    public String campuslifeCss="ul.nav:nth-child(2) > li:nth-child(3)";
    public String researchCss="ul.nav:nth-child(2) > li:nth-child(4)";
    public String InternationalCss="ul.nav:nth-child(2) > li:nth-child(5)";

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
    }

    public String[] subMenu(By topMenu,String topCSS) throws InterruptedException {
        WebElement aboutMenu;
        String[] subMenu;
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(topMenu)).perform();
        System.out.println("top menu="+driver.findElement((topMenu)).getText());

        aboutMenu = driver.findElement(By.cssSelector(topCSS));
        List<WebElement> subMenuAbout = aboutMenu.findElements(By.xpath(".//a[@tabindex='-1']"));
        subMenu=new String[subMenuAbout.size()];
        for (int i = 0; i < subMenuAbout.size(); i++) {
            subMenu[i] = subMenuAbout.get(i).getText();
            System.out.println("inside menu "+i+" "+subMenu[i]);
        }
        return subMenu;
    }

}


