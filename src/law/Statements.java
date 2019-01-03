package law;

import java.io.IOException;

class Statements {
	
	String initial;
	String speaker;
	String[] presses;

	String[] speakers;
	String[] presentResponse;
	String[] presentSpeakers;
	Object[][] presentViews;
	static StoryManager story = Main.currentCase;
	int behaviour;
	String presentThis;
	Character character;
	String animation;
	int c;
	boolean presentable=false;
	int frames;
	 String objectName;
    // 0 no function 
	// 1 needs to be pressed
	// 2 item needs to be presented
	public Statements(String i, Character speaker, String[] p, String[] s, int x, String evidence, String anim, int f ) {
		presses=p;
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
	
	void addPresent(String[] d, String[] s, Object [][] v, String n) {
		presentResponse=d;
		presentSpeakers=s;
		presentViews=v;
		objectName=n;
		presentable=true;
	}
	
	
	
	void proc() throws IOException {
		
		
	
		if (animation!=null) Main.currentCase.getCharacter(speaker).play(animation, frames, false);
	
		Main.dialogue.insert(initial,speaker);
		
	
	}
	
	void update() {
		
	}
	void press() {
		
		Main.currentCase.pressed=true;
		
		
		
			
		
		if(behaviour==1) Main.currentCase.currentExamine.passCondition(1);
	}
		
	void present(RecordEntry recordEntry)	{
		Main.dialogue.reset();
		
		String name = recordEntry.name;
		if (behaviour==2&&this.objectName.equals(name))  Main.currentCase.currentExamine.passCondition(2);
		story.presented=true;

	
		if (this.objectName!=null) {
			
		if (this.objectName.equals(name)) 
		{ 
			if (name.equals("Ouran's Attorney's Badge")) {
			story.insertV(0, null);
			story.insertD("Badge has been presented", "Judgebot 3000");
			story.insertD("This condition has been fulfilled", "Judgebot 3000");
			story.switchBackToEventQueue();
			
		} else if (name.equals("example")) {
			
		}  } 
		else {
			
			story.insertV(0, null);
			story.insertD("Ummm.. How is that of any relevance?", "Judge Judge");
		story.switchBackToEventQueue();
			
		}
		}else {
			story.insertV(0, null);
			story.insertD("Ummm.. How is that of any relevance?", "Judge Judge");
		story.switchBackToEventQueue();
			
		}
	 
		} 
		
	
	
	
}