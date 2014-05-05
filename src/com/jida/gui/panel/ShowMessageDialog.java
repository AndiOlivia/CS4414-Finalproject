package com.jida.gui.panel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ShowMessageDialog extends JFrame {
	private JButton jButtonOk;
	private JLabel jLabelMessage;
	private JLabel jLabelIcon;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				
//			}
//		});
		new ShowMessageDialog("注意","与断开"+new Date());
//		inst.setLocationRelativeTo(null);
//		inst.show();
	}
	
	public ShowMessageDialog(String title,String message) {
		super();
//		this.setUndecorated(true); // 去掉窗口的装饰 
//		this.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);//采用指定的窗口装饰 风格 
		initGUI();
		setMessage(message);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle(title);
		this.show();
	}
	
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.1, 0.0, 0.0, 0.0};
			thisLayout.rowHeights = new int[] {20, 30, 40, 10};
			thisLayout.columnWeights = new double[] {0.1, 0.0, 0.1, 0.1, 0.0};
			thisLayout.columnWidths = new int[] {20, 60, 60, 60, 60};
			getContentPane().setLayout(thisLayout);
			{
				jButtonOk = new JButton();
				getContentPane().add(jButtonOk, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jButtonOk.setText("\u786e\u8ba4");
			}
			{
				jLabelMessage = new JLabel();
				jLabelMessage.setText("dddddddddd");
				getContentPane().add(jLabelMessage, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jLabelMessage.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelIcon = new JLabel();
				getContentPane().add(jLabelIcon, new GridBagConstraints(1, 0, 2, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabelIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/err.png")));
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
		register();
	}
	public void setMessage(String message){
		this.setSize(160+message.length()*10,120);
		this.jLabelMessage.setText(message);
	}
	public void register(){
		this.jButtonOk.addActionListener(als);
	}
	transient ActionListener als=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			dispose() ;
		}
	};

}
