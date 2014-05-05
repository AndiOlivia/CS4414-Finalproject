package com.jy.print;

import java.util.List;

public class CourseResultReport {
	private List<ReportItem> list;
	private String crs_id;
	private String crs_name;
	private int count;
	private float income;
	public String toString(){
		return crs_id+"-"+crs_name+"-"+count+"-"+income;
	}
	public List<ReportItem> getList() {
		return list;
	}
	public void setList(List<ReportItem> list) {
		this.list = list;
	}
	public String getCrs_id() {
		return crs_id;
	}
	public void setCrs_id(String crs_id) {
		this.crs_id = crs_id;
	}
	public String getCrs_name() {
		return crs_name;
	}
	public void setCrs_name(String crs_name) {
		this.crs_name = crs_name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}	
}
