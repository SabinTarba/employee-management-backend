package main.controller;


import main.model.OrderlnInfo;
import main.model.entities.Ord;
import main.model.entities.OrdLn;
import main.repository.ord.OrdLnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "https://employee-management-starba.netlify.app/")
@RestController
@RequestMapping("api/v1/ordlines/")
public class OrdLnController {

    @Autowired
    OrdLnRepository ordLnRepository;

    @PostMapping("createLine")
    public void createLine(@RequestBody OrdLn ordln){
        ordLnRepository.save(ordln);
    }


    @PostMapping("bulkCreateLines")
    public void bulkCreateLines(@RequestBody List<OrdLn> ordlines){
        Long lineCounter = 0L;

        for (OrdLn ordln : ordlines) {
                ordln.setLn(++lineCounter);
        }

        ordLnRepository.saveAllAndFlush(ordlines);
    }

    @GetMapping("getOrderLines/{ord}")
    public List<OrderlnInfo> getOrderLines(@PathVariable long ord){
        return ordLnRepository.getOrderLines(ord);
    }
}
