package law; // selects package
import javax.swing.SwingUtilities; // imports swing
import java.awt.event.KeyEvent; // imports using keys
import java.awt.event.KeyListener; // imports listening for keys
import java.awt.event.MouseEvent; // imports using mouse
import java.awt.event.MouseListener; // imports listening for mouse

import javax.swing.JFrame; // imports frame for game
import javax.swing.JPanel; // imports panel for game
import javax.swing.BorderFactory; // imports border around game
import java.awt.Color; // imports colours
import java.awt.Dimension; // imports dimensions of game
import java.awt.Graphics; // imports graphics for game
import java.awt.Insets; // imports using insets for graphics
import java.awt.image.BufferedImage; // imports using images
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException; // imports exception if files don't exist
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; // imports exception for input and output
import java.util.ArrayList; // imports usage of array lists
import java.util.Random; // imports randomness
public class Main extends JFrame{ // opens main class
	static int count; // holds count of running through game
	static int gameState = 0; // holds current game state
	final int fps =40; // holds number of frames per second
	final int ups =40; // holds number of updates per second
	public static boolean inCourt=false; // holds whether the game is in court
	ArrayList<Drawable> actors = new ArrayList<Drawable>(); // holds all actors in game
	static int examineSlot=0; // holds which slot is currently selected to be examined
	static int currentExamine=0; // holds the current cross-examination
	static Gui gui; // holds the gui
	static Menu menu;
	static ArrayList<StoryManager> caseList = new ArrayList<StoryManager>(); 
	static StoryManager currentCase; // holds the current case
	static int keyInt; // holds the key which is being pressed as integer
	static int modTimer=0; // holds the timer
	static CrossExamination[] cExamine= new CrossExamination[100]; // holds all cross-examinations
	static boolean examineBlock=false; // blocks examine from endlessly repeating
      static KeyEvent currentKey; // holds current key being pressed
	static Dialogue dialogue = new Dialogue(0); // holds pieces of dialogue
	   int windowWidth = 1024;  // holds width of game
	    int windowHeight = 768;  // holds height of game
	    static Main game; // holds game being run
	    
	   static BufferedImage backBuffer;  // holds background image
	    static Insets insets;  // holds all insets for gui
	static Renderer renderer; // holds renderer for game
	private static boolean start; // holds whether the game has started
	public static Dialogue pressDialogue = new Dialogue(1); // holds all dialogue for pressing
	public static boolean entered; // holds whether a location has been entered
	public static KeyEvent pressingKey; // holds whether a key is being pressed
	public Main() throws IOException { // opens constructor
		 menu = new Menu();
		KeyListener listener = new KeyListen(); // creates new key listener
		MouseListener mouseListener = new MouseListen(); // creates new mouse listener
		addKeyListener(listener); // adds new key listener
		addMouseListener(mouseListener); // adds new mouse listener
		setFocusable(true); // allows game to focus on finding keys or mouse movements
		caseList.add(new Case0());
		caseList.add(new Case1());
		caseList.add(new Case3());
		caseList.add(new Case69());
	}
	public static void modAlpha(BufferedImage modMe, double modAmount) { // moderates colours
        //
    for (int x = 0; x < modMe.getWidth(); x++) {          // runs through width
        for (int y = 0; y < modMe.getHeight(); y++) { // runs through height
                //
            int argb = modMe.getRGB(x, y); //always returns TYPE_INT_ARGB
            int alpha = (argb >> 24) & 0xff;  //isolate alpha

            alpha *= modAmount; //similar distortion to tape saturation (has scrunching effect, eliminates clipping)
            alpha &= 0xff;      //keeps alpha in 0-255 range

            argb &= 0x00ffffff; //remove old alpha info
            argb |= (alpha << 24);  //add new alpha info
            modMe.setRGB(x, y, argb);   // sets value as colour         
        }
    }
}
	
    public static void main(String[] args) throws Exception { // runs main method
    	renderer = new Renderer(); // creates renderer
    	renderer.insert("defbench", 0); // inserts title screen objects
    	renderer.insert("ouranobject", 1);
    	renderer.insert("title", 2);

    	renderer.insert("judgebench", 10);
    	renderer.insert("defbench", 11);
    	renderer.insert("prosbench",12);
    	renderer.insert("stand",13);
    	renderer.insert("defcounsel", 14);
    	renderer.insert("defendantLobby", 15);

    	renderer.insert("objection",19);
    	currentCase = new Case0(); // sets the current case
    	  game = new Main();  // sets the game
         game.run();  // runs the game
         System.exit(0); // exits the console
         
      
      
		
        
    }
    
