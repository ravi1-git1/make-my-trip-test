package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SignIn {
private WebDriver driver;

 public SignIn(WebDriver driver){
     this.driver= driver;
 }


 public void signInGoogle(){

 }

    public static void main(String[] args) throws InterruptedException {


     System.setProperty("webdriver.chrome.driver","C:\\Users\\tejar\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
     driver.get("https://www.makemytrip.com/");
     driver.manage().window().maximize();
     String parent= driver.getWindowHandle();
    // driver.findElement(By.xpath("//*[text()='Login or Create Account']")).click();
     driver.findElement(By.xpath("//*[text()='Google']")).click();



     Set<String> s = driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while (I1.hasNext())
        {
            String child_window = I1.next();
            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ravi1.git1@gmail.com");
                driver.findElement(By.xpath("//span[text()='Next']")).click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Jan@2022");
                driver.findElement(By.xpath("//span[text()='Next']")).click();
                driver.switchTo().window(parent);
                System.out.println(driver.switchTo().window(parent).getTitle());

            }
        }
        Thread.sleep(5000);
    driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chHotels ']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='hsw_inputField lineHeight36 latoBlack font30']")).click();
        Thread.sleep(5000);
    driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("Bangalore");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//p[text()='Bangalore, Karnataka, India']")).click();
    Thread.sleep(1000);

        
    driver.findElement(By.xpath("//div[text()='12']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='13']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='ROOMS & GUESTS']")).click();
    driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
    driver.findElement(By.xpath("//li[@data-cy='children-2']")).click();




    }



}
