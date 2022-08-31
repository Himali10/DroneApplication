package com.example.droneapplication.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="MEDICATION")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Double weight;

    private String code;

    private String image;

    private String isActive;

    @ManyToOne
    @JoinColumn(name="drone_id", nullable=false)
    private Drone drone;

}
