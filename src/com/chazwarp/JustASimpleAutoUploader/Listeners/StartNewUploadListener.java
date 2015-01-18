/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.chazwarp.JustASimpleAutoUploader.Upload;

public class StartNewUploadListener implements ActionListener{

	Upload task;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		task = new Upload();
		task.addPropertyChangeListener(new ProgressChangeListener());
		task.execute();
		System.out.println("Started Upload");
	}

}
