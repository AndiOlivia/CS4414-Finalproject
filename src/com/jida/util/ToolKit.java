package com.jida.util;

import java.io.File;

import java.io.FileInputStream;

import com.jida.MvcProperties;

public class ToolKit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static byte getParitySum(byte [] bb,int len){
		int sum=0;
		for(int i=0;i<len && i<bb.length;i++){
			sum+=(bb[i] & 0xff);  
//			System.out.println(sum);
		}
		return (byte)(sum & 0xff);
	}
	public static byte[] readFromFile(String path)throws Exception{
		File file=new File(path);
		if(!file.exists())
			return null;
		int len=(int)file.length();
		byte buf[]=new byte[len];
		FileInputStream fis=new FileInputStream(path);
		fis.read(buf);
		fis.close();
		return buf;
	}
	public static String[] getStringFromFile(String path)throws Exception{
		byte buf[]=readFromFile(path);
		if(buf==null)
			return null;
		String s=new String(buf);
		String ss[]=s.split(" |\r\n");
		return ss;
	}
	/**
	 * e.g. "3ab40101000000000000000000F0";
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static byte[] getBytesFromString(String s)throws Exception{
		byte[] b=null;
//		for(int i=0;i<s.length;i++){
			 b= new byte[s.length() / 2];
			String tmp = "";
			for (int j = 0; j < b.length; j++) {
				tmp = s.substring(j * 2, j * 2 + 2);
				b[j] =(byte)(Integer.parseInt(tmp, 16)&0xff);
			}
//			System.out.println(Arrays.toString(b));
//		}
		return b;
	}
	
	public static String getCorresponding(String name,String names[],String cor[]){
		if(name==null || name.equals(""))
			return null;
		int i;
		for(i=0;i<names.length;i++){
			if(name.equals(names[i])) break;
		}
		if(i>=names.length)
			return null;
		return cor[i];
	}
	

	public static String getHexString(byte [] buf){
		String s="";
		if(buf==null)
			return null;
		String s1=null;
		for(byte b:buf){
			s1=Integer.toHexString(b&0xff);
			if(s1.length()<=1){
				s1="0"+s1;
			}
			s+=s1;
		}
		return s;
	}
	public static boolean equals(byte []b1,byte []b2){
		if(b1==null || b2==null)
			return false;
		if(b1.length!=b2.length)
			return false;
		for(int i=0;i<b1.length;i++){
			if(b1[i]!=b2[i])
				return false;
		}
		return true;
	}
}
