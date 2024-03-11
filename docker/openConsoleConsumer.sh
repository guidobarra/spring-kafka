#!/bin/bash

#consumer
echo 'reading topic myTopic, consumer...'
docker exec -it kafka_1 kafka-console-consumer --bootstrap-server kafka_1:29092,kafka_2:29093,kafka_3:29094,kafka_4:29095,kafka_5:29096 --topic myTopic --group my_group_demo_00 --from-beginning
