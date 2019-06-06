FROM maven:3.6.1-jdk-8 as builder

RUN mkdir /root/.m2/
ADD settings.xml /root/.m2/
RUN mkdir /opt/source/
WORKDIR /opt/source/
ADD eureka-service ./eureka
WORKDIR /opt/source/eureka/
RUN mvn clean package spring-boot:repackage

FROM java:8-jre-alpine
RUN mkdir -p /opt/eureka/config
WORKDIR /opt/eureka
COPY --from=builder /opt/source/eureka/target/eureka-service-0.0.1-SNAPSHOT.jar ./eureka.jar

VOLUME [ "/opt/eureka/config" ]
EXPOSE 8761
CMD [ "java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/eureka/eureka.jar" ]