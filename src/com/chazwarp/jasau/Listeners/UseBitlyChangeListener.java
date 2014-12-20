/**
@author Chaz Kerby
*/
package com.chazwarp.jasau.Listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.chazwarp.jasau.JFrame.PreferencesWindow;

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
