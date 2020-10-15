package com.wellsfargo.fsd.its.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class InterviewModel {
	
	@NotNull(message = "Interview Id is mandatory")
	@Min(value=1,message = "Interview Id can not be negative or zero")
	private Integer interviewId;
	
	@NotNull(message = "Interviewer Name is mandatory")
	@Size(min=5,max=30,message = "Interviewer Name should be min of 5 & max of 30 chars")
	private String interviewerName;
	
	@NotNull(message = "Interview Name is mandatory")
	@Size(min=3,max=30,message = "Interview Name should be min of 3 & max of 30 chars")
	private String interviewName;
	
	@NotNull(message = "User skills are mandatory")
	@Size(min=5,max=30,message = "User skills should be min of 5 & max of 30 chars")
	private String usersSkills;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate date;
	
	@DateTimeFormat(iso=ISO.TIME)
	private LocalTime time;
	
	@NotNull(message = "Interview Status is mandatory")
	@Size(min=5,max=100,message = "Interview Status should be min of 5 & max of 100 chars")
	private String interviewStatus;
	
	@NotNull(message = "Remarks is mandatory")
	@Size(min=5,max=100,message = "Remarks should be min of 5 & max of 100 chars")
	private String remarks;

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public String getUsersSkills() {
		return usersSkills;
	}

	public void setUsersSkills(String usersSkills) {
		this.usersSkills = usersSkills;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public InterviewModel() {
		super();
	}

	public InterviewModel(Integer interviewId, String interviewerName, String interviewName, String usersSkills,
			LocalDate date, LocalTime time, String interviewStatus, String remarks) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.date = date;
		this.time = time;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
	}
	
}
