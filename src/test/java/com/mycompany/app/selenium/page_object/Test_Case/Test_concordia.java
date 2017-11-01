package com.mycompany.app.selenium.page_object.Test_Case;

import com.mycompany.app.selenium.page_object.Page_Elements.HomePage;
import com.mycompany.app.selenium.page_object.assess.HomePageAsser;
import com.mycompany.app.selenium.page_object.page_actions.HomePageActions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test_concordia extends TestBase {
    WebDriver driver;
    public Boolean result = false;
    List<String> handles;
    public ArrayList fileStr = new ArrayList();
    String begin = "------------------------------";

    @Before
    public void setup() {
        driver = super.driver;
        super.pageLoad();
        fileOperate fileOperate = new fileOperate();
        try {
            fileOperate.filePrepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void aboutSubMenuTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        HomePageActions homePageAction = new HomePageActions(driver);
        HomePageAsser homePageAsser = new HomePageAsser(driver);
        String[] subMenu;
        String subPageName;
        subMenu = homePage.subMenu(homePage.menu_about, homePage.aboutCss);
        for (int i = 0; i < subMenu.length; i++) {
            fileStr.add(begin);
            fileStr.add("About menu " + subMenu[i] + " test begain");
            homePageAction.hovermenu(homePage.menu_about, subMenu[i]);
            subPageName = subMenu[i];
            if (subPageName.equals("Offices A-Z"))
                subPageName = "Offices";
            result = homePageAsser.PageChangeAssert(subPageName);
            if (result) {
                fileStr.add("test step1: change to new page " + subMenu[i] + " success");
                String currenthandle = driver.getWindowHandle();
                Set<String> handles = driver.getWindowHandles();
                if (handles.size() > 1) {
                    for (String h : handles) {
                        if (!h.equals(currenthandle)) {
                            driver.close();
                            driver.switchTo().window(h);
                            fileStr.add("close current window and go back to homepage");
                            break;
                        }
                    }
                } else {
                    homePageAction.pageBack();
                    if (homePageAsser.PageChangeAssert("Concordia University")) {
                        fileStr.add("（go back homepage form):" + subMenu[i] + " page");
                        Thread.sleep(2000);
                    } else
                        fileStr.add(("(can not goback homepage from): " + subMenu[i]) + " page");
                }
            } else {
                fileStr.add(("failed on submenu " + subMenu[i]));
                break;
            }

        }
    }
//
//    @Test
//    public void testSubMenuA2() throws Exception {
//        HomePage homePage = new HomePage(driver);
//        HomePageActions homePageAction = new HomePageActions(driver);
//        HomePageAsser homePageAsser = new HomePageAsser(driver);
//
//        homePageAction.hovermenu(homePage.menu_about, homePage.sub_About_2);
//        homePageAsser.PageChangeAssert("Strategic directions");
//        driver.navigate().back();
//        if (homePageAsser.PageChangeAssert("Concordia University")) {
//            homePageAction.hovermenu(homePage.menu_about, homePage.sub_About_1);
//            homePageAsser.PageChangeAssert("Administration & governance");
//        } else
//            System.out.println("not go back HomePage");
//
//
//    }

    @Test
    public void testAbout() throws Exception {
        HomePageActions homePageAction = new HomePageActions(driver);
        HomePageAsser homePageAsser = new HomePageAsser((driver));

        homePageAction.mAboutClick();
        homePageAsser.PageChangeAssert("About");
    }

    @Test
    public void testAdmission() throws Exception {
        HomePageActions homePageAction = new HomePageActions(driver);
        HomePageAsser homePageAsser = new HomePageAsser(driver);

        homePageAction.mAdmissionsClick();
        homePageAsser.PageChangeAssert("Admission");
    }

    @Test
    public void testCampusLife() throws Exception {
        HomePageActions homePageAction = new HomePageActions(driver);
        HomePageAsser homePageAsser = new HomePageAsser(driver);

        homePageAction.mCampusLifeClick();
        homePageAsser.PageChangeAssert("Campus-life");

    }

    @Test
    public void testResearch() throws Exception {
        HomePageActions homePageAction = new HomePageActions(driver);
        HomePageAsser homePageAsser = new HomePageAsser(driver);

        homePageAction.mResearchClick();
        homePageAsser.PageChangeAssert("Research");

    }

    @Test
    public void testInternational() throws Exception {
        HomePageActions homePageAction = new HomePageActions(driver);
        HomePageAsser homePageAsser = new HomePageAsser(driver);

        homePageAction.mInternationalClick();
        homePageAsser.PageChangeAssert("International");

    }

    @After
    public void tearDown() throws Exception {
        fileOperate fo = new fileOperate();
        fo.testFileWrite(fileStr);
        fo.testFileRead();
        super.tearDown();

    }
}