package com.jida.server;

import java.text.DateFormat;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import com.jida.gui.ItemColumnState;
import com.jida.gui.RowColorRenderer;
import com.jida.server.data.MonitorLog;
//import com.jida.server.data.Workstation;
import com.jida.util.ToolKit;


public class TableModelCenter extends AbstractTableModel {
	private List<MonitorLog> list;
	private int columnNum;
	private Object ss[]=new Object[MonitorLog.titles.length];
	private int row=-1;
	private JTable table;
	public static String [] colNames=null; 
	public static ItemColumnState ics[]=null;//new ItemColumnState[colNames.length];
		
	public TableModelCenter(JTable table){
//		this.model=model;
		this.table=table;
		try{
			this.colNames=MonitorLog.titles;
			ics=new ItemColumnState[colNames.length];
			
			for(int i=0;i<ics.length;i++){
				ics[i]=new ItemColumnState(colNames[i],true,true,i);
			}
			ics[0].setEnabled(false); //ics[0].setVisible(true);
			ics[1].setEnabled(false);//ics[1].setVisible(true);
			ics[2].setEnabled(false);//ics[2].setVisible(true);
			ics[3].setEnabled(false);// ics[3].setVisible(true);
//			ics[4].setEnabled(false);//ics[4].setVisible(true);
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
	public Object getValueAt(int rowIndex, int columnIndex) {
//	System.out.println(rowIndex+"-"+columnIndex);
//		if(rowIndex==0 && columnIndex==0){
//			if(oldNum!=columnNum){
//				oldNum=this.columnNum;
//				RowColorRenderer.paintColorRow(table);
//			}
//
//		}
		if(rowIndex<0 || rowIndex >= this.list.size()) {
			return null;
		}
		MonitorLog con=list.get(rowIndex);
//		System.out.println(con);
		if(columnIndex<0){
			return con;
		}
//		"MAC",
//		"IP",
//		"登录用户","登录时间",
//		"被监视工作站"
		if(this.row!=rowIndex){
//			ss[0]=con.getPostCode();
			ss[0]=con.getHostId();
			
			ss[1]=con.getIp()==null?"":con.getIp();
			ss[2]=con.getName()==null?"":con.getName();
			ss[3]=con.getDate()!=null?DateFormat.getDateTimeInstance().format(con.getDate()):null;
			ss[4]=con.getWksName()==null?"":con.getWksName();
//			ss[10]=	con.getSerialPort()==null?"":con.getSerialPort();
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

//	public void setCondition(String cond) {
//		this.cond = cond;
//	}
	public void setList(List list){
		this.list=list;
		this.setColor();
		this.row=-1;
//		System.out.println("TableModelTemCon:setList:"+list);
	}
	public List<MonitorLog> getList(){
		return this.list;
	}
//	public void user() {
//		System.out.println(this.userName);
//	}	
	public void setColor(){
		if(list==null)
			return ;
		int n=list.size();
		MonitorLog ht=null;
		byte color=0;
		for(int i=0;i<n;i++){
			MonitorLog tem=list.get(i);
			if(ht!=null && tem.getHostId().equals(ht.getHostId())){
				tem.setColor(color);
			}
			else{
				color++;color%=2;
				tem.setColor(color);
				ht=tem;
				
			}
//			System.out.println(tem);
		}
	}

}
