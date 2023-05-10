package com.gens.task2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;


@Entity
public class Vehicle implements Serializable {
	@Id
	@Column(name = "vehicle_id")
	private int id;
	
	
	@Column(name = "plate_number")
	private String plateNumber;
	
	private String model;
	
	private String manufacturer;

	private String category;
	
	private boolean avaible=true;
	
	@Column(name = "registration_date")
	private int registrationDate;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle", cascade = CascadeType.ALL)
	private List<Rent> rents;
	
	public Vehicle() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int vehicleId) {
		this.id = vehicleId;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(int registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<Rent> getRents() {
		 List<Rent> rentList = new ArrayList<>(rents);
		 return rentList;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	public boolean isAvaible() {
		return avaible;
	}

	public void setAvaible(boolean avaible) {
		this.avaible = avaible;
	}
	
	public void removeRent(Rent rent) {
		this.rents.remove(rent);
		System.out.println("attualmente le rent nei veicoli sono: " + this.rents);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return avaible == other.avaible && Objects.equals(category, other.category) && id == other.id
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(model, other.model)
				&& Objects.equals(plateNumber, other.plateNumber) && registrationDate == other.registrationDate
				&& Objects.equals(rents, other.rents);
	}


	
	
	
}
