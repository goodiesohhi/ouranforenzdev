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
	Character(String n,int x, int y) throws IOException {
		
		 this.x=x;
		 this.y=y;
	
		 name=n;
		
	}
	
	void setVisible(boolean b) {
		show=b;
		
	}
	
	void play(String path, int f, boolean loop) throws IOException {
		
		animation=new Animation(path,f, this);
		this.animation.play(loop);
		
	}
	
	void clear () {
		animation=null;
		drawn=null;
	}
	
	void update () {
		if (this.animation!=null)this.animation.update();
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
		/*for (int i=0;i<f;i++)
		 sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/"+path+"_"+f+".png")));
	
	}*/
		
		 sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/nekocchiWitness_0.png"))); 
		 sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/nekocchiWitness_1.png")));
	}
			
	
	BufferedImage draw() {
		return  sprites.get(currentFrame);
	}
	
void update() {
	if (playing) {
		
		System.out.println("PLAYING"+time);
		if (time>=0)time++;
		if (time>=0) currentFrame= (int)time/10;
		
		if (currentFrame>sprites.size()-1) {
			if (loop) {
				currentFrame=0;
				time=0;
			} else {
				time= -1;
				currentFrame=currentFrame-1;
				
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
