#!/bin/bash

#
# This script sets up the environment for the Fyber exercise
# Including:
# 1. Consul (single) server docker, on local network
# 2. Jenkins docker with 2 predefined jobs:
#   a. CI of a consul service (Java) - create a local docker image
#   b. CD of the consul service - run the docker image with the service
# The consul service register itself to the Consul service discovery
# The consul service allows to add and retrieve keys from the Consul

# Assumes:
# 1. Docker installed on the host machine

# Consul server (and agent)
docker run -d -p 8500:8500 -p 8600:8600/udp  --name=consul consul agent -server -ui -node=server-1 -bootstrap-expect=1 -client=0.0.0.0  &
echo "consul is up and running, see UI on http://localhost:8500"
# Browser:
# http://localhost:8500/

# Jenkins
docker run  -d  -p 8080:8080 -p 50000:50000  ittiel/jenkins-fyber:1.0.0 &
echo "jenkins is up and running, see UI http://localhost:8080"
# Browser:
# http://localhost:8080
