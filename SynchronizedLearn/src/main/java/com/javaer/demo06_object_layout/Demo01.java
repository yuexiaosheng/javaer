package com.javaer.demo06_object_layout;

import org.openjdk.jol.info.ClassLayout;

public class Demo01 {
    public static void main(String[] args) {
        LockObj obj = new LockObj();
        int x = obj.hashCode();

        System.out.println(Integer.toHexString(x));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        //VM options -XX:+UseCompressedOops 默认开启指针压缩 -XX:-UseCompressedOops关闭
    }
}
