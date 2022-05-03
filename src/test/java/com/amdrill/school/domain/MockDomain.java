package com.amdrill.school.domain;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

import com.amdrill.school.domain.MockDomain.MockApiOutput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MockDomain extends BaseMockDomain implements Domain<MockApiOutput, String> {

	public static final String UPDATED_NAME = "UpdatedTestName";
	public static final String NAME = "TestName";
	public static final String ID = "TestId";

	@Id
	private String id;

	public MockDomain() {
	}

	public MockDomain(MockApiInput mockApiInput) {
		BeanUtils.copyProperties(mockApiInput, this);
	}

	public MockApiOutput generateOutput() {
		MockApiOutput mockApiOutput = new MockApiOutput();
		BeanUtils.copyProperties(this, mockApiOutput);
		return mockApiOutput;
	}

	public static class MockApiInput extends BaseMockDomain implements ApiInput {
	}

	@Getter
	@Setter
	public static class MockApiOutput extends BaseMockDomain implements ApiOutput {
		private String id;
	}

	public static MockApiInput createApiInput() {
		MockApiInput mockApiInput = new MockApiInput();
		mockApiInput.setName(NAME);
		return mockApiInput;
	}

	public static MockDomain createDomain() {
		MockDomain mockDomain = new MockDomain();
		mockDomain.setName(NAME);
		mockDomain.setId(ID);
		return mockDomain;
	}

}

@Getter
@Setter
abstract class BaseMockDomain {
	private String name;
}
