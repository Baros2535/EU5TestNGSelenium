package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){
        LoginPage loginPage=new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

    }

    @Test
    public void loginAsStoreManager(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

    }
}
