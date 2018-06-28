package com.kafkawebsocket.rayonit.kafkawebsocket.Services;

import com.kafkawebsocket.rayonit.kafkawebsocket.Models.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(topics = "events")
    public void consume(String message) {
        System.out.println("Mesazhi: "  + message);
        template.convertAndSend("/events", new ResponseModel( message));
    }

    //    @KafkaListener(topics = "Kafka_Example_json", group = "group_json",
//            containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(User user) {
//        System.out.println("Consumed JSON Message: " + user);
//    }
}
