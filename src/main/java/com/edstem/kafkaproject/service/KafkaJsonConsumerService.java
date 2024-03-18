package com.edstem.kafkaproject.service;


import com.edstem.kafkaproject.payload.Student;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumerService.class);

    @KafkaListener(topics = "${spring.kafka.topic.json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Student student){
        LOGGER.info(String.format("Json message received -> %s", student.toString()));
    }
}
