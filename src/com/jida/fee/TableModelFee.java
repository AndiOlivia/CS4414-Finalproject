package com.jida.fee;

import java.math.RoundingMode;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.jida.MvcProperties;
import com.jida.fee.data.Fee;
import com.jida.gui.ItemColumnState;
import com.jida.gui.RowColorRenderer;

public class TableModelFee extends AbstractTableModel {
	private static final long serialVersionUID = 0L;
	private ModelFee model;
	List<Fee> list=null;
//	private String userName=null;
	private String cond=null;
	private int columnNum;
	private Object ss[]=new Object[Fee.titles.length];
	private int row=-1;
	private JTable table;
	public  String [] colNames=null; 
	public  ItemColumnState ics[]=null;//new ItemColumnState[colNames.length];
//	public  ItemColumnState ics[]=new ItemColumnState[colNames.length];
		
	public TableModelFee(ModelFee model,JTable table){
		this.model=model;
		this.table=table;
		try{
			this.colNames=Fee.titles;
			ics=new ItemColumnState[colNames.length];
			
			for(int i=0;i<ics.length;i++){
				ics[i]=new ItemColumnState(colNames[i],true,true,i);
			}
			ics[0].setEnabled(false); //ics[0].setVisible(true);
			ics[1].setEnabled(false);//ics[1].setVisible(true);
			ics[2].setEnabled(false);//ics[2].setVisible(true);
			ics[3].setEnabled(false);// ics[3].setVisible(true);
			ics[4].setEnabled(false);//ics[4].setVisible(true);
//			ics[5].setEnabled(false);//ics[5].setVisible(true);
//			ics[6].setEnabled(false);// ics[6].setVisible(true);
//			ics[7].setEnabled(false);//ics[7].setVisible(true);
//			ics[8].setEnabled(false);//ics[8].setVisible(true);
//			ics[9].setEnabled(false);//ics[9].setVisible(true);
		}
		catch(Exception e){
			
		}
		
		//New 20131222
		MvcProperties.loadColumn("fee", ics);
//		this.userName=userName;
//		this.cond=cond;
		this.columnNum=this.ics.length;
	}
	public int getColumnCount() {
//		return colNames.length;
		this.columnNum=0;
		for(ItemColumnState it:ics){
			if(it.isVisible())
				this.columnNum++;
		}
//		System.out.println("TableModelFee.getColumnCount():"+this.columnNum+"----"+new Date());
		return this.columnNum;
	}

	public int getRowCount() {
//		try{
//			list=model.get(cond);
//		}
//		catch(Exception e){
//			return 0;
//		}
		
		return list==null?0:list.size();
	}
	private int oldNum=-1;
	public Object getValueAt(int rowIndex, int columnIndex) {
//	System.out.println(rowIndex+"-"+columnIndex);
		if(rowIndex==0 && columnIndex==0){
			if(oldNum!=columnNum){
				oldNum=this.columnNum;
				RowColorRenderer.paintColorRow(table);
			}

		}
//		if(rowIndex<0 || rowIndex >= this.list.size()) {
//			return null;
//		}
		Fee con=list.get(rowIndex);
//		System.out.println(con);
		if(columnIndex<0){
			return con;
		}
//		String doorNo=null,floorNo=null;
//		if(con.getTemConAddr3().length()==3){
//			doorNo=con.getTemConAddr3().substring(0,1);
//			floorNo=con.getTemConAddr3().substring(1,2);
//		}
//		else if(con.getTemConAddr3().length()>3){
//			String sss[]=con.getTemConAddr3().split("-");
//			doorNo=sss[0];
//			if(sss.length>1)
//				floorNo=sss[1];
//		}
		if(this.row!=rowIndex){
//			NumberFormat nf=NumberFormat.getCurrencyInstance();
//			nf.setMaximumFractionDigits(2);
//			nf.setMinimumFractionDigits(2);
//			nf.setRoundingMode(RoundingMode.HALF_UP);
			int i=0;
			String s=null;
			ss[i++]=con.getFeeNo();
			ss[i++]=con.getFeePdtNo();
			ss[i++]=con.getFeePdtName();
			ss[i++]=MvcProperties.toStr(con.getFeeAmount());
			ss[i++]=MvcProperties.toStr(con.getFeePrice());
			ss[i++]=MvcProperties.toStr(con.getFeeTotalPrice());
			ss[i++]=MvcProperties.sdf.format(con.getFeeDate());
			ss[i++]=con.getFeeComment();
			this.row=rowIndex;
		}

		for(int i=columnIndex;i<ics.length;i++){
			if(ics[i].getNo()==columnIndex){
//				System.out.println(ss[i]);
				return ss[i];
			}
		}
		
		return null;
	}
	//New 20131222
	public  ItemColumnState[] getIcs() {
		return ics;
	}
	public  void setIcs(ItemColumnState[] ics) {
		this.ics = ics;
		MvcProperties.storeColumn("fee", ics);
	}
	
	public  void setIcsAll(){
		for(int i=0;i<ics.length;i++){
			ics[i]=new ItemColumnState(colNames[i],true,true,i);
		}
		ItemColumnState.setNos(ics);
		this.fireTableStructureChanged();
		MvcProperties.storeColumn("fee", ics);
	}
	
	public String getColumnName(int col){
//		return colNames[col];
		for(int i=col;i<ics.length;i++){
//			System.out.println(ics[i]);
			if(ics[i].getNo()==col){
//				System.out.println("--------------");
				return colNames[i];
			}
		}
		return null;
	}

//	public void setColConfiguration(List<Boolean> config) {
//	}

	public void setCondition(String cond) {
		this.cond = cond;
	}
	public void setList(List<Fee> list){
		this.list=list;
		this.setColor();
	}
	public List<Fee> getList(){
		this.row=-1;
		return this.list;
	}
//	public void user() {
//		System.out.println(this.userName);
//	}	
	public void setColor(){
		int n=list.size();
		Fee ht=null;
		byte color=0;
		for(int i=0;i<n;i++){
			Fee tem=list.get(i);
			if(ht!=null &&  MvcProperties.sdf.format(ht.getFeeDate()).equals(MvcProperties.sdf.format(tem.getFeeDate()))){
				tem.setColorOption(color);
			}
			else{
				color++;color%=2;
				tem.setColorOption(color);
				ht=tem;
				
			}
//			System.out.println(tem);
		}
	}
	
}
