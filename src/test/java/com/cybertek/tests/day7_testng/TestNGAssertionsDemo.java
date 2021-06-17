package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");
        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }
    @Test
public void test2(){
        Assert.assertEquals("test2","test2");
}
   @Test
   public void test3(){
        String expectedTitle="Cyb";
        String actualTitle="Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"verify title statrs with Cyb");
   }
   @Test
    public void test4(){
        //Verify email contains @ sign
       String email="brsaltn.25@gmail.com";
       Assert.assertTrue(email.contains("@"),"Verify email contains @ sign");

   }
   @Test
    public void test5(){
        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");

   }
   @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
   }
}
