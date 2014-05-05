package com.jida.user.gui;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import com.jida.user.AuthModel;
import com.jida.user.domObject.Group;
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
public class PanelUser extends javax.swing.JPanel implements ToolBarable {

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

	private Map<String ,List<String>> map;
	private PanelUser panel;
	private JTextField jTextFieldUserName;
	private JComboBox jComboBoxUserType;
	private JTextField jTextFieldTel;
	private JTextField jTextFieldMobile;
	private JTextField jTextFieldAddr;
	private JTextField jTextFieldId;
	private JTable tableUsers;
	private JComboBox jComboBoxGroups;
	private YButton jButtonUserGroupInsert;
	private YButton jButtonUserGroupDelete;
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
//	private JTextField jTextFieldProvince;
//	private JTextField jTextFieldCity;
	private JComboBox jComboBoxProvince;
	private JComboBox jComboBoxCity;
	private JTextField jTextFieldPassword;
	private YButton jButtonChangePassword;
	private JTextField jTextFieldPasswordNew;
	private JTextField jTextFieldPPostCode;
	public static String name="User-Group";
	
	public PanelUser() {
		super();
		initGUI();
		this.buildToolBar();
		
		map=MvcProperties.initParam(MvcProperties.province);
//		System.out.println(map);
		if(map!=null){
			this.setJComboBoxProvinces(map.keySet());
			this.setJComboBoxCities(map.get((String)this.jComboBoxProvince.getSelectedItem()));
		}
		register();
	}
	
