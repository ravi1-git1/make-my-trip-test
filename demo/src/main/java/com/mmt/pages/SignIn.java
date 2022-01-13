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
     By Google_login= By.xpath("//*[text()='Google']");
        By email= By.xpath("//input[@type='email']");
        By next_button= By.xpath("//span[text()='Next']");
        By password= By.xpath("//input[@type='password']");
        By click_city= By.xpath("//input[@class='hsw_inputField lineHeight36 latoBlack font30']");
        By select_city= By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']");
        By select_bangalore= By.xpath("//p[text()='Bangalore, Karnataka, India']");
        By click_room= By.xpath("//p[@data-cy='roomGuestCount']");
        By select_adult= By.xpath("//li[@data-cy='adults-2']");
        By select_child= By.xpath("//li[@data-cy='children-1']");
        By child_age= By.xpath("//select[@data-cy]");
        By apply_button= By.xpath("//*[text()='APPLY']");
        By search_button= By.xpath("//button[@id='hsw_search_button']");
        By min= By.xpath("//*[@name='min']");
        By max= By.xpath("//*[@name='max']");
        By arrow_button= By.xpath("//*[@class='btnRangeGo appendLeft5 ']");
        By hotel_1= By.xpath("//div[@id='Listing_hotel_0']//*");
        By remove_filter= By.xpath("//*[@class='apldFltr__item--close']");
        By show_more= By.xpath("//*[text()='Show 3 more' and @id='hlistpg_proptypes_show_more'][1]");
        By last_filter= By.xpath("//*[text()='Staycations']");
        By profile= By.xpath("//*[text()='My Profile'][1]");
        By logout= By.xpath("//*[text()='Logout'][1]");


    // driver.findElement(By.xpath("//*[text()='Login or Create Account']")).click();
     driver.findElement(Google_login).click();



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
        Thread.sleep(5000);
        driver.navigate().to("https://www.makemytrip.com/hotels/");
    //driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chHotels ']")).click();
        Thread.sleep(5000);
        driver.findElement(click_city).click();
        Thread.sleep(5000);
    driver.findElement(select_city).sendKeys("Bangalore");
    Thread.sleep(2000);
    driver.findElement(select_bangalore).click();
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
        driver.findElement(click_room).click();
        Thread.sleep(3000);
    driver.findElement(select_adult).click();
    driver.findElement(select_child).click();

        Select se = new Select(driver.findElement(child_age));
        se.selectByValue("2");

        //driver.findElement(By.xpath("//p[@class='makeFlex vrtlCenter']")).click();

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
        Thread.sleep(5000);
        act.moveToElement(driver.findElement(min));
        Thread.sleep(2000);
        driver.findElement(min).sendKeys("500");
        driver.findElement(max).sendKeys("5000");
        Thread.sleep(4000);

        driver.findElement(arrow_button).click();
        Thread.sleep(5000);
        //act.moveToElement(driver.findElement(By.xpath("//div[@id='Listing_hotel_0']")));
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
        driver.findElement(profile).click();
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click()", driver.findElement(logout));
        //driver.findElement(By.xpath("//*[text()='Logout'][1]")).click();
        driver.close();



    }



}
