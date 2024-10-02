FROM tomcat:9.0-jdk11

COPY /var/lib/jenkins/workspace/Dev/target/LateShipmentProject.war /usr/local/tomcat/webapps/

RUN sed -i 's/8080/8081/g' /usr/local/tomcat/conf/server.xml

EXPOSE 8081

CMD ["catalina.sh", "run"]
