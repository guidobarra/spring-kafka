package com.guba.springkafka.consumer;

import com.guba.springkafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "myTopic")
    public void consume(User message) {
        log.info("#### -> Consumed message -> {}", message.getId());
    }
}
