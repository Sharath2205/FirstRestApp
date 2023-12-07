FROM tomcat:8.5-jre8

RUN rm -rf /usr/local/tomcat/webapps/*
RUN mvn clean install

COPY first-rest-app.war /usr/local/tomcat/webapps/

EXPOSE 8095

CMD ["java", "-jar", "target/first-rest-app.jar"]