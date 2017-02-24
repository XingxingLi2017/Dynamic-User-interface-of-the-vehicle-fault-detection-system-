package CustomComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;

public class BrowserFrame extends JFrame {
	
	private JFrame father = null;
	private String destination = null;
	private JFXPanel jfxPanel = null;
	private MyThread myThread;

	public BrowserFrame(JFrame parent , String url ) {
		// TODO Auto-generated constructor stub
		father = parent;
		destination = url;
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(10, 10, 1010, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				father.setVisible(true);
				//dispose();
				setVisible(false);
			}
		});

		//布置浏览器界面
		jfxPanel = new JFXPanel();
		myThread = new MyThread();
		
		Platform.runLater(myThread);
	
		setLayout(new BorderLayout());
		add(jfxPanel, BorderLayout.CENTER);
		
		validate();
	}
	
	class MyThread extends Thread 
	{
		@Override
		public void run() 
		{
			// TODO Auto-generated method stub
			super.run();
			
			//网页显示界面
			WebView webView = new WebView();
			webView.setLayoutX(0);
			webView.setLayoutY(30);
			webView.setPrefHeight(650);
		    webView.setPrefWidth(1000);
		    
			final WebEngine webEngine = webView.getEngine();
		//	webEngine.load("http://www.baidu.com/");
			webEngine.load(destination.startsWith("http://") ? destination: "http://"+destination);
			//地址栏
			final TextField addressBar = new TextField(destination);
			addressBar.setLayoutX(1);
			addressBar.setEditable(false);
			addressBar.setPrefWidth(960);
			addressBar.setPrefHeight(25);
			//转到按钮
//			Button goButton = new Button("Go!");
//			goButton.setLayoutX(1);
//			goButton.setOnAction(new EventHandler<ActionEvent>(){
//
//	            @Override
//	            public void handle(ActionEvent e){
//	            	webEngine.load(addressBar.getText().startsWith("http://") ? addressBar.getText() : "http://"+addressBar.getText());
//	            }
//	        });
			
			webEngine.locationProperty().addListener(new ChangeListener<String>(){

                   @Override
                   public void changed(ObservableValue<?extends String> observable, String oldValue, String newValue){
                       addressBar.setText(newValue);
                   }
            });
					
			HBox hb=new HBox();
			hb.getChildren().add(addressBar);
		//	hb.getChildren().add(goButton);
			
			Pane sp = new Pane();
	        sp.getChildren().add(hb);
	        sp.getChildren().add(webView);
	        
	        Scene scene = new Scene(sp);
	        
	        jfxPanel.setScene(scene);
			
		}
	}
	
	public static void main(String[] args) {
		JFrame a = new JFrame();
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BrowserFrame b = new BrowserFrame(a, "http://localhost:8080/ietm/ietm/twxbzViewAction_toBrowser.action?dmid=c4bdc803c23a44e496c9372fefa36225");
		
	}
}
