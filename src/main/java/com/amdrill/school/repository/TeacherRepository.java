package com.amdrill.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdrill.school.domain.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
