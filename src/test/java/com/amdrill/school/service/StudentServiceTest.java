package com.amdrill.school.service;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdrill.school.domain.Student;

class StudentServiceTest {
	@Mock
	private MongoRepository<Student, String> mongoRepository;

	@Test
	void givenMongoRepositoryWhenStudentServiceConstructorIsCalledThenFieldIsAssigned() {
		StudentService studentService = new StudentService(mongoRepository);

		assertSame(mongoRepository, studentService.getMongoRepository());
	}
}
