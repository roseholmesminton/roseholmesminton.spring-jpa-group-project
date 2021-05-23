package com.wcci.springjpagroupproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.annotation.Resource;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class JpaWiring {
    @Autowired
    private TestEntityManager entityManager;
    @Resource
    private AddressRepository addressRepo;
    @Resource
    private EmployeeRepository employeeRepo;
    @Resource
    private ProjectRepository projectRepo;

    @Test
    public void employeeShouldReturnOneEmployees() {
        Employee employee1 = new Employee("Bozo", "the", "Clown", "Esq");
        employeeRepo.save(employee1);



        Optional<Employee> foundEmployeeOpt = employeeRepo.findByLastName(employee1.getLastName());
        Employee foundEmployee = foundEmployeeOpt.get();
        assertThat(foundEmployee.getLastName()).contains("Clown");

        entityManager.flush();
        entityManager.clear();
    }

}
