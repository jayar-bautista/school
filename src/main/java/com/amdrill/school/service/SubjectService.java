package com.amdrill.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.amdrill.school.domain.Subject;
import com.amdrill.school.dto.SubjectInput;
import com.amdrill.school.dto.SubjectOutput;

@Service
public class SubjectService extends BaseCrudService<Subject, SubjectInput, SubjectOutput> {

	@Autowired
	public SubjectService(MongoRepository<Subject, String> mongoRepository) {
		super(mongoRepository, Subject.class);
	}
}
