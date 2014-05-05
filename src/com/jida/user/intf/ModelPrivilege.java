package com.jida.user.intf;

import java.util.List;

import com.jida.user.domObject.Privilege;

//import com.jy.client.user.domObject.Privilege;
//import com.jy.client.user.domObject.ViewPrivilege;

public interface ModelPrivilege {
	public void insert(Privilege pri)throws Exception;
	public void delete(Privilege pri)throws Exception;
	public void update(Privilege pri)throws Exception;
	public List<Privilege> get()throws Exception;
	public List<Privilege> get(String cond)throws Exception;
	public int getIndex(Privilege pri);
	public int getCount();
	
	public void addViewListener(ViewPrivilege view);
}
