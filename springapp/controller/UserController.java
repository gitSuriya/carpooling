package com.examly.springapp.controller;

import com.examly.springapp.Entity.User;
import com.examly.springapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    
    @PostMapping("/add")
    public List<User> createUser(@RequestBody List<User> user) {
        return userService.createUser(user);
    }
    
    @PutMapping("/put/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }
    
    @DeleteMapping("/del/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Successful";
    }
    
    // @GetMapping("/search")
    // public List<User> Startt(@RequestParam String startingletter) {
        //     return userService.Startt(startingletter);
        // }
        // @GetMapping("/search/{uername}")
        // public List<User> getUsersByUsername(@PathVariable String username) {
            //     return userService.getUsersByUsername(username);
            // }
            // @GetMapping("/search/{email}")
            // public List<User> getUserByEmail(@PathVariable String email)
            // {
                //     return userService.getUsersByEmail(email);
                // }
                
            @GetMapping("/search/id/{id}")
                public ResponseEntity<User> getUserById(@PathVariable Long id) {
                    return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
                }

    @GetMapping("/search")
    public ResponseEntity<?> search(
        @RequestParam(required = false) String username,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String startingletter)
        // @RequestParam(required = false) Long id)
         {

            if (username != null) {
                List<User>users=userService.getUsersByUsername(username);
                return ResponseEntity.ok(users);
            } else if (email != null) {
                List<User>emails=userService.getUsersByEmail(email);
                return ResponseEntity.ok(emails);
            } else if (startingletter != null) {
                List<User>names=userService.getUserStartingletter(startingletter);
                return ResponseEntity.ok(names);
            
            // } else if (id!=null) {
            //     Optional<User> user = userService.getUserById(id);
            //     if (user.isPresent()) {
            //         Long userId = user.get().getId();
            //     }
            }
             else {
                return ResponseEntity.badRequest().body("At least one parameter (username, email, or startingletter) must be provided.");
            }
        } 
     
    @GetMapping("/get/paginated")
    public Page<User> getUsersWithPaginationAndSorting(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction
         )
        { return userService.getUsersWithPaginationAndSorting(page, size, sortBy, direction); }
}

    
    