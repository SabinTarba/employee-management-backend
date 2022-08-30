package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ord_status$")
public class OrdStatus {

    @Id
    private String id;

    @Column(name = "descr")
    private String descr;

    public OrdStatus(){

    }
    public OrdStatus(String id, String descr) {
        this.id = id;
        this.descr = descr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
