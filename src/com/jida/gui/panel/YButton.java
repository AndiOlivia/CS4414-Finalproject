package com.jida.gui.panel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class YButton extends JButton {
	Border border=BorderFactory.createBevelBorder(BevelBorder.RAISED);//this.getBorder();
	{
		this.setBorder(null);
		this.setOpaque(false);
//		this.addMouseListener(ml);
	}
	public YButton(Color color){
		super();
		{
			
			this.setBackground(color);
//			this.setOpaque(false);
			this.addMouseListener(ml);
		}
		
	}
	public YButton(){
		super();
		{
			this.setBorder(null);
//			this.setBackground(color);
			this.addMouseListener(ml);
		}
		
	}
	public YButton(String name){
		super(name);
		{
//			this.setBorder(null);
//			this.setOpaque(false);
			this.addMouseListener(ml);
		}
	}
	transient MouseListener ml=new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			super.mouseClicked(e);
		}
		public void mousePressed(MouseEvent e){
			super.mousePressed(e);
		}
		public void mouseReleased(MouseEvent e){
			super.mouseReleased(e);
		}
		public void mouseEntered(MouseEvent e){
			setBorder(border);
//			super.mouseEntered(e);
		}
		public void mouseExited(MouseEvent e){
			setBorder(null);
//			super.mouseClicked(e);
		}
	};
}
