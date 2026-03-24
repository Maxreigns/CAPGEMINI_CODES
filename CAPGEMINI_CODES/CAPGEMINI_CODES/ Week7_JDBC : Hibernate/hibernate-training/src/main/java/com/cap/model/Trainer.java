package com.cap.model;

import jakarta.persistence.*;

@Entity
public class Trainer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
long trainerId;

@Column(nullable=false)
String name;

String company;

String specialization;

 Trainer() {}

 public Trainer(String name,String company,String specialization){
this.name=name;
this.company=company;
this.specialization=specialization;
}

}