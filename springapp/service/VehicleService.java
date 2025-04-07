package com.examly.springapp.service;

import com.examly.springapp.Entity.Vehicle;
import com.examly.springapp.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

 
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

  
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

   
    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setMake(vehicleDetails.getMake());
        vehicle.setYear(vehicleDetails.getYear());
        vehicle.setRegistrationNumber(vehicleDetails.getRegistrationNumber());

        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}

   