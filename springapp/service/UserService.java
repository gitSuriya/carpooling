package com.examly.springapp.service;

import com.examly.springapp.Entity.User;
import com.examly.springapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
    public List<User> createUser(List<User> user) {
        // if (user.getId() != null && userRepository.existsById(user.getId())) {
        //     throw new IllegalArgumentException("User with ID already exists! Use PUT to update.");
        // }
        return userRepository.saveAll(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    
    public Page<User> getUsersWithPaginationAndSorting(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository.findAll(pageable);
    }
    
    public List<User> getUserStartingletter(String l) {
        return userRepository.getUsersStartingWith(l);
    }
    public List<User> getUsersByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public List<User> getUsersByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}

