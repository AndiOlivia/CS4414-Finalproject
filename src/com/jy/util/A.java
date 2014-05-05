package com.jy.util;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class A extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		a.setLayout(null);
		JLabel l=new JLabel("<html>防冻温设[4,15]<br>4为防冻关闭</html>");
		
		//l.set
		a.getContentPane().add(l);
		l.setBounds(50,50, 80, 60);
		a.setSize(500,400);
		a.setVisible(true);
	}
	
	

}
