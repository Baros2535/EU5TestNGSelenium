package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
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
        driver.get("http://practice.cybertekschool.com/upload");
        WebElement element = driver.findElement(By.id("file-upload"));

        element.sendKeys("/Users/barisaltun/Desktop/File.txt");
        driver.findElement(By.id("file-submit")).click();
        String text = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(text,"File.txt","verifying uploading");

    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");
        WebElement element = driver.findElement(By.id("file-upload"));
        final String property = System.getProperty("user.dir");
        String filePath=  "src/test/resources/textFile.txt";
        String fullPath = property + "/" + filePath;
        element.sendKeys(fullPath);
        driver.findElement(By.id("file-submit")).click();
        String text = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(text,"textFile.txt","verifying uploading");

    }
}
