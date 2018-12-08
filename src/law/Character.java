package law;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Character {

	String name;
	int id;
	Animation animation;
	int x;
	int y;
	int width;
	int height;
	Drawable drawn;
	boolean show;
	Character(String n,int x, int y, int w, int h) throws IOException {
		
		 this.x=x;
		 this.y=y;
		 height=h;
		 width=w;
		 name=n;
		
	}
	
	void setVisible(boolean b) {
		show=b;
		
	}
	
	void play(String path, int f, boolean loop) throws IOException {
		
		animation=new Animation(path,f, this);
		this.animation.play(loop);
		
	}
	
}

class Animation {
	int time;
	int frames;
	int currentFrame=0;
	Character parent;
	boolean playing;
	boolean loop;
	ArrayList<BufferedImage> sprites;
	String path;
	Animation(String p, int f, Character chara) throws IOException {
		parent=chara;
		sprites = new ArrayList<BufferedImage>();
		for (int i=0;i<f;i++)
		 sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/"+path+"_"+f+".png")));
	
	}
	
	BufferedImage draw() {
		return  sprites.get(currentFrame);
	}
	
void update() {
	if (playing) {
		if (time>=0)time++;
		if (time>=0) frames= (int)time/1000;
		
		if (frames>sprites.size()-1) {
			if (loop) {
				frames=0;
				time=0;
			} else {
				time= -1;
				
			}
		}
		
		parent.drawn= new Drawable(sprites.get(currentFrame), parent.x, parent.y, 1,0, 0);
	}
	
}

void play(boolean l) {
	if (l) {
		playing=true;
		loop=true;
	} else {
		
		playing=true;
		loop=false;
		
	}
}
	
	
	
}
