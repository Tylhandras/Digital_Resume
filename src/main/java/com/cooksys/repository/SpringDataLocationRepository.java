package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Location;

public interface SpringDataLocationRepository extends JpaRepository<Location, Long> {
	
	Location findByAreaId(Long areaId);

}
