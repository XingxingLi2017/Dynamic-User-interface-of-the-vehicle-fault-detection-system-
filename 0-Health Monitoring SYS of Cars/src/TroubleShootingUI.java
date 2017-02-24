import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import CustomComponents.BrowserInJavaFX;


public class TroubleShootingUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Main father = null;
	private JButton backHome =  null;
	private BrowserInJavaFX browserInJavaFX;
	
	
	public TroubleShootingUI(Main main) {
		// TODO Auto-generated constructor stub
		father = main;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(1010, 720);
		
		browserInJavaFX = new BrowserInJavaFX();
		browserInJavaFX.setBounds(0, 0,1000, 650);
		browserInJavaFX.go("www.qq.com");
		add(browserInJavaFX);
		
		backHome = new JButton("返回主界面");
		backHome.setPreferredSize(new Dimension(100,30));
		backHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				change(father.getThe1thUI());
			}
		});
		backHome.setBounds(500, 650, 100, 30);
		add(backHome);
		
	}
	
	public void change(JFrame destination)
	{
		this.setVisible(false);
		destination.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			Main fraMain = new Main();
			fraMain.getTroubleShootingUI().setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
