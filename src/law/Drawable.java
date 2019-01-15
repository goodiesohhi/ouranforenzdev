package law; // selects package


import java.net.URL; // imports URLs
import java.awt.image.BufferedImage; // imports image usage
import java.io.File; // imports files
import java.io.IOException; // imports IOException
import java.net.URI; // imports URIs

import javax.imageio.ImageIO; // imports image input and output

public class Drawable { // opens main class
	int x = 0; // holds x value
	int y=0; // holds y value
	int frames=0; // holds number of frames of drawable
	int dx; // holds change in x
	int dy; // holds change in y
	int speed=10; // holds speed of drawable
	int frame; // holds current frame of drawable
	int time; // holds time of drawable
	int image=9999; // holds image id of drawable
	int duration; // holds duration of animation
	int slot; // holds slot of drawable
	BufferedImage imagez; // holds image
	

	
	Drawable(int indexNo, int theX, int theY, int Loadframes,int t, int sl) { // constructs drawable by filling variables
		image = indexNo; 
		frames=Loadframes; 
		x=theX;
		y=theY;
		dx=x;
		dy=y;
		frame=0;
		time=0;
		duration=t;
		slot =sl;
	}
	
	Drawable(BufferedImage image, int theX, int theY, int Loadframes,int t, int sl) { // constructs drawables using an image by filling variables
		imagez = image;
		frames=Loadframes;
		x=theX;
		y=theY;
		dx=x;
		dy=y;
		frame=0;
		time=0;
		duration=t;
		slot =sl;
	}
	void update() { // updates drawable
		
		
		if(dx>x)x=x+speed; // moves x right by speed
		if(dx<x)x=x-speed; // moves x left by speed
		if(dy>y)y=y+speed; // moves y down by speed
		if(dy<y)y=y-speed; // moves y up by speed
		
		//time++;
		
		if (time>=duration&&duration!=0) //Main.renderer.queue[slot] = null; if the time is longer than the duration and the duration is not equal to 0
		if (time>=duration&&duration!=0 && image == 19)	Main.currentCase.objected=true; // if the time is longer than the duration and the duration isn't 0 and the image is 19, objection is set to true
			else Main.currentCase.objected=false; // otherwise objected is set to false
	
	}
	
	BufferedImage draw() throws IOException { // draws image
		if (image!=9999) { // if the image is not the default
		if (frames==1) { // if there is one frame
		
		
		return   Main.renderer.index[image]; // return the image
		} else if (frames>=2) { // if there is more than one image
			URL url = Main.class.getResource("/"+frames+".png"); // sets the url
			 BufferedImage img = ImageIO.read(url); // reads the image
				return img; // returns the image
		} else { // if the frames are 0 or negative
			return null; // returns nothing
		}
			
	} else { // if the image is the default
		return imagez; // returns the default
	}
	}
	
}

