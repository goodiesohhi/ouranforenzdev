package law; // selects package

import java.awt.image.BufferedImage; // imports images
import java.io.IOException; // imports IOException
import java.util.ArrayList; // imports ArrayLists

import javax.imageio.ImageIO; // imports image input

public class Court { // opens class
	Character defense; // holds defense
	Character prosecution;// holds prosecutor
	Character judge; // holds judge
	Character witness; // holds witness
	Character defCounsel; // holds defense counsel
	Character prosCounsel; // holds prosecutor counsel
	Character defObject; // holds the defence's objection
	Character prosObject; // holds the prosecutor's objection
	Character[] ceObjects; // holds all event objects
	boolean oneProc=false; // checks that only one segment is run
	boolean bench=false;
	ArrayList <Character>characters = new ArrayList<Character>(); // holds all characters
	public BufferedImage black; // holds background image
	public Court() throws IOException { // opens constructor
		black = ImageIO.read( Main.class.getResource("/resources/black.png")); // sets black background image
		
		defObject = new Character("Defense Objection",-200,135); // sets the defence objection
	defense=new Character("Ouran Forenz", 100, 135); // sets the defence
		prosObject = new Character("Prosecution Objection",0,200); // sets the prosecution objection
		
		characters.add(defObject); // adds the defence to the characters
		ceObjects = new Character[4]; // creates a new character object
		characters.add(prosObject); // adds the prosecution to the characters
		ceObjects[0] = new Character("ceDef",0,0); // adds the defence event to the objects
		characters.add(ceObjects[0]); // adds a new character
		
	}

	
	void switchview (int x,	AnimData y) throws IOException { // switches view of court
		Main.lastView= new ViewData(x,y.charName);
		Main.currentCase.inCourt=true;
Main.renderer.clear(); // clears view
Main.currentCase.clearSprites();	// removes sprites
	if(x==0) { // checks if the view is of the judge
		Main.renderer.queue[0]= new Drawable(10,0,0,1,0,0); // draws background
		if (Main.currentCase.getCharacter("Judge Judge")==null) Main.currentCase.characters.add(new Character("Judge Judge", 250, 60)); // draws judge
		if (!oneProc)
		{
		Main.currentCase.getCharacter("Judge Judge").play("judgeBot", 0, false); // plays animation
		oneProc=true; // ensures that only one animation runs
		}
	}	
	
	if(x==1) { // checks if view is of the defence
		Main.renderer.queue[0]= new Drawable(11,0,0,1,0,0); // draws background
		if (Main.currentCase.getCharacter("Ouran Forenz")==null) Main.currentCase.characters.add(new Character("Ouran Forenz", 100, 185)); // draws Ouran
		if (!oneProc)
		{
		Main.currentCase.getCharacter("Ouran Forenz").play("ouranobject", 0, false); // plays animation
		oneProc=true; // ensures that only one animation runs
		}
	}	
	if(x==2) { // checks if view is of the prosecutor
		Main.renderer.queue[0]= new Drawable(12,0,0,1,0,0); // draws background
		if (Main.currentCase.getCharacter(Main.currentCase.currentProsecutor)==null) Main.currentCase.characters.add(new Character(Main.currentCase.currentProsecutor, 220, 195)); // adds character
		{
			if (Main.currentCase.caseID!=1) {
				Main.currentCase.getCharacter(Main.currentCase.currentProsecutor).play("adrestiaIdle", 7, true); // plays animation
			} else {
				Main.currentCase.getCharacter(Main.currentCase.currentProsecutor).play("melTalk", 2, true); // plays animation
			}
			oneProc=true; // ensures that only one animation runs
			}
		
	}	
	if(x==3) { // checks if view is of witness
		
		Main.renderer.queue[0]= new Drawable(13,0,0,1,0,0); // draws background
		if (Main.currentCase.getCharacter(y.charName)==null) { // checks if there is no current witness
			Main.currentCase.characters.add(new Character(y.charName, 100, 135)); // adds new character for witness
			
		}
		System.out.println(y.charName);
		System.out.println(y.animName);
		if (!oneProc)
		{ System.out.println("FRAMEZ:");
			System.out.println(y.frames);
			Main.currentCase.getCharacter(y.charName).play(y.animName, y.frames, y.loop);
			Main.currentCase.getCharacter(y.charName).animation.playing=true;
		oneProc=true; // ensures that only one animation runs
		}
		Main.currentCase.currentWitness= y.charName; // sets witness as character
		Main.renderer.queue[5]= new Drawable(29,-20,0,1,0,0);
	}
	if(x==4) {
		Main.renderer.queue[0]= new Drawable(14,0,0,1,0,0); // draws background
		if (Main.currentCase.getCharacter("Nekocchi")==null) Main.currentCase.characters.add(new Character("Nekocchi", 100, 135)); // adds Nekocchi
		if (!oneProc) //  checks if this is the only animation running
		{
		Main.currentCase.getCharacter("Nekocchi").play("nekocchiWitness", 0, false); // plays animation
		oneProc=true; // sets variable to true
		}
	}
	if(x==5) {
		Main.renderer.queue[0]= new Drawable(15,0,0,1,0,0); // draws background
		if (Main.currentCase.getCharacter(y.charName)==null) { // checks if there is no current witness
			Main.currentCase.characters.add(new Character(y.charName, 100, 135)); // adds new character for witness
		}
		Main.currentCase.currentWitness= y.charName; // sets witness as character
	}
	
	if (x==69) { // checks if view is default
		Main.renderer.queue[0]= new Drawable(black,0,0,1,0,0); // draws black screen
	}
	
	}
	
