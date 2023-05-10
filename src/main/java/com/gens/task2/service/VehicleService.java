package com.gens.task2.service;

import java.util.List;

import com.gens.task2.entities.Vehicle;

public interface VehicleService {
	
	void insertItem(Vehicle vehicle);
	void deleteItem(Vehicle v1);
	Vehicle selectVehicleByID(int vehicleId);
	List<Vehicle> retrieveAll();
	Vehicle selectVehicleByPlateNumber(String plateNumber);
	void deleteItembyID(int vehicleId);

}
