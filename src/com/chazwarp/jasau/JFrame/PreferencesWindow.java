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
import com.chazwarp.jasau.Listeners.UseAutoSourcingChangeListener;

public class PreferencesWindow {

	static JFrame prefWindow = new JFrame("Preferences");
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static JPanel mainPanel = new JPanel();
	static JTabbedPane tabs = new JTabbedPane();
	static JPanel sourcing = new JPanel();
	static JCheckBox useAutoSourcing = new JCheckBox("Use Auto Sourcing");
	public static JCheckBox useNSFW = new JCheckBox("Use NSFW Sources");
	static JPanel sources = new JPanel();
	
	public static JFrame CreateWindow() {
		
		IconHelper.setWindowIcon(prefWindow, Strings.RESOURCE_LOCATION + "Icon.png");
		
		prefWindow.add(mainPanel);
		mainPanel.add(tabs);
		
		tabs.addTab("Image Sourcing", sourcing);
		useAutoSourcing.addItemListener(new UseAutoSourcingChangeListener());
		sourcing.add(useAutoSourcing);
		useNSFW.setEnabled(false);
		sourcing.add(useNSFW);
		tabs.addTab("Sources", sources);
		
		
		prefWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension minSize = new Dimension(screenSize.width/3, screenSize.height/3);
		prefWindow.setMinimumSize(minSize);
		prefWindow.setLocationRelativeTo(null);//Centers The Window
		
		return prefWindow;
	}
}
