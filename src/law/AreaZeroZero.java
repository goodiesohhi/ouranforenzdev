package law;

import java.io.IOException;

public class AreaZeroZero extends Location {
	boolean block;
	StoryManager story = Main.currentCase;
	
	public AreaZeroZero() {
		 super("Detention center",201);
		 block=true;
	}
	
	void enter () throws IOException {
		super.enter();
		//Main.renderer.insert("nekoArson",112);
		 this.addEvent(new ClickEvent("badge", 200, 200, 100, 100, this.clickEvents,0));
		 
		 if (!flags[0]){
			
		
			 story.insertD("This is a place", "Hello");
				
			 story.insertD("This is a place", "Hello");
			 flags[0] = true;
			 Main.currentCase.flags[25]=true;
			  story.toCourt();
			
			 
			 
			 
			 
			 
			 
			 
			 
		 }
	}
	
	@Override
	void update() {
		super.update();
	}

	@Override
	void events(int i) {
		
		if (i==0) {
			story.insertD("Your Badge was added to the Court Record", "");
			story.insertR( "Ouran's Attorney's Badge","badge","My badge", false,0);
		}
		
	}

	@Override
	void talk(int i) {
		//What the hell are you?
		
		
	}
}