package com.jida.server;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;
import com.jida.View;
import com.jida.client.Main;
import com.jida.fee.gui.PanelFee;
import com.jida.gui.JFrameGui;
import com.jida.gui.JFrameGuiSuper;
//import com.jida.portsell.SerialPortPoolManager;
import com.jida.server.data.Workstation;

public class ModelWorkStationDBImpl1 implements ModelWorkstation1{
	private View view;
	Connection conn;
	Statement stmt;
	List<Workstation> list;
	List<Workstation> listOld;//考虑到过滤问题，
	List<String> listTemCon;
	private static ConnectionPool connectionPool = null;
	String cond;
	boolean dirty=true;
	//singleton
	private static ModelWorkStationDBImpl1 inst=new ModelWorkStationDBImpl1();
	public static ModelWorkStationDBImpl1 getInstance(){
		return inst;
	}
	private ModelWorkStationDBImpl1() {
		connectionPool = ConnectionPool.getInstance(MvcProperties.dbName);
		init();
//		System.out.println(Workstation.map);
//		this.modelLinkman=modelLinkman;
	}


	public void addViewListener(View viewcustandlink) {
		this.view=viewcustandlink;
	}

	public void fireModelChange(Object obj){
		dirty=true;
		if(view!=null){
			view.processModelChange(obj);
		}
	}


	public void delete(Workstation item) throws Exception {
		//从库中删
//		Connection conn=connectionPool.getConnection();
//		try{
//			Statement stmt=conn.createStatement();
//			String sql="delete from TemConSet where TemConAddrCode="+
//			item.getTemConAddrCode()+" and TemConName="+item.getTemConName();
//			stmt.executeUpdate(sql);
//		}
//		finally{
//			connectionPool.releaseConnection(conn);
//		}
//		this.listTemCon=null;
		//从现表中删
//		this.customers=this.getCustomer();//
//		System.out.println("ModelDBImplTEmCon:delete:"+listOld);
//		this.listOld.remove(item);
////		System.out.println("ModelDBImplTEmCon:delete:"+listOld);
//		this.list.remove(item);
//		//
//		this.fireModelChange(list);
//		
//		//删去Workstation.map
//		List<Workstation> l=Workstation.map.get(item.getTemConAddrCode());
//		l.remove(item);
//		
//		//存入用户日志
//		ModelDBImplUserOperateLog.getInstance().insert(UserOperateLog.TemControolerDelete,1);
	}


	public  static String [] getColumnName(String tableName) {
		String []ss=Workstation.titles;
		return ss;

	}


	public List<Workstation> get(boolean fetch) throws Exception{
		dirty=fetch || list==null;
		return get(cond);
	}
	public synchronized  List<Workstation> get() throws Exception {
		if(listOld!=null)
			return listOld;
		get(null);
		if(this.listOld==null){
			this.listOld=new ArrayList();
		}
//		System.out.println("ModelDBImplTemCon:get:"+listOld);
		return listOld;
	}


	public List<Workstation> get(String cond)throws Exception{
//		if(!dirty && (cond==this.cond || cond!=null && cond.equals(this.cond)))
//			return list;
//		Connection conn=connectionPool.getConnection();
//		ResultSet rs=null;
//		try{
//			Statement stmt=conn.createStatement();
//			String sql="select * from TemConSet ";
//			if(cond!=null && !cond.equals("")){
//				sql+=" where "+cond;
//			}
//			sql+=" order by TemConAddrCode ASC, TemConName ASC";
//			rs=stmt.executeQuery(sql);
//		}
//		finally{
//			connectionPool.releaseConnection(conn);
//		}
//		String s=null;
//		if(list==null)
//			list=new ArrayList();
//		else
//			list.removeAll(list);
//		
//		Workstation tc=null,t=null;
//		Workstation cust=new Workstation();
//		while(rs.next()){
//			cust.setTemConAddr1((s=rs.getString("TemConAddr1"))!=null?s.trim():null);
//			cust.setTemConAddr2((s=rs.getString("TemConAddr2"))!=null?s.trim():null);
//			cust.setTemConAddr3((s=rs.getString("TemConAddr3"))!=null?s.trim():null);
//			cust.setSetAddr((s=rs.getString("setAddr"))!=null?s.trim():null);
//			cust.setTemConAddrCode(rs.getInt("TemConAddrCode"));
//			cust.setTemConName((byte)rs.getInt("TemConName"));
//			cust.setPowers((short)rs.getInt("Powers"));
//			tc=find(cust);
//			if(tc==null){
//				list.add(t=cust.copy());
//				if(listOld==null)
//					listOld=new ArrayList();
//				listOld.add(t);
//			}
//			else{
//				list.add(tc);
//				
//			}
//		}
//		this.dirty=false;
//		this.cond=cond;
//		System.out.println("list="+list);
//		System.out.println(listOld);
//		System.out.println(list);
		if(list==null){
			list=listOld;
		}
		return list;
	}
	public Workstation find(Workstation tc){
		if(this.listOld==null)
			return null;
		for(Workstation t:listOld){
			if(t.equals(tc))
				return t;
		}
		return null;
	}

