package com.example.droneapplication.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroneController {

    @GetMapping(value="/health")
    public  String health(){
        return "Good Health!";
    }
}
