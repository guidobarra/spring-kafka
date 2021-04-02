package com.guba.springkafka.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@ConfigurationProperties(prefix = "kafka.topic")
@Setter
@Getter
public class KafkaConfig {

    private String name;

    private Integer partition;

    private Integer replica;

    private String compressionType;

    @Bean
    public NewTopic topicWithCompressionExample() {
        return TopicBuilder.name(name)
                .partitions(partition)
                .replicas(replica)
                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, compressionType)
                .build();
    }
}
