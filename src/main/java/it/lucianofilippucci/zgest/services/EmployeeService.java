package it.lucianofilippucci.zgest.services;

import it.lucianofilippucci.zgest.entities.Employee;
import it.lucianofilippucci.zgest.helper.exceptions.EntityAlreadyExist;
import it.lucianofilippucci.zgest.helper.exceptions.EntityNotFound;
import it.lucianofilippucci.zgest.helper.exceptions.ErrorCodes;
import it.lucianofilippucci.zgest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED )
    public Employee newEmployee(Employee employee) throws EntityAlreadyExist {
        if(employeeRepository.existsEmployeeByEmployeeIdAndNameAndLastName(employee.getEmployeeId(), employee.getName(), employee.getLastName())) throw new EntityAlreadyExist(ErrorCodes.ERROR_ENTITY_ALREADY_EXIST, "Employee");
        return employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public Employee getEmployeeByEmpId(Long id) throws EntityNotFound {
        Employee emp = employeeRepository.getById(id);
        if(emp.getEmployeeId() == null) throw new EntityNotFound();
        return emp;
    }

}
