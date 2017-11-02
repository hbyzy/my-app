package com.mycompany.app.selenium.page_object.function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class pagescroll {
    WebElement driver;

    public pagescroll(WebElement driver){
      this.driver=driver;
    }
    public void rollup(){
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("windows.scrollby(0.250)","");
    }
}