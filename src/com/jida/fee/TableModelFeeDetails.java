package com.jida.fee;

import java.text.DateFormat;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.jida.MvcProperties;
import com.jida.fee.data.FeeDetails;
import com.jida.gui.ItemColumnState;
import com.jida.gui.RowColorRenderer;

public class TableModelFeeDetails extends AbstractTableModel {
	private static final long serialVersionUID = 0L;
	List<FeeDetails> list=null;
//	private String userName=null;
	private String cond=null;
	private int columnNum;
	private Object ss[]=new Object[FeeDetails.titles.length];
	private int row=-1;
	private JTable table;
	public  String [] colNames=null; 
	public  ItemColumnState ics[]=null;//new ItemColumnState[colNames.length];
		
	public TableModelFeeDetails(JTable table){
//		this.model=model;
		this.table=table;
		try{
			this.colNames=FeeDetails.titles;
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
//		this.userName=userName;
//		this.cond=cond;
		
		MvcProperties.loadColumn("feeDetails", ics);
		this.columnNum=this.ics.length;
	}
	public int getColumnCount() {
//		return colNames.length;
		this.columnNum=0;
		for(ItemColumnState it:ics){
			if(it.isVisible())
				this.columnNum++;
		}
//		System.out.println("column num:"+this.columnNum+"----"+new Date());
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
//	"单元控制箱","温控器",
//	"安装位置",
//	"开始时间","结束时间",
//	"时长(分钟)",
//	"功率","单价",
//	"费用",
	public Object getValueAt(int rowIndex, int columnIndex) {
//	System.out.println(rowIndex+"-"+columnIndex);
//		if(rowIndex==0 && columnIndex==0){
		if(oldNum!=columnNum && table!=null){
			oldNum=this.columnNum;
			RowColorRenderer.paintColorRow(table);
//			System.out.println("TableModelFeeDetail:getValueAt:"+rowIndex+","+columnIndex);
		}

//		}
		if(rowIndex<0 || rowIndex >= this.list.size()) {
			return null;
		}
		FeeDetails con=list.get(rowIndex);
//		System.out.println(con);
		if(columnIndex<0){
			return con;
		}
		
		if(this.row!=rowIndex){
			ss[0]=con.getFdNo();
			ss[1]=con.getFdPdtNo();
			ss[2]=con.getFdPdtName();
			ss[3]=MvcProperties.toStr(con.getFdAmount());
			ss[4]=MvcProperties.toStr(con.getFdPrice());
			ss[5]=MvcProperties.toStr(con.getFdTotalPrice());
			ss[6]=con.getFdComment();
			this.row=rowIndex;
		}

		for(int i=0;i<ics.length;i++){
			if(ics[i].getNo()==columnIndex){
//				System.out.println(ss[i]);
				return ss[i];
			}
		}
		
		return null;
	}
	public String getColumnName(int col){
//		return colNames[col];
		for(int i=0;i<ics.length;i++){
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
	public void setList(List<FeeDetails> list){
		this.list=list;
		this.row=-1;
		this.oldNum=-1;
		this.setColor();
	}
	public List<FeeDetails> getList(){
		return this.list;
	}
	public void setColor(){
		if(list==null)
			return;
		
		int n=list.size();
		FeeDetails ht=null;
		byte color=0;
		for(int i=0;i<n;i++){
			FeeDetails tem=list.get(i);
			if(ht!=null && ht.getFdPdtNo().equals(tem.getFdPdtNo())){
				tem.setColorOption(color);
			}
			else{
				color++;color%=2;
				tem.setColorOption(color);
				ht=tem;
//				System.out.println("TableModelFeeDetail:setColor:"+ht);
				
			}
//			System.out.println(tem);
		}
	}
//	public void user() {
//		System.out.println(this.userName);
//	}	
//	public void setColor(){
//		int n=list.size();
//		FeeDetails ht=null;
//		byte color=0;
//		for(int i=0;i<n;i++){
//			FeeDetails tem=list.get(i);
//			if(ht!=null && ht.getTemConAddrCode()==tem.getTemConAddrCode()){
//				tem.setColorOption(color);
//			}
//			else{
//				color++;color%=2;
//				tem.setColorOption(color);
//				ht=tem;
//				
//			}
////			System.out.println(tem);
//		}
//	}
	//New 20131222
	public ItemColumnState[] getIcs() {
		return ics;
	}
	public void setIcs(ItemColumnState[] ics) {
		this.ics = ics;
		MvcProperties.storeColumn("feeDetails", ics);
	}
	
	public  void setIcsAll(){
		for(int i=0;i<ics.length;i++){
			ics[i]=new ItemColumnState(colNames[i],true,true,i);
		}
		ItemColumnState.setNos(ics);
		this.fireTableStructureChanged();
		MvcProperties.storeColumn("feeDetails", ics);
	}
	
}
