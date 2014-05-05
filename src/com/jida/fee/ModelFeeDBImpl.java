package com.jida.fee;

import java.sql.Connection;

 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;
import com.jida.client.Main;
import com.jida.excel.ExcelBeanFee;
import com.jida.fee.data.Fee;
import com.jida.fee.data.FeeDetails;
import com.jida.gui.JFrameGui;
import com.jida.gui.JFrameGuiSuper;

public class ModelFeeDBImpl implements ModelFee {
//	ModelLinkman modelLinkman=new ModelLinkmanDBImpl();
//	private ModelLinkman modelLinkman;

	private ViewFee view;
	Connection conn;
	Statement stmt;
	List<Fee> list = new ArrayList();
	List<Fee> listOld;//考虑到过滤问题，
//	List<String> listFee;
	List<FeeDetails> listDetails;
	private static ConnectionPool connectionPool = null;
	String cond;
//	String condFD;
	boolean dirty=true;
	private float total;
//	boolean dirtyFD=true;

	public float getTotal() {
		return total;
	}


	//singleton
	private static ModelFeeDBImpl modelFee=new ModelFeeDBImpl();
	public static ModelFeeDBImpl getInstance(){
		return modelFee;
	}
	private ModelFeeDBImpl() {
		connectionPool = ConnectionPool.getInstance(MvcProperties.dbName);
//		init();
//		System.out.println(Fee.map);
//		this.modelLinkman=modelLinkman;
//		this.modelHistoryTem=ModelDBImplHistoryTem.getInstance();
	}


	public static final String CUST="cust";


	public void addViewListener(ViewFee viewcustandlink) {
		this.view=viewcustandlink;
	}

	public void fireModelChange(Object obj){
		dirty=true;
		if(view!=null){
			view.processModelChange(obj);
		}
	}


