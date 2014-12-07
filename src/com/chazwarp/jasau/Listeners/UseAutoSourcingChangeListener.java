/**
@author Chaz Kerby
*/
package com.chazwarp.jasau.Listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.chazwarp.jasau.JFrame.PreferencesWindow;

public class UseAutoSourcingChangeListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.DESELECTED) {
			PreferencesWindow.useNSFW.setEnabled(false);
		}
		else if(ie.getStateChange() == ItemEvent.SELECTED) {
			PreferencesWindow.useNSFW.setEnabled(true);
		}
	}
}
