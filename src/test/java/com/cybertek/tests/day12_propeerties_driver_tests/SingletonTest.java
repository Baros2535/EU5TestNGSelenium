package com.cybertek.tests.day12_propeerties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void tes1(){
     //   Singleton a=new Singleton();
        String str1= Singleton.getStr();
      String str2=  Singleton.getStr();

        System.out.println(str1);
        System.out.println(str2);

   }
   @Test
   public void test2(){
       WebDriver driver= Driver.get();
       driver.get(ConfigurationReader.get("url"));
   }
    @Test
    public void test3(){
        WebDriver driver= Driver.get();
        driver.get("https://www.google.com");
    }
}
