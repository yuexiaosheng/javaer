package com.java.rabbitmqproducer;


import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

//https://blog.csdn.net/qq_34448345/article/details/85065745
//发布客户端
public class mqttPublisher {

    //mqtt服务器地址
    public static final String HOST = "tcp://localhost:1883";
    //主题
    public static final String TOPIC = "car001";
    //mqtt 客户机ID
    private static final String clientid = "server001";
    private MqttClient client;//客户端实例
    private MqttTopic topic11;//主题实例
    private String userName = "guest";  //非必须
    private String passWord = "guest";  //非必须
    private MqttMessage message;
    //初始化客户端实例
    public mqttPublisher() throws MqttException {
        //MemoryPersistence设置clientid的保存形式，默认为以内存保存
        client = new MqttClient(HOST, clientid, new MemoryPersistence());
        connect();
    }
    //连接服务器
    private void connect() {
        //连接配置
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);//不保存，每次重启新client
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            //设置发布回调
            //client.setCallback(new publishCallback());
            client.setCallback(null);
            client.connect(options);
            topic11 = client.getTopic(TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //发布
    public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException,
            MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! "+ token.isComplete());
    }
    //测试类
    public static void main(String[] args) throws MqttException, InterruptedException {
        //发布客户端
        mqttPublisher server = new mqttPublisher();
        //每隔10s发一条
        for (;;){
            server.message = new MqttMessage();
            server.message.setQos(1);//保证消息能到达一次
            server.message.setRetained(true);//消息保留
            server.message.setPayload("{'key':'value2222'}".getBytes());//消息内容
            server.publish(server.topic11 , server.message);//发布
            Thread.sleep(10000);
        }
    }
}
