package ChildWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class DataReportFrame extends JFrame {
	private JFrame father;
	private JPasswordField passwordField;
	
	public  DataReportFrame(JFrame daddy)
	{
		father = daddy;
		//设置子窗口基本属性，子窗口的关闭按钮为回到父亲界面
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(10, 10, 500, 500);
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
		
		//设置界面上半部分
		JLabel download = new JLabel("数据报告");
		download.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(download);
		box1.add(Box.createVerticalStrut(10));
		
		JLabel destination = new JLabel("报告对象");
		destination.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(destination);
		box1.add(Box.createVerticalStrut(10));
		
		JLabel cipher = new JLabel("密码");
		cipher.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(cipher);
		
		JComboBox downloadField = new JComboBox();
		downloadField.addItem("状态评估报告");
		downloadField.addItem("维修计划报告");
		downloadField.addItem("保养计划报告");
		downloadField.addItem("故障检测报告");
		box2.add(downloadField);
		box2.add(Box.createVerticalStrut(10));
		
		JComboBox  destinationField = new JComboBox();
		destinationField.addItem("中继维修中心");
		destinationField.addItem("指挥车");
		
		box2.add(destinationField);
		box2.add(Box.createVerticalStrut(10));
		
		passwordField = new JPasswordField();
		box2.add(passwordField);
		
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(box2);
		box3.setBounds(100,50,300,100);
		add(box3);
		
		//设置小键盘
		setMiniKeyboard();
		
		//确认返回按钮
		JButton confirmButton = new JButton("确认");
		confirmButton.setBounds(200, 420, 100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "数据报告成功");
			}
		});
		add(confirmButton);
		
		validate();
	}
	
	private void setMiniKeyboard() {
		JPanel keyboardPanel = new JPanel();
		keyboardPanel.setLayout(new GridLayout(4, 4, 5, 5));
		
		JButton button1=new JButton("1");
		JButton button2=new JButton("2");
		JButton button3=new JButton("3");
		JButton button4=new JButton("4");
		JButton button5=new JButton("5");
		JButton button6=new JButton("6");
		JButton button7=new JButton("7");
		JButton button8=new JButton("8");
		JButton button9=new JButton("9");
		JButton button10=new JButton("#");
		JButton button11=new JButton("0");
		JButton button12=new JButton("*");
		//小键盘监听事件
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"1");
				passwordField.requestFocus();
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"2");
				passwordField.requestFocus();
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"3");
				passwordField.requestFocus();
			}
		});
		
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"4");
				passwordField.requestFocus();
			}
		});
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"5");
				passwordField.requestFocus();
			}
		});
		
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"6");
				passwordField.requestFocus();
			}
		});
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"7");
				passwordField.requestFocus();
			}
		});
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"8");
				passwordField.requestFocus();
			}
		});
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"9");
				passwordField.requestFocus();
			}
		});
		button10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"#");
				passwordField.requestFocus();
			}
		});
		button11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"0");
				passwordField.requestFocus();
			}
		});
		button12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"*");
				passwordField.requestFocus();
			}
		});
		
		keyboardPanel.add(button1);
		keyboardPanel.add(button2);
		keyboardPanel.add(button3);
		keyboardPanel.add(button4);
		keyboardPanel.add(button5);
		keyboardPanel.add(button6);
		keyboardPanel.add(button7);
		keyboardPanel.add(button8);
		keyboardPanel.add(button9);
		keyboardPanel.add(button10);
		keyboardPanel.add(button11);
		keyboardPanel.add(button12);
		
		keyboardPanel.setBounds(100, 200, 300, 200);
		
		add(keyboardPanel);
		
	}
	
	public static void main(String[] args) {
		JFrame daddy = new JFrame();
		daddy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DataReportFrame a = new DataReportFrame(daddy);
		
	}
}
