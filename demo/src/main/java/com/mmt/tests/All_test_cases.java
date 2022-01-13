package com.mmt.tests;

import com.mmt.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class All_test_cases  {

    private WebDriver driver;
    private Full_test_without_POM signin;
    private Home home;
    private Hotels hotels;
    private List_Hotels list_hotels;
    private Login login;
    private Logout logout;

    @BeforeClass
    public  void setup(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\tejar\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

        driver= new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
    }




    @Test(priority = 0)
    public void signInGoogle() {
        System.out.println("Sign In");
        home = new Home(driver);
        home.clickLogin();

    }
    @Test(priority = 1)
    public void Login() throws InterruptedException {
        System.out.println("Login");
        login = new Login(driver);
        login.switchWindow_login();

    }
    @Test(priority = 2)
    public void Hotels_filter() throws InterruptedException {
        System.out.println("hotels filter");
        hotels = new Hotels(driver);
        hotels.select_hotel();
        hotels.select_days();
        hotels.search();
    }

    @Test(priority = 3)
    public void Hotels_list() throws InterruptedException {
        System.out.println("hotels filter");
        list_hotels = new List_Hotels(driver);
        list_hotels.apply_filter();
        list_hotels.click_hotels();

    }

    @Test(priority = 4)
    public void Logout() throws InterruptedException {
        System.out.println("logout");
       logout= new Logout(driver);
       logout.Logout_action();


    }

    @AfterClass
    public void teardown(){
    driver.quit();
        }


}
