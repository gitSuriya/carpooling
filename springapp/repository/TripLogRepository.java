package com.examly.springapp.repository;

import com.examly.springapp.Entity.TripLog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripLogRepository extends JpaRepository<TripLog, Long> {
    @Query("SELECT t FROM TripLog t WHERE t.source LIKE %:location% OR t.destination LIKE %:location% OR t.route LIKE %:location%")
    List<TripLog> findByLocation(@Param("location") String location);
}

