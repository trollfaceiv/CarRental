package com.gens.task2.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gens.task2.entities.Rent;
import com.gens.task2.entities.User;
import com.gens.task2.repository.RentDAO;

@Service
public class RentServiceImpl implements RentService{

	@Autowired
	RentDAO rentDAO;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	@Transactional
	public void insertItem(Rent rent) {
		rentDAO.inserOrUpdateItem(rent);
		
	}



	@Override
	@Transactional
	public void deleteItem(Rent rent) {
		rentDAO.deleteItem(rent);
	}

	@Override
	@Transactional
	public Rent retrieveByID(int id) {
		return rentDAO.retrieveByID(id);
	}

	@Override
	@Transactional
	public User retrieveUserByRentID(int id) {
		return rentDAO.retrieveUserByRentID(id);
	}



	@Override
	@Transactional
	public List<Rent> retrieveAll() {
		return rentDAO.retrieveAll();
	}

	
}
