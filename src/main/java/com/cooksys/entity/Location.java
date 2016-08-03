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
	
	@Column
	private String title;
	
	@Column
	private String link;
	
	@Column
	private String description;
	
	@Column
	private Long allTimeAnon = 0L;
	
	@Column
	private Long weekAnon = 0L;
	
	@Column
	private Long monthAnon = 0L;
	
	@Column
	private Long yearAnon = 0L;
	
	@Column
	private Long allTimeUser = 0L;
	
	@Column
	private Long weekUser = 0L;
	
	@Column
	private Long monthUser = 0L;
	
	@Column
	private Long yearUser = 0L;
	
	@Column
	private Long allTimeReg = 0L;
	
	@Column
	private Long weekReg = 0L;
	
	@Column
	private Long monthReg = 0L;
	
	@Column
	private Long yearReg = 0L;

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

	public Long getAllTimeAnon() {
		return allTimeAnon;
	}

	public void setAllTimeAnon(Long allTimeAnon) {
		this.allTimeAnon = allTimeAnon;
	}

	public Long getWeekAnon() {
		return weekAnon;
	}

	public void setWeekAnon(Long weekAnon) {
		this.weekAnon = weekAnon;
	}

	public Long getMonthAnon() {
		return monthAnon;
	}

	public void setMonthAnon(Long monthAnon) {
		this.monthAnon = monthAnon;
	}

	public Long getYearAnon() {
		return yearAnon;
	}

	public void setYearAnon(Long yearAnon) {
		this.yearAnon = yearAnon;
	}

	public Long getAllTimeUser() {
		return allTimeUser;
	}

	public void setAllTimeUser(Long allTimeUser) {
		this.allTimeUser = allTimeUser;
	}

	public Long getWeekUser() {
		return weekUser;
	}

	public void setWeekUser(Long weekUser) {
		this.weekUser = weekUser;
	}

	public Long getMonthUser() {
		return monthUser;
	}

	public void setMonthUser(Long monthUser) {
		this.monthUser = monthUser;
	}

	public Long getYearUser() {
		return yearUser;
	}

	public void setYearUser(Long yearUser) {
		this.yearUser = yearUser;
	}

	public Long getAllTimeReg() {
		return allTimeReg;
	}

	public void setAllTimeReg(Long allTimeReg) {
		this.allTimeReg = allTimeReg;
	}

	public Long getWeekReg() {
		return weekReg;
	}

	public void setWeekReg(Long weekReg) {
		this.weekReg = weekReg;
	}

	public Long getMonthReg() {
		return monthReg;
	}

	public void setMonthReg(Long monthReg) {
		this.monthReg = monthReg;
	}

	public Long getYearReg() {
		return yearReg;
	}

	public void setYearReg(Long yearReg) {
		this.yearReg = yearReg;
	}

}
