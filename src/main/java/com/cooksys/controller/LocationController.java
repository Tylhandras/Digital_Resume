package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Location;
import com.cooksys.model.CountsResponse;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("location")
public class LocationController {
	
	@Autowired
	private LocationService locServ;
	
	@RequestMapping(value = "newLocation", method = RequestMethod.POST)
	public void newLocation(@RequestBody Location location) {
		locServ.newLocation(location);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Location updateLocation(@RequestBody Location location) {
		return locServ.updateLocation(location);
	}
	
	@RequestMapping(value="/{areaId}", method = RequestMethod.DELETE)
	public void removeLocation(@PathVariable Long areaId) {
		locServ.removeLocation(areaId);
	}
	
	@RequestMapping(value = "increment", method = RequestMethod.POST)
	public void increment(@RequestBody Location location) {
		locServ.incrementLocation(location);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Location> index() {
		return locServ.indexLocations();
	}
	
	@RequestMapping(value="count", method = RequestMethod.GET)
	public Integer numLocations() {
		return locServ.getLocationCount();
	}

}
