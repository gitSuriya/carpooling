package com.examly.springapp.repository;

import com.examly.springapp.Entity.RentalCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RentalCompanyRepository extends JpaRepository<RentalCompany, Long> {
    Page<RentalCompany> findAll(Pageable pageable);
}

