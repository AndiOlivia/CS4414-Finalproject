package com.jida.fee.gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout; 
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.freixas.jcalendar.JCalendarCombo;

import com.jida.MvcProperties;
import com.jida.fee.data.Fee;
import com.jida.gui.panel.ToolBarable;
import com.jida.gui.panel.YButton;
import com.jida.product.data.Product;
import com.jida.product.data.ProductType;
import com.jidasoft.gui.JLabelSelection;


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
public class PanelFee extends javax.swing.JPanel implements ToolBarable {
	private JScrollPane jScrollPane1;
	private YButton jButtonExport;
	private YButton jButtonRefresh;
	private JTable jTableContent;
	private JTable jTableDetails;
	private JLabel jLabel1;
	private JToolBar jToolBar;
	private JSplitPane jSplitPane1;
	private JPanel panel1;
	private JComboBox jComboBoxTemConAddr;
	private JCalendarCombo dateStart;
	private JCalendarCombo dateEnd;
	private JLabel jLabelTotal;
	private YButton jButtonSearch3;
	private YButton jButtonCompute;
	private YButton jButtonRefreshDetail;
	private JLabel jLabelEnergy;
	private JLabel jLabelSize;
	private JLabel jLabelEnergyAverage;
	private JLabel jLabelTotalAverage;
	private YButton buttonSort1;
	private YButton buttonSort2;
	private YButton buttonSort3;
	private YButton jButtonSetting;
	private YButton jButtonSettingAll;
	private JTextField jTextFieldId;
	private JTextField jTextFieldName;
	private JComboBox jComboBoxType;
	private JCalendarCombo jCalendarCombo;
	private JTextField jTextFieldAddr;
	private JTextField jTextFieldTotalPrice;
	private YButton jButtonInsert;
	private YButton jButtonDelete;
	private YButton jButtonUpdate;
	private JLabelSelection<Product> jLabelProduct;
	private YButton jButtonSearch;
	private JTextField jTextFieldComment;
	public static String name="Fee Manager";
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
//		PanelPrivilege inst = new PanelPrivilege();
//		inst.setVisible(true);
		JFrame f=new JFrame();
		f.getContentPane().add(new PanelFee());
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
	}

	public PanelFee() {
		super();
		buildToolBar();
		initGUI();
	}

	private void initGUI() {
		try {
			{
//				this.setPreferredSize(new java.awt.Dimension(604, 336));

//				this.setLayout(new BorderLayout());
//				this.setPreferredSize(new java.awt.Dimension(1002, 609));
				{
//					jSplitPane1 = new JSplitPane();
//					this.add(jSplitPane1);
//					jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
					
//					jSplitPane1.setPreferredSize(new java.awt.Dimension(1000, 400));


					
						JPanel panel=this;
						GridBagLayout thisLayout;
						panel.setLayout(thisLayout=new GridBagLayout());
						thisLayout.columnWeights=new double[]{0,0,0,0,0,0,0,0,0,0,0,0,1};
						thisLayout.columnWidths=new int[]{60,120,80,250,60,120,60,180,60,200,80,100,90};
						thisLayout.rowHeights=new int[]{40,100};
						thisLayout.rowWeights=new double[]{0,1};
						//						Dimension d;
						//						d=new Dimension(1000,200);
						//						panel.setMinimumSize(d);
//						jSplitPane1.add(panel, JSplitPane.TOP);
						{
							JLabel jLabel3 = new JLabel();

//							this.jToolBar.add(jLabel3);
							jLabel3.setText("Id");
							jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
							panel.add(jLabel3,new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						}
						{
							jTextFieldId = new JTextField("");
							panel.add(jTextFieldId,new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//							this.jToolBar.add(jLabelSize);
//							jLabelSize.setPreferredSize(new Dimension(70,30));
							
						}
						{
							JLabel jLabel3 = new JLabel();

//							this.jToolBar.add(jLabel3);
							jLabel3.setText("Merchandise");
							jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
							panel.add(jLabel3,new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						}
						{
							jLabelProduct = new JLabelSelection<Product>();
							Dimension d=new Dimension(250,25);
							jLabelProduct.setMaximumSize(d);
							jLabelProduct.setMinimumSize(d);
							panel.add(jLabelProduct,new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						}
						
						{
							JLabel jLabel3 = new JLabel();
							jLabel3.setText("Comment");
							jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
							panel.add(jLabel3,new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						}
						{
							jTextFieldComment = new JTextField();

							panel.add(jTextFieldComment,new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//							jTextFieldComment.setEditable(false);
						}
						
						{
							JLabel jLabel3 = new JLabel();

							jLabel3.setText("Date");
							jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
							panel.add(jLabel3,new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
							
						}
						{
							jCalendarCombo = new JCalendarCombo(Calendar.getInstance(),Locale.US,JCalendarCombo.DISPLAY_DATE,true);
							panel.add(jCalendarCombo,new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
							
						}
						
						{
							JLabel jLabel3 = new JLabel();

							jLabel3.setText("Place");
							jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
							panel.add(jLabel3,new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
							
						}
						{
							jTextFieldAddr = new JTextField("");
							panel.add(jTextFieldAddr,new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
							
						}
						{
							JLabel jLabel3 = new JLabel();

							jLabel3.setText("Total Price");
							jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
							panel.add(jLabel3,new GridBagConstraints(10, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
							
						}
						{
							jTextFieldTotalPrice = new JTextField("");
							panel.add(jTextFieldTotalPrice,new GridBagConstraints(11, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
							
						}

					


					{
						JScrollPane jScrollPane1 = new JScrollPane();
						jScrollPane1.setMinimumSize(new Dimension(1000,100));
						panel.add(jScrollPane1,new GridBagConstraints(0, 1, thisLayout.columnWeights.length, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//						jSplitPane1.add(jScrollPane1, JSplitPane.BOTTOM);


						{
							jTableContent = new JTable();
							jScrollPane1.getViewport().add(jTableContent,null);

						}
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void setContent(List<Privilege> list){
////	this.jListContent.setListData(list.toArray());
//	this.jTableContent.updateUI();
//	}

	public int getSelectedIndex(){
		return this.jTableContent.getSelectedRow();
	}
	public void setSelectedIndex(int index){
		this.jTableContent.changeSelection(index, -1, true, false);
	}

	public void register(ActionListener als[]){
		YButton buttons[]={
//				this.jButtonInsert,this.jButtonDelete,
//				this.jButtonUpdate,
				
				this.jButtonRefresh,
				this.jButtonExport,
				this.jButtonInsert,this.jButtonDelete,this.jButtonUpdate,
				this.jButtonSearch,  //20131222
				this.jButtonSearch3,

		};
		for(int i=0;i<als.length;i++){
			buttons[i].addActionListener(als[i]);
		}

//		this.jTableContent.getSelectionModel().addListSelectionListener(lsl);

	}
	public void registerTable(TableModel model,ListSelectionListener lsl){
		this.jTableContent.setModel(model);
		this.jTableContent.getSelectionModel().addListSelectionListener(lsl);
		this.jTableContent.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public void registerTableDetails(TableModel model,ListSelectionListener lsl){
		this.jTableDetails.setModel(model);
		this.jTableDetails.getSelectionModel().addListSelectionListener(lsl);
		this.jTableDetails.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public void setTableModel(TableModel model){
		this.jTableContent.setModel(model);
		this.jTableContent.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public void setContent(){
		this.jTableContent.updateUI();
	}
	public void setContentDetails(){
		this.jTableDetails.updateUI();
	}
//	public String getValue(){
//	return this.jTextFieldValue.getText();

//	}
//	public String getItem(){
//	return (String)this.jComboBoxItem.getSelectedItem();
//	}
//	public int getMode(){
//	return this.jComboBoxMode.getSelectedIndex();
//	}
	public JToolBar getJToolBar(){
		return this.jToolBar;
	}
	public void buildToolBar(){
		this.jToolBar=new JToolBar();
		Color color=jToolBar.getBackground();
		Dimension d=new Dimension(80,28);
		{
			jButtonRefresh = new YButton(color);
			this.jToolBar.add(jButtonRefresh);
			jButtonRefresh.setIcon(MvcProperties.imageIconRefresh);
			jButtonRefresh.setMaximumSize(d);
			jButtonRefresh.setMinimumSize(d);
			this.jButtonRefresh.setToolTipText("Refresh");
			this.jButtonRefresh.setText("Refresh");
		}
		{
			this.jToolBar.addSeparator();
		}

		{
			jButtonExport = new YButton(color);
			this.jToolBar.add(jButtonExport);
			jButtonExport.setIcon(MvcProperties.imageIconExport);
			jButtonExport.setMaximumSize(d);
			jButtonExport.setMinimumSize(d);
			this.jButtonExport.setToolTipText("Export");
			this.jButtonExport.setText("Export");
		}
//		{
//			this.jToolBar.addSeparator();
//		}
//		{
//			jButtonSettingAll =new YButton(color);
//			this.jToolBar.add(jButtonSettingAll);
//			jButtonSettingAll.setIcon(MvcProperties.imageIconSetting);
//			jButtonSettingAll.setPreferredSize(new Dimension(90,30));
//			jButtonSettingAll.setToolTipText("显示所有列");
//			jButtonSettingAll.setText("全列设置");
//
//		}
		{
			this.jToolBar.addSeparator();
		}
		{
			jButtonInsert = new YButton(color);
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
			jButtonUpdate.setIcon(MvcProperties.imageIconInsert);
			jButtonUpdate.setMaximumSize(d);
			jButtonUpdate.setMinimumSize(d);
			this.jButtonUpdate.setToolTipText("Update");
			this.jButtonUpdate.setText("Update");
		}
		{
			this.jToolBar.addSeparator();
		}
		{
			JLabel jLabel3 = new JLabel();
			jLabel3.setText("Category");
			jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
//			panel.add(jLabel3,new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			this.jToolBar.add(jLabel3);
		}
		{
			jComboBoxType = new JComboBox();
			this.jToolBar.add(jComboBoxType);
			d=new Dimension(120,28);
			jComboBoxType.setMaximumSize(d);
			jComboBoxType.setMinimumSize(d);
//			panel.add(jComboBoxType,new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
//			jComboBoxType.setEditable(false);
		}
		
		{
			jButtonSearch = new YButton(color);
			this.jToolBar.add(jButtonSearch);
			jButtonSearch.setIcon(MvcProperties.imageIconSearch);
			jButtonSearch.setText("Search");
			jButtonSearch.setMaximumSize(d=new Dimension(80,28));
			jButtonSearch.setMinimumSize(d);

			this.jButtonSearch.setToolTipText("Display the search result");
		}

		{
			JLabel jLabel3 = new JLabel();

			this.jToolBar.add(jLabel3);
			jLabel3.setText("From");
//			jLabel3.setPreferredSize(new Dimension(60,30));
			jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		d=new Dimension(160,30);
		{
			dateStart=new JCalendarCombo(Calendar.getInstance(),Locale.US,JCalendarCombo.DISPLAY_DATE, false);
			dateStart.setDate(new Date());
			dateStart.setMaximumSize(d);
			dateStart.setMinimumSize(d);
			this.jToolBar.add(dateStart);

		}
		
		{
			JLabel jLabel3 = new JLabel();

			this.jToolBar.add(jLabel3);
			jLabel3.setText(" To ");
			jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			dateEnd=new JCalendarCombo(Calendar.getInstance(),Locale.US,JCalendarCombo.DISPLAY_DATE, false);
			dateEnd.setDate(new Date());
			dateEnd.setMaximumSize(d);
			dateEnd.setMinimumSize(d);
			this.jToolBar.add(dateEnd);

		}
		{
			jButtonSearch3 = new YButton(color);
			this.jToolBar.add(jButtonSearch3);
			jButtonSearch3.setIcon(MvcProperties.imageIconSearch);
			jButtonSearch3.setText("Search");
			jButtonSearch3.setMaximumSize(d=new Dimension(80,28));
			jButtonSearch3.setMinimumSize(d);

			this.jButtonSearch3.setToolTipText("Display the search result");
		}
		
	}

	public JTable getTable(){
		return this.jTableContent;
	}
	public Date getDateStart() {
		return MvcProperties.getCurrentDayBegin(dateStart.getDate());
	}

	public void setDateStart(Date dateStart) {
		this.dateStart.setDate(dateStart);
	}

	public Date getDateEnd() {
		return dateEnd.getDate();
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd.setDate(dateEnd);
	}

	public String getCategory(){
		return ((String)this.jComboBoxType.getSelectedItem());
	}
	public void setCategories(List<String> list ){
		ComboBoxModel model=new DefaultComboBoxModel(list.toArray());
		this.jComboBoxType.setModel(model);
	}
	
    public void setJLabelSelection(List<Product> list, String titles[],String fields[]){
    	this.jLabelProduct.init(list,titles,fields);
    }
    Product pro=null;
    public Fee get(){
    	
    	Fee fee=new Fee();
    	try{
    		fee.setFeeNo(Integer.parseInt(this.jTextFieldId.getText()));
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	pro=this.jLabelProduct.get();
    	fee.setFeePdtNo(pro.getPdtNo());
    	fee.setFeePdtName(pro.getPdtName());
    	fee.setFeePrice(pro.getPdtPrice());
    	try{
    		fee.setFeeTotalPrice(Float.parseFloat(this.jTextFieldTotalPrice.getText()));
    	}
    	catch(Exception e){
    		JOptionPane.showMessageDialog(this, "Illegal Total Price");
    		return null;
    	}
    	
    	fee.setFeeComment(this.jTextFieldComment.getText());
    	fee.setFeeDate(this.jCalendarCombo.getDate());
    	
    	return fee;
    }
    
    public void set(Fee fee){
    	if(pro==null)
    		pro=new Product();
    	this.jTextFieldId.setText(Integer.toString(fee.getFeeNo()));
    	pro.setPdtNo(fee.getFeePdtNo());
    	this.jLabelProduct.set(pro);
    	this.jTextFieldTotalPrice.setText(Float.toString(fee.getFeeTotalPrice()));
    	this.jCalendarCombo.setDate(fee.getFeeDate());
    	this.jTextFieldComment.setText(fee.getFeeComment());
    }
    
    public  void setTypes(List<String> list){
		ComboBoxModel model=new DefaultComboBoxModel(list.toArray());
		this.jComboBoxType.setModel(model);
	}
    
    
	
}
