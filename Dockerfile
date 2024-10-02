FROM tomcat:9.0-jdk11

WORKDIR /usr/local/tomcat/webapps/

COPY target/LateShipmentProject.war .

RUN sed -i 's/8080/8081/g' /usr/local/tomcat/conf/server.xml

EXPOSE 8081

CMD ["catalina.sh", "run"]
