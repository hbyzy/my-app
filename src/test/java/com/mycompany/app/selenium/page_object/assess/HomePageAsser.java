package com.mycompany.app.selenium.page_object.assess;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class HomePageAsser {
    WebDriver driver;
    public int timeOut = 5000;
    public int interval = 500;

    public HomePageAsser(WebDriver wdriver) {
        this.driver = wdriver;
    }

    public boolean PageChangeAssert(String rname) throws InterruptedException {
        String currentHandle;
        Set<String> handles;
        while (timeOut > 0) {
            String Title = driver.getTitle();
            if (rname.equals(Title)) {
                System.out.println("chang to right page:" + Title);
                return true;
            } else {
                currentHandle = driver.getWindowHandle();
                handles = driver.getWindowHandles();
                if (handles.size() > 1) {
                    for (String e : handles) {
                        if (!e.equals(currentHandle)) {
                            driver.switchTo().window(e);
                        }
                    }
                } else {
                    Thread.sleep(interval);
                    timeOut -= interval;
                }
            }
        }

        System.out.println("can not chage to right page:" + rname);
        return false;
    }
}
