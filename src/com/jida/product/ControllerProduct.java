package com.jida.product;

import com.jida.product.data.Product;



public interface ControllerProduct {
	public void processInsert(Product pro);
	public void processDelete(Product pro);
	public void processUpdate(Product pro);
	public void processExport();

}
