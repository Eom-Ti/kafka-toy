package com.example.kafkatoy.test;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class TestKafka {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public TestKafka(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        try {
            SendResult<String, String> stringStringSendResult = kafkaTemplate.send(topic, message).get();
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessageAsync(String topic, String message) {
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, message);
    }
}
