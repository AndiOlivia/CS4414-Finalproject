package com.jida.server;

import java.util.List;


import com.jida.View;
import com.jida.server.data.Workstation;

//import com.jy.data.Workstation;

public interface ModelWorkstation1 {
	public List<Workstation> get() throws Exception;
	public List<Workstation> get(boolean fetch) throws Exception;
	public List<Workstation> get(String cond) throws Exception;
	public void insert(Workstation cust)throws Exception;
	public void delete(Workstation cust)throws Exception;
	public void update(Workstation cust)throws Exception;
	public int getIndex(Workstation cust,String cond);
	public List<String> toTemConString();
	public int getCount();
	public void restore();
	public void exportExcel(String excelPath)throws Exception;
	public List<Workstation> importExcel(String excelPath)throws Exception;
	
	public void addViewListener(View viewcustandlink);
	
//	public boolean validCustomer(String customer,String customerFinal)throws Exception;
}
