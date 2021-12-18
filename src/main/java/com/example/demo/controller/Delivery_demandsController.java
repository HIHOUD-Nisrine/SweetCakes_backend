package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Delivery_demands;
import com.example.demo.repository.Delivery_demandsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class Delivery_demandsController {

    @Autowired
    private Delivery_demandsRepository delivery_demandsRepository;

    // get all demandd
    @GetMapping("/delivery_demands")
    public List<Delivery_demands> getAllOffers() {
        return delivery_demandsRepository.findAll();
    }

    // add demands to database
    @PostMapping("/delivery_demands/add")
    public Delivery_demands postMethodName(@RequestBody Delivery_demands demand) {
        return delivery_demandsRepository.save(demand);
    }

    @PostMapping("delivery_demands/{id}/update")
    public ResponseEntity<Delivery_demands> updateOldDemand(@PathVariable Long id,
            @RequestBody Delivery_demands deliveryDemand) {

        System.out.println("deliveryDemand =====================> " + deliveryDemand.getId_demand());
        Delivery_demands OlddeliveryDemand = delivery_demandsRepository.findById(id).orElseThrow();
        OlddeliveryDemand.setStatut(deliveryDemand.getStatut());
        OlddeliveryDemand.setNotes(deliveryDemand.getNotes());
        Delivery_demands updatedOlddeliveryDemand = delivery_demandsRepository.save(OlddeliveryDemand);
        return ResponseEntity.ok(updatedOlddeliveryDemand);
    }

}
