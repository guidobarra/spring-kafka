#!/bin/bash

echo 'list topics...'
docker exec -it kafka_1 kafka-topics --bootstrap-server kafka_1:29092,kafka_2:29093,kafka_3:29094,kafka_4:29095,kafka_5:29096 --list

echo 'describe topic myTopic...'
docker exec -it kafka_1 kafka-topics --bootstrap-server kafka_1:29092,kafka_2:29093,kafka_3:29094,kafka_4:29095,kafka_5:29096 --topic myTopic --describe

echo 'logs container spring_kafka_2...'
docker logs -f -t spring_kafka_2