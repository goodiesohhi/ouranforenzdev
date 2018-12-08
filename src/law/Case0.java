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
	   
	    


	 if (block&&flags[0]==false&&!oneProc){

		 insertR( "Ouran's Attorney's Badge","badge","My badge", false,0);

		 insertR( "Placeholder1","badge","ssjhshjshjs", false,0);

		 insertR( "Placeholder2","badge","hello", false,0);
	
		    
		    
		 
		 locales[0] = new AreaZeroZero();
		 locales[1] = new NekochiiBedroom();
		
		 locales[0].linkPath(locales[1]);
     /*   
		 
		 enterArea(0);
		
		 
		 inCourt=true;
		 
		 
	//Main.renderer.queue[0] = new Drawable(10,0,0,1);

 //insertD("Hello. Welcome to the the extremely early prototype of Ouron Forenz!", "Ouran Forenz");
 

 //insertD("This is a test for text display","oTHER");
 
	 
   
   
  
   
 //insertD("Continue testing","someone else");
 insertD("I'm retarded!","Nekocchi");
 /*startCExamine(0);
 
 Main.cExamine[Main.examineSlot].add("Hello", "Nekocchi",  new String[] {"hello 1","hello 2","hello 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 0, 0);
 Main.cExamine[Main.examineSlot].add("Press this", "Nekocchi",  new String[] {"yellow 1","red  2","yikes 3"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 1, 0);
 Main.cExamine[Main.examineSlot].add("Present Item 50. Not rn not implemented", "Nekocchi",  new String[] {"hello jijs1","hello ksoks2","hello 3kdokd"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi"} , 0, 0);
 
 stopCExamine();
 
 
 
 runExamine(0);

   
   

    
    insertD("Yeah B! I'm REAAAAAALL retarded!","Nekocchi?");
 
 insertD("I'm a dog.","Det. Pat Bluthund");
 insertD("Yes.... Sadly. This is the game currently","Ouran");
 insertD("The END!","Narrator");
 
 

	   insertV(0,0);
	  
	   
	   

  
    
    insertD("Court is in session for the murder of common human decency!","Judge Judge");
    insertD("Is the defense ready?","Judge Judge");
 
   
   
		   insertV(1,0);

    
    insertD("Yes, your honor!","Ouran Forenz");
  
  
		   insertV(0,0);
		  
	 
	   insertD("Is the prosecution ready?","Judge Judge");
	  

 
    insertV(2,0);
	
   
    insertD("Yes, your honor.","Prosecutor");
    

    insertV(0,0);
    insertD("Who is the accused?" ,"Judge Judge");
    
    insertV(3,113);
    insertD("I smell a cat....","Det. Pat. Bluthund");
    insertV(3,112);
    insertD("MEEEEE, Ur HonoR!","???");
    insertD("And who are you?","Judge Judge");
    insertD("My name is Nekocchi","???");
    insertD("NYA?","Nekocchi");
    insertV(0,0);
    insertD("My verdict is guilty.","Judge Judge");
    insertD("And that was the end","God");
    insertO(0);
    insertV(2,0);
    insertD("???","Prosecutor");
    insertV(0,0);
    insertD("???","Judge Judge");
    insertV(1,0);
    insertD("The defense insists on a proper trial before a verdict an be determined","Ouran Forenz");
    insertV(0,0);
    insertD("Objection Overruled","Judge Judge");
    insertD("And that was the actual end","God");
    
   */
    enterArea(0);
    

    flags[0]=true;
    block=false;
   
oneProc=true;
  
 }
	 
	 if (flags[0]==true&&!oneProc) {
		 
		 
	 insertD("Hello","O F");
		 
		 oneProc=true;
	 }
  
	 
	super.update();
	 
   
  
 }
    
}

