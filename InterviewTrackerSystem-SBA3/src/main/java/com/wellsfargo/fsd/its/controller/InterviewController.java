package com.wellsfargo.fsd.its.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.its.exception.InterviewException;
import com.wellsfargo.fsd.its.model.InterviewModel;
import com.wellsfargo.fsd.its.service.InterviewService;

@RestController
@RequestMapping("/interviews")
public class InterviewController {
	
	@Autowired
	private InterviewService interviewservice;
	
	@GetMapping	
	public ResponseEntity<List<InterviewModel>> getAllInterviews() {
		return new ResponseEntity<List<InterviewModel>>(interviewservice.getAllInterview(),HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<InterviewModel>> getAllInterviewsByName(@PathVariable("name") String name) {
		return new ResponseEntity<List<InterviewModel>>(interviewservice.getAllInterviewByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public ResponseEntity<String> getAllInterviewsByName() {
		return new ResponseEntity<String>("Total no of interviews are " + interviewservice.getTotalNoofinterviews(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<InterviewModel> createInterview(@RequestBody @Valid InterviewModel interview, BindingResult result) throws InterviewException {
		if(result.hasErrors()) {
			throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(interviewservice.add(interview),HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<InterviewModel> updateInterview(@RequestBody @Valid InterviewModel interview, BindingResult result) throws InterviewException {
		if(result.hasErrors()) {
			throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(interviewservice.update(interview),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> deleteInterview(@PathVariable("id")int interviewId) throws InterviewException {	
		interviewservice.delete(interviewId);
		return new ResponseEntity<String>("Interview id successfully deleted",HttpStatus.OK); 
	}
	
}
