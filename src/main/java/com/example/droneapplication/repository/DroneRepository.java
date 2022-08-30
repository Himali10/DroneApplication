package com.example.droneapplication.repository;

import com.example.droneapplication.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone,Long> {

}
