package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer>{
	
	@Query("Select t from Test as t group by t.userid")
	List<Test> getIndividual();

}