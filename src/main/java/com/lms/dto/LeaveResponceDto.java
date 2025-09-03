package com.lms.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class LeaveResponceDto {
	private long leaveId;
	private long id;
	private boolean fd;
	private boolean hd;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String reason;
	private double days;
	private String status;

}
