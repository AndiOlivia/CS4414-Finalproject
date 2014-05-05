package com.jida.user;

import java.awt.event.ActionEvent;




import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.apache.log4j.Logger;

//import com.jy.client.gui.GUI;
//import com.jy.client.gui.ProductGUI;
import com.jida.MvcProperties;
//import com.jida.client.Main;
import com.jida.gui.JFrameGui;
import com.jida.gui.JFrameGuiSuper;
import com.jida.user.db.ModelDBImplPrivilege;
import com.jida.user.domObject.Group;
import com.jida.user.domObject.Privilege;
import com.jida.user.domObject.User;
import com.jida.user.gui.PanelGroupPrivilege;
import com.jida.user.gui.PanelPrivilege;
import com.jida.user.gui.PanelUser;
import com.jida.user.intf.ModelUser;

public class ViewUserImpl implements ViewUser {
	Logger logger=Logger.getLogger(ViewUserImpl.class);
	//	UserManGUI gui;
	PanelUser panel;
	PanelGroupPrivilege panelGP;
	PanelPrivilege panelPrivilege;

	ModelUser modelUser;
	//	ControllerUser controllerUser;
	TableModelUser tableModelUser;
	//Update 20120217
	TableModelUserGroup tableModelUserGroup;
	//ends
	TableModelGroup tableModelGroup;
	//update 20120217
	TableModelGroupPrivilege tableModelGroupPrivilege;
	//end
	//	TableModelPrivilege tableModelPrivilege;
	String cond;
	String condGroup;

