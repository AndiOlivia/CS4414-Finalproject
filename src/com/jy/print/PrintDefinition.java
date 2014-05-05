package com.jy.print;


import java.awt.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.JDSoftUtil.db.ConnectionPool;
import com.jida.MvcProperties;

//import com.jy.db.ConnectionPool;
public class PrintDefinition {
  public String name;
  public int no;
  public int x,y,width,height;
  public String content="This is to testq ";
  public String font="Roman";
  public int style=Font.PLAIN;
  public boolean center=true;
  public int size=15;

  public boolean focus=false;
  private static PrintDefinition old;
  public PrintDefinition() {
  }
  public PrintDefinition(String name,int no,int x,int y,int width,int height,String font,int style,boolean center,int size) {
    this.name=name;
    this.no=no;
    this.x=x;
    this.y=y;
    this.width=width;
    this.height=height;
    this.font=font;
    this.size=size;
    this.style=style;
    this.center=center;

  }
  public static void main(String[] args) {
    PrintDefinition printDefinition1 = new PrintDefinition();
  }
  public String toString(){
    return name+" "+no+"("+x+","+y+","+width+","+height+")"+content+" size:"+size;
  }
  public boolean equals(Object obj){
    if(obj instanceof PrintDefinition){
      PrintDefinition pd=(PrintDefinition)obj;
      return name.equals(pd.name) && no==pd.no;
    }
    return false;
  }
  public void draw(Graphics g){
    Font f=new Font(font,style,size);
    g.setFont(f);
    FontMetrics fm=g.getFontMetrics();
    if (content == null)
    	content = "";
    int w=fm.stringWidth(content);
    int h=fm.getHeight()-fm.getLeading();
    int x0=center?x+(width-w)/2:x;
    int y0=center?y+(height+h)/2-fm.getDescent():y+height;
    g.drawString(content,x0,y0);
  }
  public void draw(Graphics g,boolean focus){
    Font f=new Font(font,style,size);
    g.setFont(f);
    FontMetrics fm=g.getFontMetrics();
    if (content == null)
    	content = "";
    int w=fm.stringWidth(content);
    int h=fm.getHeight()-fm.getLeading();
    int x0=center?x+(width-w)/2:x;
    int y0=center?y+(height+h)/2-fm.getDescent():y+height;
    if(focus){
      if(this.focus){
        g.setColor(Color.red);
        g.drawRect(x, y, width, height);
      }
      g.setColor(Color.yellow);
    }
    g.drawRect(x0,y0-h+fm.getDescent(),w,h);
    g.setColor(Color.BLACK);
    g.drawString(content, x0, y0);
  }
  public void setFocus(){
    if(old!=null)
      old.focus=false;
    this.focus=true;
    old=this;
  }
  public static java.util.List<PrintDefinition> getPrintDefinitions(String name) throws Exception {
		String sql = "select * from printDefinition where name ='"+name+"'";
		ConnectionPool pool=ConnectionPool.getInstance(MvcProperties.dbName);
		Connection conn=pool.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		pool.releaseConnection(conn);
		
		java.util.List<PrintDefinition> list = new ArrayList<PrintDefinition>();
		while (rs.next()) {
			PrintDefinition pd = new PrintDefinition(rs.getString("name"),
					rs.getInt("no"), rs.getInt("x"), rs.getInt("y"), 
					rs.getInt("width"), rs.getInt("height"), rs.getString("font"), 
					rs.getInt("style"),	new Boolean(rs.getString("center")), rs.getInt("fsize"));
			list.add(pd);
		}
		return list;
	}

}
