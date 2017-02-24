import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.NotBoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ChildWindow.RepairPlanFrame;
import CustomComponents.BrowserFrame;
import CustomComponents.ReadWebsite;
import DataSystem.*;
import FaultSystem.Fault;
import FaultSystem.Solution;
import ThreadMethod.*;


@SuppressWarnings("serial")
public class The1thUI extends JFrame {
	
	private Main father;
	private JFrame self;
	//显示数据
	private DataStorage dataStorage = null;
	private Data displayData;
	private JPanel contentPane;
	private ThreadExecutor executor;
	private Dialplot.techometer techometer = null;
	private Dialplot.odometer odometer = null;
	private JLabel techometerJLabel = null;
	private JLabel odometerJLabel = null;
	private JTextArea taskArea;
	private JTextArea oilAndWaterText = null;
	//故障报警相关
	private JButton faultwarning = null;
	private JTextArea faulTextArea = null;
	private FaultSystem.Fault displayFault = null;
	
	//左边状态栏图标
	private ImageIcon goodstateIcon;
	private ImageIcon warningstateIcon;
	private ImageIcon badstateIcon;
	//故障类型
	public static final int canSolve = 1;
	public static final int canNotSolve = 2;
	public static final int noProblem = 0;
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public The1thUI(Main mainframe ) throws IOException {
		father = mainframe;
		self = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setBounds(100, 100, 940, 550);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		displayData = new Data();
		
	//状态显示图片
		Image goodstate = ImageIO.read(new File("img/goodstate.png"));
		goodstate.getScaledInstance(15, 15, Image.SCALE_FAST);
		goodstateIcon = new ImageIcon(goodstate);
		
		Image warningstate = ImageIO.read(new File("img/warningstate.png"));
		warningstate.getScaledInstance(15, 15, Image.SCALE_FAST);
		warningstateIcon = new ImageIcon(warningstate);
		
		Image badstate = ImageIO.read(new File("img/badstate.png"));
		badstate.getScaledInstance(15, 15, Image.SCALE_FAST);
		badstateIcon = new ImageIcon(badstate);
		
		
	//转速表
		techometer = new Dialplot.techometer();
		techometer.getDial(displayData.valueOfTechometer);
		Image panel1 = ImageIO.read(new File("img/techometer.jpeg"));
		panel1.getScaledInstance(320, 320, Image.SCALE_FAST);
		ImageIcon instrumentPanel1 = new ImageIcon(panel1);
		techometerJLabel = new JLabel();
		techometerJLabel.setBackground(Color.BLACK);
		techometerJLabel.setIcon(instrumentPanel1);
		techometerJLabel.setBounds(120, 70, 320, 320);
		contentPane.add(techometerJLabel);
		contentPane.setBackground(Color.WHITE);   
		
	//里程表
		odometer = new Dialplot.odometer();
		odometer.getDial(displayData.valueOfOdometer);
		Image panel2 = ImageIO.read(new File("img/odometer.jpeg"));
		panel2.getScaledInstance(320, 320, Image.SCALE_FAST);
		ImageIcon instrumentPanel2 = new ImageIcon(panel2);
		odometerJLabel = new JLabel(instrumentPanel2);
		odometerJLabel.setBackground(Color.BLACK);
		odometerJLabel.setBounds(441, 70, 320, 320);
		contentPane.add(odometerJLabel);
		
	//任务区域
		taskArea = new JTextArea();
		taskArea.setText("当前任务：无\n当前需求：无");
		taskArea.setEditable(false);
		taskArea.setFont(new Font("宋体",Font.BOLD,15));
		taskArea.setBounds(40, 10, 150,60 );
		contentPane.add(taskArea);
		
	//油温水温显示文字
		oilAndWaterText = new JTextArea();
		String oil = String.valueOf(displayData.valueOfOilTemp);
		String water = String.valueOf(displayData.valueOfWaterTemp);
		oilAndWaterText.setText("油温："+oil+"℃ "+"水温："+water+"℃");
		oilAndWaterText.setFont(new Font("宋体",Font.BOLD,15));
		oilAndWaterText.setEditable(false);
		oilAndWaterText.setBounds(350, 40, 250, 60);
		contentPane.add(oilAndWaterText);
		
	//状态区域
		JLabel label1 = new JLabel("油量状态");
		label1.setFont(new Font("宋体", Font.PLAIN, 15));
		label1.setBounds(20, 70, 70, 20);
		contentPane.add(label1);
		JLabel oilIcon = new JLabel();
		oilIcon.setBounds(20,90, 15, 15);
		oilIcon.setIcon(badstateIcon);
		contentPane.add(oilIcon);
		
		JLabel label2 = new JLabel("弹药状态");
		label2.setFont(new Font("宋体", Font.PLAIN, 15));
		label2.setBounds(20, 120, 70, 20);
		contentPane.add(label2);
		JLabel ammunitionIcon = new JLabel();
		ammunitionIcon.setBounds(20,140, 15, 15);
		ammunitionIcon.setIcon(goodstateIcon);
		contentPane.add(ammunitionIcon);
		
	//故障诊断
		JButton faultDiagnosis = new JButton("<html>故<br>障<br>检<br>测<br>及<br>健<br>康<br>管<br>理</html>");
		faultDiagnosis.setFont(new Font("宋体",Font.BOLD,20));
		faultDiagnosis.setBorder(BorderFactory.createEtchedBorder());
		faultDiagnosis.setBounds(800,70,100,370);
		faultDiagnosis.setBackground(Color.CYAN);
		faultDiagnosis.setForeground(Color.BLUE);
		faultDiagnosis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(father.getLogInUI());
			}
		});
		contentPane.add(faultDiagnosis);
		
	//故障报警button和故障描述文字框
		faultwarning = new JButton();
		faultwarning.setBorder(BorderFactory.createEtchedBorder());
		faultwarning.setBounds(120,400,30,30);
		faultwarning.setBackground(Color.CYAN);
		faultwarning.setForeground(Color.BLUE);
		faultwarning.setVisible(false);
		faultwarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("faultWarning!");
			}
		});
		contentPane.add(faultwarning);
		
		faulTextArea = new JTextArea();
		faulTextArea.setFont(new Font("宋体",Font.BOLD,20));
		faulTextArea.setText("故障描述区域");
		faulTextArea.setEditable(false);
		faulTextArea.setBounds(190, 400, 250, 30);
		faulTextArea.setVisible(false);
		contentPane.add(faulTextArea);
		
	//帮助按钮
		Image help = ImageIO.read(new File("img/help.png"));
		BufferedImage temp = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
		Graphics g = temp.getGraphics();
		g.drawImage(help, 0, 0,50,50,null);
		g.dispose();
		ImageIcon helpIcon = new ImageIcon(temp);
		JButton helpButton = new JButton(helpIcon);
		helpButton.setBackground(Color.WHITE);
		helpButton.setBounds(850, 450, 50, 50);
		helpButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					helpListener();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(helpButton);
		
		//提示按钮
		ImageIcon noteIcon = getImageIcon(new File("img/Hint.jpg"), 70, 40);
		JButton noteButton = new JButton(noteIcon);
		noteButton.setBounds(800, 10, 70, 40);
		noteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RepairPlanFrame repairPlanFrame = new RepairPlanFrame(self);
				self.setVisible(false);
			}
		});
		contentPane.add(noteButton);

		//执行线程对像
		executor = new ThreadExecutor();
		//同步数据区
		dataStorage = new DataStorage(displayData);
		
		//随机数生成线程
		The1thUI.random random = new random();
		executor.executorThread(random);
		
		//刷新界面线程
		The1thUI.Refresh refresh = new Refresh();
		executor.executorThread(refresh);
		
	}
	
	/**
	 * 改变转速表并刷新搭载转速表图片的Label
	*/
	public void changeTheTechometer(double value) throws IOException{
		techometer.getDial(value);
		Image panel1 = ImageIO.read(new File("img/techometer.jpeg"));
		ImageIcon instrumentPanel1 = new ImageIcon(panel1);
		techometerJLabel.setIcon(instrumentPanel1);
	}
	
	/**
	 * 改变里程表并刷新搭载里程表图片的Label
	 */
	public void changeTheOdometer(double value) throws IOException 
	{
		odometer.getDial(value);
		Image panel1 = ImageIO.read(new File("img/odometer.jpeg"));
		ImageIcon instrumentPanel1 = new ImageIcon(panel1);
		odometerJLabel.setIcon(instrumentPanel1);
	}
	
	/**
	 * 改变故障警报按钮的图片和旁边的文字描述
	 * 可以查看faultID对应故障
	 * @throws IOException 
	 * */
	public void changeFaultWarning(Fault x) throws IOException {
		switch (x.getFaultID()) {
		case 0:
			faultwarning.setVisible(false);
			faulTextArea.setText("当前无故障");
			faulTextArea.setVisible(true);
			break;
			
		case 1://水温过高
//			Image pic1 = ImageIO.read(new File("img/WaterTempLight.JPG"));
//			pic1.getScaledInstance(65, 60, Image.SCALE_FAST);
//			BufferedImage temp1 = new BufferedImage(65, 60, BufferedImage.TYPE_INT_RGB);
//			Graphics g = temp1.getGraphics();
//			g.drawImage(pic1, 0, 0,65,60,null);
//			g.dispose();
			ImageIcon pic_1 = getImageIcon(new File("img/WaterTempLight.JPG") , 30, 30);
			faultwarning.setIcon(pic_1);
			faultwarning.setVisible(true);
			faulTextArea.setText(x.getFaultName());
			faulTextArea.setVisible(true);
			break;
			
		case 1000://油温过高
			ImageIcon pic_1000 = getImageIcon(new File("img/OilTempLight.JPG") , 30, 30);
			faultwarning.setIcon(pic_1000);
			faultwarning.setVisible(true);
			faulTextArea.setText(x.getFaultName());
			faulTextArea.setVisible(true);
			break;
			
		default:
			break;
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
	
	/**
	 * 改变显示的油温和水温
	 * */
	public void changeOilAndWater(double oil , double water) {
		String oiltemp = String.valueOf(oil);
		String watertemp = String.valueOf(water);
		oilAndWaterText.setText("油温："+oiltemp+"℃ "+"水温："+watertemp+"℃");
	}
	
	/**
	 * 帮助按钮监听函数
	 * */
	public void helpListener() throws URISyntaxException
	{
		if(displayFault.getFaultType() == canSolve)
		{
			//油温过高帮助
		//	String s2 = "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid=c4bdc803c23a44e496c9372fefa36225";
			
			try {
				ReadWebsite readWebsite = new ReadWebsite();
				ArrayList<String> web = readWebsite.getWebsite();
				BrowserFrame a = new BrowserFrame(self, web.get(1));
				self.setVisible(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(displayFault.getFaultType() == noProblem || displayFault == null) {
			;
		}
		else if (displayFault.getFaultType() == canNotSolve) {
			//水温过高诊断
		//	String s1 = "http://localhost:8080/ietm/ietm/tgzzdViewAction_topage.action?dmid=f848173f79384a048e90c41798c07a2b&tdpbVO.id=31b123bdae144724a8c1916554521042&pageNo=2";
			ReadWebsite readWebsite;
			try {
				readWebsite = new ReadWebsite();
				ArrayList<String> web = readWebsite.getWebsite();
				BrowserFrame a = new BrowserFrame(self, web.get(0));
				self.setVisible(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 切换到目标窗口
	 */
	public void change(JFrame destination)
	{
		this.setVisible(false);
		destination.setVisible(true);
	}
	
	
	/**
	 * 
	 *随机数发生子线程
	 *
	 */
	class random implements Runnable{
		private double valueOfTechometer;
		private double valueOfOdometer;
		private double waterTemp ;
		private double oilTemp ;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				//生成随机数并且限制显示到小数点后1位
				DecimalFormat df = new DecimalFormat("0");
				valueOfTechometer =Double.valueOf(df.format((double)(Math.random()*4000)));
				valueOfOdometer = valueOfOdometer+10;
				oilTemp = Double.valueOf(df.format((double)(Math.random()*100)));
				waterTemp = Double.valueOf(df.format((double)(Math.random()*100)));
			//	System.out.println("Random Thread!\nthe valueOfTechometer is "+String.valueOf(valueOfTechometer));
				
				Data a = new Data();
				a.valueOfTechometer = valueOfTechometer;
				a.valueOfOdometer = valueOfOdometer;
				a.valueOfOilTemp = oilTemp;
				a.valueOfWaterTemp = waterTemp;
				
				dataStorage.set(a);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 刷新界面线程,同时会监控当前显示数据是否有故障
	 *
	 */
	class Refresh implements Runnable{
		private Data oldData;
		private Data newData;
		private Solution solution;
		
		public Refresh() {
			// TODO Auto-generated constructor stub
			solution = new Solution();
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true)
			{
			//	System.out.println("Refresh thread.\ndisplay techometer is " + String.valueOf(dataStorage.getDisplayData().valueOfTechometer));
				oldData = dataStorage.getDisplayData();
				newData = dataStorage.get();
				
				//更新故障报警界面
				solution.setData(newData);
				Fault fault = solution.getTheFault();
				displayFault = fault;
		//		System.out.println("displayFault waterTemp is "+String.valueOf(newData.valueOfWaterTemp));
		//		System.out.println("displayFault ID is "+String.valueOf(displayFault.getFaultID()));
				try {
					changeFaultWarning(displayFault);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//更新油温水温显示
				changeOilAndWater(newData.valueOfOilTemp, newData.valueOfWaterTemp);
				//更新仪表盘
				try {
					changeBoard();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dataStorage.setDisplayData(newData);
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//刷新仪表盘
		public void changeBoard() throws IOException
		{
			double techometer = oldData.valueOfTechometer;
			double odometer = oldData.valueOfOdometer;
			while ((techometer != newData.valueOfTechometer) || (odometer != newData.valueOfOdometer)) {
				if((techometer+100) < newData.valueOfTechometer)
				{
					techometer = techometer +100;
					changeTheTechometer(techometer);
				}else
				if((techometer+10) < newData.valueOfTechometer)
				{
					techometer = techometer +10;
					changeTheTechometer(techometer);
				}else if(techometer < newData.valueOfTechometer)
				{
					techometer = techometer +1;
					changeTheTechometer(techometer);
				}
				
				if((techometer-100) >newData.valueOfTechometer)
				{
					techometer = techometer -100;
					changeTheTechometer(techometer);
				}
				else if((techometer-10) > newData.valueOfTechometer)
				{
					techometer = techometer -10;
					changeTheTechometer(techometer);
				}
				else if(techometer > newData.valueOfTechometer)
				{
					techometer = techometer -1;
					changeTheTechometer(techometer);
				}
				
				if(odometer < newData.valueOfOdometer)
				{
					odometer++;
					if(odometer > 2000) continue;
					changeTheOdometer(odometer);
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		try {
			Main mainframe= new Main();
			mainframe.getThe1thUI().setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}