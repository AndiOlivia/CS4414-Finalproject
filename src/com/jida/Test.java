package com.jida;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss="2014-3-21 21:50:0";
		try {
			Date d=DateFormat.getDateTimeInstance().parse(ss);
			
			Timer timer=new Timer();
			timer.schedule(new TimerTask(){
				public void run(){
					System.out.println(new Date());
				}
			}, d,10000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void f(){
		new MyThread().start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---");
	}

}

class MyThread extends Thread{
	public void run(){
		throw new RuntimeException("Test Exception in other thread");
	}
}
