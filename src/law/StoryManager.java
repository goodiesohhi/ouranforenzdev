package law; // chooses package

import java.awt.image.BufferedImage; // imports image
import java.io.File; // imports files
import java.io.FileInputStream; // imports input of files
import java.io.FileNotFoundException; // imports exception for not finding files
import java.io.IOException; // imports IOException
import java.io.InputStream; // imports stream of input
import java.util.ArrayList; // imports array lists
import java.util.Arrays; // imports arrays



class StoryManager { // opens class
	boolean presented; // holds if something has been presented
	ArrayList<Character> characters = new ArrayList<Character>(); // holds list of characters
	Location currentLocation; // holds the current location
    boolean invest; // holds whether the game is in investigation
	ArrayList<RecordEntry> profiles = new ArrayList<RecordEntry>(); // holds array list of profiles
	int examined=0; // holds what is examined
	ArrayList<RecordEntry>evidence = new ArrayList<RecordEntry>(); // holds array list of evidence
	 Location[] locales = new Location[40];  // holds array of locations
	boolean somewhere; // holds whether the case is in a location
	boolean[] flags = new boolean[500]; // holds array of flags
	boolean inExamine = false; // holds whether the game is in an examination
	boolean objected=false; // holds whether something has been objected
	Court court; // holds current court
 ClassLoader classLoader = getClass().getClassLoader(); // holds class loader
 boolean textBox=true; // holds whether a text box should be drawn
 boolean start =true; // holds whether the case has started
 boolean block = true; // holds whether a block should run
 ArrayList<Event>eventQueue = new ArrayList<Event>();  // holds queue of events
 ArrayList<Event>presentQueue = new ArrayList<Event>();  // holds queue of what should be presented
 boolean working; // holds whether the case is working
 String currentProsecutor; // holds the current prosecutor
 int queueIndex = 0; // holds the index in the queue
 int queueSize = 0; // holds the size of the queue
 int witness = 0; // holds the current witness
 Character motionTrack; // moves the camera
 CrossExamination currentExamine; // holds the current cross-examination
 //ints to track progression and regulate flow of events 
 int benchmark =0;
 int progress = 0;
 boolean oneProc; // ensures that only one block runs
boolean  inCourt=true; // holds whether the case is in court
 
 //mode novel = 0 invest = 1 court =2 
 int mode = 0;
 //phase
 //novel only has phase 0.
 // invest has 0=talk 1=click invest thing 2= move
 // court has 0=talk 1= testimony 2= crossexamine 3= special events 4=flavour shots
 int phase = 0;
 
 boolean inDialogue = false; // holds whether the case is in a dialogue
public boolean pressed = false; // holds whether a statement has been pressed
public Character currentChar; // holds the current character
public CrossExamination currentExamineQueue; // holds the current cross-examination
public boolean beginExamine; // holds whether an examination has begun
public int timer1=0; // holds the timer
public boolean dataText; // holds whether the text is a data field
public String currentWitness; // holds the witness
public int caseID;
public String caseName;


 public Character getCharacter(String x) { // finds character
	 
	 int len=characters.size(); // runs through characters
	 for(int i=0; i<len; i++) {
	     if (characters.get(i).name.equals(x)) { // checks if character's name is the string
	        return characters.get(i); // returns the character
	     }
	 }
	 return null; // returns nothing
 }
 public StoryManager(int id, String n) throws IOException  { // construtctor
	 // fills variables
	 court= new Court();
	 currentChar=court.defense;
	 somewhere=false;
	 caseID=id;
	 caseName=n;
  
  
 }
 
