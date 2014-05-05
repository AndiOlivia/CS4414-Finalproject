package com.jida.product.data;

public class ProductType {
	private String ptName;
	private String ptBrief;
	
	public static String titles[]={
		"Type Name","Brief"
	};
	
	public static String fields[]={
		"ptName","ptBrief"
	};
	
	public String toString(){
		return this.ptName;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Product){
			return ptName.equals(((ProductType)obj).ptName);
		}
		else if(obj instanceof String){
			return ptName.equals(obj);
		}
		return false;
	}
	
	public int hashcode(){
		return ptName.hashCode();
	}

	public String getPtName() {
		return ptName;
	}

	public void setPtName(String ptName) {
		this.ptName = ptName;
	}

	public String getPtBrief() {
		return ptBrief;
	}

	public void setPtBrief(String ptBrief) {
		this.ptBrief = ptBrief;
	}
}
