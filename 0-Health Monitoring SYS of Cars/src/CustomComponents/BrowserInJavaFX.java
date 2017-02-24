package CustomComponents;

import java.awt.BorderLayout;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BrowserInJavaFX extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final JFXPanel jfxPanel;
	private WebEngine engine = null;
	
	public BrowserInJavaFX() {
		// TODO Auto-generated constructor stub
		jfxPanel = new JFXPanel();
		Platform.runLater(new Runnable() 
		{	
			@Override
			public void run() {
				//网页显示界面
				WebView webView = new WebView();
				webView.setLayoutX(0);
				webView.setLayoutY(30);
				webView.setPrefHeight(600);
			    webView.setPrefWidth(1000);
			    
				WebEngine webEngine = webView.getEngine();
				webEngine.load("http://www.baidu.com/");
				engine = webEngine;
				//地址栏
				final TextField addressBar = new TextField("http://www.baidu.com/");
				addressBar.setLayoutX(1);
				addressBar.setPrefWidth(960);
				addressBar.setPrefHeight(25);
				//转到按钮
				Button goButton = new Button("Go!");
				goButton.setLayoutX(1);
				goButton.setOnAction(new EventHandler<ActionEvent>(){

		            @Override
		            public void handle(ActionEvent e){
		                engine.load(addressBar.getText().startsWith("http://") ? addressBar.getText() : "http://"+addressBar.getText());
		            }
		        });
				
				webEngine.locationProperty().addListener(new ChangeListener<String>(){

	                   @Override
	                   public void changed(ObservableValue<?extends String> observable, String oldValue, String newValue){
	                       addressBar.setText(newValue);
	                   }
	            });
						
				HBox hb=new HBox();
				hb.getChildren().add(addressBar);
				hb.getChildren().add(goButton);
				
				Pane sp = new Pane();
		        sp.getChildren().add(hb);
		        sp.getChildren().add(webView);
		        
		        Scene scene = new Scene(sp);
		        
		        jfxPanel.setScene(scene);
				
			}
		});
	
		setLayout(new BorderLayout());
		add(jfxPanel, BorderLayout.CENTER);
	}
	
	public boolean isEngineAvailable()
	{
		if(engine == null) return false;
		else {
			return true;
		}
	}
	
	public void go(String url)
	{
		if(isEngineAvailable())
		engine.load(url.startsWith("http://") ? url: "http://"+url);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 10, 1020, 800);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		BrowserInJavaFX b = new BrowserInJavaFX();
		frame.add(b,BorderLayout.CENTER);
	}
}
