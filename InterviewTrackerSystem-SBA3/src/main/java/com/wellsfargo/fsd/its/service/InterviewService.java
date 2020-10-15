package com.wellsfargo.fsd.its.service;

import java.util.List;

import com.wellsfargo.fsd.its.exception.InterviewException;
import com.wellsfargo.fsd.its.model.InterviewModel;

public interface InterviewService {
	InterviewModel add(InterviewModel interview) throws InterviewException;
	InterviewModel update(InterviewModel interview) throws InterviewException;
	boolean delete(int interviewId) throws InterviewException;
	List<InterviewModel> searchByName(String name);
	List<InterviewModel> getAllInterview();
	List<InterviewModel> getAllInterviewByName(String name);
	Integer getTotalNoofinterviews();
}
