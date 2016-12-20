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
public class PolicyResource {

	Logger logger = LoggerFactory.getLogger(PolicyResource.class);

	@Autowired
	private PolicyService policyService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void savePolicy(@RequestBody PolicyData policy) {
		logger.info("Plicy received. Date: " + policy.getDate());
		policyService.savePolicy(policy);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/number")
	public @ResponseBody PolicyData findPolicy(
			@RequestParam(value = "policyNumber", required = true) String policyNumber) {
		PolicyData policy = policyService.findPolicy(policyNumber);
		return policy;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody PolicyData findPolicyByPolicyType(
			@RequestParam(value = "policyType", required = true) String policyType) {
		PolicyData policy = policyService.getPolicyByPolicyType(policyType);
		return policy;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/insert")
	public @ResponseBody void saveMultiplePolicies(@RequestParam(value = "number", required = true) int number) {
		policyService.saveAll(number);
	}

}
