FROM openjdk:11
COPY ./target/ums.jar ums.jar
CMD ["java","-jar","ums.jar"]