package ChildWindow.StateAssessmentFrames;

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

public class StateAssessmentFrame2 extends JFrame {

	private JFrame father;
	private JLabel tableTitle;
	private Table_Model table_Model;
	private JTable table;
	private JScrollPane scrollPane;
	private JFrame self;
	
	public StateAssessmentFrame2(JFrame daddy) {
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
		tableTitle = new JLabel("状态评估报告");
		tableTitle.setFont(new Font("宋体",Font.BOLD,20));
		tableTitle.setBounds(400, 5, 200, 20);
		add(tableTitle);
		
		table_Model = new Table_Model(20);
		table = new JTable(table_Model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 30, 980, 500);
		add(scrollPane);
		
		table_Model.addRow("火力打击能力", "100%","**********", "无", "无");
		table_Model.addRow("通讯能力", "80%","********", "清洗水箱", "清洗水箱");
		
		table.setRowHeight(40);
		
		table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		// TODO Auto-generated method stub
	    		super.mouseClicked(e);
	    		
	    		if(table.isCellSelected(table.getSelectedRow(), table.getSelectedColumn()))
	    		{
	    			//System.out.println(table.getValueAt(table.getSelectedRow(), 0));
	    			if(table.getSelectedColumn() == 3)
	    			{
	    				if(!table.getValueAt(table.getSelectedRow(), 3).toString().equals("无"))
	    				{
	    					try {
		    					ReadWebsite readWebsite = new ReadWebsite();
		    					ArrayList<String> web = readWebsite.getWebsite();
		    					BrowserFrame a = new BrowserFrame(self, web.get(11));
		    					self.setVisible(false);
							} catch (Exception e2) {
								// TODO: handle exception
							}
	    				}
	    			}
	    			if(table.getSelectedColumn() == 4)
	    			{
	    				if(!table.getValueAt(table.getSelectedRow(), 4).toString().equals("无"))
	    				{
	    					try {
		    					ReadWebsite readWebsite = new ReadWebsite();
		    					ArrayList<String> web = readWebsite.getWebsite();
		    					BrowserFrame a = new BrowserFrame(self, web.get(11));
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
		private Vector content = null;
		
		private String[] title_name = {"机动能力","状态描述",
										"星化分级","降低风险建议","恢复状态建议"};
		private Class[] type = {Object.class,Object.class,
								Object.class,Object.class,Object.class};

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
			content.add(row,v);
		}
		
		public void addRow(String mobility, String state, String level, String suggestion,
				String recoverSuggestion)
		{
			Vector v = new Vector<>();
			v.add(0,mobility);
			v.add(1,state);
			v.add(2,level);
			v.add(3,suggestion);
			v.add(4,recoverSuggestion);
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
		StateAssessmentFrame2 a = new StateAssessmentFrame2(daddy);
	}
}
