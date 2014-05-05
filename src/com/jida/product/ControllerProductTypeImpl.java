package com.jida.product;

import com.jida.product.data.ProductType;




public class ControllerProductTypeImpl implements ControllerProductType {
	private ModelProductType model;
	private ViewProductType view;
	
	public ControllerProductTypeImpl(ModelProductType model,ViewProductType view){
		this.model=model;
		this.view=view;
		this.view.addControllerListener(this);
	}
	public void delete(ProductType pt) {
		// TODO Auto-generated method stub
		try {
			model.delete(pt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(ProductType pt) {
		// TODO Auto-generated method stub
		try {
			model.insert(pt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(ProductType pt) {
		// TODO Auto-generated method stub
		try {
			model.update(pt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
