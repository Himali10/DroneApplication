package com.example.droneapplication.service;

import com.example.droneapplication.model.Medication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DroneService {

    List<String> checkAvailableDrones();
}
