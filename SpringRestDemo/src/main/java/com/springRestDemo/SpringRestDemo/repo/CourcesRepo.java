package com.springRestDemo.SpringRestDemo.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springRestDemo.SpringRestDemo.entity.Cources;

@Repository
public interface CourcesRepo extends CrudRepository<Cources, Long> {


}
