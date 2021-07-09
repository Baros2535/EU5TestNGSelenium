package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("titleBeforeclick = " + driver.getTitle());
        driver.findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();
     //   System.out.println("titleafterClick = " + driver.getTitle());

        String currentWindowHandle= driver.getWindowHandle();
        System.out.println("driver.getWindowHandle()1 = " + driver.getWindowHandle());
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)){
                System.out.println("driver.getWindowHandle() 2= " + driver.getWindowHandle());
                driver.switchTo().window(windowHandle);
                Thread.sleep(2000);

            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());


    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("titleBeforeclick = " + driver.getTitle());
        driver.findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();

        Set<String> windowHandles= driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);

            if (driver.getTitle().equals("New Window")){
                break;
            }

        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
}
