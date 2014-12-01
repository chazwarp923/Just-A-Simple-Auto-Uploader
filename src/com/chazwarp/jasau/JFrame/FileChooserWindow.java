/**
@author Chaz Kerby
*/
package com.chazwarp.jasau.JFrame;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserWindow {

	public static File[] OpenNewImage() {
		
		JFileChooser chooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "gif", "png", "bmp", "wbmp");
		String[] extArray = {"JPG", "JPEG", "GIF", "PNG", "BMP", "WBMP"};
		for(int i=0; i < extArray.length; i++) {
			FileNameExtensionFilter forFilter = new FileNameExtensionFilter(extArray[i], extArray[i].toLowerCase());
			chooser.addChoosableFileFilter(forFilter);
		}
		
		chooser.setMultiSelectionEnabled(true);
		chooser.setFileFilter(filter);
		chooser.setDragEnabled(true);
		chooser.showOpenDialog(null);
		
		if(chooser.getSelectedFile() != null) {
			return chooser.getSelectedFiles();
		}
		else {
			return null;
		}
	}
}
