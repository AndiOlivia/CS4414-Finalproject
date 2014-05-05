package com.jida.excel;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDayData {
	public static List<byte[]> importExcel(String excelPath)throws Exception{
		FileInputStream is = new FileInputStream(excelPath);
		HSSFWorkbook wb = new HSSFWorkbook(is);
		HSSFSheet sheet=wb.getSheetAt(0);
		List<byte[]> list=new ArrayList();

		for(int i=1 ;;i++ ){
			HSSFRow row1=sheet.getRow(i);
			if(row1==null)
				break;
			byte[] data=new byte[48];
			for(short j=0;j<data.length;j++){
				HSSFCell cell=row1.getCell(j);
				if(cell==null)
					continue;
				String s=null;
				float f;
				byte b;
				s=cell.toString();
				
//				switch(j){
//				case 0:
//					
//					break;
//				case 1:
//					
//					break;
//				case 2:
//				
//					break;
//			
//				}
				try{
					f=Float.parseFloat(s);
					b=(byte)f;
					System.out.println("ExcelA6:cell"+b);
					data[j]=b;
				}
				catch(Exception e){
					data[j]=(byte)0;
				}

			}
			list.add(data);

		}

		is.close();
		return list;
	}
	public static void main(String[] args){
		String s="101.0";
		float f=Float.parseFloat(s);
		int i=(int)f;
		s=Integer.toString(i);
		i=Integer.parseInt(s, 16);
		System.out.println(i);
	}
}
