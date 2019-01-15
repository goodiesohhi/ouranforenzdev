package law; // selects package

import java.io.IOException; // imports IOException
import java.util.ArrayList; // imports ArrayLists

class Event { // opens class
	
	String command; // holds event
	
	Object[] list; // holds list of objects to be acted on
	String x; // holds first string parameter
	String y; // holds second string parameter
	int z; // holds first integer parameter
	int v; // holds second integer parameter
	int n; // holds third integer parameter
	int i; // holds fourth integer parameter
	String d; // holds second string parameter
	Boolean u; // holds first boolean parameter
	
	public Event(String event, int zz ) { // constructs an event with the command and an integer
	
		z=zz;
		command = event;
	}

	public Event(String event, int zz, int nn ) { // constructs an event with the command and two integers
	
		z=zz;
		n=nn;
		command = event;
	}
	
	public Event(String event, int zz, int vv,int nn ) { // constructs an event with the command and three integers
		
		z=zz;
		n=nn;
		v=vv;
		command = event;
	}
	public Event(String event, String xz, String yz ) { // constructs an event with the command and two strings
		
		x=xz;
		y=yz;
		command = event;
	}
	
	public Event(String string, String name,String x2, String z2, Boolean u2, int i2) { // constructs an event with the command, three strings, a boolean, and an integer
		command=string;
		d=name;
		x=x2;
		y=z2;
		u=u2;
		i=i2;
	}

	public Event(String string, String string2, String string22, int i2, boolean b) { // constructs an event with a command, two strings, an integer and a boolean
		command = string;
		d=string2;
		x=string22;
		i=i2;
		u=b;
	}

	public Event(String string) { // constructs an event with only the command
		command = string;
	}

	public Event(String string, int y2, String n2) { // constructs an event with a command, a string, and an integer
		command=string;
		z=y2;
		x=n2;
		
	}

