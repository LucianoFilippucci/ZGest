package it.lucianofilippucci.zgest.repositories;

import it.lucianofilippucci.zgest.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsEmployeeByEmployeeIdAndNameAndLastName(Long id, String name, String lastName);
}
