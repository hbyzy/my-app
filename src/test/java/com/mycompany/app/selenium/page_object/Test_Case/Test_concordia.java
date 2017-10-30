package com.mycompany.app.selenium.page_object.Test_Case;

import com.mycompany.app.selenium.page_object.Page_Elements.HomePage;
import com.mycompany.app.selenium.page_object.assess.HomePageAsser;
import com.mycompany.app.selenium.page_object.page_actions.HomePageActions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Test_concordia extends TestBase {
    WebDriver driver;


    @Before
    public void setup() {
        driver=super.driver;
        super.pageLoad();
    }

    @Test
    public void testAbout() throws Exception {
        HomePageActions homePageAction= new HomePageActions(driver);
        HomePageAsser homePageAsser= new HomePageAsser((driver));

        homePageAction.mAboutClick();
        homePageAsser.PageChangeAssert("About");
    }
    @Test
    public void testAdmission() throws Exception {
        HomePageActions homePageAction= new HomePageActions(driver);
        HomePageAsser  homePageAsser= new HomePageAsser(driver);

        homePageAction.mAdmissionsClick();
        homePageAsser.PageChangeAssert("Admission");
    }
    @Test
    public void testCampusLife() throws Exception {
        HomePageActions homePageAction= new HomePageActions(driver);
        HomePageAsser  homePageAsser= new HomePageAsser(driver);

        homePageAction.mCampusLifeClick();
        homePageAsser.PageChangeAssert("Campus-life");

    }
    @Test
    public void testResearch() throws Exception {
        HomePageActions homePageAction= new HomePageActions(driver);
        HomePageAsser  homePageAsser= new HomePageAsser(driver);

        homePageAction.mResearchClick();
        homePageAsser.PageChangeAssert("Research");

    }
    @Test
    public void testInternational() throws Exception {
        HomePageActions homePageAction= new HomePageActions(driver);
        HomePageAsser  homePageAsser= new HomePageAsser(driver);

        homePageAction.mInternationalClick();
        homePageAsser.PageChangeAssert("International");

    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();

    }
}