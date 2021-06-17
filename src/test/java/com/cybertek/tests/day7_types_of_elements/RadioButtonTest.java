package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        //locating
        WebElement blueButton=driver.findElement(By.cssSelector("#blue"));
        WebElement redButton=driver.findElement(By.cssSelector("#red"));
        System.out.println("blueButton.isSelected() = " + blueButton.isSelected());
        System.out.println("redButton.isSelected() = " + redButton.isSelected());
//verify blue is selected red is not selected
        Assert.assertTrue(blueButton.isSelected(),"verify that blue is selected");
        Assert.assertFalse(redButton.isSelected(),"verify that red is not selected");
        redButton.click();

        Assert.assertFalse(blueButton.isSelected(),"verify that blue is not selected");
        Assert.assertTrue(redButton.isSelected(),"verify that red is selected");
        Thread.sleep(3000);
        driver.quit();

    }
}
