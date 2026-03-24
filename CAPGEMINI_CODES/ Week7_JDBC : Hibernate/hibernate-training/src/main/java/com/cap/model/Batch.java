package com.cap.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Batch {

@TableGenerator(
name="batchIdGenerator",
allocationSize=1,
initialValue=101,
table="allidgenerator",
valueColumnName="nextBatchId"
)

@Id
@GeneratedValue(strategy=GenerationType.TABLE,
generator="batchIdGenerator")

long bid;

private String name;

Date startDate;

Date endDate;

String content;

String venue;

@ManyToMany
List<Trainer> trainers = new ArrayList<>();

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}