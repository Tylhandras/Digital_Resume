package com.cooksys.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cooksys.entity.Date;
import com.cooksys.entity.Location;
import com.cooksys.model.CountsResponse;
import com.cooksys.repository.DateRepository;
import com.cooksys.service.DateService;

public class DataServiceImpl implements DateService {
	
	@Autowired
	private DateRepository repo;

	@Override
	public Date getDailyCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountsResponse getWeekCount() {
		LocalDate today = LocalDate.now();
		List<Location> list;
		Date tmp;
		CountsResponse result;
		
		for (int i=0;i<7;i++) {
			tmp = repo.findByDateStamp(today);
			list = tmp.getLocations();
			for (Location temp : list) {
				
			}
		}
		
		return null;
	}

	@Override
	public CountsResponse getMonthCount() {
		LocalDate today = LocalDate.now();
		CountsResponse result;
		for (int i=0;i<30;i++) {}
		return null;
	}

	@Override
	public CountsResponse getYearCount() {
		LocalDate today = LocalDate.now();
		CountsResponse result;
		int length;
		
		if (today.isLeapYear())
			length = 366;
		else
			length = 365;
		
		for (int i=0;i<length;i++) {}
		
		return null;
	}

	@Override
	public CountsResponse getAllCount() {
		LocalDate today = LocalDate.now();
		for (int i=0;i<7;i++) {}
		return null;
	}

}
