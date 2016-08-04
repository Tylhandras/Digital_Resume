package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Date;
import com.cooksys.model.CountsResponse;

public interface DateService {
	
	public Date getDailyCount();
	
	public CountsResponse getWeekCount();
	
	public CountsResponse getMonthCount();
	
	public CountsResponse getYearCount();
	
	public CountsResponse getAllCount();

}
