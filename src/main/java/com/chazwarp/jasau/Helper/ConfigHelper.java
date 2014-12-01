/**
@author Chaz Kerby
*/
package main.java.com.chazwarp.jasau.Helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import main.java.com.chazwarp.jasau.Main;
import main.java.com.chazwarp.jasau.JFrame.MainWindow;

public class ConfigHelper {
	
	private static final String savePrefix = "/Jasau/";
	
	public static void WriteCaptionAndTagsToFile() throws IOException {
		
		File dir = new File(GetBaseSaveDirectory());
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File saveFile = new File(GetBaseSaveDirectory() + "CaptionAndTags.cfg");
		
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
	
	public static void ReadCaptionAndTagsFromFile() throws IOException {
		
		File saveFile = new File(GetBaseSaveDirectory() + "CaptionAndTags.cfg");
		
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
	
	public static boolean CaptionAndTagsExists() {
		
		File configFile = new File(GetBaseSaveDirectory() + "CaptionAndTags.cfg");
		
		if(configFile.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void WriteTokenToFile() throws IOException {
		
		File dir = new File(GetBaseSaveDirectory());
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File saveFile = new File(GetBaseSaveDirectory() + "Tokens.ks");
		
		if(saveFile.exists()) {
			saveFile.delete();
		}
		
		saveFile.createNewFile();
		PrintWriter pw = new PrintWriter(saveFile);
		
		pw.append(Main.Token);
		pw.println();
		pw.append(Main.TokenSecret);
		pw.close();
	}
	
	public static void ReadTokenFromFile() throws IOException {
		
		File saveFile = new File(GetBaseSaveDirectory() + "Token.ks");
		
		BufferedReader br = new BufferedReader(new FileReader(saveFile));
		
		for(int i=0; i < 2; i++) {
			if(i == 0) {
				Main.Token = br.readLine();
			}
			else if( i == 1) {
				Main.TokenSecret = br.readLine();
			}
		}
		br.close();
	}
	
	public static boolean TokenExists() {
		
		File configFile = new File(GetBaseSaveDirectory() + "Token.ks");
		
		if(configFile.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static String GetBaseSaveDirectory() {
		String baseSaveDirectory = null;
		String OS = (System.getProperty("os.name")).toUpperCase();
		
		if(OS.contains("WIN")) {
			baseSaveDirectory = System.getenv("AppData");
		}
		else {
			baseSaveDirectory = System.getProperty("user.home");
			baseSaveDirectory += "/Library/Application Support";
		}
		
		return baseSaveDirectory + savePrefix;
	}
}
