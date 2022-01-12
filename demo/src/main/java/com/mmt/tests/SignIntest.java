package com.mmt.tests;

import com.mmt.base.BasePage;
import com.mmt.pages.SignIn;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignIntest  extends BasePage {

    private WebDriver driver;
    private SignIn signin;
    private BasePage basepage;

    @BeforeClass
    public  void setup(){
        driver= getDriver();
    }

    @Test
    public void signInGoogle(){
        System.out.println("Sign In");
        //basepage = new BasePage(driver);




    }
}
