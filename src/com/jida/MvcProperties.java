package com.jida;

import java.awt.Color;




import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
//import java.util.logging.
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//import print.ConnectionPool;


import com.JDSoftUtil.db.ConnectionPool;
import com.JDSoftUtil.db.JDatabase; 
import com.jida.client.Main; 
import com.jida.gui.ItemColumnState;
import com.jida.gui.JFrameGuiSuper;
import com.jida.util.ToolKit;

public class MvcProperties {
	static StringBuilder sb=new StringBuilder();
	public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdfTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static Logger log=Logger.getLogger(MvcProperties.class);
	//New 20130527 功能定制
	public static int customFunction=0xf;
	public static int  customElectricitryMeasure=0x1;	//电能表
	public static int  customUserOperateLog=0x2;		//日志查询
	public static int  customFee=0x4;					//计费管理
	public static int  customChart=0x8;					//报表分析
	
	public static Color colors[]={new Color(255,204,250),new Color(196,255,237)};
	public static String host="PERSONAL EXPENSE MANAGEMENT SYSTEM";
	public static String dbDriverName="com.mysql.jdbc.Driver";//"net.sourceforge.jtds.jdbc.Driver";//"com.microsoft.jdbc.sqlserver.SQLServerDriver";
	public static String url="jdbc:mysql://localhost:3306/homeManagerDB";//"jdbc:jtds:sqlserver://127.0.0.1:1433;databasename=changtuDB";//"jdbc:microsoft:sqlserver://192.168.21.101:1433;databasename=changtuDB";
	public static String user="root";//"sa";
	public static String password="root";//"sa";
	public static String dbName="HMDB";
	public static int maxConn=30;
	
	public static String path="mvc.ini";
	public static String pathBackup="xinyuanDBBackup.sql";
	public static String pathMySQL="C:\\Program Files\\MySQL\\MySQL Server 5.1";
	public static String hostName="192.168.21.150";//
	public static String hostIP;//
	public static int port=5005;
	public static String province="res/province.ini";
	static String portSetting="portSetting.ini";
	
//	public static String country="country.ini";
	public static int directivePriority;
	public static Map<String,String> map;
	public static String position="position.ini"; //安装位置文件,如厨房、客厅等
	
	
	
	public static int regitser=1;
	public static int message=2;
	public static int groupMessage=3;
	public static int login=4;
	public static int updateFriend=5;
	public static int sendSucess=6;
//	public static String path="mvc0919.properties";
	public static String path1="mvcDate.properties";
//	public static String hostname="127.0.0.1";
//	public static int MAXROWS	=3;
//	public static int levels=11; 
//	public static String date="20081225";
//	public static String filepath1="111.txt";
//	public static String filepath2="222.txt";
	public static int inBaseDaysSaved=15;
	public static int BaseDaysSaved=15;

	public static int btSpeed=9600;
	public static int parity=0;
	public static int dataBits=8;
	public static int stopBit=1;
		
	public static float fees[]={0.3f,1.0f,1.2f};
//	public static float feeNormal=1.0f;
//	public static float feeLow=0.3f;
//	public  static boolean inOutBalance=false;
	
	public static boolean printSaleMiniAuto=false;//自动打印小票
	public static boolean printSaleMiniVisible=false;//打印小票时可视
	
	public static int height=262;//打印纸大小
	public static int width=490;
	public static int top=20;
	public static int left=20;
	public static int height2=786;//打印纸大小
	public static int width2=490;
	public static int top2=15;
	public static int left2=36;
	public static int A4Width=595;//(int)(21*72/2.54);
	public static int A4Height=842;//(int)(29.7*72/2.54);
	public static int A4Left=15;//(int)(21*72/2.54);
	public static int A4Top=15;//(int)(29.7*72/2.54);
	
	
//	public static String classFile="classes.txt";
//	public static String inputForbiddenFile="xh.txt";
	
	public static String imagePath="images/login.jpg";
	public static String imageSplash="images/splash.jpg";
	public static String iconPath="images/GLASS15.png";
	
	public static int lineThick=3;
	
//	public static String DN="";//新加
	
