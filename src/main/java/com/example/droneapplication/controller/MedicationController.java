package com.example.droneapplication.controller;

import com.example.droneapplication.model.Medication;
import com.example.droneapplication.repository.MedicationRepository;
import com.example.droneapplication.repository.DroneRepository;
import com.example.droneapplication.service.MedicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medication")
public class MedicationController {
    private Logger logger= LoggerFactory.getLogger(MedicationController.class);
    @Autowired
    private MedicationService medicationService;

    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private DroneRepository droneRepository;

    @ResponseBody
    @PostMapping("/loading")
    public String loadingMedications(@RequestBody Medication medication){
        int medicationLoadedId=medicationService.loadMedications(medication);
       /* int droneId=medication.getDrone().getId();
        Medication savedMedication=medicationRepository.save(medication);
*/
        if(medicationLoadedId>0){
            //droneRepository.update(droneId,"LOADING");
            return "Medication is loaded Successfully .";
        }else{
            return "Medication is not loaded, exceed weight limit";
        }

    }

    @ResponseBody
    @GetMapping("/check/loadedMedications/{id}")
    public List<String> checkMedications(@PathVariable int id){
        return medicationService.checkLoadedMedications(id);

    }
}
