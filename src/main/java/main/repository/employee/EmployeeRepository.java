package main.repository.employee;

import main.model.EmployeeInfo;
import main.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee_info$v", nativeQuery = true)
    List<EmployeeInfo> getEmployeesInfo();
}