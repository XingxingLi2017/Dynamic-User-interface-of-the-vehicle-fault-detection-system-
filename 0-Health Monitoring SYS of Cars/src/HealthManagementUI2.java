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
	//一级按钮
	private JButton dataManageButton;
	private JButton maintenanceManageButton;
	private JButton stateInspectionButton;
	private JButton lifePredictionButton;
	private JButton stateSettingsButton;
	private ArrayList<JButton> firstButton;
	//二级按钮
	private ArrayList<JButton>secondButton;
	//数据管理中心二级按钮
	private JButton dataDownloadButton;
	private JButton dataUploadButton;
	private JButton dataReportButton;
	//维修管理中心二级按钮
	private JButton repairPlanButton;
	private JButton upkeepPlanButton;
	private JButton unfinishedRepairButton;
	private JButton unfinishedUpkeepButton;
	//状态检测二级按钮
	private JButton equipmentDetectionButton;
	private JButton bitDetectionButton;
	private JButton bitStartButton;
	private JButton stateAssessmentButton;
	//寿命预测二级按钮
	private JButton lifeButton;
	private JButton faultButton;
	//状态设置二级按钮
	
	//返回按钮
	private JButton backToTopButton;
	private JButton backToMainUIButton;
	
	//标记选定的一级按钮
	private int flag = 0;
	
	public HealthManagementUI2(JFrame father){
		this.father = father;
		self = this;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 1000, 500);
		setTitle("健康管理中心");
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setLayout(null);
		
		//布置一级按钮
		setFirstButton();
	
		//布置二级按钮
		setSecondButton();
		
		//布置返回上一级按钮和返回主界面按钮
		setBackButton();
		
	}
	
	
	/**
	 * 布置一级按钮函数
	 * */
	private void setFirstButton()
	{
			//布置一级按钮
			firstButton = new ArrayList<>();
			//数据管理
			dataManageButton = new JButton("数据管理中心");
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
			
			//维修管理中心
			maintenanceManageButton= new JButton("维修管理中心");
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
			
			//状态检测
			stateInspectionButton= new JButton("状态检测与评估");
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
			
			//寿命预测
			lifePredictionButton= new JButton("寿命与故障预测");
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
			
			//状态设置
			stateSettingsButton= new JButton("设置");
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
	 * 布置二级按钮
	 * */
	private void setSecondButton()
	{
		secondButton = new ArrayList<>();
	//数据管理中心二级按钮
		//数据下载
		dataDownloadButton = new JButton("数据下载");
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
		
		//数据上传
		dataUploadButton = new JButton("数据上传");
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
		
		//数据报告
		dataReportButton = new JButton("数据报告");
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
		
	//维修管理中心二级按钮
		//近期维修计划
		repairPlanButton = new JButton("近期维修计划");
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
		
		//近期保养计划
		upkeepPlanButton = new JButton("近期保养计划");
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
		
		//未完成维修计划
		unfinishedRepairButton = new JButton("未完成维修计划");
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
		
		//未完成保养计划
		unfinishedUpkeepButton = new JButton("未完成保养计划");
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
		
	//状态检测二级按钮
		//equipmentDetectionButton;
		equipmentDetectionButton = new JButton("设备状态检测");
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
		bitDetectionButton = new JButton("设备BIT检测");
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
		bitStartButton = new JButton("维修BIT启动");
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
		stateAssessmentButton = new JButton("状态评估");
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
		
	//寿命预测二级按钮
		//lifeButton;
		lifeButton = new JButton("寿命预测");
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
		faultButton = new JButton("故障预测");
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
	 * 设置返回上一级按钮
	 * */
	private void setBackButton() {
		//backToTopButton;
		backToTopButton = new JButton("返回上一级");
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
		backToMainUIButton = new JButton("返回主界面");
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
	 * 根据选择的一级按钮弹出二级按钮并让其他按钮变灰
	 * */
	public void chooseFirstButton(JButton button) {
		for(JButton b:firstButton)
		{
			if(!b.getText().equals(button.getText()))
			{
				b.setEnabled(false);
			}
		}
		//根据flag调出子菜单
		switch (flag) {
		//数据管理
		case 0:
			dataDownloadButton.setVisible(true);
			dataUploadButton.setVisible(true);
			dataReportButton.setVisible(true);
			break;
		//维修管理中心	
		case 1:
			repairPlanButton.setVisible(true);
			upkeepPlanButton.setVisible(true);
			unfinishedRepairButton.setVisible(true);
			unfinishedUpkeepButton.setVisible(true);
			break;
		//状态检测	
		case 2:
			equipmentDetectionButton.setVisible(true);
			bitDetectionButton.setVisible(true);
			bitStartButton.setVisible(true);
			stateAssessmentButton.setVisible(true);
			break;
		//寿命预测	
		case 3:
			lifeButton.setVisible(true);
			faultButton.setVisible(true);
			break;
		//状态设置	
		case 4:
			
			break;

		default:
			break;
		}
		
		
	}
	
	/**
	 * 使界面恢复初始化状态
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
