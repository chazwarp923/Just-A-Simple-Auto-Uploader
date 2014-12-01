/**
@author Chaz Kerby
*/
package com.chazwarp.jasau;

import java.io.File;
import java.io.IOException;

import javax.swing.SwingWorker;

import com.chazwarp.jasau.JFrame.FileChooserWindow;
import com.chazwarp.jasau.JFrame.MainWindow;

public class Upload extends SwingWorker<Void, Void> {
	
	static File[] images;
	static float temp;
	static String[] tags;

	@Override
	protected Void doInBackground() throws IllegalAccessException, InstantiationException, IOException {
		images = FileChooserWindow.OpenNewImage();
		
		tags = splitString(MainWindow.tags.getText());
		
			for(int i=0; images.length > i; i++) {
				
				CreatePost.PostToTumblr(images[i], tags);
				temp = (i + 1) / (float)images.length;
				temp = temp * 100;
				setProgress((int)temp);
				System.out.println("Upload Progress: " + (int)temp);
			}
		return null;
	}
	
	private static String[] splitString(String ttww) {
		//ttww means Tags to Work With
		String[] ta = {};

		if(ttww.contains(",")) {	
			ta = ttww.split(",");
		}
		
		return ta;
	}
}
