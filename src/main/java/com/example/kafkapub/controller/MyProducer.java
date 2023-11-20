package com.example.kafkapub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MyProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping("/login")
    public String a(String topic){

        String message = "message";
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.addCallback(new KafkaSendCallback<>(){
            @Override
            public void onFailure(KafkaProducerException ex) {
                log.info("!!!!!!!!!! onFailure onFailure onFailure onFailure onFailure onFailure onFailure  !!!!!!!!!!");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("!!!!!!!!!! onSuccess onSuccess onSuccess onSuccess onSuccess onSuccess onSuccess: {} !!!!!!!!!!",result);
            }
        });
        return "pub_page";
    }
}
