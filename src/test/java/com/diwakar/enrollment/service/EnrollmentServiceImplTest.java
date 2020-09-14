package com.diwakar.enrollment.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.diwakar.enrollment.dao.EnrolleeRepository;
import com.diwakar.enrollment.model.Enrollee;

@ExtendWith(MockitoExtension.class)
class EnrollmentServiceImplTest {

	@Mock
	EnrolleeRepository enRepo;

	@Mock
	MongoOperations mongoOperations;

	@Test
	void testDeleteEnrollee() {
		enRepo.deleteByEnrolleeId("3");
	}

	@Test
	void testAddNewRnrollee() {
		mongoOperations.save(new Enrollee("55342", "Diwakar", "True", "14/08/1981", "9888019121"));

	}

	@Test
	void testModifyEnrollee() {
		Query query = new Query();
		query.addCriteria(Criteria.where("enrolleeId").is("5"));
		Enrollee enr = mongoOperations.findOne(query, Enrollee.class);
		Enrollee enrollee = new Enrollee("55342", "Diwakar", "True", "14/08/1981", "9888019121");
		if (enr != null) {
			enr.setEnrolleeName(enrollee.getEnrolleeName());
			enr.setEnrolleeStatus(enrollee.getEnrolleeStatus());
			enr.setEnrolleeDOB(enrollee.getEnrolleeDOB());
			if (enrollee.getPhoneNumber() != null) {
				enr.setPhoneNumber(enrollee.getPhoneNumber());
			}
			mongoOperations.findAndReplace(query, enr);
		}

	}

}
