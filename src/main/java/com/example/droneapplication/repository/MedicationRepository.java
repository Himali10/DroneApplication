package com.example.droneapplication.repository;

import com.example.droneapplication.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication,Long> {
    @Query(value = "SELECT d.weightLimit FROM Drone d INNER JOIN Medication m ON d.id=m.drone.id WHERE m.drone.id=:droneId")
    List<Double> findAllById(@Param("droneId")int droneId);
}
