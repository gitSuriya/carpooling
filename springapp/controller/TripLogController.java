package com.examly.springapp.controller;

import com.examly.springapp.Entity.TripLog;
import com.examly.springapp.Service.TripLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/triplog")
public class TripLogController {

    @Autowired
    private TripLogService tripLogService;

    @GetMapping("/get")
    public List<TripLog> getAllTripLogs() {
        return tripLogService.getAllTripLogs();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TripLog> getTripLogById(@PathVariable Long id) {
        return tripLogService.getTripLogById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/add")
    public List<TripLog> createTrip(@RequestBody List<TripLog> trips) {
        return tripLogService.createTripLog(trips);
    }
    

    @PutMapping("/put/{id}")
    public ResponseEntity<TripLog> updateTripLog(@PathVariable Long id, @RequestBody TripLog tripLogDetails) {
        return ResponseEntity.ok(tripLogService.updateTripLog(id, tripLogDetails));
    }

    @DeleteMapping("/del/{id}")
    public String deleteTripLog(@PathVariable Long id) {
        tripLogService.deleteTripLog(id);
        return "TripLog deleted successfully";
    }
    @GetMapping("/search")
    public List<TripLog> getTripLogsByLocation(@RequestParam String location) {
        return tripLogService.getTripLogsByLocation(location);
    }
}  