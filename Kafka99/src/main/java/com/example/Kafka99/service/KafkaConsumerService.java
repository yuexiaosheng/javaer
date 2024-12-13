package com.example.Kafka99.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    /**
     * my-topic 发送的时候指定的参数，groupID 对应yml配置文件
     * @param message
     */
    @KafkaListener(topics = "my-topic",groupId = "my-group")
    public void consume(String message){
        System.out.println("接受消息：" + message);
    }
    /**
     * 高级消费例子
     */
    //public void consume(ConsumerRecord<String,String> record){

    //}
}
