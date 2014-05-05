package com.jy.print;

/**
 * <p>Title: Direct Sale Management System</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Jida</p>
 * @author Yang Ying
 * @version 1.0
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class JidaProperties {
		public static String m_contextFile="print.ini";
	  public static int count=1;
	  public static String m_DBDriver="sun.jdbc.odbc.JdbcOdbcDriver";
	  public static String m_DBURL="jdbc:odbc:DirectSale";
	  public static int startYear=2004;
	  public static String title="------"; 
	  
	  public static String m_SQLServerDriverName="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	  public static String m_SQLServerURL="jdbc:microsoft:sqlserver://localhost:1433;databasename=jddb";
	  public static String m_user="sa";
	  public static String m_password="sa";
	  

  public JidaProperties(String contextFile) {
    m_contextFile = contextFile;
  }
  static{
	  try{
		  load();
	  }
	  catch(Exception e){
		  System.out.println("JidaProperties.staticInit:"+e);
	  }
  }
  public static void main(String[] args)  {
//    if (args.length < 1) {
//      System.out.println("Usage:OpenEContext  propertiesFileName");
//      System.exit(0);
//
//    }
//    JidaProperties openEContext = new JidaProperties(args[0]);
   //openEContext.load() ;
   JidaProperties.store();

  }
  
  public static void load() {
    try{
      InputStream fin = new FileInputStream(m_contextFile);
      Properties properties = new Properties();
      properties.load(fin);
      m_DBDriver = properties.getProperty("DBDriver",m_DBDriver);
      m_DBURL = properties.getProperty("DBURL",m_DBURL);
      m_SQLServerDriverName= properties.getProperty("m_SQLServerDriverName",m_SQLServerDriverName);
      m_SQLServerURL = properties.getProperty("m_SQLServerURL",m_SQLServerURL);
      m_user= properties.getProperty("m_user",m_user);
      m_password = properties.getProperty("m_password",m_password);
      String s=properties.getProperty("count");
      if(s==null ||s.equals("") ) count=0;
      else  count = Integer.parseInt(s);
      s=properties.getProperty("title");
    	  
     if(s==null || s.equals("")) 
    	 title="";
     else{
       title=new String (s.getBytes("ISO-8859-1") ) ;;
     }
      fin.close() ;
    }
    catch(IOException e){
      System.out.println("Failto load properties :" + m_contextFile);
    }
  }

  public static void store() {
	  try {
		  OutputStream fout = new FileOutputStream(m_contextFile);
		  Properties properties = new Properties();
		  //properties.store(fout, "");
		  properties.setProperty("DBDriver", m_DBDriver);
		  properties.setProperty("DBURL", m_DBURL);
		  properties.setProperty("count", ""+count);
		  properties.setProperty("title",title) ;
		  properties.setProperty("m_SQLServerDriverName",m_SQLServerDriverName);
		  properties.setProperty("m_SQLServerURL",m_SQLServerURL);
		  properties.setProperty("m_user",m_user);
		  properties.setProperty("m_password",m_password);
		  properties.store(fout,"----") ;

		  fout.close() ;
	  }
	  catch (IOException e) {
		  System.out.println("Fail to Store properties:" + m_contextFile);
	  }
  }
}




