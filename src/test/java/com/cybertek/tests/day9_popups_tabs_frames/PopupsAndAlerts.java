package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
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
    public void test1(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//button[@id=\"j_idt302:j_idt303\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"j_idt302:j_idt306\"]")).click();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();

        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        Thread.sleep(2000);
        alert.dismiss();

        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        alert.sendKeys("Memoli");
        Thread.sleep(3000);
        alert.accept();


    }
}
