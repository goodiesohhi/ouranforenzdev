package law;

import java.io.IOException;

class Statements {
	
	String initial;
	String speaker;
	String[] presses;

	String[] speakers;
	int behaviour;
	int manifest;
	int slot;
	Character character;
	String animation;
	int c;
	int frames;
    // 0 no function 
	// 1 needs to be pressed
	// 2 item needs to be presented
	public Statements(String i, Character speaker, String[] p, String[] s, int x,int y, int sl, String anim, int f ) {
		presses=p;
		initial=i;
		speakers=s;
		behaviour=x;
		manifest=y;
		slot=sl;
		c=0;
		this.speaker=speaker.name;
		animation=anim;
		character=speaker;
		frames = f;

	}
	
	
	
	void proc() throws IOException {
		
		Main.currentCase.currentExamine.conditions[slot] = new Conditions(behaviour, manifest, slot);
	
		if (animation!=null) Main.currentCase.getCharacter(speaker).play(animation, frames, false);
		
		Main.dialogue.insert(initial,speaker);
	
	}
	
	void update() {
		
	}
	void press() {
		System.out.println("PRESSED!");
		Main.currentCase.pressed=true;
		System.out.println(presses.length);
		
		
			
		
		if(behaviour==1) Main.currentCase.currentExamine.flags[slot]=true;
	}
		
	void present()	{
		}
		
	
	
	
}