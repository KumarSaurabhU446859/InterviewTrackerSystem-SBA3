package com.wellsfargo.fsd.its.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.its.dao.AttendeeDao;
import com.wellsfargo.fsd.its.dao.InterviewDao;
import com.wellsfargo.fsd.its.dao.UserDao;
import com.wellsfargo.fsd.its.entity.AttendeeEntity;
import com.wellsfargo.fsd.its.entity.InterviewEntity;
import com.wellsfargo.fsd.its.entity.UserEntity;
import com.wellsfargo.fsd.its.exception.InterviewException;
import com.wellsfargo.fsd.its.exception.UserException;

@Service
public class AttendeeServiceImpl implements AttendeeService{
	
	@Autowired
	private AttendeeDao attendeedao;
	
	@Autowired
	private InterviewDao interviewdao;
	
	@Autowired
	private UserDao userdao;
	
	@Override
	@Transactional
	public AttendeeEntity add(AttendeeEntity attendee) throws UserException, InterviewException {
		if (attendee!=null) {
			if (attendeedao.existsById(attendee.getAttendeeId())) {
				throw new InterviewException("Attendee id already exists");
			}
			
			if (!userdao.existsById(attendee.getUser().getUserId())) {
				throw new UserException("User doesn't exist");
			}
			
			if (!interviewdao.existsById(attendee.getInterview().getInterviewId())) {
				throw new InterviewException("Interview id doesn't exist");
			}
			
			List<UserEntity> entities=null;
			entities=attendeedao.findAllinterviewId(attendee.getInterview());
			
			for(UserEntity e:entities) {
				if (e.getUserId()==attendee.getUser().getUserId()) {
					throw new InterviewException("User has already been added to this interview");
				}
			}
			
			UserEntity usertoadd = attendee.getUser();
			InterviewEntity interviewtoadd = attendee.getInterview();
			
			attendee.setUser(usertoadd);
			attendee.setInterview(interviewtoadd);
			usertoadd.getAttendees().add(attendee);
			interviewtoadd.getAttendees().add(attendee);			
			attendeedao.save(attendee);		
		}
		return attendee;
	}

	@Override
	public List<UserEntity> getAllAttendees(int interview) {
		List<UserEntity> entities = null;
		InterviewEntity i = interviewdao.findById(interview).orElse(null);
		if (i!=null) {
			entities=attendeedao.findAllinterviewId(i);
		}
		return entities;
	}

}
