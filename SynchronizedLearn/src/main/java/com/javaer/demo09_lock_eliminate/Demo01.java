package com.javaer.demo09_lock_eliminate;

public class Demo01 {
    public static void main(String[] args) {
        contactString("a","b","c");
    }
    public static String contactString(String s1,String s2,String s3){
        return new StringBuffer().append(s1).append(s2).append(s3).toString();
    }
}
