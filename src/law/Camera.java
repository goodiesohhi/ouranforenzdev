package law; // sets package
class Camera { // opens class
	int x; // initializes x
	int y; // initializes y
	int dx; // initializes x velocity
	int dy; // initializes y velocity
	int speed; // initializes speed
	
	public Camera() { // opens constructor
		
		x=0; // sets x value
		y=0; // sets y value
		dx=0; // sets change in x location
		dy=0; // sets change in y location
		speed=10; // sets speed
		
		
		
	}
	 void update() { // updates camera
			if(dx>x)x=x+speed; // moves camera left by speed
			if(dx<x)x=x-speed; // moves camera right by speed
			if(dy>y)y=y+speed; // moves camera down by speed
			if(dy<y)y=y-speed; // moves camera up by speed
			
			
	 }
	 
	 void reset() { // resets camera by setting all variables to original values
			x=0;
			y=0;
			dx=0;
			dy=0;
			speed=10; 
	 }
	 void pan(int dx2, int dy2) { // pans camera
		
		
		
		dx =dx2; // sets new value of dx
		dy =dy2; // sets new value of dy
	}
	
	
}