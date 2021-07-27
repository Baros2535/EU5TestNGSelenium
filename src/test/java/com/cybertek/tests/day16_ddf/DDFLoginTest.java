package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {


    @DataProvider
    public Object[][] userData(){
        String projectPath=System.getProperty("user.dir");
        String filePath=projectPath+"/src/test/resources/Vytracktestdata.xlsx";
        ExcelUtil qa3Sheet=new ExcelUtil(filePath,"QA3-short");
        String[][] dataArray= qa3Sheet.getDataArrayWithoutFirstRow();
       return dataArray;

    }

    @Test(dataProvider = "userData")
    public void login(String username,String password,String firstName,String lastName){
        extentLogger=report.createTest("TEST username: " +username +" Password: "+password );
        LoginPage loginPage=new LoginPage();

        loginPage.login(username,password);
        DashboardPage dashboardPage=new DashboardPage();
        Assert.assertEquals( dashboardPage.getUserName(),firstName+ " "+lastName,"verify the full name");
        extentLogger.pass("TEST IS PASSED");

    }


}
