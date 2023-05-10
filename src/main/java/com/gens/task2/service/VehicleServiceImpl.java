package com.gens.task2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gens.task2.entities.Vehicle;
import com.gens.task2.repository.VehicleDAO;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDAO vehicleDAO;
	
	@Override
	@Transactional
	public void insertItem(Vehicle vehicle) {
		vehicleDAO.inserOrUpdateItem(vehicle);
	}


	@Override
	@Transactional
	public void deleteItembyID(int vehicleId) {
		vehicleDAO.deleteByID(vehicleId);
		
	}
	
	@Override
	@Transactional
	public List<Vehicle> retrieveAll() {
		return vehicleDAO.retrieveAll();
	}

	@Override
	@Transactional
	public Vehicle selectVehicleByID(int vehicleId) {
		// TODO Auto-generated method stub
		return vehicleDAO.selectVehicleByID(vehicleId);
	}

	@Override
	public Vehicle selectVehicleByPlateNumber(String plateNumber) {
		// TODO Auto-generated method stub
		return vehicleDAO.selectVehicleByPlateNumber(plateNumber);
	}


	@Override
	public void deleteItem(Vehicle v1) {
		vehicleDAO.deleteItem(v1);
	}

}
