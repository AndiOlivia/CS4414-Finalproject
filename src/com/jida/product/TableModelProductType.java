package com.jida.product;

import java.util.List;


import javax.swing.table.AbstractTableModel;

import com.jida.product.data.ProductType;




public class TableModelProductType extends AbstractTableModel {
	private List<ProductType> list;
	private String [] titles;
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return ProductType.titles.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.list==null?0:list.size();
	}
	
	Object obj[]=new Object[ProductType.titles.length];
	int row=-1;

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		ProductType pt;
		pt=this.list.get(rowIndex);
	
		if(row!=rowIndex){
			obj[0]=pt.getPtName();
			obj[1]=pt.getPtBrief();
	
			row=rowIndex;
		}
		return obj[columnIndex];
	}

	public String getColumnName(int i){
		return ProductType.titles[i];///////////////////////////////////////////////////////////////////////
	}
	
	public void setList(List<ProductType> list){
		this.row=-1;
		this.list=list;
		System.out.println(list);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
