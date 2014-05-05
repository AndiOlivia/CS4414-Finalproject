package com.jida.user.gui;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.jida.MvcProperties;
import com.jida.gui.panel.ToolBarable;
import com.jida.gui.panel.YButton;
import com.jida.user.domObject.Group;
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
public class PanelGroupPrivilege extends javax.swing.JPanel implements ToolBarable {

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

	private PanelGroupPrivilege panel;
	private JTextField jTextFieldGroupName;
//	private JComboBox jComboBoxUserType;
	private JTextField jTextFieldDesc;
//	private JTextField jTextFieldMobile;
//	private JTextField jTextFieldAddr;
//	private JTextField jTextFieldId;
	private JTable tableGroup;
	private JComboBox jComboBoxGroupPri;
	private YButton jButtonGroupPriInsert;
	private YButton jButtonGroupPriDelete;
	private JTable jTableGroupPri;
	private JToolBar jToolBar;
	private YButton jButtonInsert;
	private YButton jButtonDelete;
	private YButton jButtonUpdate;
	private YButton jButtonRefresh;
//	private YButton jButtonImport;
	private YButton jButtonExport;
	private JComboBox jComboBoxItem;
	private JComboBox jComboBoxMode;
	private JTextField jTextFieldValue;
	private YButton jButtonSearch;
	public static String name="Group-Privilege";
	
	public PanelGroupPrivilege() {
		super();
		initGUI();
		this.buildToolBar();
	}
	
