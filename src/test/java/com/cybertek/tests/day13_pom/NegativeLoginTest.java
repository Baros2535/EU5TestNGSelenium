package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    @Test
    public void wrongPasswordTest(){
        LoginPage loginPage=new LoginPage();
        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

       //  driver.findElement(By.id("prependedInput")).sendKeys("User1");
        //  driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
       // driver.findElement(By.id("prependedInput")).sendKeys("User1");
      // driver.findElement(By.id("prependedInput2")).sendKeys("somepassword"+ Keys.ENTER);
        // driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("driver_username")+Keys.TAB + ConfigurationReader.get("driver_password") +Keys.ENTER);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login","vrifying not login");
    }
    @Test
    public void wrongUserNameTest(){
        LoginPage loginPage=new LoginPage();
        loginPage.usernameInput.sendKeys("someUser");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login","vrifying not login");

    }


}
