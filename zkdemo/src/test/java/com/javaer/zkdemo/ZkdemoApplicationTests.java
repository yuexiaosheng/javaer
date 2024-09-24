package com.javaer.zkdemo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZkdemoApplicationTests {
    private static CuratorFramework client;

    @BeforeAll
    public static void testConnect(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000,10);
        //第一种
//        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181",60*1000,15*1000,retryPolicy);
//        client.start();
        //第二种
        client = CuratorFrameworkFactory.builder().connectString("localhost:2181").
                sessionTimeoutMs(60*1000).retryPolicy(retryPolicy).
                connectionTimeoutMs(15*1000).namespace("java").
                build();
        client.start();
    }

    /**
     * 创建节点 create 临时，持久，顺序, 数据
     * 1.基本的
     * 2.带有数据的
     * 3.节点类型
     * 4.多级节点
     */
    @Test
    public void testCreate2() throws Exception {
        String path = client.create().forPath("/abc2","haha".getBytes());
        System.out.println(path);
    }
    @Test
    public void testCreate3() throws Exception {
        String path = client.create().withMode(CreateMode.EPHEMERAL).forPath("/abc3","haha".getBytes());
        System.out.println(path);
        while(true){

        }
    }
    @Test
    public void testCreate4() throws Exception {
        //如果父亲不存在，那么创建
        String path = client.create().creatingParentContainersIfNeeded().forPath("/abc4/p1");
        System.out.println(path);
    }

    @AfterAll
    public static void close(){
        if(client!=null){
            client.close();
        }
    }

}
