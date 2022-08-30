package main.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import main.model.Employee;
import org.hibernate.FetchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://employee-management-starba.netlify.app/")
@RestController
@RequestMapping("api/v1/employees/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Get all employees REST API
    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //Create employee REST API
    @PostMapping("/createEmployee")
    public String createEmployee(@RequestBody Employee employee){

        try{
            employeeRepository.save(employee);
            return "{ \"Status\" : \"SUCCESS\" }";
        }
        catch(Exception ex) {
            return "{ \"Status\" : \"FAIL\" }";
        }
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable long id){
        Employee e = employeeRepository.findById(id).orElseThrow();

        employeeRepository.deleteById(id);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee e = employeeRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(e);
    }


    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee e = employeeRepository.findById(id).orElseThrow();

        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setEmailId(employee.getEmailId());
        e.setSalary(employee.getSalary());
        e.setHireDate(employee.getHireDate());

        Employee employeeUpdated = employeeRepository.save(e);

        return ResponseEntity.ok(employeeUpdated);
    }

}
