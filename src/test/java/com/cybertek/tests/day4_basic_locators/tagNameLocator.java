package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        By locationOfTheFullName= By.tagName("input");
        WebElement foundOfTheFullName= driver.findElement(locationOfTheFullName);
        foundOfTheFullName.sendKeys("Barış ALTUN");

        By locationOfEmail= By.name("email");
        WebElement foundOfEmail=driver.findElement(locationOfEmail);
        foundOfEmail.sendKeys("brsaltn.25@gmail.com");

        By locationOfSignUpButton=By.tagName("button");
        WebElement foundOfSignUpButton=driver.findElement(locationOfSignUpButton);
        foundOfSignUpButton.click();

        Thread.sleep(3000);
        driver.quit();


    }
}