	void showcourt () { // shows court
		Main.inCourt = true; // sets game to be in court
	} 
	
	void update () { // updates
		if(Main.currentCase.inCourt) { // checks if case is in court
			 // updates everything
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


	public void switchview(int x, String y) throws IOException {
		Main.lastView= new ViewData(x,y);
		System.out.println("switchView");
		Main.currentCase.inCourt=true;
		Main.renderer.clear(); // clears view
		Main.currentCase.clearSprites();	// removes sprites
			if(x==0) { // checks if the view is of the judge
				Main.renderer.queue[0]= new Drawable(10,0,0,1,0,0); // draws background
				if (Main.currentCase.getCharacter("Judge Judge")==null) Main.currentCase.characters.add(new Character("Judge Judge", 250, 60)); // draws judge
				if (!oneProc)
				{
				Main.currentCase.getCharacter("Judge Judge").play("judgeBot", 0, false); // plays animation
				oneProc=true; // ensures that only one animation runs
				}
			}	
			
			if(x==1) { // checks if view is of the defence
				Main.renderer.queue[0]= new Drawable(11,0,0,1,0,0); // draws background
				if (Main.currentCase.getCharacter("Ouran Forenz")==null) Main.currentCase.characters.add(new Character("Ouran Forenz", 100, 245)); // draws Ouran
				if (!oneProc)
				{
				Main.currentCase.getCharacter("Ouran Forenz").play("ouranobject", 0, false); // plays animation
				oneProc=true; // ensures that only one animation runs
				}
			}	
			if(x==2) { // checks if view is of the prosecutor
				Main.renderer.queue[0]= new Drawable(12,0,0,1,0,0); // draws background
				if (Main.currentCase.getCharacter(Main.currentCase.currentProsecutor)==null) Main.currentCase.characters.add(new Character(Main.currentCase.currentProsecutor, 220, 195)); // adds character
				{
					if (Main.currentCase.caseID!=1) {
						Main.currentCase.getCharacter(Main.currentCase.currentProsecutor).play("adrestiaIdle", 7, true); // plays animation
					} else {
						Main.currentCase.getCharacter(Main.currentCase.currentProsecutor).play("melTalk", 2, true); // plays animation
					}
					oneProc=true; // ensures that only one animation runs
					}
				
			}	
			if(x==3) {
				// checks if view is of witness
				
				Main.renderer.queue[0]= new Drawable(13,0,0,1,0,0); // draws background
				if (Main.currentCase.getCharacter(y)==null) { // checks if there is no current witness
					Main.currentCase.characters.add(new Character(y, 100, 135)); // adds new character for witness
					
				}
				
				if (!oneProc)
				{
					
				oneProc=true; // ensures that only one animation runs
				System.out.println(y+ " zed");
				if(y.equals("Nekocchi")) {
					
					System.out.println("retarded parents");
					Main.currentCase.getCharacter("Nekocchi").play("nekocchiWitness", 0, false); 
					
				}
				
				if(y.equals("Det. Pat. Bluthund")) {
					Main.currentCase.getCharacter("Det. Pat. Bluthund").play("bluthundTalk", 2, true); 
					
				}
				
				if(y.equals("Gilligan Tam")) {
					Main.currentCase.getCharacter("Gilligan Tam").play("gilliganTalk", 16, true); 
					
				}
				if(y.equals("Enrico Nocent")) {
					Main.currentCase.getCharacter("Enrico Nocent").play("enricoWitness", 0, false); 
					
				}
			
				
				
				}
				Main.currentCase.currentWitness= y; // sets witness as character
				
			}
			if(x==4) {
				Main.renderer.queue[0]= new Drawable(14,0,0,1,0,0); // draws background
				if (Main.currentCase.getCharacter("Nekocchi")==null) Main.currentCase.characters.add(new Character("Nekocchi", 100, 135)); // adds Nekocchi
				if (!oneProc) //  checks if this is the only animation running
				{
				Main.currentCase.getCharacter("Nekocchi").play("nekocchiWitness", 0, false); // plays animation
				oneProc=true; // sets variable to true
				}
			}
			if(x==5) {
				Main.renderer.queue[0]= new Drawable(15,0,0,1,0,0); // draws background
				if (Main.currentCase.getCharacter(y)==null) { // checks if there is no current witness
					Main.currentCase.characters.add(new Character(y, 100, 135)); // adds new character for witness
				}
				Main.currentCase.currentWitness= y; // sets witness as character
				
if(y.equals("Nekocchi")) {
					
					System.out.println("retarded parents");
					Main.currentCase.getCharacter("Nekocchi").play("nekoArson", 0, false); 
					
				}
				
				if(y.equals("Det. Pat. Bluthund")) {
					Main.currentCase.getCharacter("Det. Pat. Bluthund").play("bluthundTalk", 2, true); 
					
				}
				
				if(y.equals("Gilligan Tam")) {
					Main.currentCase.getCharacter("Gilligan Tam").play("gilliganTalk", 16, true); 
					
				}
				if(y.equals("Enrico Nocent")) {
					Main.currentCase.getCharacter("Enrico Nocent").play("enricoWitness", 0, false); 
					
				}
			}
			
			if (x==69) { // checks if view is default
				Main.renderer.queue[0]= new Drawable(black,0,0,1,0,0); // draws black screen
			}
			
		
	}
	
	
}