FROM amazoncorretto:17
LABEL maintainer="https://github.com/itiszakk"
EXPOSE 8080
VOLUME /application
ADD build/libs/telegrambot-0.0.1.jar telegrambot.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/telegrambot.jar"]