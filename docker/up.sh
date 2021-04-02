#!/bin/bash

echo 'create containers zookeeper, cluster kafka and app spring kafka'
docker-compose -f zk-single-kafka-multiple-5.yml up -d
#docker stack deploy --compose-file zk-single-kafka-multiple-5.yml stackdemo