package com.esure.esureapi.core.service;

import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esure.esureapi.core.model.RiskAddress;
import com.esure.esureapi.core.repository.RiskAddressRepository;
import com.esure.esureapi.core.util.ParameterCheck;

@Service
public class RiskAddressServiceImpl implements RiskAddressService {

	@Autowired
	private RiskAddressRepository riskAddressRepository;

	@Override
	@Transactional
	public RiskAddress createRiskAddress(RiskAddress riskAddress) {
		ParameterCheck.mandatory("riskAddress", riskAddress);

		Long riskAddressId = riskAddress.getId();
		if (!Objects.isNull(riskAddressId)) {
			throw new IllegalStateException(
					"New riskAddress object must not have id set, but current is: " + riskAddressId);
		}

		return riskAddressRepository.save(riskAddress);
	}

}
