import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import ChildWindow.DataDownloadFrame;
import ChildWindow.DataReportFrame;
import ChildWindow.DataUploadFrame;
import ChildWindow.EquipmentDetectionFrame;
import ChildWindow.RepairPlanFrame;
import ChildWindow.SettingsFrame;
import ChildWindow.UnfinishedRepairFrame;
import ChildWindow.UnfinishedUpkeepFrame;
import ChildWindow.UpkeepPlanFrame;
import ChildWindow.BitDetectionFrames.BitDetectionFrame1;
import ChildWindow.FaultButtonFrames.FaultButtonFrame1;
import ChildWindow.StateAssessmentFrames.StateAssessmentFrame1;
import ChildWindow.lifeFrames.lifeFrame1;


public class HealthManagementUI2 extends JFrame{
	private JFrame father;
	private JFrame self;
	//һ����ť
	private JButton dataManageButton;
	private JButton maintenanceManageButton;
	private JButton stateInspectionButton;
	private JButton lifePredictionButton;
	private JButton stateSettingsButton;
	private ArrayList<JButton> firstButton;
	//������ť
	private ArrayList<JButton>secondButton;
	//���ݹ������Ķ�����ť
	private JButton dataDownloadButton;
	private JButton dataUploadButton;
	private JButton dataReportButton;
	//ά�޹������Ķ�����ť
	private JButton repairPlanButton;
	private JButton upkeepPlanButton;
	private JButton unfinishedRepairButton;
	private JButton unfinishedUpkeepButton;
	//״̬��������ť
	private JButton equipmentDetectionButton;
	private JButton bitDetectionButton;
	private JButton bitStartButton;
	private JButton stateAssessmentButton;
	//����Ԥ�������ť
	private JButton lifeButton;
	private JButton faultButton;
	//״̬���ö�����ť
	
	//���ذ�ť
	private JButton backToTopButton;
	private JButton backToMainUIButton;
	
	//���ѡ����һ����ť
	private int flag = 0;
	
	public HealthManagementUI2(JFrame father){
		this.father = father;
		self = this;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 1000, 500);
		setTitle("������������");
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setLayout(null);
		
		//����һ����ť
		setFirstButton();
	
		//���ö�����ť
		setSecondButton();
		
		//���÷�����һ����ť�ͷ��������水ť
		setBackButton();
		
	}
	
	
	/**
	 * ����һ����ť����
	 * */
	private void setFirstButton()
	{
			//����һ����ť
			firstButton = new ArrayList<>();
			//���ݹ���
			dataManageButton = new JButton("���ݹ�������");
			dataManageButton.setBounds(50, 20, 150, 50);
			firstButton.add(dataManageButton);
			dataManageButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flag = 0;
					chooseFirstButton(dataManageButton);
				}
			});
			getContentPane().add(dataManageButton);
			
			//ά�޹�������
			maintenanceManageButton= new JButton("ά�޹�������");
			maintenanceManageButton.setBounds(220, 20, 150, 50);
			firstButton.add(maintenanceManageButton);
			maintenanceManageButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flag = 1;
					chooseFirstButton(maintenanceManageButton);
				}
			});
			getContentPane().add(maintenanceManageButton);
			
			//״̬���
			stateInspectionButton= new JButton("״̬���������");
			stateInspectionButton.setBounds(390, 20, 150, 50);
			firstButton.add(stateInspectionButton);
			stateInspectionButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flag = 2;
					chooseFirstButton(stateInspectionButton);
				}
			});
			getContentPane().add(stateInspectionButton);
			
			//����Ԥ��
			lifePredictionButton= new JButton("���������Ԥ��");
			lifePredictionButton.setBounds(560, 20, 150, 50);
			firstButton.add(lifePredictionButton);
			lifePredictionButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flag = 3;
					chooseFirstButton(lifePredictionButton);
				}
			});
			getContentPane().add(lifePredictionButton);
			
			//״̬����
			stateSettingsButton= new JButton("����");
			stateSettingsButton.setBounds(730, 20, 150, 50);
			firstButton.add(stateSettingsButton);
			stateSettingsButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
