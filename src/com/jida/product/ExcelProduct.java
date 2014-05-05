package com.jida.product;

import java.io.FileInputStream;


import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jida.MvcProperties;
//import com.jida.TempretureController.data.TempretureController;
//import com.jida.historyTem.data.HistoryTem;
//import com.jida.historyTem.data.Payment;
import com.jida.product.data.Product;


public class ExcelProduct {
//	public static List<TestHistory> importExcel(String excelPath)throws Exception{
//		FileInputStream is = new FileInputStream(excelPath);
//		HSSFWorkbook wb = new HSSFWorkbook(is);
//		HSSFSheet sheet=wb.getSheetAt(0);
////		HSSFRow row1=sheet.getRow(0);
////		row1=sheet.getRow(i);
//		List<TestHistory> list=new ArrayList();
//		TestHistory tc;
//		for(int i=2 ;;i++ ){
//			HSSFRow row1=sheet.getRow(i);
//			tc=new TestHistory();
//			if(row1==null)
//				break;
//			double value=0;
//			for(short j=0;j<TestHistory.titles.length-2;j++){
//				HSSFCell cell=row1.getCell(j);
//				if(cell==null)
//					continue;
//				String s=null;
//				s=cell.toString();
//				switch(j){
//				case 0:
//					tc.setTemConAddrCode(Integer.parseInt(s,16));
////					value=Integer.parseInt(s,16);
////					tc.setTemConAddrCode(s==null?(short)Integer.parseInt(Integer.toString((int)value),16):Integer.parseInt(s,16));
//					break;
//				case 1:
//					tc.setTemConName((short)Float.parseFloat(s)); break;
//				case 2:
//					tc.setTemConAddr1(s);break;
//				case 3:
//					try{
//						tc.setTemConAddr2(Integer.toString((int)Float.parseFloat(s)));
//					}
//					catch(Exception e){
//						tc.setTemConAddr2(s);
//					}
//					break;
//				case 4:
//					try{
//						tc.setTemConAddr3(Integer.toString((int)Float.parseFloat(s)));
//					}
//					catch(Exception e){
//						tc.setTemConAddr3(s);
//					}
//					break;
//				case 5:
////					tc.setSetAddr(s);break;
//				case 6:
////					tc.setTemConAddr1(s);
//					break;
//				case 7:
//					try{
//						tc.setSetAddr(Integer.toString((int)Float.parseFloat(s)));
//					}
//					catch(Exception e){
//						tc.setSetAddr(s);
//					}
//					break;
//				case 8:
//					tc.setPowers((short)Float.parseFloat(s));break;
//				
//				}
////				System.out.print(s+"  ");
//			}
//			list.add(tc);
////			System.out.println(tc);New20110322
//		}
//
//		is.close();
//		return list;
//		
//	}
	public void exportExcel(String excelPath,List<Product> list) throws Exception{
		FileOutputStream os = null;
		String title="物品列表";
//		os = new FileOutputStream(excelPath);
		os = new FileOutputStream(excelPath);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(title);
		HSSFHeader header = sheet.getHeader();
		header.setCenter(title);
		int line=0;
		HSSFRow row1 = sheet.createRow((short) line);
		HSSFCell cell11 = row1.createCell((short) 0);
		cell11.setEncoding(HSSFCell.ENCODING_UTF_16);
//		cell11.set(TempretureController.titles[i]);
		cell11.setCellValue(title);
		line++;
		
		row1 = sheet.createRow((short) line);
		for(int i=0;i<Product.titles.length;i++){
			cell11 = row1.createCell((short) i);
			cell11.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell11.set(TempretureController.titles[i]);
			cell11.setCellValue(Product.titles[i]);
		}
				
		line++;
		Object ss[]=new Object[Product.titles.length];
		Product pro=null;
		int i=0;
		for(int k=0;k<list.size();k++){	
			pro=(Product)list.get(k);
			i=0;
			
			
			ss[0]=pro.getPdtNo();
			ss[1]=pro.getPdtName();
			ss[2]=pro.getPdtType();
			ss[3]=pro.getPdtPrice();
			ss[4]=pro.getPdtFactory();
			ss[5]=pro.getPdtTel();
			ss[6]=pro.getPdtAddr();
			ss[7]=pro.getPdtLinkMan();
			ss[8]=pro.getPdtComment();


			HSSFRow rowj = sheet.createRow((short) line++);
			for(int j=0;j<ss.length;j++){
				HSSFCell cellj1 = rowj.createCell((short) j);
				cellj1.setEncoding(HSSFCell.ENCODING_UTF_16);
				cellj1.setCellValue(ss[j]==null?"":ss[j].toString());
			}
						
		}
		sheet.setGridsPrinted(true);
		HSSFFooter footer = sheet.getFooter();
		footer.setRight("Page " + HSSFFooter.page() + " of " +
		HSSFFooter.numPages());
		wb.write(os);
	}
//	public static void main(String[] args) {
//		FileOutputStream fos = null;
//		try {
//
//			ExcelBeanTestHistory eb = new ExcelBeanTestHistory();
//			List list=eb.importExcel("户式控制器.xls");
////			System.out.println(list);New20110322
//			eb.exportExcel("aa.xls", list);
////			fos = new FileOutputStream("c:/book.xls" );
////			ModelProcess modelProcess = new ModelProcessDBImpl();
////			List<? extends Object> list=modelProcess.getJoinProcess();
////			eb.expordExcel("c:/book.xls",list);
//
//
//
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}
}
