package Dto;

import java.util.Date;

public class InsuranceDetails 
{
int insuranceId;
int policyholderId;
String policyholderName;
String vehicleNumber;
Date dateOfIssuance;
Date dateofRenewal;
Date dateofExpiry;
public int getPolicyholderId() {
	return policyholderId;
}
public void setPolicyholderId(int policyholderId) {
	this.policyholderId = policyholderId;
}
public String getPolicyholderName() {
	return policyholderName;
}
public void setPolicyholderName(String policyholderName) {
	this.policyholderName = policyholderName;
}
public String getVehicleNumber() {
	return vehicleNumber;
}
public void setVehicleNumber(String vehicleNumber) {
	this.vehicleNumber = vehicleNumber;
}
public Date getDateOfIssuance() {
	return dateOfIssuance;
}
public void setDateOfIssuance(Date dateOfIssuance) {
	this.dateOfIssuance = dateOfIssuance;
}
public Date getDateofRenewal() {
	return dateofRenewal;
}
public void setDateofRenewal(Date dateofRenewal) {
	this.dateofRenewal = dateofRenewal;
}
public Date getDateofExpiry() {
	return dateofExpiry;
}
public void setDateofExpiry(Date dateofExpiry) {
	this.dateofExpiry = dateofExpiry;
}

public InsuranceDetails(int policyholderId, String policyholderName,
		String vehicleNumber, Date dateOfIssuance, Date dateofRenewal,
		Date dateofExpiry) {
	super();
	this.policyholderId = policyholderId;
	this.policyholderName = policyholderName;
	this.vehicleNumber = vehicleNumber;
	this.dateOfIssuance = dateOfIssuance;
	this.dateofRenewal = dateofRenewal;
	this.dateofExpiry = dateofExpiry;
}
@Override
public String toString() {
	return "InsuranceDetails [insuranceId=" + insuranceId + ", policyholderId="
			+ policyholderId + ", policyholderName=" + policyholderName
			+ ", vehicleNumber=" + vehicleNumber + ", dateOfIssuance="
			+ dateOfIssuance + ", dateofRenewal=" + dateofRenewal
			+ ", dateofExpiry=" + dateofExpiry + "]";
}





}
