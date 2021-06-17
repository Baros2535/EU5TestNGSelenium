package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException{
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement userNameInput=driver.findElement(By.cssSelector("#username"));
        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());

        Assert.assertFalse(userNameInput.isDisplayed(),"verify that input is not displayedd");

        driver.findElement(By.cssSelector("#start>button")).click();

        Thread.sleep(5000);

        Assert.assertTrue(userNameInput.isDisplayed(),"verify that input isdisplayedd");

    }
}
