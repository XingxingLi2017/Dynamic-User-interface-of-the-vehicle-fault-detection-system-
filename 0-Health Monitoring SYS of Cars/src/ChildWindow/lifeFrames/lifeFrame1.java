package ChildWindow.lifeFrames;
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

public class lifeFrame1 extends JFrame {

	private JFrame father;
	private JFrame self;
	public lifeFrame1(JFrame daddy) {
		father = daddy;
		self = this;
		//设置子窗口基本属性，子窗口的关闭按钮为回到父亲界面
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
		
		JLabel name = new JLabel("部件名称");
		name.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(name);
		box1.add(Box.createVerticalStrut(10));
		
		JLabel lifeRequest = new JLabel("寿命要求");
		lifeRequest.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(lifeRequest);
		box1.add(Box.createVerticalStrut(10));
		
		JLabel level = new JLabel("置位水平");
		level.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(level);
		
		final JComboBox nameField = new JComboBox();
		nameField.addItem("发动机");
		nameField.addItem("变速箱");
		nameField.addItem("火炮");
		box2.add(nameField);
		box2.add(Box.createVerticalStrut(10));
		
		final JComboBox  lifeRequestField = new JComboBox();
		lifeRequestField.addItem("0.8");
		lifeRequestField.addItem("0.85");
		lifeRequestField.addItem("0.9");
		box2.add(lifeRequestField);
		box2.add(Box.createVerticalStrut(10));
		
		final JComboBox  levelField = new JComboBox();
		levelField.addItem("0.8");
		levelField.addItem("0.85");
		levelField.addItem("0.9");
		box2.add(levelField);
		
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(box2);
		box3.setBounds(100,50,300,100);
		add(box3);
		
		JButton start = new JButton("预测评估");
		start.setBounds(150, 200, 100, 50);
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = nameField.getSelectedItem().toString();
				String life = lifeRequestField.getSelectedItem().toString();
				String level = levelField.getSelectedItem().toString();
				lifeFrame2 LifeFrame2 = new lifeFrame2(self, name, life, level);
				self.setVisible(false);;
			}
		});
		add(start);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(270,200, 100, 50);
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
		lifeFrame1 a = new lifeFrame1(daddy);
		
	}
}
