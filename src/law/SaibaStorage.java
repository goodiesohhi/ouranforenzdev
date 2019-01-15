package law; // selects package
import java.io.IOException; // imports IOException
public class SaibaStorage extends Location { // opens class
	StoryManager story = Main.currentCase; // holds current case
	public SaibaStorage() // constructor for location
	{
		super("Saiba Storage", 68); // chooses background for location
	}
	@Override
	void enter() throws IOException // enters location
	{
		super.enter(); // enters the super
		this.addEvent(new ClickEvent(false,"storageWall", 0, 0, 400, 700, this.clickEvents, 0)); // adds click events
		this.addEvent(new ClickEvent(false,"dragonModel", 400, 100, 450, 500, this.clickEvents, 1));
		this.addEvent(new ClickEvent(false, "dragonMouth", 850, 200, 50, 35, this.clickEvents, 2));
		if(!flags[5]) // ensures that this only runs once
		{
			story.insertData("Saiba Corp. Storage"); // plays dialogue
			story.insertData("August 10");
			story.insertData("9:20 PM");
			story.insertD("That dragon...", "Ouran");
			story.insertD("It’s huge!", "Nekocchi");
			story.insertD("The dragon’s 2.5 metres tall.", "Det. Pat. Bluthund");
			story.insertD("(Now I just have to examine it...)", "Ouran");
			flags[5] = true; // sets flag to true
		}
	}
	@Override
	void update() // updates location
	{
		super.update(); // updates super
	}
	@Override
	void events (int i) // runs through events
	{
		if (i == 0) // chooses event
		{
			story.insertD("Looks industrial... stark contrast to the rest of the apartment.", "Ouran"); // plays dialogue
			
		}
		if (i == 1) // chooses event
		{
			story.insertD("That’s pretty realistic.", "Ouran"); // plays dialogue
			story.insertD("Looks like it could actually come to life.", "Ouran");
			story.insertD("My Fairilees are quaking in their boots, nya!", "Nekocchi");
			story.insertR("Dragon Model", "dragonModel", "It’s big, bulky, and heavy.", false, 14);
			story.insertData("Dragon Model added to Court Record");
			if (flags[21] == true) // checks if other requirement is fulfilled
			{
				story.insertD("Well, we’re packing up for the night.", "Det. Pat. Bluthund"); // inserts dialogue
				story.insertD("Are you good, Ouran?", "Det. Pat. Bluthund");
				story.insertD("Yeah, I think I’m ready.", "Ouran");
				story.insertD("(A dragon? How am I going to deal with that?)", "Ouran");
				story.insertD("TO BE CONTINUED", "");
				story.toCourt(); // moves to court
			} 
			else // checks for first requirement
			{
				flags[20] = true; // sets flag to true
			}
		}
		if (i == 2) // chooses event
		{
			story.insertD("What’s that in the mouth?", "Ouran"); // plays dialogue
			story.insertD("It’s a flamethrower, Mr. Forenz.", "Det. Pat. Bluthund");
			story.insertD("A flamethrower?", "Ouran");
			story.insertD("But wasn’t the victim killed by burns, desu ka?", "Nekocchi");
			story.insertD("It seems so...", "Ouran");
			story.insertR("Flamethrower", "flamethrower", "Used to kill Komuba, or so the prosecution claims...", false, 15); // adds to record
			story.insertData("Flamethrower added to Court Record");
			if (flags[20] == true) // checks if other condition is fulfilled
			{
				story.insertD("Well, we’re packing up for the night.", "Det. Pat. Bluthund"); // plays dialogue
				story.insertD("Are you good, Ouran?", "Det. Pat. Bluthund");
				story.insertD("Yeah, I think I’m ready.", "Ouran");
				story.insertD("(A dragon? How am I going to deal with that?)", "Ouran");
				story.insertD("TO BE CONTINUED", "");
				story.toCourt(); // moves to court
			}
			else // checks if this is first condition
			{
				flags[21] = true; // sets flag to true
			}
		}
	}
	@Override
	void talk (int i) // talk with character
	{
		
	}
	@Override
	protected void present(RecordEntry recordEntry) // present record entry
	{
		story.insertD("Why would I show this to the dragon?", "Ouran"); // plays dialogue
		story.insertD("Stop being sugoi baka, Ouran.", "Nekocchi");
	}
}
