package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TransferQueue;

public class ActionsTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverTest(){
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        Actions actions=new Actions(driver);
        //perform() --perform the action
        //moveToElement() hover the element
        actions.moveToElement(img1).perform();

        WebElement view_profile_element = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(view_profile_element.isDisplayed(),"verifying displayed");

    }
@Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions=new Actions(driver);
    WebElement elementsource = driver.findElement(By.cssSelector("div#draggable"));
    WebElement elementtarget = driver.findElement(By.cssSelector("div#droptarget"));

    driver.findElement(By.xpath("//*[.=\"Accept Cookies\"]")).click();
    Thread.sleep(1000);

    actions.dragAndDrop(elementsource,elementtarget).perform();

    Assert.assertEquals(elementtarget.getText(),"You did great!","verify thet drag and drop");

}

@Test
    public void dragAndDropChaining() throws InterruptedException {
    driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
    Actions actions=new Actions(driver);
    WebElement elementsource = driver.findElement(By.cssSelector("div#draggable"));
    WebElement elementtarget = driver.findElement(By.cssSelector("div#droptarget"));

    driver.findElement(By.xpath("//*[.=\"Accept Cookies\"]")).click();
    Thread.sleep(2000);

  //  actions.dragAndDrop(elementsource,elementtarget).perform();

  //  Assert.assertEquals(elementtarget.getText(),"You did great!","verify thet drag and drop");


    actions.moveToElement(elementsource).clickAndHold().moveToElement(elementtarget).release().perform();

    Assert.assertEquals(elementtarget.getText(),"You did great!","verify thet drag and drop");
    Thread.sleep(1000);
}
}
