FROM bitnami/java:17.0.7-7-debian-11-r21
WORKDIR /opt/countries-service
ENV JAVA_OPTS ""
EXPOSE 8000
COPY ../target/countries-service-0.0.1-SNAPSHOT.jar /opt/countries-service/countries-service-0.0.1-SNAPSHOT.jar
CMD java ${JAVA_OPTS} -jar countries-service-0.0.1-SNAPSHOT.jar