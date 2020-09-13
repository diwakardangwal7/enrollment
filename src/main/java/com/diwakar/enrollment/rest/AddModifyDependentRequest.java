package com.diwakar.enrollment.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.diwakar.enrollment.model.Dependent;

/**
 * Request object to encapsulate dependents of a enrollee. This is used for
 * adding or modifying one or more dependents of an enrollee.
 * 
 * @author Diwakar
 */

public class AddModifyDependentRequest {

	@NotNull(message = "dependents information is required")
	private List<Dependent> dependents;

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

}
