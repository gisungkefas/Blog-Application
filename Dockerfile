FROM openjdk:17
EXPOSE 8080
ADD target/blog-app-week-nine.jar blog-app-week-nine.jar
ENTRYPOINT ["java", "-jar", "/blog-app-week-nine.jar"]