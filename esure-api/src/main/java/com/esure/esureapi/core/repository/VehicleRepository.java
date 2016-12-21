package com.esure.esureapi.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.esure.esureapi.core.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

	Vehicle findByRegistration(String registration);

}
