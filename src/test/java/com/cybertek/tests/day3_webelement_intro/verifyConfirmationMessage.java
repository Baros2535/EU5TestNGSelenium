package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.bind.SchemaOutputResolver;

public class verifyConfirmationMessage {

    public static void main(String[] args) {
        //open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        // go to URL
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //enter an email.
        By inputBoxLocation=By.name("email");
        WebElement inputBoxEmail=driver.findElement(inputBoxLocation);
        String expectedEmail="brsaltn.25@gmail.com";
        inputBoxEmail.sendKeys(expectedEmail);

        String actualEmail= inputBoxEmail.getAttribute("value");
        if (expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");

        }

        //click on button
        By  buttonlocation = By.id("form_submit");
        WebElement retrievePasswordbutton=driver.findElement(buttonlocation);
        //click the button
        retrievePasswordbutton.click();
        //verify that the message
        String expectedTextOfTheMessageText="Your e-mail's been sent!";
        By locationOfText=By.name("confirmation_message");
        WebElement textOfTheMessage=driver.findElement(locationOfText);
        String actualTextOfTheMessageText = textOfTheMessage.getText();



        if(expectedTextOfTheMessageText.equals(actualTextOfTheMessageText)){
            System.out.println("PASS");
        }else
        {
            System.out.println("FAIL");
        }


       driver.quit();


    }

}
