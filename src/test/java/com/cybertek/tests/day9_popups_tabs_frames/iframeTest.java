package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }
     @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        Thread.sleep(2000);
        //first way switching by frame name or id
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).clear();
         Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Barış ALTUN");

        //Frist way goes back to HTML
         driver.switchTo().defaultContent();

         //second way switching by index
      // main HTML does not count by using index only frames
         driver.switchTo().frame(0);
         Thread.sleep(2000);
         driver.findElement(By.cssSelector("#tinymce")).clear();
         Thread.sleep(2000);
         driver.findElement(By.cssSelector("#tinymce")).sendKeys("Barış ALTUN with index");
          //second way goes back
         driver.switchTo().parentFrame();

         WebElement iframe = driver.findElement(By.tagName("iframe"));
         driver.switchTo().frame(iframe);

         Thread.sleep(2000);
         driver.findElement(By.cssSelector("#tinymce")).sendKeys("Barış ALTUN with web element");



     }
     @Test
     public  void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
         driver.switchTo().frame("frame-top");

         driver.switchTo().frame("frame-middle");

         System.out.println("driver.findElement(By.id(\"content\")).getText() = " + driver.findElement(By.id("content")).getText());

         driver.switchTo().parentFrame();

         driver.switchTo().frame(2);

         System.out.println("driver.findElement(By.id(\"content\")).getText() = " + driver.findElement(By.tagName("body")).getText());

         driver.switchTo().defaultContent();

         driver.switchTo().frame(1);

         System.out.println("driver.findElement(By.id(\"content\")).getText() = " + driver.findElement(By.tagName("body")).getText());



     }

}
