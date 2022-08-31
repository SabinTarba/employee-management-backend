package main.model.entities;


import javax.persistence.*;

@Entity
@Table(name="ordln$")
public class OrdLn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="ord")
    private Long ord;

    //generate de trigger
    @Column(name="ln")
    private Long ln;

    @Column(name="product_id")
    private Long productId;

    @Column(name="qty")
    private Float quantity;

    @Column(name="price")
    private Float price;

    public OrdLn(){
    }

    public OrdLn(Long id, Long ord, Long ln, Long productId, Float quantity, Float price) {
        this.id = id;
        this.ord = ord;
        this.ln = ln;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrd() {
        return ord;
    }

    public void setOrd(Long ord) {
        this.ord = ord;
    }

    public Long getLn() {
        return ln;
    }

    public void setLn(Long ln) {
        this.ln = ln;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
}
