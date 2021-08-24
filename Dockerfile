FROM openjdk:8
ADD target/recipes-mysql.jar recipes-mysql.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","recipes-mysql.jar"]
