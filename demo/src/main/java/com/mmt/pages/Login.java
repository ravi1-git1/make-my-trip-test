package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class Login {



    private WebDriver driver;

    By Google_login= By.xpath("//*[text()='Google']");
    By email= By.xpath("//input[@type='email']");
    By next_button= By.xpath("//span[text()='Next']");
    By password= By.xpath("//input[@type='password']");
    By click_city= By.xpath("//input[@class='hsw_inputField lineHeight36 latoBlack font30']");
    By select_city= By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']");
    By select_bangalore= By.xpath("//p[text()='Bangalore, Karnataka, India']");

    public Login(WebDriver driver) throws InterruptedException {
        this.driver=driver;
    }



    public void switchWindow_login() throws InterruptedException {
        String parent= driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while (I1.hasNext())
        {
            String child_window = I1.next();
            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                driver.findElement(email).sendKeys("ravi1.git1@gmail.com");
                driver.findElement(next_button).click();
                Thread.sleep(5000);
                driver.findElement(password).sendKeys("Jan@2022");
                driver.findElement(next_button).click();
                driver.switchTo().window(parent);
                System.out.println(driver.switchTo().window(parent).getTitle());

            }
        }

    }










}
