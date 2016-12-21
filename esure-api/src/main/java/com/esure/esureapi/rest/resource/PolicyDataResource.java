package com.esure.esureapi.rest.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esure.esureapi.core.model.PolicyData;
import com.esure.esureapi.core.service.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyDataResource {

	Logger logger = LoggerFactory.getLogger(PolicyDataResource.class);

	@Autowired
	private PolicyService policyService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void addPolicyData(@RequestBody PolicyData policyData) {
		policyService.createPolicyData(policyData);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody PolicyData findPolicyDataByPolicyNumber(
			@RequestParam(value = "policyNumber", required = true) String policyNumber) {
		PolicyData policy = policyService.getPolicyDataByPolicyNumber(policyNumber);
		return policy;
	}

}
