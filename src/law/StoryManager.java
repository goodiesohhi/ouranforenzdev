package law;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;



class StoryManager {
	ArrayList<Character> characters = new ArrayList<Character>();
	Location currentLocation;
    boolean invest;
	ArrayList<RecordEntry> profiles = new ArrayList<RecordEntry>();
	int examined=0;
	ArrayList<RecordEntry>evidence = new ArrayList<RecordEntry>();
	 Location[] locales = new Location[40]; 
	boolean somewhere;
	boolean[] flags = new boolean[100];
	boolean inExamine = false;
	boolean objected=false;
	Court court;
 ClassLoader classLoader = getClass().getClassLoader();
 boolean textBox=true;
 boolean start =true;
 boolean block = true;
 ArrayList<Event>eventQueue = new ArrayList<Event>(); ;
 boolean working;
 int queueIndex = 0;
 int queueSize = 0;
 int witness = 0;
 CrossExamination currentExamine;
 //ints to track progression and regulate flow of events
 int benchmark =0;
 int progress = 0;
 boolean oneProc;
boolean  inCourt=true;
 
 //mode novel = 0 invest = 1 court =2 
 int mode = 0;
 //phase
 //novel only has phase 0.
 // invest has 0=talk 1=click invest thing 2= move
 // court has 0=talk 1= testimony 2= crossexamine 3= special events 4=flavour shots
 int phase = 0;
 
 boolean inDialogue = false;
public boolean pressed = false;
 public Character getCharacter(String x) {
	 
	 int len=characters.size();
	 for(int i=0; i<len; i++) {
	     if (characters.get(i).name.equals(x)) {
	        return characters.get(i);
	     }
	 }
	 return null;
 }
 public StoryManager() throws IOException  {

	 court= new Court();
	 somewhere=false;
  
  
  
 }
 
  void update() throws IOException {
System.out.println(eventQueue.toString());
	  try {
			if (!eventQueue.isEmpty()) {
			 eventQueue.get(0).execute();
			 
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	  for (Character c: characters) {
		  c.update();
	  }
	  
	  if(currentExamine!=null) {
	
		  currentExamine.update();
	  }
 
  
 
  
  }
  void progress() {
	  
	  benchmark=progress;
	  progress++;
  }
  void runExamine(int z) {
	  
	  Main.currentCase.eventQueue.add(new Event("ce",z)) ;  
		queueSize++;
  }
  void insertD(String x,String y) {
	 
	  Main.currentCase.eventQueue.add(new Event("d", x,y))  ;  
	queueSize++;
	
	 }
  
  void toCourt() {
		 
	  Main.currentCase.eventQueue.add(new Event("court",0,0));  
	queueSize++;
	
	 }
  
  void startCExamine(int i) {
	  
	  if(!Main.examineBlock && i == examined ) {
	  Main.cExamine[Main.examineSlot] = new CrossExamination();
	  
	  Main.examineBlock=true;
	  examined++;
	  }
	  
  }
  
 void stopCExamine() {
	  
	 Main.examineSlot++;
	  
	  Main.examineBlock=false;
	 
	  
  }

  void insertV(int y,int n) {
	  Main.currentCase.eventQueue.add( new Event("v", y,n)) ;  
		queueSize++;
		
		 }
  
  void enterArea(int y) {
	  Main.currentCase.eventQueue.add(new Event("e",y));  
		queueSize++;
		
		 }
  
  void show(int z,int x,int y) {
	  Main.currentCase.eventQueue.add( new Event("s",z,x,y));  
		queueSize++;
		
		 }  
 
  
  void insertO(int y) {
	  Main.currentCase.eventQueue.add(new Event("o", y)) ;  
		queueSize++;
		
		 }

  void insertR(String n,String x,String z, Boolean u,int i) {
	  Main.currentCase.eventQueue.add( new Event("r",n,x,z,u,i))  ;  
		queueSize++;
		
		 }
  
  void setW(int y) {
	  Main.currentCase.witness=y;
		 }
public void clearSprites() {
	for (Character c:characters) {
		c.clear();
	}
	System.out.println("SOVIET NAZIS!!!!!");
	Main.renderer.queue=new Drawable[95];
}
public void playAni(String string, String string2, int i, boolean b) {
	 Main.currentCase.eventQueue.add( new Event("playAni", string,string2,i,b))  ;  
	queueSize++;
	
	 }
public void checkInteract() {

	
}
public RecordEntry findItem(String name) {
	for (RecordEntry r: this.evidence) {
		
		if(r.name.equals(name)) return r;
		
	}
	return null;
}

	
}
  
 

 
 
