/**
@author Chaz Kerby
*/
package com.chazwarp.jasau.JFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import com.chazwarp.jasau.JFrame.listeners.LoginListener;
import com.chazwarp.jasau.JFrame.listeners.StartNewUploadListener;

public class MainWindow {

	static JFrame mainWindow = new JFrame("Just a Simple Auto Uploader");
	static JPanel mainPanel;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static JMenuBar menuBar;
	static JMenu optionsMenu;
	static JMenuItem login;
	public static JProgressBar uploadProgress;
	public static JTextField caption;
	public static JTextField tags;
	static JButton startUpload;
	
	public static JFrame CreateWindow() {
		
		try {
			mainWindow.setIconImage(CreateImageIcon("/com/chazwarp/jasau/resources/Jasau.png").getImage());
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		menuBar = new JMenuBar();
		mainWindow.setJMenuBar(menuBar);
		mainPanel = new JPanel(new GridBagLayout());
		mainWindow.add(mainPanel);
		optionsMenu = new JMenu("Options");
		menuBar.add(optionsMenu);
		login = new JMenuItem("Login");
		login.addActionListener(new LoginListener());
		optionsMenu.add(login);
		
		uploadProgress = new JProgressBar(0, 100);
		uploadProgress.setValue(0);
		uploadProgress.setStringPainted(true);
		mainPanel.add(uploadProgress, CreateConstraints(GridBagConstraints.PAGE_END, GridBagConstraints.HORIZONTAL, 0, 2, 0, 1, 1, 1, 3, 1, 2, 2, 2, 2));
		
		caption = new JTextField();
		caption.setText("Caption");
		mainPanel.add(caption, CreateConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5));
		tags = new JTextField();
		tags.setText("Tags - Separate Tags with Commas");
		mainPanel.add(tags, CreateConstraints(GridBagConstraints.FIRST_LINE_END, GridBagConstraints.HORIZONTAL, 2, 0, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5));
		
		startUpload = new JButton();
		startUpload.setIcon(new ImageIcon(CreateImageIcon("/com/chazwarp/jasau/resources/upload32.png").getImage(), "String"));
		startUpload.setToolTipText("Start a New Upload");
		startUpload.addActionListener(new StartNewUploadListener());
		mainPanel.add(startUpload, CreateConstraints(GridBagConstraints.CENTER, 0, 1, 1, 1, 1, 1, 1, 3, 1, 5, 5, 5, 5));
		
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainWindow.setBounds(0, 0, screenSize.width/2, screenSize.height/2);
		mainWindow.setLocationRelativeTo(null);//Centers The Window
		
		return mainWindow;
	}
	
	protected static ImageIcon CreateImageIcon(String path) {
		java.net.URL imgURL = MainWindow.class.getResource(path);
		if(imgURL != null) {
			return new ImageIcon(imgURL);
		}
		else {
			System.err.println("Couldn't Find File: " + path);
			return null;
		}
	}
	
	private static GridBagConstraints CreateConstraints(int anchor, int fill, int gridX, int gridY, int ipadX, int ipadY, int weightX, int weightY, int gridWidth, int gridHeight, int insets1, int insets2, int insets3, int insets4) {
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = anchor;
		c.fill = fill;
		c.gridx = gridX;
		c.gridy = gridY;
		c.ipadx = ipadX;
		c.ipady = ipadY;
		c.weightx = weightX;
		c.weighty = weightY;
		c.gridheight = gridHeight;
		c.gridwidth = gridWidth;
		c.insets = new Insets(insets1, insets2, insets3, insets4);
		
		return c;
	}
}
