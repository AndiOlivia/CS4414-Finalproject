package com.jida.gui;

import java.awt.Color;


import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer; 
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.jida.MvcProperties;
import com.jida.fee.TableModelFee; 
import com.jida.fee.TableModelFeeDetails;
import com.jida.product.TableModelProduct;
import com.jida.user.TableModelUser;

public class RowColorRenderer extends DefaultTableCellRenderer {
//	public static Color colors[]=new Color[]{MvcProperties.color1,MvcProperties.color2};

	private int nColor=0;
//	private Object oldObject=null;
	public  Component getTableCellRendererComponent(JTable t, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		//
		TableModel model=t.getModel();
		if(model instanceof TableModelFee){
			nColor=((TableModelFee)model).getList().get(row).getColorOption();
//			System.out.println("RowColorRenderer:"+nColor+","+((TableModelTemCon)model).getList().get(row));
		}
//		else if(model instanceof TableModelFeeDetails){
//			nColor=((TableModelFeeDetails)model).getList().get(row).getColorOption();
////			System.out.println("RowColorRenderer:"+nColor+","+((TableModelTemCon)model).getList().get(row));
//		}
//		else 
			if(model instanceof TableModelUser){
			nColor=((TableModelUser)model).getList().get(row).getColorOption();
//			System.out.println("RowColorRenderer:"+nColor+","+((TableModelUser)model).getList().get(row));
		}
		else if(model instanceof TableModelProduct){
			nColor=((TableModelProduct)model).getList().get(row).getColorOption();
//			System.out.println("RowColorRenderer:"+nColor+","+((TableModelTemCon)model).getList().get(row));
		}
		
		//		synchronized(this){
		this.setBackground(MvcProperties.colors[nColor]);
		//		System.out.println("RowColorRenderer:"+nColor+","+row+","+column);

		return super.getTableCellRendererComponent(t, value, isSelected,
				hasFocus, row, column);
		//		}
	}
	public static void paintColorRow(JTable table) {
		
		TableColumnModel tcm = table.getColumnModel();
		int n = tcm.getColumnCount();
//		System.out.println("RowColorRender:paintColorRow:"+n);
		for (int i = 0; i < n; i++) {
			TableColumn tc = tcm.getColumn(i);
			tc.setCellRenderer(new RowColorRenderer());
			int w=table.getWidth();
			if(i==n-1){
				tc.setPreferredWidth((int)((double)w/(n+1.5)*2.5));
//				tc.setWidth((int)((double)w/(n+2)*3));
			}
			else{
				tc.setPreferredWidth((int)((double)w/(n+1.5)));
//				tc.setWidth((int)((double)w/(n+2)));
			}
//			System.out.println("RowColorRenderer:width="+tc.getWidth());
		}
	}
	
}
