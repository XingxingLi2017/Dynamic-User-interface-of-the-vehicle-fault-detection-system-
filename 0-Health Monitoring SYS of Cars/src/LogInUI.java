import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class LogInUI extends JFrame {
	private Main father;
	private String password;
	private String username;
	private JPanel contentPane;
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
	
	/**
	 * Create the frame.
	 */
	public LogInUI(Main mainframe) 
	{
		father = mainframe;
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		this.setContentPane(contentPane);
		
		
		password = new String();
		username = new String();
		
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(30, 40, 50, 50);
		label.setFont(new Font("宋体",Font.BOLD,15));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(30, 110, 50, 50);
		label_1.setFont(new Font("宋体",Font.BOLD,15));
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 120, 255, 25);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(90, 55, 255, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password = String.valueOf(passwordField.getPassword());
				username = String.valueOf(textField.getText());
				JOptionPane.showMessageDialog(null,"username = "+username+"\n"+"password = "+password+"\n");
				father.getHealthManagementUI().iniFrame();
				change(father.getHealthManagementUI());
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 12));
		button.setBounds(224, 162, 94, 37);
		contentPane.add(button);
		
		btnNewButton = new JButton("1");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"1");
				passwordField.requestFocus();
			}
		});
		btnNewButton.setBounds(10, 155, 42, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"2");
				passwordField.requestFocus();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 12));
		btnNewButton_1.setBounds(62, 155, 42, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"3");
				passwordField.requestFocus();
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 12));
		btnNewButton_2.setBounds(114, 155, 42, 23);
		contentPane.add(btnNewButton_2);
		
		button_1 = new JButton("4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"4");
				passwordField.requestFocus();
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 12));
		button_1.setBounds(10, 188, 42, 23);
		contentPane.add(button_1);
		
		button_2 = new JButton("5");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"5");
				passwordField.requestFocus();
			}
		});
		button_2.setFont(new Font("宋体", Font.BOLD, 12));
		button_2.setBounds(62, 188, 42, 23);
		contentPane.add(button_2);
		
		button_3 = new JButton("6");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"6");
				passwordField.requestFocus();
			}
		});
		button_3.setFont(new Font("宋体", Font.BOLD, 12));
		button_3.setBounds(114, 188, 42, 23);
		contentPane.add(button_3);
		
		button_4 = new JButton("7");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"7");
				passwordField.requestFocus();
			}
		});
		button_4.setFont(new Font("宋体", Font.BOLD, 12));
		button_4.setBounds(10, 221, 42, 23);
		contentPane.add(button_4);
		
		button_5 = new JButton("8");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"8");
				passwordField.requestFocus();
			}
		});
		button_5.setFont(new Font("宋体", Font.BOLD, 12));
		button_5.setBounds(62, 221, 42, 23);
		contentPane.add(button_5);
		
		button_6 = new JButton("9");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"9");
				passwordField.requestFocus();
			}
		});
		button_6.setFont(new Font("宋体", Font.BOLD, 12));
		button_6.setBounds(114, 221, 42, 23);
		contentPane.add(button_6);
		
		button_7 = new JButton("*");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"*");
				passwordField.requestFocus();
			}
		});
		button_7.setFont(new Font("宋体", Font.BOLD, 12));
		button_7.setBounds(10, 254, 42, 23);
		contentPane.add(button_7);
		
		button_8 = new JButton("0");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"0");
				passwordField.requestFocus();
			}
		});
		button_8.setFont(new Font("宋体", Font.BOLD, 12));
		button_8.setBounds(62, 254, 42, 23);
		contentPane.add(button_8);
		
		button_9 = new JButton("#");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(String.valueOf(passwordField.getPassword())+"#");
				passwordField.requestFocus();
			}
		});
		button_9.setFont(new Font("宋体", Font.BOLD, 12));
		button_9.setBounds(114, 254, 42, 23);
		contentPane.add(button_9);
		
		button_10 = new JButton("返回");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_10.setFont(new Font("宋体", Font.BOLD, 12));
		button_10.setBounds(224, 221, 94, 37);
		contentPane.add(button_10);
	}
	
	public void change(JFrame destination)
	{
		this.setVisible(false);
		destination.setVisible(true);
	}
}
