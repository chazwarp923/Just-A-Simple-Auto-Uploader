/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader.Listeners;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.chazwarp.JustASimpleAutoUploader.JFrame.MainWindow;

public class ProgressChangeListener implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            MainWindow.uploadProgress.setValue(progress);
		}
	}
}
