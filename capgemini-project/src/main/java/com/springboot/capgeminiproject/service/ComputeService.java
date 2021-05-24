package com.springboot.capgeminiproject.service;

import com.springboot.capgeminiproject.model.RequestData;
import com.springboot.capgeminiproject.model.ResponseData;

public interface ComputeService {

	ResponseData performComputation(RequestData reqData);

}