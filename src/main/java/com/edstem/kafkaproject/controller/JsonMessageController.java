package com.edstem.kafkaproject.controller;

import com.edstem.kafkaproject.payload.Student;
import com.edstem.kafkaproject.service.KafkaJsonProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private KafkaJsonProducerService kafkaProducer;


    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Student student) {
        kafkaProducer.sendMessage(student);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}