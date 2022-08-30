package main.repository.employee;

import main.model.entities.EmployeeFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeFunctionRepository extends JpaRepository<EmployeeFunction, String> {
}
