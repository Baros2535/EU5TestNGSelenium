package com.cybertek.tests.day10_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test1(){
        ///Users/barisaltun/IdeaProjects/EU5TestNGSelenium/src/test/resources/textFile.txt

        System.out.println(System.getProperty("user.dir"));
        final String property = System.getProperty("user.dir");
        String filePath=  "src/test/resources/textFile.txt";
        String fullPath = property + "/" + filePath;
        System.out.println(fullPath);



    }


}
