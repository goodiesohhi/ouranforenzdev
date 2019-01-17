package law; // selects package

import java.awt.image.BufferedImage; // imports buffered image
import java.io.IOException; // imports IOException
import java.util.ArrayList; // imports ArrayList

import javax.imageio.ImageIO; //imports image input

public class Character { // opens class

	String name; // holds character name
	int id; // holds character identifier
	Animation animation; // holds character animation
	int x; //holds character x position
	int y; // holds character y position
	int width; // holds character width
	int dx; // holds change in x
	int dy; // holds change in y
	int originX; // holds original x position
	int originY; // holds original y position
	ArrayList<AnimData> animList;
	int height; // holds character height
	Drawable drawn; // holds if the character has been drawn
	boolean show; // holds whether the character should be shown
	private int speed; // holds the character's speed
	Character(String n, int x, int y) throws IOException { // opens constructor
		// sets all values
		 this.x=x;
		 this.y=y; 
		 this.dx=this.x;
		 this.dy=this.y;
	     originY=this.y;
	     originX=this.x;
		 name=n;
		animList = new ArrayList<AnimData>();
	}
	
	void setVisible(boolean b) { // sets whether the character is visible
		show=b;
		
	}
	
	void moveTo (int x, int y) { // moves the character to a new position
		this.dx=x;
		this.dy=y;
		
	}
	
	void moveBy (int x, int y, int i) { // moves the character by a certain distance
		this.dx+=x;
		this.dy+=y;
		this.speed=i;
		
	}
	
	void resetPos() { // resets character's position
		this.x=this.originX;
		this.y=this.originY;
	}
	
	void resetMove() { // stops the character from moving
		this.dx=this.originX;
		this.dy=this.originY;
	}
	
	void play(String path, int f, boolean loop) throws IOException { // plays character animation
		
		animation=new Animation(path,f, this);
		this.animation.play(loop); 
		
	}
	
	void clear () { // removes the character from the screen
		animation=null;
		drawn=null;
	}
	
	void update () { // updates the character
		if (this.animation!=null)this.animation.update();
		if(this.dx>x) x+=speed;
	    if(this.dx<x)x-=speed;
	    if (this.dy>y)y+=speed;
	    if(this.dy<y)y-=speed;
	    
	
	}
	
}

class Animation { // opens animation class
	int time; // holds the time of the animation
	int frames; // holds the number of frames
	int currentFrame=0; // holds the current frame
	Character parent; // holds the character to which the animation belongs
	boolean playing; // holds whether the animation is playing
	boolean loop; // holds whether the animation should loop
	boolean resetOnce; // holds if the animation should reset
	ArrayList<BufferedImage> sprites; // holds the sprites for the animation
	String path; // holds the location of the animation
	Animation(String p, int f, Character chara) throws IOException { // opens constructor, which sets values
		parent=chara;
		sprites = new ArrayList<BufferedImage>();
		frames=f;
		System.out.println(f);
		if (f>1) {
		for (int i=0;i<f;i++) {
			//System.out.println("/resources/anim/"+p+"_"+i+".png");
			System.out.println("/resources/anim/"+p+"_"+i+".png");
			System.out.println(sprites);
		 sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/"+p+"_"+i+".png")));
		System.out.println(sprites.size());
		}
		} else {
			//System.out.println("/resources/anim/"+p+".png");
			System.out.println("/resources/anim/"+p+".png");
			sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/"+p+".png")));
		}
	
	}
		
		 //sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/nekocchiWitness_0.png"))); 
		// sprites.add(ImageIO.read( Main.class.getResource("/resources/anim/nekocchiWitness_1.png")));
	
			
	
	BufferedImage draw() { // draws animation
		return  sprites.get(currentFrame);
	}
	
void update() { // updates animation
	if (playing) { // checks if animation is playing
		
		if (!resetOnce) { // checks if the animation shouldn't reset
			if (frames==0||frames==1) { // checks if there are only 0 or 1 frames
			resetOnce=true; // sets the animation to reset
			if (this.parent!=Main.currentCase.motionTrack)Main.currentCase.working=false; // checks if the parent is not the motion track, and if not sets the case to not be working
			
			}
		}
		
		//System.out.println("PLAYING"+time);
		if (time>=0)time++; // increases time
		if (time>=0) currentFrame= (int)time/10; // plays frame
		
		if (currentFrame>sprites.size()-1) { // checks if the frame is the last one
			
			System.out.println(currentFrame+"/"+(sprites.size()-1));
			if (loop) { // checks if the animation should loop and resets it
				currentFrame=0;
				time=0;
			} else {
				// otherwise, sets time and current frame to previous settings
				time= -1;
				currentFrame=currentFrame-1;
				if (!resetOnce) { // checks if the animation does not reset
					resetOnce=true; // sets the animation to reset
					System.out.println("NO1");
					Main.currentCase.working=false; // sets the case to not working
				}
				
			}
		}
		
		parent.drawn= new Drawable(sprites.get(currentFrame), parent.x, parent.y, 1,0, 0); // sets the character's animation as drawn
	}
	
}

void play(boolean l) { // plays animation
	if (l) { // plays with loop
		playing=true;
		loop=true;
	} else { // plays without loop
		
		playing=true;
		loop=false;
		
	}
}
	
	
	
}
