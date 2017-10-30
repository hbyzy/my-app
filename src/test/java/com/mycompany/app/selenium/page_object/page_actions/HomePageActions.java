package com.mycompany.app.selenium.page_object.page_actions;

import com.mycompany.app.selenium.page_object.Page_Elements.HomePage;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

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

}

