FROM tomcat:10.1-jdk21

COPY target/java-web-app*.war  /usr/local/tomcat/webapps/java-web-app.war
