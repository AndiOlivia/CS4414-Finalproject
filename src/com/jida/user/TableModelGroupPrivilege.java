package com.jida.user;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.jida.user.domObject.Group;
import com.jida.user.domObject.Privilege;
import com.jida.user.domObject.User;
import com.jida.user.intf.ModelPrivilege;
import com.jida.user.intf.ModelUser;


public class TableModelGroupPrivilege extends AbstractTableModel{
	ModelPrivilege modelproduct;
	List<Privilege> list;
	List<Privilege> listBasic;
//	String cond=null;
	public static String []colNames={"选择","权限","描述"};
	public  TableModelGroupPrivilege(ModelPrivilege modelproduct){
		this.modelproduct=modelproduct;
		try {
			listBasic=modelproduct.get();
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
		if(list==null){
			return 0;
		}
		return listBasic.size();
	}
	Object obj[]=new Object[colNames.length];
	int row=-1;
	public Object getValueAt(int rowIndex, int columnIndex) {
		Privilege privilege=null;
		try {
			privilege = listBasic.get(rowIndex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(row!=rowIndex){
			obj[0]=list.contains(privilege)?true:false;
			obj[1]=privilege.getPriName();
			obj[2]=privilege.getPriDesc();

		}
		return obj[columnIndex];
	}
	public String getColumnName(int col){
		return this.colNames[col];
	}
	public List<Privilege> getList() {
		return list;
	}
	public void setList(List<Privilege> list) {
		this.list = list;
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

	public void setValueAt(Object value, int row, int col) {
		obj[col] = value;

		fireTableCellUpdated(row, col);

	}
}
