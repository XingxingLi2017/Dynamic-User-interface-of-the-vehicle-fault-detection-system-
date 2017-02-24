import java.awt.EventQueue;
import java.io.IOException;

import FaultSystem.Fault;


public class Main{
	private LogInUI login;
	private The1thUI the1thUI;
	private TixingUI tixingUI;
	private Fault fault = null;
	private HealthManagementUI healthManagementUI;
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main mainframe= new Main();
					mainframe.launchFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @throws IOException 
	 */
	public Main() throws IOException{
		login = new LogInUI(this);
		the1thUI = new The1thUI(this);
		tixingUI = new TixingUI(this);
		healthManagementUI = new HealthManagementUI(this);
		
		login.setVisible(false);
		the1thUI.setVisible(false);
		tixingUI.setVisible(false);
		healthManagementUI.setVisible(false);
	}
	
	public void launchFrame()
	{
		the1thUI.setVisible(true);
	}
	
	public LogInUI getLogInUI()
	{
		return login;
	}
	
	public The1thUI getThe1thUI()
	{
		return the1thUI;
	}
	public TixingUI getTixingUI() {
		return tixingUI;
	}

	public HealthManagementUI getHealthManagementUI() {
		return healthManagementUI;
	}
	
	/**
	 * 用于在界面间传递故障信息
	 * */
	public void setFault(Fault f) {
		fault = f;
	}
	public Fault getFault() {
		if(fault == null)
		{
		//	System.out.println("In main,the fault is null.");
			;
		}
		return fault;
	}
}
