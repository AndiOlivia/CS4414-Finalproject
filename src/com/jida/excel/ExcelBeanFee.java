package com.jida.excel;

import java.io.FileOutputStream;

import java.text.DateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jida.MvcProperties;
import com.jida.fee.data.Fee;
public class ExcelBeanFee {
	public void exportExcel(String excelPath,List<Fee> list) throws Exception{
		FileOutputStream os = null;
//		os = new FileOutputStream(excelPath);
		os = new FileOutputStream(excelPath);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Fee Table");
		HSSFHeader header = sheet.getHeader();
		header.setCenter("Fee Table");
		int line=0;
		HSSFRow row1 = sheet.createRow((short) line);
		
		for(int i=0;i<Fee.titles.length;i++){
			HSSFCell cell11 = row1.createCell((short) i);
			cell11.setEncoding(HSSFCell.ENCODING_UTF_16);
//			cell11.set(TempretureController.titles[i]);
			cell11.setCellValue(Fee.titles[i]);
		}
				
		line++;
		Object ss[]=new String[Fee.titles.length];
		Fee item=null;
		for(int i=0;i<list.size();i++){	
			item=list.get(i);
			
			ss[0]=	item.getFeeNo();
			ss[1]=	item.getFeePdtNo();
			ss[2]=	item.getFeePdtName();
			ss[3]=		MvcProperties.toStr(item.getFeeAmount());
			ss[4]=		MvcProperties.toStr(item.getFeePrice());
			ss[5]=		MvcProperties.toStr(item.getFeeTotalPrice());
			ss[6]=		item.getFeeDate()!=null?MvcProperties.sdfTime.format(item.getFeeDate()):"";
			ss[7]=		item.getFeeComment();
			
			HSSFRow rowj = sheet.createRow((short) line++);
			for(int j=0;j<ss.length;j++){
				HSSFCell cellj1 = rowj.createCell((short) j);
				cellj1.setEncoding(HSSFCell.ENCODING_UTF_16);
				cellj1.setCellValue(ss[j].toString());
			}
						
		}
		sheet.setGridsPrinted(true);
		HSSFFooter footer = sheet.getFooter();
		footer.setRight("Page " + HSSFFooter.page() + " of " +
		HSSFFooter.numPages());
		wb.write(os);
	}
}
