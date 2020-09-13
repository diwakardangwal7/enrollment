package com.diwakar.enrollment.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.diwakar.enrollment.model.Dependent;
import com.diwakar.enrollment.model.Enrollee;
import com.diwakar.enrollment.rest.ModifyEnrolleeRequest;

/**
 * Mostly used as a facade for service layer implementation
 * Contains methods which service layer must implement to perform DB operations
 * @author Diwakar
 */


public interface EnrollmentService {

	public Enrollee findEnrolleeById(String enrolleeId) throws DataAccessException;

	public Enrollee addNewRnrollee(Enrollee enrollee) throws DataAccessException;

	public Enrollee modifyEnrollee(ModifyEnrolleeRequest enrollee , String id) throws DataAccessException;

	public void deleteEnrollee(String enrolleeId) throws DataAccessException;

	public void addEnrolleeDependents(String enrolleeId, List<Dependent> dependents) throws DataAccessException;

	public void modifyEnrolleeDependents(String enrolleeId, List<Dependent> dependents) throws DataAccessException;

	public void deleteDependentsOfEnrollee(String enrolleeId) throws DataAccessException;

}