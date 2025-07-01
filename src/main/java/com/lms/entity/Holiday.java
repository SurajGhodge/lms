package com.lms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Holiday {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
private int holidayId;
private String holidayName;
private LocalDate date;
private String day;
public int getHolidayId() {
	return holidayId;
}
public void setHolidayId(int holidayId) {
	this.holidayId = holidayId;
}
public String getHolidayName() {
	return holidayName;
}
public void setHolidayName(String holidayName) {
	this.holidayName = holidayName;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}


}
