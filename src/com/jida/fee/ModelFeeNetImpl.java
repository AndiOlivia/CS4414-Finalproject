package com.jida.fee;

import java.text.DateFormat;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jida.MvcProperties;
import com.jida.client.Client;
import com.jida.client.Main;
import com.jida.fee.data.Fee;
import com.jida.fee.data.FeeDetails;
import com.jida.gui.JFrameGuiSuper;

public class ModelFeeNetImpl implements ModelFee {
	private Client client;
	private List<Fee> list;
	private ViewFee view;
	String cond;
	boolean dirty=true;
	private float total;
	private float size;
	private float energy;
	private List<FeeDetails> listDetails;
	private int totalTime;
	private static ModelFeeNetImpl modelFee;
	
	
	public void reset(){
		this.total=0;
		this.size=0;
		this.energy=0;
		
//		mapTC.clear();
	}
	
	public static ModelFeeNetImpl getInstance(){
		if(modelFee==null){
			modelFee=new ModelFeeNetImpl();
		}
		return modelFee;
	}

	private ModelFeeNetImpl(){
//		this.modelHistoryTem=ModelNetImplHistoryTem.getInstance();
	}
	public static final String CUST="cust";
	public void addViewListener(ViewFee viewcustandlink) {
		// TODO Auto-generated method stub
		this.view=viewcustandlink;
	}
	public void fireModelChange(Object obj){
		dirty=true;
		if(view!=null){
			view.processModelChange(obj);
		}
	}
	
	/**
	 * 根据listDetails细目表，计算费用
	 */
	public List<FeeDetails> get(Fee fee) throws Exception{
		return null;
	}

	/**
	 * 基于细目表，计算指定单元控制箱一天的计费数据
	 */
	public List<Fee> computeFee(int temConAddrCode,int temConName,Date from)throws Exception{
		return null;
	}
	/**
	 * 基于细目表，计算面板上指定的单元控制箱的计费项目,从from到end
	 * 
	 */
	
	public List<Fee> computeFee(Date from,Date end,int temConAddrCode,int temConName)throws Exception{
//		List<Fee> l=new ArrayList();
		if(list==null){
			list=new ArrayList();
		}
		else
			list.clear();
		
		end=MvcProperties.getNextDayBegin(end);
		
		total=0;
		for(Date currDate=from;currDate.getTime()<end.getTime();){
			List<Fee> fee=computeFee(temConAddrCode,temConName,currDate);
			this.list.addAll(fee);
//			for(Fee f:fee){
////				total+=f.getTotal();
//				computeTotal(f);
//			}
			currDate=new Date(currDate.getTime()+24*3600*1000);
		}
		return list;
	}
	public List<Fee> computeFee(Date from)throws Exception{
		return null;
	}

	public void delete(Fee cust) throws Exception {
		// TODO Auto-generated method stub
		client=Client.getInstance();
		CommandDeleteFee comDelete=new CommandDeleteFee(cust);
		Object obj;
		for(int i=0;i<4;i++){
			client.write(comDelete);
			obj=client.read();
			if(obj instanceof CommandDeleteFee){
				System.out.println("ModelNetImplFee:Delete:"+cust);
				this.fireModelChange(null);
				return;
			}
		}
		JFrameGuiSuper.gui.showStatus("远程数据删除请求失败");
//		ModelNetImplUserOperateLog.getInstance().insert(UserOperateLog.TemControolerDelete,1);
	}
	public  static String [] getColumnName(String tableName) {
		String []ss=Fee.titles;
		return ss;

	}
	public void exportExcel(String excelPath) throws Exception {
		// TODO Auto-generated method stub
//		ExcelBeanHistoryTem eb=new ExcelBeanHistoryTem();
//		eb.exportExcelFee(excelPath,list);
//		ModelNetImplUserOperateLog.getInstance().insert(UserOperateLog.TemControolerExport, 1);
	}

	public synchronized List<Fee> get() throws Exception {
		// TODO Auto-generated method stub
		return get((String)null);
	}

	public List<Fee> get(boolean fetch) throws Exception {
		// TODO Auto-generated method stub
		dirty=fetch || list==null;
		return get(cond);
	}

	public List<Fee> get(String cond) throws Exception {
		// TODO Auto-generated method stub
		client=Client.getInstance();
		CommandSearchFee comSearch=new CommandSearchFee(cond);
		Object obj;
		for(int i=0;i<4;i++){
			client.write(comSearch);
			obj=client.read();
			if(obj instanceof CommandSearchFee){
				comSearch=(CommandSearchFee)obj;
				this.list=comSearch.get();
				this.dirty=false;
				this.cond=cond;
				System.out.println("ModelNetImplFee:get(String cond):list:"+list);
				return list;
			}
//			this.dirty=false;
//			this.cond=cond;
//			System.out.println("ModelNetImplFee:get(String cond):list:"+list);
//			return list;
		}
		JFrameGuiSuper.gui.showStatus("远程数据刷新请求失败");
		return list;
	}
	


	public int getCount() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	public int getIndex(Fee cust, String cond) {
		// TODO Auto-generated method stub
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

	public float getTotal() {
		// TODO Auto-generated method stub
		return total;
	}

	public int getTotalTime() {
		// TODO Auto-generated method stub
		return totalTime;
	}

	public void insert(Fee cust) throws Exception {
		// TODO Auto-generated method stub
		client=Client.getInstance();
		CommandInsertFee comInsert=new CommandInsertFee(cust);
		Object obj;
		for(int i=0;i<4;i++){
			client.write(comInsert);
			System.out.println("ModelFeeNetImpl.insert()write:"+comInsert);
			obj=client.read();//read CommandPing
			System.out.println("ModelFeeNetImpl.insert()read:"+obj);
			if(obj instanceof CommandInsertFee){
				comInsert=(CommandInsertFee)obj;
//				this.list=comInsert.getList();
//				this.fireModelChange(null);
//				list.add(cust);
				return;
			}
//			this.fireModelChange(null);
		}
		JFrameGuiSuper.gui.showStatus("远程数据插入请求失败");
	}

	public void update(Fee cust) throws Exception {
		// TODO Auto-generated method stub
//		ModelNetImplUserOperateLog.getInstance().insert(UserOperateLog.TemControolerUpdate,1);
	}
	public void exportExcelTime(String excelPath)throws Exception{
//		ExcelBeanHistoryTem eb=new ExcelBeanHistoryTem();
//		eb.exportExcelTime(excelPath,this.listDetails);
		
		//存入用户日志
//		ModelDBImplUserOperateLog.getInstance().insert(UserOperateLog.FeeDataExport,1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public float getSize() {
		return size;
	}

	public float getEnergy() {
		return energy;
	}
	
//	public void computeTotal(CommandComputeFee fee){
//		this.total=fee.getTotal();
//		this.size=fee.getSize();
//		this.energy=fee.getEnergy();
//	}
//	
//	public void computeTotal(Fee fee){
//		TempretureController tc=fee.getTc();
//		if(tc==null){
//			return;
//		}
//		
//		this.total+=fee.getTotal();
//		this.energy+=fee.getEnergy();
//		if(mapTC.get(tc)==null){
//			this.size+=tc.getSize();
//			mapTC.put(tc, tc);
//		}
////		System.out.println(tc+":￥"+total+","+energy+"KWh,"+size+"m\u00b2");
//	}
	
	//New 20120220
	public List<Fee>  sort(){
		 Collections.sort(this.list);
		 return list;
	}
	//end
	


	public Fee getByIndex(int index){

		if(index<0 || index>=list.size())
			return null;
		return list.get(index);
	}

}
