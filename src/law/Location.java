package law;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Location {
	
	ArrayList<Location> paths;
	ArrayList<Integer> clickedEvents = new ArrayList<Integer>();
	int graphic;
	boolean[] flags;
	ArrayList<ClickEvent> clickEvents = new ArrayList<ClickEvent>();
	String name;
	public ArrayList<Question> questions= new ArrayList<Question> ();
	
	public Location (String n, int g) {
		paths = new ArrayList<Location>();
		graphic=g;
		name=n;
		flags = new boolean[500];
	}
	
	void linkPath(Location l) {
		
		paths.add(l);
		l.paths.add(this);

		
	
	}
	void enter() throws IOException {
		Main.currentCase.eventQueue = new ArrayList<Event>();
		Main.currentCase.clearSprites();
		
		   Main.currentCase.queueSize=0;
		   Main.currentCase.queueIndex=0;
		   
	Main.currentCase.currentLocation=this;	
	Main.inCourt=false;
Main.entered=true;		
Main.currentCase.inCourt=false;
Main.currentCase.somewhere=true;
Main.renderer.queue[0]= new Drawable(graphic,0,0,1,0,0);
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
	
	void addEvent(ClickEvent ce) {
		boolean exists=false;
		for (ClickEvent ce2: clickEvents) {
			for (Integer inte:clickedEvents) {
				if (inte.equals(ce2.id)) exists=true;
			}
		}
		
		if (!exists)  this.clickEvents.add(ce);
	}
	
	void addQuestion(Question ce) {
		boolean exists=false;
		for (Question q: questions) {
			if (ce.id==q.id) exists=true;
		}
		
		if (!exists)  this.questions.add(ce);
	}
	
	void unlockQuestion (int i) {
		for (Question q: questions) {
			if (q.id==i) q.unlocked=true; 
		}
	}
	
	void clearQuestions() {
		questions= new ArrayList<Question> ();
	}
	
	void interact (int x,int y) {
		//System.out.println("attempted interaction");
		//System.out.println (x+", "+y);
		for (ClickEvent ce: clickEvents) {
			//System.out.println(ce.x+":"+ce.y);
			if ( (x>ce.x)&&(x<ce.x+ce.width)&&(y>ce.y)&&(y<ce.y+ce.height) ) {
				
				if (!ce.unlocked) {this.clickedEvents.add(ce.id);
				if (ce.collectable)ce.unlocked=true;
				this.events(ce.id);
				}
				}
		}
	}
	
	
	abstract void events(int i);
	abstract void talk(int i);

	public int getVisible() {
		int i=0;
		for (Question q: questions) if (q.unlocked==true) i++;
		return i;
	}

	protected abstract void present(RecordEntry recordEntry);
	
}

class Question {
	
	int id;
	boolean unlocked;
	public String question;
	boolean asked;
	
	Question (int i, String s, boolean b) {
		id=i;
		unlocked =b;
		question =s;
		asked=false;
	}
	
}