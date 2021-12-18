package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Articles;
import com.example.demo.repository.ArticlesRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class ArticlesController {
	@Autowired
	private ArticlesRepository articlesRepository;

	// add articles to database
	@PostMapping("/articles/add")
	public ResponseEntity<Map<String, Boolean>> addArticles(@RequestBody Articles article) {

		articlesRepository.save(article);
		Map<String, Boolean> response = new HashMap<>();
		response.put("added", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/cakes_demands/{id}/articles")
	public ResponseEntity<List<Articles>> getDemandsById(@PathVariable Long id) {
		List<Articles> articles = articlesRepository.getArticlesByDemandId(id);
		return ResponseEntity.ok(articles);
	}

}
