package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {


    private WebDriver driver;
    By Google_login= By.xpath("//*[text()='Google']");

    public Home(WebDriver driver) {
        this.driver=driver;
    }

    public void clickLogin() {
        driver.findElement(Google_login).click();
    }

}
