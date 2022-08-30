package main.model;

import java.time.LocalDate;

public interface EmployeeInfo {

    Long getId();
    String getFirstName();
    String getLastName();
    String getEmailId();
    Float getSalary();
    LocalDate getHireDate();
    String getFunctionDescription();
}
