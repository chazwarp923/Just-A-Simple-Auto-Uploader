/**
@author Chaz Kerby
*/
package com.chazwarp.jasau.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.chazwarp.jasau.Helper.ConfigHelper;

public class SaveCaptionAndTagsListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			ConfigHelper.WriteCaptionAndTagsToFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
