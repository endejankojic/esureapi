package com.esure.esureapi.core.repository;

import com.esure.esureapi.core.model.PolicyData;

public interface PolicyRepository {

	void save(PolicyData policy);

	PolicyData findById(String policyNumber);

}
