package ChildWindow.StateAssessmentFrames;

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

public class StateAssessmentFrame1 extends JFrame {

	private JFrame father;
	private JFrame self;
	public StateAssessmentFrame1(JFrame daddy) {
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
		JLabel task = new JLabel("��ǰ����");
		task.setFont(new Font("����",Font.PLAIN, 20));
		box1.add(task);
		box1.add(Box.createVerticalStrut(10));
		
		JLabel time = new JLabel("�������ʱ��");
		time.setFont(new Font("����",Font.PLAIN, 20));
		box1.add(time);
		box1.add(Box.createVerticalStrut(10));
		
		JComboBox taskField = new JComboBox();
		taskField.addItem("�����н�");
		taskField.addItem("��ս");
		taskField.addItem("����");
		taskField.addItem("��ս����");
		box2.add(taskField);
		box2.add(Box.createVerticalStrut(10));
		
		JComboBox  timeField = new JComboBox();
		timeField.addItem("1Сʱ");
		timeField.addItem("10Сʱ");
		timeField.addItem("20Сʱ");
		timeField.addItem("30Сʱ");
		timeField.addItem("40Сʱ");
		timeField.addItem("50Сʱ");
		timeField.addItem("60Сʱ");
		timeField.addItem("70Сʱ");
		timeField.addItem("80Сʱ");
		timeField.addItem("90Сʱ");
		timeField.addItem("100Сʱ");
		box2.add(timeField);
		
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(box2);
		box3.setBounds(100,50,300,70);
		add(box3);
		
		JButton start = new JButton("״̬����");
		start.setBounds(150, 150, 100, 50);
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StateAssessmentFrame2 stateAssessmentFrame2 = new StateAssessmentFrame2(self);
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
		StateAssessmentFrame1 a = new StateAssessmentFrame1(daddy);
		
	}
}
