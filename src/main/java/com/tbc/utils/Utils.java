package com.tbc.utils;

public class Utils {

    public static void log(String message){
        if(ExtendMethodManager.getTest() != null){
            ExtendMethodManager.getTest().info(message);
        }
    }
}
