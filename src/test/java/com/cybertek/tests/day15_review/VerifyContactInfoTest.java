package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest(){
        extentLogger=report.createTest("Contact Info Verification");
        LoginPage loginPage=new LoginPage();
        extentLogger.info("login as sales manger with this credentials  UserName:  "+
                ConfigurationReader.get("salesmanager_username")+
                " Pasword: " +  ConfigurationReader.get("salesmanager_password") );
        loginPage.loginAsSalesManager();

        extentLogger.info("navigate to customers --> Contacts ");
        new DashboardPage().navigateToModule("Customers","Contacts");

        ContactsPage contactsPage=new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("click the email");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage=new ContactInfoPage();
        extentLogger.info("verify name");
        Assert.assertEquals(contactInfoPage.fullName.getText(),"Mariam Brackstone","verify the name");
        extentLogger.info("verify the email");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","verify email");
        extentLogger.info("verify the phone");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone number");
        extentLogger.pass("TEST IS PASSED");


    }

}
