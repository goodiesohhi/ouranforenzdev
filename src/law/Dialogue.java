package law; // selects package

import java.awt.Color; // imports colours

class Dialogue { // opens class
 
 String text ; // holds text of dialogue
 String speaker; // holds speaker of dialogue
 int t; // holds the type of dialogue
 boolean dataField; // chooses if there is a data field or not
 
 boolean proc = true; // checks if there is already dialogue running
 
 public Dialogue(int type) { // constructs dialogue by passing type
  t=type;
 }
 
 void insert(String texting, String s) { // inserts dialogue by passing strings for text and speaker
  text = texting;
  speaker = s;
  dataField=false;
  System.out.println("DIA");
  
 }
 void insert(String texting, String s, boolean spec) { // inserts dialogue by passing strings for text and speaker, and whether there is a data field
	  text = texting;
	  speaker = s;
	  dataField=spec;
	  System.out.println("DIA");
	  
	  
	 }
 
 void play() { // plays dialogue
	if (Main.currentCase.inExamine&&!Main.currentCase.pressed) { // if it is in an examination and nothing is pressed, the gui removes itself from drawing
		Main.gui.inAction=false;
		  System.out.println("DIA1");
		  
	}

   if(text!=null) { // checks if the text exists
	   Main.currentCase.inDialogue=true; // puts case in dialogue
	   System.out.println("DIA2");
	   
	   if (dataField) { // checks if the text is a field
		   Main.currentCase.dataText=true; // sets data to true
	   } else {
		   Main.currentCase.dataText=false; // otherwise, sets data to false
	   }
	   
		   
    Main.currentCase.textBox=true; // opens up text box
   } else {
	   Main.currentCase.inDialogue=false; // if text doesn't exist, the case is not in dialogue
	   
    Main.currentCase.textBox=false; // there is no text box if the text doesn't exist
  
   }
   
 
   
   if (t==0) {// if the type of text is 0
		
	   if(text!=null) {  // if the text exists
		  
		   if (proc) { // if this is the only text running
		 	  Main.renderer.textQueue[10] = null; // the previous text disappears
		   Main.renderer.textQueue[10] = new DrawableText(text,Color.WHITE,0,true,0,0,false); // the new text is drawn
		   Main.renderer.textQueue[9] = new DrawableText(speaker,Color.WHITE,0,false,0,0,true); // the new speaker is drawn
		   proc=false; // ensures only one piece of text is run
		   } else { // chcks if other text is running
		 	 if(Main.renderer.textQueue[10]!=null) { // checks if there is no other text
		 		
		 	      
		    if(Main.currentKey!=null&&Main.gui.button==4) { // checks if no key is pressed
		    if(Main.keyInt==90) { // checks if Z is pressed
		    	CrossExamination.statementSentinel=false; // sets the statement block to false
		    	
		     
		     	
		      if(Main.renderer.textQueue[10].frame<=Main.renderer.textQueue[10].current.length()-1) { // checks if the text frame is less than the current length of the text
		     	
		     		if (Main.renderer.textQueue[10].time%2==0&&Main.renderer.textQueue[10].typewrite) { // every second frame a letter writes
		     			
		     			if(Main.renderer.textQueue[10].frame<Main.renderer.textQueue[10].current.length()) { // if the frame is less than the current length
		     				if (Main.renderer.textQueue[10].frame+4<Main.renderer.textQueue[10].current.length()) // checks if the frame 4 frames ahead is still less than the length.
		     				 Main.renderer.textQueue[10].frame+=4; // increases the frame by 4
		     			}
		     		}
		     	
		     
		      }
		      else { // if the text frame is over the length
		     	
		     	 proc =true; // ensures this only runs once
		     	 reset(); // resets text box
		     
		      }
		     } 
		    
		   }
		    
		   }
		  }
		  }   
   } else { // runs if text is not 0

	   
	 //  for (int i=0; i<Main.renderer.pressQueue.length;i++) {
		// if (Main.renderer.pressQueue[i]!=null)  //System.out.println(Main.renderer.pressQueue[i].text);  
	   //}
		
 if(text!=null) { // if the text is not null
	
	  if (proc) { // ensures that the text is only run once
	  Main.renderer.pressQueue[10] = null; // removes previous text
  Main.renderer.pressQueue[10] = new DrawableText(text,Color.WHITE,0,true,0,0,false); // draws text
  Main.renderer.pressQueue[9] = new DrawableText(speaker,Color.WHITE,0,false,0,0,true); // draws speaker
  proc=false; // ensures that only one piece of text is running
  } else { // if text is already running
	 if(Main.renderer.pressQueue[10]!=null) { // checks if there is text
		
	      
   if(Main.currentKey!=null&&Main.gui.button==4) { // checks if there is no key currently running
   if(Main.keyInt==90) { // checks if the z button is pressed
	   
	   //System.out.println("yee");
    
	   CrossExamination.sentinel=false; // sets the sentinel statement to false
	  
     if(Main.renderer.pressQueue[10].frame<=Main.renderer.pressQueue[10].current.length()-1) { // checks if the frame is less than the length of the press queue
    	 //System.out.println("EFF ME");
    		if (Main.renderer.pressQueue[10].time%2==0&&Main.renderer.pressQueue[10].typewrite) { // checks if the frame is even and the renderer is drawing
    			 //System.out.println("EFF ME 2");
    			if(Main.renderer.pressQueue[10].frame<Main.renderer.pressQueue[10].current.length()) { // checks if the frame is less than the length of the press queue
    				if (Main.renderer.pressQueue[10].frame<Main.renderer.pressQueue[10].current.length()) // checks if the frame is less than the length
    					
    				 Main.renderer.pressQueue[10].frame+=4; // increases the frame by 4
    			
    			}
    		}
    	
    
     }
     else { // checks if the frame is greater than the length
    	
    	 proc =true; // sets proc to true
    	 reset(); // resets dialogue
    
     }
    } 
   
  }
   
  }
 }
 } 
   }
 }
 void start() { // starts dialogue
 reset(); // resets dialogue

 
 }
 void reset() { // resets dialogue
	 proc =true; // sets proc to true
  text = null; // removes text
  speaker = null; // removes speaker
  
  if (t==0) { // if the text type is 0
  Main.currentCase.inDialogue=false; // sets the case to not be in dialogue
    Main.renderer.textQueue[10] =null; // sets the texts to null
     Main.renderer.textQueue[9] = null; // sets the speaker to null
  } else { // if the text type is not 0
	  
	  //System.out.println("HEY!!!!SSS");
	  Main.currentCase.inDialogue=false; // sets the case to not be in dialogue
	    Main.renderer.pressQueue[10] =null; // sets the text to null
	     Main.renderer.pressQueue[9] = null; // sets the speaker to null
	     
  }
  
  
  
  
 }
 
}