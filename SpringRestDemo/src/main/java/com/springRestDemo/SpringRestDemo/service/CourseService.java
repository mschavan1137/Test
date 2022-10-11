package com.springRestDemo.SpringRestDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springRestDemo.SpringRestDemo.entity.Cources;

public interface CourseService {
	
	public List<Cources> getCources();
	
	public Optional<Cources> getCourse(Long id);

	public Cources addCource(Cources cources);
	
	public Cources updateCource(Long id,Cources cources);

	public String deleteCource(Long id);
	
	
	
}