    public void saveGame () throws IOException {
    	  BufferedWriter outputWriter = null;
		  outputWriter = new BufferedWriter(new FileWriter("save.osd"));
		  
	    outputWriter.write("case: "+Main.currentCase.caseID);
	    outputWriter.newLine();
	    outputWriter.write("inCourt: "+Main.currentCase.inCourt);
	    outputWriter.newLine();
	    outputWriter.write("somewhere: "+Main.currentCase.somewhere);
	    outputWriter.newLine();
	    outputWriter.write("currentLocation: "+Main.currentCase.currentLocation.id);
	    outputWriter.newLine();
	   
	   
	    outputWriter.write("evidence: ");
		  for (RecordEntry re :Main.currentCase.evidence) {
			  
			  String save=re.name+";"+re.path+";"+re.desc+";"+re.isProfile+",";
		    outputWriter.write(save);
		   

		   
		  }
		  outputWriter.newLine();
		   outputWriter.write("profiles: ");
			  for (RecordEntry re :Main.currentCase.profiles) {
				  
				  String save=re.name+";"+re.path+";"+re.desc+";"+re.isProfile+",";
			    outputWriter.write(save);
			   
			  
			   
			  }
			  outputWriter.newLine();
		  
	    outputWriter.write("mainFlags: ");
    		  for (int i = 0; i < Main.currentCase.flags.length; i++) {
    		   
    		    outputWriter.write(Main.currentCase.flags[i]+",");
    		   
    		   
    		   
    		  }
    		  outputWriter.newLine();
    		  
    		  for (int x =0; x< Main.currentCase.locales.length;x++) {
    			  if(Main.currentCase.locales[x]!=null) {
    		    outputWriter.write("localeFlags"+x+": ");
    		    
      		  for (int i = 0; i < Main.currentCase.locales[x].flags.length; i++) {
      		   
      		    outputWriter.write(Main.currentCase.locales[x].flags[i]+",");
      		   
      		   
      		   
      		  }	  outputWriter.newLine();
    			  }
    		  }
      		  outputWriter.newLine();
       		  for (int x =0; x< Main.currentCase.locales.length;x++) {
    			  if(Main.currentCase.locales[x]!=null) {
    		    outputWriter.write("localeQuestions"+x+": ");
    		    
    		    for (Question re :Main.currentCase.locales[x].questions) {
    				  
    				  String save=re.id+";"+re.question+";"+re.unlocked+";"+re.asked+",";
    			    outputWriter.write(save);
    			   

    			   
    			  } outputWriter.newLine();
    			  }
    		  }
      		 
    		  outputWriter.flush();  
    		  outputWriter.close();  
    		
    	
    }
    public void loadGame () throws Exception {
    	String line =null;
    	 int area = -1;
    	  FileReader fileReader = 
                  new FileReader("save.osd");

              // Always wrap FileReader in BufferedReader.
              BufferedReader bufferedReader = 
                  new BufferedReader(fileReader);

              while((line = bufferedReader.readLine()) != null) {
            	  if (line.length()>1) {System.out.println("line: "+line);
            	  int i = line.indexOf(' ');
            	 
            	  String word = line.substring(0, i);
            	  String rest = line.substring(i+1);
            	  
            	  if (word.equals("case:")) {
            		  currentCase = findCase (Integer.valueOf(rest));
            		  currentCase.setUP();
            	  }
            	  if (word.equals("inCourt:")) {
            		  currentCase.inCourt = Boolean.valueOf(rest);
            				  
            	  }
            	  if (word.equals("somewhere:")) {
            		  currentCase.inCourt = Boolean.valueOf(rest);
            				  
            	  }
            	  if (word.equals("currentLocation:")) {
            		 area = Integer.valueOf(rest);
            				  
            	  }
            	  
            	  if (word.equals("evidence:")) {
            		
            		String[] entries =rest.split(",");
            		
            		for (i=0;i<entries.length;i++) {
            			String[] data =entries[i].split(";");
            			for (int z=0;z<data.length;z++) {
            				System.out.println(data[z]);
            				
            			}
           System.out.println("EVI"); 			
System.out.println(Boolean.valueOf(data[3]));
            			
            			if(data.length>1) {
            				if (!Boolean.valueOf(data[3])) {
            					Main.currentCase.evidence.add(new RecordEntry(data[0], data[1], Boolean.valueOf(data[3]),data[2], 0));
            				    
            				} else {
            					Main.currentCase.profiles.add(new RecordEntry(data[0], data[1], Boolean.valueOf(data[3]),data[2], 0));
            				}
            			}
            		}
            				  
            	  }
            	  
            	  if (word.equals("mainFlags:")) {
              		
              		String[] entries =rest.split(",");
              		
              		for (i=0;i<entries.length;i++) {
              			
              			
              			if(entries.length>1) Main.currentCase.flags[i]=Boolean.valueOf(entries[i]);
              		}
              				  
              	  }
            	  for (int g=0;g<currentCase.locales.length;g++) {
            		  if(Main.currentCase.locales[g]!=null) {
            	  if (word.equals("localeFlags"+g+":")) {
                		
                		String[] entries =rest.split(",");
                		
                		for (i=0;i<entries.length;i++) {
                			
                			
                			if(entries.length>1) {
                				Main.currentCase.locales[g].flags[i]=Boolean.valueOf(entries[i]);
                				System.out.println(entries[i]);
                			}
                		}
                				  
                	  }
            	  if (word.equals("localeQuestions"+g+":")) {
              		
              		String[] entries =rest.split(",");
              		
              		for (i=0;i<entries.length;i++) {
              			
              			
              			if(entries.length>1) {
              				String[] data = entries[i].split(";");
              				Main.currentCase.locales[g].addQuestion(new Question(Integer.valueOf(data[0]), data[1], Boolean.valueOf(data[2])));
              				
              				Main.currentCase.locales[g].questions.get(Integer.valueOf(i)).asked=Boolean.valueOf(data[3]);
              			}
              		}
              				  
              	  }
            		  }
            	  }
              	  
            	  
            	  if (word.equals("profiles:")) {
              		
              		String[] entries =rest.split(",");
              		
              		for (i=0;i<entries.length;i++) {
              			String[] data =entries[i].split(";");
              			
              			if(data.length>1)Main.currentCase.profiles.add(new RecordEntry(data[0], data[1], Boolean.valueOf(data[2]),data[3], 0));
              		}
              				  
              	  }
            	  }
            	  
              }   
              
              bufferedReader.close();
              if (area==-1) {
            	  throw new Exception("Save file Corrupt??");
              }
              else {
            	  Main.currentCase.locales[area].enter(); // enters a location
              }
              Main.switchState(2);
             
         
    }
    private StoryManager findCase(Integer valueOf) {
		for (StoryManager c : caseList) {
			if (c.caseID==valueOf) return c;
			
		}
		return null;
	}
	public void run() throws Exception { // runs the game
        initPanel();  // creates new panel
        
        
        gui = new Gui(); // sets gui
        long initialTime = System.nanoTime(); // sets time since game ran
        final double timeU = 1000000000 / ups; // holds total length of updates
        final double timeF = 1000000000 / fps; // holds total length of frames
        final double timeI = 1000000000 / 10; // holds total length of each get
        double deltaU = 0, deltaF = 0, deltaI = 0; // sets values of changes in updates, frames, or gets
        int frames = 0, ticks = 0, gets =0; // holds number of frames, ticks, and gets
        long timer = System.currentTimeMillis(); // holds timer for game

            while (true) { // loops forever
            	
              
                
                if(modTimer>=1000000) modTimer=0; // resets timer if it's too great
                
                long currentTime = System.nanoTime(); // sets the current time
                deltaU += (currentTime - initialTime) / timeU; // sets the number of updates
                deltaF += (currentTime - initialTime) / timeF; // sets the number of frames
                deltaI += (currentTime - initialTime) / timeI; // sets the number of gets
                initialTime = currentTime; // sets the starting time to the current time

                if(deltaI>=1) { // if the change in gets is greater than 1
                	  modTimer++; // increase timer
                
                	 gets++; // get values
                     deltaI--; // decrease change
                    
                }
                
                if (deltaU >= 1) { // if the change in updates is greater than 1
                	
                	getInput(); // find inputs
                	  update(); // update game
                    ticks++; // increase number of ticks
                    deltaU--; // decrease change in updates
                }
                
               

                if (deltaF >= 1) { // if change in frames is greater than 1
                    Main.renderer.update(); // update renderer
                    Main.currentKey=null; // sets key to not being used
             		
             		
             		
                    this.draw(); // draws game
                    keyInt=0; // sets key integer back to 0
                    frames++; // increases number of frames
                    deltaF--; // decreases change in number of frames
                }

                if (System.currentTimeMillis() - timer > 1000) { // if the time minus the timer is over 1000
                	
                    frames = 0; // reset frames
                    ticks = 0; // reset ticks
                    gets=0; // reset gets
                    timer += 1000; // increase timer
                }
            }
        
        
    }


