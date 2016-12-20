package com.esure.esureapi.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esure.esureapi.core.model.PolicyData;
import com.esure.esureapi.core.repository.PolicyRepositoryImpl;
import com.esure.esureapi.core.service.exception.UnexpectedNumberOfResultsException;

@Service
public class PolicyServiceImpl implements PolicyService {

	// @Autowired
	// private PolicyRepository policyRepository;

	@Autowired
	private PolicyRepositoryImpl policyRepositoryImpl;

	@Override
	public void savePolicy(PolicyData policy) {
		policyRepositoryImpl.save(policy);
	}

	@Override
	public PolicyData findPolicy(String policyNumber) {
		// PolicyData policy = policyRepository.findById(policyNumber);
		return null;
	}

	@Override
	public PolicyData getPolicyByPolicyType(String policyType) {
		List<PolicyData> policyDataList = policyRepositoryImpl.findByPolicyType(policyType);
		if (policyDataList.isEmpty()) {
			throw new UnexpectedNumberOfResultsException("There is no policy with policy type: " + policyType);
		}

		return policyDataList.get(0);
	}

	@Override
	public void saveAll(int number) {
		List<PolicyData> policyDataList = new ArrayList<PolicyData>();

		for (int i = 0; i < number; i++) {
			Random random = new Random();
			PolicyData policyData = new PolicyData(random.toString(), "type" + random, new Date());
			policyDataList.add(policyData);
		}

		policyRepositoryImpl.save(policyDataList);
	}

}
