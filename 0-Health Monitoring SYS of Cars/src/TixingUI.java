import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class TixingUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Main father;
	
	private JFrame frame = null;

    private JTable table = null;

    private Table_Model model = null;

    private JScrollPane s_pan = null;

    public TixingUI(Main main) {
    	father = main;
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setTitle("ά�޼ƻ���");
    	
        //frame = new JFrame("ά�޼ƻ���");
        model = new Table_Model(20);
        table = new JTable(model);
      //  String[] age = { "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
   //     JComboBox com = new JComboBox(age);
        TableColumnModel tcm = table.getColumnModel();
   //     tcm.getColumn(2).setCellEditor(new DefaultCellEditor(com)); // ����ĳ�в���JComboBox��� 


        model.addRow("������", "750h", "�м̼�", "��ѹ��", "�ָ���ѹ����ѹ��", "����ά��", "H150��ѹ��һ��", "��Ҫ�ܷ��XXXX��������˨M12X25", " ");
        model.addRow("����", "550h", "�м̼�", "����", "�ָ���ѹ��", "����", "����", " ", " ");
        table.setRowHeight(40);
        
        s_pan = new JScrollPane(table);

       // frame.getContentPane().add(s_pan, BorderLayout.CENTER);
        this.getContentPane().add(s_pan, BorderLayout.CENTER);
        
        JButton returnBotton = new JButton("����������");
        returnBotton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				change(father.getThe1thUI());
			}
		});
      //  frame.getContentPane().add(returnBotton, BorderLayout.SOUTH);
        this.getContentPane().add(returnBotton, BorderLayout.SOUTH);
        this.setSize(1000, 700);

        //model.addRow(2); // ��ĳ������һ���� 

        //table.updateUI(); // ˢ�� 

    }

    public static void main(String args[]) throws IOException 
    {
		Main main = new Main();
		TixingUI frame = main.getTixingUI();
		frame.setVisible(true);
			
    }
    
    public void change(JFrame destination) {
		this.setVisible(false);
		destination.setVisible(true);
	}

}

class Table_Model extends AbstractTableModel {
    private static final long serialVersionUID = -3094977414157589758L;

    private Vector content = null;

    private String[] title_name = { "��Ʒ����", "ά�޼ƻ�", "ά�޼���", "ά�޲�λ", "ά��Ҫ��", "ά�޷�ʽ", "ά�ޱ���", "ά����Դ", "ע������"};

    public Table_Model() {
        content = new Vector();
    }

    public Table_Model(int count) {
        content = new Vector(count);
    }

    /** 
     * ����һ���� 
     * @param row �к� 
     */
    public void addRow(int row) {
        Vector v = new Vector(9);
        v.add(0, null);
        v.add(1, null);
        v.add(2, null);
        v.add(3, null);
        v.add(4, null);
        v.add(5, null);
        v.add(6, null);
        v.add(7, null);
        v.add(8, null);
        content.add(row, v);
    }

    /** 
     * ����һ������ 
     */
    public void addRow(String name, String plan, String Jibie, String Buwei, String Yaoqiu, String Fangshi, String Beijian,
    		String Ziyuan, String Zhuyi) {
        Vector v = new Vector(9);
        v.add(0, name);
        v.add(1, plan); // JCheckBox��Boolean��Ĭ����ʾ������������Ϊ�˿�Ч������ʵ��JComboBox��ʾ***������ 

        v.add(2, Jibie); // ������ǰ���Ѿ����ó���JComboBox����������������ʲô�ַ�����û��ϵ 
        
        v.add(3, Buwei);
        v.add(4, Yaoqiu);
        v.add(5, Fangshi);
        v.add(6, Beijian);
        v.add(7, Ziyuan);
        v.add(8, Zhuyi);
        

        content.add(v);
    }

    public void removeRow(int row) {
        content.remove(row);
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(rowIndex == 2) {
            return false;
        }
        return true;
    }

    public void setValueAt(Object value, int row, int col) {
        ((Vector) content.get(row)).remove(col);
        ((Vector) content.get(row)).add(col, value);
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
        return ((Vector) content.get(row)).get(col);
    }

    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }

}