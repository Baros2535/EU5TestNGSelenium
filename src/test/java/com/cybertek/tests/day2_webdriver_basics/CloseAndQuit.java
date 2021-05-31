package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        /*WebDriverManager.iedriver().setup();
        WebDriver driver1=new InternetExplorerDriver();

        driver1.get("http://practice.cybertekschool.com");
        driver1.close();*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://practice.cybertekschool.com");
        Thread.sleep(3000);
        driver.close();
        driver=new ChromeDriver();
        driver.navigate().to("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(3000);

        driver.quit();

    }

}
