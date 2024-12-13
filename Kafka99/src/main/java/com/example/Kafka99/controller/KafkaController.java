package com.example.Kafka99.controller;

import com.example.Kafka99.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    KafkaProducerService kafkaProducerService;

    /**
     * 请求例子 http://localhost:85/send?topic=my-topic&message=tom
     * @param topic
     * @param message
     * @return
     */
    @RequestMapping("/send")
    public ResponseEntity sendMessage(@RequestParam String topic,
                                      @RequestParam String message){
        kafkaProducerService.sendMessage(topic,message);
        return ResponseEntity.ok("发送成功");

    }
    @RequestMapping("/get")
    public String get(){
        return "Hi,I am Kafka";
    }
}
