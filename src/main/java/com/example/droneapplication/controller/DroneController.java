package com.example.droneapplication.controller;


import com.example.droneapplication.model.Drone;
import com.example.droneapplication.model.Medication;
import com.example.droneapplication.repository.DroneRepository;
import com.example.droneapplication.repository.MedicationRepository;
import com.example.droneapplication.service.DroneService;
import com.example.droneapplication.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/drone")
public class DroneController {
    private Logger logger= LoggerFactory.getLogger(DroneController.class);
@Autowired
private DroneRepository droneRepository;

    @GetMapping("/health")
    public  String healthCheck(){
        return "Good Health!";
    }
    @ResponseBody
    @PostMapping ("/register")
    public String registerDrone(@RequestBody Drone drone){
        Drone savedDrone=droneRepository.save(drone);
        if(savedDrone.getIsActive().equalsIgnoreCase("true")){
            return "Drone is registered Successfully .";
        }else {
            return "Drone is not registered .";
        }
    }
    @ResponseBody
    @GetMapping("/check/availableDrones")
    public List<String> checkDrones(){
        //return droneService.checkAvailableDrones();
        return droneRepository.findByState();
    }

    @ResponseBody
    @GetMapping("/check/battery/{id}")
    public Double checkBattery(@PathVariable int id){
        return droneRepository.checkBatteryLevel(id);

    }
}
