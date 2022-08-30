package main.model.entities;

import javax.persistence.*;

@Entity
@Table(name="ord_origin_source$")
public class OrderOriginSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="descr")
    private String description;

    public OrderOriginSource(){

    }

    public OrderOriginSource(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
