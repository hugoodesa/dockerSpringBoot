FROM openjdk
WORKDIR /app
COPY ./target/*.jar app.jar
ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 9000
CMD ["java","-jar","app.jar"]
