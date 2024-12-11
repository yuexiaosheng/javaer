package com.example.Batis3.controller;

import com.example.Batis3.po.Website;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class WebsiteController {
    @RequestMapping("/read")
    public String readone() throws IOException {

        // 读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
        // 通过SqlSessionFactory创建SqlSession
        SqlSession ss = ssf.openSession();
        // SqlSession执行文件中定义的SQL，并返回映射结果
        // 添加网站
        Website website = new Website();
        website.setName("编程帮");
        website.setUrl("https://www.biancheng.net/");
        website.setAge(21);
        website.setCountry("CN");
        ss.insert("com.example.Batis3.mapper.WebsiteMapper.addWebsite", website);
        // 查询所有网站
        List<Website> listWeb = ss.selectList("com.example.Batis3.mapper.WebsiteMapper.selectAllWebsite");
        for (Website site : listWeb) {
            System.out.println(site);
        }
        // 提交事务
        ss.commit();
        // 关闭 SqlSession
        ss.close();

        return "I am tom";
    }
}
