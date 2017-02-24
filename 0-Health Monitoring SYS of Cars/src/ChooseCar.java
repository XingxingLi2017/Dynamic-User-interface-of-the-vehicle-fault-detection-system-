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


public class ChooseCar extends JFrame {

	private JFrame father;
	private JFrame self;
	public ChooseCar(JFrame daddy) {
		// TODO Auto-generated constructor stub
		father = daddy;
		self = this;
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(300, 300, 500, 300);
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
		JLabel bitObject = new JLabel("选择车型");
		bitObject.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(bitObject);
		box1.add(Box.createVerticalStrut(10));
		
		JLabel bitType = new JLabel("选择车号");
		bitType.setFont(new Font("宋体",Font.PLAIN, 20));
		box1.add(bitType);
		box1.add(Box.createVerticalStrut(10));
		
		final JComboBox bitObjectField = new JComboBox();
		bitObjectField.addItem("04A");
		bitObjectField.addItem("8*8");
		bitObjectField.addItem("99A");
		box2.add(bitObjectField);
		box2.add(Box.createVerticalStrut(10));
		
		JComboBox  bitTypeField = new JComboBox();
		bitTypeField.addItem("001");
		bitTypeField.addItem("002");
		bitTypeField.addItem("003");
		bitTypeField.addItem("004");
		bitTypeField.addItem("005");
		bitTypeField.addItem("006");
		bitTypeField.addItem("007");
		bitTypeField.addItem("008");
		bitTypeField.addItem("009");
		bitTypeField.addItem("010");
		box2.add(bitTypeField);
		
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(box2);
		box3.setBounds(100,50,300,70);
		add(box3);
		
		JButton start = new JButton("启动");
		start.setBounds(150, 150, 100, 50);
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = bitObjectField.getSelectedItem().toString();
				HealthManagementUI2 healthManagementUI2 = new HealthManagementUI2(self);
				self.setVisible(false);;
			}
		});
		add(start);
		
		JButton cancel = new JButton("取消");
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
		ChooseCar a = new ChooseCar(daddy);
		
	}
}
