package com.gens.task2.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gens.task2.entities.User;
import com.gens.task2.entities.Vehicle;

@Repository
public class VehicleDAOImpl extends GenericDAOImpl<Vehicle, Integer> implements VehicleDAO {

	

	@Override
	public void inserOrUpdateItem(Vehicle vehicle) {
		super.inserOrUpdateItem(vehicle);
		
	}

	public void deleteByID(int vehicleId) {
		super.deleteByID(vehicleId);
	}
	@Override
	public void deleteItem(Vehicle v1) {
		super.deleteItem(v1);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> retrieveAll() {
		return super.retrieveAll();
	}

	@Override
	public Vehicle selectVehicleByID(int vehicleId) {
		return super.retrieveByID(vehicleId);
	}
	
	public Vehicle selectVehicleByPlateNumber(String plateNumber) {
		Vehicle v1 = null;
		String JPQL = "SELECT v FROM Vehicle v WHERE v.plateNumber=:plateNumber";
		try{
			v1 = (Vehicle) entityManager.createQuery(JPQL).setParameter("plateNumber", plateNumber).getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return v1;
	}

	}



