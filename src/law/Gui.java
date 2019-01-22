package law; // selects package

import java.awt.Color; // imports color
import java.awt.event.KeyEvent; // imports usage of keys
import java.awt.image.BufferedImage; // imports images
import java.io.File;
import java.io.IOException; // imports IOException
import java.net.URL; //imports URL usage
import javax.imageio.ImageIO; //imports image input and output
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class Gui  { // opens class
static boolean inChat; // holds if the gui is currently talking
int evidenceOffset=0; // holds the current piece of evidence
int profileOffset=0; // holds the current profile
int menu = -1;	 // holds which menu is being used
int button = 4; // holds which button is selected
boolean show=true;	//holds if the GUI should be shown
int inMenu; // holds whether the user is in a menu
int markerLocation=0; // holds the location of the menu marker
int x=250; // holds the x position of the menu
int y=250; // holds the y position of the menu

BufferedImage empty = ImageIO.read( Main.class.getResource("/resources/empty.png")); // holds empty image
BufferedImage marker = ImageIO.read( Main.class.getResource("/resources/marker.png")); // holds image for menu marker
BufferedImage scroller = ImageIO.read( Main.class.getResource("/resources/scroller.png")); // holds image for menu scroller
BufferedImage mag = ImageIO.read( Main.class.getResource("/resources/mag.png")); // holds image of magnifying glass
BufferedImage highlight = ImageIO.read( Main.class.getResource("/resources/highlight.png")); // holds image for menu highlight
BufferedImage backing = ImageIO.read( Main.class.getResource("/resources/backing.png")); // holds image for menu backing
BufferedImage backingEvidence = ImageIO.read( Main.class.getResource("/resources/backingEvidence.png")); // holds image for backing of evidence
BufferedImage backingProfile = ImageIO.read( Main.class.getResource("/resources/backingProfiles.png")); // holds image for backing of profiles
Drawable[] queue = new Drawable[40]; // holds queue of drawable objects
DrawableText[] textQueue = new DrawableText[50]; // holds queue of text to be drawn
BufferedImage[] guiElements = new BufferedImage[40]; // holds array of elements to be drawn
boolean[] sentinelValues = new boolean[40]; // holds array of values to block entrance to loops
boolean inAction; // holds if the gui is in action
private boolean inProfile; // holds if the gui is in profiles or evidence


Gui() throws IOException { // constructor for GUI

 // reads images of gui elements
	
   guiElements[1] = ImageIO.read( Main.class.getResource("/resources/topleft.png")); 
   guiElements[5] = ImageIO.read( Main.class.getResource("/resources/topleft2.png")); 
   guiElements[2] = ImageIO.read( Main.class.getResource("/resources/topright.png"));
   guiElements[6] = ImageIO.read( Main.class.getResource("/resources/topright2.png"));
   guiElements[3] = ImageIO.read( Main.class.getResource("/resources/bottomleft.png"));
   guiElements[7] = ImageIO.read( Main.class.getResource("/resources/bottomleft2.png"));
   guiElements[4] = ImageIO.read( Main.class.getResource("/resources/bottomright.png"));
   guiElements[8] = ImageIO.read( Main.class.getResource("/resources/bottomright2.png"));
   guiElements[9] = ImageIO.read( Main.class.getResource("/resources/next.png"));
   guiElements[10] = ImageIO.read( Main.class.getResource("/resources/next2.png"));
   guiElements[0]= ImageIO.read( Main.class.getResource("/resources/recordpanel.png"));
   
    
    
}
void cls() { // clears screen
 markerLocation=0; // sets marker location back to 0
	 queue = new Drawable[40]; // refreshes queue
	 textQueue = new DrawableText[50]; // refreshes queue of text
}
void update() throws IOException { // updates gui
System.out.println(menu);
	if (show) { // if the gui is being shown
		 queue[6]=null; // set the queue to null
		
		if ((!Main.currentCase.inDialogue||(Main.currentCase.inExamine&&!Main.currentCase.presented))||menu==2||menu==-17) { // if the case is not in dialogue or if it's in an examine with nothing presented
	
		
		
	
		if (menu==3 && !Main.currentCase.inCourt) { // if the menu is the base menu and it's in investigation
			textQueue[0] = null; // set the first text box to null
			
			textQueue[1] =  null; // set the second text box to null
		
			textQueue[2] =  null; // set the third text box to null
					
			textQueue[3] =  new DrawableText("Move",Color.BLACK,35.0f,true,0,0,false); // draw move in the fourth text box
			textQueue[3].x=1028-120; // draws x value of box at width - 120
			textQueue[3].y=768-40; // draws y value of box at height - 40
		}	if (menu==3&&!Main.currentCase.inCourt) { // if the menu is in the base menu and the case is not in court
		
				
			queue[1]= new Drawable(backing,200-165,120	-35,1,0,0); // creates the backing for the gui
					for (int i=0; i<6; i++) { // runs through locations
					if (i<Main.currentCase.currentLocation.paths.size()) { // if the location number is less than the number of paths out of the location
					Location path = Main.currentCase.currentLocation.paths.get(i); // the location is equal to the path of the variable
					if (i==markerLocation) textQueue[20+i]= new DrawableText(path.name,Color.GREEN,32.0f,true,0,0,false); // draws location name in green if the marker is on the location
					else textQueue[20+i]= new DrawableText(path.name,Color.BLACK,32.0f,true,0,0,false); // otherwise draws name in black
					
					textQueue[20+i].x=350; // sets the value of the textqueue of x to 350 px
					textQueue[20+i].y=150+25*i; // sets the value of the y position to 150 px + 25 times the variable
					}
				
					}
				
			
		
		      System.out.println(markerLocation+" / "+Main.currentCase.currentLocation.paths.size()); // prints the marker spot and the number of linked locations
		       
			  if(Main.currentKey!=null) { // if a key is being pressed
			
				   if(Main.keyInt==38) { // if the key is up
					   if (markerLocation>=1) // if the location is greater than 1
					   {
						   markerLocation--; // move up
						   try
						   {
							   playSound("/resources/audio/menuMove.mp3"); //plays sound
							   
						   }
						   catch(LineUnavailableException ex) // looks for exception
						   {
							   System.out.println("Wrong line");
						   }
						   catch(UnsupportedAudioFileException ex) // looks for exception
						   {
							   System.out.println("Wrong file");
						   }
						   catch(IOException ex) // looks for exception
						   {
							   System.out.println("Input problem");
						   }
					   }
				   } else if (Main.keyInt==40) { // if the key is down
					
					   if (markerLocation<Main.currentCase.currentLocation.paths.size()-1)
					   {
						   markerLocation++; // if the location is higher than the last one, move the marker down
						   try
						   {
							   playSound("/resources/audio/menuMove.mp3"); //plays sound
						   }
						   catch(LineUnavailableException ex) // looks for exception
						   {
							   System.out.println("Wrong line");
						   }
						   catch(UnsupportedAudioFileException ex) // looks for exception
						   {
							   System.out.println("Wrong file");
						   }
						   catch(IOException ex) // looks for exception
						   {
							   System.out.println("Input problem");
						   }
					   }
				   }else
					   if(Main.keyInt==KeyEvent.VK_Z) { // if z is pressed
						   
						  Main.currentCase.currentLocation.paths.get(markerLocation).enter();	//enter the chosen location
						   menu=-1; // menu is set to default
						   queue = new Drawable[40]; // creates new queue of objects to draw
							  textQueue = new DrawableText[50]; // creates new queue of text
					   }
					   else  if(Main.keyInt==KeyEvent.VK_X) { // if x is pressed
						 
						   menu=-1; // the menu is set to the default
						 queue = new Drawable[40]; // creates new queue to draw
						  textQueue = new DrawableText[50]; // creates new queue of text
		   				   
	   }
			  }
		} 
			  System.out.println(menu+ "AHAHHHAHAH"); 
		if (menu==2) { // if the menu is the record
			System.out.println("HONGKONG");
			 queue[35]= new Drawable(scroller,800,100+evidenceOffset*30*(Main.currentCase.evidence.size()+3/3)-15,1,0,0); // draws the scroller
			queue[0]= new Drawable(guiElements[0],10,10,1,0,0); // draws the background
			queue[31]= new Drawable(marker,200-5,125	-5,1,0,0); // draws the marker of evidence
			
			
			if(inProfile) { // if you're in the profile
				
				queue[1]= new Drawable(backingProfile,200-165,20	-35,1,0,0); // draws the background of the profile
				
				for (int i=0;i<3;i++) { // runs through three times
					
					if (!Main.currentCase.profiles.isEmpty()) { // if there are profiles
					if(i<Main.currentCase.profiles.size()) { // if the current variable is less than the number of profiles
						
						if (i+evidenceOffset<Main.currentCase.profiles.size())guiElements[20+i]=Main.currentCase.profiles.get(i+evidenceOffset).image; // if the offset is less than the number of profiles, add to the gui element the profile image
						else guiElements[20+i]=empty; // otherwise don't include the picture
						queue[20+i]= new Drawable(guiElements[20+i],200,125+i*120,1,0,0); // add to the queue the gui element
					}
					else { // if the number is greater than the size of the profiles
						queue[20+i] =   new Drawable(empty,200,125+i*120,1,0,0); // add default empty image
					}
					}
					
				}
				
				if (evidenceOffset<Main.currentCase.profiles.size()) // if the scroller is under the number of profiles
				
				textQueue[10] =  new DrawableText(Main.currentCase.profiles.get(evidenceOffset).name,Color.BLACK,35.0f,true,0,0,false); // writes the name of the profile
				else
					textQueue[10] =  new DrawableText("EMPTY",Color.BLACK,35.0f,true,0,0,false); // if the scroller is over the number of profiles write the empty text
				textQueue[10].x=350; // sets the x co-ordinate of the profile text
				textQueue[10].y=200; // sets the y co-ordinate of the profile text
				
				if (evidenceOffset<Main.currentCase.profiles.size()) // if the scroller is under the number of profiles
					
					textQueue[11] =  new DrawableText(Main.currentCase.profiles.get(evidenceOffset).desc,Color.BLACK,15.0f,true,0,0,false); // writes the description of the profile
					else
						textQueue[11] =  new DrawableText("EMPTY",Color.BLACK,15.0f,true,0,0,false); // otherwise writes the empty text
					textQueue[11].x=350; // sets the x co-ordinate of the description
					textQueue[11].y=250; // sets the y co-ordinate of the description
				
			} else { // if you're not in the profile
				queue[1]= new Drawable(backingEvidence,200-165,20	-35,1,0,0); // draws the background for the evidence
			for (int i=0;i<3;i++) { // runs for three evidence pieces
				
				if (!Main.currentCase.evidence.isEmpty()) { // if evidence is not empty
				if(i<Main.currentCase.evidence.size()) { // if the variable is less than the total pieces of evidence
					
					if (i+evidenceOffset<Main.currentCase.evidence.size())guiElements[20+i]=Main.currentCase.evidence.get(i+evidenceOffset).image;  // if the current piece of evidence is less than the number of pieces the evidence picture is drawn
					else guiElements[20+i]=empty; // otherwise draw the empty box
					queue[20+i]= new Drawable(guiElements[20+i],200,125+i*120,1,0,0); // draws the picture
				}
				else {
					queue[20+i] =   new Drawable(empty,200,125+i*120,1,0,0); // otherwise draw an empty box
				}
				}
				
			}
			
			if (evidenceOffset<Main.currentCase.evidence.size())  // if the evidence selected is less than the number of pieces of evidence
			
			textQueue[10] =  new DrawableText(Main.currentCase.evidence.get(evidenceOffset).name,Color.BLACK,35.0f,true,0,0,false); // writes the name of the evidence
			else
				textQueue[10] =  new DrawableText("EMPTY",Color.BLACK,35.0f,true,0,0,false); // otherwise writes the empty text
			textQueue[10].x=350; // sets the x value to 350
			textQueue[10].y=200; // sets the y value to 200
			
			if (evidenceOffset<Main.currentCase.evidence.size())  // if the evidence selected is less than the number of pieces of evidence
				
				textQueue[11] =  new DrawableText(Main.currentCase.evidence.get(evidenceOffset).desc,Color.BLACK,15.0f,true,0,0,false); // writes the evidence description
				else
					textQueue[11] =  new DrawableText("EMPTY",Color.BLACK,15.0f,true,0,0,false); // writes an empty description
				textQueue[11].x=350; // sets the x value to 350
				textQueue[11].y=250; // sets the y value to 250
			}


		      
		       
			  if(Main.currentKey!=null) { // if a key is being pressed
			
				   if(Main.keyInt==38) { // if the key is up
					   if (evidenceOffset!=0) // if the first piece of evidence is not selected
					   {
						   evidenceOffset--; // move up
						   try
						   {
							   playSound("/resources/audio/menuMove.mp3"); //plays sound
						   }
						   catch(LineUnavailableException ex) // looks for exception
						   {
							   System.out.println("Wrong line");
						   }
						   catch(UnsupportedAudioFileException ex) // looks for exception
						   {
							   System.out.println("Wrong file");
						   }
						   catch(IOException ex) // looks for exception
						   {
							   System.out.println("Input problem");
						   }
					   }
				   } else if (Main.keyInt==40) { // if the key is down
					   if (evidenceOffset!=Main.currentCase.evidence.size()+5)
					   {
						   evidenceOffset++; // if the selection isn't out of bounds, move down
						   try
						   {
							   playSound("/resources/audio/menuMove.mp3"); //plays sound
						   }
						   catch(LineUnavailableException ex) // looks for exception
						   {
							   System.out.println("Wrong line");
						   }
						   catch(UnsupportedAudioFileException ex) // looks for exception
						   {
							   System.out.println("Wrong file");
						   }
						   catch(IOException ex) // looks for exception
						   {
							   System.out.println("Input problem");
						   }
					   }
				   }else
					   if(Main.keyInt==90) { // if the key is z
						   		
						   if (evidenceOffset<Main.currentCase.evidence.size()) { // if the evidence is a piece of evidence
								if (  Main.currentCase.evidence.get(evidenceOffset)!=null)  { // if the evidence exists
								if(!Main.currentCase.inCourt)
								{
									Main.currentCase.currentLocation.present(Main.currentCase.evidence.get(evidenceOffset)); // presents piece of evidence
								}
									 queue = new Drawable[40]; // resets drawing queue
									  textQueue = new DrawableText[50]; // resets text queue
									this.menu=-1; // moves out of menu
								}
								   				   
							   }
						   
					   }
					   else  if(Main.keyInt==KeyEvent.VK_X) { // if the key is x
						 
						   menu=-1; // moves out of menu
						 queue = new Drawable[40]; // resets drawing queue
						  textQueue = new DrawableText[50]; // resets text queue
		   				   
	   } 	   else if (Main.keyInt==KeyEvent.VK_LEFT||Main.keyInt==KeyEvent.VK_RIGHT) { // checks if left or right is chosen
		   evidenceOffset=0; // resets scroller
		   this.cls(); // clears screen
		   if (inProfile) inProfile = false; // switches profile
		   else inProfile=true;
		   try
		   {
			   playSound("/resources/audio/menuMove.mp3"); //plays sound
		   }
		   catch(LineUnavailableException ex) // looks for exception
		   {
			   System.out.println("Wrong line");
		   }
		   catch(UnsupportedAudioFileException ex) // looks for exception
		   {
			   System.out.println("Wrong file");
		   }
		   catch(IOException ex) // looks for exception
		   {
			   System.out.println("Input problem");
		   }
		   
	   }
				   
				   }
			  
		} else
			  
		if (menu==1&&Main.currentCase.inCourt) { // if the menu's on the evidence menu and the case is in court
			 queue[35]= new Drawable(scroller,800,100+evidenceOffset*30*(Main.currentCase.evidence.size()+3/3)-15,1,0,0); // draws the scroller
			queue[0]= new Drawable(guiElements[0],10,10,1,0,0); // draws the background
			queue[31]= new Drawable(marker,200-5,125	-5,1,0,0); // draws the marker
	
			if(inProfile) { // if the menu is in a profile 
				queue[1]= new Drawable(backingProfile,200-165,20	-35,1,0,0); // draws the backing for the profile
				
				for (int i=0;i<3;i++) { // runs through three profiles to include on screen
					
					if (!Main.currentCase.profiles.isEmpty()) { // if profiles aren't empty
					if(i<Main.currentCase.profiles.size()) { // if the profile of the variable exists
						
						if (i+evidenceOffset<Main.currentCase.profiles.size())guiElements[20+i]=Main.currentCase.profiles.get(i+evidenceOffset).image;  // if the selected profile is within the range, draw the image
						else guiElements[20+i]=empty; // otherwise draw an empty box
						queue[20+i]= new Drawable(guiElements[20+i],200,125+i*120,1,0,0); // draws the necessary image
					}
					else { // if the profiles are empty
						queue[20+i] =   new Drawable(empty,200,125+i*120,1,0,0); // draw an empty box
					}
					}
					
				}
				
				if (evidenceOffset<Main.currentCase.profiles.size()) // if the selected evidence is less than the size of profiles
				
				textQueue[10] =  new DrawableText(Main.currentCase.profiles.get(evidenceOffset).name,Color.BLACK,35.0f,true,0,0,false); // draw the name of the profile
				else // if the selected evidence is past the profiles
					textQueue[10] =  new DrawableText("EMPTY",Color.BLACK,35.0f,true,0,0,false); // write the empty text
				textQueue[10].x=350; // sets x position of text
				textQueue[10].y=200; // sets y position of text
				
				if (evidenceOffset<Main.currentCase.profiles.size())  // if the selected evidence is less than the size of profiles
					
					textQueue[11] =  new DrawableText(Main.currentCase.profiles.get(evidenceOffset).desc,Color.BLACK,15.0f,true,0,0,false); // write the evidence description
					else // if the evidence is past the profiles
						textQueue[11] =  new DrawableText("EMPTY",Color.BLACK,15.0f,true,0,0,false); // write an empty description
					textQueue[11].x=350; // sets x position of text
					textQueue[11].y=250; // sets y position of text
				
			} else { // if the user is not in a profile
				queue[1]= new Drawable(backingEvidence,200-165,20	-35,1,0,0); // draws the background for the evidence
			for (int i=0;i<3;i++) { // runs through three pieces of evidence
				
				if (!Main.currentCase.evidence.isEmpty()) { // if there are pieces of evidence
				if(i<Main.currentCase.evidence.size()) { // if the variable is less than the number of pieces of evidence
					
					if (i+evidenceOffset<Main.currentCase.evidence.size())guiElements[20+i]=Main.currentCase.evidence.get(i+evidenceOffset).image; // if the evidence fits on screen, get the image 
					else guiElements[20+i]=empty; // otherwise get an empty image
					queue[20+i]= new Drawable(guiElements[20+i],200,125+i*120,1,0,0); // draws image
				}
				else { // if there are no pieces of evidence
					queue[20+i] =   new Drawable(empty,200,125+i*120,1,0,0); // draws empty image
				}
				}
				
			}
			
			if (evidenceOffset<Main.currentCase.evidence.size()) // if the selected piece of evidence is within the evidence size
			
			textQueue[10] =  new DrawableText(Main.currentCase.evidence.get(evidenceOffset).name,Color.BLACK,35.0f,true,0,0,false); // draws name of evidence
			else // if the piece of evidence is not within the evidence size
				textQueue[10] =  new DrawableText("EMPTY",Color.BLACK,35.0f,true,0,0,false); // draws empty text
			textQueue[10].x=350; // sets x value of text
			textQueue[10].y=200; // sets y value of text
			
			if (evidenceOffset<Main.currentCase.evidence.size())  // if the selected piece of evidence is within the evidence size
				
				textQueue[11] =  new DrawableText(Main.currentCase.evidence.get(evidenceOffset).desc,Color.BLACK,15.0f,true,0,0,false); // draws description of evidence
				else // if the piece of evidence is not within the number of pieces
					textQueue[11] =  new DrawableText("EMPTY",Color.BLACK,15.0f,true,0,0,false); // draw empty description
				textQueue[11].x=350; // sets x value of text
				textQueue[11].y=250; // sets y value of text
			}


//System.out.println(evidenceOffset);
		      
		       
			  if(Main.currentKey!=null) { // if a key is pressed
			
				   if(Main.keyInt==38) { // if the key is up
					   if (evidenceOffset!=0) // if the first piece isn't selected
					   {
						   evidenceOffset--; // moves up
						   try
						   {
							   playSound("/resources/audio/menuMove.mp3"); //plays sound
						   }
						   catch(LineUnavailableException ex) // looks for exception
						   {
							   System.out.println("Wrong line");
						   }
						   catch(UnsupportedAudioFileException ex) // looks for exception
						   {
							   System.out.println("Wrong file");
						   }
						   catch(IOException ex) // looks for exception
						   {
							   System.out.println("Input problem");
						   }
					   }
				   } else if (Main.keyInt==40) { // if the key is down
					   if (evidenceOffset!=Main.currentCase.evidence.size()+5)
					   {
						   evidenceOffset++; // if the selected piece of evidence is not the last one, moves down
						   try
						   {
							   playSound("/resources/audio/menuMove.mp3"); //plays sound
						   }
						   catch(LineUnavailableException ex) // looks for exception
						   {
							   System.out.println("Wrong line");
						   }
						   catch(UnsupportedAudioFileException ex) // looks for exception
						   {
							   System.out.println("Wrong file");
						   }
						   catch(IOException ex) // looks for exception
						   {
							   System.out.println("Input problem");
						   }
					   }
				   }else
					   if(Main.keyInt==90) { // if the key is z
						   if (inProfile) { // if the menu is in a profilie
						   if (evidenceOffset<Main.currentCase.profiles.size()) { // if the evidence is within the size of profiles
						if (  Main.currentCase.profiles.get(evidenceOffset)!=null)  { // if the profile exists
					
							Main.currentCase.currentExamine.statements.get(Main.currentCase.currentExamine.currentStatement).present(Main.currentCase.profiles.get(evidenceOffset)); // presents profile
							 queue = new Drawable[40]; // resets queue
							  textQueue = new DrawableText[50]; // resets text queue
							this.menu=-1; // resets menu
						}
						   				   
					   }
						   } else { // if the user is in evidence
						   if (evidenceOffset<Main.currentCase.evidence.size()) { // if the evidence is within the number of pieces of evidence
								if (  Main.currentCase.evidence.get(evidenceOffset)!=null)  { // if the evidence exists
									  Main.currentCase.currentExamine.statements.get(Main.currentCase.currentExamine.currentStatement).present(Main.currentCase.evidence.get(evidenceOffset)); // presents evidence
									 queue = new Drawable[40]; // resets queue
									  textQueue = new DrawableText[50]; // resets text queue
									this.menu=-1; // resets menu
								}
								   				   
							   }
						   }
						   /////
						   
					   }
					   else  if(Main.keyInt==KeyEvent.VK_X) { // if the key is x
						 
						   menu=-1; // resets menu
						 queue = new Drawable[40]; // resets queue
						  textQueue = new DrawableText[50]; // resets text queue
		   				   
	   } else if (Main.keyInt==KeyEvent.VK_LEFT||Main.keyInt==KeyEvent.VK_RIGHT) { // if the key is left or right
		   evidenceOffset=0; // reset the scroller
		   this.cls(); // clear screen
		   if (inProfile) inProfile = false; // switches profile
		   else inProfile=true;
		   try
		   {
			   playSound("/resources/audio/menuMove.mp3"); //plays sound
		   }
		   catch(LineUnavailableException ex) // looks for exception
		   {
			   System.out.println("Wrong line");
		   }
		   catch(UnsupportedAudioFileException ex) // looks for exception
		   {
			   System.out.println("Wrong file");
		   }
		   catch(IOException ex) // looks for exception
		   {
			   System.out.println("Input problem");
		   }
		   
	   }
				   }
			  
		}

	/*	else if (menu==4) {
			textQueue = new DrawableText[50];
			 guiElements = new BufferedImage[40];
		} */
		else if (menu==69) { // if the menu is the base menu
			if(Main.currentCase.timer1<5)cls(); // if the timer is less than 1 clear the screen
			else if (Main.currentCase.timer1>5&&Main.currentCase.timer1<7)  { // if the timer is between 5 and 7 switch the view to the test view
				Main.currentCase.court.switchview(69, (String)null);
			} else if(Main.currentCase.timer1>7&&Main.currentCase.timer1<30) { // if the timer is between 7 and 30
				if (!this.sentinelValues[0]) { // if the sentinel value is false
					//Main.currentCase.court.ceObjects[0].play("ouranCE", 5, true);
				this.sentinelValues[0]=true; // set the sentinel value to true
				}
				
				Main.currentCase.court.ceObjects[0].x+=10; // increases x coordinate of cross-examination
			}
 		} if (menu==-17) {
			//	System.out.println("SAVE ME");
			  // Main.game.saveGame();
			
			//makes buttons
 			
 			queue[0]= new Drawable(guiElements[0],0,0,1,0,0);
			 System.out.println("frog");System.out.println("frog");System.out.println("frog");System.out.println("frog");System.out.println("frog");System.out.println("frog");

			
			if(true) {
			if (button==0)textQueue[0] = new DrawableText("Continue",Color.GREEN,30.0f,true,0,0,false); 
			else textQueue[0] = new DrawableText("Continue",Color.GRAY,30.0f,true,0,0,false); 
			if (button==1)textQueue[1] = new DrawableText("Save",Color.GREEN,30.0f,true,0,0,false); 
			else textQueue[1] = new DrawableText("Save",Color.GRAY,30.0f,true,0,0,false); 
			if (button==2)textQueue[2] = new DrawableText("Exit",Color.GREEN,30.0f,true,0,0,false); 
			else textQueue[2] = new DrawableText("Exit",Color.GRAY,30.0f,true,0,0,false); 
		
			textQueue[0].x=300; // sets the x value
			textQueue[0].y=300;
			
			textQueue[1].x=300; // sets the x value
			textQueue[1].y=400;
			
			textQueue[2].x=300; // sets the x value
			textQueue[2].y=500;
			
			if(Main.currentKey!=null) {
				if(Main.keyInt==KeyEvent.VK_Z) {
					if(button==0) {
						
						Main.gui.cls();
						  queue = new Drawable[40]; // creates new queue of objects to draw
						  textQueue = new DrawableText[50]; // creates new queue of text
						
						Main.gui.menu=-1;
						  queue = new Drawable[40]; // creates new queue of objects to draw
						  textQueue = new DrawableText[50]; // creates new queue of text
						
					} else if (button==1) {
						Main.game.saveGame();
						Main.gui.cls();
						button=0;
						  queue = new Drawable[40]; // creates new queue of objects to draw
						  textQueue = new DrawableText[50]; // creates new queue of text
						
						Main.gui.menu=-1;
						  queue = new Drawable[40]; // creates new queue of objects to draw
						  textQueue = new DrawableText[50]; // creates new queue of text
						
					} else if (button==2) {
					System.exit(0);	
					}
					
				}   else if(Main.keyInt==38) { // if the key is up
					   if (button>0) button--;
				   } else if (Main.keyInt==40) { // if the key is down
					   if (button<2) button++;
				   }
				
				else if(Main.keyInt==KeyEvent.VK_X) {
					menu=-1;
					 queue = new Drawable[40]; // resets drawing queue
					  textQueue = new DrawableText[50]; // resets text queue // creates new queue of text
				} 
			}
			} else {
				if (button==0)textQueue[0] = new DrawableText("Continue",Color.GREEN,30.0f,true,0,0,false); 
				else textQueue[0] = new DrawableText("Continue",Color.GRAY,30.0f,true,0,0,false); 
				if (button==1)textQueue[1] = new DrawableText("Can't save while in Court",Color.GREEN,30.0f,true,0,0,false); 
				else textQueue[1] = new DrawableText("Save",Color.GRAY,30.0f,true,0,0,false); 
				if (button==2)textQueue[2] = new DrawableText("Exit",Color.GREEN,30.0f,true,0,0,false); 
				else textQueue[2] = new DrawableText("Exit",Color.GRAY,30.0f,true,0,0,false); 
			
				textQueue[0].x=300; // sets the x value
				textQueue[0].y=300;
				
				textQueue[1].x=300; // sets the x value
				textQueue[1].y=400;
				
				textQueue[2].x=300; // sets the x value
				textQueue[2].y=500;
				
				if(Main.currentKey!=null) {
					if(Main.keyInt==KeyEvent.VK_Z) {
						if(button==0) {
							
							Main.gui.cls();
							  queue = new Drawable[40]; // creates new queue of objects to draw
							  textQueue = new DrawableText[50]; // creates new queue of text
							
							Main.gui.menu=-1;
							  queue = new Drawable[40]; // creates new queue of objects to draw
							  textQueue = new DrawableText[50]; // creates new queue of text
							
						} else if (button==1) {
							
							
						} else if (button==2) {
						System.exit(0);	
						}
						
					}   else if(Main.keyInt==38) { // if the key is up
						   if (button>0) button--;
					   } else if (Main.keyInt==40) { // if the key is down
						   if (button<2) button++;
					   }
					
					else if(Main.keyInt==KeyEvent.VK_X) {
						Main.gui.cls();
						  queue = new Drawable[40]; // creates new queue of objects to draw
						  textQueue = new DrawableText[50]; // creates new queue of text
						
						Main.gui.menu=-1;
						  queue = new Drawable[40]; // creates new queue of objects to draw
						  textQueue = new DrawableText[50]; // creates new queue of text
					} 
				}
			}
		}
		else if (menu == 1) { // if the menu is the base menu
			
			if (!Main.currentCase.inCourt) { // if the case is not in court
				
				if (!Main.currentCase.inDialogue&&button==4)button=1; // if the case is not in dialogue and the button would be the fifth one, set it to the second
				System.out.println("button: "+button+" menu: "+menu); // prints out button
				queue[2]=null; // resets queue
			      
			       queue[4]= new Drawable(guiElements[3],0,768-100,1,0,0); // draws top-left element
			       queue[5]= null; // resets queue
			       
			       queue[3]= new Drawable(guiElements[2],1028-200,0,1,0,0); // draws bottom-left element
			       if(button==1)  queue[3]= new Drawable(guiElements[6],1028-200,0,1,0,0); // if the button was 1 draw the top-right element
			       
			   	  if(button==0) queue[2]= null; // if the button was 0 reset the queue
			   
			   	  if(button==2)  queue[4]= new Drawable(guiElements[7],0,768-100,1,0,0); // if the button was 2 draw the bottom-left element
			   	  if(button==3)   queue[5]=null; // if the button was 3 reset the queue
			   	  
			
				if (button==2) { // if the button was 2
					textQueue[3] =  new DrawableText("Present",new Color(Main.randInt(0,255),Main.randInt(0,255),255),35.0f,true,0,0,false); // draws in present in random colour
				} else { // if the button was not 2
					textQueue[3] =  new DrawableText("Present",Color.BLUE,35.0f,true,0,0,false); // draws in present in blue
				}
				textQueue[3].y=768-40;// sets the y value
				textQueue[3].x=20;		// sets the x value
				
				textQueue[1] = null; // sets the queue value to null
				if (button==1) { // if the button is 1
					textQueue[2] =  new DrawableText("See Ya!",new Color(255,Main.randInt(0,255),Main.randInt(0,255)),33.0f,true,0,0,false); // draws See Ya
				} else { // if the button is not 1
					textQueue[2] =  new DrawableText("Thanks.",Color.RED,33.0f,true,0,0,false); // draws in Thanks
				}
				textQueue[2].x=1028-130;// sets the x value
				textQueue[2].y=40; // sets the y value
				
				textQueue[4] =  null;			// sets top-left element
				
				
				
			Question[] shown = new Question[20]; // array of questions holds shown questions
			StoryManager story = Main.currentCase; // sets current case
			int i=0; // integer variable set to 0
			
			for (Question q: story.currentLocation.questions ) { // runs through questions
				if (q.unlocked) { // if the question is unlocked, show it
				shown[i]=q;
				
				if (!Gui.inChat) { // if the GUI is not in a chat
				if (q.asked) textQueue[20+i] = new DrawableText(q.question,Color.GRAY,25.0f,true,0,0,false); // if the question is asked, draw it in gray
				else  textQueue[20+i] = new DrawableText(q.question,Color.WHITE,25.0f,true,0,0,false); // if not asked, draw it in white
				textQueue[20+i].x=300; // sets the x value
				textQueue[20+i].y=500+i*50; // sets the y value
				
				} else { // if the the gui is in chat
					 textQueue[20+i] = null; // set the question to not appear
				}
				i++; // increase question number
				}
			}
			
			
			  if(Main.currentKey!=null) { // if a key is being pressed
				 
				
				   if(Main.keyInt==40) { // if the key is down
					if (markerLocation<story.currentLocation.getVisible()-1)
						{
							markerLocation++; // if there is a location below, move down
							try
							   {
								   playSound("/resources/audio/menuMove.mp3"); //plays sound
							   }
							   catch(LineUnavailableException ex) // looks for exception
							   {
								   System.out.println("Wrong line");
							   }
							   catch(UnsupportedAudioFileException ex) // looks for exception
							   {
								   System.out.println("Wrong file");
							   }
							   catch(IOException ex) // looks for exception
							   {
								   System.out.println("Input problem");
							   }
						}
				   } else if  (Main.keyInt==38) { // if the key is up
					if (markerLocation>0)
						{
							markerLocation--;   // if there are locations above, move up
							try
							   {
								   playSound("/resources/audio/menuMove.mp3"); //plays sound
							   }
							   catch(LineUnavailableException ex) // looks for exception
							   {
								   System.out.println("Wrong line");
							   }
							   catch(UnsupportedAudioFileException ex) // looks for exception
							   {
								   System.out.println("Wrong file");
							   }
							   catch(IOException ex) // looks for exception
							   {
								   System.out.println("Input problem");
							   }
						}
				   } else if (Main.keyInt==KeyEvent.VK_LEFT) { // if the key is left, switch the buttons around
					   try
					   {
						   playSound("/resources/audio/menuMove.mp3"); //plays sound
					   }
					   catch(LineUnavailableException ex) // looks for exception
					   {
						   System.out.println("Wrong line");
					   }
					   catch(UnsupportedAudioFileException ex) // looks for exception
					   {
						   System.out.println("Wrong file");
					   }
					   catch(IOException ex) // looks for exception
					   {
						   System.out.println("Input problem");
					   }
					   if(button==1) button=-2;
					   else if(button==-2) button=2;
					   else if (button==2) button=1;
					   
				   } else if (Main.keyInt==KeyEvent.VK_RIGHT) { // if the key is right, switch the buttons around
					   try
					   {
						   playSound("/resources/audio/menuMove.mp3"); //plays sound
					   }
					   catch(LineUnavailableException ex) // looks for exception
					   {
						   System.out.println("Wrong line");
					   }
					   catch(UnsupportedAudioFileException ex) // looks for exception
					   {
						   System.out.println("Wrong file");
					   }
					   catch(IOException ex) // looks for exception
					   {
						   System.out.println("Input problem");
					   }
					   if(button==1) button=2;
					   else if(button==2) button=-2;
					   else if (button==-2) button=1;
				   }
				   else 
					   if(Main.keyInt==90&&button==-2) { // if the key is z and the button is talk
							 queue = new Drawable[40]; // resets queue
							  textQueue = new DrawableText[50]; // resets text queue
							  Gui.inChat=true; // enters chat
						   Main.currentCase.currentLocation.talk(shown[markerLocation].id); // asks question
						   
					}
					   else 
						   if(Main.keyInt==KeyEvent.VK_ESCAPE&&!Main.currentCase.inCourt) {
							   cls();
							   queue = new Drawable[40]; // creates new queue of objects to draw
								  textQueue = new DrawableText[50]; // creates new queue of text
						menu=-17;
						button=0;
							   
						}
				   if(Main.keyInt==90&&button==2) { // if the key is z and the button is evidence
					   queue = new Drawable[40]; // resets queue
						  textQueue = new DrawableText[50]; // resets text queue
						 menu=2; // enters evidence menu
					   
				}
					   else  if(Main.keyInt==90&&button==1) { // if the key is x or if the key is z and the button is exit
							 
						   queue = new Drawable[40]; // reset the queue
							  textQueue = new DrawableText[50]; // reset the text queue
						   menu=-1; // return to the main menu
							
		   				   
	   }
						   
					   }
			  if (!Gui.inChat&&button==-2) { // if the GUI is not in chat and the button is talk
			queue[31]= new Drawable(highlight,200+75,400+this.markerLocation*50,1,0,0); // draws highlight on button
			  } else { // if the gui is in chat or the button is not talk
			queue[31]=null; // don't draw highlight
			  }
		}
		}
		else if (menu == 0) { // if the menu is examine
			if (!Main.currentCase.inCourt) { // if the case is not in court
	
			queue[10] = new Drawable (mag, x-55, y-55, 1, 0, 0) ; // draws magnifying glass
			//queue[11] = new Drawable (marker, x-55, y-55, 1, 0, 0) ;
			
			
			
			if(Main.pressingKey!=null) { // if a key is pressed
			  
				if (button==4&&Main.keyInt!=90) button=0; // if the button is return and the key is not z, returns
						  if  (Main.pressingKey.getKeyCode()==37) { // if the button is left
							x-=5; // moves left
						   } else
				   if(Main.pressingKey.getKeyCode()==39) { // if the button is right
				x+=5; // moves right
				   } else
				   if(Main.pressingKey.getKeyCode()==38) { // if the button is up
					y-=5; // moves up
				   } else 
					   
				   if (Main.pressingKey.getKeyCode()==40) { // if the button is down
					   y+=5; // moves down
				   } 
					  
			}
			
			 if(Main.keyInt==90) { // if the button is z
				   
				   Main.currentCase.currentLocation.interact(x, y); // interact with object
			}
			 
			   else  if(Main.keyInt==KeyEvent.VK_X) { // if the button is x
				   queue = new Drawable[40]; // reset queue
					  textQueue = new DrawableText[50]; // reset text queue
				   menu=-1; // return to main menu
						
	   				   
   }
							   
						  
				  
				}
			}
	
			else if(menu==-1) { // if the menu is the main menu
			if(Main.currentKey!=null) {
				   if(Main.keyInt==KeyEvent.VK_ESCAPE) {
					//System.out.println("SAVE ME");
					 //  Main.game.saveGame();
menu=-17;
						   
					}
				}
			if (Main.currentCase.inCourt) { // if the case is in court
			if (button==0) { // if the button is the top left
				textQueue[1] =  new DrawableText("Press",new Color(Main.randInt(200, 255),Main.randInt(200, 255),Main.randInt(200, 255)),35.0f,true,0,0,false); // draw press in a random colour
			} else { // if the button is not top left
				textQueue[1] =  new DrawableText("Press",Color.WHITE,35.0f,true,0,0,false); // draw press in white
			}
			textQueue[1].x=20; // sets x value for button
			textQueue[1].y=40; // sets y value for button
			if(button==1) { // if the button is the top right
				textQueue[2] =  new DrawableText("Present",new Color(255,Main.randInt(0, 255),Main.randInt(0,255)),35.0f,true,0,0,false); // draw present in a random colour
				} else { // if the button is not the top right
					textQueue[2] =  new DrawableText("Present",Color.RED,35.0f,true,0,0,false);	 // draw present in red
				}
			textQueue[2].x=1028-130; // sets x value for button
			textQueue[2].y=40; // sets y value for button
			if (button==2) { // if the button is the bottom left
				textQueue[3] =  new DrawableText("Record",new Color(Main.randInt(0, 255),Main.randInt(0,255),255),35.0f,true,0,0,false); // draws record in a random colour
				} else { // if the button is not the bottom left
					textQueue[3] =  new DrawableText("Record",Color.BLUE,35.0f,true,0,0,false);	 // draws record in blue
				}
			textQueue[3].y=768-40; // sets x value for button
			textQueue[3].x=20;				 // sets y value for button
			textQueue[4] =  new DrawableText("Menu",Color.BLACK,35.0f,true,0,0,false); // draws in menu
			textQueue[4].x=1028-120; // sets x value for button
			textQueue[4].y=768-40; // sets y value for button
			
		} else { // if the game is not in court
			
			if (button==0) { // if the button is the top-left
				textQueue[1] =  new DrawableText("Examine",new Color(Main.randInt(200, 255),Main.randInt(200, 255),Main.randInt(200, 255)),35.0f,true,0,0,false); // draw examine in a random colour
			} else { // if the button is not the top-left
				textQueue[1] =  new DrawableText("Examine",Color.WHITE,35.0f,true,0,0,false); // draws the button in white
			}
			textQueue[1].x=20; // sets the x value for the button
			textQueue[1].y=40; // sets the y value for the button
			
			if(button==1) { // if the button is the top-right
			textQueue[2] =  new DrawableText("Talk",new Color(255,Main.randInt(0, 255),Main.randInt(0,255)),35.0f,true,0,0,false); // draws talk in a random colour
			} else { // if the button is not the top-right
				textQueue[2] =  new DrawableText("Talk",Color.RED,35.0f,true,0,0,false);	// draws talk in red
			}
			textQueue[2].x=1028-130; // sets x value for button
			textQueue[2].y=40; // sets y value for button
			if (button==2) { // if the button is the bottom-left
			textQueue[3] =  new DrawableText("Record",new Color(Main.randInt(0, 255),Main.randInt(0,255),255),35.0f,true,0,0,false); // draws record in a random colour
			} else { // if the button is not the bottom-right
				textQueue[3] =  new DrawableText("Record",Color.BLUE,35.0f,true,0,0,false);	// draws record in blue
			}
			textQueue[3].y=768-40; // sets y value for button
			textQueue[3].x=20;	 // sets x value for button
			
			if (button==3) { // if the button is the bottom-right
			textQueue[4] =  new DrawableText("Move",new Color(Main.randInt(0, 100),Main.randInt(0,100),Main.randInt(0,100)),35.0f,true,0,0,false); // draws move in a random colour
			} else { // if the button is not the bottom-right
				textQueue[4] =  new DrawableText("Move",Color.BLACK,35.0f,true,0,0,false); // draws move in black
				
			}
			textQueue[4].x=1028-120; // sets x value for button
			textQueue[4].y=768-40; // sets y value for button
			
			
		}
		
	 
		if (Main.currentCase.inExamine) { // if the case is in an examination
			
			if (inAction) {  // if an action is running
				
				//for (int i=0;i<6;i++) { // runs through all buttons
				//	 queue[i]=null; // removes all buttons
					
				//}
				
				//button=4; // sets default button to next
				queue[10]= new Drawable(guiElements[10],(1028-200)/2,768-100,1,0,0); // draws next
				
			} else { // if no action is running
			 if (button==4) queue[10]= new Drawable(guiElements[10],(1028-200)/2,768-100,1,0,0); // draws highlighted 'next' if the button is selected
			 else queue[10] = new Drawable(guiElements[9],(1028-200)/2,768-100,1,0,0); // draws plain 'next' if the button is not selected
			  if(Main.currentKey!=null) { // if a key is being pressed
				
				
						  if  (Main.keyInt==37) { // if the key is left
							  try
							   {
								   playSound("/resources/audio/menuMove.mp3"); //plays sound
							   }
							   catch(LineUnavailableException ex) // looks for exception
							   {
								   System.out.println("Wrong line");
							   }
							   catch(UnsupportedAudioFileException ex) // looks for exception
							   {
								   System.out.println("Wrong file");
							   }
							   catch(IOException ex) // looks for exception
							   {
								   System.out.println("Input problem");
							   }
							   if(button==0)button=1; // moves from top-left to top-right
							   else
							
							   if(button==1)button=0; // moves from top-right to top-left
							   else
							   
							   if(button==2)button = 3; // moves from bottom-left to bottom-right
							   else if (button ==4) button=2; // moves from middle to bottom-left
							   else if (button == 3) button=4; // moves from bottom-right to middle
						   } else
				   if(Main.keyInt==39) { // if the key is right
					   try
					   {
						   playSound("/resources/audio/menuMove.mp3"); //plays sound
					   }
					   catch(LineUnavailableException ex) // looks for exception
					   {
						   System.out.println("Wrong line");
					   }
					   catch(UnsupportedAudioFileException ex) // looks for exception
					   {
						   System.out.println("Wrong file");
					   }
					   catch(IOException ex) // looks for exception
					   {
						   System.out.println("Input problem");
					   }
					   if(button==0)button=1; // moves from top-left to top-right
					   else
					
					   if(button==1)button=0; // moves from top-right to top-left
					   else
					   
					   if(button==2)button=4; // moves from bottom-left to bottom-right
					   else if (button ==3) button=2; // moves from bottom-right to middle
					   else if (button ==4) button=3; // moves from middle to bottom-left
				   } else
				   if(Main.keyInt==38||Main.keyInt==40) { // if the key is up or down
					   try
					   {
						   playSound("/resources/audio/menuMove.mp3"); //plays sound
					   }
					   catch(LineUnavailableException ex) // looks for exception
					   {
						   System.out.println("Wrong line");
					   }
					   catch(UnsupportedAudioFileException ex) // looks for exception
					   {
						   System.out.println("Wrong file");
					   }
					   catch(IOException ex) // looks for exception
					   {
						   System.out.println("Input problem");
					   }
					   if(button==0)button=2; // moves from top-left to bottom-left
					   else
					   if(button==2)button=0; // moves from bottom-left to top-left
					   else
					   if(button==1)button=3; // moves from top-right to bottom-right
					   else
					   if(button==3)button=1; // moves from bottom-right to top-right
				   } else 
					   if(Main.keyInt==90) { // if the key is z
						   if (button==2||button==3) { // if the button is bottom-left or move
						   menu=button; // opens menu
						   cls(); // clears screen
						   } 
						   else if (button == 3) // if button is Menu
						   {
							   button=0;
							  menu=-17; 
							  cls(); 
						   }
						   else if (button ==1) { // if the button is top-right
							   System.out.println("yolo"); // prints test phrase
							   if (!Main.currentCase.inCourt) { // if the case is not in court
								 
								  if (Main.currentCase.currentLocation.questions.isEmpty()) { // if there are no questions
									  Main.currentCase.insertD("Umm.. Talk to who?", Main.currentCase.currentChar.name); // plays default phrase
								  } else { // if there are questions
									  menu=1; // opens question menu
									  cls(); // clears screen
								  }
							   }else { // if the case is in court
								   menu=1; // opens menu
								   cls(); // clears screen
							   }
						   } else
						   if (button==0) { // if the button is top-left
							
		if (Main.currentCase.inCourt) { // if the case is in court
			inAction=true; // sets action to running
							   Main.currentCase.currentExamine.statements.get(Main.currentCase.currentExamine.currentStatement).press(); // presses statement
		} else { // if the case is not in court
			
			menu=button; // opens menu
			cls(); // clears screen
		}
						
						   }}
			  }
					   }
			
			
		} else { // if there is no examination
		  if(Main.currentKey!=null) { // if a key is being pressed
			  markerLocation=0; // set the default location to 0
			if (button==4&&Main.keyInt!=90) button=0; // if the button is the middle and z is not pressed set the button to the top-left
					  if  (Main.keyInt==37) { // if the button is left
						  try
						   {
							   playSound("/resources/audio/menuMove.mp3"); //plays sound
						   }
						   catch(LineUnavailableException ex) // looks for exception
						   {
							   System.out.println("Wrong line");
						   }
						   catch(UnsupportedAudioFileException ex) // looks for exception
						   {
							   System.out.println("Wrong file");
						   }
						   catch(IOException ex) // looks for exception
						   {
							   System.out.println("Input problem");
						   }
						   if(button==0)button=1; // moves from top-left to top-right
						   else
						
						   if(button==1)button=0; // moves from top-right to top-left
						   else
						   
						   if(button==2)button=3; // moves from bottom-left to bottom-right
						   else if (button ==3) button=2; // moves from bottom-right to bottom-left
					   } else
			   if(Main.keyInt==39) { // if the button is right
				   try
				   {
					   playSound("/resources/audio/menuMove.mp3"); //plays sound
				   }
				   catch(LineUnavailableException ex) // looks for exception
				   {
					   System.out.println("Wrong line");
				   }
				   catch(UnsupportedAudioFileException ex) // looks for exception
				   {
					   System.out.println("Wrong file");
				   }
				   catch(IOException ex) // looks for exception
				   {
					   System.out.println("Input problem");
				   }
				   if(button==0)button=1; // moves from top-left to top-right
				   else
				
				   if(button==1)button=0; // moves from top-right to top-left
				   else
				   
				   if(button==2)button=3; // moves from bottom-left to bottom-right
				   else if (button ==3) button=2; // moves from bottom-right to bottom left
			   } else
			   if(Main.keyInt==38||Main.keyInt==40) { // if the key is up or down
				   try
				   {
					   playSound("/resources/audio/menuMove.mp3"); //plays sound
				   }
				   catch(LineUnavailableException ex) // looks for exception
				   {
					   System.out.println("Wrong line");
				   }
				   catch(UnsupportedAudioFileException ex) // looks for exception
				   {
					   System.out.println("Wrong file");
				   }
				   catch(IOException ex) // looks for exception
				   {
					   System.out.println("Input problem" +ex.getMessage());
				   }
				   if(button==0)button=2; // moves from top-left to bottom-left
				   else
				   if(button==2)button=0; // moves from bottom-left to top-left
				   else
				   if(button==1)button=3; // moves from top-right to bottom-right
				   else
				   if(button==3)button=1; // moves from bottom-right to top-right
			   } else 
				   if(Main.keyInt==90) { // if the key is z
					   if (button==3||button==2) { // if the button is bottom-left or bottom-right
						   menu=button; // opens correct menu
						  							   cls(); // clears screen
						   } else if (button ==1) { // if the button is top-right
							   System.out.println("yolo"); // print test phrase
							   if (!Main.currentCase.inCourt) { // if the case is not in court
								 
								  if (Main.currentCase.currentLocation.questions.isEmpty()) { // if there are no questions
									  Main.currentCase.insertD("Umm.. Talk to who?", Main.currentCase.currentChar.name); // print default phrase
								  } else { // if there are questions
									  menu=1; // open question menu
									  cls(); // clear screen
								  }
							   }else { // if the case is in court
								   cls(); // clear screen
								   menu=1; // open menu
							   }
						   } 
						   
						   else if (button==3) { // if the button was close
							  menu=-17;
							  cls();
							   
							   
						   }
						   else 
					   if (button==0) { // if the button is top-left
						
	if (Main.currentCase.inCourt) { // if the case is in court
		button=4; // set the button to middle
		Main.currentKey=null; // set no key to being pressed
		 Main.dialogue.reset(); // resets dialogue
						   Main.currentCase.currentExamine.statements.get(Main.currentCase.currentExamine.currentStatement).press(); // writes pressed statement
	} else {// if the case is not in court
		
		menu=button; // opens menu
		cls(); // clears screen
	}
					
					   }}
					   
				   }}
			   }
		if (menu==-1) { // if the menu is the base menu
			queue[2]= new Drawable(guiElements[1],0,0,1,0,0); // draw top-left button
	       queue[3]= new Drawable(guiElements[2],1028-210,10,1,0,0); // draw top-right button
	     
	       queue[4]= new Drawable(guiElements[3],0,768-100,1,0,0); // draw bottom-left button
	       queue[5]= new Drawable(guiElements[4],1028-200,768-100,1,0,0); // draw bottom-right button
	       
	   	  if(button==0) queue[2]= new Drawable(guiElements[5],0,0,1,0,0); // draw selected top-left
	   	  if(button==1)  queue[3]= new Drawable(guiElements[6],1028-210,10,1,0,0); // draw selected top-right
	   	  if(button==2)  queue[4]= new Drawable(guiElements[7],0,768-100,1,0,0); // draw selected bottom-left
	   	  if(button==3)   queue[5]= new Drawable(guiElements[8],1028-200,768-100,1,0,0); // draw selected bottom-right
if (!Main.currentCase.inCourt) {
			textQueue[48] =  new DrawableText("Press ESC for Menu",new Color(200, Main.randInt(0,255), Main.randInt(100,115)),45.0f,true,0,0,false); // prints instructions
		textQueue[48].x=325; // sets x position of text
		textQueue[48].y=750; // sets y position of text
}
			
		   //	 if(button==4)   queue[5]= new Drawable(guiElements[9],600-200,768-100,1,0,0);
		}
		
		if ((menu!=-1)&&(menu==1&&!Main.currentCase.inCourt)) { // if the menu is not the base menu and the menu is either not in court or talking
		
			textQueue[48] =  new DrawableText("Press X to return",new Color(200, Main.randInt(0,255), Main.randInt(100,115)),35.0f,true,0,0,false); // prints instructions
			textQueue[48].x=375; // sets x position of text
			textQueue[48].y=750; // sets y position of text
			
			
		}
	   	  
		
		
		
		
	} else if (menu==-1){ // if dialogue is running
		//for (int i=0;i<6;i++) { // runs through buttons
			// queue[i]=null; // sets buttons to not exist
			
	//	}
		//for (int i=1;i<5;i++) { // runs through text
			// textQueue[i]=null; // sets text to not exist
			
		//}
		 //button=4; // sets button to next
		if (button==0)button=4;
		System.out.println(button+"  LION  "+menu);
		queue[2]=null;
		queue[3]=null;
		textQueue[2]=null;
		textQueue[1]=null;
		textQueue[4] =  new DrawableText("Menu",Color.BLACK,35.0f,true,0,0,false); // draws in menu
		textQueue[4].x=1028-120; // sets x value for button
		textQueue[4].y=768-40; // sets y value for button
		 queue[6]= new Drawable(guiElements[9],(1028-200)/2,768-100,1,0,0); // draws button
		 
		 textQueue[3] =  new DrawableText("Record",Color.BLUE,35.0f,true,0,0,false);	 // draws record in blue
		 textQueue[3].y=768-40; // sets x value for button
			textQueue[3].x=20;		
			queue[4]= new Drawable(guiElements[3],0,768-100,1,0,0); // draw bottom-left button
	       queue[5]= new Drawable(guiElements[4],1028-200,768-100,1,0,0); // draw bottom-right button
	       
	   	  if(button==2)  queue[4]= new Drawable(guiElements[7],0,768-100,1,0,0); // draw selected bottom-left
	   	  if(button==3)   queue[5]= new Drawable(guiElements[8],1028-200,768-100,1,0,0);
	   	  if(button==4) queue[6]= new Drawable(guiElements[10],(1028-200)/2,768-100,1,0,0); // draws button
		
		 if(Main.currentKey!=null) { // if a key is being pressed
			 System.out.println("TURTLE");
			  markerLocation=0; // set the default location to 0
					  if  (Main.keyInt==37) { // if the button is left
						  try
						   {
							   playSound("/resources/audio/menuMove.mp3"); //plays sound
						   }
						   catch(LineUnavailableException ex) // looks for exception
						   {
							   System.out.println("Wrong line");
						   }
						   catch(UnsupportedAudioFileException ex) // looks for exception
						   {
							   System.out.println("Wrong file");
						   }
						   catch(IOException ex) // looks for exception
						   {
							   System.out.println("Input problem");
						   }
						   
						   if(button==2) button=3; // moves from bottom-left to bottom-right
							  
						   else if (button ==3) button=4; // moves from bottom-right to middle
						   
						   else if (button==4)button=2; //moves from middle to bottom left
					   } else
			   if(Main.keyInt==39) { // if the button is right
				   try
				   {
					   playSound("/resources/audio/menuMove.mp3"); //plays sound
				   }
				   catch(LineUnavailableException ex) // looks for exception
				   {
					   System.out.println("Wrong line");
				   }
				   catch(UnsupportedAudioFileException ex) // looks for exception
				   {
					   System.out.println("Wrong file");
				   }
				   catch(IOException ex) // looks for exception
				   {
					   System.out.println("Input problem");
				   }
				   
				   
				   if(button==2)button=4; // moves from bottom-left to middle
				   else if (button==4)button=3;//moves from middle to bottom right
				   else if (button ==3) button=2; // moves from bottom-right to bottom left
			   } else
				   if(Main.keyInt==90) { // if the key is z
					   if (button==2) { // if the button is bottom-left or bottom-right
						   
						   menu=button; // opens correct menu
						   cls(); // clears screen
						   } 
						   
						   else if (button==3) { // if the button was close
								   
								   menu=-17;
								   button=0;
								   cls();
								   
								   
							   }
							   }
						   
					   }
		}
		}
	}
	void playSound(String file) throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
    	File url = new File(file);
    	Clip clip = AudioSystem.getClip();
    	AudioInputStream ais = AudioSystem.
    	getAudioInputStream( url );
    	clip.open(ais);
    	clip.start();
    }
}