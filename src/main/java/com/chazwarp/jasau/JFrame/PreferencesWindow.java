/**
@author Chaz Kerby
*/
package main.java.com.chazwarp.jasau.JFrame;

import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import main.java.com.chazwarp.jasau.Helper.IconHelper;
import main.java.com.chazwarp.jasau.Helper.Strings;

public class PreferencesWindow {

	static JFrame prefWindow = new JFrame("Preferences");
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static JTabbedPane tabs = new JTabbedPane();
	static JPanel sourcing = new JPanel();
	static JCheckBox useNSFW = new JCheckBox();
	
	public static JFrame CreateWindow() {
		
		IconHelper.setWindowIcon(prefWindow, Strings.RESOURCE_LOCATION + "Icon.png");
		
		sourcing.add(useNSFW);
		tabs.addTab("Image Sourcing", sourcing);
		
		return prefWindow;
	}
}
