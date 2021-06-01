package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        By locationOfTheHomeLink= By.className("nav-link");
        WebElement foundOfTheHomeLink=driver.findElement(locationOfTheHomeLink);
        foundOfTheHomeLink.click();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        By locationOfTheText=By.tagName("h3");
        WebElement foundOfTheText=driver.findElement(locationOfTheText);
        System.out.println(foundOfTheText.getText());

    }
}
