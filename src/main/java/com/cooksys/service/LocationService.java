package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Location;
import com.cooksys.model.CountsResponse;

public interface LocationService {
	
	public Location newLocation(Location location);
	
	public Location updateLocation(Location location);
	
	public Boolean removeLocation(Long areaId);
	
	public Location incrementLocation(Location location);
	
	public Location decrementLocation(Location location);
	
	public Location incrementUser(Location location);
	
	public Location incrementReg(Location location);
	
	public List<Location> indexLocations();
	
	public Integer getLocationCount();

	public Long getAllTimeCount(Long areaId);

	public Long getUserCount(Long areaId);

	public List<CountsResponse> getWeekCounts(Boolean hits);

	public List<CountsResponse> getMonthCounts(Boolean hits);

	public List<CountsResponse> getYearCounts(Boolean hits);

	public List<CountsResponse> getAllTimeCounts(Boolean hits);

}
