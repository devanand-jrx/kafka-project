package com.edstem.kafkaproject.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.edstem.kafkaproject.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducerService {
    @Value("${spring.kafka.topic.json.name}")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducerService.class);

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMessage(Student data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<Student> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        kafkaTemplate.send(message);
    }
}
