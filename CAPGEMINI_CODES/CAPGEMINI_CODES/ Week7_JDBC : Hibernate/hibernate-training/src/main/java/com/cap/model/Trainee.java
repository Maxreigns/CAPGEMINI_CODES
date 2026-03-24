package com.cap.model;

import jakarta.persistence.*;

@Entity
public class Trainee {

@SequenceGenerator(
name="traineeseq",
allocationSize=1,
initialValue=1001
)

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,
generator="traineeseq")

long superid;

@Column(nullable=false)
String name;

String institute;

String email;

String phone;

@ManyToOne
Batch batch;

}