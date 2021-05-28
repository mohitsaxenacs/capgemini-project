package com.springboot.capgeminiproject.service;

import java.text.DecimalFormat;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.springboot.capgeminiproject.model.RequestData;
import com.springboot.capgeminiproject.model.ResponseData;

/**
 *
 * This is the service class which performs computation on input data.
 *
 */
@Service
public class ComputeServiceImpl implements ComputeService {

	/**
	 *
	 * This method computes the square root of the sum of squares of the 3 highest numeric
	 * inputs.
	 * 
	 * @param RequestData containing array of numeric inputs
	 * @return ResponseData having output as square root of the sum of squares of
	 *         the 3 highest numeric inputs.
	 *
	 */
	@Override
	public ResponseData performComputation(RequestData requestData) {

		if (requestData == null) {
			return new ResponseData("Invalid Request: No request data found.");
		}

		int[] array = requestData.getData();

		if (array == null || array.length < 3) {
			return new ResponseData("Invalid Request: Array of numeric inputs is null or less than 3 integers.");
		}

		// Stream Operation on Input Integer Array
		int sum = Arrays.stream(array).sorted().skip(array.length - 3).map(x -> x * x).sum();

		// Format result to two decimal place
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);

		return new ResponseData(df.format(Math.sqrt(sum)));

	}

}
