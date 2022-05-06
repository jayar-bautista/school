package com.amdrill.school.service;

import static com.amdrill.school.domain.MockDomain.ID;
import static com.amdrill.school.domain.MockDomain.NAME;
import static com.amdrill.school.domain.MockDomain.createApiInput;
import static com.amdrill.school.domain.MockDomain.createDomain;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdrill.school.domain.MockDomain;
import com.amdrill.school.domain.MockDomain.MockApiInput;
import com.amdrill.school.domain.MockDomain.MockApiOutput;

@ExtendWith(MockitoExtension.class)
public class BaseCrudServiceTest {

	private static final String ERROR_CREATING_DOMAIN = "Error encountered while creating domain instance";

	@Mock
	private MongoRepository<MockDomain, String> mongoRepository;

	@Mock
	private MongoRepository<DomainWithIssue, String> mongoRepositoryWithIssue;

	private CrudService<MockApiInput, MockApiOutput, String> crudService;
	private MockDomain mockDomain;

	@BeforeEach
	public void init() {
		crudService = new MockBaseCrudService(mongoRepository);
		mockDomain = createDomain();
	}

	@Test
	public void givenMongoRepositoryWhenCreateIsCalledThenIdIsReturned() {
		MockApiInput apiInput = createApiInput();
		when(mongoRepository.insert(any(MockDomain.class))).thenReturn(mockDomain);

		MockApiOutput result = crudService.create(apiInput);

		assertSame(mockDomain.getId(), result.getId());
		assertSame(mockDomain.getName(), result.getName());
	}

	@Test
	public void givenMongoRepositoryWhenReadWithIdIsCalledThenStudentOutputIsReturned() {
		when(mongoRepository.findById(mockDomain.getId())).thenReturn(Optional.of(mockDomain));

		MockApiOutput result = crudService.read(mockDomain.getId());

		assertSame(mockDomain.getId(), result.getId());
		assertSame(mockDomain.getName(), result.getName());
	}

	@Test
	public void givenMongoRepositoryWhenReadWithIdIsCalledThenNullIsReturned() {
		when(mongoRepository.findById(mockDomain.getId())).thenReturn(Optional.empty());

		MockApiOutput result = crudService.read(mockDomain.getId());

		assertNull(result);
	}

	@Test
	public void givenMongoRepositoryWhenReadIsCalledThenStudentOutputsIsReturned() {
		List<MockDomain> domains = Collections.singletonList(mockDomain);
		when(mongoRepository.findAll()).thenReturn(domains);

		List<MockApiOutput> results = crudService.read();

		assertSame(domains.size(), results.size());
		MockApiOutput result = results.get(0);
		MockDomain domain = domains.get(0);
		assertSame(domain.getId(), result.getId());
		assertSame(domain.getName(), result.getName());
	}

	@Test
	public void givenMongoRepositoryWhenDomainExistsThenSaveIsInvoked() {
		MockApiInput apiInput = createApiInput();
		when(mongoRepository.existsById(ID)).thenReturn(true);
		when(mongoRepository.save(any(MockDomain.class))).thenReturn(mockDomain);

		MockApiOutput result = crudService.update(apiInput, ID);

		assertSame(ID, result.getId());
		assertSame(NAME, result.getName());
	}

	@Test
	public void givenMongoRepositoryWhenDomainDoesNotExistsThenSaveIsInvoked() {
		MockApiInput apiInput = createApiInput();
		when(mongoRepository.existsById(ID)).thenReturn(false);

		MockApiOutput result = crudService.update(apiInput, ID);

		assertNull(result);
	}

	@Test
	public void givenMongoRepositoryWhenDeleteIsExecutedThenRepositoryDeleteIsInvoked() {
		crudService.delete(ID);

		verify(mongoRepository, times(1)).deleteById(ID);
	}

	@Test
	public void givenApiInputWhenCreateDomainIsInvokedThenDomainIsReturned() {
		MockApiInput mockApiInput = createApiInput();
		BaseCrudService<MockDomain, MockApiInput, MockApiOutput, String> baseCrudService = new BaseCrudService<>(
				mongoRepository, MockDomain.class) {
		};

		MockDomain result = baseCrudService.createDomain(mockApiInput);

		assertSame(mockApiInput.getName(), result.getName());
	}

	@Test
	public void givenApiInputWhenCreateDomainIsInvokedThenExceptionIsThrown() {
		MockApiInput mockApiInput = createApiInput();
		BaseCrudService<DomainWithIssue, MockApiInput, MockApiOutput, String> baseCrudService = new BaseCrudService<>(
				mongoRepositoryWithIssue, DomainWithIssue.class) {
		};

		Exception exception = assertThrows(RuntimeException.class, () -> {
			baseCrudService.createDomain(mockApiInput);
		});

		String actualMessage = exception.getMessage();

		assertSame(ERROR_CREATING_DOMAIN, actualMessage);
	}

	private class MockBaseCrudService extends BaseCrudService<MockDomain, MockApiInput, MockApiOutput, String> {

		protected MockBaseCrudService(MongoRepository<MockDomain, String> mongoRepository) {
			super(mongoRepository, MockDomain.class);
		}

		MockDomain createDomain(MockApiInput mockApiInput) {
			return mockDomain;
		}
	}

	private class DomainWithIssue extends MockDomain {
	}
}
