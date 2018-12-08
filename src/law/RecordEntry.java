package law;

import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

class RecordEntry {
	int index;
	int manifest;
	BufferedImage image;
	boolean isProfile;
	String desc;
	String name;
	
	public RecordEntry(String name,String path, boolean isProf,String d,int m) throws IOException {
		
         this.name=name;
		desc=d;
        image= ImageIO.read( Main.class.getResource("/resources/record/"+path+".png"));
		
		isProfile=isProf;
		manifest=m;
	}
	
}	