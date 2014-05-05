package com.jida.product;

import java.util.List;


import com.jida.product.data.Product;




public interface ModelProduct {
	public List<Product> get() throws Exception;
	public void insert(Product pro)throws Exception;
	public void delete(Product pro)throws Exception;
	public void update(Product pro)throws Exception;
	
	public Product get(int index);
	public List<Product> toProductString();
	public int getIndex(Product pd, String cond);
	
	public List<Product> get(String cond)throws Exception;
	public Product getById(String id)throws Exception;
	
	public void addViewListener(ViewProduct view);
	public Product getByIndex(int index);
	public List<Product> get(boolean fetch) throws Exception;
	public Product getByID(int ID)throws Exception;
	
	public void exportExcel(String path)throws Exception;

}
