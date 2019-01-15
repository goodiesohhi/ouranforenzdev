package law; // chooses package

import java.io.IOException; // imports IOException

class Statements { // opens class
	
	String initial; // holds initial statement
	String speaker; // holds speaker
	String[] presses; // holds statements in press

	String[] speakers; // holds speakers in press
	String[] presentResponse; // holds statements in present
	String[] presentSpeakers; // holds speakers in present
	Object[][] presentViews; // holds viewpoints during present
	static StoryManager story = Main.currentCase; // holds current case
	int behaviour; // holds what condition must be fulfilled
	String presentThis; // holds what statement be presented
	Character character; // holds the character who says the statement
	String animation; // holds the animation that must be drawn
	int c; // holds number of statement
	boolean presentable=false; // holds whether something must be presented
	int frames; // holds number of frames
	 String objectName; // holds name of what must be presented
    // 0 no function 
	// 1 needs to be pressed
	// 2 item needs to be presented
	public Statements(String i, Character speaker, String[] p, String[] s, int x, String evidence, String anim, int f ) { // constructor for statements
		presses=p; // fills variables
		initial=i;
		speakers=s;
		behaviour=x;
		objectName=evidence;
	
		c=0;
		this.speaker=speaker.name;
		animation=anim;
		character=speaker;
		frames = f;

	}
	
	void addPresent(String[] d, String[] s, Object [][] v, String n) { // adds something that must be presented
		presentResponse=d; // fills variables
		presentSpeakers=s;
		presentViews=v;
		objectName=n;
		presentable=true;
	}
	
	
	
	void proc() throws IOException { // runs statement
		
		
	
		if (animation!=null) Main.currentCase.getCharacter(speaker).play(animation, frames, false); // plays animation
	
		Main.dialogue.insert(initial,speaker); // runs dialogue
		
	
	}
	
	void update() { // updates statement
		
	}
	void press() { // presses statement
		
		Main.currentCase.pressed=true; // sets pressed to true
		
		
		
			
		
		if(behaviour==1) Main.currentCase.currentExamine.passCondition(1); // passes press condition
	}
		
	void present(RecordEntry recordEntry)	{ // presents on statement
		Main.dialogue.reset(); // resets dialogue
		
		String name = recordEntry.name; // holds name of record entry
		if (behaviour==2&&this.objectName.equals(name))  Main.currentCase.currentExamine.passCondition(2); // passes present condition
		story.presented=true; // sets presented to true

	
		if (this.objectName!=null) { // if the object exists
			
		if (this.objectName.equals(name))  // if the object's name is what it should be
		{ 
			if (name.equals("Ouran's Attorney's Badge")) { // if the object is the badge
			story.insertO(0); // insert objection
			story.insertD("RANDOM OBJECTION!", "Ouran Forenz"); // play dialogue
			story.removeO(); // remove objection
			
			story.insertV(0, null); // change view
			
			story.insertD("Badge has been presented", "Judgebot 3000"); // play dialogue
			story.insertD("This condition has been fulfilled", "Judgebot 3000");
			story.switchBackToEventQueue(); // switches to event queue
			
		} else if (name.equals("Autopsy Report")) {
			
			
			story.insertO(0);
			story.insertD("RANDOM OBJECTION!", "Ouran Forenz");
			story.removeO();
			
			story.insertV(0, null);
			
			story.insertD("My Little Pony", "Judgebot 3000");
			
			story.switchBackToEventQueue();

			
		}  } 
		else { // if evidence is not correct
			
			story.insertV(0, null); // switches view to judge
			story.insertD("Ummm.. How is that of any relevance?", "Judge Judge"); //plays default dialogue
		story.switchBackToEventQueue(); // switches to event queue
			
		}
		}else { // if the requirement is not to present
			story.insertV(0, null); // switches view to judge
			story.insertD("Ummm.. How is that of any relevance?", "Judge Judge"); // plays default dialogue
		story.switchBackToEventQueue(); // switches to event queue
			
		}
	 
		} 
		
	
	
	
}