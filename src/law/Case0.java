package law; // sets package

import java.io.IOException; // imports IOException

class Case0 extends StoryManager  { // opens class
	

 int currentArea=0; // sets area
 Case0() throws IOException  { // opens constructor
    super(0,"The Testing Case"); // constructs story manager
	Main.renderer.insert("nekocchiWitness",112); // inserts assets

	Main.renderer.insert("bluthundWitness",113);
    this.currentProsecutor="Adrasteia Rhamnousia";
	Main.renderer.insert("detention",201);
	Main.renderer.insert("area00",202);
    Main.renderer.insert("cory", 110);
    Main.renderer.insert("cory", 120);
 //Main.renderer.textQueue[0] = new DrawableText("Hello. Welcome to the the extremely early prototype of Ouron Forenz!",Color.WHITE,0,true,0,0);
 }

 void update () throws IOException { // update loop
	   inCourt=true;
	    //System.out.println ("flags[25]: " + flags[25]);
	 if (flags[25]==true&&!oneProc){ // checks if the investigation has been run and if it is the only thing running
		 oneProc=true; // ensures that nothing else will run in update
		
		 
		


	
		 startCExamine(0); // starts first cross-examination
		System.out.println(Main.cExamine);
		System.out.println(Main.examineSlot);
		Main.examineSlot=0;
		System.out.println(Main.cExamine[Main.examineSlot]);

		 // sets various statements of cross-examine
		 Main.cExamine[Main.examineSlot].add("Hello", "Nekocchi",  new String[] {"hello 1","hello 2","hello 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("Press this", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Present Badge", "Nekocchi",  new String[] {"hello jijs1","hello ksoks2","hello 3kdokd"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 2, "Ouran's Attorney's Badge",null,0);
		 Main.cExamine[Main.examineSlot].add("test1", "Nekocchi",  new String[] {"0","1","2","3","4","5"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("test2", "Nekocchi",  new String[] {"0","1","2","3","4","5"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("test3", "Nekocchi",  new String[] {"0","1","2","3","4","5"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("test4", "Nekocchi",  new String[] {"0","1","2","3","4","5"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 0, null,null,0);
		 
		 stopCExamine(); // ends first cross-examination
		 
		 startCExamine(1); // starts second cross-examination
		  // sets various statements of cross-examine
		 Main.cExamine[Main.examineSlot].add("Press this1", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this2", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this3", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this4", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this5", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this6", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 stopCExamine(); // ends second cross-examination
		 
		 startCExamine(2); // starts third cross-examination
		  // sets various statements of cross-examine
		 Main.cExamine[Main.examineSlot].add("Press this7", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this8", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this9", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this10", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this11", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this12", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 stopCExamine(); // ends third cross-examination
		 
		 
		 startCExamine(3); // starts fourth cross-examination
		 // sets various statements of cross-examine
		 Main.cExamine[Main.examineSlot].add("Press this13", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this14", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this15", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this16", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this17", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this18", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 stopCExamine(); // ends fourth cross-examination
		 
		 
		 
	

		   
		   

		/*    
		    insertD("Yeah B! I'm REAAAAAALL retarded!","Nekocchi?");
		 
		 insertD("I'm a dog.","Det. Pat Bluthund");
		 insertD("Yes.... Sadly. This is the game currently","Ouran");
		 insertD("The END!","Narrator");
		 
		 

			   insertV(0,null);
			
			   
			   

		  */
		    // inserts lines of dialogue and various changes of view
		    insertD("Court is in session for the murder of common human decency!","Judge Judge");
		    insertD("Is the defense ready?","Judge Judge");
		 
		   
				   insertV(1,(String)null);

		    
		    insertD("Yes, your honor!","Ouran Forenz");
		  
		  
				   insertV(0,(String)null);
				  
			 
			   insertD("Is the prosecution ready?","Judge Judge");
			  

		 
		    insertV(2,(String)null);
			
		   
		    insertD("Yes, your honor.","Prosecutor");
		    

		    insertV(0,(String)null);
		    insertD("Who is the accused?" ,"Judge Judge");
		    
		    insertV(3,new AnimData("Det. Pat. Bluthund","bluthundTalk",2,true));
		    //playAni("Det. Pat. Bluthund","bluthundWitness",0,false); // plays animation for Bluthund
		  // playAni( new AnimData("Det. Pat. Bluthund","bluthundTalk",4,true));
		    insertD("I smell a cat....","Det. Pat. Bluthund");
		    insertV(3,"Nekocchi");
		    playAni("Nekocchi","nekocchiWitness",0,false); // plays animation for Nekocchi
			  
		    insertD("MEEEEE, Ur HonoR!","???");
		    insertD("And who are you?","Judge Judge");
		    insertD("My name is Nekocchi","???");
		    insertD("NYA?","Nekocchi");
		    runFirstExamine(0); // runs start of cross-examination
		    runExamine(1); // runs cross-examination
		 
		    
		    insertV(0,(String)null);
		    insertD("My verdict is guilty.","Judge Judge");
		    insertD("And that was the end","God");
		    insertO(0);
		    insertV(2,(String)null);
		    insertD("???","Prosecutor");
		    insertV(0,(String)null);
		    insertD("???","Judge Judge");
		    insertV(1,(String)null);
		    removeO();
		    insertD("The defense insists on a proper trial before a verdict an be determined","Ouran Forenz");
		    insertV(0,(String)null);
		    insertD("Okay","Judge Judge");
		    runFirstExamine(2); // runs start of cross-examination
		    runExamine(3); // runs cross-examination

		    insertD("My verdict is still guilty.","Judge Judge");
		    
		    insertD("And that was the actual end","God");
		    
		  
	 }

	 if (flags[0]==false&&!oneProc){ // checks if investigation has already happened and if this is the only segment being updated
this.setUP();
   //flags[25]=true;
		// this.toCourt();
		 enterArea(0); // enters starting area
		
		 
		flags[0]=true; // sets flag to true

    block=false; // removes block
   
oneProc=true; // sets variable to true to stop repetition each click
  
 }
	 
	
  
	 
	super.update(); // updates StoryManager
	 
   
  
 }


@Override
void setUP() throws IOException {
	 characters.add(new Character("Nekocchi", 280, 0)); // adds character to game
System.out.println("Do the setup");
		


		
	 
	 locales[0] = new AreaZeroZero(0); // adds locations
	 locales[1] = new NekochiiBedroom(1);
	locales[2] = new DetentionThree(2);
	System.out.println(locales[1].name);
	 locales[0].linkPath(locales[1]); // links locations
	 locales[0].linkPath(locales[2]);
	
}

    
}

