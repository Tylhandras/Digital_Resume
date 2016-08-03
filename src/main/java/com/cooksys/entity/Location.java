package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
public class Location {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@JoinColumn
	private Long areaId;
	
	@JoinColumn
	private Date currentDay;
	
	@Column
	private String title;
	
	@Column
	private String link;
	
	@Column
	private String description;
	
	@Column
	private Long anonHits = 0L;
	
	@Column
	private Long userHits = 0L;
	
	@Column
	private Long registers = 0L;

	public Location() {
		super();
	}

	public Location(Long areaId, String title, String link) {
		super();
		this.areaId = areaId;
		this.title = title;
		this.link = link;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Date getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(Date currentDay) {
		this.currentDay = currentDay;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAnonHits() {
		return anonHits;
	}

	public void setAnonHits(Long anonHits) {
		this.anonHits = anonHits;
	}

	public Long getUserHits() {
		return userHits;
	}

	public void setUserHits(Long userHits) {
		this.userHits = userHits;
	}

	public Long getRegisters() {
		return registers;
	}

	public void setRegisters(Long registers) {
		this.registers = registers;
	}

}
