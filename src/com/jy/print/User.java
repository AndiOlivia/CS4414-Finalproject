package com.jy.print;

public class User {
	private static String passwords[]={"a0b5","b9lk","ch7y6","djui","ea09s","f8ui7","gn88m","hfd5","ilxl","jw2qa",
			"kj43","lnk7","mgs5","n731","owe8","peek7","qween","rise5","s0ite","t8ree",
			"uni9t","v65ow","win00","xoyen","yang0","zoo36","9join","8un0","7iire","600k9","5seg7",};
	private static String users="jida007007";
	String user;
	String password;
	String type;//0:normal 1:just see
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	public static boolean right(int d,String password,String user){
		if(d<1 || d>passwords.length){
			return false;
		}
		return user.equals(user)&&passwords[d-1].equals(password);
	}
}
