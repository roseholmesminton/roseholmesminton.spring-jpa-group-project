package com.wcci.springjpagroupproject;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository <Employee, Long>{

    Optional<Employee> findByLastName(String lastName);
}
