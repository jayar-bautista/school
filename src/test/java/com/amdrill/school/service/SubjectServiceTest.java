package com.amdrill.school.service;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdrill.school.domain.Subject;

class SubjectServiceTest {
	@Mock
	private MongoRepository<Subject, String> mongoRepository;

	@Test
	void givenMongoRepositoryWhenSubjectServiceConstructorIsCalledThenFieldIsAssigned() {
		SubjectService subjectService = new SubjectService(mongoRepository);

		assertSame(mongoRepository, subjectService.getMongoRepository());
	}
}