    protected static void update() throws Exception { // updates game
	
    	if(gameState==0) { // if the state is 0
    	while(!start) { // if the game has not started
    	 count= 0;	 // set the count to 0
    	renderer.queue[1]= new Drawable(0,0,0,1,0,1); // adds drawable to queue

    	renderer.queue[3]= new Drawable(1,-500,280+68,1,0,3); // adds title to queue
    	renderer.queue[3].dx=0; // sets destination of title
    	renderer.queue[3].speed=20; // sets speed of title
    	renderer.queue[2]= new Drawable(2,20,-500,1,0,2); // creates new drawable
    	renderer.queue[2].dy=20; // sets destination
    	renderer.queue[2].speed=20; // sets speed
    	Main.start=true; // starts game
    	
    	}
    	
    	if(renderer.queue[2].y==20) renderer.queue[2].speed=1; // if the title's position is correct, increase its speed a tiny bit
    	if(renderer.queue[2].y==0) { // if the title's position is 0, move it back to the default
    		renderer.queue[2].dy =20;
    	count++; // increase count
    	}
    	if(renderer.queue[2].y==20) renderer.queue[2].dy =0; // if the title's position is 20 move it back to 0
    	
 
    	if (count>=1) { // if the count is 1 or over
    		  if(Main.currentKey!=null) { // if a key is being pressed
    			   if(Main.currentKey.getKeyCode()==90) { // if the key is z
    		renderer.camera.speed=50;  // moves speed of camera
    		renderer.camera.pan(1100,0); // pans camera
    			   }
    		  }
    		
    	}
    	
    	if(renderer.camera.x>=1100) { // if the value of the camera is over 1100
    		renderer.clear(); // clear the renderer
    		renderer.camera.reset(); // reset the camera
    		currentCase= null; // removes current case
    	
    		switchState(3); // switches state to case
    		
    	}
    	} 
    	else if(gameState==2) { // if the game state is in game
    		
    		
    		currentCase.update(); // update case
    		gui.update(); // update gui
    		////System.out.println(currentCase.eventQueue.length);
    		
    		
    	}
    	
    	else if(gameState==3) { // if the game state is in game
    	
    		Main.currentCase=null;
    		menu.update();
    		
    		
    	}
	}
  
