package com.cybertek.assignment;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework2 {
WebDriver driver;
WebDriverWait wait;
    @BeforeMethod
    public  void setUp(){
     driver= WebDriverFactory.getDriver("chrome");
     driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    wait=new WebDriverWait(driver,10);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }



    @Test
    public void testCase1()  {
    driver.get("http://practice.cybertekschool.com/");
    WebElement registForm = driver.findElement(By.xpath("//li/a[contains(text(),\"Registration Form\")]"));
    registForm.click();
    driver.findElement(By.xpath("//input[@name=\"birthday\"]")).sendKeys("Barış");

        WebElement errorBirthTextElement = driver.findElement(By.xpath("//small[@data-bv-validator=\"date\"]"));
        wait.until(ExpectedConditions.visibilityOf(errorBirthTextElement));
        String actualText =errorBirthTextElement.getText();

    Assert.assertEquals("The date of birth is not valid",actualText,"VVerify that warning message is displayed:\n" +
                "“The date of birth is not valid”");

    }

    @Test
    public  void testCase2() {
        driver.get("http://practice.cybertekschool.com/");
        WebElement registForm = driver.findElement(By.xpath("//li/a[contains(text(),\"Registration Form\")]"));
        registForm.click();

        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineCheckbox1~label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineCheckbox2~label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#inlineCheckbox3~label")).isDisplayed());


    }
    @Test
    public  void testCase3() {
        driver.get("http://practice.cybertekschool.com/");
        WebElement registForm = driver.findElement(By.xpath("//li/a[contains(text(),\"Registration Form\")]"));
        registForm.click();
         driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("a");
        WebElement errorNameTextElement = driver.findElement(By.xpath("//small[@data-bv-validator=\"stringLength\"]"));
        wait.until(ExpectedConditions.visibilityOf(errorNameTextElement));
        String actualText =errorNameTextElement.getText();
        Assert.assertEquals(actualText,"first name must be more than 2 and less than 64 characters long","Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”");

    }

    @Test
    public  void testCase4() {
        driver.get("http://practice.cybertekschool.com/");
        WebElement registForm = driver.findElement(By.xpath("//li/a[contains(text(),\"Registration Form\")]"));
        registForm.click();
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("a");
        WebElement errorLastNameTextElement = driver.findElement(By.xpath("(//small[@data-bv-validator=\"stringLength\"])[2]"));
        wait.until(ExpectedConditions.visibilityOf(errorLastNameTextElement));
        String actualText =errorLastNameTextElement.getText();
        Assert.assertEquals(actualText,"The last name must be more than 2 and less than 64 characters long","Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”");

    }

    @Test
    public void testCase5(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement registForm = driver.findElement(By.xpath("//li/a[contains(text(),\"Registration Form\")]"));
        registForm.click();
        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Baros");
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("ALTUN");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("brsaltn");
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("brsaltn.25@gmail.com");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Baro1234");
        driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("571-123-0000");
        driver.findElement(By.xpath("//input[@name=\"gender\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"birthday\"]")).sendKeys("01/14/1989");
        WebElement dropDownDepartment = driver.findElement(By.xpath("//select[@name=\"department\"]"));
        Select departmentDropdown=new Select(dropDownDepartment);
        departmentDropdown.selectByValue("DE");
        WebElement dropDownJobTitle = driver.findElement(By.xpath("//select[@name=\"job_title\"]"));
        Select jobDropdown=new Select(dropDownJobTitle);
        jobDropdown.selectByIndex(4);
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        WebElement actualTextElement = driver.findElement(By.xpath("//p"));
        wait.until(ExpectedConditions.visibilityOf(actualTextElement));
        String actualText = actualTextElement.getText();

        Assert.assertEquals(actualText,"You've successfully completed registration!","Verify that following success message is displayed: “You've successfully completed registration!”");

    }
    @Test
    public void testCase6(){
        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.xpath("//span[@id=\"email\"]")).getText();
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Sign Up \")]")).click();
        driver.findElement(By.xpath("//input")).sendKeys("Barış");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys(email);
        //step 7
        driver.findElement(By.xpath("//button")).click();


    }

    @Test
    public void testCase7() {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("File Upload")).click();
        WebElement element = driver.findElement(By.id("file-upload"));
        element.sendKeys("/Users/barisaltun/IdeaProjects/EU5TestNGSelenium/src/test/resources/textFile.txt");
        driver.findElement(By.id("file-submit")).click();
        String textFileUpload = driver.findElement(By.xpath("//h3")).getText();
        String textFile = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(textFileUpload,"File Uploaded!","verifying uploaded message");
        Assert.assertEquals(textFile,"textFile.txt","verifying correct file");



    }

    @Test
    public void testCase8() {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Autocomplete\")]")).click();
        driver.findElement(By.cssSelector("#myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type=\"button\"]")).click();
        WebElement textElement = driver.findElement(By.xpath("(//p)[2]"));
        wait.until(ExpectedConditions.visibilityOf(textElement));
        Assert.assertEquals(textElement.getText(),"You selected: United States of America","Verify that following message is displayed: “You selected: United States of America”");

    }



    public List<WebElement> listOfStatus(){
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Status\")]")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//li/a[contains(@href,\"status_codes\")]"));
        return elements;

    }

    @Test
    public void testCase9() {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Status\")]")).click();
       listOfStatus().get(0).click();
        WebElement elementText = driver.findElement(By.xpath("//p"));
        wait.until(ExpectedConditions.visibilityOf(elementText));

        String actualMessagetext = elementText.getText();
        actualMessagetext=actualMessagetext.substring(0, actualMessagetext.indexOf(".")+1).trim();

        System.out.println(actualMessagetext);
        Assert.assertEquals(actualMessagetext,"This page returned a 200 status code.","Verify that following message is displayed: “This page returned a 200 status code”");
    }

    @Test
    public void testCase10() {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Status\")]")).click();
        listOfStatus().get(1).click();
        WebElement elementText = driver.findElement(By.xpath("//p"));
        wait.until(ExpectedConditions.visibilityOf(elementText));

        String actualMessagetext = elementText.getText();
        actualMessagetext=actualMessagetext.substring(0, actualMessagetext.indexOf(".")+1).trim();

        System.out.println(actualMessagetext);
        Assert.assertEquals(actualMessagetext,"This page returned a 301 status code.","Verify that following message is displayed: “This page returned a 301 status code”");
    }

    @Test
    public void testCase11() {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Status\")]")).click();
        listOfStatus().get(2).click();
        WebElement elementText = driver.findElement(By.xpath("//p"));
        wait.until(ExpectedConditions.visibilityOf(elementText));

        String actualMessagetext = elementText.getText();
        actualMessagetext=actualMessagetext.substring(0, actualMessagetext.indexOf(".")+1).trim();


        System.out.println(actualMessagetext);
        Assert.assertEquals(actualMessagetext,"This page returned a 404 status code.","Verify that following message is displayed: “This page returned a 404 status code”");
    }
    @Test
    public void testCase12() {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Status\")]")).click();
        listOfStatus().get(3).click();
        WebElement elementText = driver.findElement(By.xpath("//p"));
        wait.until(ExpectedConditions.visibilityOf(elementText));

        String actualMessagetext = elementText.getText();
        actualMessagetext=actualMessagetext.substring(0, actualMessagetext.indexOf(".")+1).trim();


        System.out.println(actualMessagetext);
        Assert.assertEquals(actualMessagetext,"This page returned a 500 status code.","Verify that following message is displayed: “This page returned a 500 status code”");
    }


/*

    @DataProvider
    public Object[][] getData(){
        Object [][] status=new Object[4][2];
        status[0][0]="li>a[href*=\"status_codes/200\"]";
        status[0][1]="This page returned a 200 status code";
        status[1][0]="li>a[href*=\"status_codes/301\"]";
        status[1][1]="This page returned a 301 status code";
        status[2][0]="li>a[href*=\"status_codes/404\"]";
        status[2][1]="This page returned a 404 status code";

        status[3][0]="li>a[href*=\"status_codes/500\"]";
        status[3][1]="This page returned a 500 status code";

        return status;

    }
    @Test(dataProvider = "getData")
    public void test1(String  statusCode,String statusError) throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Status\")]")).click();
        driver.findElement(By.cssSelector(statusCode)).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//p")).getText();
        String  actualText=text.substring(0,text.indexOf("."));
        Assert.assertEquals(actualText,statusError,"verifying errors");


    }
*/
    }

