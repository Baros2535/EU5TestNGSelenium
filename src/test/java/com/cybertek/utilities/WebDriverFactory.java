package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.invoke.SwitchPoint;
import java.util.Locale;
public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){
        WebDriver driver= null;
        switch (browserType.toUpperCase())
        {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver =new ChromeDriver();
                break;
            case " FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;

        }

        return driver;

    }

}
