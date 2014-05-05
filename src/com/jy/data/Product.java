package com.jy.data;

public class Product{
//	private String id;
	public static String []titles= { 
		"产品名称", "等级", "类型", 
		"单位",
//		"标准单价","1级单价",
//		"2级单价","3级单价",
		"包装净重", 
		"备注" };
	public static String []fields={
		"product_name","product_class","product_type",
		"product_unit",
//		"product_unitPrice","product_unitPrice1",
//		"product_unitPrice2","product_unitPrice3",
		"product_netWeight",
		"product_remark"
	};
	
	public static String[] productClasses=new String[]{
				"标准等","红条一级","红条二级","红条三级",
				"白条一级","白条二级","白条三级","白条四级",
				"白条五级","白条六级","白条七级","白条八级",
				"红条四级","白条九级","红条五级","红条六级",
				
				};
	public static String [] productTypes=new String[]{"猪肉","副品","下货"};
	public static String [] inputForbidden={""};
	private String name;
	private String unit;
	private byte productType;
	private byte productClass;		
	private String unitPrice;
	private String unitPrice1;
	private String unitPrice2;
	private String unitPrice3;
	private String netWeight="0";
	private String Remark;
	
	public static int getTypeInt(String s){
		if(s.length()==1 && Character.isDigit(s.charAt(0)))
			return s.charAt(0)-'0';
		for(int i=0;i<productTypes.length;i++){
			if(productTypes[i].equals(s))
				return i;
		}
		return -1;
	}
	
	public static int getClassInt(String s){
		if(s.length()==1 && Character.isDigit(s.charAt(0)))
			return s.charAt(0)-'0';
		
		for(int i=0;i<productClasses.length;i++){
			if(productClasses[i].equals(s))
				return i;
		}
		return 0;
	}
	public boolean equals(Object obj){
		if(obj instanceof Product){
			return name.equals(((Product)obj).name) && productClass==((Product)obj).productClass;
		}
		return false;
	}
	public int hashCode(){
		return this.name.hashCode()+this.productClass;
	}
	public String getClassString(){
		if(productClass>=productClasses.length)
			return "Unknown-"+productClass;
		return this.productClasses[productClass];
	}
	public void setProductClassString(String str){
		for(int i=0;i<this.productClasses.length;i++){
			if(this.productClasses[i].equals(str)){
				this.productClass=(byte)i;
			}
		}
	}
	public void setProductTypeString(String str){
		for(int i=0;i<this.productTypes.length;i++){
			if(this.productTypes[i].equals(str)){
				this.productType=(byte)i;
			}
		}
	}
	public byte getProductClass(){
		return this.productClass;
	}
	public void setProductClass(byte productClass){
		if(productClass>=this.productClasses.length)
			this.productClass=0;
		else this.productClass=productClass;
	}
	public String toString(){
		return "Product: "+this.name+"("+productClass+")";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public static String[] getProductTypes() {
		return productTypes;
	}
	public static void setProductTypes(String[] productTypes) {
		Product.productTypes = productTypes;
	}
	public byte getProductType() {
		return productType;
	}
	public void setProductType(byte productType) {
		this.productType = productType;
	}
	public String getProductTypeString() {
		return this.productTypes[productType];
	}
	public String getUnitPrice1() {
		return unitPrice1;
	}
	public void setUnitPrice1(String unitPrice1) {
		this.unitPrice1 = unitPrice1;
	}
	public String getUnitPrice2() {
		return unitPrice2;
	}
	public void setUnitPrice2(String unitPrice2) {
		this.unitPrice2 = unitPrice2;
	}
	public String getUnitPrice3() {
		return unitPrice3;
	}
	public void setUnitPrice3(String unitPrice3) {
		this.unitPrice3 = unitPrice3;
	}
	public String getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}
	public void setUnitPrice(String price,int grade){
		switch(grade){
		case 0: this.unitPrice=price;
		case 1: this.unitPrice1=price;
		case 2: this.unitPrice2=price;
		case 3: this.unitPrice3=price;
		}
	}
	public String getUnitPrice(int grade){
		String ss[]={this.unitPrice,this.unitPrice1,this.unitPrice2,this.unitPrice3};
		return ss[grade];
	}
	public static boolean forbidden(String s){
		if(inputForbidden==null){
			return false;
		}
		for(String ss:inputForbidden){
			if(ss!=null && ss.equals(s)){
				return true;
			}
		}
		return false;
	}
}
