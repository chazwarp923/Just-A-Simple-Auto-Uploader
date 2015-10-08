/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.chazwarp.JustASimpleAutoUploader.Main;

public class LoginListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Main.buttonClicked("Login");
	}

}
