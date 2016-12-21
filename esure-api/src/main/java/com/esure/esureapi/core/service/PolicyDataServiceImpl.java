package com.esure.esureapi.core.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esure.esureapi.core.model.PolicyData;
import com.esure.esureapi.core.model.RiskAddress;
import com.esure.esureapi.core.model.Vehicle;
import com.esure.esureapi.core.repository.PolicyDataRepository;
import com.esure.esureapi.core.service.exception.UnexpectedNumberOfResultsException;
import com.esure.esureapi.core.util.ParameterCheck;

@Service
public class PolicyDataServiceImpl implements PolicyDataService {

	Logger logger = LoggerFactory.getLogger(PolicyDataServiceImpl.class);

	@Autowired
	private PolicyDataRepository policyDataRepository;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private RiskAddressService riskAddressService;

	@Override
	@Transactional
	public PolicyData createPolicyData(PolicyData policyData) {
		ParameterCheck.mandatory("policyDta", policyData);
		ParameterCheck.mandatory("policyNumber", policyData.getPolicyNumber());

		Long policyDataId = policyData.getId();
		if (!Objects.isNull(policyDataId)) {
			throw new IllegalStateException(
					"New policyData object must not have id set, but current is: " + policyDataId);
		}

		Vehicle vehicle = policyData.getVehicle();
		if (!Objects.isNull(vehicle)) {
			try {
				policyData.setVehicle(vehicleService.createVehicle(vehicle));
			}
			catch (Exception e) {
				logger.error("Could not create vehicle field for PolicyData with id: " + policyData.getId()
						+ ". Policy number: " + policyData.getPolicyNumber());
			}
		}

		RiskAddress riskAddress = policyData.getRiskAddress();
		if (!Objects.isNull(riskAddress)) {
			try {
				policyData.setRiskAddress(riskAddressService.createRiskAddress(riskAddress));
			}
			catch (Exception e) {
				logger.error("Could not create riskAddress field for PolicyData with id: " + policyData.getId()
						+ ". Policy number: " + policyData.getPolicyNumber());
			}
		}

		PolicyData existingPolicyData = policyDataRepository.findByPolicyNumber(policyData.getPolicyNumber());
		if (!Objects.isNull(existingPolicyData)) {
			logger.info(
					"PolicyData with policy number " + policyData.getPolicyNumber() + " already exists. Updating...");
			existingPolicyData.setPolicyType(policyData.getPolicyType());
			existingPolicyData.setProduct(policyData.getProduct());
			existingPolicyData.setBrandCode(policyData.getBrandCode());
			existingPolicyData.setBrandName(policyData.getBrandName());
			existingPolicyData.setCancellationCode(policyData.getCancellationCode());
			existingPolicyData.setRenewal(policyData.getRenewal());
			existingPolicyData.setStartDate(policyData.getStartDate());
			existingPolicyData.setRenewalDate(policyData.getRenewalDate());
			existingPolicyData.setVehicle(policyData.getVehicle());
			existingPolicyData.setRiskAddress(policyData.getRiskAddress());
			return policyDataRepository.save(existingPolicyData);
		}

		return policyDataRepository.save(policyData);

	}

	@Override
	@Transactional
	public PolicyData getPolicyData(Long policyDataId) throws UnexpectedNumberOfResultsException {
		ParameterCheck.mandatory("policyDataId", policyDataId);
		PolicyData policyData = policyDataRepository.findOne(policyDataId);

		if (Objects.isNull(policyData)) {
			throw new UnexpectedNumberOfResultsException("There is no policy with policyId: " + policyDataId);
		}

		return policyData;
	}

	@Override
	@Transactional
	public PolicyData getPolicyDataByPolicyNumber(String policyNumber) {
		ParameterCheck.mandatory("policyNumber", policyNumber);
		PolicyData policyData = policyDataRepository.findByPolicyNumber(policyNumber);

		if (Objects.isNull(policyData)) {
			throw new UnexpectedNumberOfResultsException("There is no policy with policy number: " + policyNumber);
		}

		return policyData;
	}

	@Override
	@Transactional
	public List<PolicyData> getPolicyDataByVehicleRegistration(String registration) {
		ParameterCheck.mandatory("registration", registration);
		return policyDataRepository.findByVehicleId_Registration(registration);
	}

	@Override
	public void deletePolicyData(Long policyId) throws UnexpectedNumberOfResultsException {
		ParameterCheck.mandatory("policyId", policyId);
		policyDataRepository.delete(policyId);
	}

}
