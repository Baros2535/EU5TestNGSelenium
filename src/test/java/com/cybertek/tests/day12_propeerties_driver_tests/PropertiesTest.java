package com.cybertek.tests.day12_propeerties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class PropertiesTest {

    @Test
    public void test1(){
        String browserType= ConfigurationReader.get("browser");
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));

        System.out.println(browserType);
    }

    @Test
    public void openBrowserWithConf(){
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        String url = ConfigurationReader.get("url");
        System.out.println(url);
        driver.get(url);
      //  driver.findElement(By.id("prependedInput")).sendKeys("User1");
      //  driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
       driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("driver_username"));
       driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.get("driver_password")+ Keys.ENTER);
       // driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("driver_username")+Keys.TAB + ConfigurationReader.get("driver_password") +Keys.ENTER);

    }
}
