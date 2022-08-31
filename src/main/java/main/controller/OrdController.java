package main.controller;


import main.model.*;
import main.model.entities.Ord;
import main.model.entities.OrdStatus;
import main.model.entities.OrderOriginSource;
import main.repository.ord.OrdRepository;
import main.repository.ord.OrdStatusRepository;
import main.repository.ord.OrderSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://employee-management-starba.netlify.app/")
@RestController
@RequestMapping("api/v1/orders/")
public class OrdController {

    @Autowired
    private OrdRepository ordRepository;

    @Autowired
    private OrdStatusRepository ordStatusRepository;

    @Autowired
    private OrderSourceRepository orderSourceRepository;


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
        try{
            Ord ordCreated = ordRepository.save(ord);
            return "{ \"lastOrd\" : " + ordCreated.getOrd() +" }";
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return "{ \"Status\" : \"FAIL \" }";
        }}


    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<Ord> updateEmployee(@PathVariable Long id, @RequestBody Ord ord){
        Optional<Ord> e = ordRepository.findById(id);

        ordRepository.save(ord);

        return ResponseEntity.ok(ord);
    }

    @GetMapping("/allInfoOrders")
    public List<OrderInfo> getInfo(){
        return ordRepository.getOrdersInfo();
    }

    @GetMapping("/allOrderSources")
    public List<OrderOriginSource> getOrderSources(){
        return orderSourceRepository.findAll();
    }


    @GetMapping("/processOrder/{ord}")
    public void processOrder(@PathVariable Long ord){
        ordRepository.processOrder(ord);
    }

    @GetMapping("/confirmOrder/{ord}")
    public void confirmOrder(@PathVariable Long ord){
        ordRepository.confirmOrder(ord);
    }


    @GetMapping("/lastOrd")
    public OrdLastId getLastOrd(){
        return ordRepository.getLastOrd();
    }
}
