package law; // selects package
import javax.swing.SwingUtilities; // imports swing

import java.awt.Color; // imports colour
import java.awt.Graphics; // imports graphics
import java.awt.image.BufferedImage; // imports buffered images
import java.io.File; // imports file usage
import java.io.IOException; // imports IOException 
import java.net.URL;// imports urls

import javax.imageio.ImageIO; // imports image input
import javax.swing.JFrame; // imports jframes

public class Renderer { // opens class
	Drawable[] queue; // creates queue to draw
	DrawableText[] textQueue; // creates queue of text
	DrawableText[] pressQueue; // creates queue of presses
	BufferedImage dataField = null; // creates image for data field
	BufferedImage[] index = new BufferedImage[300] ; // holds index of images
	
	Color textBoxColor=new Color(0.1f,0.1f,0.1f,.85f ); // holds the colour of the text box
	Camera camera = new Camera(); // holds the camera
	public Renderer() throws IOException { // constructs renderer
		
		queue = new Drawable[95]; // creates new queue
		
		 
			textQueue = new DrawableText[30]; // creates new text queue
			dataField = ImageIO.read( Main.class.getResource("/resources/datafield.png")); // finds image for data field
		
			 pressQueue = new DrawableText[30]; // creates new press queue
				
		
		
	}

	void insert(String path, int indexNo) throws IOException { // inserts renderer
		URL url = Main.class.getResource("/resources/"+path+".png"); // finds path of image
		
        index[indexNo] = ImageIO.read(url); // reads image from file
	}
	
