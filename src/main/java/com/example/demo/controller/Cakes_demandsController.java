package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.model.cakes_demands;
import com.example.demo.repository.Cakes_demandsRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class Cakes_demandsController {
	@Autowired
	private Cakes_demandsRepository cakes_demandsRepository;

	// add demands to database
	@PostMapping("/cakes_demand/add")
	public cakes_demands postMethodName(@RequestBody cakes_demands offer) {
		return cakes_demandsRepository.save(offer);
	}

	// get the last id of demands and return to the front
	@GetMapping("/cakes_demand/recentOne")
	public Long getRecentDemandsId() {
		return cakes_demandsRepository.findDemand();
	}

	// gett all demands :
	@GetMapping("/cakes_demands")
	public List<cakes_demands> getAllOffers() {
		return cakes_demandsRepository.findAll();
	}

	@PostMapping("cakes_demands/{id}/update")
	public ResponseEntity<cakes_demands> updateOldDemand(@PathVariable Long id, @RequestBody cakes_demands cakeDemand) {

		System.out.println("cakeDemand =====================> " + cakeDemand.getId_demand());
		cakes_demands OldcakeDemand = cakes_demandsRepository.findById(id).orElseThrow();
		OldcakeDemand.setStatut(cakeDemand.getStatut());
		OldcakeDemand.setNotes(cakeDemand.getNotes());
		cakes_demands updatedOldcakeDemand = cakes_demandsRepository.save(OldcakeDemand);
		return ResponseEntity.ok(updatedOldcakeDemand);
	}
	@PostMapping("cakes_demands/{id}/updates")
	public ResponseEntity<cakes_demands> updateOldDemands(@PathVariable Long id, @RequestBody cakes_demands cakeDemand) {

		System.out.println("cakeDemand =====================> " + cakeDemand.getId_demand());
		cakes_demands OldcakeDemand = cakes_demandsRepository.findById(id).orElseThrow();
		OldcakeDemand.setPrix(cakeDemand.getPrix());
		cakes_demands updatedOldcakeDemand = cakes_demandsRepository.save(OldcakeDemand);
		return ResponseEntity.ok(updatedOldcakeDemand);
	}
}
