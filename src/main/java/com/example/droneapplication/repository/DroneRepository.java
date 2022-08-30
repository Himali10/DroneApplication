package com.example.droneapplication.repository;

import com.example.droneapplication.model.Drone;
import com.example.droneapplication.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface DroneRepository extends JpaRepository<Drone,Long> {
    @Modifying
    @Query(value="UPDATE Drone  SET state='LOADING' WHERE id=:droneId")
    void update(@Param("droneId")int droneId);
    @Query(value="SELECT d.weightLimit FROM Drone d WHERE d.id=:droneId")
    Double findByDroneId(@Param("droneId")int droneId);
}
