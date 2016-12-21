package com.esure.esureapi.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.esure.esureapi.core.model.PolicyData;

public interface PolicyDataRepository extends CrudRepository<PolicyData, Long> {

	PolicyData findByPolicyNumber(String policyNumber);

	List<PolicyData> findByVehicleId_Registration(String registration);

}
