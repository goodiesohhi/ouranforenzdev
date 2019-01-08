package law;

import java.io.IOException;

public class NekochiiBedroom extends Location {
		boolean block;
		StoryManager story = Main.currentCase;
		
		public NekochiiBedroom() {
			 super("Jesus Palace",202);
			 block=true;
		}
		
		void enter () throws IOException {
			super.enter();
			//Main.renderer.insert("nekoArson",112);
			
			 if (!flags[0]){
					
				 story.insertD("This is a place", "Hello");
				story.playAni("Nekocchi","nekocchiWitness",1,true);
				
				 story.insertD("Hey! Ouran","Nekocchi");
				 story.insertD("Welcome to my crypt","Nekocchi");
				 story.insertD("I hope you like it here","Nekocchi");
				 flags[0] = true;
				 this.addQuestion(new Question(0, "What are you?", true));
				 this.addQuestion(new Question(1, "But why?", false));
				 
				 
				 
				 
				 
				 
				 
			 } else {
				 story.playAni("Nekocchi","nekocchiWitness",1,true);
			 }
			 
			 
		}
		
		@Override
		void update() {
			super.update();
		
		}

		@Override
		void events(int i) {
			
			
		}

		@Override
		void talk(int i) {
			//what the hell are you
			
			this.getQuestionId(i).asked=true;
			if (i==0) {
				story.insertD("What am I?", "Nekocchi"); 
				story.insertD("I am.....", "Nekocchi"); 
				story.insertD("A KUO-TOA!", "Nekocchi");
				this.unlockQuestion(1);
			}
			
			//but why?u
			if (i==1) {
				story.insertD("I'm going to vore....", "Nekocchi"); 
				story.insertD("YOUR HORSE LEGS!", "Nekocchi"); 
				story.insertD("UwUwUwUwUwUWWUWUSUSHDBJSKJHDNJSDKNSDJ", "Nekocchi");
				//if(story.findItem("Ouran's Attorney's Badge")!=null)
			  if(flags[121]) { 		
				
			  }
				else story.insertD("Do you have your badge? You need your badge to goto court. Duh. Nya.", "Nekocchi"); 
				
				 
			}
			if (i==99) {
				Main.currentCase.flags[25]=true;
				story.insertD("Let's upgrade your badge", "Nekocchi");
				story.insertR( "Ouran's Attorney's Badge","badge","My badge (Upgraded)", false,0);
				story.insertD("Off to court!", "Nekocchi");
				   story.toCourt();
			}
		}

		private Question getQuestionId(int id) {


			for (Question q: questions) {
				if (q.id==id) return q;
			}
			
			return null;
			
		}

		@Override
		protected void present(RecordEntry recordEntry) {
			if(recordEntry.name.equals("Ouran's Attorney's Badge")&&!flags[121]) {
				
				story.insertD("Nice! You have it", "Nekocchi");
				this.addQuestion(new Question(99, "Lets head to court", true));
				
			}
			
		}
	}


