/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader.Listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.chazwarp.JustASimpleAutoUploader.JFrame.PreferencesWindow;

public class UseBitlyChangeListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.DESELECTED) {
			PreferencesWindow.authorizeForBitly.setEnabled(false);
		}
		else if(ie.getStateChange() == ItemEvent.SELECTED) {
			PreferencesWindow.authorizeForBitly.setEnabled(true);
		}
	}

}
