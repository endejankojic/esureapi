package com.esure.esureapi.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.esure.esureapi.core.model.PolicyData;

public interface PolicyRepositoryImpl extends CrudRepository<PolicyData, Serializable> {

	static final String KEY_PREFIX = "number:";

	// @Autowired
	// private RedisTemplate<String, PolicyData> policyRedisTemplate;
	//
	// @Override
	// public void save(PolicyData policy) {
	// policyRedisTemplate.opsForValue().set(KEY_PREFIX + policy.getPolicyNumber(), policy);
	// }
	//
	// @Override
	// public PolicyData findById(String policyNumber) {
	// return policyRedisTemplate.opsForValue().get(KEY_PREFIX + policyNumber);
	// }

	public List<PolicyData> findByPolicyType(String policyType);
}
