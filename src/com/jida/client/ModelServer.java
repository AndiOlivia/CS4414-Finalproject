package com.jida.client;

import java.sql.Connection;


import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;
import com.jida.fee.ModelFeeDBImpl;
import com.jida.fee.ModelFee;

public class ModelServer {
	private ConnectionPool connectionPool=ConnectionPool.getInstance(MvcProperties.dbName);
	
	public Connection connectionDB()throws Exception{
		return connectionPool.getConnection();
	}
	public void releaseConnection(Connection conn){
		connectionPool.releaseConnection(conn);
	}
//	public void fireModelChangeTemCon(Object obj){
//		dirty=true;
//		if(viewTemCon!=null){
//			viewTemCon.processModelChange(obj);
//		}
//	}
//	protected void fireModelChangeOutputTime(Object obj){
//		if(viewOutputTime!=null){
//			viewOutputTime.processModelChange(obj);
//		}
//	}
//	protected void fireModelChangePlanTask(Object obj){
//		if(viewPlanTask!=null){
//			viewPlanTask.processModelChange(obj);
//		}
//	}
	
	public ModelFee getModelFee(){
		ModelFee model=(ModelFeeDBImpl)Main.models.get("Fee");
		return model;
	}
	
}
