package com.jida.gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CustomerColumnChooser extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	public static final int ID = 0;
	public static final int CUSNAME = 1;
	public static final int PRODUCTTYPE = 2;
	public static final int CITY = 3;
	public static final int ZIP = 4;
	public static final int WEBADDR = 5;
	public static final int BANK = 6;
	public static final int TRAINSTATION = 7;
	public static final int PROFESSIONTYPE = 8;
	public static final int CUSTYPE = 9;
	public static final int COUNTRY = 10;
	public static final int CONTACTADDR = 11;
	public static final int FAX = 12;
	public static final int TAXID = 13;
	public static final int TICKETADDR = 14;
	public static final int BUSSTATION = 15;
	public static final int SYMBOL = 16;
	public static final int CUSSOURCE = 17;
	public static final int PROVINCE = 18;
	public static final int TEL = 19;
	public static final int EMAIL = 20;
	public static final int ZHANGHAO = 21;
	public static final int TICKETTEL = 22;
	public static final int MEMO = 23;
	private JPanel btnPanel;
	private JCheckBox ckCusName;
	private JCheckBox ckTel;
	private JCheckBox ckMemo;
	private JCheckBox ckTicketTel;
	private JCheckBox ckZhanghao;
	private JCheckBox ckEmail;
	private JCheckBox ckProvince;
	private JCheckBox ckCusSource;
	private JButton btnCancel;
	private JButton btnOK;
	private JCheckBox ckSymbol;
	private JCheckBox ckBusStation;
	private JCheckBox ckTicketAddr;
	private JCheckBox ckTaxId;
	private JCheckBox ckFax;
	private JCheckBox ckTrainStation;
	private JCheckBox ckContactAddr;
	private JCheckBox ckCountry;
	private JCheckBox ckCusType;
	private JCheckBox ckProfession;
	private JCheckBox ckBank;
	private JCheckBox ckWebAddr;
	private JCheckBox ckZip;
	private JCheckBox ckCity;
	private JCheckBox ckProductType;
	private JCheckBox ckID;
	private JCheckBox [] cks = null;
	private JCheckBox ckAll;


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CustomerColumnChooser inst = new CustomerColumnChooser();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public CustomerColumnChooser() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setResizable(false);
			GridBagLayout thisLayout = new GridBagLayout();
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
			thisLayout.rowHeights = new int[] {7, 25, 7, 25, 7, 25, 7, 25, 7, 25, 7, 25, 7, 25, 7, 25, 7, 20};
			thisLayout.columnWeights = new double[] {0.0, 0.1, 0.1, 0.1};
			thisLayout.columnWidths = new int[] {7, 7, 7, 7};
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				btnPanel = new JPanel();
				GridBagLayout btnPanelLayout = new GridBagLayout();
				btnPanelLayout.rowWeights = new double[] {0.0, 0.1};
				btnPanelLayout.rowHeights = new int[] {-1, 7};
				btnPanelLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
				btnPanelLayout.columnWidths = new int[] {7, 7, 7, 7};
				btnPanel.setLayout(btnPanelLayout);
				getContentPane().add(btnPanel, new GridBagConstraints(1, 17, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				{
					btnOK = new JButton();
					btnPanel.add(btnOK, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnOK.setText("\u786e\u5b9a");
					btnOK.setHorizontalAlignment(SwingConstants.RIGHT);
				}
				{
					btnCancel = new JButton();
					btnPanel.add(btnCancel, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					btnCancel.setText("\u53d6\u6d88");
				}
				{
					ckAll = new JCheckBox();
					btnPanel.add(ckAll, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					ckAll.setText("\u5168\u9009");
				}
			}
			{
				ckID = new JCheckBox();
				getContentPane().add(ckID, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckID.setText("\u7f16\u53f7");
				ckID.setSelected(true);
				ckID.setEnabled(false);
			}
			{
				ckCusName = new JCheckBox();
				getContentPane().add(ckCusName, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckCusName.setText("\u5ba2\u6237\u540d\u79f0");
				ckCusName.setSelected(true);
				ckCusName.setEnabled(false);
			}
			{
				ckProductType = new JCheckBox();
				getContentPane().add(ckProductType, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckProductType.setText("\u4e3b\u8425\u4ea7\u54c1");
			}
			{
				ckCity = new JCheckBox();
				getContentPane().add(ckCity, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckCity.setText("\u57ce\u5e02");
			}
			{
				ckZip = new JCheckBox();
				getContentPane().add(ckZip, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckZip.setText("\u90ae\u7f16");
			}
			{
				ckWebAddr = new JCheckBox();
				getContentPane().add(ckWebAddr, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckWebAddr.setText("\u7f51\u5740");
			}
			{
				ckBank = new JCheckBox();
				getContentPane().add(ckBank, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckBank.setText("\u5f00\u6237\u94f6\u884c");
			}
			{
				ckTrainStation = new JCheckBox();
				getContentPane().add(ckTrainStation, new GridBagConstraints(1, 15, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckTrainStation.setText("\u706b\u8f66\u5230\u7ad9");
			}
			{
				ckProfession = new JCheckBox();
				getContentPane().add(ckProfession, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckProfession.setText("\u884c\u4e1a\u7c7b\u522b");
			}
			{
				ckCusType = new JCheckBox();
				getContentPane().add(ckCusType, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckCusType.setText("\u5ba2\u6237\u7c7b\u578b");
			}
			{
				ckCountry = new JCheckBox();
				getContentPane().add(ckCountry, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckCountry.setText("\u56fd\u5bb6");
			}
			{
				ckContactAddr = new JCheckBox();
				getContentPane().add(ckContactAddr, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckContactAddr.setText("\u901a\u8baf\u5730\u5740");
			}
			{
				ckFax = new JCheckBox();
				getContentPane().add(ckFax, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckFax.setText("\u4f20\u771f");
			}
			{
				ckTaxId = new JCheckBox();
				getContentPane().add(ckTaxId, new GridBagConstraints(2, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckTaxId.setText("\u7a0e\u53f7");
			}
			{
				ckTicketAddr = new JCheckBox();
				getContentPane().add(ckTicketAddr, new GridBagConstraints(2, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckTicketAddr.setText("\u5f00\u7968\u5730\u5740");
			}
			{
				ckBusStation = new JCheckBox();
				getContentPane().add(ckBusStation, new GridBagConstraints(2, 15, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckBusStation.setText("\u6c7d\u8f66\u5230\u7ad9");
			}
			{
				ckSymbol = new JCheckBox();
				getContentPane().add(ckSymbol, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckSymbol.setText("\u52a9\u8bb0\u7b26");
			}
			{
				ckCusSource = new JCheckBox();
				getContentPane().add(ckCusSource, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckCusSource.setText("\u5ba2\u6237\u6765\u6e90");
			}
			{
				ckProvince = new JCheckBox();
				getContentPane().add(ckProvince, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckProvince.setText("\u7701\u4efd");
			}
			{
				ckTel = new JCheckBox();
				getContentPane().add(ckTel, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckTel.setText("\u7535\u8bdd");
			}
			{
				ckEmail = new JCheckBox();
				getContentPane().add(ckEmail, new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckEmail.setText("\u7535\u5b50\u90ae\u4ef6");
			}
			{
				ckZhanghao = new JCheckBox();
				getContentPane().add(ckZhanghao, new GridBagConstraints(3, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckZhanghao.setText("\u5e10\u53f7");
			}
			{
				ckTicketTel = new JCheckBox();
				getContentPane().add(ckTicketTel, new GridBagConstraints(3, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckTicketTel.setText("\u5f00\u7968\u7535\u8bdd");
			}
			{
				ckMemo = new JCheckBox();
				getContentPane().add(ckMemo, new GridBagConstraints(3, 15, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				ckMemo.setText("\u5907\u6ce8");
			}
			this.generateCkArray();
			pack();
			this.setSize(441, 334);
			this.ckAll.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent ce) {
					selectAll(isSelectAllChecked());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean [] getSelectedItem() {
		boolean [] returnMe = new boolean[this.cks.length];
		for(int i = 0; i < this.cks.length; ++i) {
			returnMe[i] = this.cks[i].isSelected();
		}
		return returnMe;
	}

	public boolean showAlertBox(String msg) {
		//JOptionPane.showConfirmDialog(this, msg, "Warning", JOptionPane.WARNING_MESSAGE, null, null, null);

		return (JOptionPane.showConfirmDialog(this, msg, "Warning", JOptionPane.YES_NO_OPTION) == 0);

	}

	public void selectAll(boolean all) {
		for (int i = 2; i < this.cks.length; ++i) {
			this.cks[i].setSelected(all);
		}
	}

	public boolean isSelectAllChecked() {
		return this.ckAll.isSelected();
	}

	public void registerListeners(ActionListener ok, ActionListener cancel, MouseListener ckAll) {
		this.btnOK.addActionListener(ok);
		this.btnCancel.addActionListener(cancel);
		this.ckAll.addMouseListener(ckAll);
		this.ckAll.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {return;}
		});
	}

	private void generateCkArray() {
		this.cks = new JCheckBox [] {
				this.ckID, this.ckCusName, this.ckProductType,
				this.ckCity, this.ckZip, this.ckWebAddr,
				this.ckBank, this.ckTrainStation, this.ckProfession,
				this.ckCusType, this.ckCountry,
				this.ckContactAddr, this.ckFax, this.ckTaxId,
				this.ckTicketAddr, this.ckBusStation, this.ckSymbol,
				this.ckCusSource, this.ckProvince, this.ckTel,
				this.ckEmail, this.ckZhanghao, this.ckTicketTel,
				this.ckMemo
		};

	}


}
