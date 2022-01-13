package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class List_Hotels {



    WebDriver driver;
    By min= By.xpath("//*[@name='min']");
    By max= By.xpath("//*[@name='max']");
    By arrow_button= By.xpath("//*[@class='btnRangeGo appendLeft5 ']");
    By hotel_1= By.xpath("//div[@id='Listing_hotel_0']//*");
    By remove_filter= By.xpath("//*[@class='apldFltr__item--close']");
    By show_more= By.xpath("//*[text()='Show 3 more' and @id='hlistpg_proptypes_show_more'][1]");
    By last_filter= By.xpath("//*[text()='Staycations']");

    public List_Hotels(WebDriver driver) {
        this.driver=driver;
    }

    public void apply_filter() throws InterruptedException {
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(min));
        Thread.sleep(2000);
        driver.findElement(min).sendKeys("500");
        driver.findElement(max).sendKeys("5000");
        Thread.sleep(4000);

        driver.findElement(arrow_button).click();
    }

    public void click_hotels() throws InterruptedException {

        driver.navigate().to(driver.findElement(hotel_1).getAttribute("href"));
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.findElement(remove_filter).click();
        Thread.sleep(5000);
        driver.findElement(show_more).click();

        driver.findElement(last_filter).click();
        Thread.sleep(2000);
        driver.navigate().to(driver.findElement(hotel_1).getAttribute("href"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='makeFlex hrtlCenter']")).click();
    }
}
