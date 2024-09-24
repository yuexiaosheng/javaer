package com.java.rabbitmqproducer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class producer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建链接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //2.设置参数，虚拟机，ip，端口
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/itcast"); //默认是/
        factory.setUsername("heima");
        factory.setPassword("heima");

        //3.创建链接 Connection
        Connection connection = factory.newConnection();
        //4.创建channel
        Channel channel = connection.createChannel();
        //5.创建一个队列Queue
        /*
        * queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        * 参数
            1. queue: 队列名称
            2. durable: 是否持久化,MQ重启以后还在
            3. exclusive: 是否独占，只能由一个消费者监听这个队列，当connection关闭时候是否删除 一般设置为false
            4. autoDelete: 是否自动删除 ，没有consumer时候自动删除
            5. arguments: 先不讲，设置为null
        * */

        //如果没有一个名字叫hello_world的队列，则创建，如果有，则不会创建
        channel.queueDeclare("hello_world",true,false,false,null);
        //6.发送消息给Queue
        /*
        * String exchange, String routingKey, BasicProperties props, byte[] body
        * 参数
        *   1. exchange: 交换机名称,简单模式下没有 输入""
        *   2. routingKey: 路由名称,默认的交换机下要和队列名字一样
        *   3. BasicProperties： 配置
        *   4. body： 真实的消息数据
        * */
        String body = "hello mq ~~~~ ";
        channel.basicPublish("","hello_world",null,body.getBytes());

        //7. 释放资源
        //channel.close();
        //connection.close();
    }
}
