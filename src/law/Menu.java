package law;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

class Menu {
	Drawable[] queue; // creates queue to draw
	DrawableText[] textQueue; // creates queue of text
	BufferedImage backing = ImageIO.read( Main.class.getResource("/resources/backing.png")); // holds image for menu backing

	int button =0;
	int menu=0;
	public boolean entered;
	
	Menu () throws IOException {
		
		//Main.renderer.insert("menuScreen", 0);
	}
	public void cls() {
		Main.renderer.textQueue[0]=null;
		Main.renderer.textQueue[1]=null;

		Main.renderer.textQueue[2]=null;
		Main.renderer.textQueue[3]=null;
		Main.renderer.textQueue[4]=null;



		}
	public void update() throws Exception {
entered=true;
Main.renderer.queue[1]= new Drawable(backing,200-165,120	-35,1,0,0); // creates the backing for the gui
		if (menu==0) {
			if (saveExists()) {
			Main.renderer.queue[0] = new  Drawable(0,0,0,1,0,1);
			//makes buttons
			if (button==0)Main.renderer.textQueue[1] = new DrawableText("New Game",Color.GREEN,30.0f,true,0,0,false); 
			else Main.renderer.textQueue[1] = new DrawableText("New Game",Color.GRAY,30.0f,true,0,0,false); 
			if (button==1)Main.renderer.textQueue[0] = new DrawableText("Continue",Color.GREEN,30.0f,true,0,0,false); 
			else Main.renderer.textQueue[0] = new DrawableText("Continue",Color.GRAY,30.0f,true,0,0,false); 
			if (button==2)Main.renderer.textQueue[2] = new DrawableText("Case Select",Color.GREEN,30.0f,true,0,0,false); 
			else Main.renderer.textQueue[2] = new DrawableText("Case Select",Color.GRAY,30.0f,true,0,0,false); 
		
			Main.renderer.textQueue[1].x=400; // sets the x value
			Main.renderer.textQueue[1].y=300;
			
			Main.renderer.textQueue[0].x=400; // sets the x value
			Main.renderer.textQueue[0].y=400;
			
			Main.renderer.textQueue[2].x=400; // sets the x value
			Main.renderer.textQueue[2].y=500;
			
		      
						  if(Main.currentKey!=null) { // if a key is being pressed
						
							   if(Main.keyInt==38) { // if the key is up
							   if (button>0) button--;
							   } else if (Main.keyInt==40) { // if the key is down
								   if (button<2) button++;
							   }else
								   if(Main.keyInt==KeyEvent.VK_Z) { // if z is pressed
									if (button==0) {
										 Main.renderer.queue = new Drawable[40]; // reset the queue
										 Main.renderer. textQueue = new DrawableText[50]; // reset the text queue
										Main.currentCase= Main.caseList.get(1);
										Main.switchState(2);
									}
									else if (button==2) {
										button=0;
										menu=2;
									}
									else if (button==1) {
										 Main.renderer.queue = new Drawable[40]; // reset the queue
										 Main.renderer. textQueue = new DrawableText[50]; // reset the text queue
									Main.game.loadGame();
									}
								   } 
								   else  if(Main.keyInt==KeyEvent.VK_X) { // if x is pressed
									 
									
					   				   
				   }
						  }
						  } else {
							  
								Main.renderer.queue[0] = new  Drawable(0,0,0,1,0,1);
								//makes buttons
								if (button==0)Main.renderer.textQueue[0] = new DrawableText("New Game",Color.GREEN,30.0f,true,0,0,false); 
								else Main.renderer.textQueue[0] = new DrawableText("New Game",Color.GRAY,30.0f,true,0,0,false); 
					
								if (button==1)Main.renderer.textQueue[1] = new DrawableText("Case Select",Color.GREEN,30.0f,true,0,0,false); 
								else Main.renderer.textQueue[1] = new DrawableText("Case Select",Color.GRAY,30.0f,true,0,0,false); 
							
								Main.renderer.textQueue[0].x=400; // sets the x value
								Main.renderer.textQueue[0].y=300;
								
								Main.renderer.textQueue[1].x=400; // sets the x value
								Main.renderer.textQueue[1].y=400;
							
								
							      
											  if(Main.currentKey!=null) { // if a key is being pressed
											
												   if(Main.keyInt==38) { // if the key is up
												   if (button>0) button--;
												   } else if (Main.keyInt==40) { // if the key is down
													   if (button<1) button++;
												   }else
													   if(Main.keyInt==KeyEvent.VK_Z) { // if z is pressed
														if (button==0) {
															 Main.renderer.queue = new Drawable[40]; // reset the queue
															 Main.renderer. textQueue = new DrawableText[50]; // reset the text queue
															Main.currentCase= Main.caseList.get(1);
															Main.switchState(2);
														}
														else if (button==1) {
															button=0;
															menu=2;
														}
														else if (button==2) {
														Main.game.loadGame();
														}
													   } 
													   else  if(Main.keyInt==KeyEvent.VK_X) { // if x is pressed
														 
														
										   				   
									   }
											  }
							  
						  }
		} else if (menu==2) {
			int i=0;
			for (StoryManager c: Main.caseList) {
			if (button==i)Main.renderer.textQueue[i] = new DrawableText(c.caseName,Color.GREEN,30.0f,true,0,0,false); 
			else Main.renderer.textQueue[i] = new DrawableText(c.caseName,Color.GRAY,30.0f,true,0,0,false); 
			Main.renderer.textQueue[i].x=400; // sets the x value
			Main.renderer.textQueue[i].y=300+100*i;
			i++;
			}
			  if(Main.currentKey!=null) { // if a key is being pressed
					
				   if(Main.keyInt==38) { // if the key is up
				   if (button>0) button--;
				   } else if (Main.keyInt==40) { // if the key is down
					   if (button<Main.caseList.size()-1) button++;
				   }else
					   if(Main.keyInt==KeyEvent.VK_Z) { // if z is pressed
						if (button>-1) {
							 Main.renderer.queue = new Drawable[40]; // reset the queue
							 Main.renderer. textQueue = new DrawableText[50]; // reset the text queue
							Main.currentCase= Main.caseList.get(button);
							Main.switchState(2);
						}
					   }
					   else  if(Main.keyInt==KeyEvent.VK_X) {
						   cls();
						   menu=0;// if x is pressed
						 cls();
						
		   				   
	   }
			  }
			  
		}
		
	}
	private boolean saveExists() throws IOException {
		
		if (!new File("save.osd").exists()) return false;
		String line =null;
   	
   	  FileReader fileReader = 
                 new FileReader("save.osd");

             // Always wrap FileReader in BufferedReader.
             BufferedReader bufferedReader = 
                 new BufferedReader(fileReader);

             while((line = bufferedReader.readLine()) != null) {
             if (line.length()>0) return true;
             }
		return false;
	}
	
	
	
}