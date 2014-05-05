package com.jida;


public interface View <T>{
	public void processModelChange(Object obj); 
	public void addControllerListener(Controller<T> con);
}
 