package com.java.rabbitmqconsumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class consumer1 {
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

          basicConsume(String queue, boolean autoAck, Consumer callback)

            1. quque，队列名称
            2. autoAck 自动回调
            3. callback 谁来回调
         * */

        Consumer consumer = new DefaultConsumer(channel){
            /*
            consumerTag 消费的标记
            envelope 获取一些信息
            properties 配置信息
            body 真实数据
            * */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body){
                System.out.println(consumerTag);
                System.out.println(envelope.getExchange());
                System.out.println(envelope.getRoutingKey());
                System.out.println(properties);
                System.out.println(new String(body));
            }
        };
        channel.basicConsume("hello_world",true,consumer);

        //7. 消费者不能关闭资源
    }
}
