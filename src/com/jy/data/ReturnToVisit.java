package com.jy.data;


public class ReturnToVisit {
	private String id;
	private String name;
	private String returnPerson;
	private String returnDate;
	private String returnContents;
	private String returnResult;
	private int days;
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	/**
	 * @param args
	 */
	public String toString(){
		return "("+id+","+name+","+returnPerson+","+returnDate+","+returnContents+","+returnResult+")";
	}
	public boolean equals(Object obj){
		if(obj instanceof ReturnToVisit){
			return id.equals(((ReturnToVisit)obj).getId());
		}
		return false;
	}

	public String getReturnPerson() {
		return returnPerson;
	}
	public void setReturnPerson(String returnPerson) {
		this.returnPerson = returnPerson;
	}
	public String getReturnContents() {
		return returnContents;
	}
	public void setReturnContents(String returnContents) {
		this.returnContents = returnContents;
	}
	public String getReturnResult() {
		return returnResult;
	}
	public void setReturnResult(String returnResult) {
		this.returnResult = returnResult;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}
