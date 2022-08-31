package com.example.droneapplication.service;

import com.example.droneapplication.controller.MedicationController;
import com.example.droneapplication.model.Drone;
import com.example.droneapplication.model.Medication;
import com.example.droneapplication.repository.DroneRepository;
import com.example.droneapplication.repository.MedicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MedicationServiceImpl implements MedicationService {
    private Logger logger= LoggerFactory.getLogger(MedicationController.class);
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private DroneRepository droneRepository;
    @Override
    public int loadMedications(Medication medication) {
        logger.info("-----------0");
        Double totalWeight=0.0;
        int returnId = 0;
        int droneId=medication.getDrone().getId();
        logger.info("-----------2",droneId);
        List<Double> medicationList=medicationRepository.findAllById(droneId);
        Double weightLimit=droneRepository.findByDroneId(droneId);
        System.out.println("-----------3"+weightLimit);
        if (!medicationList.isEmpty()) {
            for (int i = 0; i < medicationList.size(); i++) {
                Double loadedWeight = medicationList.get(i);
                totalWeight = totalWeight+loadedWeight;
            }
            if ((totalWeight <= weightLimit) && ((totalWeight + medication.getWeight()) <= weightLimit)) {
                Medication medicationLoaded=medicationRepository.save(medication);
                droneRepository.update(droneId);
                returnId=medicationLoaded.getId();
                System.out.println("-----------ss"+returnId);
            }
            return returnId;
        }else{
            if (medication.getWeight() < weightLimit) {
                Medication medicationLoaded=medicationRepository.save(medication);
                droneRepository.update(droneId);
                returnId=medicationLoaded.getId();
                System.out.println("-----------gg"+returnId);
            }
            return returnId;
        }


    }

    @Override
    public void updateDrone(Medication medication) {
        int droneId=medication.getDrone().getId();
        Medication medicationLoaded=medicationRepository.save(medication);
        droneRepository.update(droneId);
    }
}
