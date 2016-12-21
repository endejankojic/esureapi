package com.esure.esureapi.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.esure.esureapi.core.model.PolicyData;

public interface PolicyDataRepository extends CrudRepository<PolicyData, Long> {

	public PolicyData findByPolicyNumber(String policyNumber);

}
