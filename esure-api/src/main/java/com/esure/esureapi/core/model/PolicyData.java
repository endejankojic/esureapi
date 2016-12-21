package com.esure.esureapi.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "policy_data")
public class PolicyData {

	@Id
	@Column(name = "policy_data_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "policy_number")
	private String policyNumber;

	@Column(name = "policy_type")
	private String policyType;

	@Column(name = "product")
	private String product;

	@Column(name = "brand_code")
	private String brandCode;

	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "cancellation_code")
	private Integer cancellationCode;

	@Column(name = "renewal")
	private Boolean renewal;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "renewal_date")
	private Date renewalDate;

	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	@ManyToOne
	@JoinColumn(name = "risk_address_id")
	private RiskAddress riskAddress;

	public PolicyData() {

	}

	public PolicyData(String policyNumber, String policyType, String product, String brandCode, String brandName,
			Integer cancellationCode, Boolean renewal, Date startDate, Date renewalDate, Vehicle vehicle,
			RiskAddress riskAddress) {
		super();
		this.policyNumber = policyNumber;
		this.policyType = policyType;
		this.product = product;
		this.brandCode = brandCode;
		this.brandName = brandName;
		this.cancellationCode = cancellationCode;
		this.renewal = renewal;
		this.startDate = startDate;
		this.renewalDate = renewalDate;
		this.vehicle = vehicle;
		this.riskAddress = riskAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getCancellationCode() {
		return cancellationCode;
	}

	public void setCancellationCode(Integer cancellationCode) {
		this.cancellationCode = cancellationCode;
	}

	public Boolean getRenewal() {
		return renewal;
	}

	public void setRenewal(Boolean renewal) {
		this.renewal = renewal;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public RiskAddress getRiskAddress() {
		return riskAddress;
	}

	public void setRiskAddress(RiskAddress riskAddress) {
		this.riskAddress = riskAddress;
	}

	@Override
	public String toString() {
		return "PolicyData [policyNumber=" + policyNumber + ", policyType=" + policyType + ", product=" + product
				+ ", brandCode=" + brandCode + ", brandName=" + brandName + ", cancellationCode=" + cancellationCode
				+ ", renewal=" + renewal + ", startDate=" + startDate + ", renewalDate=" + renewalDate + ", vehicle="
				+ vehicle + ", riskAddress=" + riskAddress + "]";
	}

}
