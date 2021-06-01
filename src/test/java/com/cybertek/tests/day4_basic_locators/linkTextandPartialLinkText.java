package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextandPartialLinkText {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        By locationOfTheLink1= By.linkText("Example 1: Element on page that is hidden and become visible after trigger");
        WebElement foundOfTheLink1=driver.findElement(locationOfTheLink1);
        foundOfTheLink1.click();

        driver.navigate().back();

        By locationOfTheLink2= By.partialLinkText("Example 2");
        WebElement foundOfTheLink2=driver.findElement(locationOfTheLink2);
        foundOfTheLink2.click();


    }
}
