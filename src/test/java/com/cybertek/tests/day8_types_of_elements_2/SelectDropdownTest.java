package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {
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
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropDownElement = driver.findElement(By.cssSelector("#state"));
        Select stateDropdown=new Select(dropDownElement);
        List<WebElement> dropdownOptions = stateDropdown.getOptions();
        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());
/*
        for (WebElement dropdownOption : dropdownOptions) {

            System.out.println("dropdownOption.getText() = " + dropdownOption.getText());
        }
        */
        String expectedResult="Select a State";
        String actualResult = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult,expectedResult,"verify the first selection");

        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");
        String actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Virginia","verifying");

        Thread.sleep(2000);
        stateDropdown.selectByValue("AK");
        String actualOption1=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption1,"Alaska","verifying");

        Thread.sleep(2000);
        stateDropdown.selectByIndex(1);
        String actualOption2=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption2,"Alabama","verifying");


    }


}
