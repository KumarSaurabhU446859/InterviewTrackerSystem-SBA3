package com.wellsfargo.fsd.its.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.its.dao.InterviewDao;
import com.wellsfargo.fsd.its.entity.InterviewEntity;
import com.wellsfargo.fsd.its.exception.InterviewException;
import com.wellsfargo.fsd.its.model.InterviewModel;

@Service
public class InterviewServiceImpl implements InterviewService {
	
	@Autowired
	private InterviewDao interviewdao;
	
	private InterviewModel toModel(InterviewEntity interview) {
		return new InterviewModel(interview.getInterviewId(), interview.getInterviewerName(), interview.getInterviewName(), interview.getUsersSkills(), interview.getDate(), interview.getTime(), interview.getInterviewStatus(), interview.getRemarks());
	}
	
	private InterviewEntity toEntity(InterviewModel interview) {
		return new InterviewEntity(interview.getInterviewId(), interview.getInterviewerName(), interview.getInterviewName(), interview.getUsersSkills(), interview.getDate(), interview.getTime(), interview.getInterviewStatus(), interview.getRemarks());
	}

	@Override
	@Transactional
	public InterviewModel add(InterviewModel interview) throws InterviewException {
		if (interview!=null) {
			if (interviewdao.existsById(interview.getInterviewId())) {
				throw new InterviewException("Interview already exists");
			}
			interview=toModel(interviewdao.save(toEntity(interview)));
		}
		return interview;
	}

	@Override
	@Transactional
	public InterviewModel update(InterviewModel interview) throws InterviewException {
		if (interview!=null) {
			if (!interviewdao.existsById(interview.getInterviewId())) {
				throw new InterviewException("Interview with given id doesn't exists");
			}
			interview=toModel(interviewdao.save(toEntity(interview)));
		}
		return interview;
	}

	@Override
	@Transactional
	public boolean delete(int interviewId) throws InterviewException {
		if (!interviewdao.existsById(interviewId)) {
			throw new InterviewException("Interview with given id doesn't exists");
		}
		interviewdao.deleteById(interviewId);
		return true;
	}

	@Override
	public List<InterviewModel> searchByName(String name) {
		return null;
	}

	@Override
	public List<InterviewModel> getAllInterview() {
		List<InterviewModel> models = null;
		List<InterviewEntity> entities = null;
		entities=interviewdao.findAll();
		if (entities!=null && !entities.isEmpty()) {
			models = entities.stream().map(e->toModel(e)).collect(Collectors.toList());
		}
		return models;
	}

	@Override
	public List<InterviewModel> getAllInterviewByName(String name) {
		List<InterviewModel> models = null;
		List<InterviewEntity> entities = null;
		entities = interviewdao.findAllinterviewerName(name);
		if (entities==null || entities.isEmpty()) {
			entities = interviewdao.findAllinterviewName(name);
		}
		
		if (entities!=null && !entities.isEmpty()) {
			models = entities.stream().map(e->toModel(e)).collect(Collectors.toList());
		}
		return models;
	}

	@Override
	public Integer getTotalNoofinterviews() {
		return interviewdao.findAll().size();
	}

}
