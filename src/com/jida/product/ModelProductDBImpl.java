package com.jida.product;

import java.awt.Color;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//import com.jida.ForceParamManage.gui.PanelForceParam;
//import com.jida.client.Main;
//import com.jida.db.ConnectionPool;
//import com.jida.production.gui.PanelProduction;
//import com.jida.testData.ExcelBeanTestHistory;
//import com.jy.db.ConnectionPool;
import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;
import com.jida.product.data.Product;

public class ModelProductDBImpl implements ModelProduct {
	private ViewProduct view;
	private List<Product> list=new ArrayList();
//	private List<Product> listNew=new ArrayList();
//	private List<Product> oldList=new ArrayList();
	List<Product> listProduct;
	private String cond;
	private boolean dirty=true;
	public static Map<String,List<Product>>mappro=new HashMap();
	private static ConnectionPool connectionPool = null;

//	public static Map<String ,List<KuCunWuZi>> mapKCWZ=null;
//	public static Map<Integer ,List<KuCunWuZi>> mapKF2KCWZ=null;
	
	private static ModelProductDBImpl modelProduct;//=new ModelDBImplKuFang();
	public static ModelProduct getInstance(){
		if (modelProduct==null){
			modelProduct=new ModelProductDBImpl();
		}
		
		return modelProduct;
	}
	private ModelProductDBImpl(){
		connectionPool = ConnectionPool.getInstance(MvcProperties.dbName);
		init();
	}


