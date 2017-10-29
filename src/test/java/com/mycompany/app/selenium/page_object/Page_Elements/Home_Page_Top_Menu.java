package com.mycompany.app.selenium.page_object.Page_Elements;

import com.mycompany.app.selenium.page_object.Test_Case.TestBase;
import com.mycompany.app.selenium.page_object.Test_Case.result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Watchable;
import java.util.List;

public class Home_Page_Top_Menu {
    public void top_menu() throws InterruptedException {
        String title;
        result rs = new result();
        Boolean result=false;

        WebElement topMenu = TestBase.driver.findElement(By.xpath("//ul[@class='nav landing']"));
        List<WebElement> top_menu = TestBase.driver.findElements((By.xpath("//a[@class='dropdown-toggle']")));
        for (WebElement e : top_menu) {
            title = e.getText();
            System.out.println(title);
            e.click();
            result=rs.result(title);
            System.out.println(result);
            if (!result)
                break;
            else
                continue;
        }

    }
}

