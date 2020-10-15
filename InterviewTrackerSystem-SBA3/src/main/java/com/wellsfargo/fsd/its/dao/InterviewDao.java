package com.wellsfargo.fsd.its.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.its.entity.InterviewEntity;

@Repository
public interface InterviewDao extends JpaRepository<InterviewEntity,Integer>{
	@Query("SELECT k FROM InterviewEntity k WHERE k.interviewerName=:interviewerName")
	List<InterviewEntity> findAllinterviewerName(String interviewerName);
	
	@Query("SELECT k FROM InterviewEntity k WHERE k.interviewName=:interviewName")
	List<InterviewEntity> findAllinterviewName(String interviewName);
}