	public ViewUserImpl(ModelUser modelUser) {
		this.modelUser = modelUser;
		modelUser.addViewListener(this);

		//工作站 和服务器均有
		panel=(PanelUser)JFrameGuiSuper.gui.getPanel(PanelUser.name);
		if(panel!=null){
			tableModelUser = new TableModelUser(panel.getTable());
			panel.register(als);
			panel.registerTable(tableModelUser, lsl);
			//Update20120217
			this.tableModelUserGroup=new TableModelUserGroup(modelUser);
			this.tableModelUserGroup.addTableModelListener(tlG);
			//End
			panel.registerTableModelUserGroup(this.tableModelUserGroup);
			try {
				panel.setGroups(modelUser.getGroup());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e);
			}
			//工作站 和服务器均有
			this.panelGP=(PanelGroupPrivilege)JFrameGuiSuper.gui.getPanel(PanelGroupPrivilege.name);
			tableModelGroup = new TableModelGroup(modelUser);
			panelGP.register(this.alsGroup);
			panelGP.registerTable(tableModelGroup, this.lslGroup);
			//New 20120217
			//Update 20140116
			if(AuthModel.getInstance().getUser().getType()==AuthSession.SERVER){
				tableModelGroupPrivilege = new TableModelGroupPrivilege(ModelPrivilegeNetImpl.getInstance());//ModelDBImplPrivilege.getInstance());
			}
			else{
				tableModelGroupPrivilege = new TableModelGroupPrivilege(ModelDBImplPrivilege.getInstance());	
			}
			this.tableModelGroupPrivilege.addTableModelListener(tlP);
			//end
			panelGP.registerTableModelPrivilege(this.tableModelGroupPrivilege);
		}
		//		panelGP.setPrivileges(list);
	}

	public void processModelChange(Object obj){
		//		System.out.println("UserViewImpl:processModelChange:"+obj);

		if(!valid())
			return;

		List<User> list=null;
		if(obj!=null){
			this.tableModelUser.setList(list=(List<User>)obj);
		}
		else{
			try{
				list=modelUser.getUser(cond);
				this.tableModelUser.setList(list);
				List<Group> listGroup=modelUser.getGroup();
				//				System.out.println("UserViewImpl:processModelChange:"+listGroup);
				//				this.tableModelUserGroup.setListBasic(listGroup);
				//				panel.setGroups(modelUser.getGroup());
			}
			catch(Exception e){
				e.printStackTrace();
				logger.error(e);
				//				System.out.println(e);
			}
		}
		//		this..setList(list);
		this.panel.setContent();

		this.panel.setContentGroup();

		//		this.refresh(obj);
	}
	public void processModelChangeGroups(Object obj){
		if(!valid())
			return;

		List<Group> list=null;
		if(obj!=null){
			this.tableModelGroup.setList(list=(List<Group>)obj);
		}
		else{
			try{
				list=modelUser.getGroup(false);
				this.tableModelGroup.setList(list);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		//		this..setList(list);
		this.panelGP.setContent();
	}
	//	public void addControllerListener(ControllerUser controller){
	//	this.controllerUser=controller;
	//	}


	//	transient ActionListener alUpdateProduct = new ActionListener() {
	//	public void actionPerformed(ActionEvent e) {
	//	int index = gui.getSelectedIndex("product");
	//	if (index < 0) {
	//	return;
	//	}
	//	List<Product> list = null;
	//	try {
	//	list = modelproduct.getProduct(false);
	//	} catch (Exception excp) {
	//	gui.showStatus(excp);
	//	return;
	//	}
	//	Product product = list.get(index);
	//	ViewProductImpl.this.productGui = new ProductGUI("修改");
	//	productGui.setProductId(product.getId());
	//	productGui.setType(product.getType());
	//	productGui.setProductName(product.getName());
	//	productGui.setPosNo(product.getPosNo());
	//	productGui.setUnitPrice(product.getUnitPrice());
	//	productGui.setRemark(product.getRemark());
	//	ActionListener[] als = { alUpdateProductGUIOK, alProductGUICancel };
	//	productGui.register(als);

	//	index = modelproduct.getIndex(product, ProductCond);
	//	gui.setSelectedIndex(index, "product");

	//	}
	//	};
	transient ActionListener alDeleteProduct = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!valid())
				return;

			User user=panel.getUser();
			//			user.setName(panel.getUserName());
			//			user.setState(gui.getType());
			//			user.setPassword("0000");
			int index=modelUser.getIndex(user);

			if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null, "确定删除"+user+"吗？")){
				AuthModel aModel=AuthModel.getInstance();
				if(!valid(user)){
					JOptionPane.showMessageDialog(null, "当前用户无操作权限!");
					return;
				}
				try{
					modelUser.delete(user);
				}
				catch(Exception excp){
					logger.error(excp);
				}

				try{
					panel.setSelectedIndex(index);
					if(panel.getSelectedIndex() < 0) {
						panel.setSelectedIndex(index);
					}
				}
				catch(Exception excp){
					logger.error(excp);
				}
			}

		}
	};
	transient ActionListener alInsertProduct = new ActionListener() {
		public void actionPerformed(ActionEvent e) {



			User user=panel.getUser();
			if(!valid(user))
				return;
			//			user.setName(gui.getUserName());
			//			user.setState(gui.getType());
			//			user.setPassword("0000");
			//			user.setAddr(gui.getAddr());
			//			user.setId(gui.getId());
			//			user.setMobile(gui.getMobile());
			//			user.setTel(gui.getTel());
			try{
				modelUser.insert(user);

			}

			catch(Exception excp){
				logger.error(excp);
			}

			int index=modelUser.getIndex(user);

			panel.setSelectedIndex(index);
			if(panel.getSelectedIndex() < 0) {
				panel.setSelectedIndex(index);
			}
		}
	};

	private transient ListSelectionListener lsl = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent lse) {
			int index = panel.getSelectedIndex();
			if (index < 0) {
				return;
			}
			List<User> list = null;
			try {
				list = modelUser.getUser(cond);
			} catch (Exception excp) {
				logger.error(excp);
				return;
			}
			User user = list.get(index);
			panel.setUser(user);

			ViewUserImpl.this.tableModelUserGroup.setList(user.getGroups());
			panel.setContentGroup();

		}
	};
	transient ActionListener alUpdateProduct = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			User user=panel.getUser();
			if(!valid(user))
				return;

			int index=modelUser.getIndex(user);
			//			if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null, "确定删除"+user+"吗？")){

			try{
				modelUser.update(user);

			}
			catch(Exception excp){
				logger.error(excp);
			}

			try{
				panel.setSelectedIndex(index);
				if(panel.getSelectedIndex() < 0) {
					panel.setSelectedIndex(index);
				}
			}
			catch(Exception excp){
				logger.error(excp);
			}
			//			}

		}
	};

	transient ActionListener alUserSearch = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	};
	transient ActionListener alUserRefresh = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			processModelChange(null);


		}
	};
	transient ActionListener alUserImport = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	};
	transient ActionListener alUserExport = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!valid())
				return;

		}
	};

	transient ActionListener alInsertUserGroup = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			int index=panel.getSelectedIndex();
			if(index<0){
				JOptionPane.showMessageDialog(JFrameGui.getGui(), "请首先选择用户！");
				return;
			}
			User user=null;
			try{
				List<User> list=modelUser.getUser();
				user=list.get(index);
			}
			catch(Exception excp){
				logger.error(excp);
				return;
			}
			//New 20131110
			if(!valid(user))
				return;

			Group group=panel.getGroup();
			//			group.setName(gui.getUserGroup());
			//			group.setDesc(gui.getGroupDesc());
			//			user.setPassword("0000");
			try{
				modelUser.insert(user,group);
				modelUser.get(user);
				JFrameGui.getGui().showStatus("插入"+group+"成功");
			}

			catch(Exception excp){
				logger.error(excp);

				return;
			}
			//			tableModelUserGroup.setList(user.getGroups());
			panel.setContentGroup();
			//			panelGP.setContentHas();
			//			int index=modelUser.getIndex(group);

			//			gui.setSelectedIndex(index);
			//			if(gui.getSelectedIndex() < 0) {
			//			gui.setSelectedIndex(index);
			//			}

		}
	};
	transient ActionListener alDeleteUserGroup = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int index=panel.getSelectedIndex();
			if(index<0){
				JOptionPane.showMessageDialog(JFrameGui.getGui(), "请首先选择组！");
				return;
			}

			User user=null;
			try{
				List<User> list=tableModelUser.getList();//modelUser.getUser(false);
				System.out.println("UserViewImpl:alDeleteGroupPri:"+list);
				user=list.get(index);
			}
			catch(Exception excp){
				logger.error(excp);
				return;
			}
			System.out.println("UserViewImpl:alDeleteGroupPri:"+user);
			//New 20131110
			if(!valid(user))
				return;

			int indexGroup=panel.getSelectedIndexGroup();
			//			Group group=panelGP.getGroup();
			if(indexGroup<0){
				JOptionPane.showMessageDialog(JFrameGui.getGui(), "请首先选择用户的组！");
				return;
			}

			Group group=user.getGroups().get(indexGroup);

			if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null, "确定删除"+group+"吗？")){

				try{
					modelUser.delete(user ,group);
					modelUser.get(user);
					JFrameGui.getGui().showStatus("删除"+group+"成功");
				}
				catch(Exception excp){
					logger.error(excp);
				}
				//				tableModelUserGroup.setList(user.getGroups());
				panel.setContentGroup();

				//				try{
				//				gui.setSelectedUserGroupIndex(index);
				//				if(gui.getSelectedIndex() < 0) {
				//				gui.setSelectedIndex(index);
				//				}
				//				}
				//				catch(Exception excp){
				//				showStatus("加入选项条时:"+excp);
				//				}
			}

		}
	};
	transient ActionListener alChangePassword = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			User user=panel.getUser();
			String s=null;
			try {
				modelUser.changePassword(user, panel.getPasswordNew());
				//				s="成功更改";
				List<User> li=modelUser.getUser();
				ViewUserImpl.this.tableModelUser.setList(li);
				panel.setContent();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				s="更改失败";
				JOptionPane.showMessageDialog(JFrameGui.getGui(), s);
				//				e1.printStackTrace();
			}
		}
	};
	transient ActionListener[] als = {
			alInsertProduct,  alDeleteProduct,alUpdateProduct,
			this.alUserRefresh,/*this.alUserSearch,*/
			//			this.alUserImport,
			this.alUserExport,
			this.alChangePassword,
			/*this.alInsertUserGroup,this.alDeleteUserGroup,*/
	};
	//	transient ActionListener[] alsUserGroup = {
	//	alInsertUserGroup,  alDeleteUserGroup
	//	};


	transient ActionListener alInsertGroup = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!valid("SuperPrivilege"))
				return;

			Group group=panelGP.getGroup();
			if(group==null)
				return;
			//			user.setPassword("0000");
			try{
				modelUser.insert(group);

				JFrameGui.getGui().showStatus("插入成功");
			}
			catch(Exception excp){
				JOptionPane.showMessageDialog(panel, excp);
				return ;
			}


			int index=modelUser.getIndex(group);

			panelGP.setSelectedIndex(index);
			if(panelGP.getSelectedIndex() < 0) {
				panelGP.setSelectedIndex(index);
			}

			//			try {
			//				List<Group> ll=null;
			//				panel.setGroups(ll=modelUser.getGroup());
			//				
			//				tableModelUserGroup.setListBasic(ll);
			//			} catch (Exception excp) {
			//				// TODO Auto-generated catch block
			//				JOptionPane.showMessageDialog(panel, excp);
			//			}

		}
	};

	private transient ListSelectionListener lslGroup = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent lse) {
			int index = panelGP.getSelectedIndex();
			if (index < 0) {
				return;
			}
			List<Group> list = null;
			try {
				list = modelUser.getGroup(false);
			} catch (Exception excp) {
				logger.error(excp);
				return;
			}
			Group group = list.get(index);

			panelGP.setGroup(group);

			ViewUserImpl.this.tableModelGroupPrivilege.setList(group.getprivileges());
			panelGP.setContentHas();
		}
	};
	transient ActionListener alDeleteGroup = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!valid("SuperPrivilege"))
				return;

			Group group=panelGP.getGroup();
			if(group==null)
				return;

			int index=modelUser.getIndex(group);
			if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null, "确定删除"+group+"吗？")){

				try{
					modelUser.delete(group);
					JFrameGui.getGui().showStatus("删除"+group+"成功");
				}
				catch(Exception excp){
					logger.error(excp);
					return;
				}

				try{
					panelGP.setSelectedIndex(index);
					if(panelGP.getSelectedIndex() < 0) {
						panelGP.setSelectedIndex(index);
					}
				}
				catch(Exception excp){
					index--;
					if(index<0)
						return;
					panelGP.setSelectedIndex(index);
					//					JFrameGuiServer.getGui().showStatus("加入选项条时:"+excp);
					//					JOptionPane.showMessageDialog(panel, excp);
					//					return;
				}
				//New 20131110
				//				try{
				//					List<Group> ll=null;
				//					ll=modelUser.getGroup();
				//					tableModelUserGroup.setListBasic(ll);
				//				}
				//				catch(Exception excp){
				//					excp.printStackTrace();
				//					JOptionPane.showMessageDialog(panel, excp);
				//				}
			}

		}
	};
	transient ActionListener alUpdateGroup = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!valid("SuperPrivilege"))
				return;

			Group group=panelGP.getGroup();
			if(group==null)
				return;

			int index=modelUser.getIndex(group);
			//if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null, "确定删除"+group+"吗？")){

			try{
				modelUser.update(group);
				JFrameGui.getGui().showStatus("修改"+group+"成功");
			}
			catch(Exception excp){
				JOptionPane.showMessageDialog(panel, excp);
			}

			try{
				panelGP.setSelectedIndex(index);
				if(panelGP.getSelectedIndex() < 0) {
					panelGP.setSelectedIndex(index);
				}
			}
			catch(Exception excp){
				//				JOptionPane.showMessageDialog(panel, excp);
				logger.error(excp);
			}
			//}

		}
	};

	transient ActionListener alGroupSearch = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	};
	transient ActionListener alGroupRefresh = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			processModelChangeGroups(null);
		}
	};
	//	transient ActionListener alUserImport = new ActionListener() {
	//	public void actionPerformed(ActionEvent e) {
	//	}
	//	};
	transient ActionListener alGroupExport = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!valid("SuperPrivilege"))
				return;

		}
	};

	transient ActionListener alInsertGroupPri = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//New 20131110
			if(!valid("SuperPrivilege"))
				return;

			int index=panelGP.getSelectedIndex();
			if(index<0){
				JOptionPane.showMessageDialog(JFrameGui.getGui(), "请首先选择组！");
				return;
			}
			Group g=null;
			try{
				List<Group> list=modelUser.getGroup();
				g=list.get(index);
			}
			catch(Exception excp){
				logger.error(excp);
				JOptionPane.showMessageDialog(panel, excp);
				return;
			}
			//			Group group=panelGP.getGroup();
			Privilege pri=panelGP.getJComboBoxGroupPri();
			//			group.setName(gui.getUserGroup());
			//			group.setDesc(gui.getGroupDesc());
			//			user.setPassword("0000");
			try{
				modelUser.insert(g,pri);
				//				modelUser.get();
				JFrameGui.getGui().showStatus("插入"+g+"成功");
			}

			catch(Exception excp){
				logger.error(excp);
				JOptionPane.showMessageDialog(panel, excp);
			}
			tableModelGroupPrivilege.setList(g.getprivileges());
			panelGP.setContentHas();
			//			int index=modelUser.getIndex(group);

			//			gui.setSelectedIndex(index);
			//			if(gui.getSelectedIndex() < 0) {
			//			gui.setSelectedIndex(index);
			//			}

		}
	};

	//	private transient ListSelectionListener lslGroupPri = new ListSelectionListener() {
	//	public void valueChanged(ListSelectionEvent lse) {
	//	int index = panelGP.getSelectedIndex();
	//	if (index < 0) {
	//	return;
	//	}
	//	int indexUser=panelGP.getSelectedIndex();
	//	if(indexUser<0){
	//	return;
	//	}
	//	User user=null;
	//	try{
	//	List <User> list=modelUser.getUser(cond);
	//	user=list.get(indexUser);
	//	}
	//	catch(Exception excp){

	//	}
	//	List<Group> listGroup = user.getGroups();
	//	if(listGroup==null){
	//	return;
	//	}
	//	Group group = listGroup.get(index);

	////	gui.setSelectedIndexUserGroup(inde);
	//	panelGP.setGroup(group);
	////	System.out.println(gui.getUserGroup());
	//	}
	//	};
	transient ActionListener alDeleteGroupPri = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//New 20131110
			if(!valid("SuperPrivilege"))
				return;

			int index=panelGP.getSelectedIndex();
			if(index<0){
				JOptionPane.showMessageDialog(JFrameGui.getGui(), "请首先选择组！");
				return;
			}
			Group group=null;
			try{
				List<Group> list=modelUser.getGroup();
				group=list.get(index);
			}
			catch(Exception excp){
				logger.error(excp);
				return;
			}
			Privilege pri;
			int indexPri=panelGP.getSelectedIndexPri();
			if(indexPri<0){
				if(indexPri<0){
					JOptionPane.showMessageDialog(JFrameGui.getGui(), "请选择组的权限！");
					return;
				}	
			}
			pri=group.getprivileges().get(indexPri);

			if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null, "确定删除"+pri+"吗？")){

				try{
					modelUser.delete(group,pri);
					//					modelUser.get(groups);
					JFrameGui.getGui().showStatus("删除成功:"+pri);
				}
				catch(Exception excp){
					logger.error(excp);
				}
				tableModelGroupPrivilege.setList(group.getprivileges());
				panelGP.setContentHas();

				//				try{
				//				gui.setSelectedUserGroupIndex(index);
				//				if(gui.getSelectedIndex() < 0) {
				//				gui.setSelectedIndex(index);
				//				}
				//				}
				//				catch(Exception excp){
				//				showStatus("加入选项条时:"+excp);
				//				}
			}

		}
	};

	transient ActionListener[] alsGroup = {
			alInsertGroup,  alDeleteGroup,this.alUpdateGroup,
			this.alGroupRefresh,this.alGroupSearch,
			this.alGroupExport,
			//			this.alChangePassword,
			//Delete 20120220
			/*this.alInsertGroupPri,this.alDeleteGroupPri,*/
			//end
	};
	//	transient ActionListener[] alsGroupPri = {
	//	alInsertGroupPri,  alDeleteGroupPri
	//	};
	//new 20120218 增删 用户－组
	transient TableModelListener tlG= new TableModelListener(){

		public void tableChanged(TableModelEvent e) {

			int row = e.getFirstRow();

			int column = e.getColumn();

			//取得列表框的数据

			Object data = tableModelUserGroup.getValueAt(row, column);
			if(column==0){
				System.out.println("UserViewImpl.tableChanged():"+data);

				int index=panel.getSelectedIndex();
				if(index<0){
					JOptionPane.showMessageDialog(JFrameGui.getGui(), "请首先选择用户！");
					return;
				}
				User user=null;
				try{
					List<User> list=modelUser.getUser();
					user=list.get(index);
				}
				catch(Exception excp){
					logger.error(excp);
					return;
				}


				Group group=null;
				try {
					group=tableModelUserGroup.getListBasic().get(row);//modelUser.getGroup().get(row);
					//New 20131110
					if(!valid("SuperPrivilege",false) &&	group.getName().equalsIgnoreCase("SuperGroup")){
						JOptionPane.showMessageDialog(null, "不能操作超级用户组");
						return;
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if(data.equals(false)){
					try{

						modelUser.insert(user,group);
						modelUser.get(user);
						JFrameGui.getGui().showStatus("插入"+group+"成功");
					}

					catch(Exception excp){
						logger.error(excp);

						return;
					}
				}else{
					//					if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null, "确定删除"+group+"吗？")){

					try{
						modelUser.delete(user ,group);
						modelUser.get(user);
						JFrameGui.getGui().showStatus("删除"+group+"成功");
					}
					catch(Exception excp){
						logger.error(excp);
					}
					//					}
				}
				tableModelUserGroup.setList(user.getGroups());
				panel.setContentGroup();
				//				panelGP.setContentHas();
				//				int index=modelUser.getIndex(group);

				//				gui.setSelectedIndex(index);
				//				if(gui.getSelectedIndex() < 0) {
				//				gui.setSelectedIndex(index);
				//				}
			}
		}
	};
	//end
	//new 20120218 增删组权限
	transient TableModelListener tlP= new TableModelListener(){

		public void tableChanged(TableModelEvent e) {
			//New 20131110
			if(!valid("SuperPrivilege")){
				return;
			}

			int row = e.getFirstRow();

			int column = e.getColumn();

			//取得列表框的数据
			//New 20131110


			Object data = tableModelGroupPrivilege.getValueAt(row, column);
			if(column==0){
				System.out.println(data);

				int index=panelGP.getSelectedIndex();
				if(index<0){
					JOptionPane.showMessageDialog(JFrameGui.getGui(), "请首先选择用户！");
					return;
				}
				Group g=null;
				try{
					List<Group> list=modelUser.getGroup();
					g=list.get(index);
				}
				catch(Exception excp){
					logger.error(excp);
					return;
				}

				Privilege pri=null;
				try {
					pri = ModelDBImplPrivilege.getInstance().get().get(row);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(data.equals(false)){
					try{
						modelUser.insert(g,pri);
						//						modelUser.get();
						JFrameGui.getGui().showStatus("插入"+g+"成功");
					}

					catch(Exception excp){
						logger.error(excp);
					}
				}else{
					//					if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null, "确定删除"+pri+"吗？")){

					try{
						modelUser.delete(g,pri);
						//							modelUser.get(groups);
						JFrameGui.getGui().showStatus("删除成功:"+pri);
					}
					catch(Exception excp){
						logger.error(excp);
					}
					//					}
				}
				tableModelGroupPrivilege.setList(g.getprivileges());
				panelGP.setContentHas();

			}
		}
	};

	public static boolean valid(){
		return valid("UserMgrPrivilege,SuperPrivilege",true);
	}
	/**
	 * 当前用户是否有指定的权限序列：pris	New 20131110
	 * @param pris：权限序列
	 * @return
	 */
	public static boolean valid(String pris){
		return valid(pris,true);
	}
	public static boolean valid(String pris,boolean display){
		AuthModel aModel=AuthModel.getInstance();
		if(!aModel.isValidOperation(pris)){
			if(display)
				JOptionPane.showMessageDialog(null, "当前用户无用户管理权限!");
			return false;
		}
		return true;
	}
	public static boolean valid(User user){
		AuthModel aModel=AuthModel.getInstance();
		//New 20131110
		if(aModel.isValidOperation("SuperPrivilege")||
				(aModel.isValidOperation("UserMgrPrivilege")&& user.getT1().equals(aModel.getUser().getT1()))){
			return true;
		}
		JOptionPane.showMessageDialog(null, "当前用户无用户管理权限或用户单位名不正确!");
		return false;

	}
	//end
}
