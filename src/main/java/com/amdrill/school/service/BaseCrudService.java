package com.amdrill.school.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdrill.school.domain.ApiInput;
import com.amdrill.school.domain.ApiOutput;
import com.amdrill.school.domain.Domain;
import com.amdrill.school.exception.CrudServiceException;

public abstract class BaseCrudService<D extends Domain<K>, I extends ApiInput, O extends ApiOutput, K>
		implements CrudService<I, O, K> {

	private final MongoRepository<D, K> mongoRepository;
	private final Class<D> domainClass;

	protected BaseCrudService(MongoRepository<D, K> mongoRepository, Class<D> domainClass) {
		super();
		this.mongoRepository = mongoRepository;
		this.domainClass = domainClass;
	}

	@Override
	public K create(I input) {
		D domain = createDomain(input);
		D result = mongoRepository.insert(domain);
		return result.getId();
	}

	@Override
	public O read(K id) {
		Optional<D> optional = mongoRepository.findById(id);
		if (optional.isPresent()) {
			D result = optional.get();
			return (O) result.generateOutput();
		}
		return null;
	}

	@Override
	public List<O> read() {
		List<D> results = mongoRepository.findAll();
		List<O> outputs = new ArrayList<>();
		results.forEach(result -> {
			O output = (O) result.generateOutput();
			outputs.add(output);
		});
		return outputs;
	}

	@Override
	public void update(I input, K id) {
		boolean exists = mongoRepository.existsById(id);
		if (exists) {
			D domain = createDomain(input);
			domain.setId(id);
			mongoRepository.save(domain);
		}
	}

	@Override
	public void delete(K id) {
		mongoRepository.deleteById(id);
	}

	private D createDomain(I input) {
		try {
			Constructor<D> constructor = domainClass.getConstructor(input.getClass());
			return constructor.newInstance(input);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			throw new CrudServiceException("Error encountered while creating domain instance", e);
		}
	}
}
