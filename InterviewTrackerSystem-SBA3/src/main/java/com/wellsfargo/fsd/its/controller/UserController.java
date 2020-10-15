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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.its.exception.UserException;
import com.wellsfargo.fsd.its.model.UserModel;
import com.wellsfargo.fsd.its.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping	
	public ResponseEntity<List<UserModel>> getAllUsers() {
		return new ResponseEntity<List<UserModel>>(userservice.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getUser(@PathVariable("id") int userId) {
		ResponseEntity<UserModel> resp = null;
		UserModel user = userservice.getUser(userId);
		if(user != null) { 
			resp = new ResponseEntity<>(user, HttpStatus.OK); 
		} else { 
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		} 
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<UserModel> createuser(@RequestBody @Valid UserModel user, BindingResult result) throws UserException {
		if(result.hasErrors()) {
			throw new UserException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(userservice.add(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> deleteUser(@PathVariable("id")int userId) throws UserException {
		if (userservice.getUser(userId)==null) {
			throw new UserException("User id doesn't exist");
		}
		userservice.delete(userId);
		return new ResponseEntity<String>("User id successfully deleted", HttpStatus.OK); 
	}
	
}
