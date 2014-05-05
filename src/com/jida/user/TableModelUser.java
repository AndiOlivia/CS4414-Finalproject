package com.jida.user;

import java.util.List;


import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.jida.gui.RowColorRenderer;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;


public class TableModelUser extends AbstractTableModel{
//	ModelUser modelproduct;
	List<User>list;
	int columnNum;
	private JTable table;
	public TableModelUser(JTable table){
		this.table=table;
	}
//	String cond=null;
	public static String []colNames=User.titles;//{"用户名","状态","电话","移动电话","地址","身份证号"};
	public  TableModelUser(ModelUser modelproduct){
//		this.modelproduct=modelproduct;
//		this.cond=cond;
	}
	public int getColumnCount() {
		return columnNum=colNames.length;
	}

	public int getRowCount() {
//		if(list==null){
//			try{
//				list=modelproduct.getUser(false);
//			}
//			catch(Exception e){
//				return 0;
//			}
//		}
		return list==null?0:list.size();
	}
	
	Object obj[]=new Object[colNames.length];
	int row=-1;
	int oldNum=-1;
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(oldNum!=columnNum && table!=null ){
			oldNum=this.columnNum;
			RowColorRenderer.paintColorRow(table);
//			first=true;
//			dirty=
		}
		User user=list.get(rowIndex);
		if(row!=rowIndex){
			int k=0;
			obj[k++]=user.getT1();//getPostCode();
			obj[k++]=user.getName();
			
			obj[k++]=user.getTel();
			obj[k++]=user.getMobile();
			obj[k++]=user.getProvince();
			obj[k++]=user.getCity();
			obj[k++]=user.getAddr();
			obj[k++]=user.getPostCode();
			obj[k++]=User.codesString[user.getState()];
//			obj[k++]=user.getPassword();
			row=rowIndex;
		}
//		String ss[]={user.getName(),Byte.toString(user.getState()),
//				user.getTel(),user.getMobile(),
//				user.getAddr(),user.getId()};
		return obj[columnIndex];
	}
	
	public String getColumnName(int col){
		return this.colNames[col];
	}
	
	public List<User> getList() {
		return list;
	}
	
	public void setList(List<User> list) {
		this.list = list;
		this.oldNum=-1;
		this.row=-1;
		setColor();
	}
	public void setColor(){
		if(list==null)return;
		int n=list.size();
		User ht=null;
		byte color=0;//Update 20110428 color=0; Restore 20110429
		for(int i=0;i<n;i++){
			User tem=list.get(i);
			
			if(i%3!=0){//ht!=null && ht.getT1().toUpperCase().equals(tem.getT1())){
				tem.setColorOption(color);
			}
			else{
				color++;color%=2;
				tem.setColorOption(color);
				ht=tem;
			}
//			System.out.println(ht!=null?:-1);
//			System.out.println(" tem:"+tem+" color="+tem.getColorOption());
			
		}
	}
}
