package com.gens.task2.service;

import java.util.List;

import com.gens.task2.entities.User;

public interface UserService {

	List<User> retrieveAll();
	void insertItem(User user);
	void deleteItem(User user);
	void deleteByID(int id);
	User retrieveByID(int id);
	public User selectByUserName(String username);
}
