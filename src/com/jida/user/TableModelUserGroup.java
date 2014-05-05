package com.jida.user;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.jida.user.domObject.Group;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelUser;


public class TableModelUserGroup extends AbstractTableModel{
	ModelUser modelproduct;
	List<Group> list;
	List<Group> listBasic;
//	String cond=null;
	public static String []colNames={"选择","组名","描述"};
	public  TableModelUserGroup(ModelUser modelproduct){
		this.modelproduct=modelproduct;
		try {
			listBasic=modelproduct.getGroup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		this.cond=cond;
	}
	public int getColumnCount() {
		return colNames.length;
	}

	public int getRowCount() {

//		try{
//		list=modelproduct.getGroup(false);
//		}
//		catch(Exception e){
//		return 0;
//		}
//		if(list==null){
//			return 0;
//		}
		
		return listBasic.size();
	}
	Object obj[]=new Object[colNames.length];
	int row=-1;
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Group group=null;
		try {
			group = listBasic.get(rowIndex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("tableModelUserGroup:getValueAt() group="+group+","+rowIndex+","+columnIndex);
		if(row!=rowIndex){
			obj[0]=list!=null&& list.contains(group)?true:false;
			obj[1]=group.getName();
			obj[2]=group.getDesc();

		}
//		System.out.println("tableModelUserGroup:getValueAt() "+obj[columnIndex]);
		return obj[columnIndex];
	}
	public String getColumnName(int col){
		return this.colNames[col];
	}
	public List<Group> getList() {
		return list;
	}
	public void setList(List<Group> list) {
		this.list = list;
//		this.listBasic=list;
	}

	//通过getClass()方法设置默认的控件,如true与false的默认控件是复选框,

	//该方法不一定要加入AbstractTableModel类

	public Class getColumnClass(int c) {

		return getValueAt(0, c).getClass();

	}



	//定义可以编辑的单元,true表示可编辑,false表示不可编辑

	public boolean isCellEditable(int row, int col) {
		if(col==0)
			return true;
		return false;

	}



	//将改变后的值保存在表格中

	public List<Group> getListBasic() {
		return listBasic;
	}
	public void setListBasic(List<Group> listBasic) {
		this.listBasic = listBasic;
	}
	public void setValueAt(Object value, int row, int col) {
		obj[col] = value;

		fireTableCellUpdated(row, col);

	}
}
