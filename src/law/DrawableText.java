package law; // selects package

import java.awt.Color; // imports colour

class DrawableText extends Drawable { // creates class
	int slot; // holds slot of text
	String text; // holds text
	Boolean typewrite = false; // holds whether the typewrite is running
	Color color=Color.BLACK; // sets colour of text to black
	float size; // holds size of text
	String current; // holds current string
	boolean start=false; // holds whether the text has started
	
	int duration; // holds duration of text
	int loop =0; // holds if the text loops
	public DrawableText(String t, Color c, float s, Boolean scroll, int d, int sl, boolean speaker) { // constructs drawable text
		
		
		super(0,60,550,0,0,200); // constructs drawable
		
		
	
		
		slot=sl; // sets variables
		text=t;
		if (s<1) {
		size=18.0f;
		} else {
			size=s;	
		}
		y=(int) (550+size);
		dy=y;
		dx=x;	
		color=c;
		typewrite=scroll;
		frame=1;
		if (speaker) {
			
			y=y-50;
			dy=y;
		}
		
		
	
			current=text;
			
			
		
		
		
	}
	
   public void update() { // updates text
	  
		
		if(duration!=0) { // if the duration is not 0
			if (Main.currentCase.pressed)if (time*loop >= duration) Main.renderer.pressQueue[slot]=null; // if the case is pressed and the time is under the duration the slot disappears
			else if (time*loop >= duration) Main.renderer.textQueue[slot]=null;
		}
		
		
		if(time>=100000) { //if time is larger than 100000
			time =0;  // time sets to 0
			loop++; // increases the loop
		}
		
		//System.out.println("time " + time);

		//System.out.println("tw " + typewrite);
		if (time%1==0&&typewrite) { // if the text is being written
			  if (!start) { // if it hasn't started
			    	start=true; // set it to start
			    	frame=0; // sets the frame to the beginning
			    }
			//System.out.println(this.frame + " / "+(current.length()-1));

			if(this.frame<current.length()) { // if the frame is not last
				//System.out.println(frame+" frames");
				this.frame++; // increase the frame
				//System.out.println(current.substring(0, frame));
			}
		}
		
		
		if(dx>x)x=x+speed; // moves x right by speed
		if(dx<x)x=x-speed; // moves x left by speed
		if(dy>y)y=y+speed; // moves y down by speed
		if(dy<y)y=y-speed; // moves y up by speed
		
		time++; // increases time
		
	
	}
	
	String drawText() { // draws text
		
		if(!typewrite) { // if the text is not typewritten
			return current; // returns text
		} else { // if the text is typewritten
			if (frame>current.length())  frame=current.length()-1; // if the frame is longer than the length, move the frame to one before the end
			
			//System.out.println(frame);
		return  current.substring(0, frame); // return the substring from 0 to the current frame
		}
		
		
	}
	
	
	
}