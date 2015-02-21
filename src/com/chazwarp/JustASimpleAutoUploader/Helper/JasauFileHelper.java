/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader.Helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.chazwarp.JustASimpleAutoUploader.Main;
import com.chazwarp.JustASimpleAutoUploader.JFrame.MainWindow;

public class JasauFileHelper extends com.chazwarp.JWarpCore.File.FileHelper {
	
	public static final String savePrefix = "/Jasau/";
	
	public static void WriteCaptionAndTagsToFile() throws IOException {
		
		File dir = new File(GetBaseSaveDirectory(savePrefix));
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File saveFile = new File(GetBaseSaveDirectory(savePrefix) + "CaptionAndTags.cfg");
		
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
		
		File saveFile = new File(GetBaseSaveDirectory(savePrefix) + "CaptionAndTags.cfg");
		
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
		
		File configFile = new File(GetBaseSaveDirectory(savePrefix) + "CaptionAndTags.cfg");
		
		if(configFile.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void ReadFromTempFile() throws IOException {
		
		File file = new File(GetBaseSaveDirectory(savePrefix) + "OutputTemp");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		for(int i=0; i < 11; i++) {
			if(i != 9) br.readLine();
			else if(i == 9) {
				String tempString = br.readLine();
				if(tempString != null) {
					Main.Token = tempString.substring(27, 77);
					Main.TokenSecret = tempString.substring(97, 147);
				}
			}
		}
		br.close();
	}
	
	public static void WriteTokenToFile() throws IOException {
		
		File dir = new File(GetBaseSaveDirectory(savePrefix));
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File saveFile = new File(GetBaseSaveDirectory(savePrefix) + "Token.ks");
		
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
		
		File saveFile = new File(GetBaseSaveDirectory(savePrefix) + "Token.ks");
		
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
		
		File configFile = new File(GetBaseSaveDirectory(savePrefix) + "Token.ks");
		
		if(configFile.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
}
