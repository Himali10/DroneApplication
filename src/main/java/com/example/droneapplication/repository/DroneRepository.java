package com.example.droneapplication.repository;

import com.example.droneapplication.model.Drone;
import com.example.droneapplication.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface DroneRepository extends JpaRepository<Drone,Long> {
    @Modifying
    @Transactional
    @Query(value="UPDATE Drone  SET state=:state WHERE id=:droneId")
    void update(@Param("droneId")int droneId,@Param("state")String state);
    @Query(value="SELECT d.weightLimit FROM Drone d WHERE d.id=:droneId and d.state='LOADING'")
    Double findByDroneId(@Param("droneId")int droneId);
}
