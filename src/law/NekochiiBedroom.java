package law;

import java.io.IOException;

public class NekochiiBedroom extends Location {
		boolean block;
		StoryManager story = Main.currentCase;
		
		public NekochiiBedroom() {
			 super("Jesus Palace",201);
			 block=true;
		}
		
		void enter () throws IOException {
			super.enter();
			Main.renderer.insert("nekoArson",112);
			
			Main.currentCase.inCourt=false;
			Main.currentCase.somewhere=true;
			Main.renderer.queue[0]= new Drawable(graphic,0,0,1,0,0);
			 if (!flags[0]){
				
				 story.show(112,280,0);
				 story.insertD("Hey! Ouran","Nekocchi");
				 story.insertD("Welcome to my crypt","Nekocchi");
				 story.insertD("I hope you like it here","Nekocchi");
				 flags[0] = true;
				 
				 
				 
				 
				 
				 
				 
				 
			 }
		}
		
		@Override
		void update() {
			super.update();
		}

		@Override
		void events(int i) {
			
			
		}
	}


