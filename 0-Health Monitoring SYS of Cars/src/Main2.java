import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Main2 extends JFrame {

	private JFrame self;
	public Main2()
	{
		self = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(50,50,1300,800);
		
		setLayout(null);
		
		MyPanel myPanel = new MyPanel();
		setContentPane(myPanel);
		
		validate();
	}
	
	class MyPanel extends JPanel
	{
		private String password;
		private String username;
		private JPasswordField passwordField;
		private JTextField textField;
		private JButton btnNewButton;
		private JButton btnNewButton_1;
		private JButton btnNewButton_2;
		private JButton button_1;
		private JButton button_2;
		private JButton button_3;
		private JButton button_4;
		private JButton button_5;
		private JButton button_6;
		private JButton button_7;
		private JButton button_8;
		private JButton button_9;
		private JButton button_10;
		
		public MyPanel()
		{
			setBounds(0, 0, 1300, 800);
			setLayout(null);
			
			JLabel title = new JLabel("装甲车辆故障与健康管理系统");
			title.setBounds(400, 50, 700, 100);
			title.setFont(new Font("宋体",Font.BOLD,40));
			this.add(title);
			
			password = new String();
			username = new String();
			
			JLabel label = new JLabel("用户名");
			label.setBounds(430, 140, 100, 100);
			label.setFont(new Font("宋体",Font.BOLD,25));
			this.add(label);
			
			JLabel label_1 = new JLabel("密码");
			label_1.setBounds(430, 210, 100, 100);
			label_1.setFont(new Font("宋体",Font.BOLD,25));
			this.add(label_1);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(520, 250, 255, 25);
			this.add(passwordField);
			
			textField = new JTextField();
			textField.setBounds(520, 180, 255, 25);
			this.add(textField);
			textField.setColumns(10);
			
			JButton button = new JButton("确定");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					password = String.valueOf(passwordField.getPassword());
					username = String.valueOf(textField.getText());
					JOptionPane.showMessageDialog(null,"username = "+username+"\n"+"password = "+password+"\n");
					ChooseCar chooseCar = new ChooseCar(self);
					self.setVisible(false);
				}
			});
			button.setFont(new Font("宋体", Font.BOLD, 12));
			button.setBounds(680, 300, 100, 40);
			this.add(button);
			
			button_10 = new JButton("返回");
			button_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			button_10.setFont(new Font("宋体", Font.BOLD, 12));
			button_10.setBounds(680, 400, 100, 40);
			this.add(button_10);
			
			btnNewButton = new JButton("1");
			btnNewButton.setFont(new Font("宋体", Font.BOLD, 12));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"1");
					passwordField.requestFocus();
				}
			});
			btnNewButton.setBounds(450, 300, 50, 50);
			this.add(btnNewButton);
			
			btnNewButton_1 = new JButton("2");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"2");
					passwordField.requestFocus();
				}
			});
			btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 12));
			btnNewButton_1.setBounds(510, 300, 50, 50);
			this.add(btnNewButton_1);
			
			btnNewButton_2 = new JButton("3");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"3");
					passwordField.requestFocus();
				}
			});
			btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 12));
			btnNewButton_2.setBounds(570, 300, 50,50);
			this.add(btnNewButton_2);
			
			button_1 = new JButton("4");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"4");
					passwordField.requestFocus();
				}
			});
			button_1.setFont(new Font("宋体", Font.BOLD, 12));
			button_1.setBounds(450, 360, 50, 50);
			this.add(button_1);
			
			button_2 = new JButton("5");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"5");
					passwordField.requestFocus();
				}
			});
			button_2.setFont(new Font("宋体", Font.BOLD, 12));
			button_2.setBounds(510,360, 50, 50);
			this.add(button_2);
			
			button_3 = new JButton("6");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"6");
					passwordField.requestFocus();
				}
			});
			button_3.setFont(new Font("宋体", Font.BOLD, 12));
			button_3.setBounds(570, 360, 50,50);
			this.add(button_3);
			
			button_4 = new JButton("7");
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"7");
					passwordField.requestFocus();
				}
			});
			button_4.setFont(new Font("宋体", Font.BOLD, 12));
			button_4.setBounds(450, 420, 50, 50);
			this.add(button_4);
			
			button_5 = new JButton("8");
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"8");
					passwordField.requestFocus();
				}
			});
			button_5.setFont(new Font("宋体", Font.BOLD, 12));
			button_5.setBounds(510, 420, 50, 50);
			this.add(button_5);
			
			button_6 = new JButton("9");
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"9");
					passwordField.requestFocus();
				}
			});
			button_6.setFont(new Font("宋体", Font.BOLD, 12));
			button_6.setBounds(570, 420, 50, 50);
			this.add(button_6);
			
			button_7 = new JButton("*");
			button_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"*");
					passwordField.requestFocus();
				}
			});
			button_7.setFont(new Font("宋体", Font.BOLD, 12));
			button_7.setBounds(450, 480, 50, 50);
			this.add(button_7);
			
			button_8 = new JButton("0");
			button_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"0");
					passwordField.requestFocus();
				}
			});
			button_8.setFont(new Font("宋体", Font.BOLD, 12));
			button_8.setBounds(510, 480, 50, 50);
			this.add(button_8);
			
			button_9 = new JButton("#");
			button_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordField.setText(String.valueOf(passwordField.getPassword())+"#");
					passwordField.requestFocus();
				}
			});
			button_9.setFont(new Font("宋体", Font.BOLD, 12));
			button_9.setBounds(570,480, 50, 50);
			this.add(button_9);
			
			
			
		}
		
		public void paintComponent(Graphics g)
		{
			ImageIcon icon;
			try {
				icon = getImageIcon(new File("img/ArmoredCar.jpg"), 1300, 800);
				g.drawImage(icon.getImage(), 0, 0, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public ImageIcon getImageIcon(File file, int width , int height) throws IOException
	{
		Image pic1 = ImageIO.read(file);
		pic1.getScaledInstance(width, height, Image.SCALE_FAST);
		BufferedImage temp1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = temp1.getGraphics();
		g.drawImage(pic1, 0, 0,width,height,null);
		g.dispose();
		ImageIcon picIcon = new ImageIcon(temp1);
		return picIcon;
	}
	
	public static void main(String[] args) {
		new Main2();
	}
}
