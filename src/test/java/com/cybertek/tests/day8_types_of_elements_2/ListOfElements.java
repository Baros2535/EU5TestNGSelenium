package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("buttons.size() = " + buttons.size());
        Assert.assertEquals(buttons.size(),6,"verify buttons size");

        for (WebElement button : buttons) {
           Assert.assertTrue(button.isDisplayed());
        }

        buttons.get(1).getAttribute("outerHTML");
        buttons.get(1).click();

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
       List <WebElement> buttons= driver.findElements(By.tagName("button"));

    }
}
