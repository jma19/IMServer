#!/bin/bash
mvn clean install -DskipTests=true
cd target
mv RegisterService-0.0.1-SNAPSHOT.war RegisterService.war
scp RegisterService.war root@120.25.79.100:/home/apache-tomcat-8.0.32/webapps