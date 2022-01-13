package com.mmt.tests;

import com.mmt.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class All_test_cases  {

    private WebDriver driver;
    private SignIn signin;
    private Home home;
    private Hotels hotels;
    private List_Hotels list_hotels;
    private Login login;
    private Logout logout;

    @BeforeClass
    public  void setup(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\tejar\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
    }




    @Test
    public void signInGoogle() {
        System.out.println("Sign In");
        home = new Home(driver);
        home.clickLogin();
        //basepage = new BasePage(driver);
    }

    @AfterClass
    public void teardown(){
    driver.quit();
        }


}
