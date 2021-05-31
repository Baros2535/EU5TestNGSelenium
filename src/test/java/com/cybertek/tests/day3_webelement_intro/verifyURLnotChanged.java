package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;

import java.util.List;

public class verifyURLnotChanged {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //go to URL
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedURL=driver.getCurrentUrl();
      //find the location of the button
      By  buttonlocation = By.id("form_submit");
      WebElement retrievePasswordbutton=driver.findElement(buttonlocation);
        //click the button
      retrievePasswordbutton.click();
        //verify that URL is not changed.

        String actualtURL=driver.getCurrentUrl();

        if (expectedURL.equals(actualtURL))
        {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.quit();
    }
}
