package com.jida.product.data;

import com.jida.product.data.*;
 

public class Product implements java.io.Serializable{
	private String pdtNo;// varchar(12),
	private String pdtName;// varchar(30) ,	
	private String pdtType;
	private String pdtFactory;// varchar(50),						
	private float pdtPrice;// float,						
	private String pdtTel;// varchar(15),					
	private String pdtAddr;// varchar(50),				
	private String pdtLinkMan;// varchar(12),				
	private String pdtComment;// varchar(100),
	private byte colorOption;

	public static String titles[]={"No","Product Name","Category","Price","Producer","Tel","Address","Comment"};
	public static String fields[]={"pdtNo","pdtName","pdtType","pdtPrice","pdtFactory","pdtTel","pdtAddr","pdtLinkMan","pdtComment"};
	public static final String [] Types={"No","Name","Type","Price","Factory","Tel","Address","Link Man","Comment"};
	
	public static String titlesSelection[]={"No","Product Name","Category"};
	public static String fieldsSelection[]={"pdtNo","pdtName","pdtType"};
	public String toString(){
		StringBuffer bf=new StringBuffer();
		bf.append(this.pdtName);
		bf.append('(');
		bf.append(this.pdtNo);
		bf.append(')');
		
//		bf.append(",");
//		bf.append(this.Type);
//		bf.append(",");
//		bf.append(this.Chang);

		return bf.toString();
	}

	public int hashCode(){
		return pdtNo.hashCode();
	}
	public boolean equals(Object obj){
		if(obj instanceof Product){
			return pdtNo.equals(((Product)obj).pdtNo);
		}
		else if(obj instanceof String){
			return pdtNo.equals(obj);
		}
		return false;
	}
	public void copy(Product pro){
		this.pdtAddr=pro.pdtAddr;
		this.pdtComment=pro.pdtComment;
		this.pdtFactory=pro.pdtFactory;
		this.pdtLinkMan=pro.pdtLinkMan;
		this.pdtName=pro.pdtName;
		this.pdtNo=pro.pdtNo;
		this.pdtPrice=pro.pdtPrice;
		this.pdtTel=pro.pdtTel;
		this.pdtType=pro.pdtType;
	}

		
	

	public String getPdtNo() {
		return pdtNo;
	}

	public void setPdtNo(String pdtNo) {
		this.pdtNo = pdtNo;
	}

	public String getPdtName() {
		return pdtName;
	}

	public void setPdtName(String pdtName) {
		this.pdtName = pdtName;
	}

	public String getPdtType() {
		return pdtType;
	}

	public void setPdtType(String pdtType) {
		this.pdtType = pdtType;
	}

	public String getPdtFactory() {
		return pdtFactory;
	}

	public void setPdtFactory(String pdtFactory) {
		this.pdtFactory = pdtFactory;
	}

	public float getPdtPrice() {
		return pdtPrice;
	}

	public void setPdtPrice(float pdtPrice) {
		this.pdtPrice = pdtPrice;
	}

	public String getPdtTel() {
		return pdtTel;
	}

	public void setPdtTel(String pdtTel) {
		this.pdtTel = pdtTel;
	}

	public String getPdtAddr() {
		return pdtAddr;
	}

	public void setPdtAddr(String pdtAddr) {
		this.pdtAddr = pdtAddr;
	}

	public String getPdtLinkMan() {
		return pdtLinkMan;
	}

	public void setPdtLinkMan(String pdtLinkMan) {
		this.pdtLinkMan = pdtLinkMan;
	}

	public String getPdtComment() {
		return pdtComment;
	}

	public void setPdtComment(String pdtComment) {
		this.pdtComment = pdtComment;
	}

	public byte getColorOption() {
		return colorOption;
	}
	public void setColorOption(byte colorOption) {
		this.colorOption = colorOption;
	}


}
