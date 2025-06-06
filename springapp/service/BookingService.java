package com.examly.springapp.service;

import com.examly.springapp.Entity.Booking;
import com.examly.springapp.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
        }

        public Booking createBooking(Booking booking) {
            return bookingRepository.save(booking);
        }

        public Booking updateBooking(Long id, Booking bookingDetails) {
            Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
            
            booking.setUserId(bookingDetails.getUserId());
            booking.setVehicleId(bookingDetails.getVehicleId());
            booking.setBookingDate(bookingDetails.getBookingDate());
            booking.setReturnDate(bookingDetails.getReturnDate());
            booking.setStatus(bookingDetails.getStatus());
            
            return bookingRepository.save(booking);
        }
        
        public void deleteBooking(Long id) {
            bookingRepository.deleteById(id);
        }
    }

       