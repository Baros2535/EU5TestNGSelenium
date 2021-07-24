package com.cybertek.tests.day13_pom;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /*
    open browser
    login as a driver
    Verify that page subtitle is quick lanchpod
    go to Activities
    Calender events
    verify that pagesubtittle is calender page

     */


    @Test
    public void test1() {

        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();
        String expectedSubtitle="Quick Launchpad";
        DashboardPage dashboardPage=new DashboardPage();
        String actualpageSubTitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(dashboardPage.getPageSubTitle(),expectedSubtitle,"verify subtitle");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        Assert.assertEquals(new CalendarEventsPage().getPageSubTitle(),"Calendar Events","verify subtitle");



    }

}
