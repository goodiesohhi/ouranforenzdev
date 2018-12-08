package law;


import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.imageio.ImageIO;

public class Drawable {
	int x = 0;
	int y=0;
	int frames=0;
	int dx;
	int dy;
	int speed=10;
	int frame;
	int time;
	int image=9999;
	int duration;
	int slot;
	BufferedImage imagez;
	

	
	Drawable(int indexNo, int theX, int theY, int Loadframes,int t, int sl) {
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
	
	Drawable(BufferedImage image, int theX, int theY, int Loadframes,int t, int sl) {
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
	void update() {
		
		
		if(dx>x)x=x+speed;
		if(dx<x)x=x-speed;
		if(dy>y)y=y+speed;
		if(dy<y)y=y-speed;
		
		//time++;
		
		if (time>=duration&&duration!=0) //Main.renderer.queue[slot] = null;
		if (time>=duration&&duration!=0 && image == 19)	Main.currentCase.objected=true;
			else Main.currentCase.objected=false;
	
	}
	
	BufferedImage draw() throws IOException {
		if (image!=9999) {
		if (frames==1) {
		
		
		return   Main.renderer.index[image];
		} else if (frames>=2) {
			URL url = Main.class.getResource("/"+frames+".png");
			 BufferedImage img = ImageIO.read(url);
				return img;
		} else {
			return null;
		}
			
	} else {
		return imagez;
	}
	}
	
}

