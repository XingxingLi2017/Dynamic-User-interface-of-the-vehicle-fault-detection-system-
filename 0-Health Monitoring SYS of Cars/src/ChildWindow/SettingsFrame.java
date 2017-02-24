package ChildWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import CustomComponents.ReadWebsite;
import CustomComponents.WriteWebsite;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class SettingsFrame extends JFrame {

	private JFrame father;
	ReadWebsite readWebsite;
	ArrayList<String> website;
	
	
	JTextField jTextField_1_1 = new JTextField();
	JTextField jTextField_1_2 = new JTextField();
	JTextField jTextField_2 = new JTextField();
	JTextField jTextField_3 = new JTextField();
	JTextField jTextField_4 = new JTextField();
	JTextField jTextField_5 = new JTextField();
	JTextField jTextField_6 = new JTextField();
	JTextField jTextField_7 = new JTextField();
	JTextField jTextField_8 = new JTextField();
	JTextField jTextField_9 = new JTextField();
	JTextField jTextField_10 = new JTextField();
	JTextField jTextField_11 = new JTextField();
	JTextField jTextField_12 = new JTextField();
	
	public SettingsFrame(JFrame daddy) {
		// TODO Auto-generated constructor stub
		father = daddy;
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(10, 10, 700, 700);
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
		
		
		try {
			readWebsite = new ReadWebsite();
			website = readWebsite.getWebsite();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(website);
		
		JLabel linkPlaceJLabel = new JLabel("链接到IETM处：");
		linkPlaceJLabel.setBounds(20, 20, 100, 40);
		add(linkPlaceJLabel);
		
		JLabel midJLabel = new JLabel("Mid值");
		midJLabel.setBounds(300, 20, 150, 40);
		add(midJLabel);
		
		JLabel tdpbVOid = new JLabel("tdpbVO.id值");
		tdpbVOid.setBounds(450, 20, 150, 40);
		add(tdpbVOid);
		
		jTextField_1_2.setBounds(450, 70, 200, 35);
		add(jTextField_1_2);
		
		Box box1 = Box.createVerticalBox();
		Box box2 = Box.createVerticalBox();
		Box box3 = Box.createHorizontalBox();
		
		JLabel jLabel_1 = new JLabel("主界面帮助按钮水温过高");
		box1.add(jLabel_1);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_2 = new JLabel("主界面帮助按钮油温过高");
		box1.add(jLabel_2);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_3 = new JLabel("维修管理中心,近期维修计划,第1行");
		box1.add(jLabel_3);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_4 = new JLabel("维修管理中心,近期维修计划,第2行");
		box1.add(jLabel_4);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_5 = new JLabel("维修管理中心,近期保养计划,第1行");
		box1.add(jLabel_5);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_6 = new JLabel("维修管理中心,近期保养计划,第2行");
		box1.add(jLabel_6);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_7 = new JLabel("维修管理中心,未完成维修计划,第1行");
		box1.add(jLabel_7);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_8 = new JLabel("维修管理中心,未完成维修计划,第2行");
		box1.add(jLabel_8);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_9 = new JLabel("维修管理中心,未完成保养计划,第1行");
		box1.add(jLabel_9);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_10 = new JLabel("维修管理中心,未完成保养计划,第2行");
		box1.add(jLabel_10);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_11 = new JLabel("状态检测与评估,设备状态检测,第2行");
		box1.add(jLabel_11);
		box1.add(Box.createVerticalStrut(25));
		
		JLabel jLabel_12 = new JLabel("状态检测与评估,状态评估,第2行");
		box1.add(jLabel_12);
		box1.add(Box.createVerticalStrut(25));
		
		box2.add(jTextField_1_1);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_2);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_3);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_4);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_5);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_6);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_7);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_8);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_9);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_10);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_11);
		box2.add(Box.createVerticalStrut(5));
		box2.add(jTextField_12);
		
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(box2);
		box3.setBounds(20,70,400,500);
		add(box3);
		
	
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setBounds(300,600, 100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeTheWebsite();
				JOptionPane.showMessageDialog(null, "修改链接成功");
			}
		});
		add(confirmButton);
		
		validate();
	}
	
	private void changeTheWebsite()
	{
		if(!jTextField_1_1.getText().isEmpty())
		{
			if(!jTextField_1_2.getText().isEmpty())
			{
				String s1 = "http://localhost:8080/ietm/ietm/tgzzdViewAction_topage.action?dmid="+jTextField_1_1.getText()+"&tdpbVO.id="+jTextField_1_2+"&pageNo=2";
				website.set(0, s1);
				System.out.println(s1);
			}
		}
		
		if(!jTextField_2.getText().isEmpty())
		{
			String s2 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_2.getText();
			website.set(1, s2);
			System.out.println(s2);
		}
		
		if(!jTextField_3.getText().isEmpty())
		{
			String s3 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_3.getText();
			website.set(2, s3);
			System.out.println(s3);
		}
		
		if(!jTextField_4.getText().isEmpty())
		{
			String s4 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_4.getText();
			website.set(3, s4);
			System.out.println(s4);
		}
		
		if(!jTextField_5.getText().isEmpty())
		{
			String s5 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_5.getText();
			website.set(4, s5);
			System.out.println(s5);
		}
		
		if(!jTextField_6.getText().isEmpty())
		{
			String s6 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_6.getText();
			website.set(5, s6);
			System.out.println(s6);
		}
		
		if(!jTextField_7.getText().isEmpty())
		{
			String s7 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_7.getText();
			website.set(6, s7);
			System.out.println(s7);
		}
		
		if(!jTextField_8.getText().isEmpty())
		{
			String s8 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_8.getText();
			website.set(7, s8);
			System.out.println(s8);
		}
		
		if(!jTextField_9.getText().isEmpty())
		{
			String s9 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_9.getText();
			website.set(8, s9);
			System.out.println(s9);
		}
		
		if(!jTextField_10.getText().isEmpty())
		{
			String s10 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_10.getText();
			website.set(9, s10);
			System.out.println(s10);
		}
		
		if(!jTextField_11.getText().isEmpty())
		{
			String s11 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_11.getText();
			website.set(10, s11);
			System.out.println(s11);
		}
		
		if(!jTextField_12.getText().isEmpty())
		{
			String s12 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid="+jTextField_12.getText();
			website.set(11, s12);
			System.out.println(s12);
		}
		
		try {
			WriteWebsite.writeWebsite(website);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		JFrame daddy = new JFrame();
		daddy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SettingsFrame a = new SettingsFrame(daddy);
		
	}
}
