package main.model.entities;


import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name="products$")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="descr")
    private String description;

    @Column(name="qty")
    private Float quantity;

    @Column(name="price")
    private Float price;

    @Column(name="active")
    private Boolean active;


    public Product(){

    }

    public Product(Long id, String description, Float quantity, Float price, Boolean active) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.active = active;
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

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
