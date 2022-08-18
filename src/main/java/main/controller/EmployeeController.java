package main.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import main.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import main.repository.EmployeeRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Get all employees REST API
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //Create employee REST API
    @PostMapping("/create_employee")
    public String createEmployee(@RequestBody Employee employee){

       try{
           employeeRepository.save(employee);
           return "{ \"Status\" : \"SUCCESS\" }";
       }
       catch(Exception ex) {
           return "{ \"Status\" : \"FAIL\" }";
       }
    }

}
