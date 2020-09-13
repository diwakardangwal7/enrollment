package com.diwakar.enrollment.rest;

import java.util.Arrays;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diwakar.enrollment.exception.RequestValidationException;
import com.diwakar.enrollment.model.Dependent;
import com.diwakar.enrollment.model.Enrollee;
import com.diwakar.enrollment.service.EnrollmentService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Main rest controller class which acts as central pillar for Enrollee and
 * Dependent resource by intercepting all HTTP requests and calls appropriate
 * service layer methods. Every method of this returns a specific HTTP code to
 * the client based on the result of the operation.
 * 
 * @author Diwakar
 */

@RestController
@RequestMapping("/v1")
public class EnrollmentRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnrollmentRestController.class);

	@Autowired
	EnrollmentService EnrolleeService;

	// Get Request for finding Enrollee by id
	@RequestMapping(value = "/{enrollment_id}", method = RequestMethod.GET)
	public ResponseEntity<Enrollee> getEnrolleeById(@PathVariable("enrollment_id") String id) throws Exception {

		LOGGER.info("Finding enrollee with id" + id);
		return new ResponseEntity<Enrollee>(EnrolleeService.findEnrolleeById(id), HttpStatus.OK);

	}

	// Post Request for adding a new Enrollee
	@RequestMapping(value = "/addEnrollee", method = RequestMethod.POST)
	public ResponseEntity<Enrollee> addNewRnrollee(@Valid @RequestBody Enrollee request) throws Exception {

		return new ResponseEntity<Enrollee>(EnrolleeService.addNewRnrollee(request), HttpStatus.CREATED);

	}

	// Put request for updating Enrollee information
	@RequestMapping(value = "/updateEnrollee/{Enrollee_id}", method = RequestMethod.PUT)
	public ResponseEntity<Enrollee> updateEnrollee(@Valid @RequestBody ModifyEnrolleeRequest request,
			@PathVariable("Enrollee_id") String id) {

		Enrollee enr = EnrolleeService.modifyEnrollee(request, id);

		return new ResponseEntity<Enrollee>(enr, HttpStatus.NO_CONTENT);
	}

	// Delete request for deleting Enrollee information
	@RequestMapping(value = "/deleteEnrollee/{Enrollee_id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEnrollee(@PathVariable("Enrollee_id") String id) throws Exception {

		EnrolleeService.deleteEnrollee(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// Post Request for adding a new Enrollee
	@RequestMapping(value = "/addEnrolleeDependents/{Enrollee_id}", method = RequestMethod.POST)
	public ResponseEntity<Void> addEnrolleeDependents(@PathVariable("Enrollee_id") String id,
			@Valid @RequestBody String request) throws Exception {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Dependent[] dependents = mapper.readValue(request, Dependent[].class);

			if (dependents != null) {
				// Check if all required fields are present in the request for dependents
				for (Dependent dep : dependents) {
					if ((dep.getDependentName() != null) && (dep.getDependentDOB() != null)
							&& (dep.getDependentId() != null)) {

					} else {
						throw new RequestValidationException(
								"Validation of request parameters failed , Please provide correct request parameters by checking"
										+ " API documentation for correct request parameters to be sent");
					}

				}

				EnrolleeService.addEnrolleeDependents(id, Arrays.asList(dependents));
			} else {
				throw new RequestValidationException(
						"Validation of request parameters failed , Please provide correct request parameters by checking API "
								+ "documentation for correct request parameters to be sent");
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// Put Request for modifying dependents of an Enrollee
	@RequestMapping(value = "/modifyEnrolleeDependents/{Enrollee_id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> modifyEnrolleeDependents(@PathVariable("Enrollee_id") String id,
			@Valid @RequestBody String request) throws Exception {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Dependent[] dependents = mapper.readValue(request, Dependent[].class);

			if (dependents != null) {
				// Check if all required fields are present in the request for dependents
				for (Dependent dep : dependents) {
					if ((dep.getDependentName() != null) && (dep.getDependentDOB() != null)
							&& (dep.getDependentId() != null)) {

					} else {
						throw new RequestValidationException(
								"Validation of request parameters failed , Please provide correct request parameters by checking"
										+ " API documentation for correct request parameters to be sent");
					}

				}

				EnrolleeService.addEnrolleeDependents(id, Arrays.asList(dependents));
			} else {
				throw new RequestValidationException(
						"Validation of request parameters failed , Please provide correct request parameters by checking API "
								+ "documentation for correct request parameters to be sent");
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// Delete request for deleting all dependents of Enrollee
	@RequestMapping(value = "/deleteDependentsOfEnrollee/{Enrollee_id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDependentsOfEnrollee(@PathVariable("Enrollee_id") String id) throws Exception {

		EnrolleeService.deleteDependentsOfEnrollee(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
