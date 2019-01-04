package law;

import java.io.IOException;
import java.util.ArrayList;

public class Court {
	Character defense;
	Character prosecution;
	Character judge;
	Character witness;
	Character defCounsel;
	Character prosCounsel;
	Character defObject;
	Character prosObject;
	ArrayList <Character>characters = new ArrayList<Character>();
	public Court() throws IOException {
		
		
		defObject = new Character("Defense Objection",-200,135);
	defense=new Character("Ouran Forenz", 100, 135);
		prosObject = new Character("Prosecution Objection",0,200);
		
		characters.add(defObject);
		characters.add(defense);
		characters.add(prosObject);
		
	}

	
	void switchview (int x,	String y) throws IOException {
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
		if (Main.currentCase.getCharacter(y)==null) Main.currentCase.characters.add(new Character(y, 100, 135));
	}	
	}
	
	void showcourt () {
		Main.inCourt = true;
	} 
	
	void update () {
		if(Main.currentCase.inCourt) {
			
			if (defense!=null)defense.update();
			if (prosecution!=null) prosecution.update();
			if (this.judge!=null )judge.update();
			if (this.witness!=null )		witness.update();
			if (defCounsel!=null )defCounsel.update();
			if (prosCounsel!=null )	prosCounsel.update();
			if (defObject!=null )	defObject.update();
			if (prosObject!=null )	prosObject.update();
		}
	}
	
	
}