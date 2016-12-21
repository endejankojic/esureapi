package com.esure.esureapi.core.service;

import java.util.List;

import com.esure.esureapi.core.model.PolicyData;
import com.esure.esureapi.core.service.exception.UnexpectedNumberOfResultsException;

public interface PolicyDataService {

	PolicyData createPolicyData(PolicyData policyData);

	PolicyData getPolicyData(Long policyDataId) throws UnexpectedNumberOfResultsException;

	PolicyData getPolicyDataByPolicyNumber(String policyNumber);

	List<PolicyData> getPolicyDataByVehicleRegistration(String registration);

	void deletePolicyData(Long policyId) throws UnexpectedNumberOfResultsException;

}