	public static ImageIcon imageIconInsert=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/insert.png"));
	public static ImageIcon imageIconDelete=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/delete.png"));
	public static ImageIcon imageIconUpdate=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/update.png"));
	public static ImageIcon imageIconSearch=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/search.png"));
	public static ImageIcon imageIconRefresh=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/refresh.png"));
	public static ImageIcon imageIconImport=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/import.png"));
	public static ImageIcon imageIconExport=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/export.png"));
	public static ImageIcon imageIconSetting=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/configure.gif"));
	public static ImageIcon imageIconSet=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/setting.png"));
	public static ImageIcon imageIconInquery=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/inquery.png"));
	public static ImageIcon imageIconCopy=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/copy.png"));
	public static ImageIcon imageIconPaste=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/paste.png"));
	public static ImageIcon imageIconHSKZQ=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/hskzq.png"));
	public static ImageIcon imageIconCompute=new ImageIcon(Toolkit.getDefaultToolkit().getImage("images/compute.png"));
//	public static FileOutputStream logOutputStream;
	
//	public static Color color1=new Color(255,204,250),color2=new Color(196,255,237);
	public static short refreshLapse=6000;
	public static int checkLapse=60000;
	public static int netRefreshLapse=180000;
	public static long lapseLogin=600000;
	public static int lapseMonitor=30000;
	public static long timePerDirective=1500;//指令检查线程每指令执行的时间间隔
	public static long timePerCheck=2000L;//retry线程执行时间间隔，
	
	//New 20130126 by YY
	public static long lapseElectricityMeasure=5L*60*1000;//电能表显示间隔
	public static String timeElectricityMeasure="07:00:00";//每日记电能表数据时刻
	public static float ratioElectricityMeasure=3000;//New 20131222 电能表的最大变频比
	
	public static short powerDefault=1800;
	
	public static int temConNum=16;//一条B4指令中所含的温控器数据的数目
	
	//New20121218 for SR4000 48带载
	public static byte TemConMaxNum=48;

	//New20111108 by Brandi for GPRS
	public static int CommunicationMethod=0;	//0:串口通讯 1：GPRS 通讯
	public static short listeningPort=7528;		//服务器侦听端口号
	
	public static String log4jPropertiesFile="log4jGF.properties";
	public static String pathLog="log";
	
	public static int lock=1;
	
