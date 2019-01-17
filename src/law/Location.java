package law; // chooses package

import java.awt.event.MouseEvent; // imports using mouse
import java.io.IOException; // imports IOExceptions
import java.util.ArrayList; // imports ArrayLists

public abstract class Location { // opens abstract class
	
	ArrayList<Location> paths; // holds linked locations
	ArrayList<Integer> clickedEvents = new ArrayList<Integer>(); // holds used click events
	int graphic; // chooses which background graphic to draw
	boolean[] flags; // holds flags for location
	ArrayList<ClickEvent> clickEvents = new ArrayList<ClickEvent>(); // holds all click events
	String name; // holds name of location
	public ArrayList<Question> questions= new ArrayList<Question> (); // holds list of questions for location
	public int id;
	
	public Location (String n, int g, int i) { // constructs location
		paths = new ArrayList<Location>(); // sets values
		graphic=g;
		name=n;
		flags = new boolean[500];
		id=i;
	}
	
	void linkPath(Location l) { // links paths

		paths.add(l); // adds path from location to other location
		l.paths.add(this); // adds path from other location to this location

		System.out.println(this.paths.get(0).name);
	
	}
	void enter() throws IOException { // enters location
		Main.currentCase.eventQueue = new ArrayList<Event>(); // resets event queue
		Main.currentCase.clearSprites(); // clears sprites from screen
		
		   Main.currentCase.queueSize=0; // sets the queue size to 0
		   Main.currentCase.queueIndex=0; // resets the index of the queue
		   
	Main.currentCase.currentLocation=this;	 // sets the current location
	Main.inCourt=false; // sets the game to not be in court
Main.entered=true;		 // sets the location to entered
Main.currentCase.inCourt=false; // sets the case to not be in court
Main.currentCase.somewhere=true; // sets the case to be in a location
Main.renderer.queue[0]= new Drawable(graphic,0,0,1,0,0); // draws background graphic
	}
	
	void update() { // updates location
	
	}
	
	void click(MouseEvent me) { // clicks on object
		int x=me.getX(); // gets x value
		int y=me.getY(); // gets y value
	for (ClickEvent ce: clickEvents) { // runs through click events
			if ( (x>ce.x)&&(x<ce.x+ce.width)&&(y>ce.y)&&(y<ce.y+ce.height) ) this.events(ce.id); // if the clicked location is within an event, runs event
		}
	}
	
	void addEvent(ClickEvent ce) { // adds event
		boolean exists=false; // sets value for existence to false
		for (ClickEvent ce2: clickEvents) { // runs through click events
			for (Integer inte:clickedEvents) { // runs through already clicked events
				if (inte.equals(ce2.id)) exists=true; // if the id of the click event already exists, set exists to true
			}
		}
		
		if (!exists)  this.clickEvents.add(ce); // if the event doesn't already exist, add it as an event
	}
	
	void addQuestion(Question ce) { // adds question
		boolean exists=false; // sets value for existence to false
		for (Question q: questions) { // runs through questions
			if (ce.id==q.id) exists=true; // if the question id is equal to any other question id, set exists to true
		}
		
		if (!exists)  this.questions.add(ce); // if the question doesn't already exist, add it to the location
	}
	
	void unlockQuestion (int i) { // unlocks question
		for (Question q: questions) { // runs through questions
			if (q.id==i) q.unlocked=true;  // if the question id is equal to the given one, unlock it.
		}
	}
	
	void clearQuestions() { // clears all questions
		questions= new ArrayList<Question> (); // resets array list
	}
	
	void interact (int x,int y) { // interacts with object
		//System.out.println("attempted interaction");
		//System.out.println (x+", "+y);
		for (ClickEvent ce: clickEvents) { // runs through click events
			//System.out.println(ce.x+":"+ce.y);
			if ( (x>ce.x)&&(x<ce.x+ce.width)&&(y>ce.y)&&(y<ce.y+ce.height) ) { // if the interaction is within a click event
				
				if (!ce.unlocked) {this.clickedEvents.add(ce.id); // if the event is not unlocked, add it
				if (ce.collectable)ce.unlocked=true; // if the event is collectible, unlock it
				this.events(ce.id); // runs the event with the id
				}
				}
		}
	}
	
	
	abstract void events(int i); // abstract method for events
	abstract void talk(int i); // abstract method for talking

	public int getVisible() { // finds number of visible questions
		int i=0; // sets value to 0
		for (Question q: questions) if (q.unlocked==true) i++; // increases for each unlocked question
		return i; // returns number of visible questions
	}

	protected abstract void present(RecordEntry recordEntry); // abstract method for presenting evidence
	
}

class Question { // opens class
	
	int id; // holds id of question
	boolean unlocked; // holds if question is unlocked
	public String question; // holds text for question
	boolean asked; // holds if the question has already been asked
	
	Question (int i, String s, boolean b) { // constructs question
		id=i; // sets values to defaults
		unlocked =b;
		question =s;
		asked=false;
	}
	
}