     void draw() throws IOException { // draws game
    
    	 Graphics g = getGraphics();  // creates graphics
    	 
    	 Graphics bbg = backBuffer.getGraphics();  // creates background buffer

    	 bbg.setColor(Color.BLACK); // sets colour of background buffer
    	 bbg.fillRect(0, 0, 1024, 768); // draws rectangle for background
         renderer.update(); // updates renderer
         renderer.draw(bbg); // draws background
    	bbg.setColor(Color.BLACK); // sets colour for background
       
    	//Main.renderer.draw(g);
         g.drawImage(Main.backBuffer, Main.insets.left, Main.insets.top, Main.game); // draws background buffer with insets as co-ordinates 
        
         
     }

	protected static void getInput() { // receives input
		
		if(currentKey!=null) keyInt=currentKey.getKeyCode(); // if a key is being pushed, set the key integer to the key's code
		
		
	}

	static void switchState(int x) { // switches game state
		start=false; // sets the game to not start
		gameState = x; // switches state
	
	}
	void initPanel() { // creates panel
		   backBuffer = new BufferedImage(1024, 768,   BufferedImage.TYPE_INT_RGB); // creates background buffer
		      
        //System.out.println("running.");
        
        setSize(windowWidth, windowHeight);  // sets size of window
        setResizable(false);  // sets if the window can be resized
    	
   
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // leaves game when closed
        setVisible(true);  // sets window to visible
        setIgnoreRepaint(true); // window is not repainted

        insets = getInsets();  // gets insets
        setSize(insets.left + windowWidth + insets.right, 
                        insets.top + windowHeight + insets.bottom); // sets size of window to width and height of window + insets
        
    }
	public static int randInt(int i, int j) { // creates random number
		Random random = new Random(); // sets variable
		
		return  random.nextInt(j + 1 - i) +i; // returns integer between i and j
	}
}

 class KeyListen implements KeyListener { // opens class
	@Override
	public void keyTyped(KeyEvent e) { // checks if a key is typed
	}

	@Override
	public void keyPressed(KeyEvent e) { // checks if a key is pressed
		Main.pressingKey= e; // sets the key being pressed
		
	}

	@Override
	public void keyReleased(KeyEvent e) { // checks if a key is released
		Main.currentKey= e; // sets the key that was released
		Main.pressingKey= null; // resets key being pressed
		//System.out.println("keyReleased="+e.getKeyCode());
	}
}

 class MouseListen implements MouseListener { // opens class

	@Override
	public void mouseClicked(MouseEvent arg0) { // checks if the mouse was clicked
	if (Main.currentCase.invest) Main.currentCase.currentLocation.click(arg0); // if the case is in investigation, clicks at spot clicked
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) { // if the mouse has entered a location
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) { // if the mouse has exited a location 
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) { // if the mouse is being pressed
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) { // if the mouse was released
		// TODO Auto-generated method stub
		
	}
	 
 }