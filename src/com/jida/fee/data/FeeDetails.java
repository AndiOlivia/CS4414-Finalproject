package com.jida.fee.data;

import java.util.Date;


import java.util.List;

import com.jida.MvcProperties;

public class FeeDetails implements java.io.Serializable{
	private int fdNo;
	private String fdPdtNo;
	private String fdPdtName;
	private float fdAmount;
	private float fdPrice;
	private float fdTotalPrice;
	private String fdComment;
	private  int colorOption=0;
//	private Date date;
	public static String titles[]={
		"No","Product No",
		"Product Name",
		"Amount","Price",
		"Total Price",
		"Comment"
		
	};
//	
	public String toString(){
		return String.format("%d:%f*%f=%f(%s)", fdNo,fdPdtNo,fdPdtName,fdAmount,fdPrice,fdTotalPrice,fdComment);
	}
		public int getFdNo() {
		return fdNo;
	}
	public void setFdNo(int fdNo) {
		this.fdNo = fdNo;
	}
	public String getFdPdtNo() {
		return fdPdtNo;
	}
	public void setFdPdtNo(String fdPdtNo) {
		this.fdPdtNo = fdPdtNo;
	}
	public String getFdPdtName() {
		return fdPdtName;
	}
	public void setFdPdtName(String fdPdtName) {
		this.fdPdtName = fdPdtName;
	}
	public float getFdAmount() {
		return fdAmount;
	}
	public void setFdAmount(float fdAmount) {
		this.fdAmount = fdAmount;
	}
	public float getFdPrice() {
		return fdPrice;
	}
	public void setFdPrice(float fdPrice) {
		this.fdPrice = fdPrice;
	}
	public float getFdTotalPrice() {
		return fdTotalPrice;
	}
	public void setFdTotalPrice(float fdTotalPrice) {
		this.fdTotalPrice = fdTotalPrice;
	}
	public String getFdComment() {
		return fdComment;
	}
	public void setFdComment(String fdComment) {
		this.fdComment = fdComment;
	}
	public FeeDetails copy(){
		FeeDetails fd=new FeeDetails();

		fd.fdAmount=this.fdAmount;
		fd.fdComment=this.fdComment;
		fd.fdNo=this.fdNo;
		fd.fdPdtName=this.fdPdtName;
		fd.fdPdtNo=this.fdPdtNo;
		fd.fdPrice=this.fdPrice;
		fd.fdTotalPrice=this.fdTotalPrice;
		return fd;
	}
	public int getColorOption() {
		return colorOption;
	}
	public void setColorOption(int colorOption) {
		this.colorOption = colorOption;
	}
	
	
}
