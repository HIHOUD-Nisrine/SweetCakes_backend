package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.example.demo.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long >{

    // @Query("select u from Users u where u.user_name =?1  and u.password =?2")
    @Query(value = "SELECT * FROM Users WHERE username =?1  and password =?2 ", nativeQuery = true)
    Optional<Users> getUserByUsernameAndPassword(String username, String password);
}
