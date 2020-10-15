package com.wellsfargo.fsd.its.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.its.dao.UserDao;
import com.wellsfargo.fsd.its.entity.UserEntity;
import com.wellsfargo.fsd.its.exception.UserException;
import com.wellsfargo.fsd.its.model.UserModel;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userdao;
	
	private UserEntity toEntity(UserModel u) {
		return new UserEntity(u.getUserId(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getMobile());		
	}
	
	private UserModel toModel(UserEntity u) {
		return new UserModel(u.getUserId(),u.getFirstName(),u.getLastName(),u.getEmail(),u.getMobile());
	}

	@Override
	@Transactional
	public UserModel add(UserModel user) throws UserException {
		if (user!=null) {
			if (userdao.existsById(user.getUserId())) {
				throw new UserException("User Already exists");
			}
			user = toModel(userdao.save(toEntity(user)));
		}
		return user;
	}

	@Override
	@Transactional
	public boolean delete(int userId) throws UserException {
		if (!userdao.existsById(userId)) {
			throw new UserException("User doesn't exist");
		}
		userdao.deleteById(userId);
		return true;
	}

	@Override
	public UserModel getUser(int userId) {
		UserEntity entity= userdao.findById(userId).orElse(null);
		return entity!=null?toModel(entity):null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<UserEntity> entities = userdao.findAll();
		List<UserModel> models = null;
		if (entities!=null && !entities.isEmpty()) {
			 models=entities.stream().map(e->toModel(e)).collect(Collectors.toList());
		}		
		return models;
	}
	
}
