package com.esure.esureapi.core.service;

import com.esure.esureapi.core.model.PolicyData;

public interface PolicyService {

	void savePolicy(PolicyData policy);

	PolicyData findPolicy(String policyNumber);

	PolicyData getPolicyByPolicyType(String policyType);

	void saveAll(int number);

}
