package com.jy.data;

public class SumUpItem {
	private String name;
	private float num;
	private float weight;
	private float unitPrice;
	private float totalPrice;
//	private int productClass;
	
	public boolean equals(Object obj){
		if(obj instanceof SumUpItem){
			SumUpItem it=(SumUpItem)obj;
			return name.equals(it.name);
		}
		return false;
	}
//	public boolean equals(String name,float unitPrice){
//		return this.name.equals(name) && this.unitPrice==unitPrice;
//		
//	}
	public boolean equals(String name,byte productClass,float unitPrice){
		return this.name.equals(name) &&
			Math.abs(this.unitPrice-unitPrice)<0.01;
		
	}
	public String toString(){
		return name+","+num+","+","+weight+","+unitPrice+","+totalPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getNum() {
		return num;
	}
	public void setNum(float num) {
		this.num = num;
	}
	public void addNum(float num) {
		this.num += num;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void addWeight(float weight) {
		this.weight += weight;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
//	public int getProductClass() {
//		return productClass;
//	}
//	public void setProductClass(int productClass) {
//		this.productClass = productClass;
//	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void addTotalPrice(float totalPrice) {
		this.totalPrice += totalPrice;
	}
	public SumUpItem copy(){
		SumUpItem item=new SumUpItem();
		item.name=name;
		item.unitPrice=this.unitPrice;
		item.totalPrice=this.totalPrice;
		item.num=this.num;
		item.weight=this.weight;
//		item.productClass=this.productClass;
		return item;
	}
}
