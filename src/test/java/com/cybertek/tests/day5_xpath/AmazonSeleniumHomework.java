package com.cybertek.tests.day5_xpath;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSeleniumHomework {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://amazon.com");
        WebElement searchTextBox=driver.findElement(By.xpath("(//div/input)[4]"));
        String searched="selenium";
        searchTextBox.sendKeys(searched);
        WebElement searchButton= driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        searchButton.click();
        WebElement locationOfText=driver.findElement(By.xpath("(//span[@dir=\"auto\"])[1]"));
        String actualResult= locationOfText.getText() + " \"" + searched + "\"";
        System.out.println(actualResult);
        String expectedResult="1-48 of 150 results for \"selenium\"";
        if (expectedResult.equals(actualResult)){
            System.out.println("PASS");

        }else{
            System.out.println("FAİL");
        }
        Thread.sleep(2000);
driver.quit();

    }
}
