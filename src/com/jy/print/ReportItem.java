package com.jy.print;

public class ReportItem {
	private String sgn_id;
	private String std_name;
	private String std_id;
	private String std_tel;
	private String std_email;
	private String date;
	private String crs_name;
	private float pay_money;
	
	public String toString(){
		return sgn_id+","+std_name+","+std_id+","+std_tel+","+std_email+","+date+","+crs_name+","+pay_money;
	}

	public String getSgn_id() {
		return sgn_id;
	}

	public void setSgn_id(String sgn_id) {
		this.sgn_id = sgn_id;
	}

	public String getStd_name() {
		return std_name;
	}

	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getStd_tel() {
		return std_tel;
	}

	public void setStd_tel(String std_tel) {
		this.std_tel = std_tel;
	}

	public String getStd_email() {
		return std_email;
	}

	public void setStd_email(String std_email) {
		this.std_email = std_email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCrs_name() {
		return crs_name;
	}

	public void setCrs_name(String crs_name) {
		this.crs_name = crs_name;
	}

	public float getPay_money() {
		return pay_money;
	}

	public void setPay_money(float pay_money) {
		this.pay_money = pay_money;
	}
	
}
