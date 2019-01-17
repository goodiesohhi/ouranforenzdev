package law; // selects package

import java.awt.image.BufferedImage; // imports image
import java.io.IOException; // imports IOException


import javax.imageio.ImageIO; // imports input of images

class RecordEntry { // opens class
	int index; // holds index of record entry
	int manifest; // holds number of record entry
	BufferedImage image; // holds image
	boolean isProfile; // holds whether entry is profile
	String desc; // holds description of entry
	String name;// holds name of entry
	String path;
	
	public RecordEntry(String name,String path, boolean isProf,String d,int m) throws IOException { // constructs record entry
		// sets values
         this.name=name;
		desc=d;
        image= ImageIO.read( Main.class.getResource("/resources/record/"+path+".png"));
		this.path=path;
		isProfile=isProf;
		manifest=m;
	}
	
}	