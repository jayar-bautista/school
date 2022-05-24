package com.amdrill.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdrill.school.domain.Subject;

public interface SubjectRepository extends MongoRepository<Subject, String> {
}
