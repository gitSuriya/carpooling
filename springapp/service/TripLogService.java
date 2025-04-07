package com.examly.springapp.service;

import com.examly.springapp.Entity.TripLog;
import com.examly.springapp.Repository.TripLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripLogService {

    @Autowired
    private TripLogRepository tripLogRepository;

    public List<TripLog> getAllTripLogs() {
        return tripLogRepository.findAll();
    }

    public Optional<TripLog> getTripLogById(Long id) {
        return tripLogRepository.findById(id);
    }

    public List<TripLog> createTripLog(List<TripLog> tripLog) {
        return tripLogRepository.saveAll(tripLog);
    }

    public TripLog updateTripLog(Long id, TripLog tripLogDetails) {
        TripLog tripLog = tripLogRepository.findById(id).orElseThrow(() -> new RuntimeException("TripLog not found"));

        tripLog.setTripId(tripLogDetails.getTripId());
        tripLog.setDriverId(tripLogDetails.getDriverId());
        tripLog.setPassengerId(tripLogDetails.getPassengerId());
        tripLog.setSource(tripLogDetails.getSource());
        tripLog.setDestination(tripLogDetails.getDestination());
        tripLog.setRouteTaken(tripLogDetails.getRouteTaken());
        tripLog.setLocationCoordinates(tripLogDetails.getLocationCoordinates());
        tripLog.setConversationLogs(tripLogDetails.getConversationLogs());
        tripLog.setTripStartTime(tripLogDetails.getTripStartTime());
        tripLog.setTripEndTime(tripLogDetails.getTripEndTime());
        tripLog.setFare(tripLogDetails.getFare());
        tripLog.setPaymentStatus(tripLogDetails.getPaymentStatus());
        tripLog.setroute(tripLogDetails.getroute());
        return tripLogRepository.save(tripLog);
    }

    public void deleteTripLog(Long id) {
        tripLogRepository.deleteById(id);
    }
    public List<TripLog> getTripLogsByLocation(String location) {
        return tripLogRepository.findByLocation(location);
    }
}

  