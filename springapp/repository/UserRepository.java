package com.examly.springapp.repository;

import com.examly.springapp.Entity.User;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 

public interface UserRepository extends JpaRepository<User, Long> {
   
   Page<User> findAll(Pageable pageable); 
   @Query("SELECT u FROM User u WHERE u.username LIKE :prefix%")
   List<User> getUsersStartingWith(@Param("prefix") String prefix);
   List<User> findByUsername(String username);
   List<User> findByEmail(String email);
}

