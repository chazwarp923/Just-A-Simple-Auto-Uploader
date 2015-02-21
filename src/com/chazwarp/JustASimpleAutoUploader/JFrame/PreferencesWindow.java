/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.chazwarp.JWarpCore.File.IconHelper;
import com.chazwarp.JustASimpleAutoUploader.Listeners.UseAutoSourcingChangeListener;
import com.chazwarp.JustASimpleAutoUploader.Listeners.UseBitlyChangeListener;

public class PreferencesWindow {

	static JFrame prefWindow = new JFrame("Preferences");
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static JPanel mainPanel = new JPanel();
	static JTabbedPane tabs = new JTabbedPane();
	static JPanel urlShortening = new JPanel();
	static JCheckBox useBitly = new JCheckBox("Use Bit.ly");
	public static JButton authorizeForBitly = new JButton("Authorize with Bit.ly");
	static JPanel sourcing = new JPanel();
	static JCheckBox useAutoSourcing = new JCheckBox("Use Auto Sourcing");
	public static JCheckBox useNSFW = new JCheckBox("Use NSFW Sources");
	static JPanel sources = new JPanel();
	
	public static JFrame CreateWindow() {
		
		IconHelper.setWindowIcon(prefWindow, "/resources/" + "Icon.png");
		
		prefWindow.add(mainPanel);
		mainPanel.add(tabs);
		
		tabs.addTab("URL Shortening", urlShortening);
		urlShortening.add(useBitly);
		useBitly.addItemListener(new UseBitlyChangeListener());
		urlShortening.add(authorizeForBitly);
		authorizeForBitly.setEnabled(false);
		tabs.addTab("Image Sourcing", sourcing);
		useAutoSourcing.addItemListener(new UseAutoSourcingChangeListener());
		sourcing.add(useAutoSourcing);		
		sourcing.add(useNSFW);
		useNSFW.setEnabled(false);
		tabs.addTab("Sources", sources);
		
		prefWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension minSize = new Dimension(screenSize.width/3, screenSize.height/3);
		prefWindow.setMinimumSize(minSize);
		prefWindow.setLocationRelativeTo(null);//Centers The Window
		
		return prefWindow;
	}
	
	public static void loadSettings() {
		
	}
	
	public static void saveSettings() {
		
	}
}
