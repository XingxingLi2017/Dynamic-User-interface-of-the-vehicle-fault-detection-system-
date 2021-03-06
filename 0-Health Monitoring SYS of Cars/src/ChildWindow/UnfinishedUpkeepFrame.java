package ChildWindow;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import ChildWindow.UnfinishedUpkeepFrame.Table_Model;
import CustomComponents.BrowserFrame;
import CustomComponents.ReadWebsite;

public class UnfinishedUpkeepFrame extends JFrame {

	private JFrame father;
	private JTable table;
	private Table_Model table_Model;
	private JScrollPane scrollPane;
	private JFrame self;
	
	public UnfinishedUpkeepFrame(JFrame daddy)
	{
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
		
		JButton printButton = new JButton("打印");
		printButton.setBounds(900, 520, 80, 30);
		add(printButton);
		
		JButton uploadButton = new JButton("上传");
		uploadButton.setBounds(800, 520, 80, 30);
		add(uploadButton);
	}
	
	public void setTable() {
		table_Model = new Table_Model(20);
		table = new JTable(table_Model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 980, 500);
		add(scrollPane);
			
		table_Model.addRow("发动机", "750h", "中继级", "增压器", "恢复增压器的压比", "换件维修", "H150增压器一件", "需要密封垫XXXX；耐热螺栓M12X25", " ",true,"查看维修帮助");
	    table_Model.addRow("油箱", "550h", "中继级", "补油", "恢复油压比", "加油", "机油", " ", " ",false,"查看维修帮助");
	    table.setRowHeight(40);
	    table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		// TODO Auto-generated method stub
	    		super.mouseClicked(e);
	    		
	    		if(table.isCellSelected(table.getSelectedRow(), table.getSelectedColumn()))
	    		{
	    			//System.out.println(table.getValueAt(table.getSelectedRow(), 0));
	    			if(table.getSelectedColumn() == 10)
	    			{
	    				if(table.getValueAt(table.getSelectedRow(), 0).equals("发动机"))
	    				{
	    					try {
		    					ReadWebsite readWebsite = new ReadWebsite();
		    					ArrayList<String> web = readWebsite.getWebsite();
		    					BrowserFrame a = new BrowserFrame(self, web.get(8));
		    					self.setVisible(false);
							} catch (Exception e2) {
								// TODO: handle exception
							}
	    				}
	    				else if(table.getValueAt(table.getSelectedRow(), 0).equals("油箱"))
	    				{
	    					try {
		    					ReadWebsite readWebsite = new ReadWebsite();
		    					ArrayList<String> web = readWebsite.getWebsite();
		    					BrowserFrame a = new BrowserFrame(self, web.get(9));
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
	
	public static void main(String[] args) {
		JFrame daddy = new JFrame();
		daddy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UnfinishedUpkeepFrame a = new UnfinishedUpkeepFrame(daddy);
	}
	
	class Table_Model extends AbstractTableModel {

	    private Vector<Vector<Object>> content = null;

	    private String[] title_name = { "产品名称", "保养计划", "保养级别", "保养部位", "保养要求", "保养方式", "保养备件", "保养资源", "注意事项","完成状态确认","查看"};

	    private Class[] type = {Object.class,Object.class,Object.class,
	    						Object.class,Object.class,Object.class,
	    						Object.class,Object.class,Object.class,Boolean.class,Object.class};
	    public Table_Model() {
	        content = new Vector<Vector<Object>>();
	    }

	    public Table_Model(int count) {
	        content = new Vector<Vector<Object>>(count);
	    }

	    /** 
	     * 加入一空行 
	     * @param row 行号 
	     */
	    public void addRow(int row) {
	        Vector<Object> v = new Vector<Object>(10);
	        v.add(0, null);
	        v.add(1, null);
	        v.add(2, null);
	        v.add(3, null);
	        v.add(4, null);
	        v.add(5, null);
	        v.add(6, null);
	        v.add(7, null);
	        v.add(8, null);
	        v.add(9,null);
	        v.add(10,null);
	        content.add(row, v);
	    }

	    /** 
	     * 加入一行内容 
	     */
	    public void addRow(String name, String plan, String Jibie, String Buwei, String Yaoqiu, String Fangshi, String Beijian,
	    		String Ziyuan, String Zhuyi , Boolean queren , String chakan) {
	        Vector<Object> v = new Vector<Object>(9);
	        v.add(0, name);
	        v.add(1, plan); // JCheckBox是Boolean的默认显示组件，这里仅仅为了看效果，其实用JComboBox显示***更合适 
	        v.add(2, Jibie); // 本列在前面已经设置成了JComboBox组件，这里随便输入什么字符串都没关系 
	        v.add(3, Buwei);
	        v.add(4, Yaoqiu);
	        v.add(5, Fangshi);
	        v.add(6, Beijian);
	        v.add(7, Ziyuan);
	        v.add(8, Zhuyi);
	        v.add(9,queren);
	        v.add(10, chakan);
	        content.add(v);
	    }

	    public void removeRow(int row) {
	        content.remove(row);
	    }

	    public boolean isCellEditable(int rowIndex, int columnIndex) {
	        if(columnIndex == 9) {
	            return true;
	        }
	        return false;
	    }

	    public void setValueAt(Object value, int row, int col) {
	        ((Vector<?>) content.get(row)).remove(col);
	        ((Vector<Object>) content.get(row)).add(col, value);
	        this.fireTableCellUpdated(row, col);
	    }

	    public String getColumnName(int col) {
	        return title_name[col];
	    }

	    public int getColumnCount() {
	        return title_name.length;
	    }

	    public int getRowCount() {
	        return content.size();
	    }

	    public Object getValueAt(int row, int col) {
	        return ((Vector<?>) content.get(row)).get(col);
	    }

	    public Class<? extends Object> getColumnClass(int col) {
	        return type[col];
	    }

	}
}
