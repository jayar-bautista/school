package com.amdrill.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.amdrill.school.domain.Student;
import com.amdrill.school.dto.StudentInput;
import com.amdrill.school.dto.StudentOutput;

@Service
public class StudentService extends BaseCrudService<Student, StudentInput, StudentOutput> {

	@Autowired
	public StudentService(MongoRepository<Student, String> mongoRepository) {
		super(mongoRepository, Student.class);
	}
}
