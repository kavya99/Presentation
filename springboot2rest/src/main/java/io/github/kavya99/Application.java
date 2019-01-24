package io.github.kavya99;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.kavya99.employees.Employee;
import io.github.kavya99.employees.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Employee("Jack", "Bauer"));
            repository.save(new Employee("Chloe", "O'Brian"));
            repository.save(new Employee("Kim", "Bauer"));
            repository.save(new Employee("David", "Palmer"));
            repository.save(new Employee("Michelle", "Dessler"));

            // fetch all employees
            log.info("Employees found with findAll():");
            log.info("-------------------------------");
            for (Employee employee : repository.findAll()) {
                log.info(employee.toString());
            }
            log.info("");

            // fetch an individual employee by ID
            repository.findById(1L)
                    .ifPresent(employee -> {
                        log.info("Employee found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(employee.toString());
                        log.info("");
                    });

            // fetch employees by last name
            log.info("Employee found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }
}

/*

The @SpringBootApplication annotation adds all of the following:
    a) @Configuration tags the class as a source of bean definitions for the application context.
    b) @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
    c) Normally we would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a
    DispatcherServlet.
    d) @ComponentScan tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.

Application includes a main() method that puts the EmployeeRepository through a few tests. First, it fetches the EmployeeRepository from the Spring application context. Then it saves a handful of Employee objects, demonstrating the save() method
and setting up some data to work with. Next, it calls findAll() to fetch all Employees from the database. Then it calls findOne() to fetch a single Employee by its ID. Finally, it calls findByLastName() to find all employees whose last name
is "Bauer".

Reference: https://spring.io/guides/gs/accessing-data-jpa/
*/