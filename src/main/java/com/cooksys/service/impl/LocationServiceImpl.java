package com.cooksys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Location;
import com.cooksys.model.CountsResponse;
import com.cooksys.repository.LocationRepository;
import com.cooksys.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository repo;
	
	@Autowired
	private EntityManager em;

	@Override
	public Location newLocation(Location location) {
		if (repo.findByAreaId(location.getAreaId()) == null) {
			em.persist(location);
			return null;
		}
		else {
			return em.merge(repo.findByAreaId(location.getAreaId()));
		}
	}
	
	@Override
	public Location updateLocation(Location location) {
		Location temp;
		if ((temp = repo.findByAreaId(location.getAreaId())) != null) 
		{
			temp.setDescription(location.getDescription());
			return em.merge(temp);
		}
		return null;
	}
	
	@Override
	public Boolean removeLocation(Long areaId) {
		if (repo.findByAreaId(areaId) != null) {
			Location tmp = repo.findByAreaId(areaId);
			em.remove(tmp);
			return true;
		}
		
		return false;
	}

	@Override
	public Location incrementLocation(Location location) {
		if (repo.findByAreaId(location.getAreaId()) != null) {
			Location tmp = repo.findByAreaId(location.getAreaId());
			tmp.setAnonHits(repo.findByAreaId(location.getAreaId()).getAnonHits() + 1);
			em.merge(tmp);
			return tmp;
		}
		return null;
	}
	
	@Override
	public Location decrementLocation(Location location) {
		if (repo.findByAreaId(location.getAreaId()) != null) {
			Location tmp = repo.findByAreaId(location.getAreaId());
			tmp.setAnonHits(repo.findByAreaId(location.getAreaId()).getAnonHits() - 1);
			em.merge(tmp);
			return tmp;
		}
		return null;
	}
	
	@Override
	public Location incrementUser(Location location) {
		if (repo.findByAreaId(location.getAreaId()) != null) {
			Location tmp = repo.findByAreaId(location.getAreaId());
			tmp.setUserHits(repo.findByAreaId(location.getAreaId()).getUserHits() + 1);
			em.merge(tmp);
			return tmp;
		}
		return null;
	}
	
	@Override
	public Location incrementReg(Location location) {
		if (repo.findByAreaId(location.getAreaId()) != null) {
			Location tmp = repo.findByAreaId(location.getAreaId());
			tmp.setRegisters(repo.findByAreaId(location.getAreaId()).getRegisters() + 1);
			em.merge(tmp);
			return tmp;
		}
		return null;
	}

	@Override
	public List<Location> indexLocations() {
		return repo.findAll();
	}

	@Override
	public Integer getLocationCount() {
		return repo.findAll().size();
	}
	
	@Override
	public List<CountsResponse> getWeekCounts(Boolean hits) {
		return null;
	}
	
	@Override
	public List<CountsResponse> getMonthCounts(Boolean hits) {
		return null;
	}
	
	@Override
	public List<CountsResponse> getYearCounts(Boolean hits) {
		return null;
	}
	
	@Override
	public List<CountsResponse> getAllTimeCounts(Boolean hits) {
		return null;
	}

}
