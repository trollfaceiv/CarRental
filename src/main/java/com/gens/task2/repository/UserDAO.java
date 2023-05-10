package com.gens.task2.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.gens.task2.entities.Rent;
import com.gens.task2.entities.User;

public interface UserDAO {
	
	List<User> retrieveAll();
	void inserOrUpdateItem(User user);
	void deleteItem(User user);
	void deleteByID(int id);
	User retrieveByID(int id);
	User selectByUserName(String username);
}
