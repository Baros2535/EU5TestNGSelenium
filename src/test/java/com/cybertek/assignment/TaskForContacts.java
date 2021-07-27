package com.cybertek.assignment;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskForContacts extends TestBase {

    @Test
    public void test1() {
extentLogger=report.createTest("Contact Info Test");
    LoginPage loginAsSalMan=new LoginPage();
    extentLogger.info("login with as a Sales Manager");
    loginAsSalMan.loginAsSalesManager();

    ContactsPage contactsPage=new ContactsPage();
    extentLogger.info("navigate to customers -> contacts");
    contactsPage.navigateToModule("Customers","Contacts");

   // BrowserUtils.hover(contactEmail);
    contactsPage.waitUntilLoaderScreenDisappear();

    WebElement contactEmail = contactsPage.getContactEmail("mbrackstone9@example.com");
    extentLogger.info("click the email");
    BrowserUtils.waitForClickablility(contactEmail,5).click();

    ContactInfoPage contactInfoPage=new ContactInfoPage();
    extentLogger.info("verify the fullname");
    Assert.assertEquals(contactInfoPage.fullName.getText(),"Mariam Brackstone","verify fullname");
    extentLogger.pass("Verifying fullname is PASSED");
    extentLogger.info("verify the email");
    Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","verify email");
    extentLogger.pass("Verifying email is PASSED");
    extentLogger.info("verify the phone number");
    Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone");
    extentLogger.pass("Verifying email is PASSED");
    extentLogger.pass("TEST IS PASSED");

    }

}
