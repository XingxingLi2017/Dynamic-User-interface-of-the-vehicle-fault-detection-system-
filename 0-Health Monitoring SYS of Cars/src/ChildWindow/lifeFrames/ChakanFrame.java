package ChildWindow.lifeFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ChakanFrame extends JFrame {

	private JFrame father;
	private JFrame self;
	
	public ChakanFrame(JFrame daddy)
	{
		father = daddy;
		self = this;
		
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(10, 10, 700, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				father.setVisible(true);
				dispose();
			}
		});
		
		setLayout( new BorderLayout());
		
		try {
			ImageIcon icon = getImageIcon(new File("img/Life.png"), 700, 700);
			JLabel iconJLabel = new JLabel(icon);
			add(iconJLabel,BorderLayout.CENTER);
			validate();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
	
	public ImageIcon getImageIcon(File file, int width , int height) throws IOException
	{
		Image pic1 = ImageIO.read(file);
		pic1.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage temp1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = temp1.getGraphics();
		g.drawImage(pic1, 0, 0,width,height,null);
		g.dispose();
		ImageIcon picIcon = new ImageIcon(temp1);
		return picIcon;
	}
	
	public static void main(String[] args) {
		JFrame a = new JFrame();
		ChakanFrame chakanFrame = new ChakanFrame(a);
	}
}
