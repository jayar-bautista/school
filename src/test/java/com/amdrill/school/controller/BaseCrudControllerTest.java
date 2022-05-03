package com.amdrill.school.controller;

import static com.amdrill.school.domain.MockDomain.ID;
import static com.amdrill.school.domain.MockDomain.NAME;
import static com.amdrill.school.domain.MockDomain.createApiInput;
import static com.amdrill.school.domain.MockDomain.createDomain;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.amdrill.school.domain.MockDomain;
import com.amdrill.school.domain.MockDomain.MockApiInput;
import com.amdrill.school.domain.MockDomain.MockApiOutput;
import com.amdrill.school.service.CrudService;

@ExtendWith(MockitoExtension.class)
public class BaseCrudControllerTest {

	@Mock
	private CrudService<MockApiInput, MockApiOutput, String> crudService;

	private CrudController<MockApiInput, MockApiOutput, String> crudController;
	private MockApiInput mockApiInput;
	private MockDomain mockDomain;
	private MockApiOutput mockOutput;

	@BeforeEach
	public void init() {
		crudController = new MockCrudController(crudService);
		mockApiInput = createApiInput();
		mockDomain = createDomain();
		mockOutput = mockDomain.generateOutput();
	}

	@Test
	public void givenMockApiInputWhenCreateIsInvokedThenMockApiOutputIsReturned() {
		when(crudService.create(mockApiInput)).thenReturn(mockOutput);

		ResponseEntity<MockApiOutput> responseEntity = crudController.create(mockApiInput);
		MockApiOutput result = responseEntity.getBody();

		assertSame(mockDomain.getId(), result.getId());
		assertSame(mockDomain.getName(), result.getName());
	}

	@Test
	public void givenIdWhenReadIsInvokedThenMockApiOutputIsReturned() {
		when(crudService.read(ID)).thenReturn(mockOutput);

		ResponseEntity<MockApiOutput> responseEntity = crudController.read(ID);
		MockApiOutput result = responseEntity.getBody();

		assertSame(ID, result.getId());
		assertSame(NAME, result.getName());
	}

	@Test
	public void givenCrudServiceWhenReadIsInvokedThenMockApiOutputIsReturned() {
		List<MockApiOutput> mockApiOutputs = Collections.singletonList(mockOutput);
		when(crudService.read()).thenReturn(mockApiOutputs);

		ResponseEntity<List<MockApiOutput>> responseEntity = crudController.read();
		List<MockApiOutput> results = responseEntity.getBody();
		MockApiOutput result = results.get(0);

		assertSame(ID, result.getId());
		assertSame(NAME, result.getName());
	}

	@Test
	public void givenMockApiInputWhenUpdateIsInvokedThenMockApiOutputIsReturned() {
		when(crudService.update(mockApiInput, ID)).thenReturn(mockOutput);

		ResponseEntity<MockApiOutput> responseEntity = crudController.update(mockApiInput, ID);
		MockApiOutput result = responseEntity.getBody();

		assertSame(mockDomain.getId(), result.getId());
		assertSame(mockDomain.getName(), result.getName());
	}

	@Test
	public void givenIdWhenDeleteIsInvokedThenCrudServiceDeleteIsCalled() {
		crudController.delete(ID);

		verify(crudService, times(1)).delete(ID);
	}

	private class MockCrudController extends BaseCrudController<MockApiInput, MockApiOutput, String> {

		protected MockCrudController(CrudService<MockApiInput, MockApiOutput, String> crudService) {
			super(crudService);
		}
	}
}