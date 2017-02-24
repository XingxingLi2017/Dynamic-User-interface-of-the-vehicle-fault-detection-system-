package ChildWindow.BitDetectionFrames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class BitDetectionFrame2 extends JFrame {

	private JFrame father;
	private String equipmentName;
	private String state;
	private String faultName;
	private String strategy;
	
	public BitDetectionFrame2(JFrame daddy,String equipName,String state,
			String faultname, String strategy) {
		// TODO Auto-generated constructor stub
		this.father = daddy;
		this.equipmentName = equipName;
		this.state = state;
		this.faultName = faultname;
		this.strategy = strategy;
		
		father = daddy;
		//设置子窗口基本属性，子窗口的关闭按钮为回到父亲界面
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(10, 10, 700,500 );
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
		
		JLabel title = new JLabel("设备BIT检测报告");
		title.setFont(new Font("宋体", Font.PLAIN, 20));
		title.setBounds(250, 10, 200, 30);
		add(title);
		//布置内容
		
		Box b1 = Box.createVerticalBox();
		JLabel nameJLabel = new JLabel("设备名称");
		nameJLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		b1.add(nameJLabel);
		b1.add(Box.createVerticalStrut(10));
		JTextArea nameJTextField = new JTextArea();
		nameJTextField.setText(equipmentName);
		nameJTextField.setEditable(false);
		nameJTextField.setBorder(BorderFactory.createLineBorder(Color.black));
		b1.add(nameJTextField);
		
		
		Box b2 = Box.createVerticalBox();
		JLabel stateJLabel = new JLabel("目标状态");
		stateJLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		b2.add(stateJLabel);
		b2.add(Box.createVerticalStrut(10));
		JTextArea stateJTextField = new JTextArea();
		stateJTextField.setText(this.state);
		stateJTextField.setEditable(false);
		stateJTextField.setBorder(BorderFactory.createLineBorder(Color.black));
		b2.add(stateJTextField);
		
		Box b3 = Box.createVerticalBox();
		JLabel fautNameLabel = new JLabel("故障名称");
		fautNameLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		b3.add(fautNameLabel);
		b3.add(Box.createVerticalStrut(10));
		JTextArea fautNameJTextField = new JTextArea();
		fautNameJTextField.setText(this.faultName);
		fautNameJTextField.setEditable(false);
		fautNameJTextField.setBorder(BorderFactory.createLineBorder(Color.black));
		b3.add(fautNameJTextField);
		
		Box b4 = Box.createVerticalBox();
		JLabel strategyJLabel = new JLabel("策略");
		strategyJLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		b4.add(strategyJLabel);
		b4.add(Box.createVerticalStrut(10));
		JTextArea strategyJTextField = new JTextArea();
		strategyJTextField.setText(this.strategy);
		strategyJTextField.setEditable(false);
		strategyJTextField.setBorder(BorderFactory.createLineBorder(Color.black));
		b4.add(strategyJTextField);
		
		Box b5 = Box.createHorizontalBox();
		b5.add(b1);
		b5.add(Box.createHorizontalStrut(10));
		b5.add(b2);
		b5.add(Box.createHorizontalStrut(10));
		b5.add(b3);
		b5.add(Box.createHorizontalStrut(10));
		b5.add(b4);
		
		b5.setBounds(20, 50, 660, 330);
		add(b5);
		
		JButton confirmButton = new JButton("确认");
		confirmButton.setBounds(480, 390, 80, 50);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				father.setVisible(true);
				dispose();
			}
		});
		add(confirmButton);
		
		JButton backbButton = new JButton("返回");
		backbButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				father.setVisible(true);
				dispose();
			}
		});
		backbButton.setBounds(580, 390, 80, 50);
		add(backbButton);
		
		validate();
	}
	
	public static void main(String[] args) {
		JFrame daddy = new JFrame();
		daddy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BitDetectionFrame2 a = new BitDetectionFrame2(daddy,"综合电子",
				"目标不正常","通讯中断",
				"查询总线通讯协议");
		
	}
}
