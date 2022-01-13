package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hotels {

    private WebDriver driver;
    By click_city= By.xpath("//input[@class='hsw_inputField lineHeight36 latoBlack font30']");
    By select_city= By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']");
    By select_bangalore= By.xpath("//p[text()='Bangalore, Karnataka, India']");
    By click_room= By.xpath("//p[@data-cy='roomGuestCount']");
    By select_adult= By.xpath("//li[@data-cy='adults-2']");
    By select_child= By.xpath("//li[@data-cy='children-1']");
    By child_age= By.xpath("//select[@data-cy]");
    By apply_button= By.xpath("//*[text()='APPLY']");
    By search_button= By.xpath("//button[@id='hsw_search_button']");

    public Hotels(WebDriver driver) {
        this.driver=driver;
    }





    public void select_hotel() throws InterruptedException {
        Thread.sleep(5000);
        driver.navigate().to("https://www.makemytrip.com/hotels/");
        driver.findElement(click_city).click();
        Thread.sleep(5000);
        driver.findElement(select_city).sendKeys("Bangalore");
        Thread.sleep(2000);
        driver.findElement(select_bangalore).click();
        Thread.sleep(1000);
    }

    public void select_days() throws InterruptedException {
        SimpleDateFormat f = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        String current_day=f.format(c.getTime());
        System.out.println(current_day);
        String seventh_day= String.valueOf((Integer.parseInt(current_day)+7));
        System.out.println(seventh_day);
        driver.findElement(By.xpath("//div[text()='"+current_day+"']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='"+seventh_day+"']")).click();
        Thread.sleep(3000);
        driver.findElement(click_room).click();
        Thread.sleep(3000);
        driver.findElement(select_adult).click();
        driver.findElement(select_child).click();
        Select se = new Select(driver.findElement(child_age));
        se.selectByValue("2");
    }

    public void search() throws InterruptedException {

        System.out.println("searching ");
        //driver.findElement(By.xpath("//p[@class='makeFlex vrtlCenter']")).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[text()='APPLY']")));
        //js.executeScript("window.scrollBy(0,-350)", "");
        Thread.sleep(2000);
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(apply_button));
        Thread.sleep(2000);
        WebElement ele = driver.findElement(apply_button);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
        // driver.findElement(By.xpath("//*[text()='APPLY']")).click();

        driver.findElement(search_button).click();

    }
}
