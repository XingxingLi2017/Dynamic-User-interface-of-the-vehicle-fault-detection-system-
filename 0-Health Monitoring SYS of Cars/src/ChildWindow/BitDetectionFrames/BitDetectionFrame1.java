package ChildWindow.BitDetectionFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import ChildWindow.DataReportFrame;

public class BitDetectionFrame1 extends JFrame {

	private JFrame father;
	private JFrame self;
	public BitDetectionFrame1(JFrame daddy) {
		father = daddy;
		self = this;
		//�����Ӵ��ڻ������ԣ��Ӵ��ڵĹرհ�ťΪ�ص����׽���
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(10, 10, 500, 300);
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
		
		Box box1 = Box.createVerticalBox();
		Box box2 = Box.createVerticalBox();
		Box box3 = Box.createHorizontalBox();
		JLabel bitObject = new JLabel("BIT����");
		bitObject.setFont(new Font("����",Font.PLAIN, 20));
		box1.add(bitObject);
		box1.add(Box.createVerticalStrut(10));
		
		JLabel bitType = new JLabel("BIT����");
		bitType.setFont(new Font("����",Font.PLAIN, 20));
		box1.add(bitType);
		box1.add(Box.createVerticalStrut(10));
		
		final JComboBox bitObjectField = new JComboBox();
		bitObjectField.addItem("�۵��豸");
		bitObjectField.addItem("�����豸");
		bitObjectField.addItem("�����豸");
		bitObjectField.addItem("ͨѶ�豸");
		box2.add(bitObjectField);
		box2.add(Box.createVerticalStrut(10));
		
		JComboBox  bitTypeField = new JComboBox();
		bitTypeField.addItem("����BIT");
		bitTypeField.addItem("����BIT");
		bitTypeField.addItem("ά��BIT");
		box2.add(bitTypeField);
		
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(box2);
		box3.setBounds(100,50,300,70);
		add(box3);
		
		JButton start = new JButton("����");
		start.setBounds(150, 150, 100, 50);
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = bitObjectField.getSelectedItem().toString();
				BitDetectionFrame2 bitDetectionFrame2 = new BitDetectionFrame2(self, name,
						"Ŀ�겻����", "ͨѶ�ж�", "��ѯ����ͨѶЭ��");
				self.setVisible(false);;
			}
		});
		add(start);
		
		JButton cancel = new JButton("ȡ��");
		cancel.setBounds(270,150, 100, 50);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				father.setVisible(true);
				dispose();
			}
		});
		add(cancel);
		
		validate();
	}
	
	public static void main(String[] args) {
		JFrame daddy = new JFrame();
		daddy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BitDetectionFrame1 a = new BitDetectionFrame1(daddy);
		
	}
}
