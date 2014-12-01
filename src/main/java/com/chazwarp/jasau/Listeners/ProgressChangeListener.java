/**
@author Chaz Kerby
*/
package main.java.com.chazwarp.jasau.Listeners;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import main.java.com.chazwarp.jasau.JFrame.MainWindow;

public class ProgressChangeListener implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            MainWindow.uploadProgress.setValue(progress);
		}
	}
}
