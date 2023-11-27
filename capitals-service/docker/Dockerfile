FROM bitnami/java:17.0.7-7-debian-11-r21
WORKDIR /opt/capitals-service
ENV JAVA_OPTS ""
EXPOSE 8000
COPY ../target/capitals-service-0.0.1-SNAPSHOT.jar /opt/capitals-service/capitals-service-0.0.1-SNAPSHOT.jar
CMD java ${JAVA_OPTS} -jar capitals-service-0.0.1-SNAPSHOT.jar