	public void delete(Product pro) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=connectionPool.getConnection();
		String sql="delete from product where pdtNo='"+
		pro.getPdtNo()+"'";

		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{

			connectionPool.releaseConnection(conn);
		}
		if(listProduct!=null){
			this.listProduct.remove(pro);
		}
		this.list.remove(pro);
		this.fireModelChange(list);


	}


	public List<Product> get() throws Exception {
		// TODO Auto-generated method stub
		return (get(null));
	}


	public Product get(int index) {
		// TODO Auto-generated method stub
		return list==null || index>=list.size()?null:list.get(index);
	}


	public List<Product> get(String cond) throws Exception {
		// TODO Auto-generated method stub
		if(!dirty &&(this.cond==cond||this.cond!=null&&this.cond.equals(cond))){
			return this.list;
		}
		Connection conn=connectionPool.getConnection();
		ResultSet rs=null;
		try{
			Statement stmt=conn.createStatement();
			String sql="select * from product";
			if(cond!=null&&!cond.equals("")){
				sql+=" where "+cond;
			}
			sql+=" order by pdtType ASC,pdtName ASC";
			rs=stmt.executeQuery(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		String s=null;
//		if(list==null)
			list=new ArrayList();
//		else
//			list.removeAll(list);

		Product pro=null,t=null;
		while(rs.next()){
			Product pd=new Product();
			pd.setPdtNo(rs.getString("pdtNo"));
			pd.setPdtName(rs.getString("pdtName").trim());
			pd.setPdtType(rs.getString("pdtType"));
			pd.setPdtPrice(rs.getFloat("pdtPrice"));
			pd.setPdtFactory(rs.getString("pdtFactory"));
			pd.setPdtTel(rs.getString("pdtTel"));
			pd.setPdtAddr(rs.getString("pdtAddr"));
			pd.setPdtLinkMan(rs.getString("pdtLinkMan"));
			pd.setPdtComment(rs.getString("pdtComment"));
//			pd.setT1((s=rs.getString("t1"))==null?null:s.trim());
//			pd.setT2((s=rs.getString("t2"))==null?null:s.trim());
//			pd.setT3((s=rs.getString("t3"))==null?null:s.trim());
//			pd.setT4((s=rs.getString("t4"))==null?null:s.trim());
//			pd.setT5((s=rs.getString("t5"))==null?null:s.trim());
			
			list.add(pd);

			
		}
		this.dirty=false;
		this.cond=cond;

		return list;
	}
	
	public Product getById(String id)throws Exception{
		Connection conn=connectionPool.getConnection();
		ResultSet rs=null;
		try{
			Statement stmt=conn.createStatement();
			String sql="select * from product";
//			if(cond!=null&&!cond.equals("")){
				sql+=" where pdtId='"+id+"'";
//			}
//			sql+=" order by pdtType ASC";
			rs=stmt.executeQuery(sql);
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		String s=null;
//		if(list==null)
			list=new ArrayList();
//		else
//			list.removeAll(list);

		Product pro=null,t=null;
		if(rs.next()){
			Product pd=new Product();
			pd.setPdtNo(rs.getString("pdtNo"));
			pd.setPdtName(rs.getString("pdtName").trim());
			pd.setPdtType(rs.getString("pdtType"));
			pd.setPdtPrice(rs.getFloat("pdtPrice"));
			pd.setPdtFactory(rs.getString("pdtFactory"));
			pd.setPdtTel(rs.getString("pdtTel"));
			pd.setPdtAddr(rs.getString("pdtAddr"));
			pd.setPdtLinkMan(rs.getString("pdtLinkMan"));
			pd.setPdtComment(rs.getString("pdtComment"));
//			list.add(pd);

//			this.dirty=false;
//			this.cond=cond;
			return pd;
		}	
		return null;
	}

	
	public List<Product> get(boolean fetch) throws Exception {
		dirty=fetch || list==null;
		return get(cond);
	}


	public Product getByIndex(int index) {
		// TODO Auto-generated method stub
		if(index<0 || index>=list.size())
			return null;
		return list.get(index);
	}

	public Product getByID(int ID) throws Exception {
		// TODO Auto-generated method stub
		String oldCond=this.cond;
		List oldList=this.list;
		this.list=new ArrayList();
		
		StringBuffer cond=new StringBuffer("pdtId=");
		cond.append(ID);
		get(cond.toString());
		if(list.size()<1){
			return null;
		}
		Product pro=list.get(0);
		
		this.list=oldList;
		this.cond=oldCond;
		
		return pro;
	}


	public int getIndex(Product pro, String cond) {
		// TODO Auto-generated method stub
		
			try {
				list=this.get(cond);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//S2
		int n=this.list.size();
		for(int i=0;i<n;i++){
			if(pro.equals(this.list.get(i)))
				return i;
		}
		return -1;
	}


	public void insert(Product pro) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into  product(pdtNo,pdtName,pdtType,pdtPrice,pdtFactory,pdtTel,pdtAddr,pdtLinkMan,pdtComment) VALUES(?,?,?,?,?,?,?,?,?)";
		Connection conn=connectionPool.getConnection();
		try{
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, pro.getPdtNo());
			stmt.setString(2, pro.getPdtName());
			stmt.setString(3, pro.getPdtType());
			stmt.setFloat(4, pro.getPdtPrice());
			stmt.setString(5, pro.getPdtFactory());
			stmt.setString(6, pro.getPdtTel());
			stmt.setString(7,pro.getPdtAddr());
			stmt.setString(8, pro.getPdtLinkMan());
			stmt.setString(9, pro.getPdtComment());
			stmt.executeUpdate();
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		this.list.add(pro);
		if(this.listProduct!=null){
			this.listProduct.add(pro);
		}
//		this.listOld.add(cust);
		this.fireModelChange(null); 

	}


	public List<Product> toProductString() {
		// TODO Auto-generated method stub
		if(listProduct!=null)
			return listProduct;
		try {
			listProduct=get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			listProduct=new ArrayList();
		}
	
		return listProduct;
	}
	public void init(){
		if(this.mappro==null){
			try {
				this.toProductString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


	public void update(Product pro) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=connectionPool.getConnection();
		String sql="update Product set pdtName=?,pdtType=?,pdtPrice=?,pdtFactory=?,pdtTel=?,pdtAddr=?,pdtLinkMan=?,pdtComment=? where pdtNo=?";//"update set Product(pdtID,pdtName,pdtType,pdtChang,pdtR1,pdtR2,pdtR3,pdtColor,pdtWeight,t1,t2,t3,t4,t5) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, pro.getPdtName());
			stmt.setString(2, pro.getPdtType());
			stmt.setFloat(3, pro.getPdtPrice());
			stmt.setString(4, pro.getPdtFactory());
			stmt.setString(5, pro.getPdtTel());
			stmt.setString(6,pro.getPdtAddr());
			stmt.setString(7, pro.getPdtLinkMan());
			stmt.setString(8, pro.getPdtComment());
			stmt.setString(9, pro.getPdtNo());
//			stmt.setString(10, pro.getT1());
//			stmt.setString(11, pro.getT2());
//			stmt.setString(12,pro.getT3());
//			stmt.setString(13, pro.getT4());
//			stmt.setString(14, pro.getT5());
			stmt.executeUpdate();
		}
		finally{
			connectionPool.releaseConnection(conn);
		}
		this.fireModelChange(null);
		//		

	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ModelProduct model=new ModelProductDBImpl();
//		System.out.println(model.loadKCWZ());
//		Product kf=new Product();
//		kf.setID("22222222");
//		kf.setName("aaaaaaaaaaa");
//		kf.setType("bbbbb");
//		kf.setChang(20);
//		kf.setR1(30);
//		kf.setColor("");	
//		model.insert(kf);
//		System.out.println(model.get(null));
//		kf.setPdtName("abababa");
//		model.update(kf);
		System.out.println(model.get(null));
//		model.delete(kf);
//		System.out.println(model.get());
//		System.out.println(model.getByKFID(6));
//		System.out.println(model.get());

	}
	public void addViewListener(ViewProduct view){
		this.view=view;
	}
	public void fireModelChange(Object obj){
		this.dirty=true;
		if(view!=null){
			view.processModelChange(obj);
			
			//将生产面板中产品项改变
//			((PanelProduction)Main.gui.getPanel(PanelProduction.name)).setProducts(listProduct);
//			((PanelForceParam)Main.gui.getPanel(PanelForceParam.name)).setProducts(listProduct);
		}
	}
	public void exportExcel(String path)throws Exception{
		ExcelProduct eb=new ExcelProduct();
		eb.exportExcel(path,list);
	}

}
