package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Location;

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

}
