package law;
class Camera {
	int x;
	int y;
	int dx;
	int dy;
	int speed;
	
	public Camera() {
		
		x=0;
		y=0;
		dx=0;
		dy=0;
		speed=10;
		
		
		
	}
	 void update() {
			if(dx>x)x=x+speed;
			if(dx<x)x=x-speed;
			if(dy>y)y=y+speed;
			if(dy<y)y=y-speed;
			
			
	 }
	 
	 void reset() {
			x=0;
			y=0;
			dx=0;
			dy=0;
			speed=10; 
	 }
	 void pan(int dx2, int dy2) {
		
		
		
		dx =dx2;
		dy =dy2;
	}
	
	
}