  void update() throws IOException { // updates sotry manager
//System.out.println(eventQueue.toString());
	  court.update(); // updates court
	  if (this.beginExamine&&Main.currentCase.working) { // if the case is working and has begun an examination
		  timer1++; // increase timer
		  
		  if (timer1>100) { // if the timer is over 100
			  Main.currentCase.currentExamine=Main.currentCase.currentExamineQueue; // play the examination
				Main.currentCase.inExamine=true; // set the case to in an examination
				Main.currentCase.beginExamine=false; // set the case to not beginning an examination
				timer1=0; // resets timer
				Main.currentCase.currentExamineQueue=null; // resets examine queue
				this.working=false; // sets case to not working
				Main.gui.menu=-1; // sets menu to base
				Main.currentCase.court.switchview(3, Main.currentCase.currentWitness); // switches view of court to witness
			  
		  }
	  }
	  if (Main.currentCase.eventQueue.size()>=1) { // if there are items in the event queue
			if (!Main.currentCase.eventQueue.get(0).command.equals("d")) Gui.inChat =false; // if the command is not d, set the case to not be in chat
		} else {
			Gui.inChat =false; // if there are no items, set case to not be in chat
		}
	  
	  if (motionTrack!=null&&Main.currentCase.working) { // if the motion track exists and the case is working
		  System.out.println(motionTrack.x+"/"+motionTrack.dx); // say the position of the track and where it's moving
		  if(Math.abs((double)(motionTrack.dx-motionTrack.x))<10&&Math.abs((double)(motionTrack.dy-motionTrack.y))<10) { // if the difference between the current position and the destination is less than 10 in both x and y
			  Main.currentCase.working=false; // sets case to not working
				Main.gui.menu=-1; // return to base menu
			
		  }
	  }
	  try { // runs through queue
			if (!eventQueue.isEmpty()) { // if there are items in the queue
				if (!presented) { // if nothing is presented
			 eventQueue.get(0).execute(); // execute event
				}
			 }
			if (!presentQueue.isEmpty()) { // if there are items in the present queue
				
				if (presented) { // if something is presented
					
			 presentQueue.get(0).execute(); // execute a present
				}
			 }
		} catch (Exception e) { // runs exception
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	  for (Character c: characters) { // runs through characters
		  c.update(); // updates characters
	  }
	  
	  if(currentExamine!=null) { // if the examination exists
	
		  currentExamine.update(); // update the examination
	  }
 
  
 
  
  }
  void progress() { // progresses case
	  
	  benchmark=progress; // sets benchmark
	  progress++; // increases progress
  }
  void runExamine(int z) { // runs examination
	  
	  Main.currentCase.addEvent(new Event("ce",z)); // creates new examination event   
		queueSize++; // increases queue
  }
  
  void runFirstExamine(int z) { // runs first examination
	  
	  Main.currentCase.addEvent(new Event("firstCE",z)) ; // creates new first examination event  
		queueSize++; // increases queue
  }
  void insertD(String x,String y) { // inserts dialogue
	 
	  Main.currentCase.addEvent(new Event("d", x,y))  ; // creates dialogue event  
	queueSize++; // increases queue
	
	 }
  
  void insertData(String x) { // inserts data field
		 
	  Main.currentCase.addEvent(new Event("data", x,""))  ; // adds data field  
	queueSize++; // increases queue
	
	 }
  
  void toCourt() { // moves to court
		 
	  Main.currentCase.addEvent(new Event("court",0,0));  // adds event to go to court
	queueSize++; // increases queue
	
	 }
  
  void startCExamine(int i) { // starts cross-examination
	  
	  if(!Main.examineBlock && i == examined ) { // if there is no examine block and the examination has an id equal to the next id
	  Main.cExamine[Main.examineSlot] = new CrossExamination(); // set a new cross examination
	  
	  Main.examineBlock=true; // set the examine block to true
	  examined++; // increase the number of cross-examination
	  }
	  
  }
  

  
 void stopCExamine() { // stops cross-examination
	  
	 Main.examineSlot++; // increases examine slot to next examination
	  
	  Main.examineBlock=false; // sets examine block to false
	 
	  
  }

  void insertV(int y,String n) { // changes view
	  Main.currentCase.addEvent( new Event("v", y,n)) ; // inserts view event  
		queueSize++; // increases size of queue
		
		 }
  
  void enterArea(int y) { // enters area
	  Main.currentCase.addEvent(new Event("e",y)); // inserts enter event  
		queueSize++; // increases queue
		
		 }
  void cls() { // clears screen
	  Main.currentCase.addEvent(new Event("cls"));   // adds event to clear screen
		queueSize++; // increases size of queue
		
		 }
  void show(int z,int x,int y) { // shows object
	  Main.currentCase.addEvent( new Event("s",z,x,y)); // adds show event  
		queueSize++; // increases queue
		
		 }  
 
  
  void insertO(int y) { // inserts an objection
	  Main.currentCase.addEvent(new Event("o", y)) ; // adds objection event  
		queueSize++; // increases queue
		
		 }

  void insertR(String n,String x,String z, Boolean u,int i) { // insert item into record
	  Main.currentCase.addEvent( new Event("r",n,x,z,u,i))  ;   // adds record event
		queueSize++; // increases queue
		
		 }
  
  void setW(int y) { // sets witness
	  Main.currentCase.witness=y; // sets witness
		 }
public void clearSprites() { // clears sprites
	for (Character c:characters) { // runs through characters
		c.clear(); // clears characters
	}
	//System.out.println("SOVIET NAZIS!!!!!");
	
}
public void playAni(String string, String string2, int i, boolean b) { // plays animation
	 Main.currentCase.addEvent( new Event("playAni", string,string2,i,b))  ;   // adds animation event
	queueSize++; // increases size of queue
	
	 }

public void showAni(String string, String string2, int i, boolean b) { // shows animation
	 Main.currentCase.addEvent( new Event("showAni", string,string2,i,b))  ;   // adds animation event
	queueSize++; // increases size of queue
	
	 }
public void addEvent(Event event) { // adds event
	if (presented) { // if the case is presenting something
	Main.currentCase.presentQueue.add(event); // add event to present queue
	} else {
		Main.currentCase.eventQueue.add(event); // if there is nothing being presented, add event to event queue
	}
}
public void checkInteract() { // checks interaction with object

	
}
public RecordEntry findItem(String name) { // finds record entry
	for (RecordEntry r: this.evidence) { // runs through record entry
		
		if(r.name.equals(name)) return r; // returns an entry with the correct name
		
	}
	return null; // returns nothing if no entry matches name
}
public void switchBackToEventQueue() { // switches to event queue
	Main.currentCase.addEvent(new Event("switchBack")); // adds switch event to queue
	
}
public void removeO() { // removes objection
	 Main.currentCase.addEvent(new Event("ro")) ; // adds remove event to queue  
	
}

	
}
  
 

 
 
