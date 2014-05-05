package com.jy.data;


public class Transport {

	private String id;
	private String customerId;
	private String customerName;
	private String customerTrainStop;
	private String customerRoadStop;
	private String linkmanName;
	private String transportDate;
	private String addr;
	private String postcode;
	private String tel;
	private String fax;
	private String mobilePhone;
	private String mode;
	private String state;
	private String receiptNo;
	private String remark;
	private String employeeName;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Transport() {
	}

	public String toString (){
		return "transport"+this.id+","+this.customerId+","+this.customerName+","+this.customerRoadStop;
	}
	public boolean equals(Object obj){
		if(obj instanceof Transport){
			return this.id.equals(((Transport)obj).id);
		}
		return false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getTransportDate() {
		return transportDate;
	}

	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerTrainStop() {
		return customerTrainStop;
	}

	public void setCustomerTrainStop(String customerTrainStop) {
		this.customerTrainStop = customerTrainStop;
	}

	public String getCustomerRoadStop() {
		return customerRoadStop;
	}

	public void setCustomerRoadStop(String customerRoadStop) {
		this.customerRoadStop = customerRoadStop;
	}

}