	//&&Main.currentCase.objected==false
	void execute() throws IOException { // executes event
		
		

		if( (!Main.currentCase.working&& !Main.currentCase.inDialogue&& !Main.currentCase.inExamine&& !Main.currentCase.beginExamine)||(!Main.currentCase.working&& !Main.currentCase.inDialogue&& Main.currentCase.inExamine&&Main.currentCase.presented)) { // if the case is examining something and something is presented
			
			if (Main.currentCase.presented)System.out.println(this.command+" command in PresenQueue has been executed"); else  //presents item
				System.out.println(this.command+" command in eventQueue has been executed"); // uses event item
			Main.currentCase.working=true; // sets the case to working
			if (command=="court") { // if the command is moving to court
				
				Main.currentCase.currentLocation=null; // the location is set to null
				Main.inCourt=true; // the game is set to court
				Main.currentCase.inCourt=true; // the case is set to court
				Main.currentCase.oneProc=false; // sets nothing to running
				Main.gui.menu=-1; // menu set to not appear
				 Main.gui.queue = new Drawable[40]; // queue created
				  Main.gui.textQueue = new DrawableText[50]; // text queue created
				  Main.currentCase.clearSprites(); // removes sprites
				Main.currentCase.insertV(0,null); // sets view to judge
				
				
			 
			} else if (command=="cls") { // if the command is to clear the screen
				 Main.currentCase.clearSprites(); // clears sprites
			}
			
			else if (command=="playAni") { // if the command is to play an animation
				Main.currentCase.clearSprites(); // clear sprites
				Main.currentCase.getCharacter(d).play(x, i, u); // play animation
			
			} 
			else if (command=="showAni") { // if the command is to show an animation
			
				Main.currentCase.getCharacter(d).play(x, i, u); // plays animation
			
			}else if (command=="switchBack") { // if the command is to switch back to statements
				Main.currentCase.presentQueue= new ArrayList<Event>(); // creates new presenting queue
			 Main.currentCase.presented=false; // sets nothing as presented
				
			}
			
			else	 // if the command is to be start a cross-examination
	if (command=="firstCE") {
	
		Main.currentCase.currentExamineQueue=Main.cExamine[z]; // sets the examined statement
		Main.currentCase.beginExamine=true; // starts examining
		Main.currentCase.working=true; // sets the case to working
		Main.gui.menu=69; // sets the menu to the cross-examine menu
		//System.out.println("Yes");
	 
	}	else	 
		if (command=="ce") { // if the command is to cross-examine
			
			Main.currentCase.currentExamine=Main.cExamine[z]; // sets the examined statement
			Main.currentCase.inExamine=true; // sets the case to be in an examination
	
			//System.out.println("Yes");
		 
		}	
		else
	if (command=="d") { // if the command is to say something
		Main.dialogue.insert(x, y); // inserts dialogue
		
	}	
	
	else
	if (command=="data") { // if the command is to create a data field
		Main.dialogue.insert(x, y,true); // inserts data field
		
	}	
	else 
		
	if (command=="v") { // if the command is to change view
		
		Main.currentCase.court.oneProc=false; // sets nothing to running
		   Main.currentCase.court.switchview(z,x); // moves view
		
	} else if (command=="e") { // if the command is to move to a location
		 Main.currentCase.locales[z].enter(); // enters a location
	}
	
	
else if (command=="s") { // if the command is to draw a sprite
	Main.renderer.queue[1]= new Drawable(z, v,n,1,0,1); // draws sprite
}
else if (command=="r") { // if the command is to add to the record
	if(u) { // checks for profile
		
	Main.currentCase.profiles.add(new RecordEntry(d,x, u,y,i)); // adds profile
	} else { // if not profile
		RecordEntry r = Main.currentCase.findItem(d); // checks for update
		if (r==null) {  // if the entry isn't there already
		Main.currentCase.evidence.add(new RecordEntry(d,x, u,y,i)); // adds entry
		}
		else  { // if the entry is already there, updates everything
			int index = Main.currentCase.evidence.indexOf(r);
			Main.currentCase.evidence.remove(r);
			r = new RecordEntry(d,x, u,y,i);
			Main.currentCase.evidence.add(index, r);
			System.out.println("r is: "+r);
		}
	}
} else if (command=="ro") { // if the command is to use an objection
		
	Main.currentCase.court.defObject= new Character("Defense Objection",-200,135); // creates defence objection
	Main.currentCase.court.prosObject=new Character("Prosecution Objection",0,200); // creates prosecution objection
	Main.currentCase.motionTrack=null; // removes motion track
	Main.currentCase.court.characters = new ArrayList<Character>(); // creates array list of characters
	Main.currentCase.court.characters.add(	Main.currentCase.court.defObject); // adds defence objection
	
	Main.currentCase.court.characters.add(	Main.currentCase.court.prosObject); // adds prosecution objection
	System.out.println("clear object"); // prints out clearing of object
	
}
	
	else if (command=="o") { // checks if command is to play objection
		if( z==0) {  // if the defence objects
			Main.gui.menu=69; // sets menu
			Main.currentCase.motionTrack = 	Main.currentCase.court.defObject; //sets objection
	Main.currentCase.motionTrack.moveBy(400, 0,20); // moves track
	Main.currentCase.motionTrack.play("objection", 0, false); // plays objection

		}
		else if (z==1) { // if the prosecution objects
			
		}
	
		
		
	}
	
	
			if (Main.currentCase.presented) Main.currentCase.presentQueue.remove(0); // if the case is presented, remove one presented item
				else
				Main.currentCase.eventQueue.remove(0); // remove an event item
		
	  if((!command.equals("playAni")&&!command.equals("firstCE"))||(command.equals("playAni")&&!u))Main.currentCase.working=false; // if nothing is playing, the case is not working
	  if(command.equals("o")) { //checks if an objection is being played
		  System.out.println("O COMMAND"); //prints line
		  Main.currentCase.working=true; // sets the case to working
		  System.out.println(Main.currentCase.working); // prints line
	  }
	}
	}
}
	
	
	
