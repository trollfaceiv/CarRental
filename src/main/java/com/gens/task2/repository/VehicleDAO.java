package com.gens.task2.repository;

import java.util.List;

import com.gens.task2.entities.Vehicle;


public interface VehicleDAO {

	void inserOrUpdateItem(Vehicle vehicle);
	void deleteItem(Vehicle v1);
	public void deleteByID(int vehicleId);
	Vehicle selectVehicleByID(int vehicleId);
	List<Vehicle> retrieveAll();
	Vehicle selectVehicleByPlateNumber(String plateNumber);
}
