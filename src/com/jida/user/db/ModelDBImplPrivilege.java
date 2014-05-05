package com.jida.user.db;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;
import com.jida.user.domObject.Privilege;
import com.jida.user.intf.ModelPrivilege;
import com.jida.user.intf.ViewPrivilege;

public class ModelDBImplPrivilege implements ModelPrivilege {
	private List<Privilege> list=new ArrayList();
	private ViewPrivilege view;  
	private ConnectionPool cp=ConnectionPool.getInstance(MvcProperties.dbName);
	private boolean dirty=true;
	private String cond;
	private  static ModelDBImplPrivilege inst; 
	public static ModelDBImplPrivilege getInstance(){
		if(inst==null)
			inst=new ModelDBImplPrivilege();
		return inst;
	}
	private ModelDBImplPrivilege(){
		
	}
	public void addViewListener(ViewPrivilege view) {
		// TODO Auto-generated method stub
		this.view=view;
	}

	
	public void delete(Privilege pri) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from  privilege where privilegeName='"+pri.getPriName()+"'";
		Connection conn=cp.getConnection();
		try{
			Statement stmt=conn.createStatement();
//			stmt.setString(1, pri.getPriName());
//			stmt.setString(2, pri.getPriDesc());
			stmt.executeUpdate(sql);
		}
		finally{
			cp.releaseConnection(conn);
		}
		this.fireModelChange(null);
	}

	
	public List<Privilege> get() throws Exception {
		// TODO Auto-generated method stub
		return get(null);
	}

	
	public List<Privilege> get(String cond) throws Exception {
		// TODO Auto-generated method stub
		if(! dirty && (cond==this.cond || cond!=null && cond.equalsIgnoreCase(this.cond))){
			return this.list;
		}
		
		Connection conn=cp.getConnection();
		ResultSet rs=null;
		try{
			String sql="select * from privilege";
			if(cond!=null && !cond.equals("")){
				sql+=" where "+cond;
			}
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
		}
		finally{
			cp.releaseConnection(conn);
		}
		this.list=new ArrayList();
		while(rs.next()){
			Privilege pri=new Privilege();
			pri.setPriName(rs.getString("privilegename"));
			pri.setPriDesc(rs.getString("privilegedesc"));
			list.add(pri);
		}
		this.dirty=false;
		this.cond =cond;
		return list;
	}

	public void insert(Privilege pri) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into privilege values(?,?)";
		Connection conn=cp.getConnection();
		try{
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, pri.getPriName());
			stmt.setString(2, pri.getPriDesc());
			stmt.executeUpdate();
		}
		finally{
			cp.releaseConnection(conn);
		}
		this.fireModelChange(null);
	}

	
	public void update(Privilege pri) throws Exception {
		// TODO Auto-generated method stub
		String sql="update privilege set privilegeDesc =? where privilegename =?";
		Connection conn=cp.getConnection();
		try{
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, pri.getPriDesc());
			stmt.setString(2, pri.getPriName());
			stmt.executeUpdate();
		}
		finally{
			cp.releaseConnection(conn);
		}
		this.fireModelChange(null);
	}
	protected void fireModelChange(Object obj){
		this.dirty=true;
		if(view!=null){
			view.processModelChange(obj);
		}
	}
	public int getIndex(Privilege pri){
		int n=list.size();
		for(int i=0;i<n;i++){
			if(list.get(i).equals(pri))
				return i;
		}
		return -1;
	}
	public int getCount(){
		return list==null?0:list.size();
	}
	
	public static void main(String ss[])throws Exception{
		ModelPrivilege model=new ModelDBImplPrivilege();
		System.out.println(model.get());
	}

}
