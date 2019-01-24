# springboot2rest
Simple Spring Boot 2.0 Application with simple Rest api and Docker support 

There are various ways to [run](https://dzone.com/articles/five-ways-of-running-spring-boot-application) spring boot applications.

## Running via maven plugin:
mvn sprint-boot:run

## Package into executable jar:
mvn clean package

## Deploying into Docker container
1. Create executable jar
2. Build image: docker build -t spring-boot2-docker .
3. Run the image: docker run -p 8085:8085 spring-boot2-docker

## Testing via postman: 
GET:http://localhost:8085/employees
