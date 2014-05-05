/*
 * PanelProduct.java


 *
 * Created on __DATE__, __TIME__
 */

package com.jida.product.gui;

import java.awt.Color;




import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.jida.MvcProperties;
//import com.jida.client.Main;
import com.jida.gui.panel.ToolBarable;
import com.jida.gui.panel.YButton;
//import com.jida.kuFangXinXi.gui.PanelKuFang;
import com.jida.product.data.Product;
import com.jida.product.data.ProductType;
import com.jida.user.gui.PanelPrivilege;

/**
 *
 * @author  __USER__
 */
public class PanelProduct extends javax.swing.JPanel implements ToolBarable {
	private JLabel jLabelID;
	private JLabel jLabelName;
	private JLabel jLabelType;
	private JLabel jLabelChang;
	private JLabel jLabelR1;
	private JLabel jLabelR2;
	private JLabel jLabelR3;
	private JLabel jLabelColor;
	private JLabel jLabelWeight;


	private JScrollPane scrollPane;
	private JComboBox jComboBoxType;
//	private JLabel jLabelEndTime;
	private JTextField jTextFieldID;
	private JTextField jTextFieldName;
//	private JTextField jTextFieldType;
	private JTextField jTextFieldPrice;
	private JTextField jTextFieldTel;
	private JTextField jTextFieldFactory;
	private JTextField jTextFieldAddr;
	private JTextField jTextFieldLinkMan;
	private JTextField jTextFieldComment;
	private JTable jTableContent;
	private JTable jTableProduct;
	private JComboBox jComboBoxMode;

	private YButton jButtonSearch;
	private YButton jButtonUpdate;
	private YButton jButtonDelete;
	private YButton jButtonInsert;
	private YButton jButtonRefresh;
	private YButton jButtonExport;
	private JToolBar jToolBar;
	private JComboBox jComboBoxItem;
	private JTextField jTextFieldValue;
	public static String name="Product";

	public static void main(String[] args) {
		PanelPrivilege inst = new PanelPrivilege();
		JFrame frame = new JFrame();
		inst.setVisible(true);
		frame.getContentPane().add(new PanelProduct());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
//		new PanelKuFang();
	}

