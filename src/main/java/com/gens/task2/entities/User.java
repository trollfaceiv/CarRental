package com.gens.task2.entities;

import java.io.Serializable;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "Users")
public class User implements Serializable {
		
	
	@Id
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_date")
	private Date birthDate;
	

	@Column(name = "admin_role")
	private boolean adminRole;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Rent> rents;
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return adminRole == other.adminRole && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(rents, other.rents) && Objects.equals(userName, other.userName);
	}

	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int userId) {
		this.id = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isAdminRole() {
		return adminRole;
	}

	public void setAdminRole(boolean adminRole) {
		this.adminRole = adminRole;
	}

	public List<Rent> getRents() {
		 List<Rent> rentList = new ArrayList<>(rents);
		 return rentList;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		this.password = bCryptPasswordEncoder.encode(password);
	}

	
	public void removeRent(Rent rent) {
		this.rents.remove(rent);
		System.out.println("attualmente le rent negli utenti sono: " + this.rents);

	}

	
	
	
}
