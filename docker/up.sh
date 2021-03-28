#!/bin/bash

#create containers zookeeper and kafka
docker-compose -f zk-single-kafka-multiple-5.yml up -d

sleep 10

#create topic myTopic
echo 'creating topic myTopic'
docker exec -it kafka_1 kafka-topics \
                      --zookeeper zookeeper_1:2181 \
                      --create --topic myTopic \
                      --replication-factor 3 \
                      --partitions 3 \
                      --if-not-exists

sleep 2
#producer
echo 'writing topic myTopic, producer'
docker exec -it kafka_1 kafka-console-producer --broker-list kafka_1:29092 --topic myTopic
