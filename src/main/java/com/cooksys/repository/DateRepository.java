package com.cooksys.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Date;

public interface DateRepository extends JpaRepository<Date, Long>{

	Date findByDateStamp(LocalDate today);

}
