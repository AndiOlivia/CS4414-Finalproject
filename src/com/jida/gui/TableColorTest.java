package com.jida.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableColorTest extends Object{
	public static void main(String[] args) {
		JFrame frame = new PlanetTableFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class PlanetTableFrame extends JFrame {
	public PlanetTableFrame() {
		// 用于控制每一行颜色的数组
		String[] color = { "H", "A", "F", "E", "W" };

		setTitle("PlanetTable");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// 定义JTable,实例成自己扩展的JTable类，并传入用于设定颜色的数组
		final JTable table = new StyleTable(cells, columnNames, color);
		// 下面这行代码可实现相邻两行颜色交替的效果,注意与上一行的区别
//		final JTable table = new StyleTable(cells, columnNames);

		add(new JScrollPane(table), BorderLayout.CENTER);
		JButton printButton = new JButton("Print");
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					table.print();
				} catch (java.awt.print.PrinterException e) {
					e.printStackTrace();
				}
			}
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(printButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private Object[][] cells = {
			{ "Mercury", new Double(2440.0), new Integer(0),
				new Boolean(false), Color.yellow },
				{ "Venus", new Double(60520.0), new Integer(0), new Boolean(false),
					Color.yellow },
					{ "Earth", new Double(6378.0), new Integer(1), new Boolean(false),
						Color.blue },
						{ "Mars", new Double(3397.0), new Integer(2), new Boolean(false),
							Color.red },
							{ "Jupiter", new Double(71492.0), new Integer(16),
								new Boolean(false), Color.orange } };

	private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous",
	"Color" };

	private static final int DEFAULT_WIDTH = 400;

	private static final int DEFAULT_HEIGHT = 200;
}
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Component;
//
//import javax.swing.JFrame;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.TableColumn;
//import javax.swing.table.TableColumnModel;

/**
 * 本类实现了对JTable颜色的控制，提供了两套方案： 
 * 1.实现了表格行两种颜色交替的效果 
 * 2.实现了用一个控制颜色的字符串数组来设置所对应行的颜色
 * 
 * @author Sidney
 * @version 1.0 (2008-1-14)
 */
class StyleTable extends JTable {
	/**
	 * 用于设定行颜色的数组
	 */
	private String[] color = null;

	public StyleTable() {
		super();
	}

	public StyleTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		paintRow();
	}

	public StyleTable(Object[][] rowData, Object[] columnNames, String[] color) {
		super(rowData, columnNames);
		this.color = color;
		paintColorRow();
	}

	/**
	 * 根据color数组中相应字符串所表示的颜色来设置某行的颜色，注意，JTable中可以对列进行整体操作
	 * 而无法对行进行整体操作，故设置行颜色实际上是逐列地设置该行所有单元格的颜色。
	 */
	public void paintRow() {
		TableColumnModel tcm = this.getColumnModel();
		for (int i = 0, n = tcm.getColumnCount(); i < n; i++) {
			TableColumn tc = tcm.getColumn(i);
			tc.setCellRenderer(new RowRenderer());
		}
	}

	public void paintColorRow() {
		TableColumnModel tcm = this.getColumnModel();
		System.out.println("n="+tcm.getColumnCount());
		for (int i = 0, n = tcm.getColumnCount(); i < n; i++) {
			TableColumn tc = tcm.getColumn(i);
			tc.setCellRenderer(new RowColorRenderer());
		}
	}

	/**
	 * 定义内部类，用于控制单元格颜色，每两行颜色相间，本类中定义为蓝色和绿色。
	 * 
	 * @author Sidney
	 * 
	 */
	private class RowRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable t, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			//设置奇偶行的背景色，可在此根据需要进行修改
			if (row % 2 == 0)
				setBackground(Color.BLUE);
			else
				setBackground(Color.GREEN);

			return super.getTableCellRendererComponent(t, value, isSelected,
					hasFocus, row, column);
		}
	}

	/**
	 * 定义内部类，可根据一个指定字符串数组来设置对应行的背景色
	 * 
	 * @author Sidney
	 * 
	 */
	private class RowColorRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable t, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			//分支判断条件可根据需要进行修改
			if (color[row].trim().equals("E")) {
				setBackground(Color.RED);
			} else if (color[row].trim().equals("H")) {
				setBackground(Color.CYAN);
			} else if (color[row].trim().equals("A")) {
				setBackground(Color.BLUE);
			} else if (color[row].trim().equals("F")) {
				setBackground(Color.ORANGE);
			} else {
				setBackground(Color.WHITE);
			}

			return super.getTableCellRendererComponent(t, value, isSelected,
					hasFocus, row, column);
		}
	}
}



