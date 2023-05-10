package com.gens.task2.repository;

import java.util.List;

import com.gens.task2.entities.Rent;
import com.gens.task2.entities.User;

public interface RentDAO {
	void inserOrUpdateItem(Rent rent);
	void deleteItem(Rent rent);
	Rent retrieveByID(int id);
	User retrieveUserByRentID(int id);
	List<Rent> retrieveAll();
}
