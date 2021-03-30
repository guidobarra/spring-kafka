package com.guba.springkafka.producer;

import com.guba.springkafka.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Value(value = "${kafka.topic.name}")
    private String topic;

    public void sendAsynchronousMessage(final String message) {

        User u = new User(message, "gu", "ba");
        ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send(topic, u);

        future.addCallback(new ListenableFutureCallback<>() {

            public void onSuccess(SendResult<String, User> result) {
                log.info("Sent message=[{}] with offset=[{}]", message, result.getRecordMetadata().offset());
            }

            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[{}] due to : {}", message, ex.getMessage());
            }
        });
    }

    public void sendSynchronousMessage(String message) {
        log.info("#### -> Producing message -> {}", message);
        User u = new User(message, "gu", "ba");
        this.kafkaTemplate.send(topic, u);
    }
}
