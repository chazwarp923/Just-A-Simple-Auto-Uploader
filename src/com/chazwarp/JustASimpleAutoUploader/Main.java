/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader;

import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TumblrApi;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import com.chazwarp.JustASimpleAutoUploader.Helper.JasauFileHelper;
import com.chazwarp.JustASimpleAutoUploader.JFrame.MainWindow;
import com.chazwarp.JustASimpleAutoUploader.JFrame.PreferencesWindow;
import com.tumblr.jumblr.JumblrClient;

public class Main {

	static JFrame mainWindow = null;
	static JFrame prefWindow = null;
	final protected static String ConsumerKey = "UgjrWgFKKJ1JLA0Yvar8xd5AEMwihDRAgQ9FsEUCGsCpV2m4ui";
	final protected static String ConsumerSecret = "jqmjIK9KG3TjgpjXAZvnxrO43gGEy9zHH1L0Ei3jkL40EJCETK";
	public static String Token = "";
	public static String TokenSecret = "";
	public static JumblrClient currentClient = null;
	static FileOutputStream fos = null;
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		currentClient = new JumblrClient(ConsumerKey, ConsumerSecret);
		
		if(JasauFileHelper.tokenExists()) {
			try {
				JasauFileHelper.readTokenFromFile();
				setClientToken();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		createNewWindow();
	}
	
	private static void createNewWindow() {
		mainWindow = MainWindow.CreateWindow();
		mainWindow.setVisible(true);
	}
	
	private static void setClientToken() {
		if(Token != null && TokenSecret != null) {
			currentClient.setToken(Token, TokenSecret);
		}
	}
	
	private static void login() {
		try {
			fos = new FileOutputStream(JasauFileHelper.getSaveDirectory(JasauFileHelper.savePrefix, "OutputTemp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		OAuthService service = new ServiceBuilder().provider(TumblrApi.class).apiKey(ConsumerKey).apiSecret(ConsumerSecret).callback("http://127.0.0.1").debugStream(fos).build();
		Token requestToken = service.getRequestToken();
		String authUrl = service.getAuthorizationUrl(requestToken);
		
		try {
			Desktop.getDesktop().browse(new URI(authUrl));
		} catch (IOException | URISyntaxException e1) {
			e1.printStackTrace();
		}
		
		try {
			JasauFileHelper.readFromTempFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		try {
			JasauFileHelper.writeTokenToFile();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		setClientToken();
	}
	
	private static void openPrefWindow() {
		prefWindow = PreferencesWindow.CreateWindow();
		prefWindow.setVisible(true);
	}
	
	public static void buttonClicked(String id) {
		if (id == "Login") login();
		else if (id == "Pref") openPrefWindow();
	}
}
