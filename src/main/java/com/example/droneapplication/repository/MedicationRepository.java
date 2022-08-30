package com.example.droneapplication.repository;

import com.example.droneapplication.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MedicationRepository extends JpaRepository<Medication,Long> {
    @Query(value = "SELECT m.weight_limit FROM Medication m WHERE m.drone_id=:droneId",nativeQuery = true )
    List<Double> findAllById(@Param("droneId")long droneId);
}