	public void delete(Fee item) throws Exception {
		//从库中删
		Connection conn=connectionPool.getConnection();
		try{
			Statement stmt=conn.createStatement();
			String sql="delete from Fee where feeNo="+item.getFeeNo();

			stmt.executeUpdate(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		//从现表中删
//		this.customers=this.getCustomer();//
//		System.out.println("ModelDBImplTEmCon:delete:"+listOld);
//		this.listOld.remove(item);
//		System.out.println("ModelDBImplTEmCon:delete:"+listOld);
//		this.list.remove(item);
		//
		for(int i=0;i<list.size();i++){
			Fee f=list.get(i);
			if(f.equals(item))
				list.remove(i);
		}
		this.fireModelChange(list);

		//删去Fee.map
//		List<Fee> l=Fee.map.get(item.getTemConAddrCode());
//		l.remove(item);

	}


	public  static String [] getColumnName(String tableName) {
		String []ss=Fee.titles;
		return ss;

	}


	public List<Fee> get(boolean fetch) throws Exception{
		dirty=fetch || list==null;
		return get(cond);
	}
	public synchronized  List<Fee> get() throws Exception {

		return get((String)null);
	}

 
	public List<Fee> get(String cond)throws Exception{
		total=0;
		if(!dirty && (cond==this.cond || cond!=null && cond.equals(this.cond)))
			return list;
		Connection conn=connectionPool.getConnection();
		ResultSet rs=null;
		try{
			Statement stmt=conn.createStatement();
			String sql="select * from Fee inner join product on feePdtId=pdtNo ";
			if(cond!=null && !cond.equals("")){
				sql+=" where "+cond;
			}
			sql+=" order by feeDate ASC, pdtType ASC";
			rs=stmt.executeQuery(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		String s=null;
		if(list==null)
			list=new ArrayList();
		else
			list.clear();
		if(list.size()>0){
			list.clear();
//			System.out.println("ModelDBImpl:get:list=="+list);
		}

		Fee tc=null,t=null;
		reset();
		while(rs.next()){
			Fee cust=new Fee();
//			cust.setNo(rs.getInt("no"));
			cust.setFeeNo(rs.getInt("feeNo"));
			cust.setFeePdtNo(rs.getString("feePdtId"));
			cust.setFeePdtName(rs.getString("feePdtName"));
			cust.setFeePrice(rs.getFloat("feePrice"));
			cust.setFeeAmount(rs.getFloat("feeAmount"));
			cust.setFeeTotalPrice(rs.getFloat("feeTotalPrice"));
			cust.setFeeDate((s=rs.getString("feeDate"))==null?null:MvcProperties.sdf.parse(s));
			cust.setFeeComment(rs.getString("feeComment"));
			
			
//			computeTotal(cust);
//			total+=cust.getTotal();
//			size+=cust.getSize();
//			this.energy+=cust.getEnergy();
			list.add(cust);
		}
		this.dirty=false;
		this.cond=cond;

//		System.out.println(listOld);
//		System.out.println(list);
		return list;
	}
//	public Fee find(Fee tc){
//	if(this.listOld==null)
//	return null;
//	for(Fee t:listOld){
//	if(t.equals(tc))
//	return t;
//	}
//	return null;
//	}

//	public void restore(){
//	this.list=this.listOld;
//	}

	public int getIndex(Fee cust, String cond) {
		try{
			list=this.get(cond);
		}catch(Exception e){
			JFrameGuiSuper.gui.showStatus(e);
		}

		int n=this.list.size();
		for(int i=0;i<n;i++){
			if(cust.equals(this.list.get(i)))
				return i;
		}
		return -1;
	}

	public int getCount(){
		return this.list.size();

	}

	public void insert(Fee cust) throws Exception {
		Connection conn=connectionPool.getConnection();
		String sql="insert into Fee (feePdtId,feePdtName,feePrice,feeAmount,feeTotalPrice,feeDate,feeComment) values(?,?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

		stmt.setString(1, cust.getFeePdtNo());//+"','"+
		stmt.setString(2,cust.getFeePdtName());//+"','"+
		stmt.setFloat(3,cust.getFeePrice());
		stmt.setFloat(4,cust.getFeeAmount());
		stmt.setFloat(5,cust.getFeeTotalPrice());
		stmt.setString(6,MvcProperties.sdfTime.format(cust.getFeeDate()));
		stmt.setString(7,cust.getFeeComment());
		
		try{
			stmt.executeUpdate();
			ResultSet rs=stmt.getGeneratedKeys();
			if(rs.next()){
				int no=rs.getInt(1);
				cust.setFeeNo(no);
			}
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		
		list.add(cust);
		this.fireModelChange(list);
		//存入用户日志
//		ModelDBImplUserOperateLog.getInstance().insert(UserOperateLog.TemControolerAdd,1);
//		this.fireModelChange(list);
	}


	public void update(Fee cust) throws Exception {
		Connection conn=connectionPool.getConnection();
//		String sql="update moneyStatistics set Money0=?, Timelong0=?, Money1=?, Timelong1=?, Money2=?, Timelong2=? ,total=? where TemConAddr=? and Date=?";
		String sql="update Fee set feePdtId=?,feePdtName=?,feePrice=?,feeAmount=?,feeTotalPrice=?,feeDate=?,feeComment=? where feeNo=? ";
		try{
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,cust.getFeePdtNo());
			stmt.setString(2,cust.getFeePdtName());
			stmt.setFloat(3,cust.getFeePrice());
			stmt.setFloat(4,cust.getFeeAmount());
			stmt.setFloat(5,cust.getFeeTotalPrice());
			stmt.setString(6,MvcProperties.sdfTime.format(cust.getFeeDate()));
			stmt.setString(7, cust.getFeeComment());//+","+
			stmt.setInt(8, cust.getFeeNo());
			
			stmt.executeUpdate();
			
			for(Fee f:list){
				if(f.equals(cust)){
					f.copy(cust);
				}
			}
			this.fireModelChange(list);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		
	}

	public static void main(String[] args)throws Exception {
//		ModelLinkman modelLinkman=new ModelLinkmanDBImpl();
		ModelFee model=new ModelFeeDBImpl();
		System.out.println(model.get());
//		System.out.println(model.toTemConString());

		Fee tc=new Fee();
		

	}

//	public Fee getCustomerById(String id) throws Exception {
//	return this.getCustomerByName(id);
//	}

//	public static String [] getAgents(){
//	String ss[]=null;
//	try{
//	ModelTempCon customerModel=new ModelDBImplTemCon();
//	List<Fee> customers=customerModel.getCustomer();
//	ss=new String[customers.size()];
//	for(int i=0;i<ss.length;i++){
//	ss[i]=customers.get(i).getCustName();
//	}
//	}
//	catch(Exception excp){
//	MvcProperties.toLog(excp);
//	}
//	return ss;
//	}

	public void exportExcel(String excelPath)throws Exception{
		ExcelBeanFee eb=new ExcelBeanFee();
		eb.exportExcel(excelPath,list);

	
	}

//	public void exportExcelTime(String excelPath)throws Exception{
//		ExcelBeanHistoryTem eb=new ExcelBeanHistoryTem();
//		eb.exportExcelTime(excelPath,this.listDetails);
//
//		
//		ModelDBImplUserOperateLog.getInstance().insert(UserOperateLog.FeeDataExport,1);
//	}
	/**
	 * 
	 */
	public List<Fee> computeFee(int temConAddrCode,int temConName,Date from)throws Exception{
		return null;
	}
	
	public void reset(){
		
	}
	public List<Fee> sort(){
		Collections.sort(list);
		return list;
	}
	
	public float computeTotal(Fee fee){
		return fee.getFeeAmount()*fee.getFeePrice();
	}
	
	public float getSize(){
		return 0;
	}
	public Fee getByIndex(int index){

		if(index<0 || index>=list.size())
			return null;
		return list.get(index);
	}
}


