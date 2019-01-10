package law;

import java.io.IOException;
import java.util.ArrayList;

class Event {
	
	String command;
	
	Object[] list;
	String x;
	String y;
	int z;
	int v;
	int n;
	int i;
	String d;
	Boolean u;
	
	public Event(String event, int zz ) {
	
		z=zz;
		command = event;
	}

	public Event(String event, int zz, int nn ) {
	
		z=zz;
		n=nn;
		command = event;
	}
	
	public Event(String event, int zz, int vv,int nn ) {
		
		z=zz;
		n=nn;
		v=vv;
		command = event;
	}
	public Event(String event, String xz, String yz ) {
		
		x=xz;
		y=yz;
		command = event;
	}
	
	public Event(String string, String name,String x2, String z2, Boolean u2, int i2) {
		command=string;
		d=name;
		x=x2;
		y=z2;
		u=u2;
		i=i2;
	}

	public Event(String string, String string2, String string22, int i2, boolean b) {
		command = string;
		d=string2;
		x=string22;
		i=i2;
		u=b;
	}

	public Event(String string) {
		command = string;
	}

	public Event(String string, int y2, String n2) {
		command=string;
		z=y2;
		x=n2;
		
	}

	//&&Main.currentCase.objected==false
	void execute() throws IOException {
		
		

		if( (!Main.currentCase.working&& !Main.currentCase.inDialogue&& !Main.currentCase.inExamine&& !Main.currentCase.beginExamine)||(!Main.currentCase.working&& !Main.currentCase.inDialogue&& Main.currentCase.inExamine&&Main.currentCase.presented)) {
			
			if (Main.currentCase.presented)System.out.println(this.command+" command in PresenQueue has been executed"); else 
				System.out.println(this.command+" command in eventQueue has been executed");
			Main.currentCase.working=true;
			if (command=="court") {
				
				Main.currentCase.currentLocation=null;
				Main.inCourt=true;
				Main.currentCase.inCourt=true;
				Main.currentCase.oneProc=false;
				Main.gui.menu=-1;
				 Main.gui.queue = new Drawable[40];
				  Main.gui.textQueue = new DrawableText[50];
				  Main.currentCase.clearSprites();
				Main.currentCase.insertV(0,null);
				
				
			 
			} else if (command=="cls") {
				 Main.currentCase.clearSprites();
			}
			
			else if (command=="playAni") {
				Main.currentCase.clearSprites();
				Main.currentCase.getCharacter(d).play(x, i, u);
			
			} else if (command=="switchBack") {
				Main.currentCase.presentQueue= new ArrayList<Event>();
			 Main.currentCase.presented=false;
				
			}
			
			else	 
	if (command=="firstCE") {
	
		Main.currentCase.currentExamineQueue=Main.cExamine[z];
		Main.currentCase.beginExamine=true;
		Main.currentCase.working=true;
		Main.gui.menu=69;
		//System.out.println("Yes");
	 
	}	else	 
		if (command=="ce") {
			
			Main.currentCase.currentExamine=Main.cExamine[z];
			Main.currentCase.inExamine=true;
	
			//System.out.println("Yes");
		 
		}	
		else
	if (command=="d") {
		Main.dialogue.insert(x, y);
		
	}	
	
	else
	if (command=="data") {
		Main.dialogue.insert(x, y,true);
		
	}	
	else 
		
	if (command=="v") {
		
		
		   Main.currentCase.court.switchview(z,x);
		
	} else if (command=="e") {
		 Main.currentCase.locales[z].enter();
	}
	
	
else if (command=="s") {
	Main.renderer.queue[1]= new Drawable(z, v,n,1,0,1);
}
else if (command=="r") {
	if(u) {
		
	Main.currentCase.profiles.add(new RecordEntry(d,x, u,y,i));
	} else {
		RecordEntry r = Main.currentCase.findItem(d);
		if (r==null) { 
		Main.currentCase.evidence.add(new RecordEntry(d,x, u,y,i));
		}
		else  {
			int index = Main.currentCase.evidence.indexOf(r);
			Main.currentCase.evidence.remove(r);
			r = new RecordEntry(d,x, u,y,i);
			Main.currentCase.evidence.add(index, r);
			System.out.println("r is: "+r);
		}
	}
} else if (command=="ro") {
		
	Main.currentCase.court.defObject= new Character("Defense Objection",-200,135);
	Main.currentCase.court.prosObject=new Character("Prosecution Objection",0,200);
	Main.currentCase.motionTrack=null;
	Main.currentCase.court.characters = new ArrayList<Character>();
	Main.currentCase.court.characters.add(	Main.currentCase.court.defObject);
	
	Main.currentCase.court.characters.add(	Main.currentCase.court.prosObject);
	System.out.println("clear object");
	
}
	
	else if (command=="o") {
		if( z==0) { 
			Main.gui.menu=69;
			Main.currentCase.motionTrack = 	Main.currentCase.court.defObject;
	Main.currentCase.motionTrack.moveBy(400, 0,20);
	Main.currentCase.motionTrack.play("objection", 0, false);

		}
		else if (z==1) {
			
		}
	
		
		
	}
	
	
			if (Main.currentCase.presented) Main.currentCase.presentQueue.remove(0);
				else
				Main.currentCase.eventQueue.remove(0);
		
	  if((!command.equals("playAni")&&!command.equals("firstCE"))||(command.equals("playAni")&&!u))Main.currentCase.working=false;
	  if(command.equals("o")) {
		  System.out.println("O COMMAND");
		  Main.currentCase.working=true;
		  System.out.println(Main.currentCase.working);
	  }
	}
	}
}
	
	
	
