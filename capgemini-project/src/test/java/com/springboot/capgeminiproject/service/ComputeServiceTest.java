package com.springboot.capgeminiproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.springboot.capgeminiproject.model.RequestData;
import com.springboot.capgeminiproject.model.ResponseData;

class ComputeServiceTest {

	// Positive Test
	@Test
	void testComputePositiveResult() {
		ComputeService computeService = new ComputeServiceImpl(); // Arrange

		// Setup
		RequestData data = new RequestData();
		int array[] = { 5, 4, 6, 1 };
		data.setData(array);

		ResponseData responseData = computeService.performComputation(data); // Act

		assertEquals("8.77", responseData.getOutput()); // Assert
	}

	// Negative Test
	@Test
	void testComputeInputArraySizeBelowThree() {
		ComputeService ComputeService = new ComputeServiceImpl(); // Arrange

		// Setup
		RequestData data = new RequestData();
		int array[] = { 5, 4 };
		data.setData(array);

		ResponseData responseData = ComputeService.performComputation(data); // Act

		assertEquals("Invalid Request: Array of numeric inputs is null or less than 3 integers.",
				responseData.getOutput()); // Assert
	}

	// Negative Test
	@Test
	void testComputeNullInputArray() {
		ComputeService ComputeService = new ComputeServiceImpl(); // Arrange

		// Setup
		RequestData data = new RequestData();

		ResponseData responseData = ComputeService.performComputation(data); // Act

		assertEquals("Invalid Request: Array of numeric inputs is null or less than 3 integers.",
				responseData.getOutput()); // Assert
	}

	// Negative Test
	@Test
	void testComputeNullRequest() {
		ComputeService ComputeService = new ComputeServiceImpl(); // Arrange

		ResponseData responseData = ComputeService.performComputation(null); // Act

		assertEquals("Invalid Request: No request data found.", responseData.getOutput()); // Assert
	}
}
