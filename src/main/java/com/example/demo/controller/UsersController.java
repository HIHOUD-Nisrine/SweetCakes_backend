package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersRepository UsersRepository;

    // get all demandd
    @PostMapping("/login")
	public boolean login(@RequestBody Users user){
		
		Optional<Users> userLogin = UsersRepository.getUserByUsernameAndPassword(user.getUsername(),user.getPassword());
		if( userLogin.isPresent()){
			//rederect to home
			return true;
		}
		return false;
	}
}
