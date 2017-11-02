package com.mycompany.app.selenium.page_object.Test_Case;

import com.mycompany.app.selenium.page_object.assess.HomePageAsser;
import com.mycompany.app.selenium.page_object.function.TestBase;
import com.mycompany.app.selenium.page_object.function.pagescroll;
import com.mycompany.app.selenium.page_object.page_actions.AboutPageAction;
import com.mycompany.app.selenium.page_object.page_actions.HomePageActions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.WeakHashMap;

public class test_aboutPage extends TestBase{
    WebDriver driver;
    AboutPageAction aboutPageAction;
    HomePageAsser homePageAsser;
    pagescroll  pageScroll;
    @Before
    public void setup(){
        driver=super.driver;
        super.pageLoad("http://www.concordia.ca/about.html");
        aboutPageAction= new AboutPageAction(driver);
        homePageAsser=new HomePageAsser(driver);
    }

    @Test
    public void studyHereButton() throws InterruptedException {
        //pageScroll.rollup();
        aboutPageAction.studyHereClick();
        homePageAsser.PageChangeAssert("Admissions");
    }

    @After
    public void teardown() throws Exception {
        super.tearDown();
    }
}
