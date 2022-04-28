package com.amdrill.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdrill.school.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}
