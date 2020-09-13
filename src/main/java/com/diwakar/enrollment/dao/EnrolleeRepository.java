package com.diwakar.enrollment.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diwakar.enrollment.model.Enrollee;

@Repository
public interface EnrolleeRepository extends MongoRepository<Enrollee, String> {
	
	Enrollee findByEnrolleeId(String enrolleeId);
	void deleteByEnrolleeId(String enrolleeId);

}
