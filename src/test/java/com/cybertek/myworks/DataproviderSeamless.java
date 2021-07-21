package com.cybertek.myworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataproviderSeamless {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public  void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        wait=new WebDriverWait(driver,10);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }


    @DataProvider (name="login_credentials")

    public Object[][] getData()
    {
        Object [][] userData=new Object[4][2];
        userData[0][0]="Employee1";
        userData[0][1]="Employee123";
        userData[1][0]="Employee11";
        userData[1][1]="Employee123";
        userData[2][0]="Employee21";
        userData[2][1]="Employee123";
        userData[3][0]="Employee31";
        userData[3][1]="Employee123";

       return userData;

    }




    @Test (dataProvider = "login_credentials")
    public  void login(String username,String password){
        driver.get("http://qa.seamlessly.net/index.php/login?redirect_url=/index.php/apps/files/");
        driver.findElement(By.id("user")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-form")).click();


    }

}
