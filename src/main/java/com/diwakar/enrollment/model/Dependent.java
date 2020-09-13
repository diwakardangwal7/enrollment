package com.diwakar.enrollment.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

/**
 * Simple JavaBean domain object representing a Dependent.
 * Same class is used as Data Transfer object from server to client
 * and DAO for persisting in Mongo DB. Though separate objects should be used 
 * for representing these but due to time constraint using it for now 
 * can be refactored when time permits
 * @author Diwakar
 */

@Validated
@Document(collection = "dependents")
public class Dependent {

	@NotNull
	private String dependentId;

	@NotNull
	private String dependentName;

	@NotNull
	private String dependentDOB;

	public String getDependentId() {
		return dependentId;
	}

	public void setDependentId(String dependentId) {
		this.dependentId = dependentId;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public String getDependentDOB() {
		return dependentDOB;
	}

	public void setDependentDOB(String dependentDOB) {
		this.dependentDOB = dependentDOB;
	}

}