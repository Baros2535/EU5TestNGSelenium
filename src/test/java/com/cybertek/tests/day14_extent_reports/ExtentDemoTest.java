package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {
   //Class is using Building Report
    ExtentReports report;
    //this class is used for create HTML report
    ExtentHtmlReporter htmlReporter;
    //this class is defining a test
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
             //starting report
        report=new ExtentReports();
        //creating a report path
        String projectPath=System.getProperty("user.dir");
        String path=projectPath+ "/test-output/report.html";
        //initialize the html reporter with the report path
        htmlReporter=new ExtentHtmlReporter(path);

        //attaach the html report to report object
        report.attachReporter(htmlReporter);

        //title reporter
        htmlReporter.config().setReportName("Vytrack Smoke Test");
        //set environment info
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));


    }

    @Test
    public void test1(){
        extentLogger=report.createTest("TC123 Login as Driver Test");

        //test steps
        extentLogger.info("open browserr");

        extentLogger.info("go to this url");

        extentLogger.info("Enter driver username password");

        extentLogger.info("click login");

        extentLogger.info("verify logged in ");

        //pass() marks the test is passed
        extentLogger.pass("TC123 is passed");
    }


    @AfterMethod
    public void tearDown(){
        //this is when the report is actually created
        report.flush();
    }

}
