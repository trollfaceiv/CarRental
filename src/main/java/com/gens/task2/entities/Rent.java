package com.gens.task2.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Rent implements Serializable{
	
	@Id
	@Column(name="rent_id")
	private int id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="start_date")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="end_date")
	private Date endDate;
	
	@Column
	private String approved;
	
	@ManyToOne
	@JoinColumn(name = "user_fk", nullable=false)
	private User user;
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rent other = (Rent) obj;
		return id == other.id &&
				 Objects.equals(user.getId(), other.user.getId())
				&& Objects.equals(vehicle.getId(), other.vehicle.getId());
	}

	@ManyToOne
	@JoinColumn(name = "vehicle_fk", nullable=false)
	private Vehicle vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getRentId() {
		return id;
	}

	public void setRentId(int rentId) {
		this.id = rentId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Rent [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", approved=" + approved
				+ ", user=" + user.getId() + ", vehicle=" + vehicle.getId() + "]";
	}
	
	
	
}
