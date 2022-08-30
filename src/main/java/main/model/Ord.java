package main.model;

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

    public Ord(){

    }

    public Ord(Long ord, String dt, Long employeeId, String status) {
        this.ord = ord;
        this.dt = LocalDate.parse(dt);
        this.employeeId = employeeId;
        this.status = status;
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
