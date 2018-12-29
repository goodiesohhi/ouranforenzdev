package law;

import java.io.IOException;

public class Court {
	Character defense;
	Character prosecution;
	Character judge;
	Character witness;
	Character defCounsel;
	Character prosCounsel;
	public Court() throws IOException {
		
		defense=new Character("Ouran Forenz", 0, 0);
		
		
	}
	
	
	void switchview (int x,	int y) throws IOException {
Main.renderer.clear();
	if(x==0) {
		Main.renderer.queue[0]= new Drawable(10,0,0,1,0,0);
		if (Main.currentCase.getCharacter("Judge Judge")==null) Main.currentCase.characters.add(new Character("Judge Judge", 350, 96));
		Main.renderer.queue[1]= new Drawable(1,350,96,1,0,1);
	}	
	
	if(x==1) {
		Main.renderer.queue[0]= new Drawable(11,0,0,1,0,0);
		if (Main.currentCase.getCharacter("Ouran Forenz")==null) Main.currentCase.characters.add(new Character("Ouran Forenz", 100, 135));
		Main.renderer.queue[1]= new Drawable(1,100,135,1,0,1);
	}	
	if(x==2) {
		Main.renderer.queue[0]= new Drawable(12,0,0,1,0,0);
		if (Main.currentCase.getCharacter("Adrasteia Rhamnousia")==null) Main.currentCase.characters.add(new Character("Adrasteia Rhamnousia", 100, 135));
		Main.renderer.queue[1]= new Drawable(1, 300,280+68,1,0,1);
	}	
	if(x==3) {
		Main.renderer.queue[0]= new Drawable(13,0,0,1,0,0);
		Main.renderer.queue[1]= new Drawable(y, 150,188,1,0,1);
	}	
	}
	
	void showcourt () {
		Main.inCourt = true;
	} 
	
	
	
}