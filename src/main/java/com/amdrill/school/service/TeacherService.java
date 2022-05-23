package com.amdrill.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.amdrill.school.domain.Teacher;
import com.amdrill.school.dto.TeacherInput;
import com.amdrill.school.dto.TeacherOutput;

@Service
public class TeacherService extends BaseCrudService<Teacher, TeacherInput, TeacherOutput> {

	@Autowired
	public TeacherService(MongoRepository<Teacher, String> mongoRepository) {
		super(mongoRepository, Teacher.class);
	}
}