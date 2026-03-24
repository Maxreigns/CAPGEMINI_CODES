package com.gal.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Training {
@Id
@GeneratedValue
private int trainingid;
private Date startDate,endDate;
private String topic;
private String trainername;
public int getTrainingid() {
	return trainingid;
}
public void setTrainingid(int trainingid) {
	this.trainingid = trainingid;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public String getTopic() {
	return topic;
}
public void setTopic(String topic) {
	this.topic = topic;
}
public Training() {
	super();
}
public Training(int trainingid, Date startDate, Date endDate, String topic, String trainername) {
	super();
	this.trainingid = trainingid;
	this.startDate = startDate;
	this.endDate = endDate;
	this.topic = topic;
	this.trainername = trainername;
}
public String getTrainername() {
	return trainername;
}
public void setTrainername(String trainername) {
	this.trainername = trainername;
}


}
