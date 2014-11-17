/**
@author Chaz Kerby
*/
package com.chazwarp.jasau.settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.chazwarp.jasau.JFrame.MainWindow;

public class ConfigFile {
	
	private static final String saveSuffix = "/Jasau/";
	
	public static void writeConfigToFile() throws IOException {
		
		File dir = new File(getBaseSaveDirectory() + saveSuffix);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File saveFile = new File(getBaseSaveDirectory() + saveSuffix + "UserPrefrences.cfg");
		
		if(saveFile.exists()) {
			saveFile.delete();
		}
		
		saveFile.createNewFile();
		PrintWriter pw = new PrintWriter(saveFile);
		
		pw.append(MainWindow.caption.getText());
		pw.println();
		pw.append(MainWindow.tags.getText());
		pw.close();
		
	}
	
	public static void readConfigFromFile() throws IOException {
		
		File saveFile = new File(getBaseSaveDirectory() + saveSuffix + "UserPrefrences.cfg");
		
		BufferedReader br = new BufferedReader(new FileReader(saveFile));
		
		for(int i=0; i < 2; i++) {
			if(i == 0) {
				MainWindow.caption.setText(br.readLine());
			}
			else if( i == 1) {
				MainWindow.tags.setText(br.readLine());
			}
		}
		br.close();
	}
	
	public static boolean configExists() {
		File configFile = new File(getBaseSaveDirectory() + saveSuffix + "UserPrefrences.cfg");
		
		if(configFile.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static String getBaseSaveDirectory() {
		String baseSaveDirectory = null;
		String OS = (System.getProperty("os.name")).toUpperCase();
		
		if(OS.contains("WIN")) {
			baseSaveDirectory = System.getenv("AppData");
		}
		else {
			baseSaveDirectory = System.getProperty("user.home");
			baseSaveDirectory += "/Library/Application Support";
		}
		
		return baseSaveDirectory;
	}
}
