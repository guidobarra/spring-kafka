package com.guba.springkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "myTopic", groupId = "my_group_demo")
    public void consume(String message) {
        log.info("#### -> Consumed message -> {}", message);
    }
}
