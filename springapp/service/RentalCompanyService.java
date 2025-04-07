package com.examly.springapp.service;

import com.examly.springapp.Entity.RentalCompany;
import com.examly.springapp.Repository.RentalCompanyRepository;

import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalCompanyService {

    @Autowired
    private RentalCompanyRepository rentalCompanyRepository;

    public List<RentalCompany> getAllRentalCompany() {
        return rentalCompanyRepository.findAll();
    }

    public Optional<RentalCompany> getRentalCompanyById(Long id) {
        return rentalCompanyRepository.findById(id);
    }

    public RentalCompany createRentalCompany(RentalCompany rentalCompany) {
        return rentalCompanyRepository.save(rentalCompany);
    }

    public RentalCompany updateRentalCompany(Long id, RentalCompany rentalCompanyDetails) {
        RentalCompany rentalCompany = rentalCompanyRepository.findById(id).orElseThrow(() -> new RuntimeException("RentalCompany not found"));
        rentalCompany.setName(rentalCompanyDetails.getName());
        rentalCompany.setLocation(rentalCompanyDetails.getLocation());
        return rentalCompanyRepository.save(rentalCompany);
    }
    
    public void deleteRentalCompany(Long id) {
        rentalCompanyRepository.deleteById(id);
    }
    public Page<RentalCompany> getRentalCompanyWithPaginationAndSorting(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return rentalCompanyRepository.findAll(pageable);
    }
}


   