package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@ManyToOne
	@JoinColumn(name = "locationId")
	private Location locationId;

	public User() {
		super();
	}

	public User(String username, String password, String role, Location locationId) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.locationId = locationId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Location getLocationId() {
		return locationId;
	}

	public void setLocationId(Location location) {
		this.locationId = location;
	}

}