	//end
	static{		
//			boolean f1=false,f2=false,f3=false;
			try {	
				MvcProperties.initLog(log4jPropertiesFile);
//				f1=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			load();
			
			initDB();
//			write("日志初始化成功、环境参数加载成功！");
	}
	
	public static void initDB(){
		JDatabase db=new JDatabase(MvcProperties.dbName,MvcProperties.dbDriverName,MvcProperties.url,MvcProperties.user,MvcProperties.password,maxConn);
//		System.out.println(db.getConnectionPool());
//		System.out.println(ConnectionPool.getInstance(MvcProperties.dbName));
//		System.out.println(ConnectionPool.getInstance("jida"));
//		System.out.println(db.getName());
//		System.out.println(JDatabase.Databases);
//		System.out.println(JDatabase.Databases.get(dbName));
//		ConnectionPool cp = ConnectionPool.getInstance(db.getName());
//		System.out.println(cp == null);
	}
	/**
	 * 日志操作
	 * @param obj
	 */
	
	public static void toLog(Object obj){
//		try {
//			logOutputStream.write(obj.toString().getBytes());
			log.debug(obj);
	}
	public static void initLog(String path)throws Exception{
		if(path!=null){
			PropertyConfigurator.configure(path);
		}
		else{
			System.out.println("log4j 配置文件不存在，将影响日志的输出:"+path);
		}
	}
	
	public static final int INFO=2;
	public static final int DEBUG=1;
	public static final int WARN=3;
	public static final int ERROR=4;
	public static final int FATAL=5;
	public  static void write(int level,Object ... obj){
		if(obj==null)
			return ;
		for(int i=0;i<obj.length;i++){
			Object o=obj[i];
			if(o!=null)
				sb.append(o.toString());
			if(i<obj.length-1){
				sb.append(", ");
			}
		}
		//			sb.append("\r\n");

		Logger logger=Logger.getLogger(MvcProperties.class);
		switch(level){
		case INFO:
			logger.info(sb);
			break;
		case DEBUG:
			logger.debug(sb);
			break;
		case WARN:
			logger.warn(sb);
			break;
		case ERROR:
			logger.error(sb);
			break;
		case FATAL:
			logger.fatal(sb);
			break;
		}
	}
	
//	public  static void write(Object ... obj){
//		if(obj==null)
//			return ;
//		for(int i=0;i<obj.length;i++){
//			Object o=obj[i];
//			if(o!=null)
//				sb.append(o.toString());
//			if(i<obj.length-1){
//				sb.append(", ");
//			}
//		}
//		//			sb.append("\r\n");
//
//		Logger logger=Logger.getLogger(MvcProperties.class);
//		logger.info(sb);
//
//	}
	
	public static void store(){
		Properties prop=new Properties();
		//New20111108 by Brandi for GPRS
		prop.setProperty("CommunicationMethod", Integer.toString(CommunicationMethod));
		prop.setProperty("listeningPort", Short.toString(listeningPort));
		//end
		prop.setProperty("dbDriverName", dbDriverName);
		prop.setProperty("url", url);
		prop.setProperty("user", user);
		prop.setProperty("password", password);
		prop.setProperty("hostName", hostName);//新加
		prop.setProperty("port", Integer.toString(port));
//		prop.setProperty("netRefreshLapse", Integer.toString(netRefreshLapse));//New20110321
		prop.setProperty("refreshLapse", Integer.toString(refreshLapse));//New20110905
		prop.setProperty("lapseLogin", Long.toString(lapseLogin));//New 20110917
		
		
//		prop.setProperty("inOutBalance", Boolean.toString(inOutBalance));		
		
		prop.setProperty("printSaleMiniAuto",Boolean.toString(printSaleMiniAuto));
		prop.setProperty("printSaleMiniVisible",Boolean.toString(printSaleMiniVisible));
		prop.setProperty("left", Integer.toString(left));
		prop.setProperty("top", Integer.toString(top));
		prop.setProperty("width", Integer.toString(width));
		prop.setProperty("height", Integer.toString(height));
		prop.setProperty("width2", Integer.toString(width));
		prop.setProperty("height2", Integer.toString((int)(height2)));
		prop.setProperty("left2", Integer.toString(left2));
		prop.setProperty("top2", Integer.toString(top2));
		
		prop.setProperty("cFunction", Integer.toString(MvcProperties.customFunction));
		
		//insert 20120223 for lock 
		prop.setProperty("lock", Integer.toString(lock));
		//end
		
		//2010-8-14 暂不保存，因为编码问题:用FileReader和FileWriter解决
//		try {
//		imagePath=new String(imagePath.getBytes("GB2312"));
		prop.setProperty("imagePath", imagePath);
		prop.setProperty("imageSplash", imageSplash);
		prop.setProperty("iconPath", iconPath);
		
		prop.setProperty("colors[0]",getColors(colors[0]));
		prop.setProperty("colors[1]", getColors(colors[1]));
		
		prop.setProperty("fees",	getFees(fees));
		
//		} catch (UnsupportedEncodingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		}
//		try {
//			host=new String(host.getBytes("GB2312"));
			prop.setProperty("host", host);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		prop.setProperty("imagePath", imagePath);
		try{
			FileWriter fos=new FileWriter(path);
			prop.store(fos, "test");
			fos.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void load(){
		Properties prop=new Properties();
		try{
			FileReader fis=new FileReader(path);
			
			prop.load(fis);
			fis.close();

		}catch(Exception e){
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"初始化文件！");
			MvcProperties.toLog("初始参数装入时错误："+e);
			System.exit(-1);
			
		}
		dbDriverName=prop.getProperty("dbDriverName", dbDriverName);
		url=prop.getProperty("url", url);
		user=prop.getProperty("user", user);
		password=prop.getProperty("password", password);
		host=prop.getProperty("host",host);
		
		hostName=prop.getProperty("hostName", hostName);//New20101216

		String s;
		s=prop.getProperty("port");
		if(s!=null){
			try{
				port=Integer.parseInt(s);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		//New 20111108 by Brandi for GPRS
		s=prop.getProperty("CommunicationMethod", CommunicationMethod+"");
		CommunicationMethod=Integer.parseInt(s);
		s=prop.getProperty("listeningPort",listeningPort+"");
		listeningPort=Short.parseShort(s);
		//end
		s=prop.getProperty("inBaseDaysSaved");
		if(s!=null){
			inBaseDaysSaved=Integer.parseInt(s);
			if(inBaseDaysSaved<2)
				inBaseDaysSaved=2;
		}
		
		//insert 20120223 for lock
		s=prop.getProperty("lock",lock+"");
		lock=Integer.parseInt(s);
		//end
		s=prop.getProperty("left",left+"");
		left=Integer.parseInt(s);
		s=prop.getProperty("top",top+"");
		top=Integer.parseInt(s);
		s=prop.getProperty("width",width+"");
		width=(Integer.parseInt(s));
		s=prop.getProperty("height",""+height);
		height=(Integer.parseInt(s));

		s=prop.getProperty("left2",left2+"");
		left2=Integer.parseInt(s);
		s=prop.getProperty("top2",top2+"");
		top2=Integer.parseInt(s);
		s=prop.getProperty("width2",width2+"");
		width2=(Integer.parseInt(s));
		s=prop.getProperty("height2",""+height2);
		height2=(Integer.parseInt(s));
		
		s=prop.getProperty("cFunction",""+MvcProperties.customFunction);
		MvcProperties.customFunction=(Integer.parseInt(s));
		
		
		s=prop.getProperty("refreshLapse");
		if(s!=null)
			MvcProperties.refreshLapse=(short)Integer.parseInt(s);
		//New 20110917
		s=prop.getProperty("lapseLogin");
		if(s!=null)
			MvcProperties.lapseLogin=(short)Integer.parseInt(s);
		
		s=prop.getProperty("ratioElectricityMeasure");
		if(s!=null)
			MvcProperties.ratioElectricityMeasure=Float.parseFloat(s);
		s=prop.getProperty("powerDefault");
		if(s!=null)
			MvcProperties.powerDefault=Short.parseShort(s);
		
		String ss[];
//		Product.productClasses=(ss=initParam(classFile))==null?Product.productClasses:ss;
//		Product.inputForbidden=(ss=initParam(inputForbiddenFile))==null?Product.inputForbidden:ss;
		
		imagePath=prop.getProperty("imagePath", imagePath);
		imageSplash=prop.getProperty("imageSplash", imageSplash);
		iconPath=prop.getProperty("iconPath", iconPath);
		
		s=prop.getProperty("colors[0]");
		colors[0]=setColors(s);
		s=prop.getProperty("colors[1]");
		colors[1]=setColors(s);
		
		s=prop.getProperty("fees");
		fees=setFees(s);
		
//		try {
//			ModelDBImplTemCon.alterTable();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			write("alter table temconset",e.getMessage());
//		}
	}
	public static void main(String [] args)throws Exception{
//		if(args.length==0){
//			System.out.println("命令参数：backup或restore");
//			return;
//		}
//		if(args[0].equalsIgnoreCase("backup")){
////			MvcProperties.backupDB();
//		}
//		else if(args[0].equalsIgnoreCase("restore")){
//			MvcProperties.restoreDB();
//		}
//		initParam(province);
		//store();
//		DateFormat df=DateFormat.getDateTimeInstance();
//		System.out.println(df.format(MvcProperties.getNextDayBegin(df.parse("2011-4-25 0:0:0"))));
//		System.out.println(getOutDoor());
//		int x=0x0120;
//		System.out.println(MvcProperties.getHiBYTE(x));
//		System.out.println(MvcProperties.getLowBYTE(x));
//		
//		System.out.printf("\n%d",MvcProperties.getIntFromBytes((byte)0x1, (byte)0x0a));
		System.out.println(MvcProperties.initParam(MvcProperties.province));
		
		DateFormat df=DateFormat.getDateTimeInstance();
		Date d=MvcProperties.getNextDayBegin(new Date());
		System.out.println(df.format(d));
	}
	
	public static Map initParam(String classFile){
		try{
			File file=new File(classFile);
			if(!file.exists()){
//				throw new FileNotFoundException(classFile+" not exists in "+file.getParent());
				return null;
			}
			byte buf[]=new byte[(int)file.length()];
			FileInputStream fis=new FileInputStream(file);
			fis.read(buf);
			fis.close();
			
			Map map=parseFile(buf);
//			if(ss!=null && ss.length>0)
//				return ss;
			return map;
		}
		catch(Exception e){
			MvcProperties.toLog(e);
		}
		return null;
	}
	public static Map parseFile(byte [] buf){
		String ss[]=new String(buf).split("\r\n");
		
		Map<String,List<String>> map=new HashMap();
		for(String s:ss){
			String sss[]=s.split(" ");
			List l=map.get(sss[0]);
			if(l==null){
				l=new ArrayList();
				map.put(sss[0], l);
			}
			if(sss.length>1){
				l.add(sss[1]);
			}
//			System.out.println(s);
		}
//		System.out.println(map);
		return map;
	}
	
	public static String[] initParam(){
		try{
			File file=new File(portSetting);
			if(!file.exists()){
				throw new FileNotFoundException(portSetting+" not exists in "+file.getParent());
			}
			byte buf[]=new byte[(int)file.length()];
			FileInputStream fis=new FileInputStream(portSetting);
			fis.read(buf);
			fis.close();
			return parse(buf);
		}
		catch(Exception e){
			log.error("MvcProperties:initParam:"+e);
		}
		return null;
	}
	public static String [] parse(byte [] buf){
		String ss[]=new String(buf).split(";|,| |\r\n");
//		for(String s:ss){
//			System.out.println(s);
//		}
		return ss;
	}
	public static String [] parse(byte [] buf,String separators){
		String ss[]=new String(buf).split(separators);
//		for(String s:ss){
//			System.out.println(s);
//		}
		return ss;
	}
	 
	
	


	public static OutputStream getOutputStream(String path)throws Exception{
//		String dir="log";
//		createDir(pathLog);
		File file=new File(pathLog);
		if(!file.exists())
			file.mkdir();
		file=new File(pathLog,path);
		
		return new FileOutputStream(file,true);
	}
	
	public static void close(){
//		try{
//			if(logOutputStream==null)
//				logOutputStream.close();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
	}
	
	public static void delete(){
		if(JOptionPane.showConfirmDialog(null,"删除称重历史记录吗？")!=JOptionPane.OK_OPTION)
			return;
		File file=new File(pathLog);
		if(!file.exists())
			return;
		//file=new File(file,"*.*");
		
		String ss[]=file.list();
		for(String s :ss){
			File f=new File(pathLog,s);
			f.delete();
		}
	}
	
	public static String getColors(Color color){
		int red=color.getRed();
		int blue=color.getBlue();
		int green=color.getGreen();
		return red+","+green+","+blue;
	}
	public static Color setColors(String s){
		String ss[]=s.split(",");
		int red=Integer.parseInt(ss[0]);
		int blue=Integer.parseInt(ss[2]);
		int green=Integer.parseInt(ss[1]);
		
		return new Color(red,green,blue);
		
	}
	public static String getFees(float[] fees){
		float gu=fees[0];
		float ping=fees[1];
		float feng=fees[2];
		return gu+","+ping+","+feng;
	}
	public static float[] setFees(String s){
		//New 20110515 Yang
		if(s==null){
			return new float[]{0.3f,1.0f,1.2f};
		}
		//End 20110515
			
		String ss[]=s.split(",");
		float gu=Float.parseFloat(ss[0]);
		float ping=Float.parseFloat(ss[1]);
		float feng=Float.parseFloat(ss[2]);
		return new float[]{gu,ping,feng};
	}
	public static  void backupDB(String path)throws Exception{
//		String path=JOptionPane.showInputDialog("确认数据库路径",MvcProperties.pathMySQL);
//		if(path.charAt(path.length()-1)!=File.separatorChar)
//			path+=File.separatorChar;
//		path="\""+path+"bin\"\\";
		//只能执行当前目录下的可执行程序
		//构造backup.bat:
		String cmd="mysqldump.exe -uroot -p"+MvcProperties.password+" --opt xinyuanDB>\""+path+"\"";//MvcProperties.pathBackup;
		String ss="xinyuan1.bat";
		File pathBat=new File(ss);

		FileWriter fos=new FileWriter(pathBat);
//		fos.write(path);
		fos.write(cmd);
		fos.close();	

		Process process = Runtime.getRuntime().exec("cmd /c "+ ss);

//		Thread.sleep(2000);
		System.out.println("数据库已导出到文件"+path);
		
	}
	//数据库导入
	public static void restoreDB(String path)throws Exception{
//		String pathBin=System.getProperty("user.dir");
//		if(pathBin.charAt(pathBin.length()-1)!=File.separatorChar)
//			pathBin+=File.separatorChar;
////		String path=JOptionPane.showInputDialog("确认数据库路径",MvcProperties.pathMySQL);
//		if(path.charAt(path.length()-1)!=File.separatorChar)
//			path+=File.separatorChar;
//		path="\""+path+"bin\"\\";

		//只能执行当前目录下的可执行程序
		String cmd="mysqladmin -uroot -p"+MvcProperties.password+" create xinyuanDB";
		String cmd2="mysql -uroot -p"+MvcProperties.password+" xinyuanDB <\"";
		StringBuilder sb=new StringBuilder();
//		sb.append(path);
		sb.append(cmd);
		sb.append("\r\n");
//		sb.append(path);
		sb.append(cmd2);
		sb.append(path);
//		sb.append(pathBin);
//		sb.append(MvcProperties.pathBackup);
		sb.append("\"\r\n");

		String ss="xinyuan2.bat";
		File pathBat=new File(ss);

		FileWriter fos=new FileWriter(pathBat);
		fos.write(sb.toString());
		fos.close();	


		Process process = Runtime.getRuntime().exec("cmd /c "+ ss);

		Thread.sleep(1000);

		System.out.println("数据库导入完成"); 
		
	}
	
	public static int day=0;

	public static Date getNextDayBegin(Date date){
		DateFormat df=DateFormat.getDateInstance();
		try {
			return new Date(df.parse(df.format(date)+" 0:0:0").getTime()+(24*3600*1000));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return date;
		}
		
	}
	public static Date getCurrentDayBegin(Date date){
		DateFormat df=DateFormat.getDateInstance();
		try {
			return new Date(df.parse(df.format(date)).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return date;
		}
		
	}
	/**
	 * 0x0110表示01H和0aH
	 * @param n
	 * @return
	 */
	public static byte getHiBYTE(int n){
		int i=((n & 0xff00)>>8);
//		return (byte)i;
		String s=Integer.toHexString(i);
		i=Integer.parseInt(s);
		return (byte)i;
//		i=(i & 0x0f)+((i& 0xf0)>>4)*16;
//		return (byte)((i %10)+(i/10)*16);
	}
	public static byte getLowBYTE(int n){
		int i=(n & 0xff);
		String s=Integer.toHexString(i);
		i=Integer.parseInt(s);
//		i= (i & 0x0f)+((i& 0xf0)>>4)*16;
//		return (byte)((i %10)+(i/10)*16);
		return (byte)i;
	}
	/**
	 * 将0x1,0xa转为0x110
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getIntFromBytes(byte a,byte b){
		int aa=(a & 0xff);//(a & 0x0f)+((a& 0xf0)>>4)*10;//1
		int bb=(b & 0xff);//(b & 0x0f)+((b& 0xf0)>>4)*10;//10
		String s=Integer.toString(aa);
		aa=Integer.parseInt(s,16);
		s=Integer.toString(bb);
		bb=Integer.parseInt(s,16);
		return ((aa<<8)| bb);
	}
	
	/**
	 * 将串转为户式控制器地址：如"110"转为266
	 * @param s
	 * @return
	 */
	public static int getTemConAddr(String s){
		int l;
		if(s==null || (l=s.length())<=0 || l>4){
			JOptionPane.showMessageDialog(JFrameGuiSuper.gui, "不正确的户式控制器编号："+s);
			return 0;
		}
			
		
		try{
			int n=0;
			if(l<=2){
				n=Integer.parseInt(s);
				return n;
			}
			
			n=Integer.parseInt(s.substring(l-2));
			n=Integer.parseInt(s.substring(0,l-2))*256+n;
//			System.out.println("JFrameSupper:alOutDoorTemConAddr:"+MvcProperties.outDoorTemConAddr);
			return n;
		}
		catch(Exception excp){
			JOptionPane.showMessageDialog(JFrameGuiSuper.gui, "不正确的户式控制器编号："+s);
			return 0;
		}
	}
	/**
	 * 整数保留len位
	 * @param val
	 * @param len
	 * @return
	 */
	public static String toStr(int val,int len){
		NumberFormat nf=NumberFormat.getIntegerInstance();
		nf.setGroupingUsed(false);//千分号不用
		nf.setMaximumIntegerDigits(len);
		nf.setMinimumIntegerDigits(len);
		return nf.format(val);
	}
	/**
	 * 实数保留len小数位
	 * @param val
	 * @param len
	 * @return
	 */
	public static String toStr(float val,int len){
		NumberFormat nf=NumberFormat.getIntegerInstance();
//		nf.setGroupingUsed(false);//千分号不用
		nf.setMaximumFractionDigits(len);
		nf.setMinimumFractionDigits(len);
		return nf.format(val);
	}
	
	public static String toStr(float f){
		return toStr(f,2);
	}
	/**
	 * 读入文件内容，并基于，；空格 换行分隔为字符串集
	 * @param path 路径
	 * @return 字符串数组
	 */
	
	
	public static String[] loadContents(String path)throws Exception{
		byte buf[] =loadFile(path);
		return parse(buf);
	}
	
	public static byte[] loadFile(String path)throws Exception{
		try{
			File file=new File(path);
			if(!file.exists()){
				throw new FileNotFoundException(portSetting+" not exists in "+file.getParent());
			}
			byte buf[]=new byte[(int)file.length()];
			FileInputStream fis=new FileInputStream(path);
			fis.read(buf);
			fis.close();
			return buf;
//			return parse(buf);
		}
		catch(Exception e){
			log.error("MvcProperties:initParam:",e);
			throw e;
		}
	}
	/**
	 * 在文件尾追加字符串,以换行分隔
	 * @param path 文件路径
	 * @param item 字符串
	 */
	public static void appendItemToFile(String path,String item){
		try {
			FileOutputStream fos=new FileOutputStream(path,true);
			fos.write(("\r\n"+item).getBytes());
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getStackTrackString(Exception e){
		sb.delete(0, sb.length());
		StackTraceElement ste[]=e.getStackTrace();
		for(int i=0;i<ste.length;i++){
			if(i>0)
				sb.append("\r\n");
			sb.append(ste[i]);
			
		}
		return sb.toString();
	}
	
	
	/**
	 * 以文件名“项目.dat”如“fee.dat”为名读取列设置信息　New 20131222
	 * @param file
	 * @param ics
	 */
	public static void loadColumn(String file,ItemColumnState ics[]){
		File f=new File("res",file+".dat");
		try{
			byte buf[]=MvcProperties.loadFile(f.getAbsolutePath());
			String ss[]=parse(buf," ");
			int n=Math.min(ics.length, ss.length);
			for(int i=0;i<n;i++){
				if(ics[i].isEnabled())
					ics[i].setVisible(new Boolean(ss[i]));
			}
		}
		catch(Exception e){
			log.error(e);
			return ;
		}
		
		
	}
	/**
	 * 以文件名“项目.dat”如“fee.dat”为名保存列设置信息　New 20131222
	 * @param file
	 * @param ics
	 */
	public static void storeColumn(String file,ItemColumnState ics[]){
		if(ics==null || ics.length==0)
			return;
		
		File f=new File("res",file+".dat");
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ics.length;i++){
			if(i>0){
				sb.append(' ');
			}
			sb.append(ics[i].isVisible());
		}
		try{
			FileOutputStream fos=new FileOutputStream(f);
			fos.write(sb.toString().getBytes());
			fos.close();
		}
		catch(Exception e){
			log.error(e);
		}
	}
	
}

//  \\192.168.21.150
