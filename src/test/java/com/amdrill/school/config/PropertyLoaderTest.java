package com.amdrill.school.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PropertyLoaderTest {

	private static final String TEST_KEY = "MONGO_HOST";
	private static final String TEST_VALUE = "localhost";

	@Test
	public void givenPropertyLoaderWhenGetValueOfIsInvokedThenExpectedResultIsReturned() {
		PropertyLoader propertyLoader = new PropertyLoader();

		String result = propertyLoader.getValueOf(TEST_KEY);

		assertEquals(TEST_VALUE, result);
	}
}
