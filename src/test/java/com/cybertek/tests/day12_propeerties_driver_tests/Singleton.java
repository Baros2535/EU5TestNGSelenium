package com.cybertek.tests.day12_propeerties_driver_tests;

public class Singleton {
private static String str;

    private Singleton() { }

    public static String getStr() {
        if (str==null)
        {
            System.out.println("str is null assign it");
            str="somevalue";

        }else {
            System.out.println("it has value just return");
        }

        return str;
    }
}
