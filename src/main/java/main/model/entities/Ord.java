package main.model.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="ord$")
public class Ord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ord")
    private Long ord;

    @Column(name="dt")
    private LocalDate dt;

    @Column(name="employee_id")
    private Long employeeId;

    @Column(name="status")
    private String status;

    @Column(name = "origin")
    private Long origin;

    public Ord(){

    }

    public Ord(Long ord, LocalDate dt, Long employeeId, String status, Long origin) {
        this.ord = ord;
        this.dt = dt;
        this.employeeId = employeeId;
        this.status = status;
        this.origin = origin;
    }

    public Long getOrigin() {
        return origin;
    }

    public void setOrigin(Long origin) {
        this.origin = origin;
    }

    public Long getOrd() {
        return ord;
    }

    public void setOrd(Long ord) {
        this.ord = ord;
    }

    public LocalDate getDt() {
        return dt;
    }

    public void setDt(LocalDate dt) {
        this.dt = dt;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
