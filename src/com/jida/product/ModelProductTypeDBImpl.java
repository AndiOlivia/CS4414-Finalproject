package com.jida.product;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;
import com.jida.product.data.ProductType;

public class ModelProductTypeDBImpl implements ModelProductType {
	private List<ProductType> list;
	private List<String> listTypeNames;
	private ViewProductType view;
	private String cond;
	private boolean dirty=true;
	private static ConnectionPool cp;
	private static ModelProductTypeDBImpl inst;
	
	public static ModelProductTypeDBImpl getInstance(){
		if(inst==null){
			inst=new ModelProductTypeDBImpl();
		}
		return inst;
	}
	private ModelProductTypeDBImpl(){
		cp=ConnectionPool.getInstance(MvcProperties.dbName);
	}
	
	
	public void addViewListener(ViewProductType View) {
		// TODO Auto-generated method stub
		this.view=view;
	}

	public void delete(ProductType pt) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from productType where pt_name=?";
		Connection conn=cp.getConnection();
		try{
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setString(1, pt.getPtName());
			stmt.executeUpdate();
			this.fireModelChange(null);
		}
		finally{
			cp.releaseConnection(conn);
		}
	}

	public List<ProductType> get() throws Exception {
		// TODO Auto-generated method stub
		return get(null);
	}

	public List<ProductType> get(String cond) throws Exception {
		// TODO Auto-generated method stub
		if(!dirty&&(this.cond==cond||this.cond!=null&&this.cond.equals(cond))){
//			System.out.println("list get 1="+list);
			return this.list;
		}
		Connection conn=cp.getConnection();
		ResultSet re=null;
		String sql=String.format("select * from productType %s%s order by ptName",cond==null?"":" where ",cond==null?"":cond);
//		if(cond!=null){
//			sql+=" where "+cond;
//		}
//		sql+=" order by ptName";
		System.out.println("ModelProductTypeDBImpl.get():"+sql);
		try{
			Statement stmt=conn.createStatement();
			re=stmt.executeQuery(sql);
		}
		finally{
			cp.releaseConnection(conn);
		}
		if(list==null){
			list=new ArrayList();
		}
		else{
			list.clear();
		}
		String s=null;
		while(re.next()){
			ProductType pt=new ProductType();
//			create table productType(
//			pt_name char(30) primary key,					--类名称
//			pt_brief char(100),
			pt.setPtName(re.getString("ptName").trim());
			pt.setPtBrief((s=re.getString("ptBrief"))!=null?s.trim():null);
			list.add(pt);
		}
		this.dirty=false;
		this.cond=cond;
//		System.out.println("list get="+list);
		return list;
		
	}
	/**
	 * New 20140422
	 */
	public List<String> getTypeName(){
		try {
			get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.listTypeNames==null){
			listTypeNames=new ArrayList();
		}
		else{
			this.listTypeNames.clear();
		}
		for(ProductType pt:list){
			this.listTypeNames.add(pt.getPtName());
		}
		return this.listTypeNames;
	}

	public ProductType getByindex(int index) {
		// TODO Auto-generated method stub
		if(list==null||list.size()<=index){
			return null;
		}
		return list.get(index);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return this.list==null?0:list.size();
	}

	public int getIndex(ProductType pdt) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(pdt)){
				return i;
			}
		}
		return -1;
	}

	public void insert(ProductType pt) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into productType(ptName,ptBbrief)values(?,?)";
		Connection conn=cp.getConnection();
		try{
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, pt.getPtName());
			stmt.setString(2, pt.getPtBrief());
			stmt.executeUpdate();
		}
		finally{
			cp.releaseConnection(conn);
		}
		list.add(pt);
		this.fireModelChange(list);
	}

	public void update(ProductType pt) throws Exception {
		// TODO Auto-generated method stub
		String sql="update productType set ptBrief=? where ptName=?";
		Connection conn=cp.getConnection();
		try{
			PreparedStatement stmt=conn.prepareStatement(sql); 
			
			stmt.setString(1, pt.getPtBrief());
			stmt.setString(2, pt.getPtName());
			stmt.executeUpdate();
		}
		finally{
			cp.releaseConnection(conn);
		}
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(pt)){
				list.get(i).setPtBrief(pt.getPtBrief());
			}
		}
		this.fireModelChange(list);
	}
	
	public void fireModelChange(Object obj){
		this.dirty=true;
		if(view!=null){
			view.processModelChange(obj);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModelProductType model=new ModelProductTypeDBImpl();
//		ProductType pt=new ProductType();
//		pt.setPtName("学习类");
//		pt.setPtBrief("need more");
//		try {
////			model.insert(pt);
////			model.update(pt);
//			model.delete(pt);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			System.out.println(model.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
