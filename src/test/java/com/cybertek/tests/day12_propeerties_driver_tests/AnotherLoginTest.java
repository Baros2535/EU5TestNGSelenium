package com.cybertek.tests.day12_propeerties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AnotherLoginTest  extends TestBase {

    @Test
    public void test1(){
        String url = ConfigurationReader.get("url");

        driver.get(url);
        //  driver.findElement(By.id("prependedInput")).sendKeys("User1");
        //  driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("driver_username"));
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.get("driver_password")+ Keys.ENTER);
        // driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("driver_username")+Keys.TAB + ConfigurationReader.get("driver_password") +Keys.ENTER);

    }
}
