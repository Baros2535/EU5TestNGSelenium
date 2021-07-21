package com.cybertek.myworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExampleForTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }


    public List<WebElement> listOfStatus() {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Status\")]")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//li/a[contains(@href,\"status_codes\")]"));
        return elements;

    }


    public void testAll(int index, int statusCode) {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Status\")]")).click();
        listOfStatus().get(index).click();
        WebElement elementText = driver.findElement(By.xpath("//p"));
        wait.until(ExpectedConditions.visibilityOf(elementText));

        String actualMessagetext = elementText.getText();
        actualMessagetext = actualMessagetext.substring(0, actualMessagetext.indexOf(".") + 1).trim();
        System.out.println(actualMessagetext);
        Assert.assertEquals(actualMessagetext, "This page returned a " + statusCode + " status code.", "Verify that following message is displayed: “This page returned a " + statusCode + " status code”");

    }

    @Test
    public void testCase9() {
        testAll(0, 200);
    }

    @Test
    public void testCase10() {
        testAll(1, 301);
    }

    @Test
    public void testCase11() {
        testAll(2, 404);
    }

    @Test
    public void testCase12() {
        testAll(3, 500);
    }



    @Test
    public void test8() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Status Codes")).click();

        for (int i = 1; i <= 4; i++)

        {    driver.findElement(By.xpath("(//div[@class='example']//ul/li/a)["+i+"]")).click();
            WebElement message = driver.findElement(By.xpath("//div[@class=\"example\"]/p"));
            System.out.println("message.getText() = " + message.getText());
          //  Assert.assertTrue(message.isDisplayed(), "Verify that following message is displayed: " + message.getText());
            driver.navigate().back();
        }


//        Step 4. Verify that following message is displayed:“This page returned a 200 status code”


    }
}