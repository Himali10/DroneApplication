package com.example.droneapplication.repository;

import com.example.droneapplication.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication,Long> {
    @Query(value = "SELECT m.weight FROM Drone d INNER JOIN Medication m ON d.id=m.drone.id WHERE m.drone.id=:droneId and m.isActive='true'")
    List<Double> findAllById(@Param("droneId")int droneId);
    @Modifying
    @Transactional
    @Query(value="UPDATE Medication  SET isActive=:isActive WHERE id=:droneId")
    void update(@Param("droneId")int droneId,@Param("isActive")String isActive);
    @Query(value = "SELECT m.name FROM Medication m WHERE m.drone.id=:droneId and m.isActive=:status")
    List<String> findAllByDroneIdAndStatus(int droneId, String status);
}
