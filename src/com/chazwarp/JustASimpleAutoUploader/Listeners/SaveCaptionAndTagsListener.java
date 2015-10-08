/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.chazwarp.JustASimpleAutoUploader.Helper.JasauFileHelper;

public class SaveCaptionAndTagsListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			JasauFileHelper.writeCaptionAndTagsToFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
