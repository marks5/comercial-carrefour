FROM gradle:4.10-jdk8-alpine as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build --stacktrace

FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/qrcode-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "qrcode-0.0.1-SNAPSHOT.jar"]