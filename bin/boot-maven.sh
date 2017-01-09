#!/bin/sh

# Generate Spring Boot skeleton project.
#
# Include actuator and devtools.
#
# To see all options run 'curl https://start.spring.io'
#
curl https://start.spring.io/starter.zip \
  -d type=maven-project \
  -d applicationName="Couchbase" \
  -d packageName="jp.bikon" \
  -d groupId="jp.bikon" -d name="Couchbase" -d artifactId="couchbase" \
  -d description="Spring Data Couchbase" \
  -d dependencies=web,data-couchbase,actuator,devtools \
  -d version="0.1.0-SNAPSHOT" \
  -d javaVersion="1.8" \
  | tar -xzvf -
