package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {
    @Test
    public void readExcelFile(){
        String projectPath=System.getProperty("user.dir");
        String filePath=projectPath+"/src/test/resources/Vytracktestdata.xlsx";
        ExcelUtil qa3Sheet=new ExcelUtil(filePath,"QA3-short");
        System.out.println(qa3Sheet.rowCount());
        System.out.println(qa3Sheet.columnCount());
        System.out.println(qa3Sheet.getColumnsNames());
        List<Map<String, String>> dataList = qa3Sheet.getDataList();

        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);
        }
        // get nona as a value
        System.out.println(dataList.get(2).get("firstname"));
        // get harber
        System.out.println(dataList.get(8).get("lastname"));

        //get all data in 2d array
        String[][] dataArray = qa3Sheet.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));


    }
}
