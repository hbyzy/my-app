package com.mycompany.app.selenium.page_object.page_actions;

import com.mycompany.app.selenium.page_object.Page_Elements.HomePage;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePageActions {
    WebDriver driver;

    public HomePageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void mAboutClick() {
        HomePage homePage = new HomePage(driver);

        driver.findElement(homePage.menu_about).click();
    }

    public void mAdmissionsClick() {
        HomePage homePage = new HomePage(driver);

        driver.findElement(homePage.menu_admissions).click();
    }

    public void mCampusLifeClick() {
        HomePage homePage = new HomePage(driver);

        driver.findElement(homePage.menu_campuslife).click();
    }

    public void mResearchClick() {
        HomePage homePage = new HomePage(driver);

        driver.findElement(homePage.menu_research).click();
    }

    public void mInternationalClick() {
        HomePage homePage = new HomePage(driver);

        driver.findElement(homePage.menu_international).click();
    }

    public void hovermenu(By rBy, String menuCss) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement wm = driver.findElement(rBy);
        actions.moveToElement(wm).perform();

        WebElement ws = driver.findElement(By.linkText(menuCss));

        actions.moveToElement(ws);
        actions.click().build().perform();
        System.out.println("hover:" + driver.getTitle());

    }

    public void pageBack() {
        driver.navigate().back();
    }

}

