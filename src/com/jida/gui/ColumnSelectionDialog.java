package com.jida.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class ColumnSelectionDialog extends JDialog {
	private ItemColumnState [] items;
	private JCheckBox checkBox[];
	private JButton jButtonOk;
	private JButton jButtonCancel;
	private JButton jButtonSelectAll;
	private JButton jButtonDeselectAll;
	private AbstractTableModel model;
	
	public ColumnSelectionDialog(String title,ItemColumnState [] items,AbstractTableModel model){
		this.setTitle(title);
		this.items=items;
		this.model=model;
		
		this.setModal(true);
		
		initDialog();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemColumnState ics[]=new ItemColumnState[6];
		for(int i=0;i<ics.length;i++){
			ics[i]=new ItemColumnState("Test"+i,true,i%2==0?true:false,i);
		}
//		new ColumnSelectionDialog("Test",ics);
	}
	int columnsNo=5;
	public void initDialog(){
		this.getContentPane().setLayout(new GridBagLayout());
		
		int i=0,j=0;
		if(this.items!=null){
			this.checkBox=new JCheckBox[items.length];
			for(int k=0;k<items.length;k++){
				this.checkBox[k]=new JCheckBox(items[k].getStrColumn());
				if(items[k].isVisible()){
					this.checkBox[k].setSelected(true);
				}
				
				this.checkBox[k].setEnabled(items[k].isEnabled());
				
				this.getContentPane().add(this.checkBox[k], new GridBagConstraints(i, j,
						1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
						GridBagConstraints.VERTICAL,
						new Insets(0, 0, 0, 0), 0, 0));
				i++; i%=this.columnsNo;
				if(i==0) j++;
			}
		}
		j++;
		this.jButtonOk=new JButton("确定");
		this.getContentPane().add(this.jButtonOk, new GridBagConstraints(this.columnsNo-2, j,
				1, 2, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		
		this.jButtonCancel=new JButton("取消");
		this.getContentPane().add(this.jButtonCancel, new GridBagConstraints(this.columnsNo-1, j,
				1, 2, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		this.jButtonSelectAll=new JButton("全部选择");
		this.getContentPane().add(this.jButtonSelectAll, new GridBagConstraints(this.columnsNo-4, j,
				1, 2, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		this.jButtonDeselectAll=new JButton("全部取消");
		this.getContentPane().add(this.jButtonDeselectAll, new GridBagConstraints(this.columnsNo-3, j,
				1, 2, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		
		setSize((this.columnsNo+2)*100,(j+3)*50);
//		setVisible(true);
		
		this.register();
	}
	public void register(){
		this.jButtonOk.addActionListener(this.alOk);
		this.jButtonCancel.addActionListener(this.alCancel);
		this.jButtonSelectAll.addActionListener(this.alSelectAll);
		this.jButtonDeselectAll.addActionListener(this.alDeselectAll);
	}

	transient ActionListener alOk=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			for(int i=0;i<checkBox.length;i++){
				if(items[i].isEnabled())
					items[i].setVisible(checkBox[i].isSelected());
				else
					items[i].setVisible(true);
//				System.out.println(i+":"+items[i]);
			}
			
			ItemColumnState.setNos(items);
			
			
			setVisible(false);
			dispose();
			model.fireTableStructureChanged();
		}
	};
	transient ActionListener alCancel=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			setVisible(false);
			dispose();
			
		}
	};
	transient ActionListener alSelectAll=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			for(int i=0;i<checkBox.length;i++){
				checkBox[i].setSelected(true);
//				System.out.println(i+":"+items[i]);
			}
		}
	};
	transient ActionListener alDeselectAll=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			for(int i=0;i<checkBox.length;i++){
				if(items[i].isEnabled())
					checkBox[i].setSelected(false);
//				System.out.println(i+":"+items[i]);
			}
		}
	};
}
