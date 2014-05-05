package com.jida.user;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.jida.user.domObject.Group;
import com.jida.user.intf.ModelUser;



public class TableModelGroup extends AbstractTableModel{
	ModelUser modelproduct;
	List<Group>list;
//	String cond=null;
	public static String []colNames={"组名","描述"};
	public  TableModelGroup(ModelUser modelproduct){
		this.modelproduct=modelproduct;
//		this.cond=cond;
	}
	public List<Group> getList() {
		return list;
	}
	public void setList(List<Group> list) {
		this.list = list;
	}
	public int getColumnCount() {
		return colNames.length;
	}

	public int getRowCount() {

//		try{
//			list=modelproduct.getGroup(false);
//		}
//		catch(Exception e){
//			return 0;
//		}
		return list==null?0:list.size();
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		Group group=list.get(rowIndex);
	
		switch(columnIndex){
		case 0:
			return group.getName();
		case 1:
			return group.getDesc();
		}
		return null;
	}
	public String getColumnName(int col){
		return this.colNames[col];
	}
}
