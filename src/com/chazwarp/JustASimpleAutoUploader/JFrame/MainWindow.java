/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import com.chazwarp.JWarpCore.File.IconHelper;
import com.chazwarp.JustASimpleAutoUploader.Helper.JasauFileHelper;
import com.chazwarp.JustASimpleAutoUploader.Listeners.LoginListener;
import com.chazwarp.JustASimpleAutoUploader.Listeners.PreferencesListener;
import com.chazwarp.JustASimpleAutoUploader.Listeners.SaveCaptionAndTagsListener;
import com.chazwarp.JustASimpleAutoUploader.Listeners.StartNewUploadListener;

public class MainWindow {

	static JFrame mainWindow = new JFrame("Just a Simple Auto Uploader");
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Dimension screenSize = tk.getScreenSize();
	static JPanel mainPanel = new JPanel(new BorderLayout());
	static JPanel compPanel = new JPanel(new FlowLayout());
	static JMenuBar menuBar = new JMenuBar();
	static JMenu optionsMenu = new JMenu("Options");
	static JMenuItem prefs = new JMenuItem("Preferences");
	static JMenuItem login = new JMenuItem("Login");
	static JMenuItem saveCapAndTag = new JMenuItem("Save Caption & Tags");
	public static JProgressBar uploadProgress = new JProgressBar(0, 100);
	public static JTextField caption = new JTextField();
	public static JTextField tags = new JTextField();
	static JButton startUpload = new JButton();
	
	public static JFrame CreateWindow() {
		
		IconHelper.setWindowIcon(mainWindow, "/resources/" + "Icon.png");
			
		mainWindow.setJMenuBar(menuBar);	
		menuBar.add(optionsMenu);
		prefs.addActionListener(new PreferencesListener());
		optionsMenu.add(prefs);		
		login.addActionListener(new LoginListener());
		optionsMenu.add(login);		
		saveCapAndTag.addActionListener(new SaveCaptionAndTagsListener());
		optionsMenu.add(saveCapAndTag);
		
		caption.setText("Caption");
		compPanel.add(caption);		
		tags.setText("Tags - Separate Tags with Commas");
		compPanel.add(tags);
		startUpload.setIcon(IconHelper.CreateImageIcon("/resources/" + "upload32.png"));
		startUpload.setToolTipText("Start a New Upload");
		startUpload.addActionListener(new StartNewUploadListener());
		compPanel.add(startUpload);
		
		uploadProgress.setValue(0);
		uploadProgress.setStringPainted(true);
		mainPanel.add(uploadProgress, BorderLayout.PAGE_END);
		
		Dimension tempDim = startUpload.getPreferredSize();
		compPanel.setPreferredSize(new Dimension(screenSize.width, tempDim.height + 4));
		
		mainPanel.add(compPanel, BorderLayout.PAGE_START);
		mainWindow.add(mainPanel);	
		
		if(JasauFileHelper.CaptionAndTagsExists()) {
			try {
				JasauFileHelper.ReadCaptionAndTagsFromFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = tk.getScreenSize();
		Dimension minSize = new Dimension(screenSize.width/2, screenSize.height/2);
		mainWindow.setMinimumSize(minSize);
		mainWindow.setLocationRelativeTo(null);//Centers The Window
		
		return mainWindow;
	}
}
