package com.jida.user;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.jida.user.domObject.Privilege;


public class TableModelPrivilege extends AbstractTableModel {
//	private ModelPrivilege model;
	private List<Privilege> list;
	public TableModelPrivilege(){
//		this.model=model;
	}
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		return Privilege.titles.length;
	}

	
	public int getRowCount() {
		// TODO Auto-generated method stub	
		return list==null?0:list.size();
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Privilege pri=list.get(rowIndex);
		Object objs[]={pri.getPriName(),pri.getPriDesc()};
		return objs[columnIndex];
	}
	public String getColumnName(int i){
		return Privilege.titles[i];
	}
	public Class<?> getColumnClass(int col){
		return this.getValueAt(0, col).getClass();
	}
	public boolean isCellEditable(int row,int col){
		return col==0?false:true;
	}
	public void setValueAt(Object newValue,int row,int col){
		Privilege pri=list.get(row);
		switch(col){
		case 0:
			pri.setPriName((String)newValue);
			break;
		case 1:
			pri.setPriDesc((String)newValue);
			break;
		}
	}
	public void setList(List list){
		this.list=list;
	}
}
