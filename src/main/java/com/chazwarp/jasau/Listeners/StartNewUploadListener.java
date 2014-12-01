/**
@author Chaz Kerby
*/
package main.java.com.chazwarp.jasau.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.com.chazwarp.jasau.Upload;

public class StartNewUploadListener implements ActionListener{

	Upload task;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		task = new Upload();
		task.addPropertyChangeListener(new ProgressChangeListener());
		task.execute();
	}

}
