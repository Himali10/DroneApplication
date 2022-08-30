package com.example.droneapplication.repository;

import com.example.droneapplication.model.Drone;
import com.example.droneapplication.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DroneRepository extends JpaRepository<Drone,Long> {

    @Query(value="UPDATE Drone d SET d.state='LOADING' WHERE d.id=:droneId")
    void update(@Param("droneId")int droneId);
}
