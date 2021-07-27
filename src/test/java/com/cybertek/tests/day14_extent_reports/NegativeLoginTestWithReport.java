package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {


    @Test
    public void wrongPasswordTest(){
        extentLogger=report.createTest("Wrong Password Test");

        LoginPage loginPage=new LoginPage();

        extentLogger.info("Enter Username :User1");
        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter Password : somepassword" );
        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("click button");
        loginPage.loginBtn.click();

        //  driver.findElement(By.id("prependedInput")).sendKeys("User1");
        //  driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        // driver.findElement(By.id("prependedInput")).sendKeys("User1");
        // driver.findElement(By.id("prependedInput2")).sendKeys("somepassword"+ Keys.ENTER);
        // driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("driver_username")+Keys.TAB + ConfigurationReader.get("driver_password") +Keys.ENTER);
       extentLogger.info("verify url");
       Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login","vrifying not login");

       extentLogger.pass("Wrong password test is PASSED");
    }
    @Test
    public void wrongUserNameTest(){

        LoginPage loginPage=new LoginPage();
        extentLogger=report.createTest("Wrong username test ");
        extentLogger.info("Enter Username :someUser");
        loginPage.usernameInput.sendKeys("someUser");
        extentLogger.info("Enter Password : UserUSer123" );
        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("click button");
        loginPage.loginBtn.click();
        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login","vrifying not login");
        extentLogger.pass("Wrong UserName test is PASSED");
    }
}
