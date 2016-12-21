package com.esure.esureapi.core.service;

import java.util.Objects;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esure.esureapi.core.model.Vehicle;
import com.esure.esureapi.core.repository.VehicleRepository;
import com.esure.esureapi.core.util.ParameterCheck;

@Service
public class VehicleServiceImpl implements VehicleService {

	Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	@Transactional
	public Vehicle createVehicle(Vehicle vehicle) {
		ParameterCheck.mandatory("vehicle", vehicle);
		ParameterCheck.mandatory("registration", vehicle.getRegistration());
		ParameterCheck.mandatory("make", vehicle.getMake());
		ParameterCheck.mandatory("model", vehicle.getModel());

		Long vehicleId = vehicle.getId();
		if (!Objects.isNull(vehicleId)) {
			throw new IllegalStateException("New vehicle object must not have id set, but current is: " + vehicleId);
		}

		Vehicle existingVehicle = vehicleRepository.findByRegistration(vehicle.getRegistration());
		if (Objects.isNull(existingVehicle)) {
			return vehicleRepository.save(vehicle);
		}
		else {
			logger.info("Vehicle with registration " + vehicle.getRegistration() + " already exists");
			return existingVehicle;
		}
	}

}
