package com.example.droneapplication.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="DRONE")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialNumber;

    private String model;

    private Double weight;

    private Double batteryCapacity;

    private String state;

}


