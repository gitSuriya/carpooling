package com.example.demo.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference 
    private List<Booking> bookings = new ArrayList<>();
    
    // Constructors, getters, and setters
    public User() {}
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Booking> getBookings() { return bookings; }
    
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    
    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setUser(this);
    }
}