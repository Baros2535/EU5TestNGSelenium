package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssLocator {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        By locationOfButton2= By.cssSelector("#disappearing_button");
        WebElement foundOfButton2= driver.findElement(locationOfButton2);
        foundOfButton2.click();
        driver.quit();

    }
}
