package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        driver.navigate().to("https://www.makemytrip.com/hotels/");
    //driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chHotels ']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='hsw_inputField lineHeight36 latoBlack font30']")).click();
        Thread.sleep(5000);
    driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("Bangalore");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//p[text()='Bangalore, Karnataka, India']")).click();
    Thread.sleep(1000);

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
        driver.findElement(By.xpath("//p[@data-cy='roomGuestCount']")).click();
        Thread.sleep(3000);
    driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
    driver.findElement(By.xpath("//li[@data-cy='children-1']")).click();

        Select se = new Select(driver.findElement(By.xpath("//select[@data-cy]")));
        se.selectByValue("2");

        //driver.findElement(By.xpath("//p[@class='makeFlex vrtlCenter']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[text()='APPLY']")));
        //js.executeScript("window.scrollBy(0,-350)", "");
        Thread.sleep(2000);
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//*[text()='APPLY']")));
        Thread.sleep(2000);
        WebElement ele = driver.findElement(By.xpath("(//*[text()='APPLY'])"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
     // driver.findElement(By.xpath("//*[text()='APPLY']")).click();

        driver.findElement(By.xpath("//button[@id='hsw_search_button']")).click();
        Thread.sleep(5000);
        act.moveToElement(driver.findElement(By.xpath("//*[@name='min']")));
        driver.findElement(By.xpath("//*[@name='min']")).sendKeys("500");
        driver.findElement(By.xpath("//*[@name='max']")).sendKeys("5000");
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@class='btnRangeGo appendLeft5 ']")).click();
        Thread.sleep(5000);
        //act.moveToElement(driver.findElement(By.xpath("//div[@id='Listing_hotel_0']")));
        driver.navigate().to(driver.findElement(By.xpath("//div[@id='Listing_hotel_0']//*")).getAttribute("href"));



    }



}
