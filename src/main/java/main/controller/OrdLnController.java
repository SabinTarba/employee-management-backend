package main.controller;


import main.model.entities.OrdLn;
import main.repository.ord.OrdLnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/ordlines/")
public class OrdLnController {

    @Autowired
    OrdLnRepository ordLnRepository;

    @PostMapping("createLine")
    public void createLine(@RequestBody OrdLn ordln){
        ordLnRepository.save(ordln);
    }
}
