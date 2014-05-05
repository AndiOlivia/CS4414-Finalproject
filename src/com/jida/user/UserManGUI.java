package com.jida.user;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

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

public class UserManGUI extends javax.swing.JFrame {

	private static final long serialVersionUID = 0L;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JTextField jTextFieldUserName;
	private JComboBox jComboBoxUserType;
	private JPanel panel;
	private JButton jButtonInsert;
	private JButton jButtonDelete;
	private JButton jButtonUpdate;
	private JScrollPane scrollPane;
	private JTable tableUsers;
	private JLabel jLabelStatus;
	private JTextField jTextFieldTel;
	private JTextField jTextFieldMobile;
	private JTextField jTextFieldAddr;
	private JTextField jTextFieldId;
	private Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
	
	private JTextField jTextFieldGroupName;
	private JTextField jTextFieldGroupDesc;
	private JTable jTableGroup;
	private JButton jButtonGroupInsert;
	private JButton jButtonGroupDelete;
	private JButton jButtonGroupUpdate;
	
	private JButton jButtonUserGroupInsert;
	private JButton jButtonUserGroupDelete;
	private JComboBox jComboBoxGroups;
	private JTable jTableUserGroup;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		new UserManGUI("test");
	}
	
	public UserManGUI(String str) {
		super(str);
		initGUI();
		setVisible(true);
	}
	
	private void initGUI() {
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		JTabbedPane jTabbedPane =new JTabbedPane();
		JPanel jPanelUserGroup=new JPanel();
		jPanelUserGroup.setLayout(new BorderLayout());
		
		try {
			this.setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("images/group.png")).getImage());
			GridBagLayout thisLayout = new GridBagLayout();
			thisLayout.rowWeights = new double[] {0.0,0.0, 0.1,0,0};
			thisLayout.rowHeights = new int[] {7,7, 200,7,100};
			thisLayout.columnWeights = new double[] {0.0, 0.1,0.1,0.1,0,0,0,0};
			thisLayout.columnWidths = new int[] {30, 70,30,70,90,50,50,50};
			//panel.setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				this.panel=new JPanel();
				panel.setLayout(thisLayout);
				
			}
			{
				jLabel2 = new JLabel();
				this.panel.add(jLabel2, new GridBagConstraints(0, 0, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jLabel2.setText("用户名称");
				jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				this.jTextFieldUserName = new JTextField();
				this.jTextFieldUserName.setBorder(this.bevelBorder);
				this.panel.add(jTextFieldUserName, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
			}
			{
				jLabel4 = new JLabel();
				this.panel.add(jLabel4, new GridBagConstraints(2, 0, 1, 1, 0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
				jLabel4.setText("状态");
				jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
//				jLabel4.setVisible(false);
			}
			{
				jComboBoxUserType = new JComboBox();
				this.panel.add(jComboBoxUserType, new GridBagConstraints(3, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 3, 0, 0), 0, 0));
				this.jComboBoxUserType.setBorder(this.bevelBorder);
				jComboBoxUserType.setModel(new DefaultComboBoxModel(User.codesString));
			}
			{
				JLabel jLabel = new JLabel("电话");
				this.panel.add(jLabel, new GridBagConstraints(4, 0, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//				jLabel2.setText("用户名称");
				jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				this.jTextFieldTel = new JTextField();
				this.jTextFieldTel.setBorder(this.bevelBorder);
				this.panel.add(jTextFieldTel, new GridBagConstraints(5, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
			}
			{
				JLabel jLabel = new JLabel("手机");
				this.panel.add(jLabel, new GridBagConstraints(6, 0, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//				jLabel2.setText("用户名称");
				jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				this.jTextFieldMobile = new JTextField();
				this.jTextFieldMobile.setBorder(this.bevelBorder);
				this.panel.add(jTextFieldMobile, new GridBagConstraints(7, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
			}
			{
				JLabel jLabel = new JLabel("地址");
				this.panel.add(jLabel, new GridBagConstraints(0, 1, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//				jLabel2.setText("用户名称");
				jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				this.jTextFieldAddr = new JTextField();
				this.jTextFieldAddr.setBorder(this.bevelBorder);
				this.panel.add(jTextFieldAddr, new GridBagConstraints(1, 1, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
			}
			{
				JLabel jLabel = new JLabel("身份证号");
				this.panel.add(jLabel, new GridBagConstraints(3, 1, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//				jLabel2.setText("用户名称");
				jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				this.jTextFieldId = new JTextField();
				this.jTextFieldId.setBorder(this.bevelBorder);
				this.panel.add(jTextFieldId, new GridBagConstraints(4, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
			}
			{
				jButtonInsert = new JButton();
				panel.add(this.jButtonInsert, new GridBagConstraints(5,1, 1,  1, 0.2, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
				jButtonInsert.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-add.png")));
			}
			{
				jButtonDelete = new JButton();
				panel.add(this.jButtonDelete, new GridBagConstraints(6,1, 1,  1, 0.2, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
				jButtonDelete.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-delete.png")));
			}
			{
				jButtonUpdate = new JButton();
				panel.add(this.jButtonUpdate, new GridBagConstraints(7,1, 1,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
				jButtonUpdate.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-refresh.png")));
				this.jButtonUpdate.setEnabled(true);
			}
			{
				
				//this.getContentPane().add("North",panel);
//				jPanelUserGroup.add("North",panel);
			}
			{
				this.scrollPane = new JScrollPane();
				this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				this.tableUsers=new JTable();
				this.scrollPane.getViewport().add(tableUsers,null);
				panel.add(this.scrollPane, new GridBagConstraints(0,2, 8,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//				getContentPane().add(this.scrollPane, new GridBagConstraints(2, 9, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
			
			{
				JLabel label = new JLabel();
				this.panel.add(label, new GridBagConstraints(0, 3, 1, 1, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
				label.setText("用户组");
				label.setHorizontalAlignment(SwingConstants.RIGHT);
//				jLabel4.setVisible(false);
			}
			{
				jComboBoxGroups = new JComboBox();
				this.panel.add(jComboBoxGroups, new GridBagConstraints(1, 3, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 3, 0, 0), 0, 0));
				this.jComboBoxGroups.setBorder(this.bevelBorder);
//				jComboBoxGroups.setModel(new DefaultComboBoxModel(User.codesString));
			}
			{
				jButtonUserGroupInsert = new JButton();
				panel.add(this.jButtonUserGroupInsert, new GridBagConstraints(3,3, 1,  1, 0.2, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
				jButtonUserGroupInsert.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-add.png")));
			}
			{
				jButtonUserGroupDelete = new JButton();
				panel.add(this.jButtonUserGroupDelete, new GridBagConstraints(4,3, 1,  1, 0.2, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
				jButtonUserGroupDelete.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-delete.png")));
			}
			
			{
				
				//this.getContentPane().add("North",panel);
//				jPanelUserGroup.add("North",panel);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				this.jTableUserGroup=new JTable();
				scrollPane.getViewport().add(jTableUserGroup,null);
				panel.add(scrollPane, new GridBagConstraints(0,4, 8,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//				getContentPane().add(this.scrollPane, new GridBagConstraints(2, 9, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
			
			
			{
				jTabbedPane.add("用户组管理",panel);
			}
			{
				JPanel jPanelGroup=new JPanel();
				GridBagLayout gbl=new GridBagLayout();
				gbl.columnWeights=new double[]{0,0.1,0,0.1,0.1,0.1};
				gbl.columnWidths=new int[]{100,100,100,100,100,100};
				gbl.rowHeights=new int[]{15,15,15};
				gbl.rowWeights=new double[]{0,0,0.1};
				jPanelGroup.setLayout(gbl);
				{
					JLabel jLabelGroupName=new JLabel("组名称");
					jLabelGroupName.setHorizontalAlignment(JLabel.RIGHT);
					jPanelGroup.add(jLabelGroupName, new GridBagConstraints(0,0, 1,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldGroupName=new JTextField();
					jPanelGroup.add(this.jTextFieldGroupName, new GridBagConstraints(1,0, 1,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					JLabel jLabelGroupDesc=new JLabel("描述");
					jLabelGroupDesc.setHorizontalAlignment(JLabel.RIGHT);
					jPanelGroup.add(jLabelGroupDesc, new GridBagConstraints(2,0, 1,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextFieldGroupDesc=new JTextField();
					jPanelGroup.add(this.jTextFieldGroupDesc, new GridBagConstraints(3,0, 2,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jButtonGroupInsert = new JButton("插入");
					jPanelGroup.add(this.jButtonGroupInsert, new GridBagConstraints(0,1, 1,  1, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jButtonGroupInsert.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-add.png")));
//					this.jButtonGroupInsert.setEnabled(false);
				}
				{
					jButtonGroupDelete = new JButton("删除");
					jPanelGroup.add(this.jButtonGroupDelete, new GridBagConstraints(1,1, 1,  1, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jButtonGroupDelete.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-delete.png")));
//					this.jButtonGroupDelete.setEnabled(false);
				}
				{
					jButtonGroupUpdate = new JButton("更新");
					jPanelGroup.add(this.jButtonGroupUpdate, new GridBagConstraints(2,1, 1,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jButtonGroupUpdate.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/database-refresh.png")));
//					this.jButtonGroupUpdate.setEnabled(false);
				}	
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					jTableGroup=new JTable();
					scrollPane.getViewport().add(jTableGroup,null);
//					jPanelGroup.add(scrollPane);
					jPanelGroup.add(scrollPane, new GridBagConstraints(0,2, 6,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//					getContentPane().add(this.scrollPane, new GridBagConstraints(2, 9, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTabbedPane.add("组管理",jPanelGroup);
					this.getContentPane().add(jTabbedPane);
				}
			}
			{
				this.jLabelStatus=new JLabel("就绪");
				this.getContentPane().add("South",this.jLabelStatus);
			}
			pack();
			this.setSize(800, 500);
			this.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		register();
	}
	public void register(){
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
				System.exit(0);
			}
		});
	}
	public void setType(String type){
		this.jComboBoxUserType.setSelectedItem(type);
	}
	public String getType(){
		return (String)this.jComboBoxUserType.getSelectedItem();
	}

	public void setUserName(String name){
		this.jTextFieldUserName.setText(name);
	}
	public String getUserName(){
		return this.jTextFieldUserName.getText();
	}
	
	public void register(ActionListener[] als,ListSelectionListener lsl,TableModel tableModel){
		JButton [] buttons={this.jButtonInsert,this.jButtonDelete,this.jButtonUpdate};
		for(int i=0;i<als.length && i<buttons.length;i++){
			buttons[i].addActionListener(als[i]);
		}
		this.tableUsers.setModel(tableModel);
		this.tableUsers.getSelectionModel().addListSelectionListener(lsl);
		this.tableUsers.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public void registerGroup(ActionListener[] als,ListSelectionListener lsl,TableModel tableModel){
		JButton [] buttons={this.jButtonGroupInsert,this.jButtonGroupDelete,this.jButtonGroupUpdate};
		for(int i=0;i<als.length && i<buttons.length;i++){
			buttons[i].addActionListener(als[i]);
		}
		this.jTableGroup.setModel(tableModel);
		this.jTableGroup.getSelectionModel().addListSelectionListener(lsl);
		this.jTableGroup.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public void registerUserGroup(ActionListener[] als,ListSelectionListener lsl,TableModel tableModel){
		JButton [] buttons={this.jButtonUserGroupInsert,this.jButtonUserGroupDelete};
		for(int i=0;i<als.length && i<buttons.length;i++){
			buttons[i].addActionListener(als[i]);
		}
		this.jTableUserGroup.setModel(tableModel);
		this.jTableUserGroup.getSelectionModel().addListSelectionListener(lsl);
		this.jTableUserGroup.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void disposeGUI(){
		this.dispose();
	}
	public int getSelectedIndex(){
		return this.tableUsers.getSelectedRow();
	}
	public void setSelectedIndex(int index){
		this.tableUsers.changeSelection(index,-1, true, false);
	}
	public void setContents(){
		this.tableUsers.updateUI();
	}
	public int getSelectedIndexGroup(){
		return this.jTableGroup.getSelectedRow();
	}
	public void setSelectedIndexGroup(int index){
		this.jTableGroup.changeSelection(index,-1, true, false);
	}
	public void setContentsGroup(){
		this.jTableGroup.updateUI();
	}
	public int getSelectedIndexUserGroup(){
		return this.jTableUserGroup.getSelectedRow();
	}
	public void setSelectedIndexUserGroup(int index){
		this.jTableUserGroup.changeSelection(index,-1, true, false);
	}
	public void setContentUserGroup(){
		this.jTableUserGroup.updateUI();
	}
//	private int getInteger(String s) throws Exception {
//		return Integer.parseInt(s);
//	}
	
	private float getFloat(String s) throws Exception {
		return Float.parseFloat(s);
	}
	public void showStatus(Object obj){
		this.jLabelStatus.setText(obj==null?"null":obj.toString());
	}
	public Group getUserGroup(){
		return (Group)this.jComboBoxGroups.getSelectedItem();
	}
	public void setUserGroup(Group  group){
		this.jComboBoxGroups.setSelectedItem(group);
	}
	public void setUserGroup(List<Group> list){
		
		ComboBoxModel model=new DefaultComboBoxModel(list.toArray());
		this.jComboBoxGroups.setModel(model);
	}
	
	public String getGroupName(){
		return this.jTextFieldGroupName.getText();
	}
	public void setGroupName(String name){
		this.jTextFieldGroupName.setText(name);
	}
	public String getGroupDesc(){
		return this.jTextFieldGroupDesc.getText();
	}
	public void setGroupDesc(String name){
		this.jTextFieldGroupDesc.setText(name);
	}
	public String getUserState(){
		return (String)this.jComboBoxUserType.getSelectedItem();
	}
	public void setUserState(String state){
		this.jComboBoxUserType.setSelectedItem(state);
	}
	public String getTel(){
		return this.jTextFieldTel.getText();
	}
	public void setTel(String tel){
		this.jTextFieldTel.setText(tel);
	}
	public String getMobile(){
		return this.jTextFieldMobile.getText();
	}
	public void setMobile(String mobile){
		this.jTextFieldMobile.setText(mobile);
	}
	public String getAddr(){
		return this.jTextFieldAddr.getText();
	}
	public void setAddr(String addr){
		this.jTextFieldAddr.setText(addr);
	}
	public String getId(){
		return this.jTextFieldId.getText();
	}
	public void setId(String id){
		this.jTextFieldId.setText(id);
	}
}
