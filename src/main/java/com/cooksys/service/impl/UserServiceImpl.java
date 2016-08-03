package com.cooksys.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.User;
import com.cooksys.repository.SpringDataUserRepository;
import com.cooksys.service.LocationService;
import com.cooksys.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private SpringDataUserRepository repo;
	
	@Autowired
	private LocationService locServ;

	@Override
	public User newUser(User user) {
		if (repo.findByUsername(user.getUsername()) == null) {
			if (user.getLocationId() != null)
				user.setLocationId(locServ.incrementUser(user.getLocationId()));
			em.persist(user);
			return repo.findByUsername(user.getUsername());
		} else
			return null;
	}

	@Override
	public User userLogin(User user) {
		User tmp = repo.findByUsername(user.getUsername());
		if (tmp.getPassword().equals(user.getPassword())) {
			if (user.getLocationId() != null)
				locServ.decrementLocation(user.getLocationId());
			return tmp;
		}
		return null;
	}

	@Override
	public List<User> getUsersByLocation(Long areaId) {
		return repo.findByLocationIdAreaId(areaId);
	}

}
