#!/bin/bash

# Starting Axon Server
echo "Starting Axon Server..."
cd /Users/aurel/Dev/servers/axon
java -jar axonserver.jar &

# Starting Zookeeper
echo "Starting Zookeeper..."
cd /Users/aurel/Dev/servers/kafka
bin/zookeeper-server-start.sh config/zookeeper.properties &

# Starting Kafka Server
echo "Starting Kafka Server..."
bin/kafka-server-start.sh config/server.properties &
