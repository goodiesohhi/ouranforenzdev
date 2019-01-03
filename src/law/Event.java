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

		if( (!Main.currentCase.working&& !Main.currentCase.inDialogue&& !Main.currentCase.inExamine)||(!Main.currentCase.working&& !Main.currentCase.inDialogue&& Main.currentCase.inExamine&&Main.currentCase.presented)) {
			
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
	if (command=="ce") {
	
		Main.currentCase.currentExamine=Main.cExamine[z];
		Main.currentCase.inExamine=true;
		//System.out.println("Yes");
	 
	}	 else
	if (command=="d") {
		Main.dialogue.insert(x, y);
		
	}	else 
		
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
		
		if (Main.currentCase.findItem(d)==null)
		Main.currentCase.evidence.add(new RecordEntry(d,x, u,y,i));
	}
}
	
	else if (command=="o") {
		if( z==0) { 
			Main.renderer.queue[19]= new Drawable(19, 0,0,1,10000,19);
	
		}
	
		
		
	}
	
	
			if (Main.currentCase.presented) Main.currentCase.presentQueue.remove(0);
				else
				Main.currentCase.eventQueue.remove(0);
		
	  Main.currentCase.working=false;
	}
	}
}
	
	
	
