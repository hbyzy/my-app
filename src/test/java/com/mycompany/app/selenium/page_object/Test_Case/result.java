package com.mycompany.app.selenium.page_object.Test_Case;

public class result {
    public int timeout=5000;
    public int interval=500;
    String title;

    public Boolean result(String Name) throws InterruptedException {
        while(timeout>0){
            title= TestBase.driver.getTitle();
            System.out.println(title);
           if (title==Name){
               return true;}
           else
           {Thread.sleep(interval);
               timeout -=interval;}
        }
        return false;
    }

}
