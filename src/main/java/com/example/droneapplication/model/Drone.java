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

    @Column(name = "serial_number")
    private String serialNumber;

    private String model;

    @Column(name = "weight_limit")
    private Double weightLimit;

    @Column(name = "battery_capacity")
    private Double batteryCapacity;

    private String state;

    @Column(name = "is_active")
    private String isActive;

    @OneToMany(mappedBy="drone")
    private Set<Medication> items;

}


