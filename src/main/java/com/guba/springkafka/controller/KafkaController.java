package com.guba.springkafka.controller;

import com.guba.springkafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable String message) {
        log.info("Rest Controller KafkaController publishMessage param: {}", message);

        log.info("send synchronous");
        kafkaProducer.sendSynchronousMessage(message);

        log.info("send asynchronous");
        kafkaProducer.sendAsynchronousMessage(message);

        return message;
    }
}
