package com.springRestDemo.SpringRestDemo.comtroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springRestDemo.SpringRestDemo.entity.Cources;
import com.springRestDemo.SpringRestDemo.service.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/cources")
	public List<Cources> getCources(){
		return courseService.getCources();
	}
	
	@GetMapping("/cources/{id}")
	public Optional<Cources> getCourse(@PathVariable Long id) {
		return courseService.getCourse(id);
	}
	
	@PostMapping("/cources")
	public Cources addCource(@RequestBody Cources cources) {
		return  courseService.addCource(cources);
	}
	
	@PutMapping("/cources/{id}")
	public ResponseEntity<Cources> updateCource(@PathVariable Long id,@RequestBody Cources cources) {
		return ResponseEntity.ok(courseService.updateCource(id, cources));
	}
	
	@DeleteMapping("/cources/{id}")
	public ResponseEntity<String> deleteCource(@PathVariable Long id){
		
		return ResponseEntity.ok(courseService.deleteCource(id));
	}
	
	
}
