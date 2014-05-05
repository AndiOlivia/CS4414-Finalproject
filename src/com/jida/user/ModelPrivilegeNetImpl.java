package com.jida.user;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.jida.center.Client;
import com.jida.client.Client;
import com.jida.server.Command;
import com.jida.user.db.ModelDBImplPrivilege;
import com.jida.user.domObject.Privilege;
import com.jida.user.intf.ModelPrivilege;
import com.jida.user.intf.ViewPrivilege;

public class ModelPrivilegeNetImpl implements ModelPrivilege {
	private List<Privilege> list=new ArrayList();
	private ViewPrivilege view;  
//	private ConnectionPool cp=ConnectionPool.getInstance();
	private boolean dirty=true;
	private String cond;
	private  static ModelPrivilegeNetImpl inst; 
	public static ModelPrivilegeNetImpl getInstance(){
		if(inst==null)
			inst=new ModelPrivilegeNetImpl();
		return inst;
	}
	private ModelPrivilegeNetImpl(){
		
	}
	public void addViewListener(ViewPrivilege view) {
		// TODO Auto-generated method stub
		this.view=view;
	}

	
	public void delete(Privilege pri) throws Exception {
		// TODO Auto-generated method stub
		CommandUpdatePrivilege com=new CommandUpdatePrivilege(AuthModel.getInstance().getUser(),pri);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			dirty=true;
			list=this.get(cond);
			this.fireModelChange(list);
			return ;
		}
		throw new Exception("Delete Customer failed..."+list);
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
		CommandGetPrivilege com=new CommandGetPrivilege(AuthModel.getInstance().getUser(),cond);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			dirty=true;
			list=((CommandGetPrivilege)obj).getList();
			
			return  list;
		}
		
		
		this.dirty=false;
		this.cond =cond;
		return list;
	}

	public void insert(Privilege pri) throws Exception {
		// TODO Auto-generated method stub
		CommandUpdatePrivilege com=new CommandUpdatePrivilege(AuthModel.getInstance().getUser(),pri);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			dirty=true;
			list=this.get(cond);
			this.fireModelChange(list);
			return ;
		}
		throw new Exception("Delete Customer failed..."+list);
	}

	
	public void update(Privilege pri) throws Exception {
		// TODO Auto-generated method stub
		CommandUpdatePrivilege com=new CommandUpdatePrivilege(AuthModel.getInstance().getUser(),pri);
		Client.getInstance().write(com);
		Object obj=Client.getInstance().read();
		if(obj instanceof Command){
			dirty=true;
			list=this.get(cond);
			this.fireModelChange(list);
			return ;
		}
		throw new Exception("Delete privilege failed..."+list);
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
		ModelPrivilege model=new ModelPrivilegeNetImpl();
		System.out.println(model.get());
	}

}
