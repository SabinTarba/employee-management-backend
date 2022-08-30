package main.controller;


import main.model.Employee;
import main.model.Ord;
import main.model.OrdStatus;
import main.repository.OrdRepository;
import main.repository.OrdStatusRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/orders/")
public class OrdController {

    @Autowired
    private OrdRepository ordRepository;

    @Autowired
    private OrdStatusRepository ordStatusRepository;


    @GetMapping("allOrders")
    private List<Ord> getAllOrders(){
        return ordRepository.findAll();
    }

    @GetMapping("allStatus")
    private List<OrdStatus> getAllStatus(){
        return ordStatusRepository.findAll();
    }

    @DeleteMapping("deleteOrder/{id}")
    private void deleteOrder(@PathVariable Long id){
        ordRepository.deleteById(id);
    }

    @PostMapping("createOrder")
    private String createOrder(@RequestBody Ord ord){
        System.out.println(ord.getOrd());
        try{
            ordRepository.save(ord);
            return "{ \"Status\" : \"SUCCESS\" }";
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return "{ \"Status\" : \"FAIL \" }";
        }}
}
