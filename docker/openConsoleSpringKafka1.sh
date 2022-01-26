#!/bin/bash

echo 'list topics...'
docker exec -it kafka_1 kafka-topics --zookeeper zookeeper_1:2181 --list

echo 'describe topic myTopic...'
docker exec -it kafka_1 kafka-topics --zookeeper zookeeper_1:2181 --topic myTopic --describe

echo 'logs container spring_kafka_1...'
docker logs -f -t spring_kafka_1