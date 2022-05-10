package it.lucianofilippucci.zgest.controllers;

import it.lucianofilippucci.zgest.entities.Employee;
import it.lucianofilippucci.zgest.helper.exceptions.EntityAlreadyExist;
import it.lucianofilippucci.zgest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/new")
    public ResponseEntity newEmployee(@RequestBody Employee employee) {
        try {
            Employee newEmp = employeeService.newEmployee(employee);
            return new ResponseEntity(newEmp, HttpStatus.OK);
        } catch(EntityAlreadyExist e) {
            return new ResponseEntity(e.getErrorCode().toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}
