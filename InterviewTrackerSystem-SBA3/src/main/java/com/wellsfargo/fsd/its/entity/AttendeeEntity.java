package com.wellsfargo.fsd.its.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class AttendeeEntity {
	@Id
	@Column
	private Integer attendeeId;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	private UserEntity user;
	
	@ManyToOne
    @JoinColumn(name = "interview_id")
	private InterviewEntity interview;

	public Integer getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(Integer attendeeId) {
		this.attendeeId = attendeeId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public InterviewEntity getInterview() {
		return interview;
	}

	public void setInterview(InterviewEntity interview) {
		this.interview = interview;
	}		

	@Override
    public boolean equals(Object obj) {
		if (this == obj) {
            return true;
		}
        
		if (obj == null) {
            return false;
		}
        
		if (getClass() != obj.getClass()) {
            return false;
		}
        
		InterviewEntity other = (InterviewEntity) obj;
        
		if (this.interview.getInterviewId() == null) {
            if (other.getInterviewId() != null) {
                return false;
            }
        } else if (!this.interview.getInterviewId().equals(other.getInterviewId())) {
            return false;
        }
        
		return true;
    }

}
