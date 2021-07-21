package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public  void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,10);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }



    @Test
    public void testCase1()  {
        WebElement table1 = driver.findElement(By.cssSelector("table#table1"));
        System.out.println(table1.getText());
        Assert.assertTrue(table1.getText().contains("jdoe@hotmail.com"));



    }
    @Test
    public void testCase2()  {
 //how many colums we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id=\"table1\"]/thead/tr/th"));
        System.out.println(headers.size());

        for (WebElement element:headers) {
            System.out.println(element.getText());
        }

    }

    @Test
    public void testCase3()  {
        //how many rows we have
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
        System.out.println(rows.size());

        for (WebElement element:rows) {
            System.out.println(element.getText());
        }

    }

    @Test
    public  void getRow(){
        //get text second row
        System.out.println( driver.findElement(By.xpath("(//table[@id=\"table1\"]/tbody/tr)[2]")).getText());


        System.out.println("==========================================");

        //all rows get

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
        for (int i = 1; i <= rows.size(); i++) {
            System.out.println( i +"-"+ driver.findElement(By.xpath("(//table[@id=\"table1\"]/tbody/tr)["+i+"]")).getText());

        }

    }

    @Test
    public void getAllCellInOneRow(){

        List<WebElement> rowsCells = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr[1]/td"));
        for (WebElement element:rowsCells) {
            System.out.println(element.getText());
        }

    }
@Test
    public void getSingleCellByIndex(){
WebElement singleElement = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[3]/td[5]"));
    System.out.println(singleElement.getText());
}

@Test
    public void printAllCellsByIndex(){
        int rows=getNumberOfRow();
        int columns=getNumberOfColumn();
    for (int i = 1; i <=rows ; i++) {
        System.out.print(i+"-");
        for (int j = 1; j <=columns ; j++) {
            WebElement singleElement = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+i+"]/td["+j+"]"));
            System.out.print(" | " +singleElement.getText());
        }
        System.out.println();
    }
}

@Test
public void getCellInRelationToAnotherCellInSameRow(){
String firstName="Bach";

    WebElement element = driver.findElement(By.xpath("//table[@id=\"table1\"]//td[.=\""+firstName+"\"]/../td[3]"));
    System.out.println(element.getText());


}

    private int getNumberOfColumn() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id=\"table1\"]/thead/tr/th"));
return headers.size();
    }

    private int getNumberOfRow() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
        return rows.size();
    }

}
