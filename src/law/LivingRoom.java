package law; // selects package
import java.io.IOException; // imports IOException
public class LivingRoom extends Location{ // opens class
	StoryManager story = Main.currentCase; // sets current case
	public LivingRoom(int i) // opens constructor
	{
		super("Living Room", 66, i); // constructs background
	}
	@Override
	void enter() throws IOException // enters location
	{
		super.enter(); // uses the default location enter
		this.addEvent(new ClickEvent(false,"body", 600, 400, 80, 60, this.clickEvents, 0)); // loads click events
		this.addEvent(new ClickEvent(true,"uniform", 700, 350, 60, 50, this.clickEvents, 1));
		this.addEvent(new ClickEvent(false,"tv", 50, 200, 150, 500, this.clickEvents, 2));
		this.addEvent(new ClickEvent(false,"coffeeTable", 200, 500, 400, 100, this.clickEvents, 3));
		if (!flags[4]) // ensures that this only runs once
		{
			story.insertData("Saiba Corp. Apartment Living Room"); // plays dialogue
			story.insertData("August 10");
			story.insertData("9:12 PM");
			story.insertD("This is where the murder happened, desu!", "Nekocchi");
			story.insertD("So it seems...", "Ouran");
			story.playAni("Det. Pat. Bluthund", "bluthundWitness", 1, false); // plays animation
			story.insertD("Ouran! You’re on this case?", "Det. Pat. Bluthund"); // plays dialogue
			story.insertD("Yes. We just saw you, remember?", "Ouran");
			story.insertD("Oh. Right.", "Det. Pat. Bluthund");
			story.insertD("Well, then, take your time and examine the scene of the crime.", "Det. Pat. Bluthund");
			flags[4] = true; // sets the flag to true
			this.addQuestion(new Question(0, "The Crime", true)); // adds questions
			this.addQuestion(new Question(1, "The Scene", true));
			this.addQuestion(new Question(2, "Witnesses?", true));
			this.addQuestion(new Question(3, "Replica Dragon", true));
		}
	}
	@Override
	void update() // updates location
	{
		super.update(); // updates super
	}
	@Override
	void events (int i) // creates examine events
	{
		if (i == 0) // chooses event
		{
			story.insertD("So this is Komuba... looks kind of small for his age.", "Ouran"); // writes text
		}
		if (i == 1) // chooses event
		{
			story.insertD("Strange... this doesn’t look a bit burnt.", "Ouran"); // writes text
			story.insertD("Why did he take off his uniform?", "Ouran"); // writes text
			story.insertR("Uniform", "uniform", "This uniform wasn’t burned a mite.", false, 12); // adds to record
			story.insertData("Uniform has been added to Court Record.");
			if (flags[35] == false) // ensures location is only added once
			{
				if (flags[34]== true) // checks for linking flag
				{
					story.locales[4].linkPath(story.locales[5]); // links location
					story.insertD("Ouran! We’ve found the dragon! Follow me!", "Det. Pat. Bluthund"); // plays dialogue
					flags[35] = true; // stops location from being added again
				}
				else // checks if this is first requirement
				{
					flags[33] = true; // sets flag for first requirement to true
				}
			}
		}
		if (i == 2) // chooses event
		{
			story.insertD("I’m pretty sure 10 of my TV could fit on that screen...", "Ouran"); // plays dialogue
		}
		if (i == 3) // chooses event
		{
			story.insertD("The richer you are, the lower to the ground your coffee table is.", "Ouran"); // plays dialogue
			story.insertD("It definitely holds true here.", "Ouran");
		}
	}
	@Override
	void talk (int i) // talks with Bluthund
	{
		this.getQuestionId(i).asked=true; // sets questions asked to asked
		if (i == 0) // chooses option
		{
			story.insertD("It appears that Komuba was burnt.", "Det. Pat. Bluthund"); // plays dialogue
			story.insertD("We have his autopsy report here if you want to take a look.", "Det. Pat. Bluthund");
			story.insertR("Autopsy Report","autopsyReport", "Died due to septicaemia after severe burns", false, 13); // adds to court record
			story.insertData("Autopsy Report added to Court Record");
			if (flags[35] == false) // ensures link only happens once
			{
				if (flags[33] == true) // checks if other requirement has been completed
				{
					story.locales[4].linkPath(story.locales[5]); // links path
					story.insertD("Ouran! We’ve found the dragon! Follow me!", "Det. Pat. Bluthund"); // plays dialogue
					flags[35] = true; // ensures locations are only linked once
				}
				else // checks for first requirement
				{
					flags[34] = true; // sets flag to true
				}
			}
		}
		if (i == 1) // chooses option
		{
			story.insertD("The body does not appear to have been moved.", "Det. Pat. Bluthund"); // plays dialogue
			story.insertD("Therefore, it seems like the crime took place here.", "Det. Pat. Bluthund"); // plays dialogue
		}
		if (i == 2) // chooses option
		{
			story.insertD("As of yet, we do not have any witnesses.", "Det. Pat. Bluthund"); // plays dialogue
			story.insertD("Maybe we’ll ask around later.", "Det. Pat. Bluthund"); // plays dialogue
		}
		if (i == 3) // chooses option
		{
			story.insertD("Yeah, I heard about that.", "Det. Pat. Bluthund"); // plays dialogue
			story.insertD("We’re trying to locate the replica dragon as we speak.", "Det. Pat. Bluthund");
			story.insertD("My guess is it’ll turn up in the next half-hour.", "Det. Pat. Bluthund");
			story.insertD("Hard to move such a large model.", "Det. Pat. Bluthund");
		}
	}
	private Question getQuestionId(int id) // finds id of question asked
	{
		for (Question q: questions) { // runs through questions
			if (q.id==id) return q; // returns id
		}
		
		return null; // returns nothing if id is incorrect
	}
	@Override
	protected void present (RecordEntry recordEntry) // presents object
	{
		if(recordEntry.name.equals("Ouran's Attorney's Badge")) // if the object is the badge
		{
			story.insertD("Why do attorneys get a badge, anyways?", "Det. Pat. Bluthund"); // plays dialogue
			story.insertD("They aren’t detectives...", "Det. Pat. Bluthund");
		}
		else if (recordEntry.name.equals("White-Eyes Blue Dragon")) // if the object is the dragon card
		{
			story.insertD("It’s the dragon! You have one?", "Det. Pat. Bluthund"); // plays dialogue
			story.insertD("I’ll trade you my entire collection!", "Det. Pat. Bluthund");
			story.insertD("(Bluthund plays card games too?)", "Ouran");
		}
		else // if the object is any other object
		{
			story.insertD("I don’t think I’m authorized to talk about that.", "Det. Pat. Bluthund"); // plays dialogue
		}
	}
	
}
