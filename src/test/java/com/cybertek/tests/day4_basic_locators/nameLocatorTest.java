package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        By locationOfFullName= By.name("full_name");
        WebElement foundOfFullName=driver.findElement(locationOfFullName);
        foundOfFullName.sendKeys("Barış ALTUN");

        //put some email click sign up button
        By locationOfEmail= By.name("email");
        WebElement foundOfEmail=driver.findElement(locationOfEmail);
       foundOfEmail.sendKeys("brsaltn.25@gmail.com");
       //click the button
        By locationOfSignUpButton=By.name("wooden_spoon");
        WebElement foundOfSignUpButton=driver.findElement(locationOfSignUpButton);
        foundOfSignUpButton.click();



    }
}
