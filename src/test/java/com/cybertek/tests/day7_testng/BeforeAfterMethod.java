package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterMethod {
    @Test
    public void test1()
    {
        System.out.println("first test case");

    }
    @Test
    public void test2()
    {
        System.out.println("Second test case");

    }
    @BeforeMethod
    public void setUp(){
        System.out.println("webdriver openning browser");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("closing browser quit");
    }
    @BeforeClass
    public void setUpClass(){
        System.out.println("BEFORE class");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("AFTER class");
    }
}
