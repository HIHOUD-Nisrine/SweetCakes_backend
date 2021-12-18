package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Delivery_demands;

@Repository
public interface Delivery_demandsRepository extends JpaRepository<Delivery_demands, Long >{

}
