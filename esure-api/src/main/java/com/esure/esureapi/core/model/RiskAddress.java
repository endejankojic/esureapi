package com.esure.esureapi.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "risk_address")
public class RiskAddress {

	@Id
	@Column(name = "risk_address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "house_name")
	private String houseName;

	@Column(name = "house_number")
	private String houseNumber;

	@Column(name = "street")
	private String street;

	@Column(name = "country")
	private String country;

	@Column(name = "postal_town")
	private String postalTown;

	@Column(name = "post_code")
	private String postCode;

	public RiskAddress() {

	}

	public RiskAddress(String houseName, String houseNumber, String street, String country, String postalTown,
			String postCode) {
		this.houseName = houseName;
		this.houseNumber = houseNumber;
		this.street = street;
		this.country = country;
		this.postalTown = postalTown;
		this.postCode = postCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalTown() {
		return postalTown;
	}

	public void setPostalTown(String postalTown) {
		this.postalTown = postalTown;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return "RiskAddress [houseName=" + houseName + ", houseNumber=" + houseNumber + ", street=" + street
				+ ", country=" + country + ", postalTown=" + postalTown + ", postCode=" + postCode + "]";
	}

}
