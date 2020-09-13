/**
 * 
 */
package com.diwakar.enrollment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.diwakar.enrollment.model.Enrollee;

/**
 * @author Diwakar
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class EnrollmentServiceImplTest {

	@InjectMocks
	private static EnrollmentService enrolService = new EnrollmentServiceImpl();

	private Enrollee enrollee;

	@Test
	public void testAddNewRnrollee() {

		Enrollee enrollee1 = new Enrollee("55342", "Diwakar", "True", "14/08/1981", "9888019122");

		assertEquals(enrollee, enrolService.addNewRnrollee(enrollee1));

	}

}
