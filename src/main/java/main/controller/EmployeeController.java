package main.controller;

import main.model.EmployeeInfo;
import main.model.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.repository.employee.EmployeeRepository;

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
        employeeRepository.deleteById(id);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable long id){
        Optional<Employee> e = employeeRepository.findById(id);

        return ResponseEntity.ok(e);
    }


    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeUpdated){
        Optional<Employee> e = employeeRepository.findById(id);

        employeeRepository.save(employeeUpdated);

        return ResponseEntity.ok(employeeUpdated);
    }

    @GetMapping("/allInfoEmployees")
    public List<EmployeeInfo> getAllInfoEmployees(){
        return employeeRepository.getEmployeesInfo();
    }



}
