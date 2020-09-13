package com.diwakar.enrollment.rest;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Request object to modify enrollee information
 * 
 * @author Diwakar
 */

public class ModifyEnrolleeRequest {

	@NotNull(message = "enrolleeName is required")
	private String enrolleeName;

	@NotNull(message = "enrolleeStatus is required")
	private String enrolleeStatus;

	@NotNull(message = "dateOfBirth is required")
	@JsonFormat(pattern = "YYYY/MM/DD")
	private String enrolleeDOB;

	private String phoneNumber;

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

	public void setEnrolleeDOB(String enrolleeDOB) {
		this.enrolleeDOB = enrolleeDOB;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
