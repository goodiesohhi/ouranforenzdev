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
	int dx;
	int dy;
	int originX;
	int originY;
	
	int height;
	Drawable drawn;
	boolean show;
	private int speed;
	Character(String n,int x, int y) throws IOException {
		
		 this.x=x;
		 this.y=y;
		 this.dx=this.x;
		 this.dy=this.y;
	     originY=this.y;
	     originX=this.x;
		 name=n;
		
	}
	
	void setVisible(boolean b) {
		show=b;
		
	}
	
	void moveTo (int x, int y) {
		this.dx=x;
		this.dy=y;
		
	}
	
	void moveBy (int x, int y, int i) {
		this.dx+=x;
		this.dy+=y;
		this.speed=i;
		
	}
	
	void resetPos() {
		this.x=this.originX;
		this.y=this.originY;
	}
	
	void resetMove() {
		this.dx=this.originX;
		this.dy=this.originY;
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
		if(this.dx>x) x+=speed;
	    if(this.dx<x)x-=speed;
	    if (this.dy>y)y+=speed;
	    if(this.dy<y)y-=speed;
	    
	
	}
	
}

class Animation {
	int time;
	int frames;
	int currentFrame=0;
	Character parent;
	boolean playing;
	boolean loop;
	boolean resetOnce;
	ArrayList<BufferedImage> sprites;
	String path;
	Animation(String p, int f, Character chara) throws IOException {
		parent=chara;
		sprites = new ArrayList<BufferedImage>();
		frames=f;
		System.out.println(f);
		if (f>1) {
		for (int i=0;i<f;i++) {
			//System.out.println("/resources/anim/"+p+"_"+i+".png");
		 sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/"+p+"_"+i+".png")));
		}
		} else {
			//System.out.println("/resources/anim/"+p+".png");
			sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/"+p+".png")));
		}
	
	}
		
		 //sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/nekocchiWitness_0.png"))); 
		// sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/nekocchiWitness_1.png")));
	
			
	
	BufferedImage draw() {
		return  sprites.get(currentFrame);
	}
	
void update() {
	if (playing) {
		
		if (!resetOnce) {
			if (frames==0||frames==1) {
			resetOnce=true;
			if (this.parent!=Main.currentCase.motionTrack)Main.currentCase.working=false;
			
			}
		}
		
		//System.out.println("PLAYING"+time);
		if (time>=0)time++;
		if (time>=0) currentFrame= (int)time/10;
		
		if (currentFrame>sprites.size()-1) {
			if (loop) {
				currentFrame=0;
				time=0;
			} else {
				time= -1;
				currentFrame=currentFrame-1;
				if (!resetOnce) {
					resetOnce=true;
					System.out.println("NO1");
					Main.currentCase.working=false;
				}
				
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
