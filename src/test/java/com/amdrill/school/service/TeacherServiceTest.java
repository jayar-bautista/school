package com.amdrill.school.service;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdrill.school.domain.Teacher;

public class TeacherServiceTest {
	@Mock
	private MongoRepository<Teacher, String> mongoRepository;

	@Test
	public void givenMongoRepositoryWhenTeacherServiceConstructorIsCalledThenFieldIsAssigned() {
		TeacherService teacherService = new TeacherService(mongoRepository);

		assertSame(mongoRepository, teacherService.getMongoRepository());
	}
}
