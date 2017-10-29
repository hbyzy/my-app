package com.mycompany.app.selenium.Juest_Eat;
import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class testjusteat {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String wprice;
    private String restourant;
    private String wpricet;
    private String wtaxt;
    private String wtipt;
    private String wdrivert;
    private String wtotalt;
    private float total;
    private boolean tcal;
    String wname="c:\\deleteable\\rname.txt";
    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        String os = (System.getProperty("os.name"));
        if (os.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        else
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions chromOptions = new ChromeOptions();
        chromOptions.addArguments("--kiosk");
        driver = new ChromeDriver(chromOptions);
        baseUrl = "https://www.just-eat.ca";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void wfile(String fname, List<WebElement> rname, List<WebElement> rstyle) throws IOException {
        File file= new File(fname);
        if (!file.exists())
            file.createNewFile();

        FileOutputStream fos=new FileOutputStream(file);
        OutputStreamWriter  wfos= new OutputStreamWriter(fos);
        for(int i=0;i<rname.size();i++){
            String str=rname.get(i).getText()+"\t"+"||"+rstyle.get(i).getText();
            wfos.write(str+"\n\r");
        }
        wfos.flush();
        wfos.close();

    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl + "/");
        assertEquals("Order Food Delivery Online | Pizza, Sushi & Chinese at Just-Eat.ca", driver.getTitle());
        driver.findElement(By.id("homepage-search-fullAddress")).clear();
        driver.findElement(By.id("homepage-search-fullAddress")).sendKeys("365 elm westmount");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//section[@id='skipToMain']/div[2]/div/div/div/ul/li/strong[3]")).click();
        Thread.sleep(3000);
        assertEquals("Order take out in H3Z Montreal from JUST-EAT.ca", driver.getTitle());

        /*
        List<WebElement> rname= driver.findElements(By.className("listing-item-title"));
        for (WebElement e:rname)
        System.out.println(e.getText());
        */
        WebElement element =driver.findElement(By.cssSelector(".listing-group.listing-group--noSpacingTop.card"));
        List<WebElement> rName= element.findElements(By.className("listing-item-title"));
        List<WebElement> rStyle= element.findElements(By.cssSelector(".infoText.infoText--primary>strong"));
        /*for (WebElement e:rName)
            System.out.println(e.getText());
        for (WebElement e:rStyle)
            System.out.println(e.getText());
        */
        wfile(wname,rName,rStyle);




        Thread.sleep(5000);
        driver.findElement(By.cssSelector("h3.listing-item-title")).click();
        Thread.sleep(5000);
        restourant = driver.getTitle();
        System.out.println(restourant);
        if (Objects.equals(restourant, "SAJ mahal Menu | Order Delivery Online at JUST-EAT.ca")) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,250)", "");
            Thread.sleep(3000);
            driver.findElement(By.id("cat0")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//div[@id='container-menu--card']/section[2]/div/div/button")).click();
            Thread.sleep(5000);
            wprice = driver.findElement(By.xpath(".//*[@id='container-menu--card']/section[2]/div/div/div[2]")).getText();
            wpricet = driver.findElement(By.xpath(".//*[@id='menuContainer']/div/div[3]/article/div/div[3]/div[1]/ul[2]/li/div[1]/span[2]")).getText();
            wtaxt = driver.findElement(By.xpath(".//*[@id='menuContainer']/div/div[3]/article/div/div[3]/div[1]/ul[2]/li/div[2]/span[2]")).getText();
            wtipt = driver.findElement(By.xpath(".//*[@id='menuContainer']/div/div[3]/article/div/div[3]/div[1]/ul[2]/li/div[3]/div[2]")).getText();
            wdrivert = driver.findElement(By.xpath(".//*[@id='menuContainer']/div/div[3]/article/div/div[3]/div[1]/ul[2]/li/div[4]/div/div[2]")).getText();
            wtotalt = driver.findElement(By.xpath(".//*[@id='menuContainer']/div/div[3]/article/div/div[3]/div[1]/ul[2]/li/div[6]/span[2]")).getText();
            wprice=wprice.substring(1);
            wpricet = wpricet.substring(1);
            wtaxt = wtaxt.substring(1);
            wtipt = wtipt.substring(1);
            wdrivert = wdrivert.substring(1);
            wtotalt = wtotalt.substring(1);
            if (wprice.equals(wpricet)) {
                total = Float.parseFloat(wpricet) + Float.parseFloat(wtaxt) + Float.parseFloat(wtipt) + Float.parseFloat(wdrivert);
                System.out.println("calculated total is : "+total);
                System.out.println("website total is : "+Float.parseFloat(wtotalt));


                if (Float.parseFloat(wtotalt) == total)
                    tcal = true;
                else
                    tcal = false;

            }
            System.out.println(wprice);
        } else if (Objects.equals(restourant, "Devi Restaurant Bar Menu | Order Delivery Online at JUST-EAT.ca")) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,250)", "");
            Thread.sleep(3000);
            driver.findElement(By.id("cat0")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//div[@id='container-menu--card']/section[2]/div/div[2]/button")).click();
            Thread.sleep(5000);
        } else if (Objects.equals(restourant, "Restaurant PM Menu | Order Delivery Online at JUST-EAT.ca")) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,250)", "");
            Thread.sleep(3000);
            driver.findElement(By.id("cat0")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='container-menu--card']/section[2]/div/div[2]/button")).click();
            Thread.sleep(10000);

        } else if (Objects.equals(restourant, "Montrose Menu | Order Delivery Online at JUST-EAT.ca")) {
            Thread.sleep(1000);
            driver.findElement(By.id("cat0")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='container-menu--card']/section[2]/div/div/button")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[@id='collectiononly']/div[2]/div/div")).click();
            wprice = driver.findElement(By.xpath(".//*[@id='container-menu--card']/section[3]/div/div[1]/div")).getTagName();
            Thread.sleep(3000);
        }
    }

    public String getprice(String wpprice) {
        int i = wpprice.indexOf("|");
        String prices = wpprice.substring(0, i);
        return prices;
    }


    public void rfile(String rname) throws IOException {
        File file=new File(rname);
        if(!file.exists())
            System.out.println("File not exist:"+rname);
        //FileInputStream fis=new  FileInputStream(file);
        BufferedReader filebuf= new BufferedReader(new FileReader(file));
        //BufferedInputStream fisb= new BufferedInputStream(fis);
        //InputStreamReader fisr=new InputStreamReader(fis);
        String readline ;
        do{
            readline=filebuf.readLine();
            System.out.println(readline);
        }
        while (readline!=null);
        try {
            filebuf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
        testjusteat price = new testjusteat();
        String name;
        name = getprice(restourant);
        System.out.println(name);
        if (tcal)
            System.out.println("calculation is correct");
        else
            System.out.println("calculation is wrong");
        rfile(wname);
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
