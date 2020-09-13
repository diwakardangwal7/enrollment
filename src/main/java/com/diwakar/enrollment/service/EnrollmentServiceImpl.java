package com.diwakar.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diwakar.enrollment.dao.EnrolleeRepository;
import com.diwakar.enrollment.exception.EnrolleeNotFoundException;
import com.diwakar.enrollment.exception.EnrollmentMethodNotAllowedException;
import com.diwakar.enrollment.model.Dependent;
import com.diwakar.enrollment.model.Enrollee;
import com.diwakar.enrollment.rest.ModifyEnrolleeRequest;

/**
 * Contains method implemented(defined in service facade) to carry out
 * operations on DB and return required results.
 * 
 * @author Diwakar
 */

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	EnrolleeRepository enRepo;

	@Autowired
	MongoOperations mongoOperations;

	@Transactional
	public Enrollee addNewRnrollee(Enrollee enrollee) throws DataAccessException {

		Query query = new Query();
		query.addCriteria(Criteria.where("enrolleeId").is(enrollee.getEnrolleeId()));

		// Check if enrollee is already present in DB if yes then throw exception and
		// report back to client
		Enrollee enr = mongoOperations.findOne(query, Enrollee.class);
		if (enr != null) {
			throw new EnrollmentMethodNotAllowedException("Enrollee already exist");
		}

		try {
			enr = mongoOperations.save(enrollee);

			if (null != enr) {
				return enr;
			} else {
				throw new EnrollmentMethodNotAllowedException("Not able to save Enrollee");
			}
		} catch (Exception e) {

			throw e;
		}

	}

	@Transactional
	public Enrollee modifyEnrollee(ModifyEnrolleeRequest request, String id) {

		Query query = new Query();
		query.addCriteria(Criteria.where("enrolleeId").is(id));

		/*
		 * Check if enrollee is present in DB if no then throw exception and report back
		 * to client, if present take out the fields from the request and set in DB
		 */
		try {
			Enrollee enr = mongoOperations.findOne(query, Enrollee.class);

			if (enr != null) {
				enr.setEnrolleeName(request.getEnrolleeName());
				enr.setEnrolleeStatus(request.getEnrolleeStatus());
				enr.setEnrolleeDOB(request.getEnrolleeDOB());
				if (request.getPhoneNumber() != null) {
					enr.setPhoneNumber(request.getPhoneNumber());
				}

				enr = mongoOperations.findAndReplace(query, enr);
				return enr;
			} else {
				throw new EnrolleeNotFoundException("Enrollee doesnot exist");
			}
		} catch (Exception e) {

			throw e;

		}

	}

	public void deleteEnrollee(String id) {

		Query query = new Query();
		query.addCriteria(Criteria.where("enrolleeId").is(id));

		/*
		 * Check if enrollee is present in DB if no then throw exception and report back
		 * to client, if present delete it
		 */
		try {
			Enrollee enr = mongoOperations.findOne(query, Enrollee.class);

			if (enr != null) {
				enRepo.deleteByEnrolleeId(id);
			} else {
				throw new EnrolleeNotFoundException("Enrollee doesnot exist with id : " + id);
			}
		} catch (Exception e) {

			throw e;

		}

	}

	@Transactional
	public void addEnrolleeDependents(String enrolleeId, List<Dependent> dependents) throws DataAccessException {

		Query query = new Query();
		query.addCriteria(Criteria.where("enrolleeId").is(enrolleeId));

		/*
		 * Check if enrollee is present in DB if no then throw exception and report back
		 * to client, if present add its dependents by setting dependent list coming
		 * from request
		 */
		Enrollee enr = mongoOperations.findOne(query, Enrollee.class);

		try {
			if (enr != null) {
				enr.setDependentsList(dependents);
				mongoOperations.findAndReplace(query, enr);
			} else {
				throw new EnrolleeNotFoundException("Enrollee doesnot exist with id : " + enrolleeId);
			}
		} catch (Exception e) {
			//
			throw e;

		}

	}

	@Transactional
	public void modifyEnrolleeDependents(String enrolleeId, List<Dependent> dependents) throws DataAccessException {

		Query query = new Query();
		query.addCriteria(Criteria.where("enrolleeId").is(enrolleeId));

		/*
		 * Check if enrollee is present in DB if no then throw exception and report back
		 * to client, if present modify its dependents by setting dependent list coming
		 * from request
		 */
		Enrollee enr = mongoOperations.findOne(query, Enrollee.class);

		try {
			if (enr != null) {
				enr.setDependentsList(dependents);
				mongoOperations.findAndReplace(query, enr);
			} else {
				throw new EnrolleeNotFoundException("Enrollee doesnot exist with id : " + enrolleeId);
			}
		} catch (Exception e) {

			throw e;

		}

	}

	public void deleteDependentsOfEnrollee(String enrolleeId) throws DataAccessException {

		Query query = new Query();
		query.addCriteria(Criteria.where("enrolleeId").is(enrolleeId));

		/*
		 * Check if enrollee is present in DB if no then throw exception and report back
		 * to client, if present delete its dependents by setting dependent list as null
		 */
		Enrollee enr = mongoOperations.findOne(query, Enrollee.class);

		try {
			if (enr != null) {
				enr.setDependentsList(null);
				mongoOperations.findAndReplace(query, enr);
			} else {
				throw new EnrolleeNotFoundException("Enrollee doesnot exist with id : " + enrolleeId);
			}
		} catch (Exception e) {

			throw e;

		}

	}

	public Enrollee findEnrolleeById(String id) throws DataAccessException {
		Query query = new Query();
		query.addCriteria(Criteria.where("enrolleeId").is(id));

		Enrollee enr = mongoOperations.findOne(query, Enrollee.class);

		try {
			if (enr != null) {
				return enr;
			} else {
				throw new EnrolleeNotFoundException("Enrollee doesnot exist with id : " + id);
			}
		} catch (Exception e) {

			throw e;

		}

	}

}
