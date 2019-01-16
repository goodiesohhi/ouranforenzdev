/**
 * 
 */
package law; // selects package
import java.io.IOException; // imports IOException

public class SaibaEntrance extends Location { // opens class
	
	StoryManager story = Main.currentCase; // holds current case
	public SaibaEntrance() // constructs entrance
	{
		super("Saiba Entrance", 62); // chooses location
		
	}
	@Override
	void enter() throws IOException // enters location
	{
		super.enter(); // enters super
		this.addEvent((new ClickEvent(false,"stairs", 300, 0, 300, 500, this.clickEvents, 0))); // initializes click events
		this.addEvent((new ClickEvent(false,"elevator", 700, 0, 300, 500, this.clickEvents, 1)));
		this.addEvent((new ClickEvent(false,"receptionDesk", 500, 550, 300, 50, this.clickEvents, 2)));
		this.addEvent((new ClickEvent(false,"tracks", 200, 600, 100, 50, this.clickEvents, 3)));
		if (!flags[2]) // ensures that this only runs once
		{
			story.insertData("Saiba Corp. Entrance"); // plays dialogue
			story.insertData("August 10");
			story.insertData("9:00 PM");
			story.playAni("Susan Ord", "susanWitness", 1, false); // plays animation
			story.insertD("We’re finally here.", "Ouran"); // plays dialogue
			story.insertD("Isn’t this where the murder took place, desu?", "Nekocchi");
			story.insertD("Hello. Are you a detective?", "Susan");
			story.insertD("No, ma’am. I’m Keto’s defence attorney, Ouran Forenz.", "Ouran");
			story.insertD("And you are?", "Nekocchi");
			story.insertD("My name’s Susan Ord.", "Susan");
			story.insertR("Susan Ord", "susanProfile", "Head of the Saiba Corp. board.", true, 9); // inserts profile in record
			story.insertD("I’m the head of the board of directors here at Saiba Corp.", "Susan"); // plays dialogue
			story.insertD("If you have any questions, I’ll be happy to help.", "Susan");
			this.addQuestion(new Question(0, "Keto", true)); // adds questions
			this.addQuestion(new Question(1, "Komuba", true));
			this.addQuestion(new Question(2, "The investigation", true));
			this.addQuestion(new Question(3, "White-Eyes Blue Dragon", false));
			flags[2] = true; // sets flag to true
		}
	}
	
	@Override
	void update() // updates location
	{
		super.update(); // updates super
		
	}
	
	@Override
	void events (int i) // activates event
	{
		if (i == 0) // chooses event
		{
			story.insertD("It spirals up and up for stories. I sort of want to climb it...", "Ouran"); // plays dialogue
		}
		if (i == 1) // chooses event
		{
			story.insertD("For people who don’t want to spend hours on the stairs.", "Ouran"); // plays dialogue
		}
		if (i == 2) // chooses event
		{
			story.insertD("The receptionist has gone home.", "Ouran"); // plays dialogue
			story.insertD("I guess it is pretty late at night for her to stay...", "Susan");
		}
		if (i == 3) // chooses event
		{
			story.insertD("Those tracks look suspicious...", "Ouran"); // plays dialogue
			story.insertR("Tracks", "tracks", "Tracks similar to those on a motorbike.", true, 8); // inserts tracks in record
			story.insertData("Tracks added to Court Record.");
			if (!flags[29]) // ensures that location is only linked once
			{
				if (flags[28] == true)
				{
					story.locales[2].linkPath(story.locales[3]); // links location
					flags[29] = true; // ensures location is linked once
				}
				else
				{
					flags[27] = true; // sets tracks to examined
				}
			}
		}
	}

	@Override
	void talk (int i) // talks with character
	{
		this.getQuestionId(i).asked=true; // sets question to asked
		if (i == 0) // chooses question
		{
			story.insertD("Keto was a good and reliable CEO.", "Susan"); // runs dialogue
			story.insertD("Sure, he had his weird card game obsession.", "Susan");
			story.insertD("But he was always focused on the business first and foremost.", "Susan");
			story.insertD("I’ll help you as much as I can.", "Susan");
			story.insertD("I only want to ensure he can get back to work as soon as possible.", "Susan");
		}
		if (i == 1) // chooses question
		{
			story.insertD("Komuba... I honestly couldn’t stand that kid.", "Susan"); // runs dialogue
			story.insertD("To tell the truth, I won’t miss him that much.", "Susan");
			story.insertD("He was always meddling around in our plans.", "Susan");
		}
		if (i == 2) // chooses question
		{
			story.insertD("The police have been meddling around here for the past hour.", "Susan"); // runs dialogue
			story.insertD("Hopefully they’ll leave soon so I can go home...", "Susan");
		}
		if (i == 3) // chooses question
		{
			story.insertD("How could he be killed by a White-Eyes Blue Dragon?", "Ouran"); // runs dialogue
			story.insertD("It appears to be Keto’s replica dragon. That’s why Keto was implicated in the case.", "Susan");
			story.insertD("I suppose you want to see the crime scene now.", "Susan");
			story.insertD("Nya... nya, nya!", "Nekocchi");
			story.insertD("...OK", "Susan");
			story.insertD("Proceed up the stairs or the elevator to the Saiba family’s apartment.", "Susan");
			story.insertD("(They have an apartment in their office? Talk about dedicated...)", "Ouran");
			if (!flags[29]) //  ensures that location is only linked once
			{
				if (flags[27] == true) // checks if other condition is fulfilled
				{
					story.locales[2].linkPath(story.locales[3]); // links path
					flags[29] = true; // ensures link happens once
				}
				else // if first condition
				{
					flags[28] = true; // sets flag to true
				}
			}
		}
	}
	private Question getQuestionId(int id) // finds question id
	{
		for (Question q: questions) { // runs through questions
			if (q.id==id) return q; // returns correct question
		}
		
		return null; // if no question found, returns null
	}
	@Override
	protected void present (RecordEntry recordEntry) // presents entry
	{
		if(recordEntry.name.equals("Ouran's Attorney's Badge")) // if entry is badge
		{
			story.insertD("I think that I am clear about you being an attorney, Mr. Forenz.", "Susan"); // plays dialogue
		}
		else if (recordEntry.name.equals("Saiba Corp. Article")) // if entry is article
		{
			story.insertD("Ah. That article.", "Susan"); // plays dialogue
			story.insertD("We have been working hard to improve conditions in our factories.", "Susan");
			story.insertD("Soon our workers will see the fruits of our labours.", "Susan");
			story.insertD("(It doesn’t seem like she has much to say...)", "Ouran");
		}
		else if (recordEntry.name.equals("White-Eyes Blue Dragon")) // if entry is dragon
		{
			story.insertD("What are you doing with that? After what happened?", "Susan"); // plays dialogue
			story.insertD("What?", "Ouran");
			story.insertD("Komuba was killed... by a White-Eyes Blue Dragon!", "Susan");
			story.insertD("OwO", "Nekocchi");
			this.unlockQuestion(3); // unlocks question
		}
	}
}
