package com.wellsfargo.fsd.its.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.its.entity.AttendeeEntity;
import com.wellsfargo.fsd.its.entity.InterviewEntity;
import com.wellsfargo.fsd.its.entity.UserEntity;

@Repository
public interface AttendeeDao extends JpaRepository<AttendeeEntity, Integer> {	
	@Query("SELECT k.user FROM AttendeeEntity k WHERE k.interview=:interview")
	List<UserEntity> findAllinterviewId(InterviewEntity interview);	
}
