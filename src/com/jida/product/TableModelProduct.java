package com.jida.product;

import java.util.List;


import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.jida.gui.ItemColumnState;
import com.jida.gui.RowColorRenderer;
import com.jida.product.data.Product;


public class TableModelProduct extends AbstractTableModel {

	private ModelProduct model;
	private List<Product> list;
	private int columnNum;
	private int oldNum=-1;
	private JTable table;
	private Object ss[]=new Object[Product.titles.length];
	private int row=-1;
	public static ItemColumnState ics[]=null;
	public TableModelProduct(ModelProduct model,JTable table){
		this.model=model;
		this.table=table;
	}
	

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Product.titles.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
//		try {
//			list=model.get();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return list==null?0:list.size();
	}
	private int oldRow=-1;
	boolean first=true;
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
//		if(rowIndex==0 && columnIndex==0){
		if(oldNum!=columnNum){
			oldNum=this.columnNum;
			RowColorRenderer.paintColorRow(table);
		}

//		}
		//"No","Product Name","Category","Place","Producer","Tel","Comment"
		if(oldRow!=rowIndex){
			Product pro=list.get(rowIndex);
			ss[0]=pro.getPdtNo();
			ss[1]=pro.getPdtName();
			ss[2]=pro.getPdtType();
			ss[3]=pro.getPdtPrice();
			ss[4]=pro.getPdtFactory();
			ss[5]=pro.getPdtTel();
			ss[6]=pro.getPdtAddr();
//			ss[7]=pro.getPdtLinkMan();
			ss[7]=pro.getPdtComment();
			oldRow=rowIndex;
		}
		return ss[columnIndex];
//		if(rowIndex==0 && columnIndex==0){
//			if(oldNum!=columnNum){
//				oldNum=this.columnNum;
//				RowColorRenderer.paintColorRow(table);
//			}
//
//		}
//		if(rowIndex<0 || rowIndex >= this.list.size()) {
//			return null;
//		}
//		KuFang con=list.get(rowIndex);
//		//		System.out.println(con);
//		if(columnIndex<0){
//			return con;
//		}
//
//		if(this.row!=rowIndex){
//			ss[0]=con.getKFMC();
//			ss[1]=con.getLX();
//			ss[2]=con.getCCF();
//			ss[6]=con.getYSCRK();
//			ss[3]=con.getHD();
//			ss[4]=con.getZT();
//			ss[5]=con.getJZTJL();
//			ss[7]=con.getZZTWFSJ();
//			//			ss[8]=con.getPowers();
//			//			ss[9]=con.isState()?"正常":"异常";
//			//			ss[10]=	con.getSerialPort()==null?"":con.getSerialPort();
//			this.row=rowIndex;
//		}
//
//		for(int i=0;i<ics.length;i++){
//			if(ics[i].getNo()==columnIndex){
//				//				System.out.println(ss[i]);
//				return ss[i];
//			}
//		}
//
//		return null;
		
		
//		KuFang item=list.get(rowIndex);
//		if(first){
//			first=false;
//			RowColorRenderer.paintColorRow(table);
//		}
//		Object obj[]={
//				item.getKFMC(),
//				item.getLX(),
//				item.getCCF(),
//				item.getYSCRK(),
//				item.getHD(),
//				item.getZT(),
//				item.getJZTJL(),
//				item.getZZTWFSJ()
//		};
//		return obj[columnIndex];
	}
	public String getColumnName(int i){
		return Product.titles[i];
	}

	/**
	 * @param args
	 */
	public Integer[] getLeaveTimes(){
//		Integer s[] = null;
//		for(int i=0;i<list.size();i++){
//			s[i*2]=list.get(i).getFromHour();
//			s[i*2+1]=list.get(i).getToHour();
//		}
//		Arrays.sort(s);
		return null;
	}
	public List<Product> getList(){
		return list;
	}
	public void setList(List<Product> list){
		this.oldRow=-1;
		this.oldNum=-1;
		this.list=list;
		this.setColor();
	}
	
	public void setColor(){
		int n=list.size();
		Product ht=null;
		byte color=0;
		for(int i=0;i<n;i++){
			Product tem=list.get(i);
			if(ht!=null && ht.getPdtType().equals(tem.getPdtType())){
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
	public static void main(String args[]){
	//	TableModelDYXX model=new TableModelDYXX();	
	
	}
}