	private void initGUI() {
		GridBagLayout thisLayout = new GridBagLayout();
		thisLayout.rowWeights = new double[] {0.0,0.0, 0.1,0,0};
		thisLayout.rowHeights = new int[] {30,30, 200,40,180};
		thisLayout.columnWeights = new double[] {0.0, 0.0,0,0.0,0,0,0,0,0,0,1};
		thisLayout.columnWidths = new int[] {50, 100,50,100,50,100,50,70,50,170,0};
		//panel.setLayout(thisLayout);
		{
			this.panel=this;//new JPanel();
			setLayout(thisLayout);

		}
		{
			JLabel jLabel2 = new JLabel();
			this.panel.add(jLabel2, new GridBagConstraints(0, 0, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			jLabel2.setText("User Name");
			jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldUserName = new JTextField();
//			this.jTextFieldUserName.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldUserName, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel4 = new JLabel();
			this.panel.add(jLabel4, new GridBagConstraints(2, 0, 1, 1, 0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
			jLabel4.setText("State");
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
			JLabel jLabel = new JLabel("Tel");
			this.panel.add(jLabel, new GridBagConstraints(4, 0, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldTel = new JTextField();
//			this.jTextFieldTel.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldTel, new GridBagConstraints(5, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel = new JLabel("Mobile");
			this.panel.add(jLabel, new GridBagConstraints(6, 0, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldMobile = new JTextField();
//			this.jTextFieldMobile.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldMobile, new GridBagConstraints(7, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel = new JLabel("ZIP");
			this.panel.add(jLabel, new GridBagConstraints(8, 0, 1, 1,0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldPPostCode =new JTextField(); //new javax.swing.JPasswordField();
//			this.jTextFieldId.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldPPostCode, new GridBagConstraints(9, 0, 1, 1, 1, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel = new JLabel("Province");
			this.panel.add(jLabel, new GridBagConstraints(0, 1, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jComboBoxProvince = new JComboBox();
//			this.jTextFieldAddr.setBorder(this.bevelBorder);
			this.panel.add(jComboBoxProvince, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel = new JLabel("City");
			this.panel.add(jLabel, new GridBagConstraints(2, 1, 1, 1,0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jComboBoxCity = new JComboBox();
//			this.jTextFieldAddr.setBorder(this.bevelBorder);
			this.panel.add(jComboBoxCity, new GridBagConstraints(3, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel = new JLabel("Address");
			this.panel.add(jLabel, new GridBagConstraints(4, 1, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldAddr = new JTextField();
//			this.jTextFieldAddr.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldAddr, new GridBagConstraints(5, 1, 3, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
		{
			JLabel jLabel = new JLabel("Corp");
			this.panel.add(jLabel, new GridBagConstraints(8, 1, 1, 1,0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldId = new JTextField();
//			this.jTextFieldId.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldId, new GridBagConstraints(9, 1, 1, 1, 1, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
			initId();
		}
		{
			this.jTextFieldPassword = new JTextField();
//			this.jTextFieldId.setBorder(this.bevelBorder);
//			this.panel.add(jTextFieldId, new GridBagConstraints(9, 1, 1, 1, 1, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
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
			panel.add(scrollPane, new GridBagConstraints(0,2, thisLayout.columnWidths.length,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//			getContentPane().add(this.scrollPane, new GridBagConstraints(2, 9, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		//Delete 20120218
		/*{
			JLabel label = new JLabel();
			this.panel.add(label, new GridBagConstraints(0, 3, 1, 1, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
			label.setText("用户组");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
//			jLabel4.setVisible(false);
		}
		{
			jComboBoxGroups = new JComboBox();
			this.panel.add(jComboBoxGroups, new GridBagConstraints(1, 3, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 3, 0, 0), 0, 0));
//			this.jComboBoxGroups.setBorder(this.bevelBorder);
//			jComboBoxGroups.setModel(new DefaultComboBoxModel(User.codesString));
		}
		{
			jButtonUserGroupInsert = new YButton();
			jButtonUserGroupInsert.setIcon(MvcProperties.imageIconInsert);		
			jButtonUserGroupInsert.setPreferredSize(new Dimension(60,30));
			panel.add(this.jButtonUserGroupInsert, new GridBagConstraints(3,3, 1,  1, 0.2, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			this.jButtonUserGroupInsert.setToolTipText("新增组");
			this.jButtonUserGroupInsert.setText("新增");
		}
		{
			jButtonUserGroupDelete = new YButton();			
			jButtonUserGroupDelete.setIcon(MvcProperties.imageIconDelete);
			jButtonUserGroupDelete.setPreferredSize(new Dimension(60,30));
			panel.add(this.jButtonUserGroupDelete, new GridBagConstraints(4,3, 1,  1, 0.2, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			this.jButtonUserGroupDelete.setToolTipText("删除组");
			this.jButtonUserGroupDelete.setText("删除");
		}*/
		//end
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			this.jTableUserGroup=new JTable();
			scrollPane.getViewport().add(jTableUserGroup,null);
			//update 20120218
			panel.add(scrollPane, new GridBagConstraints(0, 3, thisLayout.columnWidths.length, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			//end
//			getContentPane().add(this.scrollPane, new GridBagConstraints(2, 9, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
	}
	
	public JToolBar getJToolBar(){
		return this.jToolBar;
	}
	public void buildToolBar(){
		this.jToolBar=new JToolBar();
		Color color=jToolBar.getBackground();
		Dimension d=new Dimension(80,28);
		{
			jButtonInsert = new YButton();
//			this.add(jButtonInsert, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			this.jToolBar.add(jButtonInsert);
			jButtonInsert.setIcon(MvcProperties.imageIconInsert);
			jButtonInsert.setMaximumSize(d);
			jButtonInsert.setMinimumSize(d);
//			this.jButtonInsert.setToolTipText("新增");
			this.jButtonInsert.setText("New");
		}
		{
			jButtonDelete = new YButton();
			this.jToolBar.add(jButtonDelete);
			jButtonDelete.setIcon(MvcProperties.imageIconDelete);
			jButtonDelete.setMaximumSize(d);
			jButtonDelete.setMinimumSize(d);
//			this.jButtonDelete.setToolTipText("删除");
			this.jButtonDelete.setText("Delete");
		}
		{
			jButtonUpdate = new YButton();
			this.jToolBar.add(jButtonUpdate);
			jButtonUpdate.setIcon(MvcProperties.imageIconUpdate);
			jButtonUpdate.setMaximumSize(d);
			jButtonUpdate.setMinimumSize(d);
//			this.jButtonUpdate.setToolTipText("更改");
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
//			this.jButtonRefresh.setToolTipText("用户刷新");
			this.jButtonRefresh.setText("Refresh");
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
			this.jButtonExport.setText("Export");
		}
		{
			this.jToolBar.addSeparator();
		}
		{
			JLabel jLabel3 = new JLabel();
			
			this.jToolBar.add(jLabel3);
			jLabel3.setText("New Password");
			jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			jTextFieldPasswordNew=new JTextField();
			this.jToolBar.add(jTextFieldPasswordNew);
			d=new Dimension(150,30);
			this.jTextFieldPasswordNew.setMaximumSize(d);
			this.jTextFieldPasswordNew.setMinimumSize(d);
//			jButtonChangePassword.setIcon(MvcProperties.imageIconSet);
//			jTextFieldPasswordNew.setPreferredSize(new Dimension(80,30));
			
		}
		{
			jButtonChangePassword = new YButton(color);
			this.jButtonChangePassword.setText("Change Password");
			this.jToolBar.add(jButtonChangePassword);
			jButtonChangePassword.setIcon(MvcProperties.imageIconSet);
			jButtonInsert.setMaximumSize(d=new Dimension(90,28));
			jButtonInsert.setMinimumSize(d);
//			this.jButtonChangePassword.setToolTipText("更改密码");
		}
		//Delete 20120217
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
	public int getSelectedIndexGroup(){
		return this.jTableUserGroup.getSelectedRow();
	}
	
	public void register(ActionListener als[]){
		YButton buttons[]={this.jButtonInsert,this.jButtonDelete,
				this.jButtonUpdate,
				this.jButtonRefresh,
				//delete 20120217
//				this.jButtonSearch,
				//end
//				this.jButtonImport,
				this.jButtonExport,
				this.jButtonChangePassword,
				/*this.jButtonUserGroupInsert,
				this.jButtonUserGroupDelete*/};
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
	
	public void registerTableModelUserGroup(TableModel model){
		this.jTableUserGroup.setModel(model);
		this.jTableUserGroup.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public void setContent(){
		this.tableUsers.updateUI();
	}
	public void setContentGroup(){
		this.jTableUserGroup.updateUI();
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
	
	public String getPassword(){
		return this.jTextFieldPassword.getText();
		
	}
	public void setPassword(String password){
		this.jTextFieldPassword.setText(password);
	}
	public String getPasswordNew(){
		String s=this.jTextFieldPasswordNew.getText();
		return s;
		
	}
	public void setPasswordNew(String password){
		this.jTextFieldPasswordNew.setText(password);
	}
	public JTable getTable(){
		return this.tableUsers;
	}
	public User getUser(){
		String t1=this.jTextFieldId.getText();
		if(t1==null || t1.equals("")){
			JOptionPane.showMessageDialog(this, "未指定厂商名!");
			return null;
		}
		User user=new User();
		user.setAddr(this.jTextFieldAddr.getText());
		user.setT1(t1);
		user.setMobile(this.jTextFieldMobile.getText());
		user.setTel(this.jTextFieldTel.getText());
		user.setName(this.jTextFieldUserName.getText());
//		user.setPassword("000000");
		user.setPostCode(this.jTextFieldPPostCode.getText());
		user.setProvince((String)this.jComboBoxProvince.getSelectedItem());
		user.setCity((String)this.jComboBoxCity.getSelectedItem());
		user.setState((byte)this.jComboBoxUserType.getSelectedIndex());
		
		String s=this.jTextFieldPassword.getText();
		if(s==null ||s.equals("")){
			s="000000";
		}
		user.setPassword(s);
		
		return user;
	}
	public void setUser(User user){
		this.jTextFieldAddr.setText(user.getAddr());
		this.jTextFieldId.setText(user.getT1());
		this.jTextFieldMobile.setText(user.getMobile());
		this.jTextFieldUserName.setText(user.getName());
//		u.setPassword("000000");
		this.jTextFieldPPostCode.setText(user.getPostCode());
		this.jComboBoxProvince.setSelectedItem(user.getProvince());
		this.jComboBoxCity.setSelectedItem(user.getCity());
		this.jTextFieldTel.setText(user.getTel());
		this.jComboBoxUserType.setSelectedIndex(user.getState());
		this.jTextFieldPassword.setText(user.getPassword());
	}
	
	public void setGroups(List<Group> list){
		ComboBoxModel model=new DefaultComboBoxModel(list.toArray());
		this.jComboBoxGroups.setModel(model);
		
	}
	public Group getGroup(){
		return (Group)this.jComboBoxGroups.getSelectedItem();
	}
	public void setJComboBoxProvinces(Set set) {
		ComboBoxModel model=new DefaultComboBoxModel(set.toArray());
		this.jComboBoxProvince.setModel(model);
	}

	public void setJComboBoxCities(List<String> l) {
		ComboBoxModel model=new DefaultComboBoxModel(l.toArray());
		this.jComboBoxCity.setModel(model);
	}
	ItemListener il=new ItemListener(){
		public void itemStateChanged(ItemEvent e){
			String s=(String)jComboBoxProvince.getSelectedItem();
			setJComboBoxCities(map.get(s));
		}
	};
	public void register() {
//		for(int i = 0; i < this.tempArr.length; ++i) {
//			this.tempArr[i].addFocusListener(this.fl);
//		}
//		this.jTextAreaRemark.addFocusListener(this.textAreaFL);
		this.jComboBoxProvince.addItemListener(il);
	}

	public void initId(){
		AuthModel model=AuthModel.getInstance();
		User user=model.getUser();
		if(user!=null && !user.hasPrivilege("SuperPrivilege")){
			this.jTextFieldId.setText(user.getT1());
			this.jTextFieldId.setEditable(false);
		}
	}
}
