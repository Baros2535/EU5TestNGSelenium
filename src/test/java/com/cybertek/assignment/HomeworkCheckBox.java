package com.cybertek.assignment;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeworkCheckBox {
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
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkBoxElement = driver.findElement(By.cssSelector("div[id=\"txtAge\"]"));
        Assert.assertFalse(checkBoxElement.isDisplayed(),"is not displayed");
        driver.findElement(By.cssSelector("input#isAgeSelected")).click();
        Assert.assertEquals(checkBoxElement.getText(),"Success - Check box is checked","verify that message is displayed");
    }

    @Test
    public void test2(){
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement buttonCheckAll=driver.findElement(By.cssSelector("input#check1"));
        Assert.assertEquals(buttonCheckAll.getAttribute("value"),"Check All","verify Check All button text is \"Check All\" ");
       buttonCheckAll.click();
        List<WebElement> elements = driver.findElements(By.cssSelector("input.cb1-element"));
        for (WebElement element : elements) {
            Assert.assertTrue(element.isSelected()," verify element is selected");
            System.out.println("element.isSelected() = " + element.isSelected());
        }
     Assert.assertEquals(buttonCheckAll.getAttribute("value"),"Uncheck All","Verify button text changed to \"Uncheck All\"");
        


    }


}
