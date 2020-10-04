FROM gradle:6.5-jdk11 as builder

USER root
COPY . .
RUN gradle build -i -x test && chmod +x ./docker-entrypoint.sh


FROM openjdk:11.0.7-jre-slim

WORKDIR /cv

EXPOSE 9093

COPY --from=builder /home/gradle/build/libs/*.jar /cv/cv.jar
COPY --from=builder /home/gradle/docker-entrypoint.sh /cv/cv.sh

ENV MARIADB_URI jdbc:mariadb://mariadb:3306/cv
ENV MARIADB_USERNAME cv
ENV MARIADB_PASSWORD cv

ENTRYPOINT [ "/cv/cv.sh" ]