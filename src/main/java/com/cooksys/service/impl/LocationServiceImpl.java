package com.cooksys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Location;
import com.cooksys.model.CountsResponse;
import com.cooksys.repository.SpringDataLocationRepository;
import com.cooksys.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private SpringDataLocationRepository repo;
	
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
			tmp.setWeekUser(repo.findByAreaId(location.getAreaId()).getWeekAnon() + 1);
			tmp.setMonthUser(repo.findByAreaId(location.getAreaId()).getMonthAnon() + 1);
			tmp.setYearUser(repo.findByAreaId(location.getAreaId()).getYearAnon() + 1);
			tmp.setAllTimeUser(repo.findByAreaId(location.getAreaId()).getAllTimeAnon() + 1);
			em.merge(tmp);
			return tmp;
		}
		return null;
	}
	
	@Override
	public Location decrementLocation(Location location) {
		if (repo.findByAreaId(location.getAreaId()) != null) {
			Location tmp = repo.findByAreaId(location.getAreaId());
			tmp.setWeekUser(repo.findByAreaId(location.getAreaId()).getWeekAnon() - 1);
			tmp.setMonthUser(repo.findByAreaId(location.getAreaId()).getMonthAnon() - 1);
			tmp.setYearUser(repo.findByAreaId(location.getAreaId()).getYearAnon() - 1);
			tmp.setAllTimeUser(repo.findByAreaId(location.getAreaId()).getAllTimeAnon() - 1);
			em.merge(tmp);
			return tmp;
		}
		return null;
	}
	
	@Override
	public Location incrementUser(Location location) {
		if (repo.findByAreaId(location.getAreaId()) != null) {
			Location tmp = repo.findByAreaId(location.getAreaId());
			tmp.setWeekUser(repo.findByAreaId(location.getAreaId()).getWeekUser() + 1);
			tmp.setMonthUser(repo.findByAreaId(location.getAreaId()).getMonthUser() + 1);
			tmp.setYearUser(repo.findByAreaId(location.getAreaId()).getYearUser() + 1);
			tmp.setAllTimeUser(repo.findByAreaId(location.getAreaId()).getAllTimeUser() + 1);
			em.merge(tmp);
			return tmp;
		}
		return null;
	}
	
	@Override
	public Location incrementReg(Location location) {
		if (repo.findByAreaId(location.getAreaId()) != null) {
			Location tmp = repo.findByAreaId(location.getAreaId());
			tmp.setWeekUser(repo.findByAreaId(location.getAreaId()).getWeekReg() + 1);
			tmp.setMonthUser(repo.findByAreaId(location.getAreaId()).getMonthReg() + 1);
			tmp.setYearUser(repo.findByAreaId(location.getAreaId()).getYearReg() + 1);
			tmp.setAllTimeUser(repo.findByAreaId(location.getAreaId()).getAllTimeReg() + 1);
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
	public Long getAllTimeCount(Long areaId) {
		return repo.findByAreaId(areaId).getAllTimeAnon();
	}

	@Override
	public Long getUserCount(Long areaId) {
		return repo.findByAreaId(areaId).getAllTimeUser();
	}
	
	@Override
	public List<CountsResponse> getWeekCounts(Boolean hits) {
		List<Location> temp = repo.findAll();
		List<CountsResponse> result = new ArrayList<>();
		
		if (hits) {
			for (Location l : temp) {
				result.add(new CountsResponse(l.getTitle(), l.getWeekAnon(), l.getWeekUser(), 0L));
			}
		} else {
			for (Location l : temp) {
				if ((l.getWeekAnon() > 0) && (l.getWeekReg() / l.getWeekAnon()) > 0)
					result.add(new CountsResponse(l.getTitle(), l.getWeekAnon(), l.getWeekReg(),(l.getWeekReg() / l.getWeekAnon())));
				else
					result.add(new CountsResponse(l.getTitle(), l.getWeekAnon(), l.getWeekReg(), 0L));
			}
		}
		
		return result;
	}
	
	@Override
	public List<CountsResponse> getMonthCounts(Boolean hits) {
		List<Location> temp = repo.findAll();
		List<CountsResponse> result = new ArrayList<>();
		
		if (hits) {
			for (Location l : temp) {
				result.add(new CountsResponse(l.getTitle(), l.getMonthAnon(), l.getMonthUser(), 0L));
			}
		} else {
			for (Location l : temp) {
				if ((l.getMonthAnon() > 0) && (l.getMonthReg() / l.getMonthAnon()) > 0)
					result.add(new CountsResponse(l.getTitle(), l.getMonthAnon(), l.getMonthReg(),(l.getMonthReg() / l.getMonthAnon())));
				else
					result.add(new CountsResponse(l.getTitle(), l.getMonthAnon(), l.getMonthReg(), 0L));
			}
		}
		
		return result;
	}
	
	@Override
	public List<CountsResponse> getYearCounts(Boolean hits) {
		List<Location> temp = repo.findAll();
		List<CountsResponse> result = new ArrayList<>();
		
		if (hits) {
			for (Location l : temp) {
				result.add(new CountsResponse(l.getTitle(), l.getYearAnon(), l.getYearUser(), 0L));
			}
		} else {
			for (Location l : temp) {
				if ((l.getYearAnon() > 0) && (l.getYearReg() / l.getYearAnon()) > 0)
					result.add(new CountsResponse(l.getTitle(), l.getYearAnon(), l.getYearReg(),(l.getYearReg() / l.getYearAnon())));
				else
					result.add(new CountsResponse(l.getTitle(), l.getYearAnon(), l.getYearReg(), 0L));
			}
		}
		
		return result;
	}
	
	@Override
	public List<CountsResponse> getAllTimeCounts(Boolean hits) {
		List<Location> temp = repo.findAll();
		List<CountsResponse> result = new ArrayList<>();
		
		if (hits) {
			for (Location l : temp) {
				result.add(new CountsResponse(l.getTitle(), l.getAllTimeAnon(), l.getAllTimeUser(), 0L));
			}
		} else {
			for (Location l : temp) {
				if ((l.getAllTimeAnon() > 0) && (l.getAllTimeReg() / l.getAllTimeAnon()) > 0)
					result.add(new CountsResponse(l.getTitle(), l.getAllTimeAnon(), l.getAllTimeReg(),(l.getAllTimeReg() / l.getAllTimeAnon())));
				else
					result.add(new CountsResponse(l.getTitle(), l.getAllTimeAnon(), l.getAllTimeReg(), 0L));
			}
		}
		
		return result;
	}

}
