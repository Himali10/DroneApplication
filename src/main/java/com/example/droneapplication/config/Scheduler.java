package com.example.droneapplication.config;

import com.example.droneapplication.controller.DroneController;
import com.example.droneapplication.repository.DroneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Scheduler {
    @Autowired
    private DroneRepository droneRepository;
    //@Scheduled(cron = "0 0 22 * * ?")
    //@Scheduled(cron = "${interval-in-cron-priority}")
    @Scheduled(cron = "0 */5 * ? * *")
    public void cronJobSchedule() {
        Logger logger= LoggerFactory.getLogger(DroneController.class);
        logger.info("Scheduler Started...");
        Map<Integer,Double> batteyLevel=droneRepository.trackBatteryLevel();
        for (Map.Entry<Integer,Double> set :
                batteyLevel.entrySet()) {

            // Printing all elements of a Map
            System.out.println(set.getKey() + " = "
                    + set.getValue());
            logger.info("batteyLevel for drone{}-->batteryLevel{}", set.getKey(), set.getValue());
        }
        logger.info("Scheduler Stoped...");
    }
}
