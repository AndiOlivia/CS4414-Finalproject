package com.jida.fee;

import java.util.Date;

import java.util.List;

import com.jida.fee.data.Fee;
import com.jida.fee.data.FeeDetails; 

public interface ModelFee {
	public List<Fee> get() throws Exception;
	public List<Fee> get(boolean fetch) throws Exception;
	public List<Fee> get(String cond) throws Exception;
	public Fee getByIndex(int index);
//	public List<FeeDetails> get(Fee fee) throws Exception;
	public void insert(Fee cust)throws Exception;
	public void delete(Fee cust)throws Exception;
	public void update(Fee cust)throws Exception;
	public int getIndex(Fee cust,String cond);
//	public List<Fee> computeFee(int temConAddrCode,int temConName,Date from)throws Exception;
//	public List<Fee> computeFee(Date from)throws Exception;
//	public List<Fee> computeFee(Date from,Date end,int temConAddrCode,int temConName)throws Exception;
//	public List<FeeDetails> get(int temConAddrCode,int temConName,Date from,Date to)throws Exception;
//	public List<FeeDetails> getFeeDetails(String condFD)throws Exception;
//	public List<String> toTemConString();
	public int getCount();
	public float getTotal();
	public float getSize();
//	public float getEnergy();
	public List<Fee> sort();
//	public int getTotalTime();
//	public void restore();
	public void exportExcel(String excelPath)throws Exception;
//	public void exportExcelTime(String excelPath)throws Exception;
//	public List<Fee> importExcel(String excelPath)throws Exception;
	
	public void addViewListener(ViewFee viewcustandlink);
}
 