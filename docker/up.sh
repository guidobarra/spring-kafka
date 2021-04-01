#!/bin/bash

echo 'create containers zookeeper, cluster kafka and app spring kafka'
docker-compose -f zk-single-kafka-multiple-5.yml up -d

sleep 5
echo 'list topics...'
docker exec -it kafka_1 kafka-topics --zookeeper zookeeper_1:2181 --list

echo 'describe topic myTopic...'
docker exec -it kafka_1 kafka-topics --zookeeper zookeeper_1:2181 --topic myTopic --describe

echo 'logs container spring_kafka...'
docker logs -f -t spring_kafka