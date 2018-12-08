package law;

import java.awt.Color;

class Dialogue {
 
 String text ;
 String speaker;
 int t;
 boolean proc = true;
 
 public Dialogue(int type) {
  t=type;
 }
 
 void insert(String texting, String s) {
  text = texting;
  speaker = s;
  
 }
 
 void play() {
	

   if(text!=null) {
	   Main.currentCase.inDialogue=true;
	   
    Main.currentCase.textBox=true;
   } else {
	   Main.currentCase.inDialogue=false;
	   
    Main.currentCase.textBox=false;
  
   }
   
   
   if (t==0) {
		
	   if(text!=null) { 
		   if (proc) {
		 	  Main.renderer.textQueue[10] = null;
		   Main.renderer.textQueue[10] = new DrawableText(text,Color.WHITE,0,true,0,0,false);
		   Main.renderer.textQueue[9] = new DrawableText(speaker,Color.WHITE,0,false,0,0,true);
		   proc=false;
		   } else {
		 	 if(Main.renderer.textQueue[10]!=null) {
		 		
		 	      
		    if(Main.currentKey!=null&&Main.gui.button==4) {
		    if(Main.keyInt==90) {
		     
		     	
		      if(Main.renderer.textQueue[10].frame<=Main.renderer.textQueue[10].current.length()-1) {
		     	
		     		if (Main.renderer.textQueue[10].time%2==0&&Main.renderer.textQueue[10].typewrite) {
		     			
		     			if(Main.renderer.textQueue[10].frame<Main.renderer.textQueue[10].current.length()) {
		     				if (Main.renderer.textQueue[10].frame+4<Main.renderer.textQueue[10].current.length())
		     				 Main.renderer.textQueue[10].frame+=4;
		     			}
		     		}
		     	
		     
		      }
		      else {
		     	
		     	 proc =true;
		     	 reset();
		     
		      }
		     } 
		    
		   }
		    
		   }
		  }
		  }   
   } else {

	   
	 //  for (int i=0; i<Main.renderer.pressQueue.length;i++) {
		// if (Main.renderer.pressQueue[i]!=null)  System.out.println(Main.renderer.pressQueue[i].text);  
	   //}
		
 if(text!=null) { 
	 System.out.println(Main.currentCase.currentExamine.statements[Main.currentCase.currentExamine.currentStatement].c+ " statement c");
	  if (proc) {
	  Main.renderer.pressQueue[10] = null;
  Main.renderer.pressQueue[10] = new DrawableText(text,Color.WHITE,0,true,0,0,false);
  Main.renderer.pressQueue[9] = new DrawableText(speaker,Color.WHITE,0,false,0,0,true);
  proc=false;
  } else {
	 if(Main.renderer.pressQueue[10]!=null) {
		
	      
   if(Main.currentKey!=null&&Main.gui.button==4) {
   if(Main.keyInt==90) {
	   
	   System.out.println("yee");
    
    	
     if(Main.renderer.pressQueue[10].frame<=Main.renderer.pressQueue[10].current.length()-1) {
    	 System.out.println("EFF ME");
    		if (Main.renderer.pressQueue[10].time%2==0&&Main.renderer.pressQueue[10].typewrite) {
    			 System.out.println("EFF ME 2");
    			if(Main.renderer.pressQueue[10].frame<Main.renderer.pressQueue[10].current.length()) {
    				if (Main.renderer.pressQueue[10].frame<Main.renderer.pressQueue[10].current.length())
    					
    				 Main.renderer.pressQueue[10].frame+=4;
    			
    			}
    		}
    	
    
     }
     else {
    	
    	 proc =true;
    	 reset();
    
     }
    } 
   
  }
   
  }
 }
 } 
   }
 }
 void start() {
 reset();

 
 }
 void reset() {
   
  text = null;
  speaker = null;
  if (t==0) {
  Main.currentCase.inDialogue=false;
    Main.renderer.textQueue[10] =null;
     Main.renderer.textQueue[9] = null;
  } else {
	  
	  System.out.println("HEY!!!!SSS");
	  Main.currentCase.inDialogue=false;
	    Main.renderer.pressQueue[10] =null;
	     Main.renderer.pressQueue[9] = null;
	     
  }
  
  
  
  
 }
 
}