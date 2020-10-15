package com.wellsfargo.fsd.its.service;

import java.util.List;

import com.wellsfargo.fsd.its.entity.AttendeeEntity;
import com.wellsfargo.fsd.its.entity.UserEntity;
import com.wellsfargo.fsd.its.exception.InterviewException;
import com.wellsfargo.fsd.its.exception.UserException;

public interface AttendeeService {
	AttendeeEntity add(AttendeeEntity attendee) throws UserException, InterviewException;
	List<UserEntity> getAllAttendees(int interview);
}
