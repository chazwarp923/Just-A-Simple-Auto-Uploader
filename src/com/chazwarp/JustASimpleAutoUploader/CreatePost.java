/**
@author Chaz Kerby
*/
package com.chazwarp.JustASimpleAutoUploader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.chazwarp.JustASimpleAutoUploader.JFrame.MainWindow;
import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.PhotoPost;

public class CreatePost {
	
	public static void PostToTumblr(File image, String[] tags) {
			
		PhotoPost post = null;
				
		JumblrClient jc = Main.currentClient;
		try {
			post = jc.newPost("chazthefurry.tumblr.com", PhotoPost.class);
			System.out.println("Instantiated The Post");
		} catch (IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		post.setData(image);
		post.setCaption(MainWindow.caption.getText());
		post.setTags(Arrays.asList(tags));
		post.setState("queue");
		try {
			post.save();
			System.out.println("Pushed The Post To Tumblr");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Created Post For " + image.toString());
	}
}
