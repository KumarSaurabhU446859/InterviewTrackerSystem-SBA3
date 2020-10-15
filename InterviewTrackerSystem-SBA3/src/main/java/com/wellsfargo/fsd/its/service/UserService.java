package com.wellsfargo.fsd.its.service;

import java.util.List;

import com.wellsfargo.fsd.its.exception.UserException;
import com.wellsfargo.fsd.its.model.UserModel;

public interface UserService {
	UserModel add(UserModel user) throws UserException;
	boolean delete(int userId) throws UserException;
	UserModel getUser(int userId);
	List<UserModel> getAllUsers();
}
