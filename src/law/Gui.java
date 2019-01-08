package law;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

class Gui  {
static boolean inChat;
int evidenceOffset=0;
int profileOffset=0;
int menu = -1;	
int button = 4;
boolean show=true;	
int inMenu;
int markerLocation=0;
int x=250;
int y=250;

BufferedImage empty = ImageIO.read( Main.class.getResource("/resources/empty.png"));
BufferedImage marker = ImageIO.read( Main.class.getResource("/resources/marker.png"));
BufferedImage scroller = ImageIO.read( Main.class.getResource("/resources/scroller.png"));
BufferedImage mag = ImageIO.read( Main.class.getResource("/resources/mag.png"));
BufferedImage highlight = ImageIO.read( Main.class.getResource("/resources/highlight.png"));
BufferedImage backing = ImageIO.read( Main.class.getResource("/resources/backing.png"));
Drawable[] queue = new Drawable[40];
DrawableText[] textQueue = new DrawableText[50];
BufferedImage[] guiElements = new BufferedImage[40];
boolean inAction;


	Gui() throws IOException {
	
     
		
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
	
	void update() throws IOException {
	
		if (show) {
			 queue[6]=null;
			
			if (!Main.currentCase.inDialogue||(Main.currentCase.inExamine&&!Main.currentCase.presented)) {
		
			
			
		
			if (menu==3 && !Main.currentCase.inCourt) {
				textQueue[0] = null;
				
				textQueue[1] =  null;
			
				textQueue[2] =  null;
						
				textQueue[3] =  new DrawableText("Move",Color.BLACK,35.0f,true,0,0,false);
				textQueue[3].x=1028-120;
				textQueue[3].y=768-40;
			}	if (menu==3&&!Main.currentCase.inCourt) {
			
					
				queue[1]= new Drawable(backing,200-5-50,125	-35,1,0,0);
						for (int i=0; i<6; i++) {
						if (i<Main.currentCase.currentLocation.paths.size()) {
						Location path = Main.currentCase.currentLocation.paths.get(i);
						if (i==markerLocation) textQueue[20+i]= new DrawableText(path.name,Color.YELLOW,32.0f,true,0,0,false);
						else textQueue[20+i]= new DrawableText(path.name,Color.WHITE,32.0f,true,0,0,false);
						
						textQueue[20+i].x=200;
						textQueue[20+i].y=150+25*i;
						}
					
						}
					
				
			
			      
			       
				  if(Main.currentKey!=null) {
				
					   if(Main.keyInt==38) {
						   if (markerLocation>=1)
					markerLocation--;
					   } else if (Main.keyInt==40) {
						   if (markerLocation<Main.currentCase.currentLocation.paths.size()) evidenceOffset++;
					   }else
						   if(Main.keyInt==KeyEvent.VK_Z) {
							   
							  Main.currentCase.currentLocation.paths.get(markerLocation).enter();	
							   menu=-1;
							   queue = new Drawable[40];
								  textQueue = new DrawableText[50];
						   }
						   else  if(Main.keyInt==KeyEvent.VK_X) {
							 
							   menu=-1;
							 queue = new Drawable[40];
							  textQueue = new DrawableText[50];
			   				   
		   }
				  }
			} else
				  
			if (menu==2) {
				 queue[35]= new Drawable(scroller,800,100+evidenceOffset*30*(Main.currentCase.evidence.size()+3/3)-15,1,0,0);
				queue[0]= new Drawable(guiElements[0],10,10,1,0,0);
				queue[31]= new Drawable(marker,200-5,125	-5,1,0,0);
				queue[1]= new Drawable(backing,200-5-50,125	-35,1,0,0);
				for (int i=0;i<3;i++) {
					
					if (!Main.currentCase.evidence.isEmpty()) {
					if(i<Main.currentCase.evidence.size()) {
						
						if (i+evidenceOffset<Main.currentCase.evidence.size())guiElements[20+i]=Main.currentCase.evidence.get(i+evidenceOffset).image; 
						else guiElements[20+i]=empty;
						queue[20+i]= new Drawable(guiElements[20+i],200,125+i*120,1,0,0);
					}
					else {
						queue[20+i] =   new Drawable(empty,200,125+i*120,1,0,0);
					}
					}
					
				}
				
				if (evidenceOffset<Main.currentCase.evidence.size()) 
				
				textQueue[10] =  new DrawableText(Main.currentCase.evidence.get(evidenceOffset).name,Color.WHITE,35.0f,true,0,0,false);
				else
					textQueue[10] =  new DrawableText("EMPTY",Color.WHITE,35.0f,true,0,0,false);
				textQueue[10].x=325;
				textQueue[10].y=200;
				
				if (evidenceOffset<Main.currentCase.evidence.size()) 
					
					textQueue[11] =  new DrawableText(Main.currentCase.evidence.get(evidenceOffset).desc,Color.WHITE,15.0f,true,0,0,false);
					else
						textQueue[11] =  new DrawableText("EMPTY",Color.WHITE,15.0f,true,0,0,false);
					textQueue[11].x=325;
					textQueue[11].y=250;


			      
			       
				  if(Main.currentKey!=null) {
				
					   if(Main.keyInt==38) {
						   if (evidenceOffset!=0)
					evidenceOffset--;
					   } else if (Main.keyInt==40) {
						   if (evidenceOffset!=Main.currentCase.evidence.size()+5) evidenceOffset++;
					   }else
						   if(Main.keyInt==90) {
							   		
							   if (evidenceOffset<Main.currentCase.evidence.size()) {
									if (  Main.currentCase.evidence.get(evidenceOffset)!=null)  {
										System.out.println("phase1");
										Main.currentCase.currentLocation.present(Main.currentCase.evidence.get(evidenceOffset));
										 queue = new Drawable[40];
										  textQueue = new DrawableText[50];
										this.menu=-1;
									}
									   				   
								   }
							   
						   }
						   else  if(Main.keyInt==KeyEvent.VK_X) {
							 
							   menu=-1;
							 queue = new Drawable[40];
							  textQueue = new DrawableText[50];
			   				   
		   }
					   }
				  
			} else
				  
			if (menu==1&&Main.currentCase.inCourt) {
				 queue[35]= new Drawable(scroller,800,100+evidenceOffset*30*(Main.currentCase.evidence.size()+3/3)-15,1,0,0);
				queue[0]= new Drawable(guiElements[0],10,10,1,0,0);
				queue[31]= new Drawable(marker,200-5,125	-5,1,0,0);
				queue[1]= new Drawable(backing,200-5-50,125	-35,1,0,0);
				for (int i=0;i<3;i++) {
					
					if (!Main.currentCase.evidence.isEmpty()) {
					if(i<Main.currentCase.evidence.size()) {
						
						if (i+evidenceOffset<Main.currentCase.evidence.size())guiElements[20+i]=Main.currentCase.evidence.get(i+evidenceOffset).image; 
						else guiElements[20+i]=empty;
						queue[20+i]= new Drawable(guiElements[20+i],200,125+i*120,1,0,0);
					}
					else {
						queue[20+i] =   new Drawable(empty,200,125+i*120,1,0,0);
					}
					}
					
				}
				
				if (evidenceOffset<Main.currentCase.evidence.size()) 
				
				textQueue[10] =  new DrawableText(Main.currentCase.evidence.get(evidenceOffset).name,Color.WHITE,35.0f,true,0,0,false);
				else
					textQueue[10] =  new DrawableText("EMPTY",Color.WHITE,35.0f,true,0,0,false);
				textQueue[10].x=325;
				textQueue[10].y=200;
				
				if (evidenceOffset<Main.currentCase.evidence.size()) 
					
					textQueue[11] =  new DrawableText(Main.currentCase.evidence.get(evidenceOffset).desc,Color.WHITE,15.0f,true,0,0,false);
					else
						textQueue[11] =  new DrawableText("EMPTY",Color.WHITE,15.0f,true,0,0,false);
					textQueue[11].x=325;
					textQueue[11].y=250;

//System.out.println(evidenceOffset);
			      
			       
				  if(Main.currentKey!=null) {
				
					   if(Main.keyInt==38) {
						   if (evidenceOffset!=0)
					evidenceOffset--;
					   } else if (Main.keyInt==40) {
						   if (evidenceOffset!=Main.currentCase.evidence.size()+5) evidenceOffset++;
					   }else
						   if(Main.keyInt==90) {
							   if (evidenceOffset<Main.currentCase.evidence.size()) {
							if (  Main.currentCase.evidence.get(evidenceOffset)!=null)  {
								System.out.println("phase1");
								Main.currentCase.currentExamine.statements.get(Main.currentCase.currentExamine.currentStatement).present(Main.currentCase.evidence.get(evidenceOffset));
								 queue = new Drawable[40];
								  textQueue = new DrawableText[50];
								this.menu=-1;
							}
							   				   
						   }
						   }
						   else  if(Main.keyInt==KeyEvent.VK_X) {
							 
							   menu=-1;
							 queue = new Drawable[40];
							  textQueue = new DrawableText[50];
			   				   
		   }
					   }
				  
			}

		/*	else if (menu==4) {
				textQueue = new DrawableText[50];
				 guiElements = new BufferedImage[40];
			} */

			else if (menu == 1) {
				
				if (!Main.currentCase.inCourt) {
					
					if (!Main.currentCase.inDialogue&&button==4)button=1;
					System.out.println("button: "+button);
					queue[2]=null;
				      
				       queue[4]= new Drawable(guiElements[3],0,768-100,1,0,0);
				       queue[5]= null;
				       
				       queue[3]= new Drawable(guiElements[2],1028-200,0,1,0,0);
				       if(button==1)  queue[3]= new Drawable(guiElements[6],1028-200,0,1,0,0);
				       
				   	  if(button==0) queue[2]= null;
				   
				   	  if(button==2)  queue[4]= new Drawable(guiElements[7],0,768-100,1,0,0);
				   	  if(button==3)   queue[5]=null;
				   	  
				
					if (button==2) {
						textQueue[3] =  new DrawableText("Present",new Color(Main.randInt(0,255),Main.randInt(0,255),255),35.0f,true,0,0,false);
					} else {
						textQueue[3] =  new DrawableText("Present",Color.BLUE,35.0f,true,0,0,false);
					}
					textQueue[3].y=768-40;
					textQueue[3].x=20;		
					
					textQueue[1] = null;
					if (button==1) {
						textQueue[2] =  new DrawableText("See Ya!",new Color(255,Main.randInt(0,255),Main.randInt(0,255)),33.0f,true,0,0,false);
					} else {
						textQueue[2] =  new DrawableText("Thanks.",Color.RED,33.0f,true,0,0,false);
					}
					textQueue[2].x=1028-130;
					textQueue[2].y=40;
					
					textQueue[4] =  null;			
					
					
					
				Question[] shown = new Question[20];
				StoryManager story = Main.currentCase;
				int i=0;
				
				for (Question q: story.currentLocation.questions ) {
					if (q.unlocked) {
					shown[i]=q;
					
					if (!Gui.inChat) {
					if (q.asked) textQueue[20+i] = new DrawableText(q.question,Color.GRAY,25.0f,true,0,0,false);
					else  textQueue[20+i] = new DrawableText(q.question,Color.WHITE,25.0f,true,0,0,false);
					textQueue[20+i].x=300;
					textQueue[20+i].y=500+i*50;
					
					} else {
						 textQueue[20+i] = null;
					}
					i++;
					}
				}
				
				
				  if(Main.currentKey!=null) {
					 
					
					   if(Main.keyInt==40) {
						if (markerLocation<story.currentLocation.getVisible()-1)markerLocation++;
					   } else if  (Main.keyInt==38) {
						if (markerLocation>0) markerLocation--;   
					   } else if (Main.keyInt==KeyEvent.VK_LEFT) {
						   
						   if(button==1) button=-2;
						   else if(button==-2) button=2;
						   else if (button==2) button=1;
						   
					   } else if (Main.keyInt==KeyEvent.VK_RIGHT) {
						   
						   if(button==1) button=2;
						   else if(button==2) button=-2;
						   else if (button==-2) button=1;
					   }
					   else 
						   if(Main.keyInt==90&&button==-2) {
								 queue = new Drawable[40];
								  textQueue = new DrawableText[50];
								  Gui.inChat=true;
							   Main.currentCase.currentLocation.talk(shown[markerLocation].id);
							   
						}
					   if(Main.keyInt==90&&button==2) {
						   queue = new Drawable[40];
							  textQueue = new DrawableText[50];
							 menu=2;
						   
					}
						   else  if(Main.keyInt==KeyEvent.VK_X||Main.keyInt==90&&button==1) {
								 
							   queue = new Drawable[40];
								  textQueue = new DrawableText[50];
							   menu=-1;
								
			   				   
		   }
							   
						   }
				  if (!Gui.inChat&&button==-2) {
				queue[31]= new Drawable(highlight,200+75,400+this.markerLocation*50,1,0,0);
				  } else {
				queue[31]=null;
				  }
			}
			}
			else if (menu == 0) {
				if (!Main.currentCase.inCourt) {
		
				queue[10] = new Drawable (mag, x-55, y-55, 1, 0, 0) ;
				//queue[11] = new Drawable (marker, x-55, y-55, 1, 0, 0) ;
				
				
				
				if(Main.pressingKey!=null) {
				  
					if (button==4&&Main.keyInt!=90) button=0;
							  if  (Main.pressingKey.getKeyCode()==37) {
								x-=5;
							   } else
					   if(Main.pressingKey.getKeyCode()==39) {
					x+=5;
					   } else
					   if(Main.pressingKey.getKeyCode()==38) {
						y-=5;
					   } else 
						   
					   if (Main.pressingKey.getKeyCode()==40) {
						   y+=5;
					   } 
						  
				}
				
				 if(Main.keyInt==90) {
					   
					   Main.currentCase.currentLocation.interact(x, y);
				}
				 
				   else  if(Main.keyInt==KeyEvent.VK_X) {
					   queue = new Drawable[40];
						  textQueue = new DrawableText[50];
					   menu=-1;
						
	   				   
   }
							   
						  
				  
				}
			}
	
			else if(menu==-1) {
			
			if (Main.currentCase.inCourt) {
				if (button==0) {
					textQueue[1] =  new DrawableText("Press",new Color(Main.randInt(200, 255),Main.randInt(200, 255),Main.randInt(200, 255)),35.0f,true,0,0,false);
				} else {
					textQueue[1] =  new DrawableText("Press",Color.WHITE,35.0f,true,0,0,false);
				}
				textQueue[1].x=20;
				textQueue[1].y=40;
				if(button==1) {
					textQueue[2] =  new DrawableText("Present",new Color(255,Main.randInt(0, 255),Main.randInt(0,255)),35.0f,true,0,0,false);
					} else {
						textQueue[2] =  new DrawableText("Present",Color.RED,35.0f,true,0,0,false);	
					}
				textQueue[2].x=1028-130;
				textQueue[2].y=40;
				if (button==2) {
					textQueue[3] =  new DrawableText("Record",new Color(Main.randInt(0, 255),Main.randInt(0,255),255),35.0f,true,0,0,false);
					} else {
						textQueue[3] =  new DrawableText("Record",Color.BLUE,35.0f,true,0,0,false);	
					}
				textQueue[3].y=768-40;
				textQueue[3].x=20;				
				textQueue[4] =  new DrawableText("Menu",Color.BLACK,35.0f,true,0,0,false);
				textQueue[4].x=1028-120;
				textQueue[4].y=768-40;
				
			} else {
				
				if (button==0) {
					textQueue[1] =  new DrawableText("Examine",new Color(Main.randInt(200, 255),Main.randInt(200, 255),Main.randInt(200, 255)),35.0f,true,0,0,false);
				} else {
					textQueue[1] =  new DrawableText("Examine",Color.WHITE,35.0f,true,0,0,false);
				}
				textQueue[1].x=20;
				textQueue[1].y=40;
				
				if(button==1) {
				textQueue[2] =  new DrawableText("Talk",new Color(255,Main.randInt(0, 255),Main.randInt(0,255)),35.0f,true,0,0,false);
				} else {
					textQueue[2] =  new DrawableText("Talk",Color.RED,35.0f,true,0,0,false);	
				}
				textQueue[2].x=1028-130;
				textQueue[2].y=40;
				if (button==2) {
				textQueue[3] =  new DrawableText("Record",new Color(Main.randInt(0, 255),Main.randInt(0,255),255),35.0f,true,0,0,false);
				} else {
					textQueue[3] =  new DrawableText("Record",Color.BLUE,35.0f,true,0,0,false);	
				}
				textQueue[3].y=768-40;
				textQueue[3].x=20;	
				
				if (button==3) {
				textQueue[4] =  new DrawableText("Move",new Color(Main.randInt(0, 100),Main.randInt(0,100),Main.randInt(0,100)),35.0f,true,0,0,false);
				} else {
					textQueue[4] =  new DrawableText("Move",Color.BLACK,35.0f,true,0,0,false);
					
				}
				textQueue[4].x=1028-120;
				textQueue[4].y=768-40;
				
				
			}
			
		
			if (Main.currentCase.inExamine) {
				
				if (inAction) { 
					
					for (int i=0;i<6;i++) {
						 queue[i]=null;
						
					}
					
					button=4;
					queue[10]= new Drawable(guiElements[10],(1028-200)/2,768-100,1,0,0);
					
				} else {
				 if (button==4) queue[10]= new Drawable(guiElements[10],(1028-200)/2,768-100,1,0,0);
				 else queue[10] = new Drawable(guiElements[9],(1028-200)/2,768-100,1,0,0);
				  if(Main.currentKey!=null) {
					
					
							  if  (Main.keyInt==37) {
								   if(button==0)button=1;
								   else
								
								   if(button==1)button=0;
								   else
								   
								   if(button==2)button = 3;
								   else if (button ==4) button=2;
								   else if (button == 3) button=4;
							   } else
					   if(Main.keyInt==39) {
						   if(button==0)button=1;
						   else
						
						   if(button==1)button=0;
						   else
						   
						   if(button==2)button=3;
						   else if (button ==3) button=4;
						   else if (button ==4) button=2;
					   } else
					   if(Main.keyInt==38||Main.keyInt==40) {
						   if(button==0)button=2;
						   else
						   if(button==2)button=0;
						   else
						   if(button==1)button=3;
						   else
						   if(button==3)button=1;
					   } else 
						   if(Main.keyInt==90) {
							   if (button==3||button==2) {
							   menu=button;
							   } else if (button ==1) {
								   System.out.println("yolo");
								   if (!Main.currentCase.inCourt) {
									 
									  if (Main.currentCase.currentLocation.questions.isEmpty()) {
										  Main.currentCase.insertD("Umm.. Talk to who?", Main.currentCase.currentChar.name);
									  } else {
										  menu=1;
									  }
								   }else {
									   menu=1;
								   }
							   } else
							   if (button==0) {
								
			if (Main.currentCase.inCourt) {
				inAction=true;
								   Main.currentCase.currentExamine.statements.get(Main.currentCase.currentExamine.currentStatement).press();
			} else {
				
				menu=button;
			}
							
							   }}
				  }
						   }
				
				
			} else {
			  if(Main.currentKey!=null) {
				  markerLocation=0;
				if (button==4&&Main.keyInt!=90) button=0;
						  if  (Main.keyInt==37) {
							   if(button==0)button=1;
							   else
							
							   if(button==1)button=0;
							   else
							   
							   if(button==2)button=3;
							   else if (button ==3) button=2;
						   } else
				   if(Main.keyInt==39) {
					   if(button==0)button=1;
					   else
					
					   if(button==1)button=0;
					   else
					   
					   if(button==2)button=3;
					   else if (button ==3) button=2;
				   } else
				   if(Main.keyInt==38||Main.keyInt==40) {
					   if(button==0)button=2;
					   else
					   if(button==2)button=0;
					   else
					   if(button==1)button=3;
					   else
					   if(button==3)button=1;
				   } else 
					   if(Main.keyInt==90) {
						   if (button==3||button==2) {
							   menu=button;
							   } else if (button ==1) {
								   System.out.println("yolo");
								   if (!Main.currentCase.inCourt) {
									 
									  if (Main.currentCase.currentLocation.questions.isEmpty()) {
										  Main.currentCase.insertD("Umm.. Talk to who?", Main.currentCase.currentChar.name);
									  } else {
										  menu=1;
									  }
								   }else {
									   menu=1;
								   }
							   } else
						   if (button==0) {
							
		if (Main.currentCase.inCourt) {
			button=4;
			Main.currentKey=null;
			 Main.dialogue.reset();
							   Main.currentCase.currentExamine.statements.get(Main.currentCase.currentExamine.currentStatement).press();
		} else {
			
			menu=button;
		}
						
						   }}
						   
					   }}
				   }
			if (menu==-1) {
				queue[2]= new Drawable(guiElements[1],0,0,1,0,0);
		       queue[3]= new Drawable(guiElements[2],1028-210,10,1,0,0);
		     
		       queue[4]= new Drawable(guiElements[3],0,768-100,1,0,0);
		       queue[5]= new Drawable(guiElements[4],1028-200,768-100,1,0,0);
		       
		   	  if(button==0) queue[2]= new Drawable(guiElements[5],0,0,1,0,0);
		   	  if(button==1)  queue[3]= new Drawable(guiElements[6],1028-210,10,1,0,0);
		   	  if(button==2)  queue[4]= new Drawable(guiElements[7],0,768-100,1,0,0);
		   	  if(button==3)   queue[5]= new Drawable(guiElements[8],1028-200,768-100,1,0,0);
		   //	 if(button==4)   queue[5]= new Drawable(guiElements[9],600-200,768-100,1,0,0);
			}
			
			if ((menu!=-1)&&!(menu==1&&!Main.currentCase.inCourt)) {
				System.out.println("hellodur");
				textQueue[48] =  new DrawableText("Press X to return",new Color(200, Main.randInt(0,255), Main.randInt(100,115)),35.0f,true,0,0,false);
				textQueue[48].x=375;
				textQueue[48].y=750;
				
				
			}
			
		   	  
			
			
			
		} else {
			for (int i=0;i<6;i++) {
				 queue[i]=null;
				
			}
			for (int i=1;i<5;i++) {
				 textQueue[i]=null;
				
			}
			 button=4;
			 queue[6]= new Drawable(guiElements[10],(1028-200)/2,768-100,1,0,0);
		}
		}
	}
	
}