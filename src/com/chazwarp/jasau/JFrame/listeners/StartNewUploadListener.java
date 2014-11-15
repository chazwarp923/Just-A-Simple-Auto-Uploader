/**
@author Chaz Kerby
*/
package com.chazwarp.jasau.JFrame.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.chazwarp.jasau.Upload;

public class StartNewUploadListener implements ActionListener{

	Upload task;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		task = new Upload();
		task.addPropertyChangeListener(new ProgressChangeListener());
		task.execute();
	}

}
