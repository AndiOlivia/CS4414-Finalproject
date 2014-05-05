package com.jida.fee.data;

import java.text.DateFormat;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jida.MvcProperties;


public class Fee implements java.io.Serializable,Comparable<Fee>{
	//New 20120216
	public static String name="Fee Manager"; 
	private int feeNo; //单元控制箱
	private String feePdtNo;		//温控器 New 20111107
	private String feePdtName;
	private float feeAmount;
	private float feePrice;
	private float feeTotalPrice;
	private Date feeDate;
	private String feeComment;
	
	
	public short colorOption;
	
//	private List<FeeDetails> details;

	public static String titles[]={
		
		"No","Product No","Product Name",
		"Amount","Unit Price","Total Price","Date",
		"Comment"
	};
	
	public short getColorOption() {
		return colorOption;
	}
	public void setColorOption(short colorOption) {
		this.colorOption = colorOption;
	}
	public static String fields[]={
	
		"feeNo",	"feePdtId",//
		 "feePdtName",// float,                     -- 费用金额
		"feeAmount",// int,
		"feePrice",// float,                     -- 费用金额
		"feeTotal",// int,
		"Money2",// float,                     -- 费用金额
		"TimeLong2",// int,
//		"total",// float
	};
	public float getFeeTotalPrice() {
		return feeTotalPrice;
	}
	public void setFeeTotalPrice(float feeTotalPrice) {
		this.feeTotalPrice = feeTotalPrice;
	}
	public int getFeeNo() {
		return feeNo;
	}
	public void setFeeNo(int feeNo) {
		this.feeNo = feeNo;
	}
	public String getFeePdtNo() {
		return feePdtNo;
	}
	public void setFeePdtNo(String feePdtNo) {
		this.feePdtNo = feePdtNo;
	}
	public String getFeePdtName() {
		return feePdtName;
	}
	public void setFeePdtName(String feePdtName) {
		this.feePdtName = feePdtName;
	}
	public float getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(float feeAmount) {
		this.feeAmount = feeAmount;
	}
	public float getFeePrice() {
		return feePrice;
	}
	public void setFeePrice(float feePrice) {
		this.feePrice = feePrice;
	}
	public Date getFeeDate() {
		return feeDate;
	}
	public void setFeeDate(Date feeDate) {
		this.feeDate = feeDate;
	}
	public String getFeeComment() {
		return feeComment;
	}
	public void setFeeComment(String feeComment) {
		this.feeComment = feeComment;
	}
	public String toString(){
		return String.format("%d:%s-%s,%f*%f=%f(%s,%s)", feeNo,feePdtNo,feePdtName,feePrice,feeAmount,feeTotalPrice,MvcProperties.sdf.format(feeDate),feeComment);
	}
	public int hashCode(){
//		int re=((this.temConAddrCode<<8)|(this.temConName & 0xff));
//		System.out.println("TemConLog:hashCode:"+Integer.toHexString(re));
		return this.feeNo;
	}
	public boolean equals(Object obj){
//		System.out.println("TemConLog:equals:"+this+"=="+obj);
		if(obj instanceof Fee){
			return this.feeDate.equals(((Fee)obj).feeDate) && this.feePdtNo.equals(((Fee)obj).feePdtNo);
		}
		return false;
	}
	
	public Fee(){
//		this.minutes=new int[3];
//		this.fees=new float[3];
//		
//		this.details=new ArrayList<FeeDetails>();
	}
	/**
	 * 
	 */
	public int compareTo(Fee fee){
//		switch(sortMode){
//		case Fee.SORTBYNO:
//			return this.temConAddrCode==fee.temConAddrCode?this.temConName-fee.temConName:this.temConAddrCode-fee.temConAddrCode;
//		case Fee.SORTBYUNITENERGY:
//			//Update 20130408
//			if(this.tc.getSize()==0 || fee.tc.getSize()==0)
//				return 0;
//			
//			float thisEnergy=this.getEnergy()/tc.getSize();
//			float feeEnergy=fee.getEnergy()/fee.tc.getSize();
//			if(thisEnergy==feeEnergy)
//				return 0;
//			else if(thisEnergy>feeEnergy){ 
//				return -1;
//			}
//			else return 1;
//			
//		case Fee.SORTBYUNITPRICE:
//			//Update 20130408
////			if(this.tc.getSize()==0 || fee.tc.getSize()==0)
////				return 0;
//			
////			float thisTotal=this.getTotal()/tc.getSize();
////			float feeTotal=fee.getTotal()/fee.tc.getSize();
////			if(thisTotal==feeTotal)
////				return 0;
////			else if(thisTotal>feeTotal){
////				return -1;
////			}
////			else return 1;
//		}
		return 0;
	}
	
	public Fee copy(Fee fee){
		this.feeAmount=fee.feeAmount;
		this.feeComment=fee.feeComment;
		this.feeDate=fee.feeDate;
		this.feeNo=fee.feeNo;
		this.feePdtName=fee.feePdtName;
		this.feePdtNo=fee.feePdtNo;
		this.feePrice=fee.feePrice;
		this.feeTotalPrice=fee.feeTotalPrice;
		return this;
	}
	

}
