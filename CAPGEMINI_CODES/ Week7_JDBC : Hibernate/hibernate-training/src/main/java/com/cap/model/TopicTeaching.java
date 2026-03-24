package com.cap.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class TopicTeaching {

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
long teachingid;

@ManyToOne
@JoinColumn(name="trainerid")
public
Trainer trainer;

@ManyToOne
@JoinColumn(name="bid")
private
Batch batch;

Date stDate;

Date endDate;

private String topics;

public Batch getBatch() {
	return batch;
}

public void setBatch(Batch batch) {
	this.batch = batch;
}

public String getTopics() {
	return topics;
}

public void setTopics(String topics) {
	this.topics = topics;
}

}