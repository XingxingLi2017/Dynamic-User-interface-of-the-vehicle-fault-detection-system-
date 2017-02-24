package ChildWindow.FaultButtonFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.omg.CORBA.PRIVATE_MEMBER;

public class FaultButtonFrame2 extends JFrame {

	private JFrame father;
	private JFrame self;
	private String name;
	public FaultButtonFrame2(JFrame daddy ,String faultName )
	{
		father = daddy;
		self = this;
		name = faultName;
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(10, 10, 500, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				father.setVisible(true);
				dispose();
			}
		});
		setLayout(null);
		
		JLabel nameJLabel = new JLabel("故障名称："+name);
		nameJLabel.setFont(new Font("宋体",Font.PLAIN, 20));
		nameJLabel.setBounds(150, 50, 300, 50);
		add(nameJLabel);
		
		Box box1 = Box.createVerticalBox();
		Box box2 = Box.createVerticalBox();
		Box box3 = Box.createHorizontalBox();
		
		//设置界面上半部分
		JLabel upload = new JLabel("分布类型");
		upload.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(upload);
		box1.add(Box.createVerticalStrut(10));
		
		JLabel uploadAddress = new JLabel("预测时间");
		uploadAddress.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(uploadAddress);
		box1.add(Box.createVerticalStrut(10));
		
		JLabel cipher = new JLabel("置位水平");
		cipher.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(cipher);
		
		JTextField leixingField = new JTextField();
		leixingField.setText("威布尔分布");
		leixingField.setEditable(false);
		box2.add(leixingField);
		box2.add(Box.createVerticalStrut(10));
		
		JTextField yuceshijian = new JTextField();
		yuceshijian.setText("200h");
		yuceshijian.setEditable(false);
		box2.add(yuceshijian);
		box2.add(Box.createVerticalStrut(10));
		
		JTextField zhiweishuiping = new JTextField();
		zhiweishuiping.setText("80%");
		zhiweishuiping.setEditable(false);
		box2.add(zhiweishuiping);
		
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(box2);
		box3.setBounds(100,150,300,100);
		add(box3);
		
		validate();
		
	}
	
	public static void main(String[] args) {
		JFrame a = new JFrame();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FaultButtonFrame2 faultButtonFrame2 = new FaultButtonFrame2(a, "发动机磨损");
	}
}
