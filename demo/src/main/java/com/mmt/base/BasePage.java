package com.mmt.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BasePage {

    private WebDriver driver;

static String driverpath= "C:\\Users\\tejar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";

public WebDriver getDriver(){
    return driver;
}

public void setDriver(String browser, String url) {

    switch (browser) {
        case "chrome":
            driver = initChrome(url);
            break;
        case "firefox":
            driver = initFirefox(url);
            break;
        default:
            driver = initChrome(url);
    }
}

    private static WebDriver initChrome(String url){
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver",driverpath);
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        return driver;


    }

    private static WebDriver initFirefox(String url){

        System.out.println("launching the firefox browser");
        WebDriver driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        return driver;

}
 @Parameters({"browser","url"})
    @BeforeClass
    public void initialse(String browser, String url){
    try{
        setDriver(browser,url);
    }catch (Exception e)
    {
        System.out.println("error is "+e);
    }
 }


   @AfterClass
    public void tearDown(){
    driver.quit();
   }


}
