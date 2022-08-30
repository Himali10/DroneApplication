package com.example.droneapplication.controller;


import com.example.droneapplication.model.Drone;
import com.example.droneapplication.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drone")
public class DroneController {
    //private Logger logger= LoggerFactory.getLogger(DroneController.class);
@Autowired
private DroneRepository droneRepository;
    @GetMapping("/health")
    public  String health(){
        return "Good Health!";
    }
    @ResponseBody
    @PostMapping ("/register")
    public Drone registerDrone(@RequestBody Drone drone){

        return droneRepository.save(drone);
    }
}
