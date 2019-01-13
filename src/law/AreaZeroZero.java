package law; // sets package

import java.io.IOException; // imports IOException

public class AreaZeroZero extends Location { // opens class
	boolean block; // holds if the location should play opening
	StoryManager story = Main.currentCase; // holds the current case for the location
	
	public AreaZeroZero() { // constructor
		 super("Detention center",201); // sets id of location
		 block=true; // sets block to true
	}
	
	void enter () throws IOException {
		super.enter();
		//Main.renderer.insert("nekoArson",112);
		 this.addEvent(new ClickEvent(true,"badge", 200, 200, 100, 100, this.clickEvents,0)); //adds badge event
		 
		 if (!flags[0]){ // checks for first time entering area
			
		
			 story.insertData("This is a place"); // prints out test data field
				
			 story.insertData("This is a place");
			 flags[0] = true; // sets flag for area entering to true
			 
			
			 
			 
			 
			 
			 
			 
			 
			 
		 }
	}
	
	@Override
	void update() { // updates location
		super.update(); // updates super
	}

	@Override
	void events(int i) { // holds events
		
		if (i==0) { // checks if badge was selected
			story.insertData("Your Badge was added to the Court Record");
			story.insertR( "Ouran's Attorney's Badge","badge","My badge", false,0); // adds badge to record
		}
		
	}

	@Override
	void talk(int i) { // runs talk method with nothing in it because there's no-one here.
		//What the hell are you?
		
		
	}

	@Override
	protected void present(RecordEntry recordEntry) { // runs present method with nothing in it because there's no-one here.
		// TODO Auto-generated method stub
		
	}
}