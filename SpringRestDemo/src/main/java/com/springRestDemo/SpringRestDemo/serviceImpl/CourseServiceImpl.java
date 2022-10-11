package com.springRestDemo.SpringRestDemo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springRestDemo.SpringRestDemo.entity.Cources;
import com.springRestDemo.SpringRestDemo.exception.BusinessException;
import com.springRestDemo.SpringRestDemo.repo.CourcesRepo;
import com.springRestDemo.SpringRestDemo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourcesRepo courcesRepo;

	@Override
	public List<Cources> getCources() {
		return (List<Cources>) courcesRepo.findAll();
	}

	@Override
	public Optional<Cources> getCourse(Long id) {
		return courcesRepo.findById(id);
	}

	@Override
	public Cources addCource(Cources cources) {
		try {
			if(cources.getCourceName().isEmpty()||cources.getCourceName().length()==0) {
				throw new BusinessException("601", "Please send Proper information, it Blank"); 
			}
			return courcesRepo.save(cources);
		}catch (Exception e) {
			
		}
		return cources;
	}

	@Override
	public Cources updateCource(Long id, Cources cources) {
		Cources updateCource = courcesRepo.findById(id).orElseThrow();
		updateCource.setCourceName(cources.getCourceName());
		return courcesRepo.save(updateCource);
	}

	@Override
	public String deleteCource(Long id) {
		Cources isDeleteCource = courcesRepo.findById(id).orElseThrow();

		if (isDeleteCource.getCourceName() != null) {
			courcesRepo.delete(isDeleteCource);
			return "Succesful deleted..";
		} else {
			return "Not found ...";
		}
	}

}
