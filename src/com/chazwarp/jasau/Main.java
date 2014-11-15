/**
@author Chaz Kerby
*/
package com.chazwarp.jasau;

import java.awt.Desktop;
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

import com.chazwarp.jasau.JFrame.MainWindow;
import com.tumblr.jumblr.JumblrClient;

public class Main {

	static JFrame mainWindow = null;
	final static String OAuthKey = "UgjrWgFKKJ1JLA0Yvar8xd5AEMwihDRAgQ9FsEUCGsCpV2m4ui";
	final static String OAuthSecret = "jqmjIK9KG3TjgpjXAZvnxrO43gGEy9zHH1L0Ei3jkL40EJCETK";
	static JumblrClient currentClient = null;
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		CreateNewWindow();
	}
	
	public static void CreateNewWindow() {
		mainWindow = MainWindow.CreateWindow();
		mainWindow.setVisible(true);
	}
	
	public static void login() {
		
		//Consumer Key, Consumer Secret
		JumblrClient client = new JumblrClient(OAuthKey, OAuthSecret);
		OAuthService service = new ServiceBuilder().provider(TumblrApi.class).apiKey(OAuthKey).apiSecret(OAuthSecret).callback("http://www.tumblr.com/connect/login_success.html").build();
		Token requestToken = service.getRequestToken();
		String authUrl = service.getAuthorizationUrl(requestToken);
		
		if(Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(authUrl));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		}
		
		client.setToken("hbJvml5K3Wsdb6t0yUmSpkV7V8WP15ayenxxRSaDQt74Rx8lIu", "5uhOMXcmecNlhvPqJ5HG3NHli4LzsiYHrWI74OSWw3gGQJdQAe");
		
		currentClient = client;
	}
	
	public static JumblrClient getClient() {
		return currentClient;
	}
	
	public static void ButtonClicked(String id) {
		if(id == "Login") login();
	}
}
