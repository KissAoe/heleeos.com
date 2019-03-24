#/bin/bash

/usr/sbin/nginx

export DOCKER_HOST_IP=$(route -n | awk '/UG[ \t]/{print $2}')

export MYSQL_HOST=$DOCKER_HOST_IP

java -jar /app/heleeos-blog-server.jar