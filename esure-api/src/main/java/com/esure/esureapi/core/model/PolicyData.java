package com.esure.esureapi.core.model;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("policydatas")
public class PolicyData {

	@Id
	private String id;

	@Indexed
	private String policyNumber;

	@Indexed
	private String policyType;

	private Date date;

	public PolicyData() {

	}

	public PolicyData(String policyNumber, String policyType, Date date) {
		this.policyNumber = policyNumber;
		this.policyType = policyType;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PolicyData [policyNumber=" + policyNumber + ", policyType=" + policyType + ", date=" + date + "]";
	}

}
