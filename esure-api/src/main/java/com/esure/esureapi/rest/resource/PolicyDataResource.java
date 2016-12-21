package com.esure.esureapi.rest.resource;

import java.util.List;

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
import com.esure.esureapi.core.service.PolicyDataService;

@RestController
@RequestMapping("/policy")
public class PolicyDataResource {

	Logger logger = LoggerFactory.getLogger(PolicyDataResource.class);

	@Autowired
	private PolicyDataService policyDataService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void addPolicyData(@RequestBody PolicyData policyData) {
		policyDataService.createPolicyData(policyData);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody PolicyData findPolicyDataByPolicyNumber(
			@RequestParam(value = "policyNumber", required = true) String policyNumber) {
		PolicyData policy = policyDataService.getPolicyDataByPolicyNumber(policyNumber);
		return policy;
	}

	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
	public @ResponseBody List<PolicyData> findPolicyDataByRegistration(
			@RequestParam(value = "registration", required = true) String registration) {
		return policyDataService.getPolicyDataByVehicleRegistration(registration);
	}

}
