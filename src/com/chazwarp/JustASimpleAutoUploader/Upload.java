/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader;

import java.io.File;

import javax.swing.SwingWorker;

import com.chazwarp.JustASimpleAutoUploader.JFrame.FileChooserWindow;
import com.chazwarp.JustASimpleAutoUploader.JFrame.MainWindow;

public class Upload extends SwingWorker<Void, Void> {
	
	private File[] images;
	private String[] tags;
	private float temp;	

	@Override
	protected Void doInBackground() {
		images = FileChooserWindow.OpenNewImage();
		
		tags = splitString(MainWindow.tags.getText());
		
		if(images != null) {
			setProgress(0);
			
			for(int i=0; images.length > i; i++) {	
				CreatePost.PostToTumblr(images[i], tags);
				temp = (i + 1) / (float)images.length;
				temp = temp * 100;
				setProgress((int)temp);
				System.out.println("Upload Progress: " + (int)temp);
			}
		}
		else { 
			System.out.println("Image Array From File Chooser Was Empty");
			System.out.println("Either You Closed The Window Without Selecting Anything Or Something Has Gone Horribly Wrong");
		}
			
		return null;
	}
	
	private static String[] splitString(String tags) {
		String[] ta = {};

		if(tags.contains(",")) {	
			ta = tags.split(",");
		}
		else {
			ta[0] = tags;
		}
		
		return ta;
	}
}
