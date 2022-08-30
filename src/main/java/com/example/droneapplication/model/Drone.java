package com.example.droneapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="DRONE")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialNumber;

    private String model;

    private Double weightLimit;

    private Double batteryCapacity;

    private String state;

    private String isActive;

    @OneToMany(mappedBy="drone")
    private Set<Medication> items;

}


