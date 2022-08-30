package com.example.droneapplication.controller;

import com.example.droneapplication.model.Medication;
import com.example.droneapplication.service.MedicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medication")
public class MedicationController {
    private Logger logger= LoggerFactory.getLogger(MedicationController.class);

    public MedicationService medicationService;

    @ResponseBody
    @PostMapping("/loading")
    public Medication loadingMedications(@RequestBody Medication medication){
        Medication medicationLoaded=medicationService.loadMedications(medication);
       /* if(medicationLoaded.getId()!=0){
            return "Medication is loaded Successfully .";
        }else{
            return "Medication is not loaded, exceed weight limit";
        }*/

        return medicationLoaded;
    }
}
