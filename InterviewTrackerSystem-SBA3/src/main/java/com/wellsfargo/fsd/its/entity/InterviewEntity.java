package com.wellsfargo.fsd.its.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="InterviewDetails")
public class InterviewEntity {
	
	@Id
	@Column
	private Integer interviewId;
	
	@Column
	private String interviewerName;
	
	@Column
	private String interviewName;
	
	@Column
	private String usersSkills;
	
	@Column
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate date;
	
	@Column
	@DateTimeFormat(iso=ISO.TIME)
	private LocalTime time;
	
	@Column
	private String interviewStatus;
	
	@Column
	private String remarks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "interview",cascade = CascadeType.ALL)
    Set<AttendeeEntity> attendees = new HashSet<>();
	
	public Set<AttendeeEntity> getAttendees() {
		return attendees;
	}
	
	public void setAttendees(Set<AttendeeEntity> attendees) {
		this.attendees = attendees;
	}
	
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
	
	public InterviewEntity(Integer interviewId, String interviewerName, String interviewName, String usersSkills,
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
	
	public InterviewEntity() {
		super();
	}
	

}
