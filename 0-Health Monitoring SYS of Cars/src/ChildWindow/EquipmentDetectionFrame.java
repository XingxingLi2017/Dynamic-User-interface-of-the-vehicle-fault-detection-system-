package ChildWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import CustomComponents.BrowserFrame;
import CustomComponents.ReadWebsite;

public class EquipmentDetectionFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame father;
	private JLabel tableTitle;
	private Table_Model table_Model;
	private JTable table;
	private JScrollPane scrollPane;
	private JFrame self;
	
	public EquipmentDetectionFrame(JFrame daddy) {
		// TODO Auto-generated constructor stub
		father = daddy;
		self = this;
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(10, 10, 1000, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				father.setVisible(true);
				dispose();
			}
		});
		setLayout(null);
		
		setTable();
		
		JButton confirmButton = new JButton("确认");
		confirmButton.setBounds(900, 535, 80, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				father.setVisible(true);
				dispose();
			}
		});
		add(confirmButton);
		
		JButton backButton = new JButton("返回");
		backButton.setBounds(800, 535, 80, 30);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				father.setVisible(true);
				dispose();
			}
		});
		add(backButton);
		
	}
	
	public void setTable() 
	{
		tableTitle = new JLabel("设备状态检测报告");
		tableTitle.setFont(new Font("宋体",Font.BOLD,20));
		tableTitle.setBounds(400, 5, 200, 20);
		add(tableTitle);
		
		table_Model = new Table_Model(20);
		table = new JTable(table_Model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 30, 980, 500);
		add(scrollPane);
		
		table_Model.addRow("1", "火控计算机", true, false, false,"无");
		table_Model.addRow("2", "防护单元", true, false, true,"清洁水箱");
		
		table.setRowHeight(40);
		
		table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		// TODO Auto-generated method stub
	    		super.mouseClicked(e);
	    		
	    		if(table.isCellSelected(table.getSelectedRow(), table.getSelectedColumn()))
	    		{
	    			//System.out.println(table.getValueAt(table.getSelectedRow(), 0));
	    			if(table.getSelectedColumn() == 5)
	    			{
	    				if((boolean) table.getValueAt(table.getSelectedRow(), 4))
	    				{
	    					try {
		    					ReadWebsite readWebsite = new ReadWebsite();
		    					ArrayList<String> web = readWebsite.getWebsite();
		    					BrowserFrame a = new BrowserFrame(self, web.get(10));
		    					self.setVisible(false);
							} catch (Exception e2) {
								// TODO: handle exception
							}
	    				}
	    			}
	    		}
	    	}
		});
	}
	
	class Table_Model extends AbstractTableModel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Vector content = null;
		
		private String[] title_name = {"序号","设备名","开机",
										"未开机","故障","处理建议"};
		private Class[] type = {Object.class,Object.class,Boolean.class,
								Boolean.class,Boolean.class,Object.class};

		public Table_Model() {
			// TODO Auto-generated constructor stub
			content = new Vector<>();
		}
		public Table_Model(int num) {
			// TODO Auto-generated constructor stub
			content = new Vector<>(num);
		}
		public void addEmptyRow(int row) {
			Vector v = new Vector<>();
			v.add(0,null);
			v.add(1,null);
			v.add(2,null);
			v.add(3,null);
			v.add(4,null);
			v.add(5,null);
			content.add(row,v);
		}
		
		public void addRow(String order, String name , boolean boot, boolean notBoot,
				boolean fault, String suggestion)
		{
			Vector v = new Vector<>();
			v.add(0,order);
			v.add(1,name);
			v.add(2,boot);
			v.add(3,notBoot);
			v.add(4,fault);
			v.add(5,suggestion);
			content.add(v);
		}
		public void removeRow(int row) {
	        content.remove(row);
	    }
		
		public Class<?> getColumnClass(int columnIndex)
		{
		        return type[columnIndex];
		}
		
		public String getColumnName(int column) {
	        return title_name[column];
	    }
		
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) 
		{
			((Vector<Object>)content.get(rowIndex)).set(columnIndex, aValue);
			this.fireTableCellUpdated(rowIndex, columnIndex);
	    }
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return content.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return title_name.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return ((Vector<?>)content.get(rowIndex)).get(columnIndex);
		}
		
	}
	
	public static void main(String[] args) {
		JFrame daddy = new JFrame();
		daddy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EquipmentDetectionFrame a = new EquipmentDetectionFrame(daddy);
	}
}
