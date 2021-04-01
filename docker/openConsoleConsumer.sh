#!/bin/bash

#consumer
echo 'reading topic myTopic, consumer'
docker exec -it kafka_1 kafka-console-consumer --bootstrap-server kafka_1:29092 --topic myTopic --group my_group_demo_00 --from-beginning
