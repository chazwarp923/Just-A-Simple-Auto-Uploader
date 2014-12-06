/**
@author Chaz Kerby
*/
package com.chazwarp.jasau.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.chazwarp.jasau.Helper.IconHelper;
import com.chazwarp.jasau.Helper.Strings;

public class PreferencesWindow {

	static JFrame prefWindow = new JFrame("Preferences");
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static JPanel mainPanel = new JPanel();
	static JTabbedPane tabs = new JTabbedPane();
	static JPanel sourcing = new JPanel();
	static JCheckBox useAutoSourcing = new JCheckBox();
	static JCheckBox useNSFW = new JCheckBox();
	
	public static JFrame CreateWindow() {
		
		IconHelper.setWindowIcon(prefWindow, Strings.RESOURCE_LOCATION + "Icon.png");
		
		prefWindow.add(mainPanel);
		mainPanel.add(tabs);
		
		tabs.addTab("Image Sourcing", sourcing);
		useAutoSourcing.setText("Use Auto Sourcing");
		sourcing.add(useAutoSourcing);
		useNSFW.setText("Use NSFW Sources");
		sourcing.add(useNSFW);
		
		
		prefWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension minSize = new Dimension(screenSize.width/3, screenSize.height/3);
		prefWindow.setMinimumSize(minSize);
		prefWindow.setLocationRelativeTo(null);//Centers The Window
		
		return prefWindow;
	}
}
