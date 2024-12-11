package com.example.Batis3.po;

import lombok.Data;

import java.sql.Date;

@Data
public class Website {
    private int id;
    private String name;
    private String url;
    private int age;
    private String country;
    private Date createtime;
    /*省略setter和getter方法*/
    @Override
    public String toString() {
        return "id:" + id  + " name" + name + " url" + url + "age" + age + "country" + country + "createtime" + createtime;
    }
}
