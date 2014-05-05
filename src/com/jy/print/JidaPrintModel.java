package com.jy.print;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;

//import com.jy.db.ConnectionPool;

public class JidaPrintModel {
	public static String jidaHeader[] = { "学生编号", "姓名", "电话", "email", "日期",
			"科目", "费用" };
	private static ConnectionPool connectionPool = null;

	public JidaPrintModel() {
		connectionPool = ConnectionPool.getInstance(MvcProperties.dbName);
	}
	
	/**
	 * @param args 
	 */
	public static void main(String[] args)throws Exception {
		JidaPrintModel model=new JidaPrintModel();
		System.out.println(model.getEnrollReportList("2008-1-14", "2008-1-14", null));
		System.out.println(model.getReport("2008-1-1", "2008-2-1"));
	}
	public CourseResultReport getEnrollReportList(String start,String end,String crs_Id)throws Exception{
		float income=0;
		int count=0;
		String crs_name=null;
		String cond="";
		if(start!=null && !start.equals(""))
			cond="sgn_datetime>='"+start+"' ";
		if(end!=null && !end.equals("")){
			end+=" 23:59:59";
			end="sgn_datetime<='"+end+"' ";
			cond+=cond.equals("")?end:" and "+end;
		}
		if(crs_Id!=null && !crs_Id.equals("")){
			crs_Id="crs_id='"+crs_Id+"' ";
			cond+=cond.equals("")?crs_Id:" and "+crs_Id;
		}
		
		String sql="select  sgn_id, std_name,std_id,std_tel,std_email,datename(\"yy\",sgn_datetime)+datename(\"mm\",sgn_datetime)+datename(\"dd\",sgn_datetime) as date,crs_name ,pay_money "+
				   "from signup inner join stdcard on sgn_scr_id=scr_id inner join student on std_id=scr_std_id "+ 
				   "inner join course on sgn_crs_id=crs_id inner join payment on pay_scr_id=scr_id "+
				   (cond.equals("")?"":" where "+cond)+ 
				   " order by crs_id ,sgn_datetime";
		Connection conn=connectionPool.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		connectionPool.releaseConnection(conn);
		
		List<ReportItem> list=new ArrayList<ReportItem>();
		float pay_money=0;
		while(rs.next()){
			ReportItem item=new ReportItem();
			item.setCrs_name(crs_name=rs.getString("crs_name"));
			item.setDate(rs.getString("date"));
			item.setPay_money(pay_money=rs.getFloat("pay_money"));
			item.setSgn_id(rs.getString("sgn_id"));
			item.setStd_email(rs.getString("std_email"));
			item.setStd_id(rs.getString("std_id"));
			item.setStd_tel(rs.getString("std_tel"));
			item.setStd_name(rs.getString("std_name"));
			list.add(item);
			count++;
			income+=pay_money;
		}
		if(list.size()==0)
			return null;
		CourseResultReport crr=new CourseResultReport();
		crr.setCount(count);
		crr.setCrs_id(crs_Id);
		crr.setCrs_name(crs_Id==null?"合计":crs_name);
		crr.setIncome(income);
		crr.setList(list);
		return crr;
	}
	
	public Map<String ,CourseResultReport> getReport(String start,String end)throws Exception{
		List<String> crss=new ArrayList<String>();
		String sql="select  crs_id from course"; 
		Connection conn=connectionPool.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		connectionPool.releaseConnection(conn);

		while(rs.next()){
			crss.add(rs.getString("crs_id"));
		}
		System.out.println(crss);
		Map<String ,CourseResultReport> map=new HashMap<String, CourseResultReport>();
		for(String crs:crss){
			CourseResultReport crr=this.getEnrollReportList(start, end, crs);
			if(crr!=null){
				map.put(crr.getCrs_id(),crr);
			}
		}
	//	System.out.println(map);
		return map;
		
	}
	
	
	

}
