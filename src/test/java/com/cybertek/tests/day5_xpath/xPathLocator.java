package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xPathLocator {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        By locationOfButton2= By.xpath("//*[@id=\"content\"]/div[1]/button[2]");
        WebElement foundOfButton2= driver.findElement(locationOfButton2);
        foundOfButton2.click();



    }


}
