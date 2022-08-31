package com.example.droneapplication.repository;

import com.example.droneapplication.model.Drone;
import com.example.droneapplication.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DroneRepository extends JpaRepository<Drone,Long> {
    @Modifying
    @Transactional
    @Query(value="UPDATE Drone  SET state=:state ,isActive=:isActive WHERE id=:droneId")
    void update(@Param("droneId")int droneId,@Param("state")String state,@Param("isActive")String isActive);
    @Query(value="SELECT d.weightLimit FROM Drone d WHERE d.id=:droneId and d.batteryCapacity>=25.0")
    Double findByDroneId(@Param("droneId")int droneId);
    @Query(value="SELECT d.serialNumber FROM Drone d WHERE d.state='IDLE'")
    List<String> findByState();
    @Query(value = "SELECT d.batteryCapacity FROM Drone d WHERE d.id=:droneId")
    Double checkBatteryLevel(@Param("droneId")int droneId);

    @Query(value = "SELECT d.id,d.batteryCapacity FROM Drone d")
    Map<Integer, Double> trackBatteryLevel();
}
