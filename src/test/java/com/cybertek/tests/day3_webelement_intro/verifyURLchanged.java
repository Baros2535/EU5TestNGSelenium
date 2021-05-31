package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) {
        //open driver
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //go to URL
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //enter any email
        By inputBoxLocation=By.name("email");
        WebElement inputBoxEmail=driver.findElement(inputBoxLocation);
        inputBoxEmail.sendKeys("brsaltn.25@gmail.com");

        //click the button
        By  buttonlocation = By.id("form_submit");
        WebElement retrievePasswordbutton=driver.findElement(buttonlocation);
        retrievePasswordbutton.click();

        String expectedURL="http://practice.cybertekschool.com/email_sent";
        String actualURL=driver.getCurrentUrl();

       if (expectedURL.equals(actualURL)){
           System.out.println("PASS");

       }else{

           System.out.println("FAIL");
       }
        //close browser
       driver.quit();
    }





}