	/** Creates new form PanelProduct */
	public PanelProduct() {
		super();
		this.buildToolBar();
		initGUI();

	}
	private void initGUI() {

//		JTabbedPane jTabbedPane =new JTabbedPane();



		try {
			GridBagLayout thisLayout = new GridBagLayout();
			this.setLayout(thisLayout);
			thisLayout.rowWeights = new double[] { 0.0, 0.0, 0, 0.1};//行
			thisLayout.rowHeights = new int[] {30, 30, 30,180};
			thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0,0,0.1};//列
			thisLayout.columnWidths = new int[] {100, 100, 100, 100, 100, 100, 100, 100,100,100,9};
			this.setLayout(thisLayout);
//			this.setPreferredSize(new java.awt.Dimension(600, 500));
			{
				JLabel jLabelID = new JLabel();
				this.add(jLabelID, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabelID.setText(Product.titles[0]);
				jLabelID.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTextFieldID = new JTextField();
				this.add(jTextFieldID, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				jLabelName = new JLabel();
				this.add(jLabelName, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabelName.setText(Product.titles[1]);
				jLabelName.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTextFieldName = new JTextField();
				this.add(jTextFieldName, new GridBagConstraints(4, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}

			{
				jLabelType = new JLabel();
				this.add(jLabelType, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabelType.setText(Product.titles[2]);
				jLabelType.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jComboBoxType = new JComboBox();
				this.add(jComboBoxType, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//				this.jComboBoxType.setModel(new DefaultComboBoxModel(Product.Types));
			}
			{
				jLabelChang = new JLabel();
				this.add(jLabelChang, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabelChang.setText(Product.titles[3]);
				jLabelChang.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTextFieldPrice = new JTextField();
				this.add(jTextFieldPrice, new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				JLabel jLabelColor = new JLabel();
				this.add(jLabelColor, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabelColor.setText(Product.titles[5]);
				jLabelColor.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTextFieldFactory = new JTextField();
				this.add(jTextFieldFactory, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				JLabel jLabelWeight = new JLabel();
				this.add(jLabelWeight, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabelWeight.setText(Product.titles[6]);
				jLabelWeight.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTextFieldTel = new JTextField();
				this.add(jTextFieldTel, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}

			{
				JLabel jLabelR1 = new JLabel();
				this.add(jLabelR1, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabelR1.setText(Product.titles[4]);
				jLabelR1.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTextFieldAddr = new JTextField();
				this.add(jTextFieldAddr, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

			}
//			{
//				jLabelR2 = new JLabel();
//				this.add(jLabelR2, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//				jLabelR2.setText(Product.titles[7]);
//				jLabelR2.setHorizontalAlignment(SwingConstants.RIGHT);
//			}
//			{
//				jTextFieldLinkMan = new JTextField();
//				this.add(jTextFieldLinkMan, new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//
//			}
			{
				jLabelR3 = new JLabel();
				this.add(jLabelR3, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabelR3.setText(Product.titles[7]);
				jLabelR3.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTextFieldComment = new JTextField();
				this.add(jTextFieldComment, new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

			}
			{
				this.scrollPane = new JScrollPane();
				this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//				this.add(this.scrollPane, new GridBagConstraints(0,3, 8,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//				getContentPane().add(this.scrollPane, new GridBagConstraints(2, 9, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}

			{
//				TableModel jTableContentModel = new DefaultTableModel(
//				new String[][] { { "One", "Two" }, { "Three", "Four" } },
//				new String[] { "Column 1", "Column 2" });
				jTableContent = new JTable();
				JScrollPane scrollPane=new JScrollPane();
				scrollPane.getViewport().add(this.jTableContent,null);
				this.add(scrollPane, new GridBagConstraints(0, 2, 11, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//				jTableContent.setModel(jTableContentModel);
			}
			{
//				TableModel jTableContentModel = new DefaultTableModel(
//				new String[][] { { "One", "Two" }, { "Three", "Four" } },
//				new String[] { "Column 1", "Column 2" });
				JTable jTableProduct = new JTable();
				JScrollPane scrollPane=new JScrollPane();
				scrollPane.getViewport().add(this.jTableProduct,null);
				this.add(scrollPane, new GridBagConstraints(0, 5, 11, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//				jTableContent.setModel(jTableContentModel);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
						Short.MAX_VALUE));
	}// </editor-fold>
	//GEN-END:initComponents

	public void register(ActionListener als[]){
		YButton buttons[]={this.jButtonInsert,this.jButtonDelete,this.jButtonUpdate,
				this.jButtonRefresh,this.jButtonSearch,
				this.jButtonExport};
		for(int i=0;i<als.length;i++){
			buttons[i].addActionListener(als[i]);
		}
//		this.jTextFieldValue.addActionListener(als[als.length-1]);
	}

	public int getSelectedIndex(){
		return this.jTableContent.getSelectedRow();
	}
	public void setSelectedIndex(int index){
		this.jTableContent.changeSelection(index, -1, true, false);
	}
	public void registerTable(TableModel model,ListSelectionListener lsl){
		this.jTableContent.setModel(model);
		this.jTableContent.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.jTableContent.getSelectionModel().addListSelectionListener(lsl);
	}
	public void setContent(){
		this.jTableContent.updateUI();
	}	

	public Product get(){
		Product pd=new Product();
		String s=this.jTextFieldID.getText();
		if(s==null||s.equals("")){
			JOptionPane.showMessageDialog(this,"Product No cannot be null");
			return null;
		}
		pd.setPdtNo(this.jTextFieldID.getText());



		if(this.jTextFieldName==null||this.jTextFieldName.equals("")){
			JOptionPane.showMessageDialog(this,"Product name cannot be null");
			return null;
		}
		pd.setPdtName(this.jTextFieldName.getText());
		//pd.setKFMC(this.jTextFieldKFMC.getText());
		pd.setPdtType(((String)this.jComboBoxType.getSelectedItem()));

		String chang=null;
		chang=this.jTextFieldPrice.getText();
		if(chang==null &&chang.equals("")){
			JOptionPane.showMessageDialog(this, "Illegal price");
			return null;
		}
		try{
			pd.setPdtPrice(Float.parseFloat(chang));	
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "Wrong data format!");
			return null;
		}

		String R1=null;
		R1=this.jTextFieldFactory.getText();
		pd.setPdtFactory(R1);
		
		
		String R2=this.jTextFieldTel.getText();
		pd.setPdtTel(R2);	
		String R3=this.jTextFieldAddr.getText();
		pd.setPdtAddr(R3);	
//		pd.setPdtLinkMan((String)this.jTextFieldLinkMan.getText());
		pd.setPdtComment(this.jTextFieldComment.getText());
		return pd;
	}
	public void set(Product pro){
		this.jTextFieldID.setText(pro.getPdtNo());
		this.jTextFieldName.setText(pro.getPdtName());
		this.jComboBoxType.setSelectedItem(pro.getPdtType());
		this.jTextFieldPrice.setText(String.valueOf(pro.getPdtPrice()));
		this.jTextFieldFactory.setText(pro.getPdtFactory()==null?"":pro.getPdtFactory());
		this.jTextFieldTel.setText(pro.getPdtTel()==null?"":pro.getPdtTel());
		this.jTextFieldAddr.setText(pro.getPdtAddr()==null?"":pro.getPdtAddr());
//		this.jTextFieldLinkMan.setText(pro.getPdtLinkMan());
		this.jTextFieldComment.setText(pro.getPdtComment()==null?"":pro.getPdtComment());

	}


	public String getValue(){
		return this.jTextFieldValue.getText();

	}
	public String getItem(){
		return (String)this.jComboBoxItem.getSelectedItem();
	}
	public int getJComboBoxMode() {
		return jComboBoxMode.getSelectedIndex();
	}
	public void buildToolBar(){
		this.jToolBar=new JToolBar();
		Color color=jToolBar.getBackground();
		Dimension d=new Dimension(80,25);
		{
			jButtonInsert = new YButton(color);
//			this.add(jButtonInsert, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			this.jToolBar.add(jButtonInsert);
			jButtonInsert.setIcon(MvcProperties.imageIconInsert);
			jButtonInsert.setMaximumSize(d);
			jButtonInsert.setMinimumSize(d);
			this.jButtonInsert.setToolTipText("Insert");
			this.jButtonInsert.setText("Insert");
		}
		{
			jButtonDelete = new YButton(color);
			this.jToolBar.add(jButtonDelete);
			jButtonDelete.setIcon(MvcProperties.imageIconDelete);
			jButtonDelete.setMaximumSize(d);
			jButtonDelete.setMinimumSize(d);
			this.jButtonDelete.setToolTipText("Delete");
			this.jButtonDelete.setText("Delete");
		}
		{
			jButtonUpdate = new YButton(color);
			this.jToolBar.add(jButtonUpdate);
			jButtonUpdate.setIcon(MvcProperties.imageIconUpdate);
			jButtonUpdate.setMaximumSize(d);
			jButtonUpdate.setMinimumSize(d);
			this.jButtonUpdate.setToolTipText("Update");
			this.jButtonUpdate.setText("Update");
		}
		{
			this.jToolBar.addSeparator();
		}
		{
			jButtonRefresh = new YButton(color);
			this.jToolBar.add(jButtonRefresh);
			jButtonRefresh.setIcon(MvcProperties.imageIconRefresh);
			jButtonRefresh.setMaximumSize(d);
			jButtonRefresh.setMinimumSize(d);
			this.jButtonRefresh.setToolTipText("Refresh");
			this.jButtonRefresh.setText("Refresh");
		}
//		{
//		jButtonImport = new YButton(color);
//		this.jToolBar.add(jButtonImport);
//		jButtonImport.setIcon(MvcProperties.imageIconImport);
//		jButtonImport.setPreferredSize(new Dimension(30,30));
//		this.jButtonImport.setToolTipText("导入");
//		}
		{
			jButtonExport = new YButton(color);
			this.jToolBar.add(jButtonExport);
			jButtonExport.setIcon(MvcProperties.imageIconExport);
			jButtonExport.setMaximumSize(d);
			jButtonExport.setMinimumSize(d);
			this.jButtonExport.setToolTipText("Export");
			this.jButtonExport.setText("Export");
		}
		{
			this.jToolBar.addSeparator();
		}
//		{
//		jLabel3 = new JLabel();

//		this.jToolBar.add(jLabel3);
//		jLabel3.setText("\u641c\u7d22");
//		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
//		}
		{
			ComboBoxModel jComboBoxModeModel = new DefaultComboBoxModel(
					Product.titles);
			jComboBoxItem = new JComboBox();
			jComboBoxItem.setModel(jComboBoxModeModel);
			jComboBoxItem.setMaximumSize(d=new Dimension(100,25));
			jComboBoxItem.setMinimumSize(d);
			
			this.jToolBar.add(this.jComboBoxItem);
		}
		{
			ComboBoxModel jComboBoxItemModel = new DefaultComboBoxModel(
					new String[] { "Accurately", "Not Accurately" });
			jComboBoxMode = new JComboBox();
			this.jToolBar.add(this.jComboBoxMode);
			jComboBoxMode.setMaximumSize(d=new Dimension(120,25));
			jComboBoxMode.setMinimumSize(d);
			jComboBoxMode.setModel(jComboBoxItemModel);
		}
		{
			jTextFieldValue = new JTextField();
			this.add(jTextFieldValue, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			this.jToolBar.add(this.jTextFieldValue);
			jTextFieldValue.setMaximumSize(d=new Dimension(180,25));
			jTextFieldValue.setMinimumSize(d);
			
		}

		{
			jButtonSearch = new YButton(color);
			this.jToolBar.add(jButtonSearch);
			jButtonSearch.setIcon(MvcProperties.imageIconSearch);
			jButtonSearch.setMaximumSize(d=new Dimension(80,25));
			jButtonSearch.setMinimumSize(d);
			this.jButtonSearch.setText("Search");
		}
	}
	public JToolBar getJToolBar(){
		return this.jToolBar;
	}
	public JTable getTable(){
//		return null;
		return this.jTableContent;
	}

//	public void setTableKCWZ(){
//	this.jTableKCWZ.updateUI();
//	}

//	public void registerKCWZ(TableModel tableModel){
//	this.jTableKCWZ.setModel(tableModel);
//	this.jTableKCWZ.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//	//this.jTableKCWZ.getSelectionModel().addListSelectionListener(lsl);

//	}

	public  void setTypes(List<String> list){
		ComboBoxModel model=new DefaultComboBoxModel(list.toArray());
//		ComboBoxModel model=new DefaultComboBoxModel(new String[]{"aaa","bbb","ccc"});
		this.jComboBoxType.setModel(model);
		
	}
}