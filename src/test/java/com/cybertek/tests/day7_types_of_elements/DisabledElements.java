package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {
    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenButton=driver.findElement(By.cssSelector("#green"));

        System.out.println("greenButton.isEnabled() = " + greenButton.isEnabled());

        Assert.assertFalse(greenButton.isEnabled(),"verify green button is not enabled");
greenButton.click();

    }
    @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputbox=driver.findElement(By.cssSelector("#input-example>input[type=\"text\"]"));
       // inputbox.sendKeys("how are you?");  // you cann not write anything because it is disabled


    }

}
