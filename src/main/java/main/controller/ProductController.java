package main.controller;


import main.model.entities.Product;
import main.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/products/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() { return productRepository.findAll(); }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }

    @GetMapping("/toggleActive/{id}/{activeOption}")
    public void toggleActive(@PathVariable(name = "id") Long id, @PathVariable(name = "activeOption") Boolean activeOption){

        productRepository.toggleActive(id, activeOption);
    }

    @PostMapping("/createProduct")
    public String createProduct(@RequestBody Product prod) {
        try {
            productRepository.save(prod);
            return "{ \"Status\" : \"SUCCESS\" }";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "{ \"Status\" : \"FAIL \" }";
        }
    }


    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody Product prod){

        Product p = productRepository.findById(prod.getId()).orElseThrow();
        p.setQuantity(prod.getQuantity());

        productRepository.save(p);
    }
}
