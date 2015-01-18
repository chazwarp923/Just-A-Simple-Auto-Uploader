/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader.JFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import com.chazwarp.JustASimpleAutoUploader.Helper.FileHelper;
import com.chazwarp.JustASimpleAutoUploader.Helper.IconHelper;
import com.chazwarp.JustASimpleAutoUploader.Helper.Strings;
import com.chazwarp.JustASimpleAutoUploader.Listeners.LoginListener;
import com.chazwarp.JustASimpleAutoUploader.Listeners.PreferencesListener;
import com.chazwarp.JustASimpleAutoUploader.Listeners.SaveCaptionAndTagsListener;
import com.chazwarp.JustASimpleAutoUploader.Listeners.StartNewUploadListener;

public class MainWindow {

	static JFrame mainWindow = new JFrame("Just a Simple Auto Uploader");
	static JPanel mainPanel;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static JMenuBar menuBar;
	static JMenu optionsMenu;
	static JMenuItem prefs;
	static JMenuItem login;
	static JMenuItem saveCapAndTag;
	public static JProgressBar uploadProgress;
	public static JTextField caption;
	public static JTextField tags;
	static JButton startUpload;
	
	public static JFrame CreateWindow() {
		
		IconHelper.setWindowIcon(mainWindow, Strings.RESOURCE_LOCATION + "Icon.png");
		
		menuBar = new JMenuBar();
		mainWindow.setJMenuBar(menuBar);
		mainPanel = new JPanel(new GridBagLayout());
		mainWindow.add(mainPanel);
		optionsMenu = new JMenu("Options");
		menuBar.add(optionsMenu);
		prefs = new JMenuItem("Preferences");
		prefs.addActionListener(new PreferencesListener());
		optionsMenu.add(prefs);
		login = new JMenuItem("Login");
		login.addActionListener(new LoginListener());
		optionsMenu.add(login);
		saveCapAndTag = new JMenuItem("Save Caption & Tags");
		saveCapAndTag.addActionListener(new SaveCaptionAndTagsListener());
		optionsMenu.add(saveCapAndTag);
		
		uploadProgress = new JProgressBar(0, 100);
		uploadProgress.setValue(0);
		uploadProgress.setStringPainted(true);
		mainPanel.add(uploadProgress, CreateConstraints(GridBagConstraints.PAGE_END, GridBagConstraints.HORIZONTAL, 0, 2, 1, 1, 0.5, 0, 3, 1, 2, 2, 2, 2));
		
		caption = new JTextField();
		caption.setText("Caption");
		mainPanel.add(caption, CreateConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 0.5, 0, 1, 1, 5, 5, 5, 5));
		tags = new JTextField();
		tags.setText("Tags - Separate Tags with Commas");
		mainPanel.add(tags, CreateConstraints(GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL, 1, 0, 1, 1, 0.5, 1, 1, 1, 5, 5, 5, 5));
		
		startUpload = new JButton();
		startUpload.setIcon(IconHelper.CreateImageIcon(Strings.RESOURCE_LOCATION + "upload32.png"));
		startUpload.setToolTipText("Start a New Upload");
		startUpload.addActionListener(new StartNewUploadListener());
		mainPanel.add(startUpload, CreateConstraints(GridBagConstraints.FIRST_LINE_END, GridBagConstraints.HORIZONTAL, 2, 0, 1, 1, 0.5, 0, 1, 1, 5, 5, 5, 5));
		
		if(FileHelper.CaptionAndTagsExists()) {
			try {
				FileHelper.ReadCaptionAndTagsFromFile();
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
	
	private static GridBagConstraints CreateConstraints(int anchor, int fill, int gridX, int gridY, int ipadX, int ipadY, double weightX, double weightY, int gridWidth, int gridHeight, int insets1, int insets2, int insets3, int insets4) {
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
