package law;

import java.io.IOException;

class Case0 extends StoryManager  {
	

 int currentArea=0;
 Case0() throws IOException  {
    super();
	Main.renderer.insert("nekocchiWitness",112);

	Main.renderer.insert("bluthundWitness",113);
    
	Main.renderer.insert("detention",201);
	Main.renderer.insert("area00",202);
    Main.renderer.insert("cory", 110);
    Main.renderer.insert("cory", 120);
 //Main.renderer.textQueue[0] = new DrawableText("Hello. Welcome to the the extremely early prototype of Ouron Forenz!",Color.WHITE,0,true,0,0);
 }

 void update () throws IOException {
	   
	    //System.out.println ("flags[25]: " + flags[25]);
	 if (flags[25]==true&&!oneProc){
		 oneProc=true;
		
		 
		 inCourt=true;


	
		 startCExamine(0);
		 
		 
		 Main.cExamine[Main.examineSlot].add("Hello", "Nekocchi",  new String[] {"hello 1","hello 2","hello 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("Press this", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Present Badge", "Nekocchi",  new String[] {"hello jijs1","hello ksoks2","hello 3kdokd"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 2, "Ouran's Attorney's Badge",null,0);
		 Main.cExamine[Main.examineSlot].add("test1", "Nekocchi",  new String[] {"0","1","2","3","4","5"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("test2", "Nekocchi",  new String[] {"0","1","2","3","4","5"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("test3", "Nekocchi",  new String[] {"0","1","2","3","4","5"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("test4", "Nekocchi",  new String[] {"0","1","2","3","4","5"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 0, null,null,0);
		 
		 stopCExamine();
		 
		 startCExamine(1);
		 
		 Main.cExamine[Main.examineSlot].add("Press this1", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this2", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this3", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this4", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this5", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this6", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 stopCExamine();
		 
		 startCExamine(2);
		 
		 Main.cExamine[Main.examineSlot].add("Press this7", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this8", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this9", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this10", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this11", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this12", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 stopCExamine();
		 
		 
		 startCExamine(3);
		 
		 Main.cExamine[Main.examineSlot].add("Press this13", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this14", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this15", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this16", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this17", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Press this18", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, null,null,0);
		 stopCExamine();
		 
		 
		 
	

		   
		   

		/*    
		    insertD("Yeah B! I'm REAAAAAALL retarded!","Nekocchi?");
		 
		 insertD("I'm a dog.","Det. Pat Bluthund");
		 insertD("Yes.... Sadly. This is the game currently","Ouran");
		 insertD("The END!","Narrator");
		 
		 

			   insertV(0,null);
			
			   
			   

		  */
		    
		    insertD("Court is in session for the murder of common human decency!","Judge Judge");
		    insertD("Is the defense ready?","Judge Judge");
		 
		   
		   
				   insertV(1,null);

		    
		    insertD("Yes, your honor!","Ouran Forenz");
		  
		  
				   insertV(0,null);
				  
			 
			   insertD("Is the prosecution ready?","Judge Judge");
			  

		 
		    insertV(2,null);
			
		   
		    insertD("Yes, your honor.","Prosecutor");
		    

		    insertV(0,null);
		    insertD("Who is the accused?" ,"Judge Judge");
		    
		    insertV(3,"Det. Pat. Bluthund");
		    playAni("Det. Pat. Bluthund","bluthundWitness",0,false);

		    insertD("I smell a cat....","Det. Pat. Bluthund");
		    insertV(3,"Nekocchi");
		    playAni("Nekocchi","nekocchiWitness",0,false);
			  
		    insertD("MEEEEE, Ur HonoR!","???");
		    insertD("And who are you?","Judge Judge");
		    insertD("My name is Nekocchi","???");
		    insertD("NYA?","Nekocchi");
		    runFirstExamine(0);
		    runExamine(1);
		 
		    
		    insertV(0,null);
		    insertD("My verdict is guilty.","Judge Judge");
		    insertD("And that was the end","God");
		    insertO(0);
		    insertV(2,null);
		    insertD("???","Prosecutor");
		    insertV(0,null);
		    insertD("???","Judge Judge");
		    insertV(1,null);
		    removeO();
		    insertD("The defense insists on a proper trial before a verdict an be determined","Ouran Forenz");
		    insertV(0,null);
		    insertD("Okay","Judge Judge");
		    
		    
		    runFirstExamine(2);
		    runExamine(3);
		    insertD("My verdict is still guilty.","Judge Judge");
		    
		    insertD("And that was the actual end","God");
		    
		  
	 }

	 if (flags[0]==false&&!oneProc){
		 characters.add(new Character("Nekocchi", 280, 0));

	


		
		 
		 locales[0] = new AreaZeroZero();
		 locales[1] = new NekochiiBedroom();
		locales[2] = new DetentionThree();
		 locales[0].linkPath(locales[1]);
		 locales[0].linkPath(locales[2]);
   //flags[25]=true;
		// this.toCourt();
		 enterArea(0);
		
		 
		flags[0]=true;

    block=false;
   
oneProc=true;
  
 }
	 
	
  
	 
	super.update();
	 
   
  
 }

    
}

