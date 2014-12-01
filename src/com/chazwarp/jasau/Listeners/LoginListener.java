/**
@author Chaz Kerby
*/
package com.chazwarp.jasau.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.chazwarp.jasau.Main;

public class LoginListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Main.ButtonClicked("Login");
	}

}
