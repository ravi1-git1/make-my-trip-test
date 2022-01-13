package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Logout {

    private WebDriver driver;
    By profile= By.xpath("//*[text()='My Profile'][1]");
    By logout= By.xpath("//*[text()='Logout'][1]");


    public Logout(WebDriver driver) {
        this.driver=driver;
    }

    public void Logout_action() throws InterruptedException {
        driver.findElement(profile).click();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", driver.findElement(logout));
        //driver.findElement(By.xpath("//*[text()='Logout'][1]")).click();
        driver.close();
    }

}
