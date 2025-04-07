package com.example.demo.Service;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.User;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public Booking createBooking(Long userId, Booking booking) {
        return userRepository.findById(userId).map(user -> {
            booking.setUser(user);
            return bookingRepository.save(booking);
        }).orElse(null);
    }
    
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }
    
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
    
    public Booking updateBooking(Long id, Booking bookingDetails) {
        return bookingRepository.findById(id)
            .map(booking -> {
                booking.setBookingDate(bookingDetails.getBookingDate());
                booking.setDescription(bookingDetails.getDescription());
                return bookingRepository.save(booking);
            })
            .orElseGet(() -> {
                bookingDetails.setId(id);
                return bookingRepository.save(bookingDetails);
            });
    }
    
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}