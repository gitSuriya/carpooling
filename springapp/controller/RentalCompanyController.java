package com.examly.springapp.controller;

import com.examly.springapp.Entity.RentalCompany;
import com.examly.springapp.Service.RentalCompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalCompanyController {

    @Autowired
    private RentalCompanyService rentalCompanyService;

    @GetMapping("/get")
    public List<RentalCompany> getAllRentalCompanies() {
        return rentalCompanyService.getAllRentalCompany();
    }

    @PostMapping("/add")
    public RentalCompany createRentalCompany(@RequestBody RentalCompany rentalCompany) {
        return rentalCompanyService.createRentalCompany(rentalCompany);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<RentalCompany> updateRentalCompany(@PathVariable Long id, @RequestBody RentalCompany rentalCompanyDetails) {
        return ResponseEntity.ok(rentalCompanyService.updateRentalCompany(id, rentalCompanyDetails));
    }

    @DeleteMapping("/del/{id}")
    public String deleteRentalCompany(@PathVariable Long id) {
        rentalCompanyService.deleteRentalCompany(id);
        return "Successfully deleted";
    }
   
    @GetMapping("/get/paginated")
    public Page<RentalCompany> getRentalCompanyWithPaginationAndSorting(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction
    )
    { return rentalCompanyService.getRentalCompanyWithPaginationAndSorting(page, size, sortBy, direction); }

}
    
   