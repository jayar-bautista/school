package com.amdrill.school.domain;

import org.springframework.beans.BeanUtils;

import com.amdrill.school.dto.SubjectInput;
import com.amdrill.school.dto.SubjectOutput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subject extends BaseDomain<SubjectOutput> {
	private String name;
	private String grade;
	private String description;

	public Subject() {
	}

	public Subject(SubjectInput subjectInput) {
		BeanUtils.copyProperties(subjectInput, this);
	}

	public SubjectOutput generateOutput() {
		SubjectOutput subjectOutput = new SubjectOutput();
		BeanUtils.copyProperties(this, subjectOutput);
		return subjectOutput;
	}
}
