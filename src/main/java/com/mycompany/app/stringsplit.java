package com.mycompany.app;

public class stringsplit {
    public static void main(String[] args) {
        String str = "one123";
        String regex = "(?<=one)(?=123)";
        String[] strs = str.split(regex);
        for(int i = 0; i < strs.length; i++) {
            System.out.printf("strs[%d] = %s%n", i, strs[i]);
        }
    }
}