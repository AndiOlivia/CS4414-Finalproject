package com.jida.product;

import java.util.List;


import com.jida.product.data.ProductType;





public interface ModelProductType {
	public List<ProductType> get() throws Exception;
	public List<ProductType> get(String cond)throws Exception;
	public void insert(ProductType pt)throws Exception;
	public void delete(ProductType pt)throws Exception;
	public void update(ProductType pt)throws Exception;
	
	public List<String> getTypeName();
	
	public void addViewListener(ViewProductType View);
	
	public int getCount();
	public ProductType getByindex(int index);
	public int getIndex(ProductType pdt);
}