	public void restore(){
		this.list=this.listOld;
	}

	public int getIndex(Workstation cust, String cond) {
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
	
	public void insert(Workstation cust) throws Exception {
//		if(Workstation.getTemCon(cust.getTemConAddrCode(),cust.getTemConName())!=null){
//			Main.gui.showStatus(cust+"已存在！");
//			return;
//		}
//		System.out.println("insert");
//		System.out.println(this.listOld);
//		System.out.println(this.list);
//		Connection conn=connectionPool.getConnection();
//		String sql="insert into TemConSet (TemConAddr1,TemConAddr2,TemConAddr3,SetAddr,TemConAddrCode,TemConName,Powers) values(?,?,?,?,?,?,?)";
//		PreparedStatement stmt=conn.prepareStatement(sql);
//		
//		stmt.setString(1, cust.getTemConAddr1());//+"','"+
//		stmt.setString(2,cust.getTemConAddr2());//+"','"+
//		stmt.setString(3,cust.getTemConAddr3());//+"',"+
//		stmt.setString(4,cust.getSetAddr());//+"',"+
//		stmt.setInt(5,cust.getTemConAddrCode());//+","+
//		stmt.setInt(6, cust.getTemConName());//+","+
//		stmt.setInt(7, cust.getPowers());//+	")";
//		try{
//			stmt.executeUpdate();
//		} 
//		finally{
//			connectionPool.releaseConnection(conn);
//		}
//		this.list.add(cust);
		this.listTemCon=null;
		this.listOld.add(cust);
		
//		List l=Workstation.map.get(cust.getTemConAddrCode());
//		if(l==null){
//			l=new ArrayList<Workstation>();
//			Workstation.map.put(cust.getTemConAddrCode(), l);
//		}
//		l.add(cust);
//		System.out.println("End of inserting");
//		System.out.println(this.listOld);
//		System.out.println(this.list);
//		System.out.println(l);
		this.fireModelChange(this.list);
	}


	public void update(Workstation cust) throws Exception {
//		Connection conn=connectionPool.getConnection();
//		Statement stmt=conn.createStatement();
//		String sql="update TemConSet set "+
//		" TemConAddr1='"+cust.getTemConAddr1()+
//		"', TemConAddr2='"+cust.getTemConAddr2()+
//		"', TemConAddr3='"+cust.getTemConAddr3()+
//		"', SetAddr='"+cust.getSetAddr()+
//		"',Powers="+cust.getPowers()+
//		" where TemConAddrCode="+cust.getTemConAddrCode()+" and "+
//		"TemConName="+cust.getTemConName();
//		//System.out.println(sql);
//		try{
//			stmt.executeUpdate(sql);
//		}
//		finally{
//			connectionPool.releaseConnection(conn);
//		}
//		for(int i=0;i<listOld.size();i++){
//			Workstation tc=listOld.get(i);
//			if(tc.equals(cust)){
////				listOld.remove(i);
////				listOld.add(i,cust);
//				tc.setTemConAddr1(cust.getTemConAddr1());
//				tc.setTemConAddr2(cust.getTemConAddr2());
//				tc.setTemConAddr3(cust.getTemConAddr3());
//				tc.setSetAddr(cust.getSetAddr());
//				tc.setPowers(cust.getPowers());
//				//更改实时温度数据
//				ModelDBImplHistoryTem.getInstance().updateWrite(tc);
//				this.fireModelChange(list);
//				break;
//			}
//		}
//		
//		//存入用户日志
//		ModelDBImplUserOperateLog.getInstance().insert(UserOperateLog.TemControolerUpdate,1);
		
	}
	

	public static void main(String[] args)throws Exception {
//		ModelLinkman modelLinkman=new ModelLinkmanDBImpl();
//		ModelTemCon model=new ModelDBImplTemCon();

//		System.out.println(model.get());
//		System.out.println(model.toTemConString());
//
//		Workstation tc=new Workstation();
//		tc.setPowers(3000);
//		tc.setSetAddr("客厅");
//		tc.setTemConAddr1("春田小区");
//		tc.setTemConAddr2("21");
//		tc.setTemConAddr3("302");
//		tc.setTemConAddrCode(2332);
//		tc.setTemConName(8);
////		model.insert(tc);
//		System.out.println(model.get());
//		tc.setPowers(4000);
//		model.update(tc);
//		System.out.println(model.get());
	}

//	public Workstation getCustomerById(String id) throws Exception {
//	return this.getCustomerByName(id);
//	}

//	public static String [] getAgents(){
//	String ss[]=null;
//	try{
//	ModelTempCon customerModel=new ModelDBImplTemCon();
//	List<Workstation> customers=customerModel.getCustomer();
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

	public void put(Integer temCode,int num){
//		Workstation con=map.get(temCode);
//		if(con==null){
//		List<Workstation> l=null;
//		l=Workstation.map.get(temCode);
//		if(l!=null  && l.size()==num)
//			return;
//		if(l==null)
//			l=new ArrayList();
//		if(this.list==null)
//			list=new ArrayList();
//		if(this.list.size()==0){
//			try {
//				list=this.get();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		boolean flag=false;
//		for(Workstation tem:list){
//			if(tem.getTemConAddrCode()==temCode){
//				flag=true;
//				tem.setTotal((byte)num);
////				
//				if(!l.contains(tem))
//					l.add(tem);
//				if(l.size()==num)
//					break;
//			}
//			else if(flag){
//				flag=false;
//				break;
//			}	
//		}
//		if(l.size()<num){//容错
//			String s=null;
//			JOptionPane.showMessageDialog(Main.gui, s=temCode+"单元控制箱的数据不正确，请改正！");
//			Workstation.map.remove(temCode);
//			MvcProperties.write(s);
//			return;
//		}
////		System.out.println("ModelDBImplTemCon:"+l);
//		Workstation.map.put(temCode, l);
	}
	/**
	 * 形成TrepretureController.map表，保存单元控制箱信息和端口信息
	 */
	boolean begin=true;
	public void init(){

	
	}
	/**
	 * 	由List数据形成单元控制箱列表
	 */
	public List<String> toTemConString(){
//		if(listTemCon!=null)
//			return listTemCon;
//		if(listOld==null){
//			try {
//				this.get();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				MvcProperties.write(e);
//				return null;
//			}
//		}
//		int n=listOld.size();
//		listTemCon=new ArrayList();
//		for(int i=0;i<n;i++){
//			String s=Integer.toHexString(((Workstation)listOld.get(i)).getTemConAddrCode());
//			if(!listTemCon.contains(s))
//				listTemCon.add(s);
//		}
		return listTemCon;
	}
//	public List<HistoryTem> getHistoryTem(){
//		List<HistoryTem> listHT=new ArrayList();
//		for(Workstation tc:listOld){
//			listHT.add(tc.getHistoryTem());
//		}
////		System.out.println("ModelDBImplTemCon:getHistoryTem:"+listHT);
//		Collections.sort(listHT);
//		return listHT;
//	}
	public void exportExcel(String excelPath)throws Exception{
//		ExcelBeanTemCon eb=new ExcelBeanTemCon();
//		eb.exportExcel(excelPath,list);
		
		
	}
	public List<Workstation> importExcel(String excelPath)throws Exception{
//		ExcelBeanTemCon eb=new ExcelBeanTemCon();
//		List<Workstation> ll=eb.importExcel(excelPath);
//		if(ll==null){
//			return null;
//		}
//		for(int i=0;i<ll.size();i++){
//			this.insert(ll.get(i));
//		}
//		
//		this.fireModelChange(list);
//		//存入用户日志
//		ModelDBImplUserOperateLog.getInstance().insert(UserOperateLog.TemControolerImport,1);
//		return ll;
		return null;
	}
	

}
