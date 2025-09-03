package com.lms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Leaves {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long leaveId;
	private boolean fd;
	private boolean hd;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String reason;
	private String status;//approved/rejected/cancelled/pending
	private double days;
	@ManyToOne
	@JoinColumn(name = "id", nullable=false)
	private Employee employee;

	
	

}
