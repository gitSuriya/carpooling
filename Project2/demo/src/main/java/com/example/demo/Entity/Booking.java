package com.example.demo.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime bookingDate;
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    
    // Constructors, getters, and setters
    public Booking() {}
    public Booking(LocalDateTime bookingDate, String description) {
        this.bookingDate = bookingDate;
        this.description = description;
    }

    public Long getId() { return id; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public String getDescription() { return description; }
    public User getUser() { return user; }
    
    public void setId(Long id) { this.id = id; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }
    public void setDescription(String description) { this.description = description; }
    public void setUser(User user) { this.user = user; }
}