package com.jida.gui;

public class ItemColumnState {
	private String strColumn;
	private boolean visible;
	private boolean enabled;
	private int no;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public ItemColumnState(String strColumn,boolean visible,boolean enabled,int i){
		this.strColumn=strColumn;
		this.visible=visible;
		this.enabled=enabled;
		this.no=i;
	}
	public String toString(){
		return strColumn+":"+visible+" "+enabled+","+no;
	}
	public String getStrColumn() {
		return strColumn;
	}
	public void setStrColumn(String strColumn) {
		this.strColumn = strColumn;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public static void setNos(ItemColumnState [] ics){
		int i=0;
		for(ItemColumnState ic:ics){
			if(ic.isVisible()){
				ic.setNo(i++);
			}
			else
				ic.setNo(-1);
//			System.out.println(ic);
		}
	}

	
}
