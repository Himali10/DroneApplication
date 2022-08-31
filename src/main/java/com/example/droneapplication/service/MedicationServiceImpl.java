package com.example.droneapplication.service;

import com.example.droneapplication.controller.MedicationController;
import com.example.droneapplication.model.Medication;
import com.example.droneapplication.repository.DroneRepository;
import com.example.droneapplication.repository.MedicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {
    private Logger logger = LoggerFactory.getLogger(MedicationController.class);
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private DroneRepository droneRepository;

    @Override
    public List<String> checkLoadedMedications(int droneId) {
        logger.info("checkLoadedMedications-->{}", droneId);
        Double totalWeight = 0.0;
        List<Double> weightList = medicationRepository.findAllById(droneId);
        Double weightLimit = droneRepository.findByDroneId(droneId);
        if (!weightList.isEmpty()) {
            for (int i = 0; i < weightList.size(); i++) {
                Double medWeight = weightList.get(i);
                totalWeight = totalWeight + medWeight;

                if (totalWeight <= weightLimit) {
                    medicationRepository.update(droneId, "false");
                    droneRepository.update(droneId, "LOADED");
                }
            }

        }
        return medicationRepository.findAllByDroneIdAndStatus(droneId,"false");

    }
}
