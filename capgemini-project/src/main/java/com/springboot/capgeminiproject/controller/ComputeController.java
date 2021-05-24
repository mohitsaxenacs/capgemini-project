package com.springboot.capgeminiproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.capgeminiproject.model.RequestData;
import com.springboot.capgeminiproject.model.ResponseData;
import com.springboot.capgeminiproject.service.ComputeService;

@RestController
public class ComputeController {

	private ComputeService computeService;

	@Autowired
	public ComputeController(ComputeService computeService) {
		this.computeService = computeService;
	}

	@PostMapping("/compute")
	public ResponseData compute(@RequestBody RequestData reqData) {

		return computeService.performComputation(reqData);
	}

}