 public void draw(Graphics g) throws IOException { // draws image
	
	 for (int i=0; i< queue.length;i++) { // runs through images in queue
		 
		 if(queue[i]!=null)g.drawImage(queue[i].draw(),queue[i].x+camera.x,queue[i].y+camera.y,null); // draws image
		
	 }
	 if (Main.currentCase!=null) {
	 if (Main.currentCase.currentLocation!=null) { // if the location exists
		 for (ClickEvent c: Main.currentCase.currentLocation.clickEvents) { // runs through click events
		 	
		 		 if(c.image!=null&&!c.unlocked) { // if the image is there
		 			 g.drawImage(c.image, c.x+camera.x,c.y+camera.y,null); // draws the image
		 			
		 		 }
		 		
		 	 }
		 }
	 
for (Character c:Main.currentCase.characters) { // runs through characters
	
		 if(c.drawn!=null) { // if the character exists
			 if (Main.gui.menu!=0) g.drawImage(c.drawn.imagez,c.drawn.x+camera.x,c.drawn.y+camera.y,null); // draws character
			
		 }
		
	 }


for (Character c: Main.currentCase.court.characters) { // runs through court characters

	 if(c.drawn!=null) { // if the character exists
		 g.drawImage(c.drawn.imagez,c.drawn.x+camera.x,c.drawn.y+camera.y,null); // draws the character
		
	 }
}
	


	
	 
	 g.setColor(Color.BLUE); // sets colour for text box
	 if(Main.currentCase.textBox&&!Main.currentCase.dataText) g.fillRect(50, 500, 200, 49); // if the text box exists, draw the box
	 g.setColor(textBoxColor); // sets colour to text box colour
	 if(Main.currentCase.textBox) { // if the box exists
		 if(Main.currentCase.dataText) { // if it is a data field
			 g.drawImage(dataField,50,525,null); // draw a data filed
		 } else { // otherwise
			 g.fillRect(50, 550, 850, 100); // draw a text box
		 }
	 }
	 }
	 if (Main.currentCase!=null) {
	 if (!	Main.currentCase.pressed) { // if the case is not pressed
     for (int i=0; i< textQueue.length;i++) { // runs through text queue
 
    	 if(textQueue[i]!=null) {  // if the text exists
    		// //System.out.println(textQueue[i].drawText());
    		 
		 g.setColor(textQueue[i].color); // sets colour to text colour
		 g.setFont(g.getFont().deriveFont(textQueue[i].size)); // sets font to text font
	
		 if(textQueue[i].drawText()!=null) g.drawString(textQueue[i].drawText(), textQueue[i].x, textQueue[i].y); // if the text exists, draw the text
		
    	 }
	 }
	 
	 } else { // if the case is pressed
		 
		 for (int i=0; i< pressQueue.length;i++) { // runs through presses
			 
	    	 if(pressQueue[i]!=null) {  // if the press exists
	    		// //System.out.println(textQueue[i].drawText());
	    		 
			 g.setColor(pressQueue[i].color); // sets colour for press
			 g.setFont(g.getFont().deriveFont(pressQueue[i].size)); // sets font for press
			 if(pressQueue[i].drawText()!=null) g.drawString(pressQueue[i].drawText(), pressQueue[i].x, pressQueue[i].y); // draws press
			
	    	 }
		 }
		 
	 }
	 } else if (Main.gameState==3&&Main.menu.entered) {
	
	     for (int i=0; i< textQueue.length;i++) { // runs through text queue
	    	 
	    	 if(textQueue[i]!=null) {  // if the text exists
	    		// //System.out.println(textQueue[i].drawText());
	    		
			 g.setColor(textQueue[i].color); // sets colour to text colour
			 g.setFont(g.getFont().deriveFont(textQueue[i].size)); // sets font to text font
		
			 if(textQueue[i].drawText()!=null) g.drawString(textQueue[i].text, textQueue[i].x, textQueue[i].y); // if the text exists, draw the text
			
	    	 }
		 }
		 
	 }
     if (Main.currentCase!=null) {
     if (Main.gui.show) { // if the gui is being shown
		 for (int i=0; i< Main.gui.queue.length;i++) { // runs through gui queue
			
			 
			 if(Main.gui.queue[i]!=null) { // if the gui element exists
				 g.drawImage(Main.gui.queue[i].draw(),Main.gui.queue[i].x,Main.gui.queue[i].y,null); // draw the gui element
				
			 }
			
		 }
		}
     
     
     for (int i=0; i< Main.gui.textQueue.length;i++) { // runs through gui text
 
    	 if(Main.gui.textQueue[i]!=null) {  // if the gui text exists
    		 
		 g.setColor(Main.gui.textQueue[i].color); // sets colour for gui text
		 g.setFont(g.getFont().deriveFont(Main.gui.textQueue[i].size)); // sets font for gui text
		 g.drawString(Main.gui.textQueue[i].text, Main.gui.textQueue[i].x, Main.gui.textQueue[i].y); // draws gui text
		 
		
    	 }
	 }
	 }
	 }
     
	 
	 //g.drawImage(Main.backBuffer, Main.insets.left, Main.insets.top, Main.game); 
 
 public void clear() { // clears renderer
		queue = new Drawable[95]; // resets queue
 }

public void update() { // updates renderer
	
	if (Main.currentCase!=null) {
	camera.update(); // updates camera
	
	if (Main.currentCase.pressed)  // if the case is pressed
	Main.pressDialogue.play(); // play the press dialogue
	else Main.dialogue.play(); // otherwise play normal dialogue

 for (int i=0; i< textQueue.length;i++) { // runs through text queue
		 
		 if(textQueue[i]!=null)textQueue[i].update(); // if the text exists, update the text
		 
	 }
 
 for (int i=0; i< pressQueue.length;i++) { // runs through press queue
	 
	 if(pressQueue[i]!=null)pressQueue[i].update(); // if the press queue exists, update the press
	 
 }
 for (int i=0; i< queue.length;i++) { // runs through images
		 
		 if(queue[i]!=null)queue[i].update(); // if the image exists, update the image
		 
	 }
	}
	
}

public void reset() { // resets renderer
	
	queue = new Drawable[95]; // resets queue
	
	 
		textQueue = new DrawableText[30]; // resets text queue
	
		 pressQueue = new DrawableText[30]; // resets press queue
			
	
}
	
}
