package com.cybertek.tests.day12_propeerties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {

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
