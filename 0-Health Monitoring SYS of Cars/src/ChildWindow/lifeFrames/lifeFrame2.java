package ChildWindow.lifeFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class lifeFrame2 extends JFrame {

	private JFrame father;
	private JFrame self;
	private JLabel tableTitle;
	private Table_Model table_Model;
	private JTable table;
	private JScrollPane scrollPane;
	
	private String name;
	private String lifeRequest;
	private String level;
	
	
	public lifeFrame2(JFrame daddy,String name,String lifeRequest,String level) {
		// TODO Auto-generated constructor stub
		father = daddy;
		self = this;
		this.name = name;
		this.lifeRequest = lifeRequest;
		this.level = level;
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
		
		JButton checkButton = new JButton("查看");
		checkButton.setBounds(700, 535, 80, 30);
		checkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChakanFrame chakanFrame = new ChakanFrame(self);
				self.setVisible(false);
			}
		});
		add(checkButton);
		
	}
	
	public void setTable() 
	{
		tableTitle = new JLabel("寿命评估结果");
		tableTitle.setFont(new Font("宋体",Font.BOLD,20));
		tableTitle.setBounds(400, 5, 200, 20);
		add(tableTitle);
		
		table_Model = new Table_Model(20);
		table = new JTable(table_Model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 30, 980, 500);
		add(scrollPane);
		
		table_Model.addRow(name, "500h", "0.78", "[0.78,0.80]", "2016年3月1日");
		
		table.setRowHeight(40);
		
	}
	
	class Table_Model extends AbstractTableModel
	{
		private Vector content = null;
		
		private String[] title_name = {"部件名称","可靠寿命",
										"置位下限","置位区间","维修时间建议"};
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
		
		public void addRow(String a, String b, String c, String d,
				String e)
		{
			Vector v = new Vector<>();
			v.add(0,a);
			v.add(1,b);
			v.add(2,c);
			v.add(3,d);
			v.add(4,e);
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
		lifeFrame2 a = new lifeFrame2(daddy,"***","***","***");
	}
}
