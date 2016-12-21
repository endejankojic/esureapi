package com.esure.esureapi.core.service;

import com.esure.esureapi.core.model.PolicyData;
import com.esure.esureapi.core.service.exception.UnexpectedNumberOfResultsException;

public interface PolicyService {

	PolicyData createPolicyData(PolicyData policyData);

	PolicyData getPolicyData(Long policyDataId) throws UnexpectedNumberOfResultsException;

	PolicyData getPolicyDataByPolicyNumber(String policyNumber);

	void deletePolicyData(Long policyId) throws UnexpectedNumberOfResultsException;

}
