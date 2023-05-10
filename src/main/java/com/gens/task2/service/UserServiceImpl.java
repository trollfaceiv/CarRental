package com.gens.task2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gens.task2.entities.User;
import com.gens.task2.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserDAO userDAO; 
	
	
	@Override
	@Transactional
	public List<User> retrieveAll() {
		return userDAO.retrieveAll();
	}

	@Override
	@Transactional
	public void insertItem(User user) {
		userDAO.inserOrUpdateItem(user);
		
	}


	@Override
	@Transactional
	public void deleteItem(User user) {
		userDAO.deleteItem(user);
		
	}

	@Override
	@Transactional
	public void deleteByID(int id) {
		userDAO.deleteByID(id);
		
	}

	@Override
	@Transactional
	public User retrieveByID(int id) {
		return userDAO.retrieveByID(id);
	}

	@Override
	@Transactional
	public User selectByUserName(String username) {
		return userDAO.selectByUserName(username);
	}

}
