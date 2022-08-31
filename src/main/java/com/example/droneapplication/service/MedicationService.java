package com.example.droneapplication.service;

import com.example.droneapplication.model.Medication;

public interface MedicationService {
    int loadMedications(Medication medication);

    void updateDrone(Medication medication);
}
