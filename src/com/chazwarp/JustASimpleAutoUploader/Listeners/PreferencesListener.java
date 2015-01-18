/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.chazwarp.JustASimpleAutoUploader.Main;

public class PreferencesListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Main.ButtonClicked("Pref");
	}
}
