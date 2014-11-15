/**
@author Chaz Kerby
*/
package com.chazwarp.jasau;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.chazwarp.jasau.JFrame.MainWindow;
import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Photo;
import com.tumblr.jumblr.types.PhotoPost;

public class CreatePost {
	
	public static void PostToTumblr(File image, String[] tags) throws IOException, IllegalAccessException, InstantiationException {
			
		PhotoPost pp = null;
				
		JumblrClient jc = Main.getClient();
		pp = jc.newPost("chazthefurry.tumblr.com", PhotoPost.class);
		pp.setPhoto(new Photo(image));
		pp.setCaption(MainWindow.caption.getText());
		pp.setTags(Arrays.asList(tags));
		pp.setState("queue");
		pp.save();
	}
}
