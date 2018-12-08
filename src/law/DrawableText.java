package law;

import java.awt.Color;

class DrawableText extends Drawable {
	int slot;
	String text;
	Boolean typewrite = false;
	Color color=Color.BLACK;
	float size;
	String current;
	boolean start=false;
	
	int duration;
	int loop =0;
	public DrawableText(String t, Color c, float s, Boolean scroll, int d, int sl, boolean speaker) {
		
		
		super(0,60,550,0,0,200);
		
		
	
		
		slot=sl;
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
	
   public void update() {
	  
		
		if(duration!=0) {
			if (Main.currentCase.pressed)if (time*loop >= duration) Main.renderer.pressQueue[slot]=null;
			else if (time*loop >= duration) Main.renderer.textQueue[slot]=null;
		}
		
		
		if(time>=100000) {
			time =0; 
			loop++;
		}
		
		System.out.println("time " + time);

		System.out.println("tw " + typewrite);
		if (time%1==0&&typewrite) {
			  if (!start) {
			    	start=true;
			    	frame=0;
			    }
			System.out.println(this.frame + " / "+(current.length()-1));

			if(this.frame<current.length()) {
				System.out.println(frame+" frames");
				this.frame++;
				System.out.println(current.substring(0, frame));
			}
		}
		
		
		if(dx>x)x=x+speed;
		if(dx<x)x=x-speed;
		if(dy>y)y=y+speed;
		if(dy<y)y=y-speed;
		
		time++;
		
	
	}
	
	String drawText() {
		
		if(!typewrite) {
			return current;
		} else {
			if (frame>current.length())  frame=current.length()-1;
			
			System.out.println(frame);
		return  current.substring(0, frame);
		}
		
		
	}
	
	
	
}