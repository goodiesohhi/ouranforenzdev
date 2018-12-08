package law;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Location {
	
	ArrayList<Location> paths;
	int graphic;
	boolean[] flags;
	ArrayList<ClickEvent> clickEvents = new ArrayList<ClickEvent>();
	String name;
	
	public Location (String n, int g) {
		paths = new ArrayList<Location>();
		graphic=g;
		name=n;
		flags = new boolean[50];
	}
	
	void linkPath(Location l) {
		
		paths.add(l);
		l.paths.add(this);

		
	
	}
	void enter() throws IOException {
		Main.currentCase.eventQueue = new Event[1000000];
		   Main.currentCase.queueSize=0;
		   Main.currentCase.queueIndex=0;
		   
	Main.currentCase.currentLocation=this;	
	Main.inCourt=false;

	}
	
	void update() {
	
	}
	
	void click(MouseEvent me) {
		int x=me.getX();
		int y=me.getY();
	for (ClickEvent ce: clickEvents) {
			if ( (x>ce.x)&&(x<ce.x+ce.width)&&(y>ce.y)&&(y<ce.y+ce.height) ) this.events(ce.id);
		}
	}
	
	abstract void events(int i);
	
}