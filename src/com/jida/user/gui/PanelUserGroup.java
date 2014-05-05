package com.jida.user.gui;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.jida.MvcProperties;
import com.jida.gui.panel.ToolBarable;
import com.jida.gui.panel.YButton;
import com.jida.user.domObject.User;


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
public class PanelUserGroup extends javax.swing.JPanel implements ToolBarable {

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new PanelUser());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private PanelUserGroup panel;
	private JTextField jTextFieldUserName;
	private JComboBox jComboBoxUserType;
	private JTextField jTextFieldTel;
	private JTextField jTextFieldMobile;
	private JTextField jTextFieldAddr;
	private JTextField jTextFieldId;
	private JTable tableUsers;
	private JComboBox jComboBoxGroups;
	private JButton jButtonUserGroupInsert;
	private JButton jButtonUserGroupDelete;
	private JTable jTableUserGroup;
	private JToolBar jToolBar;
	private YButton jButtonInsert;
	private YButton jButtonDelete;
	private YButton jButtonUpdate;
	private YButton jButtonRefresh;
	private YButton jButtonImport;
	private YButton jButtonExport;
	private JComboBox jComboBoxItem;
	private JComboBox jComboBoxMode;
	private JTextField jTextFieldValue;
	private YButton jButtonSearch;
	
	public PanelUserGroup() {
		super();
		initGUI();
		this.buildToolBar();
	}
	
	private void initGUI() {
		GridBagLayout thisLayout = new GridBagLayout();
		thisLayout.rowWeights = new double[] {0,0, 0.1,0,0};
		thisLayout.rowHeights = new int[] {30,30, 200,0,180};
		thisLayout.columnWeights = new double[] {0.0, 0.1,0.1,0.1,0,0,0,0};
		thisLayout.columnWidths = new int[] {30, 70,30,70,90,50,50,50};
		//panel.setLayout(thisLayout);
		{
			this.panel=this;//new JPanel();
			setLayout(thisLayout);
			
		}
		{
			JLabel jLabel2 = new JLabel();
			this.panel.add(jLabel2, new GridBagConstraints(0, 0, 1, 1,0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			jLabel2.setText("用户名称");
			jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldUserName = new JTextField();
//			this.jTextFieldUserName.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldUserName, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel4 = new JLabel();
			this.panel.add(jLabel4, new GridBagConstraints(2, 0, 1, 1, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
			jLabel4.setText("状态");
			jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
//			jLabel4.setVisible(false);
		}
		{
			jComboBoxUserType = new JComboBox();
			this.panel.add(jComboBoxUserType, new GridBagConstraints(3, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 3, 0, 0), 0, 0));
//			this.jComboBoxUserType.setBorder(this.bevelBorder);
			jComboBoxUserType.setModel(new DefaultComboBoxModel(User.codesString));
		}
		{
			JLabel jLabel = new JLabel("电话");
			this.panel.add(jLabel, new GridBagConstraints(4, 0, 1, 1,0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldTel = new JTextField();
//			this.jTextFieldTel.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldTel, new GridBagConstraints(5, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel = new JLabel("手机");
			this.panel.add(jLabel, new GridBagConstraints(6, 0, 1, 1,0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldMobile = new JTextField();
//			this.jTextFieldMobile.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldMobile, new GridBagConstraints(7, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel = new JLabel("地址");
			this.panel.add(jLabel, new GridBagConstraints(0, 1, 1, 1,0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldAddr = new JTextField();
//			this.jTextFieldAddr.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldAddr, new GridBagConstraints(1, 1, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel = new JLabel("身份证号");
			this.panel.add(jLabel, new GridBagConstraints(3, 1, 1, 1,0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldId = new JTextField();
//			this.jTextFieldId.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldId, new GridBagConstraints(4, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
//		{
//			jButtonInsert = new YButton();
//			panel.add(this.jButtonInsert, new GridBagConstraints(5,1, 1,  1, 0.2, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
//			jButtonInsert.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-add.png")));
//		}
//		{
//			jButtonDelete = new JButton();
//			panel.add(this.jButtonDelete, new GridBagConstraints(6,1, 1,  1, 0.2, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
//			jButtonDelete.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-delete.png")));
//		}
//		{
//			jButtonUpdate = new JButton();
//			panel.add(this.jButtonUpdate, new GridBagConstraints(7,1, 1,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
//			jButtonUpdate.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-refresh.png")));
//			this.jButtonUpdate.setEnabled(true);
//		}
		{
			
			//this.getContentPane().add("North",panel);
//			jPanelUserGroup.add("North",panel);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			this.tableUsers=new JTable();
			scrollPane.getViewport().add(tableUsers,null);
			panel.add(scrollPane, new GridBagConstraints(0,2, 8,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//			getContentPane().add(this.scrollPane, new GridBagConstraints(2, 9, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		
		{
			JLabel label = new JLabel();
			this.panel.add(label, new GridBagConstraints(0, 3, 1, 1, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
			label.setText("用户组");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
//			jLabel4.setVisible(false);
		}
		{
			jComboBoxGroups = new JComboBox();
			this.panel.add(jComboBoxGroups, new GridBagConstraints(1, 3, 2, 1,0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 3, 0, 0), 0, 0));
//			this.jComboBoxGroups.setBorder(this.bevelBorder);
//			jComboBoxGroups.setModel(new DefaultComboBoxModel(User.codesString));
		}
		{
			jButtonUserGroupInsert = new JButton();
			panel.add(this.jButtonUserGroupInsert, new GridBagConstraints(3,3, 1,  1, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
			jButtonUserGroupInsert.setIcon(MvcProperties.imageIconInsert);
//			jButtonUserGroupInsert.setToolTipText("添加");
//			jButtonUserGroupInsert.setText("添加");
		}
		{
			jButtonUserGroupDelete = new JButton();
			panel.add(this.jButtonUserGroupDelete, new GridBagConstraints(4,3, 1,  1, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
			jButtonUserGroupDelete.setIcon(MvcProperties.imageIconDelete);
//			jButtonUserGroupDelete.setToolTipText("删除");
//			jButtonUserGroupDelete.setText("删除");
			
		}
		
		{
			
			//this.getContentPane().add("North",panel);
//			jPanelUserGroup.add("North",panel);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			this.jTableUserGroup=new JTable();
			scrollPane.getViewport().add(jTableUserGroup,null);
			panel.add(scrollPane, new GridBagConstraints(0,4, 8,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//			getContentPane().add(this.scrollPane, new GridBagConstraints(2, 9, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
	}
	
	public JToolBar getJToolBar(){
		return this.jToolBar;
	}
	public void buildToolBar(){
		this.jToolBar=new JToolBar();
		Color color=jToolBar.getBackground();
		Dimension d=new Dimension(60,28);
		{
			jButtonInsert = new YButton(color);
//			this.add(jButtonInsert, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			this.jToolBar.add(jButtonInsert);
			jButtonInsert.setIcon(MvcProperties.imageIconInsert);
			jButtonInsert.setMaximumSize(d);
			jButtonInsert.setMinimumSize(d);
//			this.jButtonInsert.setToolTipText("新增");
			this.jButtonInsert.setText("新增");
		}
		{
			jButtonDelete = new YButton(color);
			this.jToolBar.add(jButtonDelete);
			jButtonDelete.setIcon(MvcProperties.imageIconDelete);
			jButtonDelete.setMaximumSize(d);
			jButtonDelete.setMinimumSize(d);
//			this.jButtonDelete.setToolTipText("删除");
			this.jButtonDelete.setText("删除");
		}
		{
			jButtonUpdate = new YButton(color);
			this.jToolBar.add(jButtonUpdate);
			jButtonUpdate.setIcon(MvcProperties.imageIconUpdate);
			jButtonUpdate.setMaximumSize(d);
			jButtonUpdate.setMinimumSize(d);
//			this.jButtonUpdate.setToolTipText("更改");
			this.jButtonUpdate.setText("更改");
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
//			this.jButtonRefresh.setToolTipText("刷新");
			this.jButtonRefresh.setText("刷新");
		}
		{
			this.jToolBar.addSeparator();
		}
//		{
//			jButtonImport = new YButton(color);
//			this.jToolBar.add(jButtonImport);
//			jButtonImport.setIcon(MvcProperties.imageIconImport);
//			jButtonImport.setPreferredSize(new Dimension(30,30));
//			this.jButtonImport.setToolTipText("导入");
//		}
		{
			jButtonExport = new YButton(color);
			this.jToolBar.add(jButtonExport);
			jButtonExport.setIcon(MvcProperties.imageIconExport);
			jButtonExport.setMaximumSize(d);
			jButtonExport.setMinimumSize(d);
//			this.jButtonExport.setToolTipText("导出");
			this.jButtonExport.setText("导出");
		}
		//delete 20120217
		/*{
			this.jToolBar.addSeparator();
		}
		{
			JLabel jLabel3 = new JLabel();
			
			this.jToolBar.add(jLabel3);
			jLabel3.setText("\u641c\u7d22");
			jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			ComboBoxModel jComboBoxModeModel = new DefaultComboBoxModel(
				TempretureController.titles);
			jComboBoxItem = new JComboBox();
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
			jButtonSearch.setPreferredSize(new Dimension(30,30));
			this.jButtonSearch.setToolTipText("搜索");
		}*/
		//end
		
	}
	public int getSelectedIndex(){
		return this.tableUsers.getSelectedRow();
	}
	public void setSelectedIndex(int index){
		this.tableUsers.changeSelection(index, -1, true, false);
	}
	
	public void register(ActionListener als[]){
		YButton buttons[]={this.jButtonInsert,this.jButtonDelete,
				this.jButtonUpdate,this.jButtonSearch,
				this.jButtonRefresh,this.jButtonImport,this.jButtonExport};
		for(int i=0;i<als.length;i++){
			buttons[i].addActionListener(als[i]);
		}
		
//		this.jTableContent.getSelectionModel().addListSelectionListener(lsl);
		
	}
	public void registerTable(TableModel model,ListSelectionListener lsl){
		this.tableUsers.setModel(model);
		this.tableUsers.getSelectionModel().addListSelectionListener(lsl);
		this.tableUsers.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void setTableModelPrivilege(TableModel model){
		this.tableUsers.setModel(model);
		this.tableUsers.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public void setContent(){
		this.tableUsers.updateUI();
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
	public int getJComboBoxMode() {
		return jComboBoxMode.getSelectedIndex();
	}

	public void setJComboBoxMode(int index) {
		jComboBoxMode.setSelectedIndex(index);
	}
	public JTable getTable(){
		return this.tableUsers;
	}
}
