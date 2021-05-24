package com.springboot.capgeminiproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.springboot.capgeminiproject.model.RequestData;
import com.springboot.capgeminiproject.model.ResponseData;
import com.springboot.capgeminiproject.service.ComputeService;

class ComputeControllerTest {

	@Test
	void testCompute() {
		ComputeService computeServiceMock = Mockito.mock(ComputeService.class);
		ResponseData responseDataMock = Mockito.mock(ResponseData.class);

		// Setup
		RequestData data = new RequestData();
		int array[] = { 5, 4, 6, 1 };
		data.setData(array);

		when(computeServiceMock.performComputation(data)).thenReturn(responseDataMock);

		ComputeController computeController = new ComputeController(computeServiceMock);

		assertEquals(responseDataMock, computeController.compute(data)); // Act & Assert
	}

}
