/**
@author Chaz Kerby
*/
package com.chazwarp.jasau.JFrame.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.chazwarp.jasau.settings.ConfigFile;

public class SavePreferencesListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			ConfigFile.writeConfigToFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