	private void initGUI() {
		GridBagLayout thisLayout = new GridBagLayout();
		thisLayout.rowWeights = new double[] {0.0,0.0, 0.1,0,0};
		thisLayout.rowHeights = new int[] {30,30, 200,40,300};
		thisLayout.columnWeights = new double[] {0.0, 0,0.1,0,0,0,0};
		thisLayout.columnWidths = new int[] {30, 70,30,70,90,50,50,50};
		//panel.setLayout(thisLayout);
		{
			this.panel=this;//new JPanel();
			setLayout(thisLayout);
			
		}
		{
			JLabel jLabel2 = new JLabel();
			this.panel.add(jLabel2, new GridBagConstraints(0, 0, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			jLabel2.setText("Group Name");
			jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldGroupName = new JTextField();
//			this.jTextFieldUserName.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldGroupName, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
//		{
//			JLabel jLabel4 = new JLabel();
//			this.panel.add(jLabel4, new GridBagConstraints(2, 0, 1, 1, 0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
//			jLabel4.setText("状态");
//			jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
////			jLabel4.setVisible(false);
//		}
//		{
//			jComboBoxUserType = new JComboBox();
//			this.panel.add(jComboBoxUserType, new GridBagConstraints(3, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 3, 0, 0), 0, 0));
////			this.jComboBoxUserType.setBorder(this.bevelBorder);
//			jComboBoxUserType.setModel(new DefaultComboBoxModel(User.codesString));
//		}
		{
			JLabel jLabel = new JLabel("Desc");
			this.panel.add(jLabel, new GridBagConstraints(2, 0, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jLabel2.setText("用户名称");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		{
			this.jTextFieldDesc = new JTextField();
//			this.jTextFieldTel.setBorder(this.bevelBorder);
			this.panel.add(jTextFieldDesc, new GridBagConstraints(3, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
		}
//		{
//			JLabel jLabel = new JLabel("手机");
//			this.panel.add(jLabel, new GridBagConstraints(6, 0, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
////			jLabel2.setText("用户名称");
//			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//		}
//		{
//			this.jTextFieldMobile = new JTextField();
////			this.jTextFieldMobile.setBorder(this.bevelBorder);
//			this.panel.add(jTextFieldMobile, new GridBagConstraints(7, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
//		}
//		{
//			JLabel jLabel = new JLabel("地址");
//			this.panel.add(jLabel, new GridBagConstraints(0, 1, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
////			jLabel2.setText("用户名称");
//			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//		}
//		{
//			this.jTextFieldAddr = new JTextField();
////			this.jTextFieldAddr.setBorder(this.bevelBorder);
//			this.panel.add(jTextFieldAddr, new GridBagConstraizs(1, 1, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
//		}
//		{
//			JLabel jLabel = new JLabel("身份证号");
//			this.panel.add(jLabel, new GridBagConstraints(3, 1, 1, 1,0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
////			jLabel2.setText("用户名称");
//			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//		}
//		{
//			this.jTextFieldId = new JTextField();
////			this.jTextFieldId.setBorder(this.bevelBorder);
//			this.panel.add(jTextFieldId, new GridBagConstraints(4, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 0), 0, 0));
//		}
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
			this.tableGroup=new JTable();
			scrollPane.getViewport().add(tableGroup,null);
			panel.add(scrollPane, new GridBagConstraints(0,2, 8,  1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//			getContentPane().add(this.scrollPane, new GridBagConstraints(2, 9, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		//Delete 20120220
		/*{
			JLabel label = new JLabel();
			this.panel.add(label, new GridBagConstraints(0, 3, 1, 1, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
			label.setText("组权限");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
//			jLabel4.setVisible(false);
		}
		{
			jComboBoxGroupPri = new JComboBox();
			this.panel.add(jComboBoxGroupPri, new GridBagConstraints(1, 3, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 3, 0, 0), 0, 0));
//			this.jComboBoxGroups.setBorder(this.bevelBorder);
//			jComboBoxGroups.setModel(new DefaultComboBoxModel(User.codesString));
		}
		{
			jButtonGroupPriInsert = new YButton();
			panel.add(this.jButtonGroupPriInsert, new GridBagConstraints(3,3, 1,  1, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jButtonGroupPriInsert.setIcon(MvcProperties.imageIconInsert);
			jButtonGroupPriInsert.setToolTipText("新增");
			jButtonGroupPriInsert.setText("新增");
			this.jButtonGroupPriInsert.setPreferredSize(new Dimension(60,25));
			this.jButtonGroupPriInsert.setBorder(null);//BorderFactory.createBevelBorder(BevelBorder.RAISED));
			this.jButtonGroupPriInsert.setBackground(panel.getBackground());
//			this.jButtonGroupPriInsert.setBorderPainted(false);
//			this.jButtonGroupPriInsert.setSize(30,25);
		}
		{
			jButtonGroupPriDelete = new YButton();
			panel.add(this.jButtonGroupPriDelete, new GridBagConstraints(4,3, 1,  1, 0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jButtonGroupPriDelete.setIcon(MvcProperties.imageIconDelete);
			jButtonGroupPriDelete.setToolTipText("删除");
			jButtonGroupPriDelete.setText("删除");
			this.jButtonGroupPriDelete.setPreferredSize(new Dimension(60,25));
			this.jButtonGroupPriDelete.setBorder(null);//BorderFactory.createBevelBorder(BevelBorder.RAISED));
//			this.jButtonGroupPriDelete.setBorderPainted(false);
			
			this.jButtonGroupPriDelete.setBackground(panel.getBackground());
		}*/
		//end
		{
			
			//this.getContentPane().add("North",panel);
//			jPanelUserGroup.add("North",panel);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			this.jTableGroupPri=new JTable();
			scrollPane.getViewport().add(jTableGroupPri,null);
			//Update20120220
			panel.add(scrollPane, new GridBagConstraints(0, 3, 10, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
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
			jButtonInsert = new YButton(color);
//			this.add(jButtonInsert, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			this.jToolBar.add(jButtonInsert);
			jButtonInsert.setIcon(MvcProperties.imageIconInsert);
			jButtonInsert.setMaximumSize(d);
			jButtonInsert.setMinimumSize(d);
//			this.jButtonInsert.setToolTipText("新增");
			this.jButtonInsert.setText("New");
		}
		{
			jButtonDelete = new YButton(color);
			this.jToolBar.add(jButtonDelete);
			jButtonDelete.setIcon(MvcProperties.imageIconDelete);
			jButtonDelete.setMaximumSize(d);
			jButtonDelete.setMinimumSize(d);
//			this.jButtonDelete.setToolTipText("删除");
			this.jButtonDelete.setText("Delete");
		}
		{
			jButtonUpdate = new YButton(color);
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
//			this.jButtonRefresh.setToolTipText("组刷新");
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
			jLabel3.setText("Search");
			jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
//			ComboBoxModel jComboBoxModeModel = new DefaultComboBoxModel(
//				TempretureController.titles);
			jComboBoxItem = new JComboBox();
			jComboBoxItem.setMaximumSize(d=new Dimension(100,28));
			jComboBoxItem.setMinimumSize(d);
//			jComboBoxItem.setModel(jComboBoxModeModel);
			this.jToolBar.add(this.jComboBoxItem);
		}
		{
			ComboBoxModel jComboBoxItemModel = new DefaultComboBoxModel(
				new String[] { "=", "~" });
			jComboBoxMode = new JComboBox();
			jComboBoxMode.setMaximumSize(d=new Dimension(80,28));
			jComboBoxMode.setMinimumSize(d);
			this.jToolBar.add(this.jComboBoxMode);
			
			jComboBoxMode.setModel(jComboBoxItemModel);
		}
		{
			jTextFieldValue = new JTextField();
//			this.add(jTextFieldValue, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			jTextFieldValue.setMaximumSize(d=new Dimension(180,28));
			jTextFieldValue.setMinimumSize(d);
			this.jToolBar.add(this.jTextFieldValue);
		}
		
		{
			jButtonSearch = new YButton(color);
			this.jToolBar.add(jButtonSearch);
			jButtonSearch.setIcon(MvcProperties.imageIconSearch);
			jButtonSearch.setMaximumSize(d=new Dimension(80,28));
			jButtonSearch.setMinimumSize(d);
			this.jButtonSearch.setText("Search");
		}
	}
	public int getSelectedIndex(){
		return this.tableGroup.getSelectedRow();
	}
	public void setSelectedIndex(int index){
		this.tableGroup.changeSelection(index, -1, true, false);
	}
	public int getSelectedIndexPri(){
		return this.jTableGroupPri.getSelectedRow();
	}
	public void setSelectedIndexPri(int index){
		this.jTableGroupPri.changeSelection(index, -1, true, false);
	}
	
	public void register(ActionListener als[]){
		YButton buttons[]={this.jButtonInsert,this.jButtonDelete,
				this.jButtonUpdate,
				this.jButtonRefresh,this.jButtonSearch,
//				this.jButtonImport,
				this.jButtonExport,
				//New 20120220
				/*this.jButtonGroupPriInsert,
				this.jButtonGroupPriDelete,*/
				//end
				};
		for(int i=0;i<als.length;i++){
			buttons[i].addActionListener(als[i]);
		}
//		this.jTableContent.getSelectionModel().addListSelectionListener(lsl);
	}
	public void registerTable(TableModel model,ListSelectionListener lsl){
		this.tableGroup.setModel(model);
		this.tableGroup.getSelectionModel().addListSelectionListener(lsl);
		this.tableGroup.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void registerTableModelPrivilege(TableModel model){
		this.jTableGroupPri.setModel(model);
		this.jTableGroupPri.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public void setContent(){
		this.tableGroup.updateUI();
	}
	public void setContentHas(){
		this.jTableGroupPri.updateUI();
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
		return this.tableGroup;
	}

	public Group getGroup() {
		if(this.jTextFieldGroupName.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Specify group name");
			return null;
		}
		Group g=new Group();
		g.setName(this.jTextFieldGroupName.getText());
		g.setDesc(this.jTextFieldDesc.getText());
		return g;
	}

	public void setGroup(Group g) {
		jTextFieldGroupName.setText(g.getName());
		this.jTextFieldDesc.setText(g.getDesc());
	}

	public Privilege getJComboBoxGroupPri() {
		return (Privilege)jComboBoxGroupPri.getSelectedItem();
	}

	public void setJComboBoxGroupPri(String priName) {
		jComboBoxGroupPri.setSelectedItem(priName);
	}
	
	public void setPrivileges(List<Privilege> list){
		ComboBoxModel model=new DefaultComboBoxModel(list.toArray());
		this.jComboBoxGroupPri.setModel(model);
	}
}
