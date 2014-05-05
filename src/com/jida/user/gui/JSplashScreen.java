package com.jida.user.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.jida.MvcProperties;
import com.jida.client.Main;


public class JSplashScreen extends javax.swing.JDialog {

    public static final int SPLASH_MODE = 0;
    public static final int ABOUT_MODE = 1;
    private Frame frame = null;
    private int mode = SPLASH_MODE;
//    private BufferedImage image = null;
    private int width=550;
    private int height=330;
    private Image img =  Toolkit.getDefaultToolkit().createImage(MvcProperties.imageSplash);
	private JProgressBar jProgressBar;
	public static String strDisplay="";
	public static int progressValue;
	public JPanel jPanel=new JPanel(){
		protected  void paintChildren(Graphics g) {
//			super.painChildren(g);
			System.out.println(new Date());
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
//			super.paintChildren(g);
			System.out.println(new Date());
		}
		public void paint(Graphics g) {
//			paintChildren(g);
	    	super.paint(g);
//	        if (image != null) {
//	            g.drawImage(image, 0, 0, this);
//	        }
//	    	System.out.println(strDisplay);
	    	Font font=g.getFont();
	    	g.setFont(new Font(font.getFontName(),Font.PLAIN,12));
	    	g.drawString(strDisplay, 50, height+this.getY()-30);
	    }
	};
    public JSplashScreen(int mode) {
        this.mode = mode;
        this.setFocusable(true);
//        this.setModal(true);
        initComponents();
    }
    
    private void initComponents() {

//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		jPanel.setForeground(new Color(255,255,255));
//		this.add(jPanel1);
		this.setContentPane(jPanel);
		
        setAlwaysOnTop(true);//????????????
        setUndecorated(true);
        
        setSize(width,height);
        setLocationRelativeTo(null);
        
        this.setVisible(true);
//        progressThread1.start();
        jPanel.repaint();
//        this.repaint();
        
        try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("init app...");
		Main.initApplication();
    }

    
    public static void main(String s[]){
    	JSplashScreen jss = new JSplashScreen(JSplashScreen.SPLASH_MODE);
//		jss.setVisible(true);

    }
   
    
//    transient Thread progressThread1=new Thread(){
//    	public void run(){
//    		try{
//            	Thread.sleep(1000);
//            }
//            catch(Exception e){
//            	
//            }	
//    		int w=width;
//    		int h=15;
//    		jProgressBar=new JProgressBar(JProgressBar.HORIZONTAL,0,100);
//    		jProgressBar.setForeground(new Color(0,255,0));
////    		jProgressBar.setValue(20);
//    	
//    		JDialog jFrame=new JDialog(JSplashScreen.this);
//    		jFrame.getContentPane().add(jProgressBar);
//    		jFrame.setBounds(JSplashScreen.this.getX(),JSplashScreen.this.getY()+height , w, h);
//    		jFrame.setAlwaysOnTop(true);//????????????
//            jFrame.setUndecorated(true);
//            
//    		jFrame.setVisible(true);
//    	
//    		int v=0,m=0;
//    		progressValue=0;
//    		while(progressValue<=(m=jProgressBar.getMaximum())){
//    			try{
//    				Thread.sleep(500);
//    			}
//    			catch(Exception e){
//    				e.printStackTrace();
//    			}
//    			progressValue+=5;
//    			jProgressBar.setValue(progressValue);
//    			System.out.println("JSplashScreen:progressBar:"+progressValue);
////    			strDisplay="Progress:"+jProgressBar.getValue();
//    			JSplashScreen.this.getContentPane().repaint();
//    		}
//    		jFrame.setVisible(false);
//    		jFrame.dispose();
//    		JSplashScreen.this.setVisible(false);
//    		JSplashScreen.this.dispose();
//    	}
//    };
}