package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.model.Posts;
import com.example.demo.repository.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class PostsController {
	@Autowired
	private PostsRepository postsRepository;
	private static String imageDirectory = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";

	// get all Posts
	@GetMapping("/posts")
	public List<Posts> getAllPosts() {
		return postsRepository.findAll();
	}

	// get all Posts
	@GetMapping("/post/{id}")
	public Optional<Posts> getPostById(@PathVariable Long id) {
		return postsRepository.findById(id);
	}

	// add post to database
	@PostMapping(value = "/posts/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Map<String, Boolean>> addPost(@RequestParam("image") MultipartFile file,
			@RequestParam("categorie") String categorie, @RequestParam("evenement") String evenement,
			@RequestParam("prix") int prix, @RequestParam("poids") float poids,
			@RequestParam("nombre_part") int nombre_part,
			@RequestParam("gout") String gout, @RequestParam("pack_ou_unite") String pack_ou_unite,
			@RequestParam("nombre_unite_dispo") int nombre_unite_dispo, @RequestParam("dispo") Boolean dispo,
			@RequestParam("description") String description, @RequestParam("type_pate") String type_pate) {

		System.out.println("categorie : " + categorie + " evenement : " + evenement +
				" prix : " + prix + " poids : " + poids + " nombre_part : " + nombre_part + " gout : " + gout
				+ " pack_ou_unite : " + pack_ou_unite + " nombre_unite_dispo : " + nombre_unite_dispo +
				" dispo : " + dispo);

		// image traitement
		// 1- extract extention
		int index = file.getOriginalFilename().lastIndexOf('.');
		String ext = file.getOriginalFilename().substring(index + 1);

		// 2- create unique name
		int randomNumber = (int) Math.floor(Math.random() * 1000);
		String newImageName = java.util.Calendar.getInstance().getTime().getTime() + "-" + randomNumber + "." + ext;

		// 3- store name to data base and store file in right folder
		makeDirectoryIfNotExist(imageDirectory);
		Path fileNamePath = Paths.get(imageDirectory, newImageName);

		Map<String, Boolean> response = new HashMap<>();

		Posts post = new Posts(categorie, evenement, prix, poids, nombre_part, newImageName,
				gout, pack_ou_unite, nombre_unite_dispo, dispo, description, type_pate);

		try {
			Files.write(fileNamePath, file.getBytes());
			postsRepository.save(post);
			response.put("inserted", true);
			return ResponseEntity.ok(response);
		} catch (IOException ex) {
			System.out.println(">>>>>>>>>>>>>> image error :  " + ex);
			response.put("inserted", false);
			return ResponseEntity.ok(response);
		}
	}

	// update image post
	@PutMapping(value = "post/{id}/update/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Posts> updatePostImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {

		Posts myPost = postsRepository.findById(id).orElseThrow();

		// image traitement
		// 1- extract extention
		int index = file.getOriginalFilename().lastIndexOf('.');
		String ext = file.getOriginalFilename().substring(index + 1);

		// 2- create unique name
		int randomNumber = (int) Math.floor(Math.random() * 1000);
		String newImageName = java.util.Calendar.getInstance().getTime().getTime() + "-" + randomNumber + "." + ext;

		// 3- store name to data base and store file in right folder
		makeDirectoryIfNotExist(imageDirectory);
		Path fileNamePath = Paths.get(imageDirectory, newImageName);

		myPost.setImage(newImageName);

		try {
			Files.write(fileNamePath, file.getBytes());
			postsRepository.save(myPost);
			return ResponseEntity.ok(myPost);
		} catch (IOException ex) {
			System.out.println(">>>>>>>>>>>>>> image error :  " + ex);
			return ResponseEntity.ok(myPost);
		}
	}

	// add post to database
	@PutMapping("post/{id}/update")
	public ResponseEntity<Posts> updatePost(@PathVariable Long id,
			@RequestParam("categorie") String categorie, @RequestParam("evenement") String evenement,
			@RequestParam("prix") int prix, @RequestParam("poids") float poids,
			@RequestParam("nombre_part") int nombre_part,
			@RequestParam("gout") String gout, @RequestParam("pack_ou_unite") String pack_ou_unite,
			@RequestParam("nombre_unite_dispo") int nombre_unite_dispo, @RequestParam("dispo") Boolean dispo,
			@RequestParam("description") String description, @RequestParam("type_pate") String type_pate) {

		Posts myPost = postsRepository.findById(id).orElseThrow();

		myPost.setCategorie(categorie);
		myPost.setEvenement(evenement);
		myPost.setPrix(prix);
		myPost.setPoids(poids);
		myPost.setNombre_part(nombre_part);
		myPost.setGout(gout);
		myPost.setPack_ou_unite(pack_ou_unite);
		myPost.setNombre_unite_dispo(nombre_unite_dispo);
		myPost.setDispo(dispo);
		myPost.setDescription(description);
		myPost.setType_pate(type_pate);

		System.out.println("categorie : " + categorie + " evenement : " + evenement +
				" prix : " + prix + " poids : " + poids + " nombre_part : " + nombre_part + " gout : " + gout
				+ " pack_ou_unite : " + pack_ou_unite + " nombre_unite_dispo : " + nombre_unite_dispo +
				" dispo : " + dispo);

		Posts updatedPost = postsRepository.save(myPost);
		return ResponseEntity.ok(updatedPost);
	}

	// method to create the upload image folder if doesnt exist
	private void makeDirectoryIfNotExist(String imageDirectory) {
		File directory = new File(imageDirectory);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

	//delete a post from database
	@DeleteMapping("/post/{id}/delete")
	public ResponseEntity<Map<String, Boolean>> deleteOffer(@PathVariable long id) {
        postsRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}

