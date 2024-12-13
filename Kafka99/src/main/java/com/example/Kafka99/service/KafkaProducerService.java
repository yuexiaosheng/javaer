package com.example.Kafka99.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.security.auth.callback.Callback;
import javax.websocket.SendResult;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送一个消息
     * @param topic
     * @param message
     */
    public void sendMessage(String topic,String message){
        kafkaTemplate.send(topic,message);
    }
    public void sendMessageWithCallBack(String topic,String message){
//        kafkaTemplate.send(topic,message).addCallback(new Callback(){
//            @Override
//            public void onSucess(SendResult result){
//                System.out.println(result.toString());
//            }
//        });

    }
}
