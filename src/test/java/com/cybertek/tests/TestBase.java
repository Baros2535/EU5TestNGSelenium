package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
   protected WebDriver driver;
    protected Actions actions;
 protected WebDriverWait wait;
    //Class is using Building Report
    protected ExtentReports report;
    //this class is used for create HTML reprt
   protected ExtentHtmlReporter htmlReporter;
    //this class is defining a test
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
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



    @BeforeMethod
    public  void setUp(){

        driver= Driver.get();
        String url = ConfigurationReader.get("url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,30);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
        if (result.getStatus()==ITestResult.FAILURE){
            //record the neame of failed testcase
            extentLogger.fail(result.getName());
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());
            //add your screenshot to ypur report
            extentLogger.addScreenCaptureFromPath(screenshotPath);
            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }
        Thread.sleep(1000);
        Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest(){
        //this is when the report is actually created
        report.flush();
    }

}
