package com.gens.task2.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gens.task2.entities.Rent;
import com.gens.task2.entities.User;

@Repository
public class RentDAOImpl extends GenericDAOImpl<Rent, Integer> implements RentDAO {

	@Override
	public void inserOrUpdateItem(Rent rent) {
		super.inserOrUpdateItem(rent);
		
	}

	@Override
	public List<Rent> retrieveAll(){
		return super.retrieveAll();
	}


	@Override
	public void deleteItem(Rent rent) {
		super.deleteItem(rent);
		
	}

	@Override
	public Rent retrieveByID(int id) {
		return super.retrieveByID(id);
	}

	@Override
	public User retrieveUserByRentID(int id) {
		Rent r1 = retrieveByID(id);
		return r1.getUser();
	}

	private void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}
}
