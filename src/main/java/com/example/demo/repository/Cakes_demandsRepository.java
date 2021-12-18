package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.cakes_demands;

@Repository
public interface Cakes_demandsRepository extends JpaRepository<cakes_demands, Long> {

	@Query(value = "SELECT id_demand FROM cakes_demands WHERE id_demand=(SELECT max(id_demand) FROM cakes_demands)", nativeQuery = true)
	Long findDemand();
}
