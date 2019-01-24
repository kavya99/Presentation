package io.github.kavya99.employees;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByLastName(String lastName);
}

/*
   It extends CrudRepository and hence inherits several methods for working with Employee entity.
   The generic parameters are entity type and ID.
   Spring Data JPA allows us to define other query methods as well e.g. findByLastName in our case.
   We don’t have to write an implementation of the repository interface as Spring Data JPA
   creates an implementation on the fly when we run the application. That makes Spring JPA so powerful.
*/