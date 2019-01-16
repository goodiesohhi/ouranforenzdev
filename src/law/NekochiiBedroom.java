package law; // selects package

import java.io.IOException; // imports IOException

public class NekochiiBedroom extends Location { // opens class
		boolean block; // holds if block has been entered
		StoryManager story = Main.currentCase; // sets current case
		
		public NekochiiBedroom() { // constructs location
			 super("Jesus Palace",202); // chooses name and background
			 block=true; // sets block to true
		}
		
		void enter () throws IOException { // enters location
			super.enter(); // enters super
			//Main.renderer.insert("nekoArson",112);
			
			 if (!flags[0]){ // checks that this only runs once
					
				 story.insertD("This is a place", "Hello"); // inserts dialogue
				story.playAni("Nekocchi","nekocchiWitness",1,true); // plays animation
				
				 story.insertD("Hey! Ouran","Nekocchi"); // inserts dialogue
				 story.insertD("Welcome to my crypt","Nekocchi");
				 story.insertD("I hope you like it here","Nekocchi");
				 flags[0] = true; // sets flag to true
				 this.addQuestion(new Question(0, "What are you?", true)); // adds questions
				 this.addQuestion(new Question(1, "But why?", false));
				 
				 
				 
				 
				 
				 
				 
			 } else {
				 story.playAni("Nekocchi","nekocchiWitness",1,true); // plays animation
			 }
			 
			 
		}
		
		@Override
		void update() { // updates location
			super.update(); // updates super
		
		}

		@Override
		void events(int i) { // runs events
			
			
		}

		@Override
		void talk(int i) { // runs talking
			//what the hell are you
			
			this.getQuestionId(i).asked=true; // finds question asked
			if (i==0) { // chooses question
				story.insertD("What am I?", "Nekocchi"); // writes dialogue 
				story.insertD("I am.....", "Nekocchi"); 
				story.insertD("A KUO-TOA!", "Nekocchi");
				this.unlockQuestion(1); // unlocks next question
			}
			
			//but why?u
			if (i==1) { // chooses question
				story.insertD("I'm going to vore....", "Nekocchi");  // plays dialogue
				story.insertD("YOUR HORSE LEGS!", "Nekocchi"); 
				story.insertD("UwUwUwUwUwUWWUWUSUSHDBJSKJHDNJSDKNSDJ", "Nekocchi");
				//if(story.findItem("Ouran's Attorney's Badge")!=null)
			  if(flags[121]) { 		// checks for flag
				
			  }
				else story.insertD("Do you have your badge? You need your badge to goto court. Duh. Nya.", "Nekocchi"); // if flag is not there, plays dialogue
				
				 
			}
			if (i==99) { // finds question
				Main.currentCase.flags[25]=true; // sets flag to true
				story.insertD("Let's upgrade your badge", "Nekocchi"); // plays dialogue
				story.insertR( "Ouran's Attorney's Badge","badge","My badge (Upgraded)", false,0); // updates record
				story.insertD("Off to court!", "Nekocchi"); // plays dialgoue
				   story.toCourt(); // moves to court
			}
		}

		private Question getQuestionId(int id) { // finds question id


			for (Question q: questions) { // runs through questions
				if (q.id==id) return q; // finds correct id
			}
			
			return null; // returns no question asked
			
		}

		@Override
		protected void present(RecordEntry recordEntry) { // presents item
			System.out.println(recordEntry.name);
			if(recordEntry.name.equals("Ouran's Attorney's Badge")&&!flags[121]) { // checks for attorney's badge
				
				story.insertD("Nice! You have it", "Nekocchi"); // plays dialogue
				this.addQuestion(new Question(99, "Lets head to court", true)); // adds question
				
			}
			
		}
	}


