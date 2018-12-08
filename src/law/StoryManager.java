package law;

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
 Event[] eventQueue = new Event[1000000]; ;
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
 
 public StoryManager() throws IOException  {

	 court= new Court();
	 somewhere=false;
  
  
  
 }
 
  void update() throws IOException {

	  try {
			if (eventQueue[queueIndex]!=null) {
			 eventQueue[queueIndex].execute();
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	  
	  Main.currentCase.eventQueue[queueSize] = new Event("ce",z);  
		queueSize++;
  }
  void insertD(String x,String y) {
	 
	Main.currentCase.eventQueue[queueSize] = new Event("d", x,y);  
	queueSize++;
	
	 }
  
  void toCourt() {
		 
	Main.currentCase.eventQueue[queueSize] = new Event("court",0,0);  
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
		Main.currentCase.eventQueue[queueSize] = new Event("v", y,n);  
		queueSize++;
		
		 }
  
  void enterArea(int y) {
		Main.currentCase.eventQueue[queueSize] = new Event("e",y);  
		queueSize++;
		
		 }
  
  void show(int z,int x,int y) {
		Main.currentCase.eventQueue[queueSize] = new Event("s",z,x,y);  
		queueSize++;
		
		 }  
 
  
  void insertO(int y) {
		Main.currentCase.eventQueue[queueSize] = new Event("o", y);  
		queueSize++;
		
		 }

  void insertR(String n,String x,String z, Boolean u,int i) {
		Main.currentCase.eventQueue[queueSize] = new Event("r",n,x,z,u,i);  
		queueSize++;
		
		 }
  
  void setW(int y) {
	  Main.currentCase.witness=y;
		 }
  
 

 
 
 
}