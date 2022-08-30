package com.example.droneapplication.service;

import com.example.droneapplication.model.Drone;
import com.example.droneapplication.model.Medication;
import com.example.droneapplication.repository.DroneRepository;
import com.example.droneapplication.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MedicationServiceImpl implements MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private DroneRepository droneRepository;
    @Override
    public Medication loadMedications(Medication medication) {
        Medication medicationLoaded=new Medication();
        Double totalWeight=0.0;
        int droneId=medication.getDrone().getId();
        List<Double> medicationList=medicationRepository.findAllById(Long.valueOf(droneId));
        Optional<Drone> droneList=droneRepository.findById(Long.valueOf(droneId));
        Double weightLimit=droneList.get().getWeightLimit();

        if (medicationList!=null) {
            for (int i = 0; i < medicationList.size(); i++) {
                Double loadedWeight = medicationList.get(i);
                totalWeight = +loadedWeight;
            }
            if ((totalWeight < weightLimit) && (totalWeight + medication.getWeight() < weightLimit)) {
                medicationLoaded=medicationRepository.save(medication);
                droneRepository.update(droneId);
            }
        }else{
            if (medication.getWeight() < weightLimit) {
                medicationLoaded=medicationRepository.save(medication);
                droneRepository.update(droneId);
            }
        }
        return medicationLoaded;
    }
}
