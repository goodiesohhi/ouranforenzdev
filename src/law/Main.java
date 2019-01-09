package law;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Main extends JFrame{
	static int count;
	static int gameState = 0;
	final int fps =40;
	final int ups =40;
	public static boolean inCourt=false;
	ArrayList<Drawable> actors = new ArrayList<Drawable>();
	static int examineSlot=0;
	static int currentExamine=0;
	static Gui gui;
	static StoryManager currentCase;
	static int keyInt;
	static int modTimer=0;
	static CrossExamination[] cExamine= new CrossExamination[100];
	static boolean examineBlock=false;
      static KeyEvent currentKey;
	static Dialogue dialogue = new Dialogue(0);
	   int windowWidth = 1024; 
	    int windowHeight = 768; 
	    static Main game;
	    
	   static BufferedImage backBuffer; 
	    static Insets insets; 
	static Renderer renderer= new Renderer();
	private static boolean start;
	public static Dialogue pressDialogue = new Dialogue(1);
	public static boolean entered;
	public static KeyEvent pressingKey;
	public Main() {
		KeyListener listener = new KeyListen();
		MouseListener mouseListener = new MouseListen();
		addKeyListener(listener);
		addMouseListener(mouseListener);
		setFocusable(true);
	}
    public static void main(String[] args) throws IOException {
    	renderer.insert("defbench", 0);
    	renderer.insert("ouranobject", 1);
    	renderer.insert("title", 2);

    	renderer.insert("judgebench", 10);
    	renderer.insert("defbench", 11);
    	renderer.insert("prosbench",12);
    	renderer.insert("stand",13);

    	renderer.insert("objection",19);
    	currentCase = new StoryManager();
    	  game = new Main(); 
         game.run(); 
         System.exit(0);
         
      
      
		
        
    }
    
    public void run() throws IOException {
        initPanel(); 
        
        
        gui = new Gui();
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / ups;
        final double timeF = 1000000000 / fps;
        final double timeI = 1000000000 / 10;
        double deltaU = 0, deltaF = 0, deltaI = 0;
        int frames = 0, ticks = 0, gets =0;
        long timer = System.currentTimeMillis();

            while (true) {
            	
              
                
                if(modTimer>=1000000) modTimer=0;
                
                long currentTime = System.nanoTime();
                deltaU += (currentTime - initialTime) / timeU;
                deltaF += (currentTime - initialTime) / timeF;
                deltaI += (currentTime - initialTime) / timeI;
                initialTime = currentTime;

                if(deltaI>=1) {
                	  modTimer++;
                
                	 gets++;
                     deltaI--;
                    
                }
                
                if (deltaU >= 1) {
                	getInput();
                    update();
               
                    ticks++;
                    deltaU--;
                }
                
               

                if (deltaF >= 1) {
                    Main.renderer.update();
                    Main.currentKey=null;
             		 keyInt=0;
                    this.draw();
                    frames++;
                    deltaF--;
                }

                if (System.currentTimeMillis() - timer > 1000) {
                	
                    frames = 0;
                    ticks = 0;
                    gets=0;
                    timer += 1000;
                }
            }
        
        
    }


    protected static void update() throws IOException {

    	if(gameState==0) {
    	while(!start) {
    	 count= 0;	
    	renderer.queue[1]= new Drawable(0,0,0,1,0,1);

    	renderer.queue[3]= new Drawable(1,-500,280+68,1,0,3);
    	renderer.queue[3].dx=0;
    	renderer.queue[3].speed=20;
    	renderer.queue[2]= new Drawable(2,20,-500,1,0,2);
    	renderer.queue[2].dy=20;
    	renderer.queue[2].speed=20;
    	Main.start=true;
    	
    	}
    	
    	if(renderer.queue[2].y==20) renderer.queue[2].speed=1;
    	if(renderer.queue[2].y==0) {
    		renderer.queue[2].dy =20;
    	count++;
    	}
    	if(renderer.queue[2].y==20) renderer.queue[2].dy =0;
    	
 
    	if (count>=1) {
    		  if(Main.currentKey!=null) {
    			   if(Main.currentKey.getKeyCode()==90) {
    		renderer.camera.speed=50; 
    		renderer.camera.pan(1100,0);
    			   }
    		  }
    		
    	}
    	
    	if(renderer.camera.x>=1100) {
    		renderer.clear();
    		renderer.camera.reset();
    		currentCase= null;
    		currentCase = new Case3();
    		switchState(2);
    		
    	}
    	} 
    	else if(gameState==2) {
    		
    		
    		currentCase.update();
    		gui.update();
    		////System.out.println(currentCase.eventQueue.length);
    		
    		
    	}
	}
  
     void draw() throws IOException {
    
    	 Graphics g = getGraphics(); 
    	 
    	 Graphics bbg = backBuffer.getGraphics(); 

    	 bbg.setColor(Color.BLACK);
    	 bbg.fillRect(0, 0, 1024, 768);
         renderer.update();
         renderer.draw(bbg);
    	bbg.setColor(Color.BLACK);
       
    	//Main.renderer.draw(g);
         g.drawImage(Main.backBuffer, Main.insets.left, Main.insets.top, Main.game); 
        
         
     }

	protected static void getInput() {
		
		if(currentKey!=null) keyInt=currentKey.getKeyCode();
		
		
	}

	static void switchState(int x) {
		start=false;
		gameState = x;
	
	}
	void initPanel() {
		   backBuffer = new BufferedImage(1024, 768,   BufferedImage.TYPE_INT_RGB); 
		      
        //System.out.println("running.");
        
        setSize(windowWidth, windowHeight); 
        setResizable(false); 
    	
   
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true); 
        setIgnoreRepaint(true);

        insets = getInsets(); 
        setSize(insets.left + windowWidth + insets.right, 
                        insets.top + windowHeight + insets.bottom); 
        
    }
	public static int randInt(int i, int j) {
		Random random = new Random();
		
		return  random.nextInt(j + 1 - i) +i;
	}
}

 class KeyListen implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Main.pressingKey= e;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.currentKey= e;
		Main.pressingKey= null;
		//System.out.println("keyReleased="+e.getKeyCode());
	}
}

 class MouseListen implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
	if (Main.currentCase.invest) Main.currentCase.currentLocation.click(arg0);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	 
 }