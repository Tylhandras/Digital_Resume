package com.cooksys.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Date")
public class Date {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@JoinColumn
	private LocalDate dateStamp;
	
	@Column
	@ElementCollection(targetClass=Location.class)
	private List<Location> locations;

	public Date() {
		super();
	}

	public Date(LocalDate dateStamp) {
		super();
		this.dateStamp = dateStamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateStamp() {
		return dateStamp;
	}

	public void setDateStamp(LocalDate dateStamp) {
		this.dateStamp = dateStamp;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}
