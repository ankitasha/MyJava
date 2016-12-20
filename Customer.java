package Dto;

public class Customer
{

	int customerId;
	String customerName;
	String customerDob;
	String address;
	String phone;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDob(String customerDob) {
		this.customerDob = customerDob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Customer(String customerName, String customerDob, String address,
			String phone) {
		super();
		this.customerName = customerName;
		this.customerDob = customerDob;
		this.address = address;
		this.phone = phone;
	}
	
	
	
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName="
				+ customerName + ", customerDob=" + customerDob + ", address="
				+ address + ", phone=" + phone + "]";
	}
	
	
	
	
	
	
	
}
