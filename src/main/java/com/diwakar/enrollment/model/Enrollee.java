package com.diwakar.enrollment.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Simple JavaBean domain object representing an Enrollee.
 * Same class is used as Data Transfer object from server to client
 * and DAO for persisting in Mongo DB. Though separate objects should be used 
 * for representing these but due to time constraint using it for now, 
 * can be refactored when time permits
 * @author Diwakar
 */
@Validated
@Document(collection = "enrollees")
public class Enrollee {

	@NotNull(message = "enrolleeId is required")
	@Indexed(unique=true)
	private String enrolleeId;

	@NotNull(message = "enrolleeName is required")
	private String enrolleeName;

	@NotNull(message = "enrolleeStatus is required")
	private String enrolleeStatus;

	@NotNull(message = "dateOfBirth is required")
	@JsonFormat(pattern = "YYYY/MM/DD")
	private String enrolleeDOB;

	private String phoneNumber;

	private List<Dependent> dependentsList;

	public String getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(String enrolleeId) {
		this.enrolleeId = enrolleeId;
	}

	public String getEnrolleeName() {
		return enrolleeName;
	}

	public void setEnrolleeName(String enrolleeName) {
		this.enrolleeName = enrolleeName;
	}

	public String getEnrolleeStatus() {
		return enrolleeStatus;
	}

	public void setEnrolleeStatus(String enrolleeStatus) {
		this.enrolleeStatus = enrolleeStatus;
	}

	public String getEnrolleeDOB() {
		return enrolleeDOB;
	}

	public void setEnrolleeDOB(String enrolleeDOB2) {
		this.enrolleeDOB = enrolleeDOB2;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Dependent> getDependentsList() {
		return dependentsList;
	}

	public void setDependentsList(List<Dependent> dependentsList) {
		this.dependentsList = dependentsList;
	}

}