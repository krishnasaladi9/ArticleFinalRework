FROM java:8
EXPOSE 8080
ADD finalrework.jar finalrework.jar
ENTRYPOINT ["java", "-jar", "finalrework.jar"]