# Start with a base image containing JAVA 8 runtime
FROM openjdk:8

# Add maintainer info (Label is used to add metadata)
LABEL MAINTAINER="gogulakavyareddy@gmail.com"

#Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8085 available to the world outside this container
EXPOSE 8085

# The jar file path of the application
ARG JAR_FILE=target/spring-boot2-docker.jar

# Add the jar to the container
ADD ${JAR_FILE} spring-boot2-docker.jar

# Run the jar file
ENTRYPOINT ["java", "-jar" , "spring-boot2-docker.jar"]

# In the above Dockerfile, we created a mount point with path /tmp because this is where the spring boot application creates working directories for Tomcat by default.
# If we want to store stuff like tomcat access logs, then VOLUMES are very useful.
# More: https://docs.docker.com/storage/volumes/

# Building docker image
# docker build -t spring-boot2-docker .

# Running docker image
# docker run -p 8085:8085 spring-boot2-docker

# Checking API?
# GET:http://localhost:8085/employees