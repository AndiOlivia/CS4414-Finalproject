package com.jida;



public interface Controller <T>{
	public void processInsert(T cust);
	public void processDelete(T cust); 
	public void processUpdate(T cust);
	

}