//					flag = 4;
//					chooseFirstButton(stateSettingsButton);
					SettingsFrame settingsFrame = new SettingsFrame(self);
					self.setVisible(false);
				}
			});
			getContentPane().add(stateSettingsButton);
	}
	
	/**
	 * ���ö�����ť
	 * */
	private void setSecondButton()
	{
		secondButton = new ArrayList<>();
	//���ݹ������Ķ�����ť
		//��������
		dataDownloadButton = new JButton("��������");
		dataDownloadButton.setBounds(50, 90, 150, 50);
		dataDownloadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DataDownloadFrame dataDownloadFrame = new DataDownloadFrame(self);
				self.setVisible(false);
			}
		});
		secondButton.add(dataDownloadButton);
		getContentPane().add(dataDownloadButton);
		
		//�����ϴ�
		dataUploadButton = new JButton("�����ϴ�");
		dataUploadButton.setBounds(50, 160, 150, 50);
		dataUploadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DataUploadFrame dataUploadFrame = new DataUploadFrame(self);
				self.setVisible(false);
			}
		});
		secondButton.add(dataUploadButton);
		getContentPane().add(dataUploadButton);
		
		//���ݱ���
		dataReportButton = new JButton("���ݱ���");
		dataReportButton.setBounds(50, 230, 150, 50);
		dataReportButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DataReportFrame dataReportFrame = new DataReportFrame(self);
				self.setVisible(false);
			}
		});
		secondButton.add(dataReportButton);
		getContentPane().add(dataReportButton);
		
	//ά�޹������Ķ�����ť
		//����ά�޼ƻ�
		repairPlanButton = new JButton("����ά�޼ƻ�");
		repairPlanButton.setBounds(220, 90, 150, 50);
		repairPlanButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RepairPlanFrame repairPlanFrame = new RepairPlanFrame(self);
				self.setVisible(false);
			}
		});
		secondButton.add(repairPlanButton);
		getContentPane().add(repairPlanButton);
		
		//���ڱ����ƻ�
		upkeepPlanButton = new JButton("���ڱ����ƻ�");
		upkeepPlanButton.setBounds(220, 160, 150, 50);
		upkeepPlanButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpkeepPlanFrame upkeepPlanFrame = new UpkeepPlanFrame(self);
				self.setVisible(false);
			}
		});
		secondButton.add(upkeepPlanButton);
		getContentPane().add(upkeepPlanButton);
		
		//δ���ά�޼ƻ�
		unfinishedRepairButton = new JButton("δ���ά�޼ƻ�");
		unfinishedRepairButton.setBounds(220, 230, 150, 50);
		unfinishedRepairButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UnfinishedRepairFrame unfinishedRepairFrame = new UnfinishedRepairFrame(self);
				self.setVisible(false);
			}
		});
		secondButton.add(unfinishedRepairButton);
		getContentPane().add(unfinishedRepairButton);
		
		//δ��ɱ����ƻ�
		unfinishedUpkeepButton = new JButton("δ��ɱ����ƻ�");
		unfinishedUpkeepButton.setBounds(220, 300, 150, 50);
		unfinishedUpkeepButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UnfinishedUpkeepFrame unfinishedUpkeepFrame = new UnfinishedUpkeepFrame(self);
				self.setVisible(false);
			}
		});
		secondButton.add(unfinishedUpkeepButton);
		getContentPane().add(unfinishedUpkeepButton);
		
	//״̬��������ť
		//equipmentDetectionButton;
		equipmentDetectionButton = new JButton("�豸״̬���");
		equipmentDetectionButton.setBounds(390, 90, 150, 50);
		equipmentDetectionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EquipmentDetectionFrame equipmentDetectionFrame = new EquipmentDetectionFrame(self);
				self.setVisible(false);
			}
		});
		secondButton.add(equipmentDetectionButton);
		getContentPane().add(equipmentDetectionButton);
		
		//bitDetectionButton;
		bitDetectionButton = new JButton("�豸BIT���");
		bitDetectionButton.setBounds(390, 160, 150, 50);
		bitDetectionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BitDetectionFrame1 bitDetectionFrame1 = new BitDetectionFrame1(self);
				self.setVisible(false);
			}
		});
		secondButton.add(bitDetectionButton);
		getContentPane().add(bitDetectionButton);
		
		//bitStartButton;
		bitStartButton = new JButton("ά��BIT����");
		bitStartButton.setBounds(390, 230, 150, 50);
		bitStartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BitDetectionFrame1 bitDetectionFrame1 = new BitDetectionFrame1(self);
				self.setVisible(false);
			}
		});
		secondButton.add(bitStartButton);
		getContentPane().add(bitStartButton);
		
		//stateAssessmentButton;
		stateAssessmentButton = new JButton("״̬����");
		stateAssessmentButton.setBounds(390, 300, 150, 50);
		stateAssessmentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StateAssessmentFrame1 stateAssessmentFrame1 = new StateAssessmentFrame1(self);
				self.setVisible(false);
			}
		});
		secondButton.add(stateAssessmentButton);
		getContentPane().add(stateAssessmentButton);
		
	//����Ԥ�������ť
		//lifeButton;
		lifeButton = new JButton("����Ԥ��");
		lifeButton.setBounds(560, 90, 150, 50);
		lifeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lifeFrame1 LifeFrame1 = new lifeFrame1(self);
				self.setVisible(false);
			}
		});
		secondButton.add(lifeButton);
		getContentPane().add(lifeButton);
		
		//faultButton;
		faultButton = new JButton("����Ԥ��");
		faultButton.setBounds(560, 160, 150, 50);
		faultButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FaultButtonFrame1 faultButtonFrame1 = new FaultButtonFrame1(self);
				self.setVisible(false);
			}
		});
		secondButton.add(faultButton);
		getContentPane().add(faultButton);
		
		for(JButton b:secondButton)
		{
			b.setVisible(false);
		}
		
	}
	
	/**
	 * ���÷�����һ����ť
	 * */
	private void setBackButton() {
		//backToTopButton;
		backToTopButton = new JButton("������һ��");
		backToTopButton.setBounds(560,370,150,50);
		backToTopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				for(JButton b:firstButton)
				{
					b.setEnabled(true);
				}
				for(JButton c:secondButton)
				{
					c.setVisible(false);
				}
			}
		});
		getContentPane().add(backToTopButton);
		//backToMainUIButton;
		backToMainUIButton = new JButton("����������");
		backToMainUIButton.setBounds(730,370,150,50);
		backToMainUIButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				father.setVisible(true);
				self.dispose();
			}
		});
		getContentPane().add(backToMainUIButton);
	}
	
	/**
	 * ����ѡ���һ����ť����������ť����������ť���
	 * */
	public void chooseFirstButton(JButton button) {
		for(JButton b:firstButton)
		{
			if(!b.getText().equals(button.getText()))
			{
				b.setEnabled(false);
			}
		}
		//����flag�����Ӳ˵�
		switch (flag) {
		//���ݹ���
		case 0:
			dataDownloadButton.setVisible(true);
			dataUploadButton.setVisible(true);
			dataReportButton.setVisible(true);
			break;
		//ά�޹�������	
		case 1:
			repairPlanButton.setVisible(true);
			upkeepPlanButton.setVisible(true);
			unfinishedRepairButton.setVisible(true);
			unfinishedUpkeepButton.setVisible(true);
			break;
		//״̬���	
		case 2:
			equipmentDetectionButton.setVisible(true);
			bitDetectionButton.setVisible(true);
			bitStartButton.setVisible(true);
			stateAssessmentButton.setVisible(true);
			break;
		//����Ԥ��	
		case 3:
			lifeButton.setVisible(true);
			faultButton.setVisible(true);
			break;
		//״̬����	
		case 4:
			
			break;

		default:
			break;
		}
		
		
	}
	
	/**
	 * ʹ����ָ���ʼ��״̬
	 * */
	
	public void iniFrame() 
	{
		for(JButton b:firstButton)
		{
			b.setEnabled(true);
			b.setVisible(true);
		}
		for(JButton c:secondButton)
		{
			c.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		JFrame aFrame = new JFrame();
		HealthManagementUI2 healthManagementUI2 = new HealthManagementUI2(aFrame);
		
	}

}
