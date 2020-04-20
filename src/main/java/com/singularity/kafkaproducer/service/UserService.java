package com.singularity.kafkaproducer.service;

import com.singularity.kafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private KafkaTemplate<String, User> kafkaUserTemplate;

    private final static String TOPIC = "user-topic-transform-data";

    public String produceMessage(User user){
        try{
            kafkaUserTemplate.send(TOPIC, user);
            return "message delivered";
        }catch (Exception ex){
            return ex.getMessage();
        }
    }
}
