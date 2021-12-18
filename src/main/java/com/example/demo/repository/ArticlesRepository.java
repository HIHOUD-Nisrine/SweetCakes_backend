package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.model.Articles;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long> {

    // @Query("select a from articles a where a.demand.id_demand =?1 ")
    @Query(value = "SELECT * FROM articles WHERE id_demand = ?1 ", nativeQuery = true)
    List<Articles> getArticlesByDemandId(Long id_demand);
}