package com.jida.product.gui;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ComboBoxModel;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.jida.MvcProperties;
import com.jida.gui.panel.ToolBarable;
import com.jida.gui.panel.YButton;
import com.jida.product.data.ProductType;
import com.jida.user.domObject.Privilege;


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
public class PanelProductType extends javax.swing.JPanel implements ToolBarable {
	private JToolBar jToolBar;
	private JLabel jLabel2;
	private YButton jButtonSearch;
	private YButton jButtonRefresh;
	private JComboBox jComboBoxItem;
	private JTextField jTextFieldValue;
	private JComboBox jComboBoxMode;
	private JLabel jLabel3;
	private YButton jButtonUpdate;
	private YButton jButtonDelete;
	private YButton jButtonInsert;
	private JLabel jLabel4;
	private JLabel jLabel8;
	private YButton jButtonExport;
	private YButton jButtonImport;
	
	private JTextField jTextFieldPrivilege;
	private JTextField jTextFieldDesc;
	
	private JTable jTableContent;
	public static String name="物品类型管理";
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		PanelProductType inst = new PanelProductType();
		inst.setVisible(true);
	}
	
	public PanelProductType() {
		super();
		initGUI();
		buildToolBar();
	}
	
	private void initGUI() {
		try {
			
			GridBagLayout thisLayout = new GridBagLayout();
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(893, 113));
			thisLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.1, 0.1};
			thisLayout.rowHeights = new int[] {15, 15, 7, 7, 7};
			thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
			thisLayout.columnWidths = new int[] {50, 50, 50, 45, 56, 117, 50, 203, 44, 50, 50, 20};
			
			{
				JLabel jLabel2 = new JLabel();
				this.add(jLabel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabel2.setText("类型名称");
				jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTextFieldPrivilege = new JTextField();
				this.add(jTextFieldPrivilege, new GridBagConstraints(1, 1, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				JLabel jLabel1 = new JLabel();
				this.add(jLabel1, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabel1.setText("描述");
				jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTextFieldDesc = new JTextField();
				this.add(jTextFieldDesc, new GridBagConstraints(7, 1, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
//				ListModel jListContentModel = new DefaultComboBoxModel(
//					new String[] { "Item One", "Item Two" });
//				jListContent = new JList();
//				add(jListContent, new GridBagConstraints(0, 2, 4, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//				jListContent.setModel(jListContentModel);
				this.jTableContent=new JTable();
				JScrollPane scrollPane=new JScrollPane();
				scrollPane.getViewport().add(this.jTableContent,null);
				this.add(scrollPane, new GridBagConstraints(0, 2, 13, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
	
//			pack();
			//setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setContent(List<Privilege> list){
		//this.jListContent.setListData(list.toArray());
		this.jTableContent.updateUI();
	}
	
	public String getProductType(){
		return this.jTextFieldPrivilege.getText();
	}
	public void setProductType(String privilege){
		this.jTextFieldPrivilege.setText(privilege);
	}
	public String getDesc(){
		return this.jTextFieldDesc.getText();
	}
	public void setDesc(String desc){
		this.jTextFieldDesc.setText(desc);
	}
	public int getSelectedIndex(){
		return this.jTableContent.getSelectedRow();
	}
	public void setSelectedIndex(int index){
		this.jTableContent.changeSelection(index, -1, true, false);
	}
	
	public void register(ActionListener als[]){
		boolean state[]={true,true,true,true,true};
		JButton buttons[]={
//				this.jButtonInsert,this.jButtonDelete,
				this.jButtonUpdate,
				this.jButtonSearch,
				this.jButtonRefresh};
		for(int i=0;i<als.length;i++){
			buttons[i].setEnabled(state[i]);
			buttons[i].addActionListener(als[i]);
		}
		
//		this.jTableContent.getSelectionModel().addListSelectionListener(lsl);
		
	}
	public void registerTable(TableModel model,ListSelectionListener lsl){
		this.jTableContent.setModel(model);
		this.jTableContent.getSelectionModel().addListSelectionListener(lsl);
		this.jTableContent.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	
	public void setContent(){
		this.jTableContent.updateUI();
	}
	
	public String getValue(){
		return this.jTextFieldValue.getText();
		
	}
	public String getItem(){
		return (String)this.jComboBoxItem.getSelectedItem();
	}
	public int getMode(){
		return this.jComboBoxMode.getSelectedIndex();
	}
	public JToolBar getJToolBar(){
		return this.jToolBar;
	}
	public void buildToolBar(){
		this.jToolBar=new JToolBar();
		Color color=jToolBar.getBackground();
//		{
//			jButtonInsert = new YButton(color);
////			this.add(jButtonInsert, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//			this.jToolBar.add(jButtonInsert);
//			jButtonInsert.setIcon(MvcProperties.imageIconInsert);
//			this.jButtonInsert.setToolTipText("新增");
//			this.jButtonInsert.setText("新增");
//			this.jButtonInsert.setPreferredSize(new Dimension(60,30));
//		}
//		{
//			jButtonDelete = new YButton(color);
//			this.jToolBar.add(jButtonDelete);
//			jButtonDelete.setIcon(MvcProperties.imageIconDelete);
//			this.jButtonDelete.setToolTipText("删除");
//			this.jButtonDelete.setText("删除");
//			this.jButtonDelete.setPreferredSize(new Dimension(60,30));
//		}
		{
			jButtonUpdate = new YButton(color);
			this.jToolBar.add(jButtonUpdate);
			jButtonUpdate.setIcon(MvcProperties.imageIconUpdate);
			this.jButtonUpdate.setToolTipText("更改");
			this.jButtonUpdate.setText("更改");
			this.jButtonUpdate.setPreferredSize(new Dimension(60,30));
		}
		{
			this.jToolBar.addSeparator();
		}
		
		{
			jButtonRefresh = new YButton(color);
			this.jToolBar.add(jButtonRefresh);
			jButtonRefresh.setIcon(MvcProperties.imageIconRefresh);
			this.jButtonRefresh.setToolTipText("刷新");
			this.jButtonRefresh.setText("刷新");
			this.jButtonRefresh.setPreferredSize(new Dimension(60,30));
		}
		{
			this.jToolBar.addSeparator();
		}
//		{
//			jButtonImport = new YButton(color);
//			this.jToolBar.add(jButtonImport);
//			jButtonImport.setIcon(MvcProperties.imageIconImport);
//			this.jButtonImport.setToolTipText("导入");
//			this.jButtonImport.setToolTipText("导入");
//			this.jButtonImport.setPreferredSize(new Dimension(60,30));
//		}
//		{
//			jButtonExport = new YButton(color);
//			this.jToolBar.add(jButtonExport);
//			jButtonExport.setIcon(MvcProperties.imageIconExport);
//			this.jButtonExport.setToolTipText("导出");
//			this.jButtonExport.setText("导出");
//			this.jButtonExport.setPreferredSize(new Dimension(60,30));
//		}
//		{
//			this.jToolBar.addSeparator();
//		}
		{
			jLabel3 = new JLabel();
			
			this.jToolBar.add(jLabel3);
			jLabel3.setText("\u641c\u7d22");
			jLabel3.setPreferredSize(new Dimension(80,30));
			jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			ComboBoxModel jComboBoxModeModel = new DefaultComboBoxModel(
				Privilege.titles);
			jComboBoxItem = new JComboBox();
			this.jComboBoxItem.setPreferredSize(new Dimension(60,30));
			jComboBoxItem.setModel(jComboBoxModeModel);
			this.jToolBar.add(this.jComboBoxItem);
		}
		{
			ComboBoxModel jComboBoxItemModel = new DefaultComboBoxModel(
				new String[] { "精确匹配", "模糊匹配" });
			jComboBoxMode = new JComboBox();
			this.jToolBar.add(this.jComboBoxMode);
			
			jComboBoxMode.setModel(jComboBoxItemModel);
		}
		{
			jTextFieldValue = new JTextField();
//			this.add(jTextFieldValue, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			this.jToolBar.add(this.jTextFieldValue);
		}
		
		{
			jButtonSearch = new YButton(color);
			this.jToolBar.add(jButtonSearch);
			jButtonSearch.setIcon(MvcProperties.imageIconSearch);
			this.jButtonSearch.setText("搜索");
			this.jButtonSearch.setToolTipText("搜索");
			this.jButtonSearch.setPreferredSize(new Dimension(80,30));
		}
		
	}
	
	public ProductType get(){
		ProductType pt=new ProductType();
		String name=this.jTextFieldPrivilege.getText();
		if(name==null || name.equals("")){
			JOptionPane.showMessageDialog(this, "Type name cannot be null");
			return null;
		}
		pt.setPtName(name);
		pt.setPtBrief(this.jTextFieldDesc.getText());
		return pt;
	}
	
	public void set(ProductType pt){
		this.jTextFieldPrivilege.setText(pt.getPtName());
		this.jTextFieldDesc.setText(pt.getPtBrief());
	}
	
}

