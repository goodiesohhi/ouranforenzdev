package law;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Renderer {
	Drawable[] queue;
	DrawableText[] textQueue;
	DrawableText[] pressQueue;
	
	BufferedImage[] index = new BufferedImage[300] ;
	
	Color textBoxColor=new Color(0.1f,0.1f,0.1f,.85f );
	
	Camera camera = new Camera();
	public Renderer() {
		
		queue = new Drawable[95];
		 for (int i=0; i< queue.length;i++) {
			 
			 queue[i]=  null;
		 }
		 
			textQueue = new DrawableText[30];
			 for (int i=0; i< textQueue.length;i++) {
				 
				 textQueue[i]= null;
			 }
			 pressQueue = new DrawableText[30];
				 for (int i=0; i<pressQueue.length;i++) {
					 
					 pressQueue[i]= null;
				 }
		
		
	}

	void insert(String path, int indexNo) throws IOException {
		URL url = Main.class.getResource("/resources/"+path+".png");
		
        index[indexNo] = ImageIO.read(url);
	}
	
 public void draw(Graphics g) throws IOException {
	
	 for (int i=0; i< queue.length;i++) {
		 
		 if(queue[i]!=null)g.drawImage(queue[i].draw(),queue[i].x+camera.x,queue[i].y+camera.y,null);
		
	 }
	 
for (Character c:Main.currentCase.characters) {
		 
		 if(c.drawn!=null)g.drawImage(c.drawn.imagez,c.drawn.x+camera.x,c.drawn.y+camera.y,null);
		
	 }
	
	
	 
	 g.setColor(Color.BLUE);
	 if(Main.currentCase.textBox) g.fillRect(50, 500, 200, 49);
	 g.setColor(textBoxColor);
	 if(Main.currentCase.textBox) g.fillRect(50, 550, 850, 100);
	 
	 if (!	Main.currentCase.pressed) {
     for (int i=0; i< textQueue.length;i++) {
 
    	 if(textQueue[i]!=null) { 
    		// System.out.println(textQueue[i].drawText());
    		 
		 g.setColor(textQueue[i].color);
		 g.setFont(g.getFont().deriveFont(textQueue[i].size));
	
		 if(textQueue[i].drawText()!=null) g.drawString(textQueue[i].drawText(), textQueue[i].x, textQueue[i].y);
		
    	 }
	 }
	 } else {
		 
		 for (int i=0; i< pressQueue.length;i++) {
			 
	    	 if(pressQueue[i]!=null) { 
	    		// System.out.println(textQueue[i].drawText());
	    		 
			 g.setColor(pressQueue[i].color);
			 g.setFont(g.getFont().deriveFont(pressQueue[i].size));
			 if(pressQueue[i].drawText()!=null) g.drawString(pressQueue[i].drawText(), pressQueue[i].x, pressQueue[i].y);
			
	    	 }
		 }
		 
	 }
     
     if (Main.gui.show) {
		 for (int i=0; i< Main.gui.queue.length;i++) {
			
			 
			 if(Main.gui.queue[i]!=null) {
				 g.drawImage(Main.gui.queue[i].draw(),Main.gui.queue[i].x,Main.gui.queue[i].y,null);
				
			 }
			
		 }
		}
     
     
     for (int i=0; i< Main.gui.textQueue.length;i++) {
 
    	 if(Main.gui.textQueue[i]!=null) { 
    		 
		 g.setColor(Main.gui.textQueue[i].color);
		 g.setFont(g.getFont().deriveFont(Main.gui.textQueue[i].size));
		 g.drawString(Main.gui.textQueue[i].text, Main.gui.textQueue[i].x, Main.gui.textQueue[i].y);
		 
		
    	 }
	 }
     
     
	 
	 //g.drawImage(Main.backBuffer, Main.insets.left, Main.insets.top, Main.game); 
 }
 public void clear() {
		queue = new Drawable[95];
 }

public void update() {
	camera.update();
	
	if (Main.currentCase.pressed) 
	Main.pressDialogue.play();
	else Main.dialogue.play();

 for (int i=0; i< textQueue.length;i++) {
		 
		 if(textQueue[i]!=null)textQueue[i].update();
		 
	 }
 
 for (int i=0; i< pressQueue.length;i++) {
	 
	 if(pressQueue[i]!=null)pressQueue[i].update();
	 
 }
 for (int i=0; i< queue.length;i++) {
		 
		 if(queue[i]!=null)queue[i].update();
		 
	 }
	
}
	
}
